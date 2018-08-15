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
	var invoiceHDataGrid;
	var invoiceBDataGrid;
	$(function(){
		invoiceHDataGrid = $('#invoiceHDataGrid').datagrid({
			url : "${pageContext.request.contextPath}/invoice/allInvoice",
			fit : true,
			singleSelect:true,
			idField : 'id',
			pagination : true,
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
				lastSelectRow = index;
				invoiceBDataGrid.datagrid('load',{id:row.id});
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
			onBeforeLoad:function(param){
				parent.$.messager.progress('close');
				if(param && param.query_flag){
					return true;
				}else{
					return false;
				}
			}
			
		});
		invoiceBDataGrid = $('#invoiceBDataGrid').datagrid(
				{
					url:'${pageContext.request.contextPath}/invoice/qryInvoiceBVOs',
					singleSelect:true,
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
					}] ],
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
	
	showDetail = function(){
		var rows = invoiceHDataGrid.datagrid('getChecked');
		if(rows.length > 1 || rows.length==0){
			parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
			return;
		}
		var id = rows[0].id;
		
		parent.$.modalDialog({
			title : '<spring:message code="invoice_bill" />',
			width : 1000,
			height : 600,
			href : '${pageContext.request.contextPath}/invoice/invoiceCard?id='+id,
		});
	}
	
	editInvoice = function(id){
		var id;
		if(id == undefined){
			var rows = invoiceHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbillstatus == 1){
				return;
			}
			id = rows[0].id;
		}else{
			id = id;
		}
		parent.$.modalDialog({
				title : '<spring:message code="edit_invoice_bill" />',
				width : 1000,
				height : 600,
				href : '${pageContext.request.contextPath}/invoice/invoiceEdit?id='+id,
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
							$.post('${pageContext.request.contextPath}/invoice/update',
									data, function(result) {
										result = $.parseJSON(result);
										if(result.status==200){
											parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
											parent.$.modalDialog.handler.dialog('close');
											editInvoice(result.data);
											invoiceHDataGrid.datagrid('load');
											invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	deleteInvoice = function() {
		var rows = invoiceHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				if(rows[0].vbillstatus != 1){
					var idts = {id:rows[i].id,ts:rows[i].ts};
					data.push(idts);
				}
					
			}
			if(data.length  == 0){
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
					
					$.post('${pageContext.request.contextPath}/invoice/batchDelete',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							invoiceHDataGrid.datagrid('load');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
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
	
	approveInvoice = function(){
		var rows = invoiceHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_approve_approve_error" />');
				}
				if(rows[i].isdebt == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="invoice_approve_isdebt_error" />');
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
					
					$.post('${pageContext.request.contextPath}/invoice/batchApprove', dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							invoiceHDataGrid.datagrid('load');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
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
	
	queryInvoice = function(){
		parent.$.modalDialog({
			title : '<spring:message code="query_condition" />',
			width : 700,
			height : 400,
			href : '${pageContext.request.contextPath}/invoice/invoiceQuery',
			buttons : [ {
				text : '<spring:message code="query" />',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					var searchForm = parent.$.modalDialog.handler.find('#searchForm');
					if(searchForm.form('validate')){
						invoiceHDataGrid.datagrid('load', $.serializeObject(searchForm));
						invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						parent.$.modalDialog.handler.dialog('close');
					}
					parent.$.messager.progress('close');
				}
			}]
		});
	}
	refreshQuery = function(){
		invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		invoiceHDataGrid.datagrid('load');
	}
	
	refOrder = function(){
		//弹出订单查询界面
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
						var searchOrder = $.serializeObject(searchForm);
						parent.$.modalDialog.handler.dialog('close');
						linkOrderPage(searchOrder);
					}
					parent.$.messager.progress('close');
				}
			}]
		});
	}
	linkOrderPage = function(searchOrder){
		parent.$.modalDialog({
			title : '<spring:message code="ref_order_bill" />',
			width : 1000,
			height : 600,
			queryParams:searchOrder,
			href : '${pageContext.request.contextPath}/order/refOrder',
			onBeforeLoad:function(){
				//设置发票拉销售订单查询额外默认查询条件
				searchOrder.reftype = 'I';//发票拉销售订单
				if(!searchOrder.cbilltype){
					searchOrder.cbilltype = '1001A11000000000JA1X'
				}else if(searchOrder.cbilltype != '1001A11000000000L87S'){
					searchOrder.cbilltype = '1001A11000000000JA1X'
				}
				searchOrder.vbillstatus = 1;
				searchOrder.query_flag = 'N';
				parent.$.modalDialog.searchParam = searchOrder;
			},
			buttons : [ {
				text : '<spring:message code="ok" />',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					var refHid = parent.$.modalDialog.change_order_id;
					var refBDatagrid = parent.$.modalDialog.change_orderb_datagrid;
					var bRows = refBDatagrid.datagrid('getChecked');
					if(refHid && bRows.length > 0){
						var bids = [];
						parent.$.modalDialog.handler.dialog('close');
						for(var bIndex = 0;bIndex < bRows.length; bIndex++){
							bids.push(bRows[bIndex].id);
						}
						changeOrder(refHid,bids.join(","));
					}else if(bRows.length == 0){
						parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOneBody" />', 'warning');
					}else{
						parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
					}
					parent.$.modalDialog.change_order_id = undefined;
					parent.$.messager.progress('close');
					
				}
			},
			{
				text : '<spring:message code="cancle" />',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			}]
		});
	}
	changeOrder = function(refHid,refBids){
		var param = {"id":refHid,"bids":refBids}; 
		parent.$.modalDialog({
			title : '<spring:message code="add_invoice_bill" />',
			width : 1000,
			height : 600,
			queryParams:param,
			href : '${pageContext.request.contextPath}/invoice/orderChange2Invoice',
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
						$.post('${pageContext.request.contextPath}/invoice/save',
						data, function(result) {
							result = $.parseJSON(result);
							if(result.status==200){
								parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
								parent.$.modalDialog.handler.dialog('close');
								editInvoice(result.data);
								invoiceHDataGrid.datagrid('load');
								invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	unApproveInvoice = function(){
		var rows = invoiceHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].alreadyout == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_out_unapprove_error" />');
				}
				if(rows[i].issync == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_issync_unapprove_error" />');
				}
				if(rows[i].vbillstatus == 1){
					var idts = {id:rows[i].id,ts:rows[i].ts};
					data.push(idts);
				}
			}
			if(vbillmsg.length > 0){
				parent.$.messager.alert('<spring:message code="hint" />', vbillmsg.join(','), 'error');
				parent.$.messager.progress('close');
				return;
			}
			if(data.length == 0){
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
					$.post('${pageContext.request.contextPath}/invoice/batchUnApprove',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							invoiceHDataGrid.datagrid('load');
							invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
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
	exportInvoice = function(){
		var id;
		if(id == undefined){
			var rows = invoiceHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			id = rows[0].id;
		}
		var url="${pageContext.request.contextPath}/file/invoice/"+id;
		window.open(url);
		invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
	}
	blExportInvoice = function(){
		var id;
		if(id == undefined){
			var rows = invoiceHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			id = rows[0].id;
		}
		var url="${pageContext.request.contextPath}/file/invoice/bl/"+id;
		window.open(url);
		invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
	}
	canDebtInvoice = function(){
		var rows = invoiceHDataGrid.datagrid('getChecked');
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
			parent.$.messager.confirm('<spring:message code="confirm" />', '是否允许欠款?', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/invoice/batchDebt',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							invoiceHDataGrid.datagrid('load');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
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
	unSyncData = function(){
		var rows = invoiceHDataGrid.datagrid('getChecked');
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
					$.post('${pageContext.request.contextPath}/invoice/unSyncData',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							invoiceHDataGrid.datagrid('load');
							invoiceHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
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
	<div class="easyui-layout" data-options="fit : true,bInvoice : false">
		<div data-options="region:'north',bInvoice:false,split:true" style="height:50%;">
			<table id="invoiceHDataGrid"></table>
		</div>
		<div data-options="region:'center',bInvoice:false,split:true" style="height:50%;">
			<table id="invoiceBDataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/refOrder')}">
			<div onclick="refOrder();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'bullet_go'">
				<spring:message code="refOrder" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/deleteInvoice')}">
			<div onclick="deleteInvoice();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_delete'">
			<spring:message code="delete" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/editInvoice')}">
			<div onclick="editInvoice();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil'">
			<spring:message code="edit" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/approveInvoice')}">
			<div onclick="approveInvoice();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'pencil_go'">
				<spring:message code="approve" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/unApproveInvoice')}">
			<div onclick="unApproveInvoice();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'error_delete'">
				<spring:message code="unApprove" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/canDebtInvoice')}">
			<div onclick="canDebtInvoice();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'money'">
				允许欠款
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/queryInvoice')}">
			<div onclick="queryInvoice();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'search'">
				<spring:message code="query" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/refreshQuery')}">
			<div onclick="refreshQuery();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'data_refresh'">
				<spring:message code="refreshQuery" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/exportInvoice')}">
			<div onclick="exportInvoice();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'text_align_center'">
				<spring:message code="export" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/exportInvoice')}">
			<div onclick="blExportInvoice();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'text_align_center'">
				玻璃小票导出
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/invoice/unSyncData')}">
			<div onclick="unSyncData();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'lightning_delete'">
				<spring:message code="unsyncdata" />
			</div>
		</c:if>
	</div>
	<div id="menu" class="easyui-menu" style="width: 120px; display: none;">
		<div onclick="showDetail();" data-options="iconCls:'pencil'"><spring:message code="detail" /></div>
	</div>
</body>
</html>