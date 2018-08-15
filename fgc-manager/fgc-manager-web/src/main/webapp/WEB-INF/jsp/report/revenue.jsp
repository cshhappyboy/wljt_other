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
	var revenueDatagrid;
	$(function() {
		parent.$.messager.progress('close');
		revenueDatagrid = $('#revenueDatagrid').datagrid({
			url : '${pageContext.request.contextPath}/report/moneyData',
			fit : true,
			border : false,
			toolbar : '#toolbar',
			rownumbers:true,
			singleSelect:true,
			rowStyler:function(index,row){
				if (row.name == '总计'){
					return 'background-color:#6293BB;color:#fff;';
				}
			},
			frozenColumns : [ [ {
				title : '部门',
				field : 'name',
				width : 150,
				align : 'right',
				halign : 'center',
			} ] ],
			columns : [ [  {
				title : '合计',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '1日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '2日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '3日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '4日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '5日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '6日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '7日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '8日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '9日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '10日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '11日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '12日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '13日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '14日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '15日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '16日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '17日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '18日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '19日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '20日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '21日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '22日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '23日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '24日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '25日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '26日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '27日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '28日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '29日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '30日',
				align : 'right',
				halign : 'center',
				colspan : 3
			},{
				title : '31日',
				align : 'right',
				halign : 'center',
				colspan : 3
			}], [ {
				title : '总计',
				field : 'rowzongji',
				width : 100,
				align : 'right',
				halign : 'center',
				rowspan:1,
				colspan : 1,
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金合计',
				field : 'rowxianjinheji',
				width : 100,
				align : 'right',
				halign : 'center',
				rowspan:1,
				colspan : 1,
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '支票合计',
				field : 'rowzhipiaoheji',
				width : 100,
				align : 'right',
				halign : 'center',
				rowspan:1,
				colspan : 1,
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin1',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao1',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji1',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin2',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao2',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji2',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin3',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao3',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji3',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin4',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao4',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji4',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin5',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao5',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji5',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin6',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao6',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji6',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin7',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao7',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji7',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin8',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao8',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji8',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin9',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao9',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji9',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin10',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao10',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji10',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			} ,{
				title : '现金',
				field : 'xianjin11',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao11',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji11',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin12',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao12',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji12',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin13',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao13',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji13',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin14',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao14',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji14',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin15',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao15',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji15',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin16',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao16',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji16',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin17',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao17',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji17',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin18',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao18',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji18',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin19',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao19',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji19',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin20',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao20',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji20',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin21',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao21',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji21',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin22',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao22',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji22',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin23',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao23',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji23',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin24',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao24',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji24',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin25',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao25',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji25',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin26',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao26',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji26',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin27',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao27',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji27',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin28',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao28',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji28',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin29',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao29',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji29',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin30',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao30',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji30',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			},{
				title : '现金',
				field : 'xianjin31',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '支票',
				field : 'zhipiao31',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}, {
				title : '小计',
				field : 'xiaoji31',
				width : 100,
				align : 'right',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(0).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
					}
				},
			}] ],
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
			href : '${pageContext.request.contextPath}/report/revenueQuery',
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
						revenueDatagrid.datagrid('load', $
								.serializeObject(searchForm));
						parent.$.modalDialog.handler.dialog('close');
					}
					parent.$.messager.progress('close');
				}
			} ]
		});
	}
</script>
</head>
<body>
	<table id="revenueDatagrid"></table>
	<div id="toolbar" style="display: none;">
		<a onclick="queryReport();" href="javascript:void(0);"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">查询</a>
	</div>
</body>
</html>