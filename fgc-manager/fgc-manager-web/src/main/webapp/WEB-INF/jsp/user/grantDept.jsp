<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var pubRef;
	$(function() {
		parent.$.messager.progress('close');
		pubRef = $('#pubRef').tree(
				{
					url : parent.$.refDialog.refURLPath,
					parentField : 'pid',
					checkbox : true,
					cascadeCheck : false,
					onLoadSuccess : function() {
						pubRef.tree('expandAll');
						parent.$.messager.progress('close');
						var resIds = $.stringToList('${dept.deptIds}');
						if (resIds.length > 0) {
							for (var i = 0; i < resIds.length; i++) {
								if (pubRef.tree('find', resIds[i])) {
									pubRef.tree('check', pubRef.tree(
											'find', resIds[i]).target);
								}
							}
						}
					},
				});
		$('#form').form({
			url : '${pageContext.request.contextPath}/user/grantDepts',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				var nodes = pubRef.tree('getChecked');
				var ids = [];
				if (nodes && nodes.length > 0) {
					for (var i = 0; i < nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					$('#deptIds').val(ids.join(','));
				}else{
					$('#deptIds').val('');
				}

				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.status == 200) {
					parent.$.messager.show({
						title : '提示',
						msg : '部门分配成功！',
						timeout : 3000,
						showType : 'slide'

					});
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
	});
	function checkAll() {
		var nodes = pubRef.tree('getChecked', 'unchecked');
		if (nodes && nodes.length > 0) {
			for (var i = 0; i < nodes.length; i++) {
				pubRef.tree('check', nodes[i].target);
			}
		}
	}
	function uncheckAll() {
		var nodes = pubRef.tree('getChecked');
		if (nodes && nodes.length > 0) {
			for (var i = 0; i < nodes.length; i++) {
				pubRef.tree('uncheck', nodes[i].target);
			}
		}
	}
	function checkInverse() {
		var unchecknodes = pubRef.tree('getChecked', 'unchecked');
		var checknodes = pubRef.tree('getChecked');
		if (unchecknodes && unchecknodes.length > 0) {
			for (var i = 0; i < unchecknodes.length; i++) {
				pubRef.tree('check', unchecknodes[i].target);
			}
		}
		if (checknodes && checknodes.length > 0) {
			for (var i = 0; i < checknodes.length; i++) {
				pubRef.tree('uncheck', checknodes[i].target);
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
		<ul id="pubRef"></ul>
		<form id="form" method="post">
			<input id="id" name="userId" value="${dept.userId}" type="hidden" /> <input
				id="deptIds" name="deptIds" value="${dept.deptIds}" type="hidden" />
		</form>
	</div>
</div>
