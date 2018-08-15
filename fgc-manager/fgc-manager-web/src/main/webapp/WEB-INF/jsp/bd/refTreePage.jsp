<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var pubRef;
	var filterData;
	var queryParams = {};
	$(function() {
		parent.$.messager.progress('close');
		pubRef = $('#pubRef').tree({
			url : parent.$.refDialog.refURLPath,
			parentField : 'pid',
			onLoadSuccess : function(data) {
				pubRef.tree('expandAll');
				parent.$.messager.progress('close');
			},
			onDblClick : function(node) {
				if(pubRef.tree('isLeaf',node.target)){
					var textbox = parent.$.refDialog.textbox;
					textbox.textbox('setValue', node.id);
					textbox.textbox('setText', node.attributes.name);
					parent.$.refDialog.handler.dialog('close');
				}else{
					pubRef.tree('expand',node.target);
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
	filterAction = function(filterValue) {
		queryParams = {
			'filterData' : filterValue
		};
		pubRef.tree({
			queryParams : queryParams,
		});
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
	<div data-options="region:'center',title:''">
		<ul id="pubRef"></ul>
	</div>
</div>