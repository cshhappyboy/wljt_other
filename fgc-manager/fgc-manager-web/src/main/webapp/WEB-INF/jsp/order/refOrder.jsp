<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var orderHDataGrid;
	var orderBDataGrid;
	parent.$.modalDialog.change_order_id;
	$(function() {
		orderHDataGrid = $('#orderHDataGrid').datagrid({
			url : "${pageContext.request.contextPath}/order/allOrder",
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
				field : 'salesman',
				title : '<spring:message code="salesman" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'cdept',
				title : '<spring:message code="cdept" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'ntotalnum',
				title : '<spring:message code="ntotalnum" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(4);
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
			}, {
				field : 'nreceivedmny',
				title : '<spring:message code="nreceivedmny" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
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
			}, {
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
				field : 'ntotalinvoicenum',
				hidden:true,
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(4);
                    }
                },
			},{
				field : 'effectbillcode',
				title : '<spring:message code="effectbillcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'alreadyinvoice',
				hidden:true,
			},{
				field : 'alreadyin',
				hidden:true,
			},{
				field : 'alreadyrevise',
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
			}, {
				field : 'reviser',
				title : '<spring:message code="reviser" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'revisetime',
				title : '<spring:message code="revisetime" />',
				width : 120,
				align : 'left',
				halign : 'center',
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess:function(datas){
				if(datas.rows.length > 0){
					orderHDataGrid.datagrid('checkRow',0);
					parent.$.modalDialog.searchParam.id = datas.rows[0].id;
					var param = parent.$.modalDialog.searchParam;
					orderBDataGrid.datagrid('load',param);
				}else{
					orderBDataGrid.datagrid('load',{id:'-1'});
				}
				parent.$.messager.progress('close');
			},
			onSelect:function(index, row){
				parent.$.modalDialog.change_order_id = row.id;
				parent.$.modalDialog.searchParam.id = row.id;
				var param = parent.$.modalDialog.searchParam;
				orderBDataGrid.datagrid('load',param);
			}
		});
		orderBDataGrid = $('#orderBDataGrid').datagrid(
				{
					url:'${pageContext.request.contextPath}/order/qryOrderBVOs4Ref',
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
					columns : [ [{
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
						
					}, {
						field : 'nexchangerate',
						title : '<spring:message code="nexchangerate" />',
						width : 120,
						align : 'left',
						halign : 'center',
					},{
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
						}
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
						}
					} ] ],
					onLoadSuccess:function(data){
						orderBDataGrid.datagrid('checkAll');
					},
					onBeforeLoad:function(param){
						var hid = param.id;
						if(hid){
							return true;
						}else{
							return false;
						}
					},
				});
		parent.$.modalDialog.change_orderb_datagrid = orderBDataGrid;
	});

	
	
	
</script>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border:false,split:true" style="height:50%;">
			<table id="orderHDataGrid"></table>
		</div>
		<div data-options="region:'center',border:false,split:true" style="height:50%;">
			<table id="orderBDataGrid"></table>
		</div>
	</div>
