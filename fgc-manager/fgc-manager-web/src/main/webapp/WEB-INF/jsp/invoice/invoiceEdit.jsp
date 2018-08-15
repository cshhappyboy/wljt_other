<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cbalatype;
	var cbankid;
	var cashaccount;
	var cdept;//部门
	var salesman;//业务员
	var currency;//币种字段
	var customer;//客户字段
	var invoiceBDataGrid;
	$(function() {
		parent.$.messager.progress('close');
		
		cbankid = $('#cbankid').textbox({
			editable:false,
			required:true,
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
					editable:false,
					required:true,
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
		
		salesman = $('#salesman').textbox({
			required:true,
			editable:false,
			onChange:function(newValue, oldValue){
				if(newValue){
					$.ajax({  
				         type : 'get',  
				          url : '${pageContext.request.contextPath}/psndoc/cdept/'+newValue,  
				          async : false,
				          success : function(result) {
								result = $.parseJSON(result);
								if(result.status == 200){
									var billtype = result.data;
									cdept.textbox('setValue',billtype.billtype_id);
									cdept.textbox('setText',billtype.billtype_name);
								}
				          }
				     });
				}
			},
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
			onChange:function(newValue, oldValue){
				if(newValue){
					$.ajax({  
				         type : 'get',  
				          url : '${pageContext.request.contextPath}/currency/adjustrate/'+newValue,  
				          async : false,
				          success : function(result) {
				        	  result = $.parseJSON(result);
				        	  	if(result.status == 200){
				        	  		$('#nexchangerate').numberbox('setValue',result.data);
				        	  	}
				        	  
				          }
				     });
				}
			},
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
			}else{
				cashaccount.textbox('setValue',null);
				cashaccount.textbox('disable');
			}
		}
		
		invoiceBDataGrid = $('#invoiceBDataGrid').datagrid(
				{
					url:'${pageContext.request.contextPath}/invoice/qryInvoiceBVOs?id=${billHid}',
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
						width : 120,
						align : 'left',
						hidden:true,
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
					},{
						field : 'materialcode',
						title : '<spring:message code="materialcode" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								required:true,
								icons: [{
									iconCls:'icon-search',
									handler: function(e){
										parent.$.refDialog({
											title : '<spring:message code="cmaterial" />',
											width : 700,
											height : 500,
											href : '${pageContext.request.contextPath}/pub/refTreeTablePage',
											onBeforeLoad:function(){
												parent.$.refDialog.refCmaterialDataURL = '${pageContext.request.contextPath}/cmaterial/data'
												parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cmaterial/class/data';
												parent.$.refDialog.datagrid = invoiceBDataGrid;
												parent.$.refDialog.datagrid.editRow = parent.$.modalDialog.last_edit_index;
											}
										});
								}}],
								onChange:function(newValue, oldValue){
									var srow = invoiceBDataGrid.datagrid('getSelected');
									if(newValue && srow){
										if(srow.materialcode == newValue){
											return;
										}
										$.ajax({  
									         type : 'get',  
									         url : '${pageContext.request.contextPath}/cmaterial/data?filterData='+newValue,    
									         async : false,
									         success : function(result) {
													result = $.parseJSON(result);
													var rindex = invoiceBDataGrid.datagrid('getRowIndex', srow);
													if(result.total == 1){
														var row = result.rows[0];
														
														var ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialcode'
														});
														if(ed){
															ed.target.textbox('setValue', row.code);
														}
														
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'cmaterial'
														});
														if(ed){
															ed.target.textbox('setValue', row.id);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialname'
														});
														if(ed){
															textbox = ed.target.textbox('textbox');
															textbox.val(row.name);
														}

														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialspec'
														});
														if(ed){
															ed.target.textbox('setValue',row.spec);
														}
												
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialtype'
														});
														if(ed){
															ed.target.textbox('setValue',row.type);
														}

														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'csaleunitid'
														});
														if(ed){
															ed.target.textbox('setValue', row.xiaoshoumeasdoc);
															textbox = ed.target.textbox('textbox');
															textbox.val(row.xiaoshoumeasdocname);
														}
														
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'castunitid'
														});
														if(ed){
															ed.target.textbox('setValue', row.fumeasdoc);
															textbox = ed.target.textbox('textbox');
															textbox.val(row.fumeasdocname);
														}

														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'vtransrate'
														});
														if(ed){
															ed.target.textbox('setValue', row.measrate);
														}
														
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'services'
														});
														if(ed){
															ed.target.combobox('setValue', row.fee);
															var delwarehouseED = invoiceBDataGrid.datagrid('getEditor', {
																index : rindex,
																field : 'delwarehousecode'
															});
															if(delwarehouseED && row.fee == 1){
															    delwarehouseED.target.textbox({required:false});
															}
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'vunitratio'
														});
														if(ed){
															ed.target.textbox('setValue', row.vunitratio);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'cunitid'
														});
														
														if(ed){
															ed.target.textbox('setValue', row.zhumeasdoc);
															textbox = ed.target.textbox('textbox');
															textbox.val(row.zhumeasdocname);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'sizecode'
														});
														if(ed){
															if(row.isBatch == 0){
																ed.target.textbox('readonly',true);
															}else{
																ed.target.textbox('readonly',false);
															}
														}
													}else{
														var ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'cmaterial'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialcode'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialname'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}

														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialspec'
														});
														if(ed){
															ed.target.textbox('setValue',null);
														}
												
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialtype'
														});
														if(ed){
															ed.target.textbox('setValue',null);
														}

														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'csaleunitid'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'castunitid'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}

														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'vtransrate'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'services'
														});
														if(ed){
															ed.target.textbox('setValue', null);
															var delwarehouseED = invoiceBDataGrid.datagrid('getEditor', {
																index : rindex,
																field : 'delwarehousecode'
															});
															delwarehouseED.target.textbox({required:true});
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'vunitratio'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'cunitid'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
													}
									          }
									     });
									}
								}
							}
						},
					}, {
						field : 'materialname',
						title : '<spring:message code="materialname" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
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
					columns : [ [{
						field : 'materialspec',
						title : '<spring:message code="materialspec" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
					}, {
						field : 'materialtype',
						title : '<spring:message code="materialtype" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
					},{
						field : 'csaleunitid',
						title : '<spring:message code="csaleunitid" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
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
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
					},{
						field : 'vbdef5',
						title : '<spring:message code="long*haut" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
							}
						}
					},{
						field : 'vbdef6',
						title : 'QTE',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'numberbox',
							options : {
							}
						}
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								required:true,
								onChange:function(newValue,oldValue){
									if(newValue){
										var row = invoiceBDataGrid.datagrid('getSelected');
										var rindex = invoiceBDataGrid.datagrid('getRowIndex', row);
										var vunitratio = row.vunitratio;
										if(!vunitratio){
											var vunitratioED = invoiceBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'vunitratio'
											});
											vunitratio = vunitratioED.target.textbox('getValue');
										}
										if(vunitratio){
											var nastnumED = invoiceBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nastnum'
											});
											var arr = vunitratio.split('/');
											var nastnum = $.MMNumberDiv(newValue,$.MMNumberDiv(arr[0],arr[1]));
											nastnumED.target.numberbox('setValue',nastnum);//计算数量
											
											var nmnyED = invoiceBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nmny'
											});
											var nmny = nmnyED.target.numberbox('getValue');
											if(nmny){
												var nsalepriceED = invoiceBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'nsaleprice'
												});
												nsalepriceED.target.numberbox('setValue',$.MMNumberDiv(nmny,newValue));
											}
											
											var noinvoicesalenum =  row.noinvoicesalenum;
											if(newValue > noinvoicesalenum){
		 										var salenumED = invoiceBDataGrid.datagrid('getEditor', {
		 											index : rindex,
		 											field : 'salenum'
		 										});
		 										salenumED.target.numberbox('setValue',noinvoicesalenum);
											}
										}	
									}
								}
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
							}
						},
					},{
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
		                editor : {
							type : 'numberbox',
							options : {
								required:true,
								onChange:function(newValue,oldValue){
									var row = invoiceBDataGrid.datagrid('getSelected');
									var rindex = invoiceBDataGrid.datagrid('getRowIndex', row);
									if(newValue){
										var nastnumED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nastnum'
										});
										var nastnum = nastnumED.target.numberbox('getValue');
										if(nastnum){
											var npriceED = invoiceBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nprice'
											});
											npriceED.target.numberbox('setValue',$.MMNumberDiv(newValue,nastnum));
										}
										var salenumED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'salenum'
										});
										var salenum = salenumED.target.numberbox('getValue');
										if(salenum){
											var nsalepriceED = invoiceBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nsaleprice'
											});
											nsalepriceED.target.numberbox('setValue',$.MMNumberDiv(newValue,salenum));
										}
									}
								}
							}
						}
					}, {
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
						editor : {
							type : 'numberbox',
							options : {
								required:true,
								readonly:true,
								onChange:function(newValue,oldValue){
// 									var row = invoiceBDataGrid.datagrid('getSelected');
// 									var rindex = invoiceBDataGrid.datagrid('getRowIndex', row);
									
// 									var salenumED = invoiceBDataGrid.datagrid('getEditor', {
// 										index : rindex,
// 										field : 'salenum'
// 									});
// 									var salenum = salenumED.target.numberbox('getValue');
// 									if(salenum){
// 										var nmnyED = invoiceBDataGrid.datagrid('getEditor', {
// 											index : rindex,
// 											field : 'nmny'
// 										});
// 										nmnyED.target.numberbox('setValue',$.MMNumberMul(newValue,salenum));//计算金额
// 									}
								}
							}
						},
					},{
						field : 'delwarehouse',
						width : 120,
						align : 'left',
						hidden:true,
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						}
					}, {
						field : 'delwarehousecode',
						title : '<spring:message code="delwarehouse" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								required:true,
								icons: [{
									iconCls:'icon-search',
									handler: function(e){
										parent.$.refDialog({
											title : '<spring:message code="delwarehouse" />',
											width : 700,
											height : 500,
											href : '${pageContext.request.contextPath}/pub/bodyPubRefPage',
											onBeforeLoad:function(){
												parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
												parent.$.refDialog.datagrid = invoiceBDataGrid;
												parent.$.refDialog.datagrid.editRow = parent.$.modalDialog.last_edit_index;
											}
										});
									},
								}],
								onChange:function(newValue, oldValue){
									var srow = invoiceBDataGrid.datagrid('getSelected');
									var rindex = invoiceBDataGrid.datagrid('getRowIndex', srow);
									if(srow.services && srow.services==1){
										var delwarehouseED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'delwarehousecode'
										});
									    delwarehouseED.target.textbox({required:false});
									}
									if(newValue){
										if(newValue == srow.delwarehousecode){
											return;
										}
										$.ajax({  
									         type : 'get',  
									         url : '${pageContext.request.contextPath}/storedoc/data?filterData='+newValue,    
									         async : false,
									         success : function(result) {
													result = $.parseJSON(result);
													if(result.total == 1){
														var row = result.rows[0];
														var ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'delwarehouse'
														});
														if(ed){
															ed.target.textbox('setValue', row.id);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'delwarehousecode'
														});
														if(ed){
															ed.target.textbox('initValue', row.name);
														}
													}else{
														var ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'delwarehouse'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = invoiceBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'delwarehousecode'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
													}
									          }
									     });
									}
								}
							}
						},
					} ,{
						field : 'cunitid',
						title : '<spring:message code="cunitid" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
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
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
								onChange:function(newValue,oldValue){
					                var row = invoiceBDataGrid.datagrid('getSelected');
									var rindex = invoiceBDataGrid.datagrid('getRowIndex', row);
									
									var nprice = row.nprice;
									if(nprice){
										var nmnyED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nmny'
										});
										nmnyED.target.numberbox('setValue',$.MMNumberMul(newValue,nprice));
									}
									//计算主数量
									var measrate =row.vtransrate;
									var measrateArray = measrate.split('/');
									measrate = $.MMNumberDiv(measrateArray[0],measrateArray[1]);
									if(measrate){
										var nnumED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nnum'
										});
										nnumED.target.numberbox('setValue',$.MMNumberMul(measrate,newValue));
									}
								}
							}
						}
					},{
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
							}
						}
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
		                editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
							}
						}
					},{
						field : 'sizecode',
						title : '<spring:message code="sizecode" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						}
					},{
						field : 'nexchangerate',
						title : '<spring:message code="nexchangerate" />',
						width : 120,
						align : 'left',
						halign : 'center',
						hidden:true,
						editor : {
							type : 'numberbox',
							options : {
								readonly:true,
							}
						}
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
		                editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						}
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
		                editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						}
					},  {
						field : 'cbalatype',
						title : '<spring:message code="cbalatype" />',
						width : 120,
						align : 'left',
						hidden:true,
						halign : 'center',
						editor : {
							type : 'combobox',
							options : {
								readonly:true,
							}
						}
					},{
						field : 'cashaccount',
						title : '<spring:message code="cashaccount" />',
						width : 120,
						align : 'left',
						hidden:true,
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
					},{
						field : 'cbankid',
						title : '<spring:message code="cbankid" />',
						width : 120,
						align : 'left',
						hidden:true,
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						},
					},{
						field : 'vtransrate',
						title : '<spring:message code="vtransrate" />',
						width : 120,
						align : 'left',
						halign : 'center',
						editor : {
							type : 'textbox',
							options : {
								readonly:true,
							}
						}
					},{
						field : 'norigmny',
						title : '<spring:message code="norigmny" />',
						width : 120,
						align : 'left',
						halign : 'center',
						hidden:true,
						editor : {
							type : 'numberbox',
							options : {

							}
						}
					},{
						field : 'localmoney',
						title : '<spring:message code="localmoney" />',
						width : 120,
						align : 'left',
						halign : 'center',
						hidden:true,
						editor : {
							type : 'numberbox',
							options : {

							}
						}
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
						editor : {
							type : 'combobox',
							options : {
								readonly:true,
								panelHeight:50,
								valueField: 'billtype_id',
								textField: 'billtype_name',
								data: [{
									billtype_id: '1001A110000000000Q17',
									billtype_name: '制作安装'
								},{
									billtype_id: '1001A110000000000Q18',
									billtype_name: '商品销售'
								}]
							}
						}
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
						editor : {
							type : 'combobox',
							options : {
								panelHeight:50,
								valueField: 'value',
								textField: 'text',
								data:[
								      {value:0,text:'<spring:message code="no" />'},
								      {value:1,text:'<spring:message code="yes" />'}
								],
								onChange:function(newValue,oldValue){
									if(newValue && newValue == 1){
										var row = invoiceBDataGrid.datagrid('getSelected');
										var rindex = invoiceBDataGrid.datagrid('getRowIndex', row);
										
										var nsalepriceED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nsaleprice'
										});
										nsalepriceED.target.numberbox('setValue',0);//单价
										var npriceED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nprice'
										});
										npriceED.target.numberbox('setValue',0);//计算金额
										
										var nmnyED = invoiceBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nmny'
										});
										nmnyED.target.numberbox('setValue',0);//计算金额
									}
								}
							},
							
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
								readonly:true,
								panelHeight:50,
								valueField: 'value',
								textField: 'text',
								data:[
								      {value:0,text:'<spring:message code="no" />'},
								      {value:1,text:'<spring:message code="yes" />'}
								],
								onSelect:function(record){
									var row = invoiceBDataGrid.datagrid('getSelected');
									var rindex = invoiceBDataGrid.datagrid('getRowIndex', row);
									var delwarehouseED = invoiceBDataGrid.datagrid('getEditor', {
										index : rindex,
										field : 'delwarehousecode'
									});
									if(record.value == 0){
										delwarehouseED.target.textbox({required:true});
									}else if(record.value == 1){
										delwarehouseED.target.textbox({required:false});
									}
								}
							}
						},
					},{
						field : 'vsrcid',
						hidden:true,
						editor : {
							type : 'textbox',
							options : {
							}
						}
					},{
						field : 'vsrcbid',
						hidden:true,
						editor : {
							type : 'textbox',
							options : {
							}
						}
					},{
						field : 'noutnum',
						hidden:true,
						editor : {
							type : 'textbox',
							options : {
							}
						}
					},{
						field : 'vbdef1',
						hidden:true,
						editor : {
							type : 'textbox',
							options : {
							}
						}
					},{
						field : 'vbdef2',
						hidden:true,
						editor : {
							type : 'textbox',
							options : {
							}
						}
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
							parent.$.modalDialog.last_edit_index = rowIndex;
						}
						else{
							invoiceBDataGrid.datagrid('clearSelections');
							invoiceBDataGrid.datagrid('selectRow',parent.$.modalDialog.last_edit_index);
						}
					},
				});
			parent.$.modalDialog.inner_datagrid = invoiceBDataGrid;
	});
	transData = function(datagrid,rowIndex,row){
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'materialcode'});
		if(row.vsrcbid){
			ed.target.textbox('readonly',true);
		}
		
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
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'cunitid'});
		if(row.cunitid){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/castunit/trans/'+row.cunitid,    
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
		
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'customer'});
		if(row.customer){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/customer/trans/'+row.customer,
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
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'currency'});
		if(row.currency){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/currency/trans/'+row.currency,
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
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'services'});
		if(row.services&& row.services == 1){
			ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'delwarehousecode'});
			ed.target.textbox({required:false});
		}
	}
	
	addRow = function() {
		if(parent.$.modalDialog.last_edit_index != undefined){
			if(invoiceBDataGrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
				invoiceBDataGrid.datagrid('clearSelections').datagrid('endEdit',parent.$.modalDialog.last_edit_index);
				parent.$.modalDialog.last_edit_index = undefined;
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
		if(parent.$.modalDialog.last_edit_index != undefined){
			if(invoiceBDataGrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
				invoiceBDataGrid.datagrid('endEdit',parent.$.modalDialog.last_edit_index);	
			}else{
				invoiceBDataGrid.datagrid('cancelEdit',parent.$.modalDialog.last_edit_index);
			}
			invoiceBDataGrid.datagrid('deleteRow',parent.$.modalDialog.last_edit_index);
			parent.$.modalDialog.last_edit_index = undefined;
		}
	}
	endEditing = function(){
		if(parent.$.modalDialog.last_edit_index == undefined){
			return true;
		}
		if(invoiceBDataGrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
			invoiceBDataGrid.datagrid('endEdit',parent.$.modalDialog.last_edit_index);	
			parent.$.modalDialog.last_edit_index = undefined;
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
					<input name="vsrcbilltypecode" style="display: none;" value="${invoiceHVO.vsrcbilltypecode}">
				</tr>
				<tr>
					<th><spring:message code="cbilltype" /></th>
					<td><input name="cbilltype" class="easyui-combobox" data-options="editable:false,required:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:50,url:'${pageContext.request.contextPath}/billtype/32'"
						value="${invoiceHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode"  class="easyui-textbox" data-options="readonly:true"
						value="${invoiceHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" class= "easyui-datebox" required ="required" data-options="editable:false" 
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
					<td><input name="client" class="easyui-textbox" 
						value="${invoiceHVO.client}"></td>
					<th><spring:message code="address" /></th>
					<td><input name="address" class="easyui-textbox" 
						value="${invoiceHVO.address}"></td>
					<th><spring:message code="tel" /></th>
					<td><input name="tel" class="easyui-textbox" 
						value="${invoiceHVO.tel}"></td>
					<th><spring:message code="memo" /></th>
					<td><input name="memo" class="easyui-textbox" 
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
					<td><input name="isdebt" class="easyui-combobox" data-options="editable:false,valueField:'value',textField:'text',panelHeight:50,data:[{value:0,text:'<spring:message code="no" />'},{value:1,text:'<spring:message code="yes" />'}]"
						value="${invoiceHVO.isdebt}"></td>
				</tr>
				<tr>
					<th><spring:message code="returnsale" /></th>
					<td><input name="returnsale" class="easyui-combobox" data-options="readonly:true,valueField:'value',textField:'text',panelHeight:50,data:[{value:0,text:'<spring:message code="no" />'},{value:1,text:'<spring:message code="yes" />'}]"
						value="${invoiceHVO.returnsale}"></td>
					<th><spring:message code="ntotalinvoicemny" /></th>
					<td><input name="ntotalinvoicemny" class="easyui-numberbox" data-options="precision:0" 
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
	<div id="toolbar" style="display: none;">
<!-- 		<div onclick="addRow();" class="easyui-linkbutton" -->
<!-- 			data-options="plain:true,iconCls:'pencil_add'"> -->
<%-- 			<spring:message code="add_line" /> --%>
<!-- 		</div> -->
		<div onclick="deleteRow();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_delete'">
			<spring:message code="delete_line" />
		</div>

	</div>
</div>