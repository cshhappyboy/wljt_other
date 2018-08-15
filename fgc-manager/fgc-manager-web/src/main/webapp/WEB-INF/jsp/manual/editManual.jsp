<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/manual/updateManual',
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
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.status == 200) {
					parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
					parent.$.modalDialog.openner_datagrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				}else{
			   		parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
				}
			}
		});
	});
</script>
<div class="easyui-layout" data-options="fit: true, border: false">
	<div data-options="region:'center',fit: true, border: false">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<input name="id" value="${manualVO.id}" style="display: none">
				</tr>
				<tr>
					<th>资源名称</th>
					<td><input name="name" placeholder="请输入资源名称"
						class="easyui-textbox" data-options="required:true"
						value="${manualVO.name}"></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>资源路径</th>
					<td><input name="url" placeholder="请输入资源路径"
						class="easyui-textbox" data-options="required:true"
						value="${manualVO.url}"></td>
					<th></th>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</div>