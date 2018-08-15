<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	var orderHDataGrid;
	var orderBDataGrid;
	$(function() {
		orderHDataGrid = $('#orderHDataGrid').datagrid({
			url : "${pageContext.request.contextPath}/order/allOrder",
			fit : true,
			idField : 'id',
			pagination : true,
			singleSelect:true,
			selectOnCheck : false,
			checkOnSelect:false,
			pageSize : 50,
			rownumbers : true,
			pageList : [ 50, 100, 500, 1000, 2000 ],
			frozenColumns:[[{
				field : 'id',
				title : '<spring:message code="id" />',
				width : 120,
				checkbox : true,
				align : 'left',
				halign : 'center',
			},{
				field : 'background',
				width : 30,
				align : 'left',
				halign : 'center',
				formatter : function(value, row, index) {
					var str = '';
					if(row.vbillstatus == 1){
						str += '<img src="${pageContext.request.contextPath}/style/images/extjs_icons/tick.png" title="<spring:message code="approved" />" /> ';
					}else if(row.vbillstatus == 2){
						str += '<img src="${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png" title="作废" /> ';
					}
					return str;
				}
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
					}else if(value == 2){
						return '作废'
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
			}, {
				field : 'vdef1',
				title : '真实同步标识',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter:function(value,row,index){
					if(value == 1){
						return '<spring:message code="yes" />'
					}
				}
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess:function(datas){
				if(datas.rows.length > 0){
					var id = datas.rows[0].id;
					orderBDataGrid.datagrid('load',{id:id});
				}else{
					orderBDataGrid.datagrid('load',{id:'-1'});
				}
				parent.$.messager.progress('close');
			},
			onSelect:function(index, row){
				orderBDataGrid.datagrid('load',{id:row.id});
			},
			onBeforeLoad:function(param){
				parent.$.messager.progress('close');
				if(param && param.query_flag){
					return true;
				}else{
					return false;
				}
			},
			onRowContextMenu : function(e, index, row) {
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow', index);
				$(this).datagrid('uncheckAll');
				$(this).datagrid('checkRow', index);
				$("#menu").menu('show', {
					left : e.pageX,
					top : e.pageY,
				});
			},
			
		});
		orderBDataGrid = $('#orderBDataGrid').datagrid(
				{
					url:'${pageContext.request.contextPath}/order/qryOrderBVOs',
					selectOnCheck : false,
					checkOnSelect : false,
					idField : 'id',
					ctrlSelect:true,
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
					}, {
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
					onBeforeLoad:function(param){
						var hid = param.id;
						if(hid){
							return true;
						}else{
							return false;
						}
					}
				});
	});

	addOrder = function() {
		parent.$.modalDialog({
			title : '<spring:message code="add_order_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/order/orderAdd',
			onBeforeLoad:function(){
				parent.$.modalDialog.last_edit_index = undefined;
			},
			toolbar : [ {
				text : '<spring:message code="save" />',
				iconCls : 'page_save',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					if(parent.$.modalDialog.last_edit_index != undefined){
						if(parent.$.modalDialog.inner_datagrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
							parent.$.modalDialog.inner_datagrid.datagrid('endEdit',
									parent.$.modalDialog.last_edit_index);//将最后一行 置为非编辑态，编辑态的数据获取不到
							parent.$.modalDialog.last_edit_index = undefined;
						}else{
							parent.$.messager.progress('close');
							return;
						}
					}
					//获取表头数据
					var headForm = parent.$.modalDialog.handler.find('#form');
					if(headForm.form('validate')){//校验表头必输项
						var rows = parent.$.modalDialog.inner_datagrid.datagrid('getRows');
						if(rows.length <= 0){
							parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
							parent.$.messager.progress('close');
							return;
						}
						var headData = $.serializeObject(headForm);
						//获取表体新增行数据
						var newRowDatas = parent.$.modalDialog.inner_datagrid
								.datagrid('getChanges', "inserted");
						//将表头表体数据封装为一个json，通过ajax传给后台一起保存
						var data = new Object();
						data["head"] = JSON.stringify(headData);
						var rowDatas = [];//用来保存行上物料字段有值的行数据
						for(var row = 0;row <newRowDatas.length;row++){
							var cmaterial = newRowDatas[row].cmaterial;
							if(cmaterial){
								rowDatas.push(newRowDatas[row]);
							}
						}
						if(rowDatas.length <= 0){
							parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
							parent.$.messager.progress('close');
							return;
						}
						data["insertBodys"] = JSON.stringify(rowDatas);
						$.post('${pageContext.request.contextPath}/order/save',
						data, function(result) {
							result = $.parseJSON(result);
							if(result.status==200){
								parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
								parent.$.modalDialog.handler.dialog('close');
								editOrder(result.data);
								orderHDataGrid.datagrid('load');
								orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								parent.$.messager.progress('close');
							}else{
						   		parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
						   		parent.$.messager.progress('close');
							}
						});
					}else{
						parent.$.messager.progress('close');
					}
				}
			} ]
		});
	}
	showDetail = function(id){
		if(id == undefined){
			var rows = orderHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			id = rows[0].id;
		}else{
			id = id;
		}
		parent.$.modalDialog({
			title : '<spring:message code="order_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/order/orderCard?id='+id,
		});
	}
	editOrder = function(id){
		if(id == undefined){
			var rows = orderHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbillstatus == 1){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="already_approve_edit_error" />', 'warning');
				return;
			}
			id = rows[0].id;
		}else{
			id = id;
		}
		parent.$.modalDialog({
				title : '<spring:message code="edit_order_bill" />',
				width : 1200,
				height : 600,
				href : '${pageContext.request.contextPath}/order/orderEdit?id='+id,
				onBeforeLoad:function(){
					parent.$.modalDialog.last_edit_index = undefined;
				},
				toolbar : [ {
					text : '<spring:message code="save" />',
					iconCls : 'page_save',
					handler : function() {
						parent.$.messager.progress({
							title : '<spring:message code="hint" />',
							text : '<spring:message code="pleaseWait" />'
						});
// 						var lastEditRow = parent.$.modalDialog.last_edit_index;//得到最后编辑行
						if(parent.$.modalDialog.last_edit_index != undefined){
							if(parent.$.modalDialog.inner_datagrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
								parent.$.modalDialog.inner_datagrid.datagrid('endEdit',
										parent.$.modalDialog.last_edit_index);//将最后一行 置为非编辑态，编辑态的数据获取不到
								parent.$.modalDialog.last_edit_index = undefined;
							}else{
								parent.$.messager.progress('close');
								return;
							}
						}
						//获取表头数据
						var headForm = parent.$.modalDialog.handler.find('#form');
						if(headForm.form('validate')){//校验表头必输项
							var rows = parent.$.modalDialog.inner_datagrid.datagrid('getRows');
							var bodyRows = [];
							if(rows.length <= 0){
								parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
								parent.$.messager.progress('close');
								return;
							}
							for(var row = 0;row <rows.length;row++){
								var cmaterial = rows[row].cmaterial;
								if(cmaterial){
									bodyRows.push(rows[row]);
								}
							}
							
							if(bodyRows.length <= 0){
								parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
								parent.$.messager.progress('close');
								return;
							}
							var headData = $.serializeObject(headForm);
								//获取表体新增行数据
							var newRowDatas = parent.$.modalDialog.inner_datagrid
									.datagrid('getChanges', "inserted");
								//获取表体修改行数据
							var updateRowDatas = parent.$.modalDialog.inner_datagrid
									.datagrid('getChanges', "updated");
								//获取表体删除行数据
							var deleteRowDatas = parent.$.modalDialog.inner_datagrid
									.datagrid('getChanges', "deleted");
								//将表头表体数据封装为一个json，通过ajax传给后台一起保存
							var data = new Object();
							data["head"] = JSON.stringify(headData);
							var rowDatas = [];//用来保存行上物料字段有值的行数据
							if (newRowDatas.length) {
								for(var row = 0;row <newRowDatas.length;row++){
									var cmaterial = newRowDatas[row].cmaterial;
									if(cmaterial){
										rowDatas.push(newRowDatas[row]);
									}
								}
								data["insertBodys"] = JSON.stringify(rowDatas);
							}
							if (updateRowDatas.length) {
								data["updateBodys"] = JSON.stringify(updateRowDatas);
							}
							if (deleteRowDatas.length) {
								data["deleteBodys"] = JSON.stringify(deleteRowDatas);
							}
							data["realyBodys"]  = JSON.stringify(rows);
							$.post('${pageContext.request.contextPath}/order/update',
									data, function(result) {
										result = $.parseJSON(result);
										if(result.status==200){
											parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
											parent.$.modalDialog.handler.dialog('close');
											editOrder(result.data);
											orderHDataGrid.datagrid('load');
											orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
											parent.$.messager.progress('close');
										}else{
											parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
											parent.$.messager.progress('close');
										}
								});
							}else{
								parent.$.messager.progress('close');
							}
					}
				} ]
		});
	}
	deleteOrder = function() {
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_approve_delete_error" />');
				}
				var idts = {id:rows[i].id,ts:rows[i].ts};
				data.push(idts);
			}
			if(vbillmsg.length > 0){
				parent.$.messager.alert('<spring:message code="hint" />', vbillmsg.join(','), 'error');
				parent.$.messager.progress('close');
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifDelete" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/batchDelete', dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							orderHDataGrid.datagrid('load');
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	
	approveOrder = function(){
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_approve_approve_error" />');
				}
				var idts = {id:rows[i].id,ts:rows[i].ts};
				data.push(idts);
			}
			if(vbillmsg.length > 0){
				parent.$.messager.alert('<spring:message code="hint" />', vbillmsg.join(','), 'error');
				parent.$.messager.progress('close');
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifApprove" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/batchApprove',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							orderHDataGrid.datagrid('load');
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	
	handApproveOrder = function(){
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_approve_approve_error" />');
				}
				var idts = {id:rows[i].id,ts:rows[i].ts};
				data.push(idts);
			}
			if(vbillmsg.length > 0){
				parent.$.messager.alert('<spring:message code="hint" />', vbillmsg.join(','), 'error');
				parent.$.messager.progress('close');
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifApprove" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/handBatchApprove',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							orderHDataGrid.datagrid('load');
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	
	unApproveOrder = function(){
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus != 1){
					return;
				}
				if(rows[i].issync == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_issync_unapprove_error" />');
				}else if(rows[i].vbilltype != '30-02' && rows[i].returnsale == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_returnsale_unapprove_error" />');
				}else if(rows[i].alreadyinvoice == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_invoice_unapprove_error" />');
				}else if(rows[i].alreadyin == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_in_unapprove_error" />');
				}else if(rows[i].alreadyrevise == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_revise_unapprove_error" />');
				}else if(rows[i].nreceivedmny > 0){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_receipt_unapprove_error" />');
				}
				var idts = {id:rows[i].id,ts:rows[i].ts};
				data.push(idts);
			}
			if(vbillmsg.length > 0){
				parent.$.messager.alert('<spring:message code="hint" />', vbillmsg.join(','), 'error');
				parent.$.messager.progress('close');
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifUnApprove" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/batchUnApprove', dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							orderHDataGrid.datagrid('load');
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	
	receiptOrder = function(){
		var id;
		if(id == undefined){
			var rows = orderHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbillstatus != 1){
				return;
			}
			if(rows[0].vbilltype !=  '30-Cxx-1' && rows[0].vbilltype !=  '30-Cxx-3'){
				return;
			}
			if(rows[0].norigtaxmny <= rows[0].nreceivedmny){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="norigtaxmny_nreceivedmny_receipt" />', 'warning');
				return;
			}
			id = rows[0].id;
		}
		parent.$.modalDialog({
			title : '<spring:message code="add_receipt_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/receipt/orderPushReceipt?id='+id,
			toolbar : [ {
				text : '<spring:message code="save" />',
				iconCls : 'page_save',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					//获取表头数据
					var headForm = parent.$.modalDialog.handler.find('#form');
					if(headForm.form('validate')){//校验表头必输项
						var headData = $.serializeObject(headForm);
						//将表头表体数据封装为一个json，通过ajax传给后台一起保存
						var data = new Object();
						data["head"] = JSON.stringify(headData);
						$.post('${pageContext.request.contextPath}/receipt/save',
						data, function(result) {
							result = $.parseJSON(result);
							if(result.status==200){
								parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
								parent.$.modalDialog.handler.dialog('close');
								orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								orderHDataGrid.datagrid('load');
								receiptOrderDetail(result.data);
								parent.$.messager.progress('close');
							}else{
						   		parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
								parent.$.messager.progress('close');
							}
						});
					}else{
						parent.$.messager.progress('close');
					}
				}
			} ]
		});
	}
	
	receiptOrderDetail = function(vo){
		var data = [];
		var idts = {id:vo.id,ts:vo.ts};
		data.push(idts);
		var dealData = new Object();
		dealData['data'] = JSON.stringify(data);
		parent.$.modalDialog({
			title : '<spring:message code="add_receipt_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/receipt/receiptCard?id='+vo.id,
			toolbar : [ {
				text : '<spring:message code="approve" />',
				iconCls : 'pencil_go',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/receipt/batchApprove',dealData, function(result) {
							result = $.parseJSON(result);
							if(result.status==200){
								parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
								parent.$.modalDialog.handler.dialog('close');
								parent.$.messager.progress('close');
							}else{
						   		parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
						   		parent.$.messager.progress('close');
							}
					});
				}
			} ]
		});
	}
	
	queryOrder = function(){
		parent.$.modalDialog({
			title : '<spring:message code="query_condition" />',
			width : 700,
			height : 400,
			href : '${pageContext.request.contextPath}/order/orderQuery',
			buttons : [ {
				text : '<spring:message code="query" />',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					var searchForm = parent.$.modalDialog.handler.find('#searchForm');
					if(searchForm.form('validate')){
						orderHDataGrid.datagrid('load', $.serializeObject(searchForm));
						parent.$.modalDialog.handler.dialog('close');
						orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
					}
					parent.$.messager.progress('close');
				}
			}]
		});
	}
	refreshQuery = function(){
		orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		orderHDataGrid.datagrid('load');
	}
	
	batchFinprodin = function(){
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		
		if (rows.length > 0) {
			for (var i = 0; i < rows.length; i++) {
				var vbilltype = rows[i].vbilltype;
				if(rows[i].effectbillcode == null){
					return;
				}
				if(rows[i].vbillstatus == 1 && rows[i].ntotalnum > rows[i].ntotalinnum && vbilltype =='30-Cxx-1'){
					var idts = {id:rows[i].id,ts:rows[i].ts};
					data.push(idts);
				}
			}
			if(data.length == 0){
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifBatch2Finprodin" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/batchFinprodin',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							orderHDataGrid.datagrid('load');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	orderReturn = function(){
		var id;
		if(id == undefined){
			var rows = orderHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbilltype != '30-01' && rows[0].vbilltype != '30-Cxx-1'){
				return;
			}
			if(rows[0].vbillstatus != 1){
				return;
			}
			if(rows[0].returnsale == 1){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="already_returnsale_returnsale_error" />', 'warning');
				return;
			}
			id = rows[0].id;
		}
		parent.$.modalDialog({
			title : '<spring:message code="return_order_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/order/returnOrder?id='+id,
			onBeforeLoad:function(){
				parent.$.modalDialog.last_edit_index = undefined;
			},
			toolbar : [ {
				text : '<spring:message code="save" />',
				iconCls : 'page_save',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					
					if(parent.$.modalDialog.last_edit_index != undefined){
						if(parent.$.modalDialog.inner_datagrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
							parent.$.modalDialog.inner_datagrid.datagrid('endEdit',
									parent.$.modalDialog.last_edit_index);//将最后一行 置为非编辑态，编辑态的数据获取不到
							parent.$.modalDialog.last_edit_index = undefined;
						}else{
							parent.$.messager.progress('close');
							return;
						}
					}
					//获取表头数据
					var headForm = parent.$.modalDialog.handler.find('#form');
					if(headForm.form('validate')){//校验表头必输项
						var rows = parent.$.modalDialog.inner_datagrid.datagrid('getRows');
						if(rows.length <= 0){
							parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
							parent.$.messager.progress('close');
							return;
						}
						var headData = $.serializeObject(headForm);
						//获取表体新增行数据
// 						var newRowDatas = parent.$.modalDialog.inner_datagrid
// 								.datagrid('getChanges', "inserted");
						//将表头表体数据封装为一个json，通过ajax传给后台一起保存
						var data = new Object();
						data["head"] = JSON.stringify(headData);
						var rowDatas = [];//用来保存行上物料字段有值的行数据
						for(var row = 0;row <rows.length;row++){
							var cmaterial = rows[row].cmaterial;
							if(cmaterial){
								rowDatas.push(rows[row]);
							}
						}
						if(rowDatas.length <= 0){
							parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
							parent.$.messager.progress('close');
							return;
						}
						data["insertBodys"] = JSON.stringify(rowDatas);
						$.post('${pageContext.request.contextPath}/order/save',
						data, function(result) {
							result = $.parseJSON(result);
							if(result.status==200){
								parent.$.modalDialog.handler.dialog('close');
								showDetail(result.data);
								orderHDataGrid.datagrid('load');
								orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								parent.$.messager.progress('close');
							}else{
						   		parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
						   		parent.$.messager.progress('close');
							}
						});
					}else{
						parent.$.messager.progress('close');
					}
				}
			} ]
		});
	}
	importOrder = function(){
		parent.$.modalDialog({
			title : '<spring:message code="import" />',
			width : 400,
			height : 200,
			href : '${pageContext.request.contextPath}/order/orderImport',
			buttons : [ {
				text : '<spring:message code="import" />',
				iconCls : 'page_save',
				handler : function() {
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			}],
		});
	}
	infoOrder = function(){
		var id;
		if(id == undefined){
			var rows = orderHDataGrid.datagrid('getChecked');
			if(rows.length == 1){
				if(rows[0].vbilltype != '30-Cxx-1'){
					return;
				}
				if(rows[0].vbillstatus != 1){
					return;
				}
				if(rows[0].effectbillcode == null){
					return;
				}
				id = rows[0].id;
				parent.$.modalDialog({
					title : '<spring:message code="info_order_bill" />',
					width : 1200,
					height : 600,
					href : '${pageContext.request.contextPath}/order/orderInfo?id='+id,
					onBeforeLoad:function(){
						parent.$.modalDialog.last_edit_index = undefined;
					},
					toolbar : [ {
						text : '<spring:message code="save" />',
						iconCls : 'page_save',
						handler : function() {
							parent.$.messager.progress({
								title : '<spring:message code="hint" />',
								text : '<spring:message code="pleaseWait" />'
							});
							if(parent.$.modalDialog.last_edit_index != undefined){
								if(parent.$.modalDialog.inner_datagrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
									parent.$.modalDialog.inner_datagrid.datagrid('endEdit',
											parent.$.modalDialog.last_edit_index);//将最后一行 置为非编辑态，编辑态的数据获取不到
									parent.$.modalDialog.last_edit_index = undefined;
								}else{
									parent.$.messager.progress('close');
									return;
								}
							}
							//获取表头数据
							var headForm = parent.$.modalDialog.handler.find('#form');
							if(headForm.form('validate')){//校验表头必输项
								var rows = parent.$.modalDialog.inner_datagrid.datagrid('getRows');
								var bodyRows = [];
								if(rows.length <= 0){
									parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
									parent.$.messager.progress('close');
									return;
								}
								for(var row = 0;row <rows.length;row++){
									var cmaterial = rows[row].cmaterial;
									if(cmaterial){
										bodyRows.push(rows[row]);
									}
								}
								
								if(bodyRows.length <= 0){
									parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
									parent.$.messager.progress('close');
									return;
								}
								var headData = $.serializeObject(headForm);
									//获取表体新增行数据
								var newRowDatas = parent.$.modalDialog.inner_datagrid
										.datagrid('getChanges', "inserted");
									//获取表体修改行数据
								var updateRowDatas = parent.$.modalDialog.inner_datagrid
										.datagrid('getChanges', "updated");
									//获取表体删除行数据
								var deleteRowDatas = parent.$.modalDialog.inner_datagrid
										.datagrid('getChanges', "deleted");
									//将表头表体数据封装为一个json，通过ajax传给后台一起保存
								var data = new Object();
								data["head"] = JSON.stringify(headData);
								var rowDatas = [];//用来保存行上物料字段有值的行数据
								if (newRowDatas.length) {
									for(var row = 0;row <newRowDatas.length;row++){
										var cmaterial = newRowDatas[row].cmaterial;
										if(cmaterial){
											rowDatas.push(newRowDatas[row]);
										}
									}
									data["insertBodys"] = JSON.stringify(rowDatas);
								}
								if (updateRowDatas.length) {
									data["updateBodys"] = JSON.stringify(updateRowDatas);
								}
								if (deleteRowDatas.length) {
									data["deleteBodys"] = JSON.stringify(deleteRowDatas);
								}
								data["realyBodys"]  = JSON.stringify(rows);
								$.post('${pageContext.request.contextPath}/order/singleInfo',
										data, function(result) {
											result = $.parseJSON(result);
											if(result.status==200){
												parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
												parent.$.modalDialog.handler.dialog('close');
												orderHDataGrid.datagrid('load');
												orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
												parent.$.messager.progress('close');
											}else{
												parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
												parent.$.messager.progress('close');
											}
									});
								}else{
									parent.$.messager.progress('close');
								}
						}
					} ]
				});
			}
			else if(rows.length > 1){
				var data = [];
				for(var i = 0;i< rows.length;i++){
					if(rows[i].vbilltype != '30-Cxx-1'){
						return;
					}
					if(rows[i].vbillstatus != 1){
						return;
					}
					if(rows[i].effectbillcode == null){
						return;
					}
					var idts = {id:rows[i].id,ts:rows[i].ts};
					data.push(idts);
				}
				var dealData = new Object();
				dealData['data'] = JSON.stringify(data);
				parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifInfoOrder" />', function(r) {
					if (r) {
						parent.$.messager.progress({
							title : '<spring:message code="hint" />',
							text : '<spring:message code="pleaseWait" />'
						});
						$.post('${pageContext.request.contextPath}/order/infoOrder', dealData, function(result) {
							if (result.status==200) {
								orderHDataGrid.datagrid('load');
								orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								parent.$.messager.progress('close');
							}else{
								parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
								parent.$.messager.progress('close');
							}
						});
					}
				});
			}else{
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
		}
	}
	reviseOrder = function(){
		var id;
		if(id == undefined){
			var rows = orderHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbilltype != '30-Cxx-1' && rows[0].vbilltype != '30-Cxx-3'){
				return;
			}
			if(rows[0].vbillstatus != 1){
				return;
			}
			id = rows[0].id;
		}else{
			id = id;
		}
		parent.$.modalDialog({
				title : '<spring:message code="revise" />',
				width : 1200,
				height : 600,
				href : '${pageContext.request.contextPath}/order/orderRevise?id='+id,
				onBeforeLoad:function(){
					parent.$.modalDialog.last_edit_index = undefined;
				},
				toolbar : [ {
					text : '<spring:message code="save" />',
					iconCls : 'page_save',
					handler : function() {
						parent.$.messager.progress({
							title : '<spring:message code="hint" />',
							text : '<spring:message code="pleaseWait" />'
						});
						if(parent.$.modalDialog.last_edit_index != undefined){
							if(parent.$.modalDialog.inner_datagrid.datagrid('validateRow',parent.$.modalDialog.last_edit_index)){
								parent.$.modalDialog.inner_datagrid.datagrid('endEdit',
										parent.$.modalDialog.last_edit_index);//将最后一行 置为非编辑态，编辑态的数据获取不到
								parent.$.modalDialog.last_edit_index = undefined;
							}else{
								parent.$.messager.progress('close');
								return;
							}
						}
						//获取表头数据
						var headForm = parent.$.modalDialog.handler.find('#form');
						if(headForm.form('validate')){//校验表头必输项
							var rows = parent.$.modalDialog.inner_datagrid.datagrid('getRows');
							var bodyRows = [];
							if(rows.length <= 0){
								parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
								parent.$.messager.progress('close');
								return;
							}
							for(var row = 0;row <rows.length;row++){
								var cmaterial = rows[row].cmaterial;
								if(cmaterial){
									bodyRows.push(rows[row]);
								}
							}
							
							if(bodyRows.length <= 0){
								parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="bodyNoOne" />', 'info');
								parent.$.messager.progress('close');
								return;
							}
							var headData = $.serializeObject(headForm);
								//获取表体新增行数据
							var newRowDatas = parent.$.modalDialog.inner_datagrid
									.datagrid('getChanges', "inserted");
								//获取表体修改行数据
							var updateRowDatas = parent.$.modalDialog.inner_datagrid
									.datagrid('getChanges', "updated");
								//获取表体删除行数据
							var deleteRowDatas = parent.$.modalDialog.inner_datagrid
									.datagrid('getChanges', "deleted");
								//将表头表体数据封装为一个json，通过ajax传给后台一起保存
							var data = new Object();
							data["head"] = JSON.stringify(headData);
							var rowDatas = [];//用来保存行上物料字段有值的行数据
							if (newRowDatas.length) {
								for(var row = 0;row <newRowDatas.length;row++){
									var cmaterial = newRowDatas[row].cmaterial;
									if(cmaterial){
										rowDatas.push(newRowDatas[row]);
									}
								}
								data["insertBodys"] = JSON.stringify(rowDatas);
							}
							if (updateRowDatas.length) {
								data["updateBodys"] = JSON.stringify(updateRowDatas);
							}
							if (deleteRowDatas.length) {
								data["deleteBodys"] = JSON.stringify(deleteRowDatas);
							}
							data["realyBodys"]  = JSON.stringify(rows);
							$.post('${pageContext.request.contextPath}/order/revise',
									data, function(result) {
										result = $.parseJSON(result);
										if(result.status==200){
											parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
											parent.$.modalDialog.handler.dialog('close');
											editOrder(result.data);
											orderHDataGrid.datagrid('load');
											orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
											parent.$.messager.progress('close');
										}else{
											parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'info');
											parent.$.messager.progress('close');
										}
								});
							}else{
								parent.$.messager.progress('close');
							}
					}
				} ]
		});
	}
	unSyncData = function(){
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus != 1){
					return;
				}
				if(rows[i].issync != 1){
					return;
				}
				var idts = {id:rows[i].id,ts:rows[i].ts};
				data.push(idts);
			}
			if(data.length == 0){
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifUnSyncData" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/unSyncData',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							orderHDataGrid.datagrid('load');
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	exportOrder = function(){
		var id;
		if(id == undefined){
			var rows = orderHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			id = rows[0].id;
		}
		var url="${pageContext.request.contextPath}/file/order/"+id;
		window.open(url);
		orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
	}
	importOldOrder = function(){
		parent.$.modalDialog({
			title : '<spring:message code="import" />',
			width : 400,
			height : 200,
			href : '${pageContext.request.contextPath}/order/orderOldImport',
			buttons : [ {
				text : '<spring:message code="import" />',
				iconCls : 'page_save',
				handler : function() {
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			}],
		});
	}
	blackoutOrder = function(){
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_approve_delete_error" />');
				}
				var idts = {id:rows[i].id,ts:rows[i].ts};
				data.push(idts);
			}
			if(vbillmsg.length > 0){
				parent.$.messager.alert('<spring:message code="hint" />', vbillmsg.join(','), 'error');
				parent.$.messager.progress('close');
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '是否作废选中数据？', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/batchBlackout',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
							orderHDataGrid.datagrid('load');
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	refreshEffectbillcode = function(){
		var rows = orderHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				var idts = {id:rows[i].id,ts:rows[i].ts};
				data.push(idts);
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '是否刷表体有效订单号？', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/order/refreshEffectbillcode',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
							orderHDataGrid.datagrid('load');
							orderHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							parent.$.messager.progress('close');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
							parent.$.messager.progress('close');
						}
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border:false,split:true" style="height:50%;">
			<table id="orderHDataGrid"></table>
		</div>
		<div data-options="region:'center',border:false,split:true" style="height:50%;">
			<table id="orderBDataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/addOrder')}">
			<div onclick="addOrder();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">
			<spring:message code="add" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/deleteOrder')}">
			<div onclick="deleteOrder();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_delete'">
			<spring:message code="delete" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/editOrder')}">
			<div onclick="editOrder();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil'">
			<spring:message code="edit" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/approveOrder')}">
			<div onclick="approveOrder();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_go'">
			<spring:message code="approve" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/handApproveOrder')}">
			<div onclick="handApproveOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'pencil_go'">
				<spring:message code="approve" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/unApproveOrder')}">
			<div onclick="unApproveOrder();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'error_delete'">
			<spring:message code="unApprove" />
			</div>
		</c:if>
		
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/reviseOrder')}">
			<div onclick="reviseOrder();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil'">
			<spring:message code="revise" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/orderReturn')}">
			<div onclick="orderReturn();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'stop'">
				<spring:message code="orderReturn" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/receiptOrder')}">
			<div onclick="receiptOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'money'">
				<spring:message code="receipt" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/batchFinprodin')}">
			<div onclick="batchFinprodin();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'database_go'">
				<spring:message code="batchFinprodin" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/queryOrder')}">
			<div onclick="queryOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'search'">
				<spring:message code="query" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/refreshQuery')}">
			<div onclick="refreshQuery();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'data_refresh'">
				<spring:message code="refreshQuery" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/infoOrder')}">
			<div onclick="infoOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'phone'">
				<spring:message code="info" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/importOrder')}">
			<div onclick="importOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'text_align_center'">
				<spring:message code="import" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/exportOrder')}">
			<div onclick="exportOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'text_align_center'">
				<spring:message code="export" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/unSyncData')}">
			<div onclick="unSyncData();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'lightning_delete'">
				<spring:message code="unsyncdata" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/blackoutOrder')}">
			<div onclick="blackoutOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'cancel'">
				作废
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/order/refreshEffectbillcode')}">
			<div onclick="refreshEffectbillcode();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'data_refresh'">
				刷表体有效订单号
			</div>
		</c:if>
<!-- 		<div onclick="importOldOrder();" class="easyui-linkbutton" -->
<!-- 				data-options="plain:true,iconCls:'text_align_center'"> -->
<!-- 				期初导入 -->
<!-- 			</div> -->
	</div>
	<div id="menu" class="easyui-menu" style="width: 120px; display: none;">
		<div onclick="showDetail();" data-options="iconCls:'pencil'"><spring:message code="detail" /></div>
	</div>
</body>
</html>