<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cbalatype;
	var cbankid;
	var cdept;//部门
	var salesman;//业务员
	var currency;//币种字段
	var customer;//客户字段
	var invoiceBDataGrid;
	var editRow = undefined;
	$(function() {
		parent.$.messager.progress('close');
		
		cbankid = $('#cbankid').textbox({
			readonly:true,
		});
		
		if(cbankid.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/bank/trans/'+cbankid.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cbankid.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		cashaccount = $('#cashaccount').textbox({
					readonly:true,
				}
		);
		if(cashaccount.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/cashaccount/trans/'+cashaccount.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cashaccount.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
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
		
		customer = $("#customer").textbox({
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
		
		cbalatype = $('#cbalatype').combobox({
			readonly:true,
			valueField:'billtype_id',
			textField:'billtype_name',
			panelHeight:48,
			url:'${pageContext.request.contextPath}/cbalatype/data',
		});
		invoiceBDataGrid = $('#invoiceBDataGrid').datagrid(
				{
					url:'${pageContext.request.contextPath}/invoice/qryInvoiceBVOs?id=${billHid}',
					selectOnCheck : false,
					checkOnSelect : false,
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
						field : 'vbdef5',
						title : '<spring:message code="long*haut" />',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'vbdef6',
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
						field : 'noinvoicesalenum',
						title : '<spring:message code="noinvoicesalenum" />',
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
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
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
						
					}, {
						field : 'cunitid',
						title : '<spring:message code="cunitid" />',
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
					} , {
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
						title : '<spring:message code="nastnum" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					}, {
						field : 'nnum',
						title : '主数量',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					},{
						field : 'nprice',
						title : '<spring:message code="nprice" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                        return parseFloat(value).toFixed(4);
		                    }
		                },
					}, {
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
						hidden:true,
					},{
						field : 'currency',
						title : '<spring:message code="currency" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                    	var name;
		                    	$.ajax({  
		           		         type : 'get',  
		           		          url : '${pageContext.request.contextPath}/currency/trans/'+value,  
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
		                },
					}, {
						field : 'customer',
						title : '<spring:message code="customer" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter: function (value, row, index) {
		                    if (row != null && value != null && value !='') {
		                    	var name;
		                    	$.ajax({  
		           		         type : 'get',  
		           		          url : '${pageContext.request.contextPath}/customer/trans/'+value,  
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
		                },
					},  {
						field : 'cbalatype',
						hidden:true,
					},{
						field : 'cashaccount',
						hidden:true,
					},{
						field : 'cbankid',
						hidden:true,
					},{
						field : 'vtransrate',
						title : '<spring:message code="vtransrate" />',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'norigmny',
						hidden:true,
					},{
						field : 'localmoney',
						hidden:true,
					},{
						field : 'csubjcode',
						title : '<spring:message code="csubjcode" />',
						width : 120,
						align : 'left',
						halign : 'center',
						formatter:function(value,row,index){
							if(value == '1001A110000000000Q17'){
								return '制作安装'
							}else if(value == '1001A110000000000Q18'){
								return '商品销售'
							}
						},
					} ,{
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
					},{
						field : 'vsrcid',
						hidden:true,
					},{
						field : 'vsrcbid',
						hidden:true,
					},{
						field : 'noutnum',
						hidden:true,
					},{
						field : 'vbdef1',
						hidden:true,
					},{
						field : 'vbdef2',
						hidden:true,
					},{
						field : 'vbdef3',
						hidden:true,
					},{
						field : 'vbdef4',
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
					}] ],
					toolbar : '#toolbar',
					onClickRow : function(rowIndex, row) {//编辑行
						if(endEditing()){
							invoiceBDataGrid.datagrid('beginEdit',rowIndex);
							transData(invoiceBDataGrid,rowIndex,row);
							editRow = rowIndex;
							parent.$.modalDialog.last_edit_index = editRow;
						}
						else{
							invoiceBDataGrid.datagrid('clearSelections');
							invoiceBDataGrid.datagrid('selectRow',editRow);
						}
					},
				});
			parent.$.modalDialog.inner_datagrid = invoiceBDataGrid;
	});
	transData = function(datagrid,rowIndex,row){
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'materialname'});
		if(row.cmaterial){
			$.ajax({  
		         type : 'get',  
		          url : '${pageContext.request.contextPath}/cmaterial/transName/'+row.cmaterial,  
		          async : false,
		          success : function(result) {
						result = $.parseJSON(result);
						var textbox = ed.target.textbox('textbox');
						if(result.status==200){
							textbox.val(result.data);
						}
		          }
		     });
		}
		
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'csaleunitid'});
		if(row.csaleunitid){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/castunit/trans/'+row.csaleunitid,    
		         async : false,
		         success : function(result) {
						result = $.parseJSON(result);
						var textbox = ed.target.textbox('textbox');
						if(result.status==200){
							textbox.val(result.data);
						}
		          }
		     }); 
		}
		
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'castunitid'});
		if(row.castunitid){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/castunit/trans/'+row.castunitid,    
		         async : false,
		         success : function(result) {
						result = $.parseJSON(result);
						var textbox = ed.target.textbox('textbox');
						if(result.status==200){
							textbox.val(result.data);
						}
		          }
		     }); 
		}
	}
	
	addRow = function() {
		if(editRow != undefined){
			if(invoiceBDataGrid.datagrid('validateRow',editRow)){
				invoiceBDataGrid.datagrid('clearSelections').datagrid('endEdit',editRow);
				editRow = undefined;
			}else{
				return;	
			}
		}
		$('#invoiceBDataGrid').datagrid('insertRow', {
			row : {}
		});
	}
	/**
	* 暂时没有想到更好的办法，只能一次允许删除一行
	*/
	deleteRow = function(){
		if(editRow != undefined){
			if(invoiceBDataGrid.datagrid('validateRow',editRow)){
				invoiceBDataGrid.datagrid('endEdit',editRow);	
			}else{
				invoiceBDataGrid.datagrid('cancelEdit',editRow);
			}
			invoiceBDataGrid.datagrid('deleteRow',editRow);
			editRow = undefined;
		}
	}
	endEditing = function(){
		if(editRow == undefined){
			return true;
		}
		if(invoiceBDataGrid.datagrid('validateRow',editRow)){
			invoiceBDataGrid.datagrid('unselectRow',editRow).datagrid('endEdit',editRow);	
			editRow = undefined;
			return true;
		}else{
			return false;
		}
	}
</script>
<div class="easyui-layout" data-options="fit:true,binvoice:false">
	<div data-options="region:'north',binvoice:false" title=""
		style="overflow: hidden; background: #eee;">
		<form id="form" method="post">
			<table align="center">
				<tr>
					<input name="id" style="display: none;" value="${invoiceHVO.id}">
					<input name="vbilltype" style="display: none;" value="${invoiceHVO.vbilltype}">
					<input name="alreadyout" style="display: none;" value="${invoiceHVO.alreadyout}">
					<input name="ntotaloutnum" style="display: none;" value="${invoiceHVO.ntotaloutnum}">
					<input name="ntotalnum" style="display: none;" value="${invoiceHVO.ntotalnum}">
				</tr>
				<tr>
					<th><spring:message code="cbilltype" /></th>
					<td><input name="cbilltype" class="easyui-combobox" data-options="readonly:true,required:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:50,url:'${pageContext.request.contextPath}/billtype/32'"
						value="${invoiceHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode"  class="easyui-textbox" data-options="readonly:true"
						value="${invoiceHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" class= "easyui-datebox" required ="required" data-options="readonly:true,editable:false" 
						value="${invoiceHVO.dbilldate}"></td>
					<th><spring:message code="customer" /></th>
					<td><input id="customer" name="customer" 
						value="${invoiceHVO.customer}"></td>
				</tr>
				<tr>
					<th><spring:message code="currency" /></th>
					<td><input id="currency" name="currency" 
						value="${invoiceHVO.currency}"></td>
					<th><spring:message code="ntotalmny" /></th>
					<td><input id="ntotalmny" name="ntotalmny" class="easyui-numberbox" data-options="readonly:true,precision:0" 
						value="${invoiceHVO.ntotalmny}"></td>
					<th><spring:message code="norigtaxmny" /></th>
					<td><input id="norigtaxmny"  name="norigtaxmny" class="easyui-numberbox" data-options="readonly:true,precision:0" 
						value="${invoiceHVO.norigtaxmny}"></td>
					<th><spring:message code="vbillstatus" /></th>
					<td><input name="vbillstatus" class="easyui-combobox"  data-options="readonly:true,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '1',value: '<spring:message code="approved" />'},{key: '1',value: '<spring:message code="synced" />'}],panelHeight:50" value="${invoiceHVO.vbillstatus}"></td>
				</tr>
				<tr>
					<th><spring:message code="client" /></th>
					<td><input name="client" class="easyui-textbox" data-options="readonly:true,"
						value="${invoiceHVO.client}"></td>
					<th><spring:message code="address" /></th>
					<td><input name="address" class="easyui-textbox" data-options="readonly:true,"
						value="${invoiceHVO.address}"></td>
					<th><spring:message code="tel" /></th>
					<td><input name="tel" class="easyui-textbox" data-options="readonly:true,"
						value="${invoiceHVO.tel}"></td>
					<th><spring:message code="memo" /></th>
					<td><input name="memo" class="easyui-textbox" data-options="readonly:true,"
						value="${invoiceHVO.memo}"></td>
				</tr>
				<tr>
					<th><spring:message code="cbalatype" /></th>
					<td><input id="cbalatype" name="cbalatype" value="${invoiceHVO.cbalatype}"></td>
						<th><spring:message code="vorderbillcode" /></th>
					<td><input name="vorderbillcode" class="easyui-textbox" data-options="readonly:true,"
						value="${invoiceHVO.vorderbillcode}"></td>
					<th><spring:message code="vsrcbilltype" /></th>
					<td><input id="vsrcbilltype" name="vsrcbilltype" class="easyui-combobox" data-options="readonly:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:50,url:'${pageContext.request.contextPath}/billtype/30'"
						value="${invoiceHVO.vsrcbilltype}"></td>
					<th><spring:message code="effectbillcode" /></th>
					<td><input name="effectbillcode" class="easyui-textbox" data-options="readonly:true,"
						value="${invoiceHVO.effectbillcode}"></td>
				</tr>
				<tr>
					<th><spring:message code="nsalemny" /></th>
					<td><input name="nsalemny" class="easyui-numberbox" data-options="precision:0,readonly:true" 
						value="${invoiceHVO.nsalemny}"></td>
						<th><spring:message code="ntotalrecemny" /></th>
					<td><input name="ntotalrecemny" class="easyui-numberbox" data-options="precision:0,readonly:true" 
						value="${invoiceHVO.ntotalrecemny}"></td>
					<th><spring:message code="retainage" /></th>
					<td><input id="retainage" name="retainage"  class="easyui-numberbox" data-options="readonly:true" 
						value="${invoiceHVO.retainage}"></td>
					<th><spring:message code="isdebt" /></th>
					<td><input name="isdebt" class="easyui-combobox" data-options="readonly:true,valueField:'value',textField:'text',panelHeight:50,data:[{value:0,text:'<spring:message code="no" />'},{value:1,text:'<spring:message code="yes" />'}]"
						value="${invoiceHVO.isdebt}"></td>
				</tr>
				<tr>
					<th><spring:message code="returnsale" /></th>
					<td><input name="returnsale" class="easyui-combobox" data-options="readonly:true,valueField:'value',textField:'text',panelHeight:50,data:[{value:0,text:'<spring:message code="no" />'},{value:1,text:'<spring:message code="yes" />'}]"
						value="${invoiceHVO.returnsale}"></td>
					<th><spring:message code="ntotalinvoicemny" /></th>
					<td><input name="ntotalinvoicemny" class="easyui-numberbox" data-options="readonly:true,precision:0" 
						value="${invoiceHVO.ntotalinvoicemny}"></td>
					<th><spring:message code="salesman" /></th>
					<td><input id="salesman" name="salesman" value="${invoiceHVO.salesman}"></td>
					<th><spring:message code="cdept" /></th>
					<td><input id="cdept" name="cdept" value="${invoiceHVO.cdept}"></td>
				</tr>
				<tr>
					<th><spring:message code="nexchangerate" /></th>
					<td><input name="nexchangerate" id="nexchangerate" class="easyui-numberbox" data-options="readonly:true,precision:4"
						value="${invoiceHVO.nexchangerate}"></td>
					<th><spring:message code="cbankid" /></th>
					<td><input id="cbankid" name="cbankid"
						value="${invoiceHVO.cbankid}"></td>
					<th><spring:message code="cashaccount" /></th>
					<td><input id="cashaccount" name="cashaccount"
						value="${invoiceHVO.cashaccount}"></td>
					<th><spring:message code="issync" /></th>
					<td><input name="issync" class="easyui-combobox" data-options="readonly:true,panelHeight:50,valueField: 'value',textField: 'text',data:[{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]"
						value="${invoiceHVO.issync}"></td>
				</tr>
				<tr>
					<td><input name="billmaker" style="display: none;"
						value="${invoiceHVO.billmaker}"></td>
					<td><input name="billmaketime"  style="display: none;"
						value="${invoiceHVO.billmaketime}"></td>
					<td><input name="modifier"  style="display: none;"
						value="${invoiceHVO.modifier}"></td>
					<td><input name="modifiedtime"  style="display: none;" 
						value="${invoiceHVO.modifiedtime}"></td>
					<td><input name="approver"  style="display: none;" 
						value="${invoiceHVO.approver}"></td>
					<td><input name="approvetime"  style="display: none;" 
						value="${invoiceHVO.approvetime}"></td>
				</tr>
				<tr>
					<td><input name="ts" style="display: none;"
						value="${invoiceHVO.ts}"></td>
					<td><input name="dr"  style="display: none;"
						value="${invoiceHVO.dr}"></td>
					<td><input name="vsrcid" style="display: none;"
						value="${invoiceHVO.vsrcid}"></td>
					<td><input name="vsrccode"  style="display: none;"
						value="${invoiceHVO.vsrccode}"></td>
					<td><input name="pkGroup"  style="display: none;"
						value="${invoiceHVO.pkGroup}"></td>
					<td><input name="pkOrg"  style="display: none;"
						value="${invoiceHVO.pkOrg}"></td>
				</tr>
				<tr>
					<td><input name="vdef1" style="display: none;"
						value="${invoiceHVO.vdef1}"></td>
					<td><input name="vdef2"  style="display: none;"
						value="${invoiceHVO.vdef2}"></td>
					<td><input name="vdef3" style="display: none;"
						value="${invoiceHVO.vdef3}"></td>
					<td><input name="vdef4"  style="display: none;"
						value="${invoiceHVO.vdef4}"></td>
					<td><input name="vdef5"  style="display: none;"
						value="${invoiceHVO.vdef5}"></td>
					<td><input name="vdef6"  style="display: none;"
						value="${invoiceHVO.vdef6}"></td>
					<td><input name="vdef7" style="display: none;"
						value="${invoiceHVO.vdef7}"></td>
					<td><input name="vdef8"  style="display: none;"
						value="${invoiceHVO.vdef8}"></td>
					<td><input name="vdef9" style="display: none;"
						value="${invoiceHVO.vdef9}"></td>
					<td><input name="vdef10"  style="display: none;"
						value="${invoiceHVO.vdef10}"></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',title:''" style="background: #eee;">
		<table id="invoiceBDataGrid"></table>
	</div>
</div>