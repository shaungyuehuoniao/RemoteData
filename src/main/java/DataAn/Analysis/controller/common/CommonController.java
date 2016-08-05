package DataAn.Analysis.controller.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import DataAn.Analysis.dto.ConstraintDto;
import DataAn.fileSystem.option.FlyWheelDataType;
import DataAn.fileSystem.service.IFlyWheelService;
import DataAn.fileSystem.service.IJ9Series_Star_Service;
import DataAn.mongo.db.MongodbUtil;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DataAn.Analysis.dto.AllJsonData;
import DataAn.Analysis.dto.GroupMenu;
import DataAn.Analysis.dto.ParamGroup;
import DataAn.Analysis.dto.SingleParamDto;
import DataAn.Util.EhCache;
import DataAn.Util.JsonStringToObj;


@Controller
public class CommonController {

	@Resource
	private IJ9Series_Star_Service j9Series_Star_Service;
	
	@RequestMapping(value = "/Index", method = { RequestMethod.GET })
	public String goIndex(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}
	
	@RequestMapping(value = "/getConstraint", method = RequestMethod.GET)
	@ResponseBody
	public List<ConstraintDto> getConstraint() throws Exception{
		
		return j9Series_Star_Service.getFlyWheelParameterList();
	}
	
	
	@RequestMapping(value = "/showPanel", method = { RequestMethod.POST})
	public void showPanel(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="JsonG",required = true) String JsonG) throws Exception {	
		Map<String, Class<SingleParamDto>> classMap = new HashMap<String, Class<SingleParamDto>>();
		classMap.put("secectRow", SingleParamDto.class);
		List<ParamGroup> pgs =JsonStringToObj.jsonArrayToListObject(JsonG,ParamGroup.class,classMap);
		EhCache ehCache = new EhCache(); 
		ehCache.addToCache("AllJsonData", pgs);		
	}
	

	@RequestMapping(value = "/showPanel", method = { RequestMethod.GET})
	public ModelAndView showGraphic(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		EhCache ehCache = new EhCache(); 
		@SuppressWarnings("unchecked")
		List<ParamGroup> lPs = (List<ParamGroup>) ehCache.getCacheElement("AllJsonData");
		ModelAndView mv = new ModelAndView("/secondStyle/showGraphicByGroup");
		mv.addObject("lPs", lPs);
		return mv;
		}
	

	
	@RequestMapping(value = "/getDate", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getDate(
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
			MongodbUtil mg = MongodbUtil.getInstance();
			List<String> result = mg.getDateList("tesx");
			return result;
		}
	
	
	@RequestMapping(value = "/getMenus", method = RequestMethod.GET)
	@ResponseBody
	public List<GroupMenu> getMenus(
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		EhCache ehCache = new EhCache(); 
		@SuppressWarnings("unchecked")
		List<ParamGroup> lPs = (List<ParamGroup>) ehCache.getCacheElement("AllJsonData");
		List<GroupMenu> lgm = new ArrayList<GroupMenu>();
		for(ParamGroup  pg :lPs){
//			String text="";
//			List<SingleParamDto> spds =  pg.getSecectRow();
//			for(SingleParamDto sd :spds){
//				text+=sd.getName();
//			}
			GroupMenu gm = new GroupMenu();
			gm.setId(pg.getId()+"");
			gm.setText((pg.getId()+1)+"组");
			gm.setIcon("icon-glass");
			gm.setUrl("/DataRemote/showGraphic/"+pg.getId());
			lgm.add(gm);
		}
		return lgm;
	}
	
	
	@RequestMapping(value = "/showGraphic/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showGraphic(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("id") Integer id
			) throws Exception{
		EhCache ehCache = new EhCache(); 
		@SuppressWarnings("unchecked")
		List<ParamGroup> lPs = (List<ParamGroup>) ehCache.getCacheElement("AllJsonData");
		List<String> params = new ArrayList<String>();
		ModelAndView mv = new ModelAndView("/secondStyle/graphicShow");
		for(ParamGroup  pg :lPs){		
			if(pg.getId()==id){
				List<SingleParamDto> spds = pg.getSecectRow();
				for(SingleParamDto spd : spds){
					params.add(FlyWheelDataType.getFlyWheelDataTypeByZh2(spd.getName()).getName());
				}	
				mv.addObject("params", params);
			}
		}
		return mv;
	}
		
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	@ResponseBody
	public List<Float> getData(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="filename",required = true) String filename
			) throws Exception{
		MongodbUtil mg = MongodbUtil.getInstance();
		List<Float> result = mg.findAllByTie(filename);
		return result ;				
	}
	
	
	@RequestMapping(value = "/showtab", method = RequestMethod.GET)
	public String showtab(
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		return "DataAnalysis" ;				
	}
}
