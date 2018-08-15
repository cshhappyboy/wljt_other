<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	var userDataGrid;
	$(function() {
		userDataGrid = $('#userDataGrid')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/user/qryAllUser',
							fit : true,
							idField : 'cuserid',
							rownumbers : true,
							singleSelect : true,
							columns : [ [
									{
										field : 'cuserid',
										title : 'id',
										width : 100,
										hidden : true,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'usercode',
										title : '编码',
										width : 150,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'username',
										title : '姓名',
										width : 150,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'roleaction',
										title : '角色授权',
										width : 75,
										align : 'center',
										halign : 'center',
										formatter : function(value, row, index) {
											var str = '';
											str += '&nbsp;';
											str += $
													.formatString(
															'<img onclick="grantUser(\'{0}\');" src="{1}" title="授权角色" /> ',
															row.cuserid,
															'${pageContext.request.contextPath}/style/images/extjs_icons/key.png');
											str += '&nbsp;';
											
											return str;
										}
									},
									{
										field : 'deptaction',
										title : '部门授权',
										width : 75,
										align : 'center',
										halign : 'center',
										formatter : function(value, row, index) {
											var str = '';
											str += '&nbsp;';
											str += $
													.formatString(
															'<img onclick="grantDept(\'{0}\');" src="{1}" title="授权部门" /> ',
															row.cuserid,
															'${pageContext.request.contextPath}/style/images/extjs_icons/status_online.png');
											str += '&nbsp;';
											return str;
										}
									},
									{
										field : 'warehouseaction',
										title : '仓库授权',
										width : 75,
										align : 'center',
										halign : 'center',
										formatter : function(value, row, index) {
											var str = '';
											str += '&nbsp;';
											str += $
													.formatString(
															'<img onclick="grantWarehouse(\'{0}\');" src="{1}" title="授权角色" /> ',
															row.cuserid,
															'${pageContext.request.contextPath}/style/images/extjs_icons/database.png');
											str += '&nbsp;';
											return str;
										}
									} ] ],
							onLoadSuccess : function(data) {
								parent.$.messager.progress('close');
							},
						});
	});
	grantWarehouse = function(id){
		parent.$
		.modalDialog({
			title : '仓库授权',
			width : 600,
			height : 500,
			href : '${pageContext.request.contextPath}/user/grantWarehousePage?id='
					+ id,
			onBeforeLoad : function() {
				parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/allData';
			},
			buttons : [ {
				text : '授权',
				handler : function() {
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	grantDept = function(id) {
		parent.$
				.modalDialog({
					title : '部门授权',
					width : 600,
					height : 500,
					href : '${pageContext.request.contextPath}/user/grantDeptPage?id='
							+ id,
					onBeforeLoad : function() {
						parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cdept/data';
					},
					buttons : [ {
						text : '授权',
						handler : function() {
							var f = parent.$.modalDialog.handler.find('#form');
							f.submit();
						}
					} ]
				});

	}

	grantUser = function(id) {
		parent.$
				.modalDialog({
					title : '角色授权',
					width : 550,
					height : 400,
					href : '${pageContext.request.contextPath}/user/userGrant?id='
							+ id,
					buttons : [ {
						text : '授权',
						handler : function() {
							parent.$.modalDialog.openner_dataGrid = userDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
							var f = parent.$.modalDialog.handler.find('#form');
							f.submit();
						}
					} ]
				});

	}
	searchFun = function() {
		var usercode = $('#usercode').textbox('getValue');
		var username = $('#username').textbox('getValue');
		userDataGrid.datagrid('load', {
			'usercode' : usercode,
			'username' : username
		});
	}
	cleanFun = function() {
		$('#usercode').textbox('reset');
		$('#username').textbox('reset');
		userDataGrid.datagrid('load', {});
	}
</script>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'east',iconCls:'icon-search',title:'查询'"
			style="width: 200px;">
			<form id="searchForm">
				<table class="table table-hover table-condensed">
					<tr>
						<th>编码</th>
						<td><input id="usercode" name="usercode"
							class="easyui-textbox"
							data-options="onChange:function(e){searchFun();}" /></td>
					</tr>
					<tr>
						<th>姓名</th>
						<td><input id="username" name="username"
							class="easyui-textbox"
							data-options="onChange:function(e){searchFun();}" /></td>
					</tr>
					<tr>
						<th></th>
						<td><a href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'brick_add',plain:true"
							onclick="searchFun();">查询</a><a href="javascript:void(0);"
							class="easyui-linkbutton"
							data-options="iconCls:'brick_delete',plain:true"
							onclick="cleanFun();">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="userDataGrid"></table>
		</div>
	</div>

	<div id="toolbar" style="display: none;">
		<a onclick="addUser();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'user_add'">添加</a> <a
			onclick="editUser();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'user_edit'">修改</a> <a
			onclick="deleteUser();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'user_delete'">删除</a>
	</div>
</body>
</html>