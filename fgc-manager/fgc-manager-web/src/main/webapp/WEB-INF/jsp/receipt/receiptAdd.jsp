<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cbalatype;
	var cbankid;//银行账户
	var cashaccount;//现金账户
	var salesman;//业务员
	var currency;//币种
	var cdept;//部门
	var customer;//客户字段
	$(function() {
		parent.$.messager.progress('close');
		
		cbankid = $('#cbankid').textbox({
			required:true,
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="cbankid" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/bank/data';
							parent.$.refDialog.textbox = cbankid;
						}
					});
				}
			} ]
		});
		
		cashaccount = $('#cashaccount').textbox(
				{
					required:true,
					editable:false,
					icons : [ {
						iconCls : 'icon-search',
						handler : function(e) {
							parent.$.refDialog({
								title : '<spring:message code="cashaccount" />',
								width : 600,
								height : 500,
								href : '${pageContext.request.contextPath}/pub/refPage',
								onBeforeLoad:function(){
									parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cashaccount/data';
									parent.$.refDialog.textbox = cashaccount;
								}
							});
						}
					} ]
				}
		);
		
		salesman = $('#salesman').textbox({
			required:true,
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="salesman" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/psndoc/data';
							parent.$.refDialog.textbox = salesman;
							parent.$.refDialog.textbox_one = cdept
						}
					});
				}
			} ]
		});
		
		if(salesman.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/psndoc/trans/'+salesman.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							salesman.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		currency = $('#currency').textbox({
			required:true,
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="currency" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/currency/data';
							parent.$.refDialog.textbox = currency;
						}
					});
				}
			} ]
		});
		
		if(currency.textbox('getValue')){
			$.ajax({  
		         type : 'get',  
		          url : '${pageContext.request.contextPath}/currency/trans/'+currency.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							currency.textbox('setText',result.data);
						}
		          }
		     }); 
		}

		cdept = $("#cdept").textbox({
			required:true,
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="cdept" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refTreePage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cdept/data';
							parent.$.refDialog.textbox = cdept;
						}
					});
				}
			} ]
		});
		
		if(cdept.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/cdept/trans/'+cdept.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cdept.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		customer = $("#customer").textbox({
			required:true,
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="customer" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/customer/data';
							parent.$.refDialog.textbox = customer;
						}
					});
				}
			} ]
		});
		
		if(customer.textbox('getValue')){
			$.ajax({  
		         type : 'get',  
		          url : '${pageContext.request.contextPath}/customer/trans/'+customer.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							customer.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		cbalatype = $('#cbalatype').combobox({
			editable:false,
			valueField:'billtype_id',
			textField:'billtype_name',
			panelHeight:48,
			url:'${pageContext.request.contextPath}/cbalatype/data',
			onSelect:function(record){
				var cbalatypeValue = record.billtype_id;
				if(cbalatypeValue == '0001Z0100000000000XZ'){
					cbankid.textbox('disable');
					cbankid.textbox('setValue',null);
					cashaccount.textbox('enable');
					cashaccount.textbox({'editable':false});
				}else{
					cashaccount.textbox('disable');
					cashaccount.textbox('setValue',null);
					cbankid.textbox('enable');
					cbankid.textbox({'editable':false});
					cbankid.textbox('setValue','1001A1100000000CSB0W');
					cbankid.textbox('setText','CHEQUE支票');
				}
			}
		});
		
		if(cbalatype.combobox('getValue')){
			var cbalatypeValue = cbalatype.combobox('getValue');
			if(cbalatypeValue == '0001Z0100000000000XZ'){
				cbankid.textbox('setValue',null);
				cbankid.textbox('disable');
				cashaccount.textbox('enable');
				cashaccount.textbox({'editable':false});
			}else{
				cashaccount.textbox('disable');
				cashaccount.textbox('setValue',null);
				cbankid.textbox('enable');
				cbankid.textbox({'editable':false});
				cbankid.textbox('setValue','1001A1100000000CSB0W');
				cbankid.textbox('setText','CHEQUE支票');
			}
		}
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow: hidden; background: #eee;">
		<form id="form" method="post">
			<table align="center">
				<tr>
					<input name="id" type="text"  style="display: none;" value="${receiptHVO.id}">
				</tr>
				<tr>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode"  class="easyui-textbox" data-options="disabled:true"
						value="${receiptHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" class= "easyui-datebox" required ="required" data-options="editable:false" 
						value="${receiptHVO.dbilldate}"></td>
					<th><spring:message code="customer" /></th>
					<td><input id="customer" name="customer" 
						value="${receiptHVO.customer}"></td>
						<th><spring:message code="cdept" /></th>
					<td><input id="cdept" name="cdept" 
						value="${receiptHVO.cdept}"></td>
				</tr>
				<tr>
					<th><spring:message code="currency" /></th>
					<td><input id="currency" name="currency" value="${receiptHVO.currency}"></td>
					<th><spring:message code="salesman" /></th>
					<td><input id="salesman" name="salesman" value="${receiptHVO.salesman}"></td>
					<th><spring:message code="vbillstatus" /></th>
					<td><input name="vbillstatus" class="easyui-combobox"  data-options="disabled:true,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '1',value: '<spring:message code="approved" />'},{key: '1',value: '<spring:message code="synced" />'}],panelHeight:50" value="${receiptHVO.vbillstatus}"></td>
					<th><spring:message code="taux" /></th>
					<td><input name="taux" class="easyui-numberbox" data-options="precision:4" 
						value="${receiptHVO.taux}"></td>
				</tr>
				<tr>
					<th><spring:message code="total" /></th>
					<td><input name="total" class="easyui-numberbox" data-options="max:'${receiptHVO.total}',precision:0,required:true," 
						value="${receiptHVO.total}"></td>
					<th><spring:message code="cbalatype" /></th>
					<td><input name="cbalatype" id="cbalatype" value="${receiptHVO.cbalatype}"></td>
					<th><spring:message code="cashaccount" /></th>
					<td><input id="cashaccount"  name="cashaccount"
						value="${receiptHVO.cashaccount}"></td>
					<th><spring:message code="vorderbillcode" /></th>
					<td><input name="vorderbillcode" class="easyui-textbox" data-options="disabled:true,"
						value="${receiptHVO.vorderbillcode}"></td>
				</tr>
				<tr>
					<th><spring:message code="vsrcbilltype" /></th>
					<td><input name="vsrcbilltype" class="easyui-combobox" data-options="disabled:true,required:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:115,url:'${pageContext.request.contextPath}/billtype/30'"
						value="${receiptHVO.vsrcbilltype}"></td>
					<th><spring:message code="effectbillcode" /></th>
					<td><input name="effectbillcode" class="easyui-textbox" data-options="disabled:true,"
						value="${receiptHVO.effectbillcode}"></td>
					<th><spring:message code="nordermny" /></th>
					<td><input name="nordermny" class="easyui-numberbox" data-options="disabled:true,precision:0" 
						value="${receiptHVO.nordermny}"></td>
					<th><spring:message code="nreceivedmny" /></th>
					<td><input name="nreceivedmny" class="easyui-numberbox" data-options="disabled:true,precision:0" 
						value="${receiptHVO.nreceivedmny}"></td>
				</tr>
				<tr>
					<th><spring:message code="cbankid" /></th>
					<td><input id="cbankid" name="cbankid"
						value="${receiptHVO.cbankid}"></td>
					<th><spring:message code="issync" /></th>
					<td><input name="issync" class="easyui-combobox" data-options="disabled:true,panelHeight:50,valueField: 'value',textField: 'text',data:[{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]"
						value="${receiptHVO.issync}"></td>
				</tr>
				<tr>
					<td><input name="billmaker" style="display: none;"
						value="${receiptHVO.billmaker}"></td>
					<td><input name="billmaketime"  style="display: none;"
						value="${receiptHVO.billmaketime}"></td>
					<td><input name="modifier"  style="display: none;"
						value="${receiptHVO.modifier}"></td>
					<td><input name="modifiedtime"  style="display: none;" 
						value="${receiptHVO.modifiedtime}"></td>
					<td><input name="approver"  style="display: none;" 
						value="${receiptHVO.approver}"></td>
					<td><input name="approvetime"  style="display: none;" 
						value="${receiptHVO.approvetime}"></td>
				</tr>
				<tr>
					<td><input name="ts" style="display: none;"
						value="${receiptHVO.ts}"></td>
					<td><input name="dr"  style="display: none;"
						value="${receiptHVO.dr}"></td>
					<td><input name="vsrcid" style="display: none;"
						value="${receiptHVO.vsrcid}"></td>
					<td><input name="vsrccode"  style="display: none;"
						value="${receiptHVO.vsrccode}"></td>
					<td><input name="pkGroup"  style="display: none;"
						value="${receiptHVO.pkGroup}"></td>
					<td><input name="pkOrg"  style="display: none;"
						value="${receiptHVO.pkOrg}"></td>
				</tr>
				<tr>
					<td><input name="vdef1" style="display: none;"
						value="${receiptHVO.vdef1}"></td>
					<td><input name="vdef2"  style="display: none;"
						value="${receiptHVO.vdef2}"></td>
					<td><input name="vdef3" style="display: none;"
						value="${receiptHVO.vdef3}"></td>
					<td><input name="vdef4"  style="display: none;"
						value="${receiptHVO.vdef4}"></td>
					<td><input name="vdef5"  style="display: none;"
						value="${receiptHVO.vdef5}"></td>
					<td><input name="vdef6"  style="display: none;"
						value="${receiptHVO.vdef6}"></td>
					<td><input name="vdef7" style="display: none;"
						value="${receiptHVO.vdef7}"></td>
					<td><input name="vdef8"  style="display: none;"
						value="${receiptHVO.vdef8}"></td>
					<td><input name="vdef9" style="display: none;"
						value="${receiptHVO.vdef9}"></td>
					<td><input name="vdef10"  style="display: none;"
						value="${receiptHVO.vdef10}"></td>
				</tr>
			</table>
		</form>
	</div>
</div>