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
	$(function() {
		
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
									// var billtype = $.parseJSON(result.data);
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
		
		customer = $('#customer').textbox({
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
			} ],
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
					selectOnCheck : false,
					checkOnSelect : false,
					idField : 'id',
					fit : true,
					rownumbers : true,
					data :$.parseJSON('${orderBVOs}'),
					frozenColumns:[[ {
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
												parent.$.refDialog.datagrid = orderBDataGrid;
												parent.$.refDialog.datagrid.editRow = parent.$.modalDialog.last_edit_index;
											}
										});
								}}],
								onChange:function(newValue, oldValue){
									var srow = orderBDataGrid.datagrid('getSelected');
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
													var rindex = orderBDataGrid.datagrid('getRowIndex', srow);
													if(result.total == 1){
														var row = result.rows[0];
														
														var ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialcode'
														});
														if(ed){
															ed.target.textbox('setValue', row.code);
														}
														
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'cmaterial'
														});
														if(ed){
															ed.target.textbox('setValue', row.id);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialname'
														});
														if(ed){
															textbox = ed.target.textbox('textbox');
															textbox.val(row.name);
														}

														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialspec'
														});
														if(ed){
															ed.target.textbox('setValue',row.spec);
														}
												
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialtype'
														});
														if(ed){
															ed.target.textbox('setValue',row.type);
														}

														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'csaleunitid'
														});
														if(ed){
															ed.target.textbox('setValue', row.xiaoshoumeasdoc);
															textbox = ed.target.textbox('textbox');
															textbox.val(row.xiaoshoumeasdocname);
														}
														
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'castunitid'
														});
														if(ed){
															ed.target.textbox('setValue', row.fumeasdoc);
															textbox = ed.target.textbox('textbox');
															textbox.val(row.fumeasdocname);
														}

														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'measrate'
														});
														if(ed){
															ed.target.textbox('setValue', row.measrate);
														}
														
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'services'
														});
														if(ed){
															ed.target.combobox('setValue', row.fee);
															var delwarehouseED = orderBDataGrid.datagrid('getEditor', {
																index : rindex,
																field : 'delwarehousecode'
															});
															if(delwarehouseED && row.fee == 1){
															    delwarehouseED.target.textbox({required:false});
															}
														}
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'vunitratio'
														});
														if(ed){
															ed.target.textbox('setValue', row.vunitratio);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'cunitid'
														});
														
														if(ed){
															ed.target.textbox('setValue', row.zhumeasdoc);
															textbox = ed.target.textbox('textbox');
															textbox.val(row.zhumeasdocname);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
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
														var ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'cmaterial'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialcode'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialname'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}

														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialspec'
														});
														if(ed){
															ed.target.textbox('setValue',null);
														}
												
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'materialtype'
														});
														if(ed){
															ed.target.textbox('setValue',null);
														}

														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'csaleunitid'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'castunitid'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}

														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'measrate'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'services'
														});
														if(ed){
															ed.target.textbox('setValue', null);
															var delwarehouseED = orderBDataGrid.datagrid('getEditor', {
																index : rindex,
																field : 'delwarehousecode'
															});
															delwarehouseED.target.textbox({required:true});
														}
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'vunitratio'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
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
					},{
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
						field : 'vbdef1',
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
						field : 'vbdef2',
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
									var row = orderBDataGrid.datagrid('getSelected');
									var rindex = orderBDataGrid.datagrid('getRowIndex', row);
									var vunitratio = row.vunitratio;
									if(!vunitratio){
										var vunitratioED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'vunitratio'
										});
										vunitratio = vunitratioED.target.textbox('getValue');
									}
									if(vunitratio){
										var vunitratioarray = vunitratio.split('/');
										vunitratio = $.MMNumberDiv(vunitratioarray[0],vunitratioarray[1])
										var numED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nastnum'
										});
										numED.target.numberbox('setValue',$.MMNumberDiv(newValue,vunitratio));//计算数量
										
										var nmnyED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nmny'
										});
										var nmny = nmnyED.target.numberbox('getValue');
										if(nmny){
											var nsalepriceED = orderBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nsaleprice'
											});
											nsalepriceED.target.numberbox('setValue',$.MMNumberDiv(nmny,newValue));//计算金额
										}
									}
								}
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
									 	var row = orderBDataGrid.datagrid('getSelected');
										var rindex = orderBDataGrid.datagrid('getRowIndex', row);
										var numED = orderBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nastnum'
										});
										var num = numED.target.numberbox('getValue');
										if(num){
											var npriceED = orderBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nprice'
											});
											npriceED.target.numberbox('setValue',$.MMNumberDiv(newValue,num));
										}
										
										var salenumED = orderBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'salenum'
										});
										var salenum = salenumED.target.numberbox('getValue');
										if(salenum){
											var nsalepriceED = orderBDataGrid.datagrid('getEditor', {
												index : rindex,
												field : 'nsaleprice'
											});
											nsalepriceED.target.numberbox('setValue',$.MMNumberDiv(newValue,salenum));
										}
								}
							}
						}
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
												parent.$.refDialog.datagrid = orderBDataGrid;
												parent.$.refDialog.datagrid.editRow = parent.$.modalDialog.last_edit_index;
											}
										});
									},
								}],
								onChange:function(newValue, oldValue){
									var srow = orderBDataGrid.datagrid('getSelected');
									var rindex = orderBDataGrid.datagrid('getRowIndex', srow);
									if(srow.services && srow.services==1){
										var delwarehouseED = orderBDataGrid.datagrid('getEditor', {
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
														var ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'delwarehouse'
														});
														if(ed){
															ed.target.textbox('setValue', row.id);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'delwarehousecode'
														});
														if(ed){
															ed.target.textbox('initValue', row.name);
														}
													}else{
														var ed = orderBDataGrid.datagrid('getEditor', {
															index : rindex,
															field : 'delwarehouse'
														});
														if(ed){
															ed.target.textbox('setValue', null);
														}
														ed = orderBDataGrid.datagrid('getEditor', {
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
						title : '<spring:message code="num" />',
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
								readonly:true,
								onChange:function(newValue,oldValue){
					                var row = orderBDataGrid.datagrid('getSelected');
									var rindex = orderBDataGrid.datagrid('getRowIndex', row);
									var nmnyED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nmny'
									});
									var nmny = nmnyED.target.numberbox('getValue');
									if(nmny){
										var npriceED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nprice'
										});
										npriceED.target.numberbox('setValue',$.MMNumberDiv(nmny,newValue));
									}
									//计算主数量
									var measrateED = orderBDataGrid.datagrid('getEditor', {
										index : rindex,
										field : 'measrate'
									});
									var measrate = measrateED.target.numberbox('getValue');
									var measrateArray = measrate.split('/');
									measrate = $.MMNumberDiv(measrateArray[0],measrateArray[1]);
									if(measrate){
										var nnumED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nnum'
										});
										nnumED.target.numberbox('setValue',$.MMNumberMul(measrate,newValue));
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
		                        return parseFloat(value).toFixed(0);
		                    }
		                },
						editor : {
							type : 'numberbox',
							options : {
								readonly:true,
								required:true,
								onChange:function(newValue,oldValue){
// 									var row = orderBDataGrid.datagrid('getSelected');
// 									var rindex = orderBDataGrid.datagrid('getRowIndex', row);
									
// 									var salenumED = orderBDataGrid.datagrid('getEditor', {
// 										index : rindex,
// 										field : 'salenum'
// 									});
// 									var salenum = salenumED.target.numberbox('getValue');
// 									if(salenum){
// 										var nmnyED = orderBDataGrid.datagrid('getEditor', {
// 											index : rindex,
// 											field : 'nmny'
// 										});
// 										nmnyED.target.numberbox('setValue',$.MMNumberMul(newValue,salenum));//计算金额
// 									}
								}
							}
						},
					}, {
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
						editor : {
							type : 'numberbox',
							options : {
								required:true,
								precision:4,
								readonly:true,
							}
						}
					} , {
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
					}, {
						field : 'nexchangerate',
						title : '<spring:message code="nexchangerate" />',
						width : 120,
						align : 'left',
						halign : 'center',
						hidden:true,
						editor : {
							type : 'textbox',
							options : {

							}
						}
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
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
						editor : {
							type : 'numberbox',
							options : {
								readonly:true,
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
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
								readonly:true,
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
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
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
								readonly:true,
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
								onSelect:function(record){
									if(record && record.value == 1){
										var row = orderBDataGrid.datagrid('getSelected');
										var rindex = orderBDataGrid.datagrid('getRowIndex', row);
										
										var nsalepriceED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nsaleprice'
										});
										nsalepriceED.target.numberbox('setValue',0);//单价
										
										var npriceED = orderBDataGrid.datagrid('getEditor', {
											index : rindex,
											field : 'nprice'
										});
										npriceED.target.numberbox('setValue',0);//计算金额
										
										var nmnyED = orderBDataGrid.datagrid('getEditor', {
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
							}
							
						},
						formatter:function(value,row,index){
							if(value == 0){
								return '<spring:message code="no" />'
							}else if(value == 1){
								return '<spring:message code="yes" />'
							}
						}
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
						field : 'cunitid',
						hidden:true,
						editor : {
							type : 'textbox',
							options : {
							}
						}
					},{
						field : 'nnum',
						hidden:true,
						editor : {
							type : 'numberbox',
							options : {
								precision:4,
							}
						}
					},{
						field : 'measrate',
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
					}] ],
					toolbar : '#toolbar',
					onClickRow : function(rowIndex, row) {//编辑行
						if(endEditing()){
							orderBDataGrid.datagrid('beginEdit',rowIndex);
							transData(orderBDataGrid,rowIndex,row);
							parent.$.modalDialog.last_edit_index = rowIndex;
						}
						else{
							orderBDataGrid.datagrid('clearSelections');
							orderBDataGrid.datagrid('selectRow',parent.$.modalDialog.last_edit_index);
						}
					},
					onLoadSuccess:function(datas){
						parent.$.messager.progress('close');
					},
				});
			parent.$.modalDialog.inner_datagrid = orderBDataGrid;
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
		if(parent.$.modalDialog.last_edit_index != undefined){
			if(orderBDataGrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
				orderBDataGrid.datagrid('clearSelections').datagrid('endEdit',parent.$.modalDialog.last_edit_index);	
				parent.$.modalDialog.last_edit_index = undefined;
			}else{
				return;	
			}
		}
		$('#orderBDataGrid').datagrid('insertRow', {
			row : {}
		});
	}
	/**
	* 暂时没有想到更好的办法，只能一次允许删除一行
	*/
	deleteRow = function(){
		if(parent.$.modalDialog.last_edit_index != undefined){
			if(orderBDataGrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
				orderBDataGrid.datagrid('endEdit',parent.$.modalDialog.last_edit_index);	
			}else{
				orderBDataGrid.datagrid('cancelEdit',parent.$.modalDialog.last_edit_index);
			}
			orderBDataGrid.datagrid('deleteRow',parent.$.modalDialog.last_edit_index);
			parent.$.modalDialog.last_edit_index = undefined;
		}
	}
	endEditing = function(){
		if(parent.$.modalDialog.last_edit_index == undefined){
			return true;
		}
		if(orderBDataGrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
			orderBDataGrid.datagrid('endEdit',parent.$.modalDialog.last_edit_index);	
			parent.$.modalDialog.last_edit_index = undefined;
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
					<td><input name="cbilltype" class="easyui-combobox" data-options="required:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:115,url:'${pageContext.request.contextPath}/billtype/30'"
						value="${orderHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode"  class="easyui-textbox" 
						value="${orderHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" type= "text" class= "easyui-datebox"  data-options="required:true,editable:false" 
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
					<td><input name="client" class="easyui-textbox" value="${orderHVO.client}"></td>
				</tr>
				<tr>
					<th><spring:message code="address" /></th>
					<td><input name="address" class="easyui-textbox" 
						value="${orderHVO.address}"></td>
					<th><spring:message code="tel" /></th>
					<td><input name="tel" class="easyui-textbox" 
						value="${orderHVO.tel}"></td>
					<th><spring:message code="memo" /></th>
					<td><input name="memo" class="easyui-textbox" 
						value="${orderHVO.memo}"></td>
					<th><spring:message code="cbalatype" /></th>
					<td><input name="cbalatype" class="easyui-combobox" data-options="editable:false,required:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:48,url:'${pageContext.request.contextPath}/cbalatype/data'"
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
					<td><input name="nexchangerate" id="nexchangerate" class="easyui-numberbox" data-options="required:true,readonly:true,precision:4"
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
	<div id="toolbar" style="display: none;">
		<div onclick="addRow();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">
			<spring:message code="add_line" />
		</div>
		<div onclick="deleteRow();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_delete'">
			<spring:message code="delete_line" />
		</div>

	</div>
</div>