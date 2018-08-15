<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cdept;//部门
	var salesman;//业务员
	var currency;//币种字段
	var customer;//客户字段
	var orderBDataGrid;
	var canEdit = true;
	var editRow;
	$(function() {
		
		cdept = $("#cdept").textbox({
			readonly:true,
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
		
		salesman = $('#salesman').textbox({
			readonly:true,
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
			readonly:true,
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
		
		customer = $('#customer').textbox({
			readonly:true,
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
		
		orderBDataGrid = $('#orderBDataGrid').datagrid(
				{	
					url:'${pageContext.request.contextPath}/order/qryOrderBVOs?id=${billHid}',
					selectOnCheck : false,
					checkOnSelect : false,
					singleSelect:true,
					idField : 'id',
					fit : true,
					rownumbers : true,
					frozenColumns:[[{
						field : 'id',
						title : '<spring:message code="id" />',
						width : 120,
						hidden:true,
						align : 'left',
						halign : 'center',
					},{
						field : 'cmaterial',
						title : '<spring:message code="cmaterial" />',
						hidden:true,
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'materialcode',
						title : '<spring:message code="materialcode" />',
						width : 120,
						align : 'left',
						halign : 'center',
					}, {
						field : 'materialname',
						title : '<spring:message code="materialname" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && row.cmaterial != null) {
		                    	var name;
		                    	$.ajax({  
							         type : 'get',  
							          url : '${pageContext.request.contextPath}/cmaterial/transName/'+row.cmaterial,  
							          async : false,
							          success : function(result) {
											result = $.parseJSON(result);
											if(result.status==200){
												name = result.data;
											}else{
												name = "";
											}
							          }
							     }); 
								return name;
		                    }
		                }
					}]],
					columns : [ [ {
						field : 'materialspec',
						title : '<spring:message code="materialspec" />',
						width : 120,
						align : 'left',
						halign : 'center',
					}, {
						field : 'materialtype',
						title : '<spring:message code="materialtype" />',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'csaleunitid',
						title : '<spring:message code="csaleunitid" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                    	var name;
		                    	$.ajax({  
							         type : 'get',  
							          url : '${pageContext.request.contextPath}/castunit/trans/'+value,  
							          async : false,
							          success : function(result) {
											result = $.parseJSON(result);
											if(result.status==200){
												name = result.data;
											}else{
												name = "";
											}
							          }
							     }); 
								return name;
		                    }
		                }
					},{
						field : 'vunitratio',
						title : '<spring:message code="vunitratio" />',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'vbdef1',
						title : '<spring:message code="long*haut" />',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'vbdef2',
						title : 'QTE',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'salenum',
						title : '<spring:message code="salenum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'nsaleprice',
						title : '<spring:message code="nsaleprice" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(0);
		                    }
		                },
					}, {
						field : 'delwarehouse',
						title : '<spring:message code="delwarehouse" />',
						width : 120,
						hidden:true,
						align : 'left',
						halign : 'center',
						
					},{
						field : 'delwarehousecode',
						title : '<spring:message code="delwarehouse" />',
						width : 120,
						align : 'left',
						halign : 'center',
						
					},  {
						field : 'castunitid',
						title : '<spring:message code="castunitid" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                    	var name;
		                    	$.ajax({  
							         type : 'get',  
							          url : '${pageContext.request.contextPath}/castunit/trans/'+value,  
							          async : false,
							          success : function(result) {
											result = $.parseJSON(result);
											if(result.status==200){
												name = result.data;
											}else{
												name = "";
											}
							          }
							     }); 
								return name;
		                    }
		                }
					}, {
						field : 'nastnum',
						title : '<spring:message code="num" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},  {
						field : 'nprice',
						title : '<spring:message code="nprice" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(0);
		                    }
		                },
					} , {
						field : 'nmny',
						title : '<spring:message code="nmny" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(0);
		                    }
		                },
					}, {
						field : 'sizecode',
						title : '<spring:message code="sizecode" />',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'nexchangerate',
						title : '<spring:message code="nexchangerate" />',
						width : 120,
						align : 'left',
						halign : 'center',
					} ,{
						field : 'ninvoicenum',
						title : '<spring:message code="ninvoicenum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'ninvoicesalenum',
						title : '<spring:message code="ninvoicesalenum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'ninvoicemny',
						title : '<spring:message code="ninvoicemny" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(0);
		                    }
		                },
					},{
						field : 'ninnum',
						title : '<spring:message code="nrinnum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'ninfonum',
						title : '<spring:message code="ninfonum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'nthisinfonum',
						title : '<spring:message code="nthisinfonum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
							}
						},
					},{
						field : 'noutnum',
						title : '<spring:message code="noutnum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'nreturnnum',
						title : '<spring:message code="nreturnnum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'gift',
						title : '<spring:message code="gift" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter:function(value,row,index){
							if(value == 0){
								return '<spring:message code="no" />'
							}else if(value == 1){
								return '<spring:message code="yes" />'
							}
						},
					},{
						field : 'services',
						title : '<spring:message code="services" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter:function(value,row,index){
							if(value == 0){
								return '<spring:message code="no" />'
							}else if(value == 1){
								return '<spring:message code="yes" />'
							}
						},
						editor : {
							type : 'combobox',
							options : {
								panelHeight:50,
								valueField: 'value',
								textField: 'text',
								readonly:true,
								data:[
								      {value:0,text:'<spring:message code="no" />'},
								      {value:1,text:'<spring:message code="yes" />'}
								],
								onChange:function(newValue,oldValue){
									var srow = orderBDataGrid.datagrid('getSelected');
									var rindex = orderBDataGrid.datagrid('getRowIndex', srow);
									if(srow.services && srow.services==1){
										var nthisinfonumED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nthisinfonum'
										});
										nthisinfonumED.target.textbox({readonly:true});
									}
								}
							}
						},
					},{
						field : 'vsrcid',
						hidden:true,
					},{
						field : 'vsrcbid',
						hidden:true,
					},{
						field : 'cunitid',
						hidden:true,
					},{
						field : 'nnum',
						hidden:true,
					},{
						field : 'measrate',
						hidden:true,
					},{
						field : 'vbdef3',
						hidden:true,
					},{
						field : 'vbdef4',
						hidden:true,
					},{
						field : 'vbdef5',
						hidden:true,
					},{
						field : 'vbdef6',
						hidden:true,
					},{
						field : 'vbdef7',
						hidden:true,
					},{
						field : 'vbdef8',
						hidden:true,
					},{
						field : 'vbdef10',
						hidden:true,
					},{
						field : 'issync',
						hidden:true,
					},{
						field : 'ts',
						hidden:true,
					},{
						field : 'dr',
						hidden:true,
					},{
						field : 'ninvoicenastnum',
						hidden:true,
					},{
						field : 'ninastnum',
						hidden:true,
					},{
						field : 'noutnastum',
						hidden:true,
					},{
						field : 'nreturnastnum',
						hidden:true,
					}] ],
					onClickRow : function(rowIndex, row) {//编辑行
						if(endEditing()){
							orderBDataGrid.datagrid('selectRow',rowIndex);
							orderBDataGrid.datagrid('beginEdit',rowIndex);
							editRow = rowIndex;
							parent.$.modalDialog.last_edit_index = editRow;
						}
						else{
							orderBDataGrid.datagrid('clearSelections');
							orderBDataGrid.datagrid('selectRow',editRow);
						}
					},
					onLoadSuccess:function(datas){
						parent.$.messager.progress('close');
					},
				});
			parent.$.modalDialog.inner_datagrid = orderBDataGrid;
	});
	
	endEditing = function(){
		if(editRow == undefined){
			return true;
		}
		if(orderBDataGrid.datagrid('validateRow',editRow)){
			orderBDataGrid.datagrid('endEdit',editRow);	
			editRow = undefined;
			return true;
		}else{
			return false;
		}
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false" title=""
		style="overflow: hidden; background: #eee;">
		<form id="form" method="post">
			<table align="center">
				<tr>
					<input name="id" type="text"  style="display: none;" value="${orderHVO.id}">
					<input name="vbilltype" style="display: none;" value="${orderHVO.vbilltype}">
					<input name="ntotalinvoicenum" style="display: none;" value="${orderHVO.ntotalinvoicenum}">
				</tr>
				<tr>
					<th><spring:message code="cbilltype" /></th>
					<td><input name="cbilltype" class="easyui-combobox" data-options="readonly:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:115,url:'${pageContext.request.contextPath}/billtype/30'"
						value="${orderHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode"  class="easyui-textbox" data-options="readonly:true,"
						value="${orderHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" type= "text" class= "easyui-datebox"  data-options="readonly:true,editable:false" 
						value="${orderHVO.dbilldate}"></td>
					<th><spring:message code="customer" /></th>
					<td><input id="customer" name="customer" value="${orderHVO.customer}"></td>
				</tr>
				<tr>
					<th><spring:message code="currency" /></th>
					<td><input id="currency" name="currency" value="${orderHVO.currency}"></td>
					<th><spring:message code="salesman" /></th>
					<td><input id="salesman" name="salesman" value="${orderHVO.salesman}"></td>
					<th><spring:message code="cdept" /></th>
					<td><input id="cdept" name="cdept" value="${orderHVO.cdept}"></td>
					<th><spring:message code="ntotalnum" /></th>
					<td><input id="ntotalnum" name="ntotalnum" class="easyui-numberbox" data-options="readonly:true,precision:4" 
						value="${orderHVO.ntotalnum}"></td>
				</tr>
				<tr>
					<th><spring:message code="norigtaxmny" /></th>
					<td><input id="norigtaxmny"  name="norigtaxmny" class="easyui-numberbox" data-options="readonly:true,precision:0" 
						value="${orderHVO.norigtaxmny}"></td>
					<th><spring:message code="nreceivedmny" /></th>
					<td><input id="nreceivedmny" name="nreceivedmny" class="easyui-numberbox" data-options="readonly:true,precision:0" 
						value="${orderHVO.nreceivedmny}"></td>
					<th><spring:message code="vbillstatus" /></th>
					<td><input name="vbillstatus" class="easyui-combobox"  data-options="readonly:true,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '1',value: '<spring:message code="approved" />'}],panelHeight:50" value="${orderHVO.vbillstatus}"></td>
					<th><spring:message code="client" /></th>
					<td><input name="client" class="easyui-textbox" data-options="readonly:true," value="${orderHVO.client}"></td>
				</tr>
				<tr>
					<th><spring:message code="address" /></th>
					<td><input name="address" class="easyui-textbox" data-options="readonly:true,"
						value="${orderHVO.address}"></td>
					<th><spring:message code="tel" /></th>
					<td><input name="tel" class="easyui-textbox" data-options="readonly:true,"
						value="${orderHVO.tel}"></td>
					<th><spring:message code="memo" /></th>
					<td><input name="memo" class="easyui-textbox" data-options="readonly:true,"
						value="${orderHVO.memo}"></td>
					<th><spring:message code="cbalatype" /></th>
					<td><input name="cbalatype" class="easyui-combobox" data-options="readonly:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:48,url:'${pageContext.request.contextPath}/cbalatype/data'"
					value="${orderHVO.cbalatype}"></td>
				</tr>
				<tr>
					<th><spring:message code="effectbillcode" /></th>
					<td><input name="effectbillcode" class="easyui-textbox" data-options="readonly:true"
						value="${orderHVO.effectbillcode}"></td>
					<th><spring:message code="returnsale" /></th>
					<td><input name="returnsale" class="easyui-combobox" data-options="readonly:true,panelHeight:50,valueField: 'value',textField: 'text',data:[{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]"
						value="${orderHVO.returnsale}"></td>
					<th><spring:message code="ntotalinvoicemny" /></th>
					<td><input name="ntotalinvoicemny" class="easyui-numberbox" data-options="readonly:true,precision:0"
						value="${orderHVO.ntotalinvoicemny}"></td>
					<th><spring:message code="nexchangerate" /></th>
					<td><input name="nexchangerate" id="nexchangerate" class="easyui-numberbox" data-options="readonly:true,precision:4"
						value="${orderHVO.nexchangerate}"></td>
				</tr>
				<tr>
					<th><spring:message code="issync" /></th>
					<td><input name="issync" class="easyui-combobox" data-options="readonly:true,panelHeight:50,valueField: 'value',textField: 'text',data:[{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]"
						value="${orderHVO.issync}"></td>
				</tr>
				<tr>
					<td><input name="billmaker" style="display: none;"
						value="${orderHVO.billmaker}"></td>
					<td><input name="billmaketime"  style="display: none;"
						value="${orderHVO.billmaketime}"></td>
					<td><input name="modifier"  style="display: none;"
						value="${orderHVO.modifier}"></td>
					<td><input name="modifiedtime"  style="display: none;" 
						value="${orderHVO.modifiedtime}"></td>
					<td><input name="approver"  style="display: none;" 
						value="${orderHVO.approver}"></td>
					<td><input name="approvetime"  style="display: none;" 
						value="${orderHVO.approvetime}"></td>
					<td><input name="reviser"  style="display: none;" 
						value="${orderHVO.reviser}"></td>
					<td><input name="revisetime"  style="display: none;" 
						value="${orderHVO.revisetime}"></td>
				</tr>
				<tr>
					<td><input name="ts" style="display: none;"
						value="${orderHVO.ts}"></td>
					<td><input name="dr"  style="display: none;"
						value="${orderHVO.dr}"></td>
					<td><input name="vsrcid" style="display: none;"
						value="${orderHVO.vsrcid}"></td>
					<td><input name="vsrccode"  style="display: none;"
						value="${orderHVO.vsrccode}"></td>
					<td><input name="pkGroup"  style="display: none;"
						value="${orderHVO.pkGroup}"></td>
					<td><input name="pkOrg"  style="display: none;"
						value="${orderHVO.pkOrg}"></td>
				</tr>
				<tr>
					<td><input name="vdef1" style="display: none;"
						value="${orderHVO.vdef1}"></td>
					<td><input name="vdef2"  style="display: none;"
						value="${orderHVO.vdef2}"></td>
					<td><input name="vdef3" style="display: none;"
						value="${orderHVO.vdef3}"></td>
					<td><input name="vdef4"  style="display: none;"
						value="${orderHVO.vdef4}"></td>
					<td><input name="vdef5"  style="display: none;"
						value="${orderHVO.vdef5}"></td>
					<td><input name="vdef6"  style="display: none;"
						value="${orderHVO.vdef6}"></td>
					<td><input name="vdef7" style="display: none;"
						value="${orderHVO.vdef7}"></td>
					<td><input name="vdef8"  style="display: none;"
						value="${orderHVO.vdef8}"></td>
					<td><input name="vdef9" style="display: none;"
						value="${orderHVO.vdef9}"></td>
					<td><input name="vdef10"  style="display: none;"
						value="${orderHVO.vdef10}"></td>
				</tr>
				<tr>
					<td><input name="alreadyinvoice"  style="display: none;"
						value="${orderHVO.alreadyinvoice}"></td>
					<td><input name="alreadyin"  style="display: none;"
						value="${orderHVO.alreadyin}"></td>
					<td><input name="alreadyrevise"  style="display: none;"
						value="${orderHVO.alreadyrevise}"></td>
					<td><input name="ntotalinnum"  style="display: none;"
						value="${orderHVO.ntotalinnum}"></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',title:''" style="background: #eee;">
		<table id="orderBDataGrid"></table>
	</div>
</div>