<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/manual/syncManualData',
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
					parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
					parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
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
			<table>
				<tr>
					<input name="id" value="${manualVO.id}" style="display: none">
				</tr>
				<tr>
					<th>资源名称</th>
					<td><input name="name" 
						class="easyui-textbox" data-options="readonly:true"
						value="${manualVO.name}"></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>资源路径</th>
					<td><input name="url" 
						class="easyui-textbox" data-options="readonly:true"
						value="${manualVO.url}"></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>同步初始时间段</th>
					<td><input name="beginDate" 
						class="easyui-datetimebox" data-options="editable:false"
						value="${manualVO.beginDate}"></td>
					<th>同步结束时间段</th>
					<td><input name="endDate" 
						class="easyui-datetimebox" data-options="editable:false"
						value="${manualVO.endDate}"></td>
				</tr>
			</table>
		</form>
	</div>
</div>