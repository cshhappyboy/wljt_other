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
	var receiptDatagrid;
	$(function() {
		parent.$.messager.progress('close');
		receiptDatagrid = $('#receiptDatagrid').datagrid({
			url : '${pageContext.request.contextPath}/report/moneyDetail',
			fit : true,
			border : false,
			toolbar : '#toolbar',
			rownumbers:true,
			singleSelect:true,
			rowStyler:function(index,row){
				if (row.dbilldate == '总计'){
					return 'background-color:#6293BB;color:#fff;';
				}
			},
			columns : [ [ {
				title : '日期',
				field : 'dbilldate',
				width : 100,
				align : 'right',
				halign : 'center',
			}, {
				title : '订单号',
				field : 'ddh',
				width : 150,
				align : 'right',
				halign : 'center',
			}, {
				title : 'BA号',
				field : 'bah',
				width : 150,
				align : 'right',
				halign : 'center',
			},{
				title : '发票总金额',
				field : 'fpzje',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '收款金额',
				field : 'skje',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '尾款',
				field : 'wk',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '累计预收款金额',
				field : 'rnreceivedmny',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},
			
			{
				title : '发票号',
				field : 'fph',
				width : 150,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row.dbilldate == '总计' && row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}else{
						return value;
					}
				},
			},{
				title : '收营员',
				field : 'billmaker',
				width : 200,
				align : 'right',
				halign : 'center',
			},{
				title : '营销员',
				field : 'sohbillmaker',
				width : 200,
				align : 'right',
				halign : 'center',
			} ] ],
			onLoadSuccess : function(datas) {
				parent.$.messager.progress('close');
			},
			onBeforeLoad : function(param) {
				if (param && param.query_flag) {
					return true;
				} else {
					return false;
				}
			}
		});
	});
	queryReport = function() {
		parent.$.modalDialog({
			title : '<spring:message code="query_condition" />',
			width : 400,
			height : 200,
			href : '${pageContext.request.contextPath}/report/receiptQuery',
			buttons : [ {
				text : '<spring:message code="query" />',
				handler : function() {
					parent.$.messager.progress({
						title : '<spring:message code="hint" />',
						text : '<spring:message code="pleaseWait" />'
					});
					var searchForm = parent.$.modalDialog.handler
							.find('#searchForm');
					if (searchForm.form('validate')) {
						receiptDatagrid.datagrid('load', $
								.serializeObject(searchForm));
						parent.$.modalDialog.handler.dialog('close');
					}
					parent.$.messager.progress('close');
				}
			} ]
		});
	}
	exportReport = function(){
		var url="${pageContext.request.contextPath}/file/moneyDetail";
		window.open(url);
	}
</script>
</head>
<body>
	<table id="receiptDatagrid"></table>
	<div id="toolbar" style="display: none;">
		<a onclick="queryReport();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">查询</a>
		<a onclick="exportReport();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'text_align_center'">导出</a>
	</div>
</body>
</html>