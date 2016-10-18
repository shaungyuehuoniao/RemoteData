package DataAn.reportManager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import DataAn.common.dao.Pager;
import DataAn.galaxyManager.dao.ISeriesDao;
import DataAn.galaxyManager.dao.IStarDao;
import DataAn.galaxyManager.domain.Series;
import DataAn.galaxyManager.domain.Star;
import DataAn.reportManager.dao.IStarParamDao;
import DataAn.reportManager.domain.StarParam;
import DataAn.reportManager.dto.StarParamDto;
import DataAn.reportManager.service.IStarParamService;

@Service
public class StarParamServiceImpl implements IStarParamService {

	@Resource
	private IStarParamDao starParamDao;
	
	@Resource
	private ISeriesDao seriesDao;
	
	@Resource
	private IStarDao starDao;
	
	@Override
	public Pager<StarParamDto> getStarParamList(int pageIndex, int pageSize, String series, String star, String parameterType) {

		if(pageIndex == 0){
			pageIndex = 1;
		}
		List<StarParamDto>  starParamModelList = new ArrayList<StarParamDto>();
		Pager<StarParam> paramPager = starParamDao.selectByOption(pageIndex, pageSize, series, 
				star, parameterType);
		List<StarParam> userList = paramPager.getDatas();
		for (StarParam starParam : userList) {
			starParamModelList.add(pojoToDto(starParam));
		}
		Pager<StarParamDto> pager = new Pager<StarParamDto>(pageIndex, pageSize, paramPager.getTotalCount(), starParamModelList);
		return pager;			
	}
	
	private StarParamDto pojoToDto(StarParam starParam) {
		StarParamDto starParamDto = new StarParamDto();
		starParamDto.setId(starParam.getId());
		starParamDto.setParamCode(starParam.getParamCode());
		starParamDto.setParamName(starParam.getParamName());
		starParamDto.setParameterType(starParam.getParameterType());
		starParamDto.setSeries(getSeriesName(starParam.getSeries()));
		starParamDto.setStar(getStarName(starParam.getStar()));
		starParamDto.setCreater(starParam.getCreater());
		starParamDto.setCreateDate(starParam.getCreateDate());
		return starParamDto;
	}

	private String getStarName(String starId) {
		return starDao.getStarName(starId);
	}

	private String getSeriesName(String seriesId) {
		return seriesDao.getSeriesName(seriesId);
	}

	@Override
	public void save(StarParamDto starParamDto) {
		StarParam starParam = new StarParam();
		starParam.setCreater(starParamDto.getCreater());
		starParam.setSeries(starParamDto.getSeries());
		starParam.setStar(starParamDto.getStar());
		starParam.setParameterType(starParamDto.getParameterType());
		starParam.setParamCode(starParamDto.getParamCode());
		starParam.setParamName(starParamDto.getParamName());
		starParam.setCreateDate(new Date());
		starParamDao.add(starParam);
	}

	@Override
	public boolean cherkStarParam(StarParamDto starParamDto) {
		return starParamDao.cherkStarParam(starParamDto);
	}

	@Override
	public void update(StarParamDto starParamDto) {
		
		StarParam starParam = starParamDao.get(starParamDto.getId());
		if (StringUtils.isNotBlank(starParamDto.getSeries())) {
			starParam.setSeries(starParamDto.getSeries());
		}
		if (StringUtils.isNotBlank(starParamDto.getStar())) {
			starParam.setStar(starParamDto.getStar());
		}
		if (StringUtils.isNotBlank(starParamDto.getParameterType())) {
			starParam.setParameterType(starParamDto.getParameterType());
		}
		if (StringUtils.isNotBlank(starParamDto.getParamCode())) {
			starParam.setParamCode(starParamDto.getParamCode());
		}
		if (StringUtils.isNotBlank(starParamDto.getParamName())) {
			starParam.setParamName(starParamDto.getParamName());
		}
		starParam.setCreater(starParamDto.getCreater());
		starParam.setCreateDate(new Date());
		starParamDao.update(starParam);
	}

	@Override
	public void delete(String[] starParamIdArray) {
		for (String starParamId : starParamIdArray) {
			starParamDao.delete(Long.parseLong(starParamId));
		}
	}

	@Override
	public List<Series> getSeriesList() { 
		return seriesDao.list("from Series s");
	}

	@Override
	public List<Star> getStarList(long seriesId) {
		return starDao.getStarList(seriesId);
	}
}
