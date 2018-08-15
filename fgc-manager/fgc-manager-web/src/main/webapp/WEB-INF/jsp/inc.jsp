<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 引入jQuery -->
<script
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/jquery.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/ajaxfileupload.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/jquery.easyui.min.js"
	type="text/javascript" charset="utf-8"></script>
<script id="scriptlocale" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/locale/easyui-lang-<c:out value="${cookie.locale.value}" default="zh_CN"/>.js"
	charset="utf-8"></script>
<link id="easyuiTheme" rel="stylesheet"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/themes/<c:out value="${cookie.easyuiThemeName.value}" default="gray"/>/easyui.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/themes/icon.css"
	type="text/css">
<!-- 扩展EasyUI -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/extEasyUI.js"
	charset="utf-8"></script>
<!-- 扩展jQuery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.5/extJquery.js"
	charset="utf-8"></script>
<!-- 业务jquery-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/pub/pub.js" charset="utf-8"></script>
<!-- 扩展EasyUI Icon -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/extEasyUIIcon.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/extFgcUIIcon.css"
	type="text/css">


