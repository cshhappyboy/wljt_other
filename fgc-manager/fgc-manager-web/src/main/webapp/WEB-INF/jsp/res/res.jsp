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
	var fgcTreeGrid;
	$(function() {
		fgcTreeGrid = $('#fgcResTreGrid')
				.treegrid(
						{
							url : '${pageContext.request.contextPath}/res/queryAllRes',
							fit : true,
							border : false,
							idField : 'id',
							treeField : 'name',
							parentField : 'pid',
							columns : [ [
									{
										field : 'name',
										title : '名称',
										width : 200,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'url',
										title : '资源链接',
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
										title : '上级资源',
										width : 100,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'restypeId',
										title : '资源类型id',
										width : 80,
										align : 'left',
										halign : 'center',
										hidden : true,
									},
									{
										field : 'restypeName',
										title : '资源类型',
										width : 80,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'action',
										title : '操作',
										width : 50,
										align : 'left',
										halign : 'center',
										formatter : function(value, row, index) {
											var str = '';
											str += $
													.formatString(
															'<img onclick="editFun(\'{0}\');" src="{1}" title="编辑" /> ',
															row.id,
															'${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
											str += '&nbsp;';
											str += $
													.formatString(
															'<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>',
															row.id,
															'${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');

											return str;
										}
									}, {
										field : 'remark',
										title : '备注',
										width : 300,
										align : 'left',
										halign : 'center',
									} ] ],
							toolbar : '#toolbar',
							onLoadSuccess : function(data) {
								parent.$.messager.progress('close');
							},
						});

	});
	addFun = function() {
		parent.$.modalDialog({
			title : '添加资源',
			width : 500,
			height : 400,
			href : '${pageContext.request.contextPath}/res/addRes',
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_treeGrid = fgcTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}

	redo = function() {
		var node = fgcTreeGrid.treegrid('getSelected');
		if (node) {
			fgcTreeGrid.treegrid('expandAll', node.id);
		} else {
			fgcTreeGrid.treegrid('expandAll');
		}
	}

	undo = function() {
		var node = fgcTreeGrid.treegrid('getSelected');
		if (node) {
			fgcTreeGrid.treegrid('collapseAll', node.id);
		} else {
			fgcTreeGrid.treegrid('collapseAll');
		}
	}

	deleteFun = function(id) {
		if (id != undefined) {
			fgcTreeGrid.treegrid('select', id);
		}
		var node = fgcTreeGrid.treegrid('getSelected');
		//这里只能单选-->data是数组
		if (node) {
			parent.$.messager.confirm('删除', '您确定要删除选中的数据吗？', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/res/delRes',
							{
								ids : node.id
							}, function(data) {
								data = $.parseJSON(data);
								if (data.status == 200) {
									fgcTreeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
									parent.layout_west_tree.tree('reload');
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
	}

	editFun = function(id) {
		if (id != undefined) {
			fgcTreeGrid.treegrid('select', id);
		}
		var node = fgcTreeGrid.treegrid('getSelected');
		if (node) {
			parent.$.modalDialog({
				title : '编辑资源',
				width : 500,
				height : 400,
				href : '${pageContext.request.contextPath}/res/editRes?id='
						+ node.id,
				buttons : [ {
					text : '编辑',
					handler : function() {
						parent.$.modalDialog.openner_treeGrid = fgcTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
						var f = parent.$.modalDialog.handler.find('#form');
						f.submit();
					}
				} ]
			});
		} else {
			parent.$.messager.alert('提示', '只能选中一条数据修改', 'warning');
		}
	}
</script>
</head>
<body>
	<table id="fgcResTreGrid"></table>

	<div id="toolbar" style="display: none;">
		<a onclick="addFun();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">添加</a> <a
			onclick="redo();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'resultset_next'">展开</a> <a
			onclick="undo();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'resultset_previous'">折叠</a> <a
			onclick="fgcTreeGrid.treegrid('reload');" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'transmit'">刷新</a>
	</div>

</body>
</html>