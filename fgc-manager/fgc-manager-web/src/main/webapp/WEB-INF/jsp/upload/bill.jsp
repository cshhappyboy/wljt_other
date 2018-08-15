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
	var billDatagrid;
	$(function() {
		parent.$.messager.progress('close');
		billDatagrid = $('#billDatagrid').datagrid({
			url : '${pageContext.request.contextPath}/upload/billData',
			fit : true,
			border : false,
			toolbar : '#toolbar',
			rownumbers : true,
			singleSelect : true,
			pagination:true,
			pageSize : 50,
			pageList : [ 50, 100, 200, 500 , 1000],
			frozenColumns:[[{
				field : 'id',
				title : '<spring:message code="id" />',
				hidden:true,
				align : 'left',
				halign : 'center',
			},{
				field : 'background',
				width : 30,
				align : 'left',
				halign : 'center',
				formatter : function(value, row, index) {
					var str = '';
					if(row.issuccess == 'Y'){
						str += '<img src="${pageContext.request.contextPath}/style/images/extjs_icons/tick.png" title="<spring:message code="approved" />" /> ';
					}else if(row.issuccess == 'N'){
						str += '<img src="${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png" title="作废" /> ';
					}
					return str;
				}
			},{
				title : '上传的单据',
				field : 'uploadbill',
				width : 100,
				align : 'left',
				halign : 'center',
				formatter: function(value,row,index){
					if (value == 'order'){
						return '非修订销售订单';
					} else if(value == 'xdorder'){
						return '修订的销售订单';
					}else if(value == 'receipt'){
						return '预收款单';
					}else if(value == 'finprodin'){
						return '产成品入库单';
					}else if(value == 'whstrans'){
						return '转库单';
					}else if(value == 'invoice'){
						return '销售发票';
					}else if(value == 'saleout'){
						return '销售出库';
					}else if(value == 'redflushreceipt'){
						return '红冲预收款单据';
					}
				}
			}]],
			columns : [ [ {
				title : '操作时间',
				field : 'executetime',
				width : 150,
				align : 'left',
				halign : 'center',
			},{
				title : '上传方式',
				field : 'uploadmode',
				width : 80,
				align : 'left',
				halign : 'center',
				formatter: function(value,row,index){
					if (value == '0'){
						return '手动';
					} else {
						return '自动';
					}
				}
			},{
				title : '上传的单据号',
				field : 'notesvbillcode',
				align : 'left',
				halign : 'center',
			},{
				title : '上传的时间',
				field : 'uploadtime',
				width : 150,
				align : 'left',
				halign : 'center',
			},{
				title : '是否上传成功',
				field : 'issuccess',
				width : 80,
				align : 'left',
				halign : 'center',
			},{
				title : '上传结果',
				field : 'result',
				align : 'left',
				halign : 'center',
			},{
				title : '上传次数统计',
				field : 'uploadcount',
				width : 80,
				align : 'left',
				halign : 'center',
			},{
				title : '最后一次的上传时间',
				field : 'lastuploadtime',
				width : 150,
				align : 'left',
				halign : 'center',
			} ] ],
			onLoadSuccess : function(datas) {
				parent.$.messager.progress('close');
			}
		});
	});
	refresh = function() {
		billDatagrid.datagrid('load');
	}
</script>
</head>
<body>
	<table id="billDatagrid"></table>
	<div id="toolbar" style="display: none;">
		<a onclick="refresh();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'data_refresh'">刷新</a>
	</div>
</body>
</html>