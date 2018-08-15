<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	var roleTreeGrid;
	$(function() {
		roleTreeGrid = $('#roleTreeGrid')
				.treegrid(
						{
							url : '${pageContext.request.contextPath}/role/queryAllRoles',
							fit : true,
							border : false,
							idField : 'id',
							singleSelect:true,
							treeField : 'name',
							parentField : 'pid',
							columns : [ [
									{
										field : 'id',
										title : 'id',
										width : 200,
										hidden:true,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'name',
										title : '名称',
										width : 200,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'remark',
										title : '备注',
										width : 300,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'seq',
										title : '排序',
										width : 50,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'pname',
										title : '上级权限',
										width : 100,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'action',
										title : '操作',
										width : 75,
										align : 'left',
										halign : 'center',
										formatter : function(value, row, index) {
											var str = '';
											str += $
													.formatString(
															'<img onclick="editRole(\'{0}\');" src="{1}" title="编辑" /> ',
															row.id,
															'${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
											str += '&nbsp;';
											str += $
													.formatString(
															'<img onclick="grantRole(\'{0}\');" src="{1}" title="授权" /> ',
															row.id,
															'${pageContext.request.contextPath}/style/images/extjs_icons/key.png');
											str += '&nbsp;';
											str += $
													.formatString(
															'<img onclick="deleteRole(\'{0}\');" src="{1}" title="删除"/>',
															row.id,
															'${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');

											return str;
										}
									} ] ],
							toolbar : '#toolbar',
							onLoadSuccess : function(data) {
								parent.$.messager.progress('close');
							},
						});

	});
	addRole = function() {
		parent.$.modalDialog({
			title : '添加角色',
			width : 500,
			height : 400,
			href : '${pageContext.request.contextPath}/role/roleAdd',
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_treeGrid = roleTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	redo = function() {
		var node = roleTreeGrid.treegrid('getSelected');
		if (node) {
			roleTreeGrid.treegrid('expandAll', node.id);
		} else {
			roleTreeGrid.treegrid('expandAll');
		}
	}

	undo = function() {
		var node = roleTreeGrid.treegrid('getSelected');
		if (node) {
			roleTreeGrid.treegrid('collapseAll', node.id);
		} else {
			roleTreeGrid.treegrid('collapseAll');
		}
	}
	deleteRole = function(id) {
		//这里只能单选-->data是数组
			parent.$.messager
					.confirm('删除',
							'您确定要删除选中的数据吗？',
							function(r) {
								if (r) {
									parent.$.messager.progress({
										title : '提示',
										text : '数据处理中，请稍后....'
									});
									$.post('${pageContext.request.contextPath}/role/delRole',
													{
														ids : id
													},
													function(result) {
														result = $.parseJSON(result);
														if (result.status == 200) {
															roleTreeGrid
																	.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
															parent.layout_west_tree
																	.tree('reload');
															parent.$.messager.show({
																		title : '消息',
																		msg : '刪除成功',
																		timeout : 3000,
																		showType : 'slide'
																	});
														} else {
															parent.$.messager
																	.alert(
																			'提示',
																			data.msg,
																			'error');
														}
														parent.$.messager
																.progress('close');
													});
								}
							});
	}
	editRole = function(id) {
			parent.$
					.modalDialog({
						title : '编辑角色',
						width : 500,
						height : 400,
						href : '${pageContext.request.contextPath}/role/editRole?id='
								+ id,
						buttons : [ {
							text : '编辑',
							handler : function() {
								parent.$.modalDialog.openner_treeGrid = roleTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
								var f = parent.$.modalDialog.handler
										.find('#form');
								f.submit();
							}
						} ]
					});
	}
	grantRole = function(id){
			parent.$
					.modalDialog({
						title : '分配资源',
						width : 400,
						height : 500,
						href : '${pageContext.request.contextPath}/role/roleGrant?id='
								+ id,
						buttons : [ {
							text : '分配资源',
							handler : function() {
								parent.$.modalDialog.openner_treeGrid = roleTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
								var f = parent.$.modalDialog.handler
										.find('#form');
								f.submit();
							}
						} ]
					});
	}
</script>
</head>
<body>
	<table id="roleTreeGrid"></table>
	<div id="toolbar" style="display: none;">
		<a onclick="addRole();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">添加</a> <a
			onclick="redo();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'resultset_next'">展开</a> <a
			onclick="undo();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'resultset_previous'">折叠</a> <a
			onclick="roleTreeGrid.treegrid('reload');"
			href="javascript:void(0);" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'transmit'">刷新</a>
	</div>
</body>
</html>