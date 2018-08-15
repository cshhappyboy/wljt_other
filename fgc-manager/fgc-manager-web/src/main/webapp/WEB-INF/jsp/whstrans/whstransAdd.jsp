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
	$(function() {
		parent.$.messager.progress('close');
		
		cotherbizid = $('#cotherbizid').textbox({
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="cotherbizid" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/psndoc/data';
							parent.$.refDialog.textbox = cotherbizid;
						}
					});
				}
			} ]
		});
		
		cbizid = $('#cbizid').textbox({
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="cbizid" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/psndoc/data';
							parent.$.refDialog.textbox = cbizid;
						}
					});
				}
			} ]
		});
		
		coutwarehouseid = $('#coutwarehouseid').textbox({
			required:true,
			editable:false,
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					parent.$.refDialog({
						title : '<spring:message code="coutwarehouseid" />',
						width : 700,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
							parent.$.refDialog.textbox = coutwarehouseid;
						}
					});
			}}]
		});
		
		cotherwhid = $('#cotherwhid').textbox({
			required:true,
			editable:false,
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					parent.$.refDialog({
						title : '<spring:message code="cotherwhid" />',
						width : 700,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
							parent.$.refDialog.textbox = cotherwhid;
						}
					});
			}}]
		});
		
		whstransBDataGrid = $('#whstransBDataGrid').datagrid({
			selectOnCheck : false,
			checkOnSelect : false,
			singleSelect:true,
			idField : 'id',
			fit : true,
			rownumbers : true,
			frozenColumns:[[{
				field : 'id',
				title : '<spring:message code="id" />',
				width : 120,
				hidden : true,
				align : 'left',
				halign : 'center',
			}, {
				field : 'cmaterial',
				width : 120,
				align : 'left',
				hidden:true,
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {
						readonly:true,
					}
				},
			},{
				field : 'materialcode',
				title : '<spring:message code="materialcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {
						required:true,
						icons: [{
							iconCls:'icon-search',
							handler: function(e){
								parent.$.refDialog({
									title : '<spring:message code="cmaterial" />',
									width : 700,
									height : 500,
									href : '${pageContext.request.contextPath}/pub/refTreeTablePage',
									onBeforeLoad:function(){
										parent.$.refDialog.refCmaterialDataURL = '${pageContext.request.contextPath}/cmaterial/data'
										parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cmaterial/class/data';
										parent.$.refDialog.datagrid = whstransBDataGrid;
										parent.$.refDialog.datagrid.editRow = parent.$.modalDialog.last_edit_index;
									}
								});
						}}],
						onChange:function(newValue, oldValue){
							var srow = whstransBDataGrid.datagrid('getSelected');
							if(newValue && srow){
								if(srow.materialcode == newValue){
									return;
								}
								$.ajax({  
							         type : 'get',  
							         url : '${pageContext.request.contextPath}/cmaterial/data?filterData='+newValue,    
							         async : false,
							         success : function(result) {
											result = $.parseJSON(result);
											var rindex = whstransBDataGrid.datagrid('getRowIndex', srow);
											if(result.total == 1){
												var row = result.rows[0];
												var ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialcode'
												});
												if(ed){
													ed.target.textbox('setValue', row.code);
												}
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'cmaterial'
												});
												if(ed){
													ed.target.textbox('setValue', row.id);
												}
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialname'
												});
												if(ed){
													textbox = ed.target.textbox('textbox');
													textbox.val(row.name);
												}

												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialspec'
												});
												if(ed){
													ed.target.textbox('setValue',row.spec);
												}
										
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialtype'
												});
												if(ed){
													ed.target.textbox('setValue',row.type);
												}

												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'castunitid'
												});
												if(ed){
													ed.target.textbox('setValue', row.fumeasdoc);
													textbox = ed.target.textbox('textbox');
													textbox.val(row.fumeasdocname);
												}

												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vtransrate'
												});
												if(ed){
													ed.target.textbox('setValue', row.measrate);
												}
												
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'cunitid'
												});
												
												if(ed){
													ed.target.textbox('setValue', row.zhumeasdoc);
													textbox = ed.target.textbox('textbox');
													textbox.val(row.zhumeasdocname);
												}
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vbatchcode'
												});
												if(ed){
													console.info(row.isBatch);
													if(row.isBatch == 0){
														ed.target.textbox({required:false});
													}else{
														ed.target.textbox({required:true});
													}
												}
											}else{
												var ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'cmaterial'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialcode'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialname'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}

												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialspec'
												});
												if(ed){
													ed.target.textbox('setValue',null);
												}
										
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialtype'
												});
												if(ed){
													ed.target.textbox('setValue',null);
												}

												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'castunitid'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}

												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vtransrate'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
												
												ed = whstransBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'cunitid'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
											}
							          }
							     });
							}
						}
					}
				},
			}, {
				field : 'materialname',
				title : '<spring:message code="materialname" />',
				width : 120,
				align : 'left',
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {
						readonly:true,
					}
				},
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
			columns : [ [ {
				field : 'materialspec',
				title : '<spring:message code="materialspec" />',
				width : 120,
				align : 'left',
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {
						readonly:true,
					}
				},
			}, {
				field : 'materialtype',
				title : '<spring:message code="materialtype" />',
				width : 120,
				align : 'left',
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {
						readonly:true,
					}
				},
			},{
				field : 'castunitid',
				title : '<spring:message code="castunitid" />',
				width : 120,
				align : 'left',
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {
						required: true,
						readonly:true,
					}
				},
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
				editor : {
					type : 'textbox',
					options : {
						readonly:true,
					}
				},
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
				editor : {
					type : 'textbox',
					options : {
						readonly:true,
					}
				}
			}, {
				field : 'vbatchcode',
				title : '<spring:message code="vbatchcode" />',
				width : 120,
				align : 'left',
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {
						
					}
				}
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
				},
				editor : {
					type : 'numberbox',
					options : {
						precision:4,
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
				editor : {
					type : 'numberbox',
					options : {
						precision:4,
						required:true,
						onChange:function(newValue,oldValue){
							var row = whstransBDataGrid.datagrid('getSelected');
							var rindex = whstransBDataGrid.datagrid('getRowIndex', row);
							
							var measrateED = whstransBDataGrid.datagrid('getEditor', {
								index : rindex,
								field : 'vtransrate'
							});
							var measrate = measrateED.target.numberbox('getValue');
							var measrateArray = measrate.split('/');
							measrate = $.MMNumberDiv(measrateArray[0],measrateArray[1]);
							if(measrate){
								var nnumED = whstransBDataGrid.datagrid('getEditor', {
									index : rindex,
									field : 'ntrsnnum'
								});
								nnumED.target.numberbox('initValue',$.MMNumberMul(measrate,newValue));
							}
						}
					}
				}
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
				editor : {
					type : 'numberbox',
					options : {
						precision:4,
						required:true,
						onChange:function(newValue,oldValue){
							var row = whstransBDataGrid.datagrid('getSelected');
							var rindex = whstransBDataGrid.datagrid('getRowIndex', row);
							
							var measrateED = whstransBDataGrid.datagrid('getEditor', {
								index : rindex,
								field : 'vtransrate'
							});
							var measrate = measrateED.target.numberbox('getValue');
							var measrateArray = measrate.split('/');
							measrate = $.MMNumberDiv(measrateArray[0],measrateArray[1]);
							if(measrate){
								var ntrsassistnumED = whstransBDataGrid.datagrid('getEditor', {
									index : rindex,
									field : 'ntrsassistnum'
								});
								ntrsassistnumED.target.numberbox('initValue',$.MMNumberDiv(newValue,measrate));
							}
						}
					}
				}
			}, {
				field : 'momen',
				title : '<spring:message code="momen" />',
				width : 120,
				align : 'left',
				halign : 'center',
				editor : {
					type : 'textbox',
					options : {

					}
				}
			} ,{
				field : 'vsrcid',
				hidden:true,
			},{
				field : 'vsrcbid',
				hidden:true,
			},{
				field : 'vbdef1',
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
			toolbar : '#toolbar',
			onClickRow : function(rowIndex, row) {//编辑行
				if (endEditing()) {
					whstransBDataGrid.datagrid('beginEdit', rowIndex);
					transData(whstransBDataGrid,rowIndex,row);
					parent.$.modalDialog.last_edit_index = rowIndex;
				} else {
					whstransBDataGrid.datagrid('clearSelections');
					whstransBDataGrid.datagrid('selectRow', parent.$.modalDialog.last_edit_index);
				}
			},
		});
		parent.$.modalDialog.inner_datagrid = whstransBDataGrid;
	});
	
	transData = function(datagrid,rowIndex,row){
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'materialname'});
		if(row.cmaterial){
			$.ajax({  
		         type : 'get',  
		          url : '${pageContext.request.contextPath}/cmaterial/transName/'+row.cmaterial,  
		          async : false,
		          success : function(result) {
						result = $.parseJSON(result);
						var textbox = ed.target.textbox('textbox');
						if(result.status==200){
							textbox.val(result.data);
						}
		          }
		     });
		}
		
		
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'castunitid'});
		if(row.castunitid){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/castunit/trans/'+row.castunitid,    
		         async : false,
		         success : function(result) {
						result = $.parseJSON(result);
						var textbox = ed.target.textbox('textbox');
						if(result.status==200){
							textbox.val(result.data);
						}
		          }
		     }); 
		}
		ed = datagrid.datagrid('getEditor',{index:rowIndex,field:'cunitid'});
		if(row.castunitid){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/castunit/trans/'+row.castunitid,    
		         async : false,
		         success : function(result) {
						result = $.parseJSON(result);
						var textbox = ed.target.textbox('textbox');
						if(result.status==200){
							textbox.val(result.data);
						}
		          }
		     }); 
		}
	}
	
	addRow = function() {
		if (parent.$.modalDialog.last_edit_index != undefined) {
			if (whstransBDataGrid.datagrid('validateRow', parent.$.modalDialog.last_edit_index)) {
				whstransBDataGrid.datagrid('clearSelections').datagrid(
						'endEdit', parent.$.modalDialog.last_edit_index);
				parent.$.modalDialog.last_edit_index = undefined;
			} else {
				return;
			}
		}
		$('#whstransBDataGrid').datagrid('insertRow', {
			row : {}
		});
	}
	/**
	 * 暂时没有想到更好的办法，只能一次允许删除一行
	 */
	deleteRow = function() {
		if (parent.$.modalDialog.last_edit_index != undefined) {
			if (whstransBDataGrid.datagrid('validateRow', parent.$.modalDialog.last_edit_index)) {
				whstransBDataGrid.datagrid('endEdit', parent.$.modalDialog.last_edit_index);
			} else {
				whstransBDataGrid.datagrid('cancelEdit', parent.$.modalDialog.last_edit_index);
			}
			whstransBDataGrid.datagrid('deleteRow', parent.$.modalDialog.last_edit_index);
			parent.$.modalDialog.last_edit_index = undefined;
		}
	}
	endEditing = function() {
		if (parent.$.modalDialog.last_edit_index == undefined) {
			return true;
		}
		if (whstransBDataGrid.datagrid('validateRow', parent.$.modalDialog.last_edit_index)) {
			whstransBDataGrid.datagrid('endEdit', parent.$.modalDialog.last_edit_index);
			parent.$.modalDialog.last_edit_index = undefined;
			return true;
		} else {
			return false;
		}
	}
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
					<td><input name="cbilltype" class="easyui-combobox" data-options="required:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:75,url:'${pageContext.request.contextPath}/billtype/4K'"
						 value="${whstransHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode" class="easyui-textbox"
						value="${whstransHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" type="text" class="easyui-datebox"
						required="required" data-options="editable:false" 
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
					<td><input name="memo" class="easyui-textbox" 
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