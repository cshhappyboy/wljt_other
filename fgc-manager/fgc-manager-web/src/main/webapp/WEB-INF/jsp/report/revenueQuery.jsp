<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<form id="searchForm" method="post">
		<table align="center">
			<tr>
				<td><input name="query_flag" style="display: none" value="Y"></td>
			</tr>
			<tr>
				<th>年</th>
				<td><input name="year" class="easyui-numberspinner"
					data-options="editable:false,min:2018" required="required" value='${year}'></td>
				<th>月</th>
				<td><input name="month" class="easyui-numberspinner"
					data-options="editable:false,min:1,max:12" required="required" value='${month}'></td>
			</tr>
		</table>
	</form>
</div>