<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cbankid;//银行账户
	var cashaccount;//现金账户
	var approver;
	var billmaker;
	var customer;
	var cdept;//部门
	var salesman;
	$(function() {
		parent.$.messager.progress('close');

		cbankid = $('#cbankid')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cbankid" />',
												width : 600,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/bank/data';
													parent.$.refDialog.textbox = cbankid;
												}
											});
								}
							} ]
						});

		if (cbankid.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/bank/trans/'
						+ cbankid.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						cbankid.textbox('setText', result.data);
					}
				}
			});
		}

		cashaccount = $('#cashaccount')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cashaccount" />',
												width : 600,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cashaccount/data';
													parent.$.refDialog.textbox = cashaccount;
												}
											});
								}
							} ]
						});
		if (cashaccount.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/cashaccount/trans/'
						+ cashaccount.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						cashaccount.textbox('setText', result.data);
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
						billmaker.textbox('setText', result.data);
					}
				}
			});
		}

		cdept = $("#cdept")
				.textbox(
						{
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

		if (cdept.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/cdept/trans/'
						+ cdept.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						cdept.textbox('setText', result.data);
					}
				}
			});
		}

		salesman = $('#salesman')
				.textbox(
						{
							editable : false,
							onChange : function(newValue, oldValue) {
								if (newValue) {
									$
											.ajax({
												type : 'get',
												url : '${pageContext.request.contextPath}/psndoc/cdept/'
														+ newValue,
												async : false,
												success : function(result) {
													result = $
															.parseJSON(result);
													if (result.status == 200) {
														var billtype = result.data;
														billtype = $
																.parseJSON(billtype);
														cdept
																.textbox(
																		'setValue',
																		billtype.billtype_id);
														cdept
																.textbox(
																		'setText',
																		billtype.billtype_name);
													}
												}
											});
								}
							},
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="salesman" />',
												width : 600,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/psndoc/data';
													parent.$.refDialog.textbox = salesman;
												}
											});
								}
							} ]
						});

		if (salesman.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/psndoc/trans/'
						+ salesman.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						salesman.textbox('setText', result.data);
					}
				}
			});
		}

		customer = $("#customer")
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="customer" />',
												width : 600,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/customer/data';
													parent.$.refDialog.textbox = customer;
												}
											});
								}
							} ]
						});
		if (customer.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/customer/trans/'
						+ customer.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						customer.textbox('setText', result.data);
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
				<th><spring:message code="vbillcode" /></th>
				<td><input name="vbillcode" class="easyui-textbox"
					value="${receiptHVO.vbillcode}"></td>
				<th><spring:message code="vsrcbilltype" /></th>
				<td><input id="vsrcbilltype" name="vsrcbilltype"
					class="easyui-combobox"
					data-options="editable:false,valueField:'billtype_id',textField:'billtype_name',panelHeight:115,url:'${pageContext.request.contextPath}/billtype/30'"
					value="${receiptHVO.vsrcbilltype}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#vsrcbilltype').combobox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="cdept" /></th>
				<td><input id="cdept" name="cdept" value="${receiptHVO.cdept}">
					<img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cdept').textbox('clear');" /></td>
				<th><spring:message code="salesman" /></th>
				<td><input id="salesman" name="salesman"
					value="${receiptHVO.salesman}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#salesman').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="vorderbillcode" /></th>
				<td><input name="vorderbillcode" class="easyui-textbox"
					value="${receiptHVO.vorderbillcode}"></td>
				<th><spring:message code="vbillstatus" /></th>
				<td><input id="vbillstatus" name="vbillstatus"
					class="easyui-combobox"
					data-options="editable:false,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '1',value: '<spring:message code="approved" />'}],panelHeight:50"
					value="${receiptHVO.vbillstatus}"><img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#vbillstatus').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="effectbillcode" /></th>
				<td><input name="effectbillcode_con" class="easyui-combobox"
					data-options="editable:false,panelHeight:50,valueField:'value',textField:'text',data:[{value:'0',text:'<spring:message code="all" />'},{value:'1',text:'<spring:message code="empty" />'}]"
					value="${receiptHVO.effectbillcode_con}"></td>
				<th><spring:message code="effectbillcode" /></th>
				<td><input id="effectbillcode" name="effectbillcode"
					class="easyui-textbox" data-options="multiline:true,height:24"
					value="${receiptHVO.effectbillcode}"></td>
			</tr>
			<tr>
				<th><spring:message code="nreceivedmny" /></th>
				<td><input name="nreceivedmny" class="easyui-numberbox"
					data-options="precision:2" value="${receiptHVO.nreceivedmny}"></td>
				<th><spring:message code="customer" /></th>
				<td><input id="customer" name="customer"
					value="${receiptHVO.customer}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#customer').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="dbilldate" /></th>
				<td><input name="dbilldatestart" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${receiptHVO.dbilldatestart}"></td>
				<th><spring:message code="to" /></th>
				<td><input name="dbilldateend" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${receiptHVO.dbilldateend}"></td>
			</tr>
			<tr>
				<th><spring:message code="billmaker" /></th>
				<td><input id="billmaker" name="billmaker"
					value="${receiptHVO.billmaker}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#billmaker').textbox('clear');" /></td>
				<th><spring:message code="approver" /></th>
				<td><input id="approver" name="approver"
					value="${receiptHVO.approver}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#approver').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="cashaccount" /></th>
				<td><input id="cashaccount" name="cashaccount"
					value="${receiptHVO.cashaccount}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cashaccount').textbox('clear');" /></td>
				<th><spring:message code="cbankid" /></th>
				<td><input id="cbankid" name="cbankid"
					value="${receiptHVO.cbankid}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cbankid').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="cbalatype" /></th>
				<td><input id="cbalatype" name="cbalatype"
					class="easyui-combobox"
					data-options="editable:false,valueField:'billtype_id',textField:'billtype_name',panelHeight:48,url:'${pageContext.request.contextPath}/cbalatype/data'"
					value="${receiptHVO.cbalatype}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cbalatype').combobox('clear');" /></td>
				<th><spring:message code="issync" /></th>
				<td><input id="issync" name="issync" class="easyui-combobox"
					data-options="editable:false,panelHeight:75,valueField: 'value',textField: 'text',value:2,data:[{'value':2,'text':'<spring:message code="all" />'},{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]">
				</td>
			</tr>
			<tr>
				<th>是否0预收</th>
				<td><input name="iszero" class="easyui-combobox"
					data-options="editable:false,valueField:'value',textField:'text',panelHeight:75,value:0,data:[{'value':0,'text':'全部'},{'value':1,'text':'不包含0预收'},{'value':2,'text':'只有0预收'}]"
					value="${receiptHVO.iszero}"></td>
			</tr>
		</table>
	</form>
</div>