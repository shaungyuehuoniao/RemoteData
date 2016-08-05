package DataAn.galaxyManager.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import DataAn.common.pageModel.JsonMessage;
import DataAn.galaxyManager.dto.StarDto;
import DataAn.galaxyManager.service.IStarService;

/**
* Title: StarController
* @Description: 星信息的Contrller
* @author  Shewp
* @date 2016年7月28日
*/
@Controller
@RequestMapping("/admin/star")
public class StarController {

	@Resource
	private IStarService starService;
	
	@RequestMapping("/getStars")
	@ResponseBody
	public List<StarDto> getStarsBySeriesId(long seriesId){
		List<StarDto> list = starService.getStarsBySeriesId(seriesId);
		return list;
	}
	
	@RequestMapping(value="/createStar", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage createStar(@RequestParam(value = "seriesId", required = true) long seriesId,
								  @RequestParam(value = "name", required = true) String name,
								  @RequestParam(value = "beginDate", required = true) String beginDate,
								  @RequestParam(value = "description", required = false) String description){
		JsonMessage jsonMsg = new JsonMessage();
		try {
//			System.out.println("come in createStar..");
//			System.out.println("seriesId: " + seriesId);
//			System.out.println("name: " + name);
//			System.out.println("beginDate: " + beginDate);
//			System.out.println("description: " + description);
//			System.out.println();
			StarDto starDto = new StarDto();
			starDto.setSeriesId(seriesId);
			starDto.setName(name);
			starDto.setDescription(description);
			starDto.setBeginDate(beginDate);
			starService.saveStar(starDto);
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("创建星出错！");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("创建星成功！");
	    return jsonMsg;
	}
	
	@RequestMapping(value="/getStarForm", method = RequestMethod.POST)
	@ResponseBody
	public StarDto getStarForm(long starId){
		
		return starService.getStarDto(starId);
	}
	
	@RequestMapping(value="/editStar", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage editStar(@RequestParam(value = "id", required = true) long id,
								@RequestParam(value = "name", required = true) String name,
								@RequestParam(value = "beginDate", required = true) String beginDate,
								@RequestParam(value = "description", required = false) String description){
		JsonMessage jsonMsg = new JsonMessage();
		try {
//			System.out.println("come in editStar..");
//			System.out.println("id: " + id);
//			System.out.println("name: " + name);
//			System.out.println("beginDate: " + beginDate);
//			System.out.println("description: " + description);
//			System.out.println();
			StarDto starDto = new StarDto();
			starDto.setId(id);
			starDto.setName(name);
			starDto.setDescription(description);
			starDto.setBeginDate(beginDate);
			starService.updateStar(starDto);
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("编辑星出错！");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("编辑星成功！");
	    return jsonMsg;
	}
	@RequestMapping(value="/deleteStar", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage deleteStar(@RequestParam(value = "starId", required = true) long starId){
		JsonMessage jsonMsg = new JsonMessage();
		try {
//			System.out.println("come in deleteStar..");
//			System.out.println("starId: " + starId);
//			System.out.println();
			starService.deleteStar(starId);
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("删除星出错！");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("删除星成功！");
	    return jsonMsg;
	}
}
