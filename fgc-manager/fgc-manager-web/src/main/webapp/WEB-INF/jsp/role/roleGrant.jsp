<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	var roleResTree;
	$(function() {
		roleResTree = $('#roleResTree')
				.tree(
						{
							url : '${pageContext.request.contextPath}/res/resTree?type=1',
							parentField : 'pid',
							lines : true,
							panelHeight : 'auto',
							checkbox : true,
							cascadeCheck : false,
							onLoadSuccess : function() {
								parent.$.messager.progress('close');
								var resIds = $.stringToList('${role.resIds}');
								if (resIds.length > 0) {
									for (var i = 0; i < resIds.length; i++) {
										if (roleResTree.tree('find', resIds[i])) {
											roleResTree.tree('check',
													roleResTree.tree('find',
															resIds[i]).target);
										}
									}
								}
							},
						});
		$('#form').form({
			url : '${pageContext.request.contextPath}/role/grantRes',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				var nodes = roleResTree.tree('getChecked');
				var ids = [];
				if (nodes && nodes.length > 0) {
					for (var i = 0; i < nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					$('#resIds').val(ids.join(','));
				}else{
					$('#resIds').val('');
				}

				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.status == 200) {
					parent.$.messager.show({
						title : '提示',
						msg : '资源分配成功！',
						timeout : 3000,
						showType : 'slide'

					});
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
					parent.layout_west_tree.tree('reload');
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
	});
	function checkAll() {
		var nodes = roleResTree.tree('getChecked', 'unchecked');
		if (nodes && nodes.length > 0) {
			for (var i = 0; i < nodes.length; i++) {
				roleResTree.tree('check', nodes[i].target);
			}
		}
	}
	function uncheckAll() {
		var nodes = roleResTree.tree('getChecked');
		if (nodes && nodes.length > 0) {
			for (var i = 0; i < nodes.length; i++) {
				roleResTree.tree('uncheck', nodes[i].target);
			}
		}
	}
	function checkInverse() {
		var unchecknodes = roleResTree.tree('getChecked', 'unchecked');
		var checknodes = roleResTree.tree('getChecked');
		if (unchecknodes && unchecknodes.length > 0) {
			for (var i = 0; i < unchecknodes.length; i++) {
				roleResTree.tree('check', unchecknodes[i].target);
			}
		}
		if (checknodes && checknodes.length > 0) {
			for (var i = 0; i < checknodes.length; i++) {
				roleResTree.tree('uncheck', checknodes[i].target);
			}
		}
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'east',title:'快捷方式'" style="width: 150px;">
		<div class="well well-large">
			<button class="btn btn-success" onclick="checkAll();">全选</button>
			<br /> <br />
			<button class="btn btn-warning" onclick="checkInverse();">反选</button>
			<br /> <br />
			<button class="btn btn-inverse" onclick="uncheckAll();">取消</button>
		</div>
	</div>
	<div data-options="region:'center',title:'资源列表'"
		style="padding: 10px;">
		<ul id="roleResTree"></ul>
		<form id="form" method="post">
			<input id="id" name="id" value="${role.id}" type="hidden" /> <input
				id="resIds" name="resIds" value="${role.resIds}" type="hidden" />
		</form>
	</div>
</div>
