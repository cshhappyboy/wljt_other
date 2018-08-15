<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	var manualDatagrid;
	$(function() {
		parent.$.messager.progress('close');
		manualDatagrid = $('#manualDatagrid')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/manual/data',
							fit : true,
							border : false,
							toolbar : '#toolbar',
							rownumbers : true,
							singleSelect : true,
							columns : [ [
									{
										title : '名称',
										field : 'name',
										width : 200,
										align : 'left',
										halign : 'center',
									},
									{
										title : '资源链接',
										field : 'url',
										width : 300,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'action',
										title : '操作',
										width : 50,
										align : 'center',
										halign : 'center',
										formatter : function(value, row, index) {
											var str = '';
											str += $
													.formatString(
															'<img onclick="editManual(\'{0}\');" src="{1}" title="编辑" /> ',
															row.id,
															'${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
											str += '&nbsp;';
// 											str += $
// 													.formatString(
// 															'<img onclick="deleteManual(\'{0}\');" src="{1}" title="删除"/>',
// 															row.id,
// 															'${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
											return str;
										}
									} ,
									{
										field : 'syncAction',
										title : '同步',
										width : 50,
										align : 'center',
										halign : 'center',
										formatter : function(value, row, index) {
											var str = '';
											str += $
													.formatString(
															'<img onclick="syncManual(\'{0}\');" src="{1}" title="同步"/>',
															row.id,
															'${pageContext.request.contextPath}/style/images/extjs_icons/database_refresh.png');
											return str;
										}
									} ] ],
							toolbar : '#toolbar',
							onLoadSuccess : function(datas) {
								parent.$.messager.progress('close');
							}
						});
	});
	addManual = function() {
		parent.$.modalDialog({
			title : '添加手动同步',
			width : 500,
			height : 200,
			href : '${pageContext.request.contextPath}/manual/addManual',
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_datagrid = manualDatagrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	editManual = function(id){
		parent.$.modalDialog({
			title : '修改手动同步',
			width : 500,
			height : 200,
			href : '${pageContext.request.contextPath}/manual/eidtManual?id='+id,
			buttons : [ {
				text : '修改',
				handler : function() {
					parent.$.modalDialog.openner_datagrid = manualDatagrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	deleteManual = function(id){
		parent.$.messager.confirm('删除', '您确定要删除选中的数据吗？删除了可能会导致系统出现不可用的风险，请一定要谨慎！！！', function(r) {
			if (r) {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				$.post('${pageContext.request.contextPath}/manual/deleteManual',
						{
							id:id
						}, function(data) {
							data = $.parseJSON(data);
							if (data.status == 200) {
								manualDatagrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
								parent.$.messager.show({
									title : '消息',
									msg : '刪除成功',
									timeout : 3000,
									showType : 'slide'
								});
							} else {
								parent.$.messager.alert('提示', data.msg,
										'error');
							}
							parent.$.messager.progress('close');
						});
			}
		});
	}
	
	syncManual = function(id){
		parent.$.modalDialog({
			title : '同步数据',
			width : 500,
			height : 200,
			href : '${pageContext.request.contextPath}/manual/syncManual?id='+id,
			buttons : [ {
				text : '同步',
				handler : function() {
					parent.$.modalDialog.openner_datagrid = manualDatagrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	refreshQuery = function() {
		manualDatagrid.datagrid('reload');
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border:false,split:true">
			<table id="manualDatagrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		<div onclick="addManual();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">
			<spring:message code="add" />
		</div>
		<div onclick="refreshQuery();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'data_refresh'">
			<spring:message code="refreshQuery" />
		</div>
	</div>
</body>
</html>