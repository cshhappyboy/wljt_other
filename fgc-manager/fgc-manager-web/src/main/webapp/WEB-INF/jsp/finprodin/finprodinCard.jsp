<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cdept;//部门
	var salesman;//业务员
	var cwarehouseid;//仓库
// 	var cdept;//部门
	var finprodinBDataGrid;
	var editRow = undefined;
	$(function() {
		parent.$.messager.progress('close');
		
		cdept = $("#cdept").textbox({
			readonly:true,
		});
		
		if(cdept.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/cdept/trans/'+cdept.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cdept.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		salesman = $('#salesman').textbox({
			readonly:true,
		});
		
		if(salesman.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/psndoc/trans/'+salesman.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							salesman.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		cwarehouseid = $('#cwarehouseid').textbox({
			readonly:true,
		});
		
		if(cwarehouseid.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/storedoc/trans/'+cwarehouseid.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cwarehouseid.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		finprodinBDataGrid = $('#finprodinBDataGrid').datagrid({
			url : '${pageContext.request.contextPath}/finprodin/qryFinprodinBVOs?id=${billHid}',
			selectOnCheck : false,
			checkOnSelect : false,
			idField : 'id',
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
			columns : [ [{
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
				field : 'costunitprice',
				title : '<spring:message code="costunitprice" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(4);
                    }
                },
			},{
				field : 'costunitmny',
				title : '<spring:message code="costunitmny" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(0);
                    }
                },
			}, {
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
			} ,{
				field : 'vtransrate',
				title : '<spring:message code="vtransrate" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'ninnum',
				title : '<spring:message code="ninnum" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(4);
                    }
                },
			}, {
				field : 'ninassistnum',
				title : '<spring:message code="ninassistnum" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(4);
                    }
                },
			}, {
				field : 'vbatchcode',
				title : '<spring:message code="vbatchcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'dbizindate',
				title : '<spring:message code="dbizindate" />',
				width : 120,
				align : 'left',
				halign : 'center',
			},{
				field : 'momen',
				title : '<spring:message code="momen" />',
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
				field : 'vbdef1',
				title : '<spring:message code="exchangerate" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(4);
                    }
                },
			},{
				field : 'vbdef2',
				title : '<spring:message code="salesamount" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter: function (value, row, index) {
                    if (row != null && value != null && value !='') {
                        return parseFloat(value).toFixed(4);
                    }
                },
			},{
				field : 'vbdef3',
				hidden:true,
			},{
				field : 'vbdef4',
				hidden:true,
			},{
				field : 'vbdef5',
				hidden:true,
			},{
				field : 'vbdef6',
				hidden:true,
			},{
				field : 'vbdef7',
				hidden:true,
			},{
				field : 'vbdef8',
				hidden:true,
			},{
				field : 'vbdef10',
				hidden:true,
			},{
				field : 'issync',
				hidden:true,
			},{
				field : 'ts',
				hidden:true,
			},{
				field : 'dr',
				hidden:true,
			}] ],
		});
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,bfinprodin:false">
	<div data-options="region:'north',bfinprodin:false" title=""
		style="overflow: hidden; background: #eee;">
		<form id="form" method="post">
			<table align="center">
				<tr>
					<input name="id" style="display: none;" value="${finprodinHVO.id}">
					<input name="vbilltype" style="display: none;" value="${invoiceHVO.vbilltype}">
				</tr>
				<tr>
					<th><spring:message code="cbilltype" /></th>
					<td><input name="cbilltype" class="easyui-combobox" data-options="readonly:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:25,url:'${pageContext.request.contextPath}/billtype/46'"
						 value="${finprodinHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode" class="easyui-textbox" data-options="readonly:true"
						value="${finprodinHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" type="text" class="easyui-datebox" data-options="readonly:true," 
						value="${finprodinHVO.dbilldate}"></td>
					<th><spring:message code="ntotalnum" /></th>
					<td><input id="ntotalnum" name="ntotalnum"
						class="easyui-numberbox" data-options="readonly:true,precision:4"
						 value="${finprodinHVO.ntotalnum}"></td>
				</tr>
				<tr>
					<th><spring:message code="cdept" /></th>
					<td><input id="cdept" name="cdept"  
						 value="${finprodinHVO.cdept}"></td>
					<th><spring:message code="cwarehouseid" /></th>
					<td><input id="cwarehouseid" name="cwarehouseid" 
						 value="${finprodinHVO.cwarehouseid}"></td>
					<th><spring:message code="vbillstatus" /></th>
					<td><input name="vbillstatus" class="easyui-combobox" data-options="readonly:true,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '2',value: '<spring:message code="sign" />'}],panelHeight:50"
						value="${finprodinHVO.vbillstatus}"></td>
					<th><spring:message code="memo" /></th>
					<td><input name="memo" class="easyui-textbox" data-options="readonly:true," 
						value="${finprodinHVO.memo}"></td>
				</tr>
				<tr>
					<th><spring:message code="salesman" /></th>
					<td><input id="salesman" name="salesman" 
						 value="${finprodinHVO.salesman}"></td>
					<th><spring:message code="vorderbillcode" /></th>
					<td><input name="vorderbillcode" class="easyui-textbox" data-options="readonly:true,"
						value="${finprodinHVO.vorderbillcode}"></td>
					<th><spring:message code="effectbillcode" /></th>
					<td><input name="effectbillcode" class="easyui-textbox" data-options="readonly:true,"
						value="${finprodinHVO.effectbillcode}"></td>
					<th><spring:message code="issync" /></th>
					<td><input name="issync" class="easyui-combobox" data-options="readonly:true,panelHeight:50,valueField: 'value',textField: 'text',data:[{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]"
						value="${finprodinHVO.issync}"></td>
				</tr>
				<tr>
					<td><input name="billmaker" style="display: none;"
						value="${finprodinHVO.billmaker}"></td>
					<td><input name="billmaketime"  style="display: none;"
						value="${finprodinHVO.billmaketime}"></td>
					<td><input name="modifier"  style="display: none;"
						value="${finprodinHVO.modifier}"></td>
					<td><input name="modifiedtime"  style="display: none;" 
						value="${finprodinHVO.modifiedtime}"></td>
					<td><input name="approver"  style="display: none;" 
						value="${finprodinHVO.approver}"></td>
					<td><input name="approvetime"  style="display: none;" 
						value="${finprodinHVO.approvetime}"></td>
				</tr>
				<tr>
					<td><input name="ts" style="display: none;"
						value="${finprodinHVO.ts}"></td>
					<td><input name="dr"  style="display: none;"
						value="${finprodinHVO.dr}"></td>
					<td><input name="vsrcid" style="display: none;"
						value="${finprodinHVO.vsrcid}"></td>
					<td><input name="vsrccode"  style="display: none;"
						value="${finprodinHVO.vsrccode}"></td>
					<td><input name="pkGroup"  style="display: none;"
						value="${finprodinHVO.pkGroup}"></td>
					<td><input name="pkOrg"  style="display: none;"
						value="${finprodinHVO.pkOrg}"></td>
				</tr>
				<tr>
					<td><input name="vdef1" style="display: none;"
						value="${finprodinHVO.vdef1}"></td>
					<td><input name="vdef2"  style="display: none;"
						value="${finprodinHVO.vdef2}"></td>
					<td><input name="vdef3" style="display: none;"
						value="${finprodinHVO.vdef3}"></td>
					<td><input name="vdef4"  style="display: none;"
						value="${finprodinHVO.vdef4}"></td>
					<td><input name="vdef5"  style="display: none;"
						value="${finprodinHVO.vdef5}"></td>
					<td><input name="vdef6"  style="display: none;"
						value="${finprodinHVO.vdef6}"></td>
					<td><input name="vdef7" style="display: none;"
						value="${finprodinHVO.vdef7}"></td>
					<td><input name="vdef8"  style="display: none;"
						value="${finprodinHVO.vdef8}"></td>
					<td><input name="vdef9" style="display: none;"
						value="${finprodinHVO.vdef9}"></td>
					<td><input name="vdef10"  style="display: none;"
						value="${finprodinHVO.vdef10}"></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',title:''" style="background: #eee;">
		<table id="finprodinBDataGrid"></table>
	</div>
	<div id="toolbar" style="display: none;">
		<div onclick="addRow();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_add'">
			<spring:message code="add_line" />
		</div>
		<div onclick="deleteRow();" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'pencil_delete'">
			<spring:message code="delete_line" />
		</div>

	</div>
</div>