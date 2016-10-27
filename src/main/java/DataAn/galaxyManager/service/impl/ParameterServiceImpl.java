package DataAn.galaxyManager.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DataAn.common.dao.Pager;
import DataAn.galaxyManager.dao.IParameterDao;
import DataAn.galaxyManager.domain.Parameter;
import DataAn.galaxyManager.dto.ParameterDto;
import DataAn.galaxyManager.option.J9Series_Star_ParameterType;
import DataAn.galaxyManager.service.IJ9Series_Star_Service;
import DataAn.galaxyManager.service.IParameterService;


@Service("parameterService")
public class ParameterServiceImpl implements IParameterService{

	@Resource
	private IParameterDao parameterDao;
	
	@Resource
	private IJ9Series_Star_Service j9Series_Star_Service;
	
	private ConcurrentHashMap<String,String> parameterList_allZh_and_en = new ConcurrentHashMap<String,String>();
	
	private ConcurrentHashMap<String,String> parameterList_en_and_allZh = new ConcurrentHashMap<String,String>();
	
	@Override
	@Transactional
	public Parameter saveOne(String series, String star, String paramType, String param_zh) {
		Parameter param = parameterDao.selectBySeriesAndName(series, param_zh.trim());
		if(param == null){
			param = new Parameter();
			if(param_zh.equals("接收地方时")){ // || param_zh.equals("时间")
				param.setSeries(series);
				param.setStar(star);
				param.setParameterType(paramType);
				param.setFullName(param_zh);
				param.setCode("datetime");
			}else{
				String item = param_zh.trim();
				String num = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
				String code = "sequence_" + num;
				param.setSeries(series);
				param.setStar(star);
				param.setParameterType(paramType);
				param.setFullName(param_zh);
				param.setSimplyName(param_zh.split(":")[1]);
				param.setCode(code);
			}
//			parameterList_allZh_and_en.put(param.getName(), param.getCode());
//			parameterList_en_and_allZh.put(param.getCode(), param.getName());
			param = parameterDao.add(param);
		}
		return param;
	}
	

	@Override
	@Transactional
	public void saveMany(String series, String star, String paramType, String param_zhs) {
		Set<String> paramSet = new HashSet<String>();
		String[] items = param_zhs.split(",");
		for (String item : items) {
			if(!item.equals("时间") && !item.equals("接收地方时")){
				paramSet.add(item);
			}
		}
		for (String param_zh : paramSet) {
			this.saveOne(series, star, paramType, param_zh);
		}
	}

	@Override
	public List<ParameterDto> getParameterList(String series, String star, String paramType) {
		List<ParameterDto> paramDtoList = new ArrayList<ParameterDto>();
		List<Parameter> paramList = parameterDao.selectBySeriesAndParameterType(series, paramType);
		if(paramList != null && paramList.size() > 0){
			for (Parameter parameter : paramList) {
				paramDtoList.add(this.pojoToDto(parameter));
			}
		}
		return paramDtoList;
	}

	
	@Override
	public Pager<ParameterDto> getParameterList(int pageIndex, int pageSize) {
		if(pageIndex == 0){
			pageIndex = 1;
		}
		List<ParameterDto> paramDtoList = new ArrayList<ParameterDto>();
		Pager<Parameter> paramPager = parameterDao.selectByPager(pageIndex, pageSize);
		if(paramPager != null){
			List<Parameter> paramList = paramPager.getDatas();
			if(paramList != null && paramList.size() > 0){
				for (Parameter param : paramList) {
					paramDtoList.add(this.pojoToDto(param));
				}
			}			
		}
		Pager<ParameterDto> pager = new Pager<ParameterDto>(pageIndex, pageSize, paramPager.getTotalCount(), paramDtoList);
		return pager;
	}

	private ParameterDto pojoToDto(Parameter param) {
		ParameterDto paramDto = new ParameterDto();
		paramDto.setId(param.getId());
		paramDto.setCode(param.getCode());
		paramDto.setFullName(param.getFullName());
		paramDto.setSimplyName(param.getSimplyName());
		paramDto.setSeries(param.getSeries());
		paramDto.setStar(param.getStar());
		paramDto.setParameterType(param.getParameterType());
		return paramDto;
	}

	@Override
	public String getParameter_en_by_allZh(String series, String star,
			 String paramType, String param_zh) {
		//先从Map集合里面查找
		String param_en = parameterList_allZh_and_en.get(param_zh);
		if(param_en == null){
			//Map集合里面没有再从数据库中查找
			Parameter param = parameterDao.selectBySeriesAndName(series, param_zh);
			if(param == null){
				//数据库中没有此集合
				param = this.saveOne(series, star,paramType, param_zh);
			}
			param_en = param.getCode();
			parameterList_allZh_and_en.put(param_zh, param_en);
		}
		return param_en;
	}

	@Override
	public String getParameter_allZh_by_en(String series, String star,
			 String paramType, String param_en) {
		//先从Map集合里面查找
		String param_zh = parameterList_en_and_allZh.get(param_en);
		if(param_zh == null || param_zh.equals("")){
			//Map集合里面没有再从数据库中查找
			Parameter param = parameterDao.selectBySeriesAndCode(series, param_en);
			if(param != null){
				parameterList_en_and_allZh.put(param.getCode(), param.getFullName());
				param_zh = param.getFullName();
			}
		}
		return param_zh;
	}


	@Override
	public String getParameter_dataType_by_en(String series, String star,
			String paramType, String param_en) {
		String param_zh = this.getParameter_allZh_by_en(series, star, paramType, param_en);
		if(StringUtils.isNotBlank(param_zh)){
			if(!param_zh.equals("时间") && !param_zh.equals("接收地方时")){
				String param = param_zh.split(":")[1];
				List<String> typeList = J9Series_Star_ParameterType.getFlywheelTypeOnDataType();
				for (String type : typeList) {
					if(param.indexOf(type) > -1){
						return type;
					}
				}
			}
		}
		return null;
	}


	@Override
	public String getParameter_paramTypeName_by_en(String series, String star,
			String paramType, String param_en) {
		String param_zh = this.getParameter_allZh_by_en(series, star, paramType, param_en);
		if(StringUtils.isNotBlank(param_zh)){
			if(!param_zh.equals("时间") && !param_zh.equals("接收地方时")){
				String param = param_zh.split(":")[1];
				List<String> typeList = J9Series_Star_ParameterType.getFlywheelTypeOnParamTypeName();
				for (String type : typeList) {
					if(param.indexOf(type) > -1){
						return type;
					}
				}
			}
		}
		return null;
	}

}
