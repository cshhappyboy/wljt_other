<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cmaterial;
	var delwarehouse;
	var approver;
	var billmaker;
	var cdept;//部门
	var salesman;//业务员
	var customer;//客户字段
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

		delwarehouse = $('#delwarehouse')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="delwarehouse" />',
												width : 700,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
													parent.$.refDialog.textbox = delwarehouse;
												}
											});
								}
							} ]
						});
		if (delwarehouse.textbox('getValue')) {
			$.ajax({
				type : 'get',
				url : '${pageContext.request.contextPath}/storedoc/trans/'
						+ delwarehouse.textbox('getValue'),
				async : false,
				success : function(result) {
					result = $.parseJSON(result);
					if (result.status == 200) {
						delwarehouse.textbox('setText', result.data);
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
					value="${invoiceHVO.vbillcode}"></td>
				<th><spring:message code="vsrcbilltype" /></th>
				<td><input id="vsrcbilltype" name="vsrcbilltype"
					class="easyui-combobox"
					data-options="editable:false,valueField:'billtype_id',textField:'billtype_name',panelHeight:115,url:'${pageContext.request.contextPath}/billtype/30'"
					value="${invoiceHVO.cbilltype}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#vsrcbilltype').combobox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="cdept" /></th>
				<td><input id="cdept" name="cdept" value="${invoiceHVO.cdept}">
					<img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cdept').textbox('clear');" /></td>
				<th><spring:message code="salesman" /></th>
				<td><input id="salesman" name="salesman"
					value="${invoiceHVO.salesman}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#salesman').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="effectbillcode" /></th>
				<td><input name="effectbillcode_con" class="easyui-combobox"
					data-options="editable:false,panelHeight:50,valueField:'value',textField:'text',data:[{value:'0',text:'<spring:message code="all" />'},{value:'1',text:'<spring:message code="empty" />'}]"
					value="${invoiceHVO.effectbillcode_con}"></td>
				<th><spring:message code="effectbillcode" /></th>
				<td><input id="effectbillcode" name="effectbillcode"
					class="easyui-textbox" data-options="multiline:true,height:24"
					value="${invoiceHVO.effectbillcode}"></td>
			</tr>
			<tr>
				<th><spring:message code="dbilldate" /></th>
				<td><input name="dbilldatestart" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${invoiceHVO.dbilldatestart}"></td>
				<th><spring:message code="to" /></th>
				<td><input name="dbilldateend" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${invoiceHVO.dbilldateend}"></td>
			</tr>
			<tr>
				<th><spring:message code="vorderbillcode" /></th>
				<td><input name="vorderbillcode" class="easyui-textbox"
					value="${invoiceHVO.vorderbillcode}"></td>
				<th><spring:message code="ntotalrecemny" /></th>
				<td><input name="ntotalrecemny" class="easyui-numberbox"
					value="${invoiceHVO.ntotalrecemny}"></td>
			</tr>
			<tr>
				<th><spring:message code="vbillstatus" /></th>
				<td><input id="vbillstatus" name="vbillstatus"
					class="easyui-combobox"
					data-options="editable:false,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '1',value: '<spring:message code="approved" />'}],panelHeight:50"
					value="${invoiceHVO.vbillstatus}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#vbillstatus').combobox('clear');" /></td>
				<th><spring:message code="customer" /></th>
				<td><input id="customer" name="customer"
					value="${invoiceHVO.customer}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#customer').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="billmaker" /></th>
				<td><input id="billmaker" name="billmaker"
					value="${invoiceHVO.billmaker}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#billmaker').textbox('clear');" /></td>
				<th><spring:message code="approver" /></th>
				<td><input id="approver" name="approver"
					value="${invoiceHVO.approver}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#approver').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="address" /></th>
				<td><input name="address" class="easyui-textbox"
					value="${invoiceHVO.address}"></td>
				<th><spring:message code="tel" /></th>
				<td><input name="tel" class="easyui-textbox"
					value="${invoiceHVO.tel}"></td>
			</tr>
			<tr>
				<th><spring:message code="client" /></th>
				<td><input name="client" class="easyui-textbox"
					value="${invoiceHVO.client}"></td>
				<th><spring:message code="memo" /></th>
				<td><input name="memo" class="easyui-textbox"
					value="${invoiceHVO.memo}"></td>
			</tr>
			<tr>
				<th><spring:message code="cmaterial" /></th>
				<td><input id="cmaterial" name="cmaterial"
					value="${invoiceHVO.cmaterial}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cmaterial').textbox('clear');" /></td>
				<th><spring:message code="delwarehouse" /></th>
				<td><input id="delwarehouse" name="delwarehouse"
					value="${invoiceHVO.delwarehouse}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#delwarehouse').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="issync" /></th>
				<td><input id="issync" name="issync" class="easyui-combobox" data-options="editable:false,panelHeight:75,valueField: 'value',textField: 'text',value:2,data:[{'value':2,'text':'<spring:message code="all" />'},{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]">
				</td>
			</tr>
		</table>
	</form>
</div>