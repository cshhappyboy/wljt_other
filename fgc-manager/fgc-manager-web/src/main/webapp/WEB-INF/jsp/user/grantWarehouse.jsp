<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var pubRef;
	$(function() {
		parent.$.messager.progress('close');
		pubRef = $('#pubRef').datagrid(
				{
					url : parent.$.refDialog.refURLPath,
					singleSelect:true,
					selectOnCheck : false,
					checkOnSelect:false,
					idField : 'id',
					fit : true,
					rownumbers : true,
					columns : [ [ {
						field : 'id',
						title : '<spring:message code="id" />',
						width : 100,
						checkbox : true,
						align : 'left',
						halign : 'center',
					}, {
						field : 'code',
						title : '<spring:message code="code" />',
						width : 100,
						align : 'left',
						halign : 'center',
					}, {
						field : 'name',
						title : '<spring:message code="name" />',
						width : 250,
						align : 'left',
						halign : 'center',
					} ] ],
					onLoadSuccess : function() {
						parent.$.messager.progress('close');
						var resIds = $.stringToList('${warehouse.warehouseIds}');
						var allRows = pubRef.datagrid('getRows');
						if (resIds.length > 0) {
							for(var i = 0;i<allRows.length;i++){
								for (var j = 0; j < resIds.length; j++) {
									if(allRows[i].id == resIds[j]){
										pubRef.datagrid('checkRow',pubRef.datagrid('getRowIndex',allRows[i]));
										continue;
									}
								}
							}
						}
					},
				});
		$('#form').form({
			url : '${pageContext.request.contextPath}/user/grantWarehouse',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				var nodes = pubRef.datagrid('getChecked');
				var ids = [];
				if (nodes && nodes.length > 0) {
					for (var i = 0; i < nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					$('#warehouseIds').val(ids.join(','));
				}else{
					$('#warehouseIds').val('');
				}

				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.status == 200) {
					parent.$.messager.show({
						title : '提示',
						msg : '仓库分配成功！',
						timeout : 3000,
						showType : 'slide'

					});
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
	});
	function checkAll() {
		var nodes = pubRef.datagrid('checkAll');
	}
	function uncheckAll() {
		var nodes = pubRef.datagrid('uncheckAll');
	}
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'east',title:'快捷方式'" style="width: 150px;">
		<div class="well well-large">
			<button class="btn btn-success" onclick="checkAll();">全选</button>
			<br /> <br />
			<button class="btn btn-inverse" onclick="uncheckAll();">取消</button>
		</div>
	</div>
	<div data-options="region:'center',title:'资源列表'"
		style="padding: 0 px;">
		<table id="pubRef"></table>
		<form id="form" method="post">
			<input id="userId" name="userId" value="${warehouse.userId}" type="hidden" /> <input
				id="warehouseIds" name="warehouseIds" value="${warehouse.warehouseIds}" type="hidden" />
		</form>
	</div>
</div>
