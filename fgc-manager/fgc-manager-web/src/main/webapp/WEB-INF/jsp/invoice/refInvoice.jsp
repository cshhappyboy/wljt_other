<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript">
	var invoiceHDataGrid;
	var invoiceBDataGrid;
	var lastSelectRow;
	parent.$.modalDialog.change_invoice_id;
	$(function(){
		invoiceHDataGrid = $('#invoiceHDataGrid').datagrid({
			url : "${pageContext.request.contextPath}/invoice/allInvoice",
			fit : true,
			idField : 'id',
			pagination : true,
			singleSelect:true,
			selectOnCheck : true,
			checkOnSelect:true,
			pageSize : 50,
			rownumbers : true,
			pageList : [ 50, 100, 500, 1000, 2000 ],
			queryParams:parent.$.modalDialog.searchParam,
			frozenColumns:[[ {
				field : 'id',
				title : '<spring:message code="id" />',
				width : 120,
				checkbox : true,
				align : 'left',
				halign : 'center',
			}]],
			columns : [ [ {
				field : 'cbilltype',
				title : '<spring:message code="cbilltype" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'vbillcode',
				title : '<spring:message code="vbillcode" />',
				width : 150,
				align : 'left',
				halign : 'center',
			}, {
				field : 'dbilldate',
				title : '<spring:message code="dbilldate" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'customer',
				title : '<spring:message code="customer" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'currency',
				title : '<spring:message code="currency" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'ntotalmny',
				title : '<spring:message code="ntotalmny" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			}, {
				field : 'norigtaxmny',
				title : '<spring:message code="norigtaxmny" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			},{
				field : 'client',
				title : '<spring:message code="client" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'address',
				title : '<spring:message code="address" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'tel',
				title : '<spring:message code="tel" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'memo',
				title : '<spring:message code="memo" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'cbalatype',
				title : '<spring:message code="cbalatype" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'nexchangerate',
				title : '<spring:message code="nexchangerate" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'vbillstatus',
				title : '<spring:message code="vbillstatus" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter:function(value,row,index){
					if(value == 0){
						return '<spring:message code="free" />'
					}else if(value == 1){
						return '<spring:message code="approved" />'
					}
				}
			},  {
				field : 'nexchangerate',
				title : '<spring:message code="nexchangerate" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'vorderbillcode',
				title : '<spring:message code="vorderbillcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'effectbillcode',
				title : '<spring:message code="effectbillcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'nsalemny',
				title : '<spring:message code="nsalemny" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			}, {
				field : 'ntotalrecemny',
				title : '<spring:message code="ntotalrecemny" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			}, {
				field : 'retainage',
				title : '<spring:message code="retainage" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			}, {
				field : 'isdebt',
				title : '<spring:message code="isdebt" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter:function(value,row,index){
					if(value == 0){
						return '<spring:message code="no" />'
					}else if(value == 1){
						return '<spring:message code="yes" />'
					}
				}
			},{
				field : 'ntotalinvoicemny',
				title : '<spring:message code="ntotalinvoicemny" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			},{
				field : 'returnsale',
				title : '<spring:message code="returnsale" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter:function(value,row,index){
					if(value == 0){
						return '<spring:message code="no" />'
					}else if(value == 1){
						return '<spring:message code="yes" />'
					}
				}
			},{
				field : 'billmaker',
				title : '<spring:message code="billmaker" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'billmaketime',
				title : '<spring:message code="billmaketime" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'modifier',
				title : '<spring:message code="modifier" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'modifiedtime',
				title : '<spring:message code="modifiedtime" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'approver',
				title : '<spring:message code="approver" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'approvetime',
				title : '<spring:message code="approvetime" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'alreadyout',
				hidden:true,
			},{
				field : 'ntotaloutnum',
				hidden:true,
			},{
				field : 'ntotalnum',
				hidden:true,
			},{
				field : 'issync',
				title : '<spring:message code="issync" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter:function(value,row,index){
					if(value == 0){
						return '<spring:message code="no" />'
					}else if(value == 1){
						return '<spring:message code="yes" />'
					}
				}
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess:function(datas){
				if(datas.rows.length > 0){
					var id = datas.rows[0].id;
					invoiceBDataGrid.datagrid('load',{id:id});
				}else{
					invoiceBDataGrid.datagrid('load',{id:'-1'});
				}
				parent.$.messager.progress('close');
			},
			onSelect:function(index, row){
				parent.$.modalDialog.change_invoice_id = row.id;
				invoiceBDataGrid.datagrid('load',{id:row.id});
			},
		});
		invoiceBDataGrid = $('#invoiceBDataGrid').datagrid(
				{
					url:'${pageContext.request.contextPath}/invoice/qryInvoiceBVOs4Ref',
					singleSelect:true,
					selectOnCheck : false,
					checkOnSelect : false,
					idField : 'id',
					ctrlSelect:true,
					fit : true,
					rownumbers : true,
					frozenColumns:[[ {
						field : 'id',
						title : '<spring:message code="id" />',
						width : 120,
						checkbox : true,
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
					},{
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
					}, {
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
						field : 'vbdef4',
						title : '摘要',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
						field : 'sizecode',
						title : '<spring:message code="sizecode" />',
						width : 120,
						align : 'left',
						halign : 'center',
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
					}] ],
					onLoadSuccess:function(data){
						invoiceBDataGrid.datagrid('checkAll');
					},
					onBeforeLoad:function(param){
						var hid = param.id;
						if(hid){
							return true;
						}else{
							return false;
						}
					}
				});
		parent.$.modalDialog.change_invoiceb_datagrid = invoiceBDataGrid;
	});
	
</script>
	<div class="easyui-layout" data-options="fit : true,bInvoice : false">
		<div data-options="region:'north',bInvoice:false,split:true" style="height:50%;">
			<table id="invoiceHDataGrid"></table>
		</div>
		<div data-options="region:'center',bInvoice:false,split:true" style="height:50%;">
			<table id="invoiceBDataGrid"></table>
		</div>
	</div>
