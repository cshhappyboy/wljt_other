<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cotherbizid;//出库业务员
	var cbizid;//入库业务员
	var coutwarehouseid;//出库仓库
	var cotherwhid;//入库仓库
	var whstransBDataGrid;
	var editRow = undefined;
	$(function() {
		parent.$.messager.progress('close');
		
		cotherbizid = $('#cotherbizid').textbox({
			readonly:true,
		});

		if(cotherbizid.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/psndoc/trans/'+cotherbizid.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cotherbizid.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		cbizid = $('#cbizid').textbox({
			readonly:true,
		});
		
		if(cbizid.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/psndoc/trans/'+cbizid.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cbizid.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		coutwarehouseid = $('#coutwarehouseid').textbox({
			readonly:true,
		});
		
		if(coutwarehouseid.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/storedoc/trans/'+coutwarehouseid.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							coutwarehouseid.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		cotherwhid = $('#cotherwhid').textbox({
			readonly:true,
		});
		
		if(cotherwhid.textbox('getValue')){
			$.ajax({  
		          type : 'get',  
		          url : '${pageContext.request.contextPath}/storedoc/trans/'+cotherwhid.textbox('getValue'),  
		          async : false,  
		          success : function(result) {
						result = $.parseJSON(result);
						if(result.status==200){
							cotherwhid.textbox('setText',result.data);
						}
		          }
		     }); 
		}
		
		whstransBDataGrid = $('#whstransBDataGrid').datagrid({
			url : '${pageContext.request.contextPath}/whstrans/qryWhstransBVOs?id=${billHid}',
			selectOnCheck : false,
			checkOnSelect : false,
			idField : 'id',
			fit : true,
			rownumbers : true,
			frozenColumns:[[ {
				field : 'id',
				title : '<spring:message code="id" />',
				width : 120,
				hidden : true,
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
			}, {
				field : 'vtransrate',
				title : '<spring:message code="vtransrate" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'vbatchcode',
				title : '<spring:message code="vbatchcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
			}, {
				field : 'vbdef1',
				title : '数量',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(4);
					}
				}
			},{
				field : 'ntrsassistnum',
				title : '<spring:message code="ntrsassistnum" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(4);
					}
				},
			}, {
				field : 'ntrsnnum',
				title : '<spring:message code="ntrsnnum" />',
				width : 120,
				align : 'left',
				halign : 'center',
				formatter : function(value, row, index) {
					if (row != null && value != null && value != '') {
						return parseFloat(value).toFixed(4);
					}
				},
			}, {
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
				field : 'vbdef2',
				hidden:true,
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
<div class="easyui-layout" data-options="fit:true,bwhstrans:false">
	<div data-options="region:'north',bwhstrans:false" title=""
		style="overflow: hidden; background: #eee;">
		<form id="form" method="post">
			<table align="center">
				<tr>
					<input name="id" style="display: none;" value="${whstransHVO.id}">
					<input name="vbilltype" style="display: none;" value="${whstransHVO.vbilltype}">
				</tr>
				<tr>
					<th><spring:message code="cbilltype" /></th>
					<td><input name="cbilltype" class="easyui-combobox" data-options="readonly:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:75,url:'${pageContext.request.contextPath}/billtype/4K'"
						 value="${whstransHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode" class="easyui-textbox" data-options="readonly:true,"
						value="${whstransHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" type="text" class="easyui-datebox"
						required="required" data-options="readonly:true," 
						value="${whstransHVO.dbilldate}"></td>
					<th><spring:message code="cotherwhid" /></th>
					<td><input id="cotherwhid" name="cotherwhid" 
						 value="${whstransHVO.cotherwhid}"></td>
				</tr>
				<tr>
					<th><spring:message code="coutwarehouseid" /></th>
					<td><input id="coutwarehouseid" name="coutwarehouseid"
						 value="${whstransHVO.coutwarehouseid}"></td>
					<th><spring:message code="cbizid" /></th>
					<td><input id="cbizid" name="cbizid"  
						value="${whstransHVO.cbizid}"></td>
					<th><spring:message code="cotherbizid" /></th>
					<td><input id="cotherbizid" name="cotherbizid" 
						 value="${whstransHVO.cotherbizid}"></td>
					<th><spring:message code="vbillstatus" /></th>
					<td><input name="vbillstatus" class="easyui-combobox" data-options="readonly:true,valueField: 'key',textField: 'value', data: [{key: '0',value: '<spring:message code="free" />'},{key: '1',value: '<spring:message code="approved" />'},{key: '1',value: '<spring:message code="synced" />'}],panelHeight:50"
						value="${whstransHVO.vbillstatus}"></td>
				</tr>
				<tr>
					<th><spring:message code="memo" /></th>
					<td><input name="memo" class="easyui-textbox" data-options="readonly:true,"
						value="${whstransHVO.memo}"></td>
					<th><spring:message code="issync" /></th>
					<td><input name="issync" class="easyui-combobox" data-options="readonly:true,panelHeight:50,valueField: 'value',textField: 'text',data:[{'value':0,'text':'<spring:message code="no" />'},{'value':1,'text':'<spring:message code="yes" />'}]"
						value="${whstransHVO.issync}"></td>
				</tr>
				<tr>
					<td><input name="billmaker" style="display: none;"
						value="${whstransHVO.billmaker}"></td>
					<td><input name="billmaketime"  style="display: none;"
						value="${whstransHVO.billmaketime}"></td>
					<td><input name="modifier"  style="display: none;"
						value="${whstransHVO.modifier}"></td>
					<td><input name="modifiedtime"  style="display: none;" 
						value="${whstransHVO.modifiedtime}"></td>
					<td><input name="approver"  style="display: none;" 
						value="${whstransHVO.approver}"></td>
					<td><input name="approvetime"  style="display: none;" 
						value="${whstransHVO.approvetime}"></td>
				</tr>
				<tr>
					<td><input name="ts" style="display: none;"
						value="${whstransHVO.ts}"></td>
					<td><input name="dr" style="display: none;"
						value="${whstransHVO.dr}"></td>
					<td><input name="pkGroup"  style="display: none;"
						value="${whstransHVO.pkGroup}"></td>
					<td><input name="pkOrg"  style="display: none;"
						value="${whstransHVO.pkOrg}"></td>
				</tr>
				<tr>
					<td><input name="vdef1" style="display: none;"
						value="${whstransHVO.vdef1}"></td>
					<td><input name="vdef2"  style="display: none;"
						value="${whstransHVO.vdef2}"></td>
					<td><input name="vdef3" style="display: none;"
						value="${whstransHVO.vdef3}"></td>
					<td><input name="vdef4"  style="display: none;"
						value="${whstransHVO.vdef4}"></td>
					<td><input name="vdef5"  style="display: none;"
						value="${whstransHVO.vdef5}"></td>
					<td><input name="vdef6"  style="display: none;"
						value="${whstransHVO.vdef6}"></td>
					<td><input name="vdef7" style="display: none;"
						value="${whstransHVO.vdef7}"></td>
					<td><input name="vdef8"  style="display: none;"
						value="${whstransHVO.vdef8}"></td>
					<td><input name="vdef9" style="display: none;"
						value="${whstransHVO.vdef9}"></td>
					<td><input name="vdef10"  style="display: none;"
						value="${whstransHVO.vdef10}"></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',title:''" style="background: #eee;">
		<table id="whstransBDataGrid"></table>
	</div>
</div>