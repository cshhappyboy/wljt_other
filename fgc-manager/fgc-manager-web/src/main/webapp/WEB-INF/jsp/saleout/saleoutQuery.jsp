<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cmaterial;
	var cwarehouseid;
	var approver;
	var billmaker;
	var cdept;//部门
	var salesman;//业务员
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
		cwarehouseid = $('#cwarehouseid')
				.textbox(
						{
							editable : false,
							icons : [ {
								iconCls : 'icon-search',
								handler : function(e) {
									parent.$
											.refDialog({
												title : '<spring:message code="cwarehouseid" />',
												width : 700,
												height : 500,
												href : '${pageContext.request.contextPath}/pub/refPage',
												onBeforeLoad : function() {
													parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
													parent.$.refDialog.textbox = cwarehouseid;
												}
											});
								}
							} ]
						});
		 if (cwarehouseid.textbox('getValue')) {
				$.ajax({
					type : 'get',
					url : '${pageContext.request.contextPath}/storedoc/trans/'
							+ cwarehouseid.textbox('getValue'),
					async : false,
					success : function(result) {
						result = $.parseJSON(result);
						if (result.status == 200) {
							cwarehouseid.textbox('setText', result.data);
						}
					}
				});
			}
		approver = $('#approver')
				.textbox(
						{editable:false,
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
					value="${saleOutHVO.vbillcode}"></td>
				<th><spring:message code="cdept" /></th>
				<td><input id="cdept" name="cdept" value="${saleOutHVO.cdept}">
					<img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cdept').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="effectbillcode" /></th>
				<td><input name="effectbillcode_con" class="easyui-combobox"
					data-options="editable:false,panelHeight:50,valueField:'value',textField:'text',data:[{value:'0',text:'<spring:message code="all" />'},{value:'1',text:'<spring:message code="empty" />'}]"
					value="${saleOutHVO.effectbillcode_con}"></td>
				<th><spring:message code="effectbillcode" /></th>
				<td><input id="effectbillcode" name="effectbillcode"
					class="easyui-textbox" data-options="multiline:true,height:24"
					value="${saleOutHVO.effectbillcode}"></td>
			</tr>
			<tr>
				<th><spring:message code="dbilldate" /></th>
				<td><input name="dbilldatestart" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${saleOutHVO.dbilldatestart}"></td>
				<th><spring:message code="to" /></th>
				<td><input name="dbilldateend" type="text"
					class="easyui-datebox" data-options="editable:false"
					required="required" value="${saleOutHVO.dbilldateend}"></td>
			</tr>
			<tr>
				<th><spring:message code="vorderbillcode" /></th>
				<td><input name="vorderbillcode" class="easyui-textbox"
					value="${saleOutHVO.vorderbillcode}"></td>
				<th><spring:message code="vbillstatus" /></th>
				<td><input id="vbillstatus" name="vbillstatus" class="easyui-combobox"
					data-options="editable:false,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '2',value: '<spring:message code="sign" />'}],panelHeight:50"
					value="${saleOutHVO.vbillstatus}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#vbillstatus').combobox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="billmaker" /></th>
				<td><input id="billmaker" name="billmaker"
					value="${saleOutHVO.billmaker}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#billmaker').textbox('clear');" /></td>
				<th><spring:message code="approver" /></th>
				<td><input id="approver" name="approver"
					value="${saleOutHVO.approver}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#approver').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="cmaterial" /></th>
				<td><input id="cmaterial" name="cmaterial"
					value="${saleOutHVO.cmaterial}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cmaterial').textbox('clear');" /></td>
				<th><spring:message code="cwarehouseid" /></th>
				<td><input id="cwarehouseid" name="cwarehouseid"
					value="${saleOutHVO.cwarehouseid}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#cwarehouseid').textbox('clear');" /></td>
			</tr>
			<tr>
				<th><spring:message code="salesman" /></th>
				<td><input id="salesman" name="salesman"
					value="${saleOutHVO.salesman}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#salesman').textbox('clear');" /></td>
				<th><spring:message code="issync" /></th>
				<td><input id="issync" name="issync" class="easyui-combobox" data-options="editable:false,panelHeight:75,valueField: 'value',textField: 'text',value:2,data:[{'value':2,'text':'<spring:message code="all" />'},{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]">
				</td>
			</tr>
			<tr>
				<th>签字时间</th>
				<td><input id="dsigndatestart" name="dsigndatestart" type="text"
					class="easyui-datebox" data-options="editable:false"
					value="${saleOutHVO.dsigndatestart}">
					<img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#dsigndatestart').textbox('clear');" /></td>
				<th><spring:message code="to" /></th>
				<td><input id="dsigndateend" name="dsigndateend" type="text"
					class="easyui-datebox" data-options="editable:false"
					value="${saleOutHVO.dsigndateend}">
					<img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#dsigndateend').textbox('clear');" /></td>
			</tr>
			<tr>
				<th>销售订单类型</th>
				<td><input id="vdef10" name="vdef10" class="easyui-combobox" data-options="editable:false,valueField:'billtype_id',textField:'billtype_name',panelHeight:115,url:'${pageContext.request.contextPath}/billtype/30'"
					value="${saleOutHVO.vdef10}"> <img
					src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
					onclick="$('#vdef10').textbox('clear');" /></td>
				<th></th>
				<td></td>
			</tr>
		</table>
	</form>
</div>