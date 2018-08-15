<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cdept;
	var billmaker;
	var sohbillmaker;
	$(function() {
		parent.$.messager.progress('close');
		
		billmaker = $('#billmaker')
		.textbox(
				{
					editable : false,
					icons : [ {
						iconCls : 'icon-search',
						handler : function(e) {
							parent.$
									.refDialog({
										title : '<spring:message code="user" />',
										width : 600,
										height : 500,
										href : '${pageContext.request.contextPath}/pub/refPage',
										onBeforeLoad : function() {
											parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/bduser/data';
											parent.$.refDialog.textbox = billmaker;
										}
									});
						}
					} ]
				});
		sohbillmaker = $('#sohbillmaker')
		.textbox(
				{
					editable : false,
					icons : [ {
						iconCls : 'icon-search',
						handler : function(e) {
							parent.$
									.refDialog({
										title : '<spring:message code="user" />',
										width : 600,
										height : 500,
										href : '${pageContext.request.contextPath}/pub/refPage',
										onBeforeLoad : function() {
											parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/bduser/data';
											parent.$.refDialog.textbox = sohbillmaker;
										}
									});
						}
					} ]
				});

		cdept = $("#cdept")
				.textbox(
						{
							required : true,
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cdept" />',
												width : 600,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refTreePage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cdept/data';
													parent.$.refDialog.textbox = cdept;
												}
											});
								}
							} ]
						});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<form id="searchForm" method="post">
		<table align="center">
			<tr>
				<td><input name="query_flag" style="display: none" value="Y"></td>
			</tr>
			<tr>
				<th>日期</th>
				<td><input name="dbilldate" class="easyui-datebox"
					required="required" value='${moneyDetailVO.dbilldate}'></td>
				<th>部门</th>
				<td><input id="cdept" name="cdept" class="easyui-textbox"
					required="required" value='${moneyDetailVO.cdept}'></td>
			</tr>
			<tr>
				<th>收营员</th>
				<td><input id="billmaker" name="billmaker" class="easyui-textbox" >
				</td>
				<th>营销员</th>
				<td><input id="sohbillmaker" name="sohbillmaker" class="easyui-textbox" >
			</tr>
		</table>
	</form>
</div>