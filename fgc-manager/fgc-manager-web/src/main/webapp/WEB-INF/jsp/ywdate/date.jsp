<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			 url:'${pageContext.request.contextPath}/context/changeDate',    
			 onSubmit: function(){
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
			 success:function(result){    
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.status == 200) {
					parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
					parent.$.modalDialog.handler.dialog('close');
					$('#nowDate').html(result.data);
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
					<th><spring:message code="ywdate" /></th>
					<td><input name="ywdate" class= "easyui-datebox" 
						value="${ywdate}"></td>
					<th></th>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</div>