<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cmaterial;
	var approver;
	var billmaker;
	var cotherbizid;//出库业务员
	var cbizid;//入库业务员
	var coutwarehouseid;//出库仓库
	var cotherwhid;//入库仓库
	$(function() {
		parent.$.messager.progress('close');

		cmaterial = $('#cmaterial')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cmaterial" />',
												width : 700,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refTreeTablePage',
												onBeforeLoad : function() {
													parent.$.refDialog.refCmaterialDataURL = '${pageContext.request.contextPath}/cmaterial/data'
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cmaterial/class/data';
													parent.$.refDialog.textbox = cmaterial;
												}
											});
								}
							} ]
						});

		if (cmaterial.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/cmaterial/transCode/'
						+ cmaterial.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						cmaterial.textbox('setText', result.data);
					}
				}
			});
		}
		approver = $('#approver')
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
													parent.$.refDialog.textbox = approver;
												}
											});
								}
							} ]
						});

		if (approver.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/bduser/trans/'
						+ approver.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						approver.textbox('setText', result.data);
					}
				}
			});
		}
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

		if (billmaker.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/bduser/trans/'
						+ billmaker.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						billmaker.textbox('setValue', billmaker
								.textbox('getValue'));
						billmaker.textbox('setText', result.data);
					}
				}
			});
		}

		cotherbizid = $('#cotherbizid')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cotherbizid" />',
												width : 600,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/psndoc/data';
													parent.$.refDialog.textbox = cotherbizid;
												}
											});
								}
							} ]
						});

		if (cotherbizid.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/psndoc/trans/'
						+ cotherbizid.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						cotherbizid.textbox('setText', result.data);
					}
				}
			});
		}

		cbizid = $('#cbizid')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cbizid" />',
												width : 600,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/psndoc/data';
													parent.$.refDialog.textbox = cbizid;
												}
											});
								}
							} ]
						});

		if (cbizid.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/psndoc/trans/'
						+ cbizid.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						cbizid.textbox('setText', result.data);
					}
				}
			});
		}

		coutwarehouseid = $('#coutwarehouseid')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="coutwarehouseid" />',
												width : 700,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
													parent.$.refDialog.textbox = coutwarehouseid;
												}
											});
								}
							} ]
						});

		if (coutwarehouseid.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/storedoc/trans/'
						+ coutwarehouseid.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						coutwarehouseid.textbox('setText', result.data);
					}
				}
			});
		}

		cotherwhid = $('#cotherwhid')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cotherwhid" />',
												width : 700,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
													parent.$.refDialog.textbox = cotherwhid;
												}
											});
								}
							} ]
						});

		if (cotherwhid.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/storedoc/trans/'
						+ cotherwhid.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						cotherwhid.textbox('setText', result.data);
					}
				}
			});
		}
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<form id="searchForm" method="post">
		<table align="center">
			<tr>
				<td><input name="query_flag" style="display: none" value="Y"></td>
			</tr>
			<tr>
				<th><spring:message code="cbilltype" /></th>
				<td><input id="cbilltype" name="cbilltype" class="easyui-combobox"
					data-options="editable:false,valueField:'billtype_id',textField:'billtype_name',panelHeight:75,url:'${pageContext.request.contextPath}/billtype/4K'"
					value="${whstransHVO.cbilltype}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cbilltype').combobox('clear');" /></td>
				<th><spring:message code="vbillcode" /></th>
				<td><input name="vbillcode" class="easyui-textbox"
					value="${whstransHVO.vbillcode}"></td>
			</tr>
			<tr>
				<th><spring:message code="dbilldate" /></th>
				<td><input name="dbilldatestart" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${whstransHVO.dbilldatestart}"></td>
				<th><spring:message code="to" /></th>
				<td><input name="dbilldateend" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${whstransHVO.dbilldateend}"></td>
			</tr>
			<tr>
				<th><spring:message code="cotherwhid" /></th>
				<td><input id="cotherwhid" name="cotherwhid"
					value="${whstransHVO.cotherwhid}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cotherwhid').textbox('clear');" /></td>
				<th><spring:message code="coutwarehouseid" /></th>
				<td><input id="coutwarehouseid" name="coutwarehouseid"
					value="${whstransHVO.coutwarehouseid}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#coutwarehouseid').textbox('clear');" /></td>
			</tr>
			<tr>

				<th><spring:message code="cbizid" /></th>
				<td><input id="cbizid" name="cbizid"
					value="${whstransHVO.cbizid}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cbizid').textbox('clear');" /></td>
				<th><spring:message code="cotherbizid" /></th>
				<td><input id="cotherbizid" name="cotherbizid"
					value="${whstransHVO.cotherbizid}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cotherbizid').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="billmaker" /></th>
				<td><input id="billmaker" name="billmaker"
					value="${whstransHVO.billmaker}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#billmaker').textbox('clear');" /></td>
				<th><spring:message code="approver" /></th>
				<td><input id="approver" name="approver"
					value="${whstransHVO.approver}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#approver').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="cmaterial" /></th>
				<td><input id="cmaterial" name="cmaterial"
					value="${whstransHVO.cmaterial}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cmaterial').textbox('clear');" /></td>
				<th><spring:message code="vbillstatus" /></th>
				<td><input id="vbillstatus" name="vbillstatus" class="easyui-combobox"
					data-options="editable:false,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '1',value: '<spring:message code="approved" />'},],panelHeight:50"
					value="${whstransHVO.vbillstatus}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#vbillstatus').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="vbatchcode" /></th>
				<td><input name="vbatchcode" class="easyui-textbox"
					value="${whstransHVO.vbatchcode}"></td>
				<th><spring:message code="issync" /></th>
				<td><input id="issync" name="issync" class="easyui-combobox" data-options="editable:false,panelHeight:75,valueField: 'value',textField: 'text',value:2,data:[{'value':2,'text':'<spring:message code="all" />'},{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]">
				</td>
			</tr>
		</table>
	</form>
</div>