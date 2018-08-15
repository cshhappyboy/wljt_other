<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var pubRef;
	var filterData;
	$(function() {
		parent.$.messager.progress('close');
		pubRef = $('#pubRef').datagrid({
			url : parent.$.refDialog.refURLPath,
			singleSelect:true,
			idField : 'id',
			fit : true,
			rownumbers : true,
			columns : [ [ {
				field : 'id',
				title : '<spring:message code="id" />',
				width : 100,
				hidden : true,
				align : 'left',
				halign : 'center',
			}, {
				field : 'code',
				title : '<spring:message code="code" />',
				width : 250,
				align : 'left',
				halign : 'center',
			}, {
				field : 'name',
				title : '<spring:message code="name" />',
				width : 250,
				align : 'left',
				halign : 'center',
			} ] ],
			onDblClickRow:function(index, row){
				var datagrid = parent.$.refDialog.datagrid;
				var editRow = parent.$.refDialog.datagrid.editRow;
				var ed = datagrid.datagrid('getEditor',{index:editRow,field:'delwarehouse'});
				if(ed){
					ed.target.textbox('setValue',row.id);
				}
				ed = datagrid.datagrid('getEditor',{index:editRow,field:'delwarehousecode'});
				if(ed){
					ed.target.textbox('initValue',row.name);
				}
				parent.$.refDialog.handler.dialog('close');
			}
		});
			
		filterData = $('#filterData').textbox({
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					var filterValue = filterData.textbox('getValue');
					filterAction(filterValue);
				}
			} ],
			onChange:function(newValue,oldValue){
				if(newValue != oldValue){
					filterAction(newValue);
				}
				
			}
		});
	});
	filterAction = function(filterValue){
		pubRef.datagrid('load',{'filterData':filterValue});
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false" title=""
		style="overflow: hidden; background: #eee;">
		<form id="form" method="post">
			<table align="left">
				<tr>
					<th><spring:message code="filter" /></th>
					<td><input id="filterData"></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',title:''" style="background: #eee;">
		<table id="pubRef"></table>
	</div>
</div>