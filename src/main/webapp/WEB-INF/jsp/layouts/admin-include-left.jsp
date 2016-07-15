<%@ page language="java" pageEncoding="UTF-8"%>

<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>

<!--  
	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>

			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>
			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
-->	
	<!-- #sidebar-shortcuts -->

	<ul id="left_con" class="nav nav-list">
<!-- 		<li><a href="admin/index"> <i class="icon-dashboard"></i> <span -->
<!-- 				class="menu-text"> 欢迎页面 </span> -->
<!-- 		</a></li> -->

		<li>
			<a href="#" class="dropdown-toggle"> <i class="icon-list"></i>
				<span class="menu-text"> 文件管理</span>
				<b class="arrow icon-angle-down"></b>
			</a>
			<ul class="submenu">
				<li>
					<a href="#"> <i class="icon-double-angle-right"></i> 其他系列
					</a>
				</li>
				<li>
					<a href="#" class="dropdown-toggle">
						<i class="icon-double-angle-right"></i>
						j9系列
						<b class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="admin/file/index/j9/01/0/">
								<i class="icon-leaf"></i>
								第一颗星
							</a>
						</li>
						<li>
							<a href="admin/file/index/j9/02/0/">
								<i class="icon-leaf"></i>
								第二颗星
							</a>
						</li>
						<li>
							<a href="admin/file/index/j9/03/0/">
								<i class="icon-leaf"></i>
								第三颗星
							</a>
						</li>
						<li>
							<a href="admin/file/index/j9/04/0/">
								<i class="icon-leaf"></i>
								第四颗星
							</a>
						</li>
						<li>
							<a href="admin/file/index/j9/05/0/">
								<i class="icon-leaf"></i>
								第五颗星
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</li>
		
<!-- 		<li> -->
<!-- 			<a href="#" class="dropdown-toggle"> <i class="icon-list"></i> -->
<!-- 				<span class="menu-text"> 系统管理</span> -->
<!-- 				<b class="arrow icon-angle-down"></b> -->
<!-- 			</a> -->
<!-- 			<ul class="submenu"> -->
<!-- 				<li><a href="admin/user/index"> <i class="icon-double-angle-right"></i> 用户管理 -->
<!-- 					</a></li> -->
<!-- 				<li><a href="#"> <i class="icon-double-angle-right"></i> 部门管理 -->
<!-- 					</a></li> -->
<!-- 				<li><a href="admin/role/index"> <i class="icon-double-angle-right"></i> 角色管理 -->
<!-- 					</a></li> -->
<!-- 				<li><a href="#"> <i class="icon-double-angle-right"></i> 权限管理 -->
<!-- 					</a></li> -->
<!-- 				<li><a href="javascript:void(0)"> <i class="icon-double-angle-right"></i> 日志管理 -->
<!-- 					</a></li> -->
<!-- 				<li><a href="ftl/hello"> <i class="icon-double-angle-right"></i> ftl视图 -->
<!-- 				</a></li> -->
<!-- 				<li><a href="echart/echartTest"> <i class="icon-double-angle-right"></i> echart图表 -->
<!-- 					</a></li> -->
<!-- 			</ul> -->
<!-- 		</li> -->
		
	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>
