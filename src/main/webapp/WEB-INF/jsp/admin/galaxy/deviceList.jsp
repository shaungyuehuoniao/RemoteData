<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<jsp:include page="/WEB-INF/jsp/inc/include-easyUI.jsp"></jsp:include>
    
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/content/sweetalert/dist/sweetalert.css">
	<script src="${pageContext.request.contextPath}/static/content/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/all.css" type="text/css" />
	
	<!--     <link rel="stylesheet" href="${pageContext.request.contextPath}/static/content/bootstrapValidator/vendor/bootstrap/css/bootstrap.css"/> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/content/bootstrapValidator/dist/css/bootstrapValidator.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/content/bootstrapValidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/content/bootstrapValidator/dist/js/bootstrapValidator.js"></script>
    
	<script src="${pageContext.request.contextPath}/static/content/js/outlook2.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/content/js/validDate.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/content/jquery-easyui-datagridview/datagrid-detailview.js"></script>
  	<!-- 时间选择器 -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/content/jeDate/jedate/skin/jedate.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/content/jeDate/jedate/jedate.js"></script>
    
    <!-- 时间选择器 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/content/jQueryCalendar/calendar.css">
	<script src="${pageContext.request.contextPath}/static/content/jQueryCalendar/calendar.js"></script>   
    
  <style type="text/css">

.glyphicon {
    position: relative;
    top: -23px;
    padding-right: 10px;
    display: inline-block;
    font-family: 'Glyphicons Halflings';
    -webkit-font-smoothing: antialiased;
    font-style: normal;
    font-weight: normal;
    line-height: 1;
    float: right;
}
.help-block {
    display: block;
    margin-top: 10px;
    margin-bottom: 0px;
    color: #737373;
}
.form-horizontal {
    margin-bottom: 0px;
}
</style>
  <script type="text/javascript">
  	$(function(){
  		//左菜单栏
		$("#galaxymanage-img").attr("src","${pageContext.request.contextPath}/static/new/img/images/a_82.png");
		$("#galaxymanage-text").css("color","#5d90d6");
  		
  		$('#addDeviceForm').bootstrapValidator({
          message: 'This value is not valid',
          feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
        	  deviceName: {
                  message: '设备名称不能为空',
                  validators: {
                      notEmpty: {
                          message: '设备名称不能为空'
                      }
                  }
              }
          }
      });
  	  $('#editDeviceForm').bootstrapValidator({
          message: 'This value is not valid',
          feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
        	  deviceName: {
                  message: '设备名称不能为空',
                  validators: {
                      notEmpty: {
                          message: '设备名称不能为空'
                      }
                  }
              }
          }
      });
	  	$('#stopDeviceForm').bootstrapValidator({
	        message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	endDate: {
	                message: '运行结束时间不能为空',
	                validators: {
	                    notEmpty: {
	                        message: '运行结束时间不能为空'
	                    }
	                }
	            },
	            date: {
                    format: 'YYYY-MM-DD',
                    message: '日期格式不对'
                }
	        }
	    });
	  	$('#addDeviceModal').on('hide.bs.modal', function () {
			$('#addDeviceForm').data('bootstrapValidator').resetForm(true);
		});
		$('#editDeviceModal').on('hide.bs.modal', function () {
			$('#editDeviceForm').data('bootstrapValidator').resetForm(true);
		});
		$('#stopDeviceModal').on('hide.bs.modal', function () {
			$('#stopDeviceForm').data('bootstrapValidator').resetForm(true);
		});
  	});
  </script>  
  </head>
  
  <body>
    <div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>
			<ul class="breadcrumb" style="margin-top: 10px;">
				<li>
					<img src="${pageContext.request.contextPath}/static/imgs/DataImport/home.png" style="margin-bottom: 3px;">
					<span>星系管理</span>
				</li>
				<li class="active">${nowSeries}系列${nowStar}星的设备列表</li>
			</ul><!--  .breadcrumb -->
		</div>
		<div class="page-content">
<!-- 		<input type="text" name="endDate" id="edit-device-endDate1" placeholder="yyyy-MM-dd" /> -->
			<table id="deviceTypeList" fit="false" border="false" height="450px">
				
			</table>
			<!-- 添加一个设备 -->
			<div class="modal fade" id="addDeviceModal" tabindex="-1"
				role="dialog" aria-labelledby="addDeviceModalLabel">
				<div class="modal-dialog" role="document" style="margin:55px 30%">
					<div class="modal-content">
						<form id="addDeviceForm" class="form-horizontal" role="form">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close" id="close_addDevice">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="addDeviceModalLabel">添加设备</h4>
							</div>
							<div class="modal-body">
								<input type="hidden" name="datagridId" id="add-device-datagridId"/>
								<input type="hidden" name="deviceType" id="add-device-deviceType"/>
								<input type="hidden" name="seriersId" id="add-device-seriesId"/>
								<input type="hidden" name="starId" id="add-device-starId"/>
								
								<div class="space-4"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="add-device-name"> 设备名称:</label>
									<div class="col-sm-8">
										<input type="text" name="deviceName" id="add-device-name" placeholder="设备名称" class="form-control" />
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<div class="col-lg-7 col-lg-offset-3">
									<button type="button" class="subbutton_1" id="submit_addDevice">确定</button>
									<button type="button" class="cancelbutton_1" data-dismiss="modal" id="reset_addDevice">关闭</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 编辑一个设备 -->
			<div class="modal fade" id="editDeviceModal" tabindex="-1" role="dialog" aria-labelledby="editDeviceModalLabel">
				<div class="modal-dialog" role="document" style="margin:150px 450px">
					<div class="modal-content">
						<form id="editDeviceForm" class="form-horizontal" role="form">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close" id="close_editDevice">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="editDeviceModalLabel">编辑设备</h4>
							</div>
							<div class="modal-body">
								<input type="hidden" name="datagridId" id="edit-device-datagridId"/>
								<input type="hidden" name="deviceId" id="edit-device-deviceId"/>
								<div class="space-4"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="edit-device-name"> 设备名称:</label>
									<div class="col-sm-8">
										<input type="text" name="deviceName" id="edit-device-name" placeholder="设备名称" class="form-control" />
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<div class="col-lg-7 col-lg-offset-3">
									<button type="submit" class="subbutton_1" id="submit_editDevice">确定</button>
									<button type="button" class="cancelbutton_1" data-dismiss="modal" id="reset_editDevice">关闭</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
				<!-- 停止一个设备 -->
			<div class="modal fade" id="stopDeviceModal" tabindex="-1" role="dialog" aria-labelledby="stopDeviceModalLabel">
				<div class="modal-dialog" role="document" style="margin:150px 450px">
					<div class="modal-content">
						<form id="stopDeviceForm" class="form-horizontal" role="form">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close" id="close_stopDevice">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="stopDeviceModalLabel">编辑设备</h4>
							</div>
							<div class="modal-body">
								<input type="hidden" name="datagridId" id="stop-device-datagridId"/>
								<input type="hidden" name="deviceId" id="stop-device-deviceId"/>
								<div class="space-4"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="stop-device-endDate"> 运行结束时间:</label>
									<div class="col-sm-8">
										<input type="text" name="endDate" id="stop-device-endDate" placeholder="yyyy-MM-dd" class="form-control" />
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<div class="col-lg-7 col-lg-offset-3">
									<button type="submit" class="subbutton_1" id="submit_stopDevice">确定</button>
									<button type="button" class="cancelbutton_1" data-dismiss="modal" id="reset_stopDevice">关闭</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
	</div><!-- /.main-content -->
<script type="text/javascript">
jeDate({
	dateCell:"#stop-device-endDate",//直接显示日期层的容器，可以是ID  CLASS
	format:"YYYY-MM-DD",//日期格式
	isinitVal:false, //是否初始化时间
	festival:false, //是否显示节日
	maxDate:jeDate.now(0), //设定最大日期为当前日期
	zIndex:2000, 
});
$("#stop-device-endDate").keypress(function(){
	   return false;
});	
var deviceTypeGrid;
var nowSeries = "${nowSeries}";
var nowStar = "${nowStar}";
var nowSeriesId = "${nowSeriesId}";
var nowStarId = "${nowStarId}";
$(function() {
	deviceTypeGrid = $('#deviceTypeList').datagrid({
		view : detailview,
		url: '${pageContext.request.contextPath}/admin/device/getDeviceTypePager?series='+ nowSeriesId +'&star='+ nowStarId,
		rownumbers: true,
		fitColumns:true,
		idField: 'deviceTypeId',//'deviceTypeId',
		toolbar : '#toolbar',
		pageSize: 10,
		pagination: true,
		pageList: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
        columns: [[{
            title: 'ID',
            field: 'deviceTypeId',
            width: 100,
        },{
            field: 'deviceName',
            title: '设备类型名称',
            width: 100,
        }, {
            field: 'deviceCode',
            title: '设备类型码',
            width: 100
        },{
			field : 'runDays',
			title : '累计设备工作时间(天)',
			width : 100
		}
        ]],
		onLoadError:function(data){
			$.messager.alert("信息", "暂无数据信息", "error");
		},	
		detailFormatter : function(index, row) {
			return '<div><table id="ddv-' + index + '"></table></div>';
		},
		onExpandRow : function(index, row) {
			var seriesCode = row.code;
			var subgridId = 'ddv-' + index;
			$('#' + subgridId).datagrid({
						url : '${pageContext.request.contextPath}/admin/device/getDevicesByParam?deviceType='+ row.deviceTypeId +'&series='+ nowSeriesId +'&star='+ nowStarId,
						fitColumns : true,
						rownumbers : true,
						singleSelect : true,
						loadMsg : '正在载入设备列表，请稍后...',
						height : 'auto',
						toolbar : [ {
							text : '创建',
							iconCls : 'icon-add',
							handler : function() {
									createDevice(subgridId,row.deviceTypeId);
								}
							}],
						columns : [ [
								{
								    title: 'ID',
								    field: 'deviceId',
								    width: 50,
								},
								{
									field : 'deviceName',
									title : '设备名称',
									width : 50
								},
								{
									field : 'startDate',
									title : '开始运行时间',
									width : 80
								},
								{
									field : 'endDate',
									title : '结束运行时间',
									width : 80
								},
								{
									field : 'runDays',
									title : '累计工作时间(天)',
									width : 80
								},
								{
									field : 'operation',
									title : '操作选项',
									align : 'center',
									width : 200,
									formatter : function(value,row,index) {
										var editStr = "<a class=\"l-btn l-btn-plain\" href=\"javascript:editDevice('"
											+ subgridId
											+ "','"
											+ row.deviceId
											+ "')\" style=\"float: left;\"><span class=\"l-btn-left\" style=\"margin:0px 20px;\" ><span class=\"l-btn-text icon-edit\" style=\"/*padding-left: 60px;*/\">编辑</span></span></a>";
										var delStr = "<a class=\"l-btn l-btn-plain\" href=\"javascript:deleteDevice('"
											+ subgridId
											+ "','"
											+ row.deviceId
											+ "')\" style=\"float: left;\"><span class=\"l-btn-left\" style=\"margin:0px 20px;\" ><span class=\"l-btn-text icon-remove\" style=\"/*padding-left: 80px;*/\">删除</span></span></a>";
										if(row.endDate==null){
											var stopStr = "<a class=\"l-btn l-btn-plain\" href=\"javascript:stopDevice('"
												+ subgridId
												+ "','"
												+ row.deviceId
												+ "')\" style=\"float: center;\"><span class=\"l-btn-left\" style=\"margin:0px 20px;\" ><span class=\"l-btn-text icon-stop\" style=\"/*padding-left: 60px;*/\">手动停止</span></span></a>";
											return editStr
												+ '<div class="datagrid-btn-separator"></div>'
												+ delStr
												+ '<div class="datagrid-btn-separator"></div>'
												+ stopStr;
											
										}else{
											return editStr
											+ '<div class="datagrid-btn-separator"></div>'
											+ delStr;
										}
									}
								} ] ],
						onResize : function() {
							$('#deviceTypeList').datagrid('fixDetailRowHeight',index);
						},
						onLoadSuccess : function() {
							setTimeout(function() {
										$('#deviceTypeList').datagrid('fixDetailRowHeight',index);
									   }, 0);

						}
					});
				$('#deviceTypeList').datagrid('fixDetailRowHeight', index);
			}
		});
	});
	
	function reloadDatagrid(datagridId) {
		$('#' + datagridId).datagrid("unselectAll");
		$('#' + datagridId).datagrid('reload');
		
		var arr = datagridId.split('-');
		deviceTypeGrid.datagrid('fixDetailRowHeight', arr[1]);
	}
	
	function createDevice(datagridId, deviceType){
		$('#add-device-datagridId').val(datagridId);
		$('#add-device-deviceType').val(deviceType);
		$('#add-device-seriesId').val(nowSeriesId);
		$('#add-device-starId').val(nowStarId);
 		$('#addDeviceModal').modal('show');
	}
	//提交创建系列
	$('#submit_addDevice').click(function(){
		var datagridId = $('#add-device-datagridId').val();
		var f = $('#addDeviceForm');
		f.data('bootstrapValidator').validate();
		var isValid = f.data('bootstrapValidator').isValid();
		if(!isValid){
			top.alertMsg('错误', '请满足提交条件！');
			return false;
		}
		var toUrl = '${pageContext.request.contextPath}/admin/device/createDevice';
		f.form('submit', {url : toUrl,
			onsubmit : function() {
				var flag = $(this).form('validate');
				if (flag) {
					top.showProcess(true, '温馨提示','正在提交数据...');
				}
				return flag;
			},
			success : function(data) {
				top.showProcess(false);
				var map = $.parseJSON(data);
				if (map.success) {
					top.showMsg('提示', map.msg);
					reloadDatagrid(datagridId);
				} else {
					top.alertMsg('错误', map.msg + "\n"+ map.obj == null ? "": map.obj);
				}
			},
			onLoadError : function() {
				top.showProcess(false);
				top.$.messager.alert('温馨提示','由于网络或服务器太忙，提交失败，请重试！');
			}
		});
		$('#addDeviceModal').modal('hide');
	});	
	
	function editDevice(datagridId,deviceId){
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/device/getDeviceById',
			data : {
				deviceId : deviceId
			},
			cache : false,
			dataType : "json",
			success : function(data) {
				if (data) {
					$('#edit-device-datagridId').val(datagridId);
					$('#edit-device-deviceId').val(data.deviceId);
					$('#edit-device-name').val(data.deviceName);
					
					//弹出编辑框
					$('#editDeviceModal').modal('show');
				} else {
					top.alertMsg('错误', "未找到参数信息！");
				}
			}
		});
	}
	$('#submit_editDevice').click(function(){
		var datagridId = $('#edit-device-datagridId').val();
		var f = $('#editDeviceForm');
		f.data('bootstrapValidator').validate();
		var isValid = f.data('bootstrapValidator').isValid();
		if(!isValid){
			top.alertMsg('错误', '请满足提交条件！');
			return false;
		}
		
		var toUrl = '${pageContext.request.contextPath}/admin/device/editDevice';
		f.form('submit',{url : toUrl,onsubmit : function() {
				var flag = $(this).form('validate');
				if (flag) {
					top.showProcess(true,'温馨提示','正在提交数据...');
				}
				return flag;
			},
			success : function(data) {
				top.showProcess(false);
				var map = $.parseJSON(data);
				if (map.success) {
					top.showMsg('提示',map.msg);
					reloadDatagrid(datagridId);
				} else {
					top.alertMsg('错误',map.msg+ "\n"+ map.obj == null ? "": map.obj);
				}
			},
			onLoadError : function() {
				top.showProcess(false);
				top.$.messager.alert('温馨提示','由于网络或服务器太忙，提交失败，请重试！');
			}
		});
		$('#editDeviceModal').modal('hide');
	});
	
	function stopDevice(datagridId,deviceId){
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/device/getDeviceById',
			data : {
				deviceId : deviceId
			},
			cache : false,
			dataType : "json",
			success : function(data) {
				if (data) {
					$('#stop-device-datagridId').val(datagridId);
					$('#stop-device-deviceId').val(data.deviceId);
					$('#stop-device-endDate').val(data.endDate);
					
					//弹出编辑框
					$('#stopDeviceModal').modal('show');
				} else {
					top.alertMsg('错误', "未找到设备信息！");
				}
			}
		});
	}
	$('#submit_stopDevice').click(function(){
		var datagridId = $('#stop-device-datagridId').val();
		var f = $('#stopDeviceForm');
		f.data('bootstrapValidator').validate();
		var isValid = f.data('bootstrapValidator').isValid();
		if(!isValid){
			top.alertMsg('错误', '请满足提交条件！');
			return false;
		}
		
		var toUrl = '${pageContext.request.contextPath}/admin/device/editDevice';
		f.form('submit',{url : toUrl,onsubmit : function() {
				var flag = $(this).form('validate');
				if (flag) {
					top.showProcess(true,'温馨提示','正在提交数据...');
				}
				return flag;
			},
			success : function(data) {
				top.showProcess(false);
				var map = $.parseJSON(data);
				if (map.success) {
					top.showMsg('提示',map.msg);
					reloadDatagrid(datagridId);
				} else {
					top.alertMsg('错误',map.msg+ "\n"+ map.obj == null ? "": map.obj);
				}
			},
			onLoadError : function() {
				top.showProcess(false);
				top.$.messager.alert('温馨提示','由于网络或服务器太忙，提交失败，请重试！');
			}
		});
		$('#stopDeviceModal').modal('hide');
	});
	
	function deleteDevice(datagridId,deviceId){
			swal({
				title : "你是否确定删除?",
				text : "确认删除？",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "删除",
				cancelButtonText : "取消",
				closeOnConfirm : false,
				closeOnCancel : false
			},
			function(isConfirm) {
				if (isConfirm) {
					$.ajax({
						url : '${pageContext.request.contextPath}/admin/device/deleteDevice',
						data : {
							deviceIds : deviceId
						},
						cache : false,
						dataType : "json",
						success : function(data) {
							if (data.success) {
								reloadDatagrid(datagridId);
								swal("删除成功!","","success");
							} else {
// 								top.alertMsg('警告', data.msg);
								swal("删除失败", data.obj,"error");
							}
						}
					});
					
				} else {
					swal("取消删除", "","error");
				}
			});
	}
</script>
</body>
</html>
