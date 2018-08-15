<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : "${pageContext.request.contextPath}/order/uploadFileOld",
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
						msg : '导入成功！',
						timeout : 3000,
						showType : 'slide'
					});
					parent.$.modalDialog.handler.dialog("close");
				} else {
					parent.$.messager.alert("提示", r.msg, "error");
				}
			}
		});

	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false">
		<form id="form" method="post" enctype="multipart/form-data">
			<table align="center">
				<tr>
					<th><spring:message code="select_file" /></th>
					<td><input name="orderFile" class="easyui-filebox"
						style="width: 200px" data-options="buttonText:'<spring:message code="select_file" />'"></td>
				</tr>
			</table>
		</form>
	</div>

</div>