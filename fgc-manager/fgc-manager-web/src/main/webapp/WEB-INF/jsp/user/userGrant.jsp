<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#roleIds').combotree({
			url : '${pageContext.request.contextPath}/role/roleTree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto',
			multiple:true,
			onLoadSuccess : function() {
				parent.$.messager.progress('close');
			},
			cascadeCheck : false,
			value : $.stringToList('${user.roleIds}')
		});

		$('#form').form({
			url : "${pageContext.request.contextPath}/user/grant",
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(data) {
				parent.$.messager.progress('close');
				var r = $.parseJSON(data);
				if (r.status == 200) {
					parent.$.messager.show({
						title : '提示',
						msg : '授权成功！',
						timeout : 3000,
						showType : 'slide'
					});
					parent.$.modalDialog.openner_dataGrid.datagrid("reload");
					parent.$.modalDialog.handler.dialog("close");
				} else {
					$.messager.alert("提示", r.msg, "error");
				}
			}
		});

	});
</script>

<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',fit:true,border:false"
		style="overflow: hidden;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>角色</th>
					<td><select id="roleIds" name="roleIds"
						style="width: 300px; height: 29px;"></select><img
						src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
						onclick="$('#roleId').combotree('clear');" /></td>
				</tr>
				<input name="cuserid" type="text" value="${user.cuserid}"
					style="display: none;">
			</table>
		</form>
	</div>

</div>
