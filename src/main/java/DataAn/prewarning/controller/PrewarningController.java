package DataAn.prewarning.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import DataAn.common.controller.BaseController;
import DataAn.common.dao.Pager;
import DataAn.common.pageModel.EasyuiDataGridJson;
import DataAn.common.pageModel.JsonMessage;
import DataAn.prewarning.domain.WarningValue;
import DataAn.prewarning.dto.ErrorValueDTO;
import DataAn.prewarning.dto.QueryLogDTO;
import DataAn.prewarning.dto.QueryValueDTO;
import DataAn.prewarning.dto.SelectOptionDTO;
import DataAn.prewarning.dto.WarnValueDTO;
import DataAn.prewarning.service.IPrewarningService;

@Controller
@RequestMapping(value = "/admin/prewarning")
public class PrewarningController extends BaseController {

	@Resource
	private IPrewarningService prewarningService;

	@RequestMapping("logIndex")
	public String logIndex(Model model, HttpServletRequest request, HttpServletResponse response) {
		String hadRead = request.getParameter("hadRead");
		model.addAttribute("hadRead", hadRead);
		return "admin/prewarning/logIndex";
	}

	@RequestMapping("errorvalueIndex")
	public String errorvalueIndex() {
		return "admin/prewarning/errorvalueIndex";
	}

	@RequestMapping("warnvalueIndex")
	public String warnvalueIndex() {
		return "admin/prewarning/warnvalueIndex";
	}

	@RequestMapping(value = "/getParamList")
	@ResponseBody
	public SelectOptionDTO getParamList(HttpServletRequest request, String parameterType) {
		SelectOptionDTO selectOptionDTO = null;
		try {
			selectOptionDTO = prewarningService.getSelectOption(parameterType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectOptionDTO;
	}

	// 获取参数列表
	@RequestMapping(value = "/getValueList", method = RequestMethod.POST)
	@ResponseBody
	public EasyuiDataGridJson getValueList(int page, int rows, WebRequest request) {
		EasyuiDataGridJson json = new EasyuiDataGridJson();
		String series = request.getParameter("series");
		String parameter = request.getParameter("parameter");
		String parameterType = request.getParameter("parameterType");
		String warningType = request.getParameter("warningType");
		System.out.println("come in getValueList...");
		System.out.println("pageIndex: " + page);
		System.out.println("pageSize: " + rows);
		System.out.println("series: " + series);
		System.out.println("parameter: " + parameter);
		System.out.println("parameterType: " + parameterType);
		System.out.println("warningType: " + warningType);
		Pager<QueryValueDTO> pager = null;
		try {
			pager = prewarningService.pageQueryWarningValue(page, rows, series, parameter, parameterType, warningType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pager != null) {
			json.setTotal(pager.getTotalCount());
			json.setRows(pager.getDatas());
		} else {
			System.out.println("pager is null");
		}
		return json;
	}

	// 获取预警列表
	@RequestMapping(value = "/getLogList", method = RequestMethod.POST)
	@ResponseBody
	public EasyuiDataGridJson getLogList(int page, int rows, WebRequest request) {
		EasyuiDataGridJson json = new EasyuiDataGridJson();
		String series = request.getParameter("series");
		// String parameter = request.getParameter("parameter");
		String parameterType = request.getParameter("parameterType");
		String warningType = request.getParameter("warningType");
		String createdatetimeStart = request.getParameter("createdatetimeStart");
		String createdatetimeEnd = request.getParameter("createdatetimeEnd");
		String hadRead = request.getParameter("hadRead");
		System.out.println("come in getLogList...");
		System.out.println("pageIndex: " + page);
		System.out.println("pageSize: " + rows);
		System.out.println("series: " + series);
		System.out.println("parameterType: " + parameterType);
		System.out.println("createdatetimeStart: " + createdatetimeStart);
		System.out.println("createdatetimeEnd: " + createdatetimeEnd);
		System.out.println("warningType: " + warningType);
		System.out.println("hadRead: " + hadRead);
		Pager<QueryLogDTO> pager = null;
		try {
			pager = prewarningService.pageQueryWarningLog(page, rows, series, parameterType, createdatetimeStart,
					createdatetimeEnd, warningType, hadRead);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pager != null) {
			json.setTotal(pager.getTotalCount());
			json.setRows(pager.getDatas());
		} else {
			System.out.println("pager is null");
		}
		request.setAttribute("warnCount", 0, RequestAttributes.SCOPE_SESSION);
		return json;
	}

	// 创建特殊工况参数
	@RequestMapping(value = "/createWarnValue")
	@ResponseBody
	public JsonMessage createWarnValue(WarnValueDTO warnValue, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("come in createValue ");
		System.out.println(warnValue);
		System.out.println(warnValue.getMaxVal());
		JsonMessage jsonMsg = new JsonMessage();
		try {
			boolean falg = prewarningService.cherkWarningValue(warnValue.getSeries().toString(),
					warnValue.getParameter(), warnValue.getParameterType(), "0");
			if (falg) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("参数已存在！");
				jsonMsg.setObj("参数已存在！");
				return jsonMsg;
			}
			prewarningService.addWarnValue(warnValue);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("新增参数成功！");
			return jsonMsg;
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("新增参数出错！");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
	}

	// 创建异常参数
	@RequestMapping(value = "/createErrorValue")
	@ResponseBody
	public JsonMessage createErrorValue(ErrorValueDTO errorValue, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("come in createValue ");
		System.out.println(errorValue);
		JsonMessage jsonMsg = new JsonMessage();
		try {
			boolean falg = prewarningService.cherkWarningValue(errorValue.getSeries().toString(),
					errorValue.getParameter(), errorValue.getParameterType(), "1");
			if (falg) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("参数已存在！");
				jsonMsg.setObj("参数已存在！");
				return jsonMsg;
			}
			prewarningService.addErrorValue(errorValue);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("新增参数成功！");
			return jsonMsg;
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("新增参数出错！");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
	}

	// 返回编辑参数数据
	@RequestMapping(value = "/getValueById")
	@ResponseBody
	public WarningValue getValueById(long valueId) {
		WarningValue warningValue = null;
		try {
			warningValue = prewarningService.getWarningValueById(valueId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return warningValue;
	}

	// 编辑特殊工况参数
	@RequestMapping(value = "/editWarnValue")
	@ResponseBody
	public JsonMessage editWarnValue(WarnValueDTO warnValue, HttpServletRequest request, HttpServletResponse response) {
		JsonMessage jsonMsg = new JsonMessage();
		try {
			prewarningService.updateWarnValue(warnValue);
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("编辑参数失败！");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("编辑参数成功！");
		return jsonMsg;
	}

	// 编辑异常参数
	@RequestMapping(value = "/editErrorValue")
	@ResponseBody
	public JsonMessage editErrorValue(ErrorValueDTO errorValue, HttpServletRequest request,
			HttpServletResponse response) {
		JsonMessage jsonMsg = new JsonMessage();
		try {
			prewarningService.updateErrorValue(errorValue);
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("编辑参数失败！");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("编辑参数成功！");
		return jsonMsg;
	}

	// 批量删除参数
	@RequestMapping(value = "/deleteValue")
	@ResponseBody
	public JsonMessage deleteValue(HttpServletRequest request, String valueIds) {
		System.out.println("come in deleteValue");
		System.out.println(valueIds);
		String[] valueIdArray = valueIds.split(",");
		JsonMessage jsonMsg = new JsonMessage();
		try {
			for (String valueId : valueIdArray) {
				prewarningService.deleteWarningValue(Long.parseLong(valueId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("删除参数失败!");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("删除参数成功!");
		return jsonMsg;
	}

	// 批量删除预警
	@RequestMapping(value = "/deleteLog")
	@ResponseBody
	public JsonMessage deleteLog(HttpServletRequest request, String logIds) {
		System.out.println("come in deleteLog");
		System.out.println(logIds);
		String[] logIdArray = logIds.split(",");
		JsonMessage jsonMsg = new JsonMessage();
		try {
			for (String logId : logIdArray) {
				prewarningService.deleteWarningLog(Long.parseLong(logId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("删除预警失败!");
			jsonMsg.setObj(e.getMessage());
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("删除预警成功!");
		return jsonMsg;
	}

}
