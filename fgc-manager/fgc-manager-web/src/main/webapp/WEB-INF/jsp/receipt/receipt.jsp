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
	var receiptHDataGrid;
	$(function() {
		parent.$.messager.progress('close');
		receiptHDataGrid = $('#receiptHDataGrid').datagrid({
			url : "${pageContext.request.contextPath}/receipt/allReceipt",
			fit : true,
			singleSelect:true,
			idField : 'id',
			pagination : true,
			selectOnCheck : false,
			checkOnSelect : false,
			pageSize : 50,
			rownumbers : true,
			pageList : [ 50, 100, 500, 1200, 2000 ],
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
			columns : [ [  {
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
				field : 'cdept',
				title : '<spring:message code="cdept" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'currency',
				title : '<spring:message code="currency" />',
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
				field : 'vorderbillcode',
				title : '<spring:message code="vorderbillcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'vsrcbilltype',
				title : '<spring:message code="vsrcbilltype" />',
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
				field : 'nordermny',
				title : '<spring:message code="nordermny" />',
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
				field : 'cbankid',
				title : '<spring:message code="cbankid" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},  {
				field : 'vbillstatus',
				title : '<spring:message code="vbillstatus" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter : function(value, row, index) {
					if (value == 0) {
						return '<spring:message code="free" />'
					} else if (value == 1) {
						return '<spring:message code="approved" />'
					}
				}
			}, {
				field : 'taux',
				title : '<spring:message code="taux" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'total',
				title : '<spring:message code="total" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			}, {
				field : 'cbalatype',
				title : '<spring:message code="cbalatype" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'cashaccount',
				title : '<spring:message code="cashaccount" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
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
				parent.$.messager.progress('close');
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
	});
	showDetail = function(){
		var rows = receiptHDataGrid.datagrid('getChecked');
		if(rows.length > 1 || rows.length==0){
			parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
			return;
		}
		var id = rows[0].id;
		
		parent.$.modalDialog({
			title : '<spring:message code="receipt_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/receipt/receiptCard?id='+id,
		});
	}
	addReceipt = function(){
		parent.$.modalDialog({
			title : '<spring:message code="add_receipt_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/receipt/receiptAdd',
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
								editReceipt(result.data);
								receiptHDataGrid.datagrid('load');
								receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	editReceipt = function(id){
		if(id == undefined){
			var rows = receiptHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbillstatus == 1){
				return;
			}
			id = rows[0].id;
		}
		parent.$.modalDialog({
				title : '<spring:message code="edit_order_bill" />',
				width : 1200,
				height : 600,
				href : '${pageContext.request.contextPath}/receipt/receiptEdit?id='+id,
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
							var data = new Object();
							data["head"] = JSON.stringify($.serializeObject(headForm));
							$.post('${pageContext.request.contextPath}/receipt/update',
									data, function(result) {
										result = $.parseJSON(result);
										if(result.status==200){
											parent.$.messager.show({title:'<spring:message code="hint" />',msg:'<spring:message code="dealSuccess" />', timeout:4000});
											parent.$.modalDialog.handler.dialog('close');
											receiptHDataGrid.datagrid('load');
											receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
											editReceipt(result.data);
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
	deleteReceipt = function() {
		var rows = receiptHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				if(rows[i].vbillstatus != 1){
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
					$.post('${pageContext.request.contextPath}/receipt/batchDelete', dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							receiptHDataGrid.datagrid('load');
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
	
	approveReceipt = function(){
		var rows = receiptHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
				var mny = $.MMNumberAdd(rows[i].nreceivedmny,rows[i].total);//实际收款+本次收款
				var ordermny03 = $.MMNumberMul(rows[i].nordermny,0.3);//订单金额的30%
				if(mny < ordermny03){
					vbillmsg.push('<spring:message code="vbillcode" />:' + rows[i].vbillcode+ '<spring:message code="receipt_approve_mny_error" />');
				}
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
					$.post('${pageContext.request.contextPath}/receipt/batchApprove',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							receiptHDataGrid.datagrid('load');
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
	
	unApproveReceipt = function(){
		var rows = receiptHDataGrid.datagrid('getChecked');
		var data = [];
		if (rows.length > 0) {
			var vbillmsg = [];
			for ( var i = 0; i < rows.length; i++) {
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
					$.post('${pageContext.request.contextPath}/receipt/batchUnApprove',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							receiptHDataGrid.datagrid('load');
							receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	
	queryReceipt  = function(){
		parent.$.modalDialog({
			title : '<spring:message code="query_condition" />',
			width : 700,
			height : 400,
			href : '${pageContext.request.contextPath}/receipt/receiptQuery',
			buttons : [ {
				text : '<spring:message code="query" />',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					var searchForm = parent.$.modalDialog.handler.find('#searchForm');
					if(searchForm.form('validate')){
						receiptHDataGrid.datagrid('load', $.serializeObject(searchForm));
						receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						parent.$.modalDialog.handler.dialog('close');
					}
					parent.$.messager.progress('close');
				}
			}]
		});
	}
	refreshQuery = function(){
		receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		receiptHDataGrid.datagrid('load');
	}
	exportReceipt = function(){
		var id;
		if(id == undefined){
			var rows = receiptHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbillstatus != 1){
				return;
			}
			id = rows[0].id;
		}
		var url="${pageContext.request.contextPath}/file/receipt/"+id;
		window.open(url);
		receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
	}
	handApproveReceipt = function(){
		var rows = receiptHDataGrid.datagrid('getChecked');
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
					$.post('${pageContext.request.contextPath}/receipt/handBatchApprove',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							receiptHDataGrid.datagrid('load');
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
		var rows = receiptHDataGrid.datagrid('getChecked');
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
					$.post('${pageContext.request.contextPath}/receipt/unSyncData',dealData, function(result) {
						result = $.parseJSON(result);
						if (result.status==200) {
							receiptHDataGrid.datagrid('load');
							receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	hongchongReceipt = function(){
		var id;
		if(id == undefined){
			var rows = receiptHDataGrid.datagrid('getChecked');
			if(rows.length > 1 || rows.length==0){
				parent.$.messager.alert('<spring:message code="hint" />', '<spring:message code="pleaseCheckOne" />', 'warning');
				return;
			}
			if(rows[0].vbillstatus != 1){
				return;
			}
			id = rows[0].id;
		}
		parent.$.modalDialog({
			title : '<spring:message code="add_receipt_bill" />',
			width : 1200,
			height : 600,
			href : '${pageContext.request.contextPath}/receipt/hongchongReceipt?id='+id,
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
								receiptHDataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								receiptHDataGrid.datagrid('load');
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
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,breceipt : false">
		<div data-options="region:'center',breceipt:false,split:true">
			<table id="receiptHDataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/addReceipt')}">
			<div onclick="addReceipt();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">
			<spring:message code="add" />
			</div>
		</c:if>
		
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/deleteReceipt')}">
			<div onclick="deleteReceipt();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_delete'">
			<spring:message code="delete" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/editReceipt')}">
			<div onclick="editReceipt();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil'">
			<spring:message code="edit" />
			</div>
		</c:if>
		
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/approveReceipt')}">
			<div onclick="approveReceipt();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'pencil_go'">
				<spring:message code="approve" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/handApproveReceipt')}">
			<div onclick="handApproveReceipt();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'pencil_go'">
				<spring:message code="approve" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/unApproveReceipt')}">
			<div onclick="unApproveReceipt();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'error_delete'">
				<spring:message code="unApprove" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/queryReceipt')}">
			<div onclick="queryReceipt();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'search'">
				<spring:message code="query" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/refreshQuery')}">
			<div onclick="refreshQuery();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'data_refresh'">
				<spring:message code="refreshQuery" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/hongchongReceipt')}">
			<div onclick="hongchongReceipt();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'exclamation'">
				红冲
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/exportReceipt')}">
			<div onclick="exportReceipt();" class="easyui-linkbutton"
				data-options="plain:true,iconCls:'text_align_center'">
				<spring:message code="export" />
			</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/receipt/unSyncData')}">
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