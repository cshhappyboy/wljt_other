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
	var saleOutHDataGrid;
	var saleOutBDataGrid;
	$(function() {
		saleOutHDataGrid = $('#saleOutHDataGrid').datagrid({
			url : "${pageContext.request.contextPath}/saleout/allsaleout",
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
					if(row.vbillstatus == 2){
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
			},  {
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
			},  {
				field : 'vbillstatus',
				title : '<spring:message code="vbillstatus" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter:function(value,row,index){
					if(value == 0){
						return '<spring:message code="free" />'
					}else if(value == 2){
						return '<spring:message code="sign" />'
					}
				}
			}, {
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
				field : 'saletuihui',
				title : '销售退回',
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
				field : 'vorderbillcode',
				title : '<spring:message code="vorderbillcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'effectbillcode',
				title : '<spring:message code="effectbillcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'vinvoicebillcode',
				title : '<spring:message code="vinvoicebillcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'salesman',
				title : '<spring:message code="salesman" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'cdept',
				title : '<spring:message code="cdept" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'client',
				title : '<spring:message code="client" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'address',
				title : '<spring:message code="address" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'tel',
				title : '<spring:message code="tel" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'memo',
				title : '<spring:message code="memo" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},  {
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
					saleOutBDataGrid.datagrid('load',{id:id});
				}else{
					saleOutBDataGrid.datagrid('load',{id:'-1'});
				}
				parent.$.messager.progress('close');
			},
			onSelect:function(index, row){
				saleOutBDataGrid.datagrid('load',{id:row.id});
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
		saleOutBDataGrid = $('#saleOutBDataGrid').datagrid(
				{
					url:'${pageContext.request.contextPath}/saleout/qrysaleoutBVOs',
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
						hidden : true,
						align : 'left',
						halign : 'center',
					},
					{
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
					},
					{
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
					columns : [ [
					{
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
					},
									 {
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
									},
									{
										field : 'nmny',
										title : '<spring:message code="nmny" />',
										width : 120,
										align : 'left',
										halign : 'center',
										formatter : function(value, row, index) {
											if (row != null && value != null
													&& value != '') {
												return parseFloat(value)
														.toFixed(0)
											}
										},
									},
									{
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
									},
									{
										field : 'vtransrate',
										title : '<spring:message code="vtransrate" />',
										width : 120,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'vbatchcode',
										title : '<spring:message code="vbatchcode" />',
										width : 120,
										align : 'left',
										halign : 'center',
									},
									{
										field : 'nshouldassistnum',
										title : '<spring:message code="nshouldassistnum" />',
										width : 120,
										align : 'left',
										halign : 'center',
										formatter : function(value, row, index) {
											if (row != null && value != null
													&& value != '') {
												return parseFloat(value)
														.toFixed(4)
											}
										},
									},
									{
										field : 'nshouldnum',
										title : '<spring:message code="nshouldnum" />',
										width : 120,
										align : 'left',
										halign : 'center',
										formatter : function(value, row, index) {
											if (row != null && value != null
													&& value != '') {
												return parseFloat(value)
														.toFixed(4)
											}
										},
									},
									{
										field : 'nassistnum',
										title : '<spring:message code="nassistnum" />',
										width : 120,
										align : 'left',
										halign : 'center',
										formatter : function(value, row, index) {
											if (row != null && value != null
													&& value != '') {
												return parseFloat(value)
														.toFixed(4)
											}
										},
									},{
										field : 'nnum',
										title : '<spring:message code="nnum" />',
										width : 120,
										align : 'left',
										halign : 'center',
										formatter : function(value, row, index) {
											if (row != null && value != null
													&& value != '') {
												return parseFloat(value)
														.toFixed(4)
											}
										},
									},
									{
										field : 'dbizdate',
										title : '<spring:message code="dbizdate" />',
										width : 120,
										align : 'left',
										halign : 'center',
									} ,{
										field : 'vsrcid',
										hidden:true,
									},{
										field : 'vsrcbid',
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
		var rows = saleOutHDataGrid.datagrid('getChecked');
		if(rows.length > 1 || rows.length==0){
			parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
			return;
		}
		var id = rows[0].id;
		parent.$.modalDialog({
			title : '<spring:message code="saleout_bill" />',
			width : 1000,
			height : 600,
			href : '${pageContext.request.contextPath}/saleout/saleoutCard?id='+id,
		});
	}
	editSaleout = function(id){
		if(id == undefined){
			var rows = saleOutHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbillstatus == 2){
				return;
			}
			id = rows[0].id;
		}
		parent.$.modalDialog({
				title : '<spring:message code="edit_saleout_bill" />',
				width : 1000,
				height : 600,
				href : '${pageContext.request.contextPath}/saleout/saleoutEdit?id='+id,
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
							$.post('${pageContext.request.contextPath}/saleout/update',
									data, function(result) {
										result = $.parseJSON(result);
										if(result.status==200){
											parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
											parent.$.modalDialog.handler.dialog('close');
											editSaleout(result.data);
											saleOutHDataGrid.datagrid('load');
											saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	deleteSaleout = function() {
		var rows = saleOutHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				if(rows[0].vbillstatus != 2){
					var idts = {id:rows[i].id,ts:rows[i].ts};
					data.push(idts);
				}
			}
			if(data.length == 0){
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
					
					$.post('${pageContext.request.contextPath}/saleout/batchDelete',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							saleOutHDataGrid.datagrid('load');
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
	
	signSaleout = function(){
		var rows = saleOutHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus != 2){
					var idts = {id:rows[i].id,ts:rows[i].ts};
					data.push(idts);
				}
			}
			if(data.length == 0){
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifSign" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					
					$.post('${pageContext.request.contextPath}/saleout/batchSign',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							saleOutHDataGrid.datagrid('load');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
					});
				}
			});
		} else {
			parent.$.messager.alert({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	
	querySaleout = function(){
		parent.$.modalDialog({
			title : '<spring:message code="query_condition" />',
			width : 700,
			height : 400,
			href : '${pageContext.request.contextPath}/saleout/saleoutQuery',
			buttons : [ {
				text : '<spring:message code="query" />',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					var searchForm = parent.$.modalDialog.handler.find('#searchForm');
					if(searchForm.form('validate')){
						saleOutHDataGrid.datagrid('load', $.serializeObject(searchForm));
						saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						parent.$.modalDialog.handler.dialog('close');
					}
					parent.$.messager.progress('close');
				}
			}]
		});
	}
	refreshQuery = function(){
		saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		saleOutHDataGrid.datagrid('load');
	}
	unSignSaleout = function(){
		var rows = saleOutHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].issync == 1){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="already_issync_unapprove_error" />');
				}
				if(rows[i].vbillstatus == 2){
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
			parent.$.messager.confirm('<spring:message code="confirm" />', '<spring:message code="ifUnSign" />', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/saleout/batchUnSign',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							saleOutHDataGrid.datagrid('load');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
					});
				}
			});
		} else {
			parent.$.messager.alert({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	batchSaleout = function(){
		var rows = saleOutHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus == 0){
					var idts = {id:rows[i].id,ts:rows[i].ts};
					data.push(idts);
				}
			}
			if(data.length == 0){
				return;
			}
			var dealData = new Object();
			dealData['data'] = JSON.stringify(data);
			parent.$.messager.confirm('<spring:message code="confirm" />', '是否批量出库', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					$.post('${pageContext.request.contextPath}/saleout/batchSaleout',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							saleOutHDataGrid.datagrid('load');
						}else{
							parent.$.messager.alert('<spring:message code="hint" />', result.msg, 'error');
						}
						parent.$.messager.progress('close');
					});
				}
			});
		} else {
			parent.$.messager.alert({
				title : '<spring:message code="hint" />',
				msg : '<spring:message code="pleaseChecked" />'
			});
		}
	}
	addSaleout = function() {
		parent.$.modalDialog({
			title : '<spring:message code="add_saleout_bill" />',
			width : 1000,
			height : 600,
			href : '${pageContext.request.contextPath}/saleout/saleoutAdd',
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
						$.post('${pageContext.request.contextPath}/saleout/save',
						data, function(result) {
							result = $.parseJSON(result);
							if(result.status==200){
								parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
								parent.$.modalDialog.handler.dialog('close');
								editSaleout(result.data);
								saleOutHDataGrid.datagrid('load');
								saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
		var rows = saleOutHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus != 2){
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
					$.post('${pageContext.request.contextPath}/saleout/unSyncData',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							saleOutHDataGrid.datagrid('load');
							saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	refreshEffectbillcode = function(){
		var rows = saleOutHDataGrid.datagrid('getChecked');
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
					$.post('${pageContext.request.contextPath}/saleout/refreshEffectbillcode',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
							saleOutHDataGrid.datagrid('load');
							saleOutHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	<div class="easyui-layout" data-options="fit : true,bsaleout : false">
		<div data-options="region:'north',bsaleout:false,split:true" style="height:50%;">
			<table id="saleOutHDataGrid"></table>
		</div>
		<div data-options="region:'center',bsaleout:false,split:true" style="height:50%;">
			<table id="saleOutBDataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
<%-- 		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/addSaleout')}"> --%>
<!-- 			<div onclick="addSaleout();" class="easyui-linkbutton" -->
<!-- 			data-options="plain:true,iconCls:'pencil_add'"> -->
<%-- 			<spring:message code="add" /> --%>
<!-- 			</div> -->
<%-- 		</c:if> --%>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/deleteSaleout')}">
			<div onclick="deleteSaleout();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_delete'">
			<spring:message code="delete" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/editSaleout')}">
			<div onclick="editSaleout();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil'">
			<spring:message code="edit" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/signSaleout')}">
			<div onclick="signSaleout();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'status_online'">
				<spring:message code="sign" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/unSignSaleout')}">
			<div onclick="unSignSaleout();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'status_offline'">
				<spring:message code="unSign" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/querySaleout')}">
			<div onclick="querySaleout();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'search'">
				<spring:message code="query" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/refreshQuery')}">
			<div onclick="refreshQuery();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'data_refresh'">
				<spring:message code="refreshQuery" />
			</div>
		</c:if>
			<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/batchSaleout')}">
			<div onclick="batchSaleout();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'database_go'">
				批量出库
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/unSyncData')}">
			<div onclick="unSyncData();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'lightning_delete'">
				<spring:message code="unsyncdata" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/saleout/refreshEffectbillcode')}">
			<div onclick="refreshEffectbillcode();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'data_refresh'">
				刷表体有效订单号
			</div>
		</c:if>
	</div>
	<div id="menu" class="easyui-menu" style="width: 120px; display: none;">
		<div onclick="showDetail();" data-options="iconCls:'pencil'"><spring:message code="detail" /></div>
	</div>
</body>
</html>