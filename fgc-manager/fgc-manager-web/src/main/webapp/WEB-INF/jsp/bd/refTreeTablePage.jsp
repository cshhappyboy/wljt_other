<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var pubRef;
	var filterData;
	var classPubRef;
	var classFilterData;
	var queryParams = {};
	$(function() {
		parent.$.messager.progress('close');

		classPubRef = $('#classPubRef').tree({
			url : parent.$.refDialog.refURLPath,
			parentField : 'pid',
			queryParams : queryParams,
			onLoadSuccess : function(data) {
				parent.$.messager.progress('close');
			},
			onDblClick : function(node) {
				classPubRef.tree('toggle', node.target);
			},
			onBeforeLoad : function(node, param) {
				if (param.id) {
					param.filterData = null;
				}
			},
			onClick : function(node) {
				pubRef.datagrid('load', {
					'classId' : node.id
				});
			}
		});

		classFilterData = $('#classFilterData').textbox({
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					var filterValue = classFilterData.textbox('getValue');
					classFilterAction(filterValue);
				}
			} ],
			onChange : function(newValue, oldValue) {
				if (newValue != oldValue) {
					classFilterAction(newValue);
				}

			}
		});

		pubRef = $('#pubRef').datagrid(
				{
					url : parent.$.refDialog.refCmaterialDataURL,
					singleSelect : true,
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
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'name',
						title : '<spring:message code="name" />',
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'spec',
						title : '<spring:message code="materialspec" />',
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'type',
						title : '<spring:message code="materialtype" />',
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'xiaoshoumeasdoc',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'fumeasdoc',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'zhumeasdoc',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'fumeasdocname',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'zhumeasdocname',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'xiaoshoumeasdocname',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'measrate',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'fee',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					} , {
						field : 'vunitratio',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					}, {
						field : 'isBatch',
						hidden : true,
						width : 150,
						align : 'left',
						halign : 'center',
					} ] ],
					onLoadSuccess : function(data) {
						parent.$.refDialog.ref_datagrid = pubRef;
					},
					onDblClickRow : function(index, row) {
						if (parent.$.refDialog.datagrid) {
							var datagrid = parent.$.refDialog.datagrid;
							var editRow = parent.$.refDialog.datagrid.editRow;
							var ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'cmaterial'
							});
							if(ed){
								ed.target.textbox('setValue', row.id);
							}
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'materialcode'
							});
							if(ed){
								ed.target.textbox('initValue', row.code);
							}
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'materialname'
							});
							if(ed){
								textbox = ed.target.textbox('textbox');
								textbox.val(row.name);
							}

							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'materialspec'
							});
							if(ed){
								ed.target.textbox('setValue',row.spec);
							}
					
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'materialtype'
							});
							if(ed){
								ed.target.textbox('setValue',row.type);
							}

							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'csaleunitid'
							});
							if(ed){
								ed.target.textbox('setValue', row.xiaoshoumeasdoc);
								textbox = ed.target.textbox('textbox');
								textbox.val(row.xiaoshoumeasdocname);
							}
							
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'castunitid'
							});
							if(ed){
								ed.target.textbox('setValue', row.fumeasdoc);
								textbox = ed.target.textbox('textbox');
								textbox.val(row.fumeasdocname);
							}

							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'measrate'
							});
							if(ed){
								ed.target.textbox('setValue', row.measrate);
							}
							
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'vtransrate'
							});
							if(ed){
								ed.target.textbox('setValue', row.measrate);
							}
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'services'
							});
							if(ed){
								ed.target.combobox('setValue', row.fee);
								var delwarehouseED = datagrid.datagrid('getEditor', {
									index : editRow,
									field : 'delwarehousecode'
								});
								if(delwarehouseED && row.fee == 1){
								    delwarehouseED.target.textbox({required:false});
								}
							}
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'vunitratio'
							});
							if(ed){
								ed.target.textbox('setValue', row.vunitratio);
							}
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'cunitid'
							});
							if(ed){
								ed.target.textbox('setValue', row.zhumeasdoc);
								textbox = ed.target.textbox('textbox');
								textbox.val(row.zhumeasdocname);
							}
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'sizecode'
							});
							if(ed){
								if(row.isBatch == 0){
									ed.target.textbox('readonly',true);
								}else{
									ed.target.textbox('readonly',false);
								}
							}
							ed = datagrid.datagrid('getEditor', {
								index : editRow,
								field : 'vbatchcode'
							});
							if(ed){
								if(row.isBatch == 0){
									ed.target.textbox({required:false});
								}else{
									ed.target.textbox({required:true});
								}
							}
						}else{
							var textbox = parent.$.refDialog.textbox;
							textbox.textbox('setValue',row.id);
							textbox.textbox('setText',row.code);
						}
						parent.$.refDialog.datagrid = undefined;
						parent.$.refDialog.textbox = undefined;
						parent.$.refDialog.handler.dialog('close');
					},
					onBeforeLoad : function(param) {
						if (param.classId || param.filterData) {
							return true;
						} else {
							return false;
						}
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
			onChange : function(newValue, oldValue) {
				if (newValue != oldValue) {
					filterAction(newValue);
				}

			}
		});
	});

	classFilterAction = function(filterValue) {
		queryParams.filterData = filterValue;
		classPubRef.tree('reload');
	}

	filterAction = function(filterValue) {
		pubRef.datagrid('load', {
			'filterData' : filterValue
		});
	}
</script>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west',split:true"
		style="width: 230px; overflow: hidden;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',split:true,border:false"
				style="overflow: hidden; background: #eee; height: 30px">
				<form id="form" method="post">
					<table align="left">
						<tr>
							<th><spring:message code="filter" /></th>
							<td><input id="classFilterData"></td>
						</tr>
					</table>
				</form>
			</div>
			<div data-options="region:'center'">
				<ul id="classPubRef"></ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',split:true,border:false"
				style="background: #eee; height: 30px">
				<form id="form" method="post">
					<table align="left">
						<tr>
							<th><spring:message code="filter" /></th>
							<td><input id="filterData"></td>
						</tr>
					</table>
				</form>
			</div>
			<div data-options="region:'center'">
				<table id="pubRef"></table>
			</div>
		</div>
	</div>

</div>