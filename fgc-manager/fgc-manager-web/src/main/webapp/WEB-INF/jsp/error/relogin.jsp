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
<style>
a {
	text-decoration: none
}
</style>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
	});
	showPage = function() {
		parent.location.href = '${pageContext.request.contextPath}/login';
	}
</script>
</head>
<body>
	<a href="javascript:void(0)" onclick="showPage()">登录过期，返回到登录界面</a>
</body>
</html>
