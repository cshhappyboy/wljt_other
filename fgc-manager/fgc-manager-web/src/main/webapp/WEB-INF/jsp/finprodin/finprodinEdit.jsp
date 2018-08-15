<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	var cdept;//部门
	var salesman;//业务员
	var cwarehouseid;//仓库
	var finprodinBDataGrid;
	$(function() {
		parent.$.messager.progress('close');
		
		cdept = $("#cdept").textbox({
			required:true,
			editable:false,
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="cdept" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refTreePage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/cdept/data';
							parent.$.refDialog.textbox = cdept;
						}
					});
				}
			} ]
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
			editable:false,
			onChange:function(newValue, oldValue){
				if(newValue){
					$.ajax({  
				         type : 'get',  
				          url : '${pageContext.request.contextPath}/psndoc/cdept/'+newValue,  
				          async : false,
				          success : function(result) {
								result = $.parseJSON(result);
								if(result.status == 200){
									var billtype = $.parseJSON(result.data);
									cdept.textbox('setValue',billtype.billtype_id);
									cdept.textbox('setText',billtype.billtype_name);
								}
				          }
				     });
				}
			},
			icons : [ {
				iconCls : 'icon-search',
				handler : function(e) {
					parent.$.refDialog({
						title : '<spring:message code="salesman" />',
						width : 600,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/psndoc/data';
							parent.$.refDialog.textbox = salesman;
							parent.$.refDialog.textbox_one = cdept
						}
					});
				}
			} ]
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
			editable:false,
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					parent.$.refDialog({
						title : '<spring:message code="cwarehouseid" />',
						width : 700,
						height : 500,
						href : '${pageContext.request.contextPath}/pub/refPage',
						onBeforeLoad:function(){
							parent.$.refDialog.refURLPath = '${pageContext.request.contextPath}/storedoc/data'
							parent.$.refDialog.textbox = cwarehouseid;
						}
					});
			}}]
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
			singleSelect:true,
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
										parent.$.refDialog.datagrid = finprodinBDataGrid;
										parent.$.refDialog.datagrid.editRow = parent.$.modalDialog.last_edit_index;
									}
								});
						}}],
						onChange:function(newValue, oldValue){
							var srow = finprodinBDataGrid.datagrid('getSelected');
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
											var rindex = finprodinBDataGrid.datagrid('getRowIndex', srow);
											if(result.total == 1){
												var row = result.rows[0];
												
												var ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialcode'
												});
												if(ed){
													ed.target.textbox('setValue', row.code);
												}
												
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'cmaterial'
												});
												if(ed){
													ed.target.textbox('setValue', row.id);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialname'
												});
												if(ed){
													textbox = ed.target.textbox('textbox');
													textbox.val(row.name);
												}

												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialspec'
												});
												if(ed){
													ed.target.textbox('setValue',row.spec);
												}
										
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialtype'
												});
												if(ed){
													ed.target.textbox('setValue',row.type);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'castunitid'
												});
												if(ed){
													ed.target.textbox('setValue', row.fumeasdoc);
													textbox = ed.target.textbox('textbox');
													textbox.val(row.fumeasdocname);
												}

												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vtransrate'
												});
												if(ed){
													ed.target.textbox('setValue', row.measrate);
												}
												
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vunitratio'
												});
												if(ed){
													ed.target.textbox('setValue', row.vunitratio);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'cunitid'
												});
												
												if(ed){
													ed.target.textbox('setValue', row.zhumeasdoc);
													textbox = ed.target.textbox('textbox');
													textbox.val(row.zhumeasdocname);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vbatchcode'
												});
												if(ed){
													if(row.isBatch == 0){
														ed.target.textbox('readonly',true);
													}else{
														ed.target.textbox('readonly',false);
													}
												}
											}else{
												var ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'cmaterial'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialcode'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialname'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}

												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialspec'
												});
												if(ed){
													ed.target.textbox('setValue',null);
												}
										
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'materialtype'
												});
												if(ed){
													ed.target.textbox('setValue',null);
												}

												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'castunitid'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}

												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vtransrate'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
													index : rindex,
													field : 'vunitratio'
												});
												if(ed){
													ed.target.textbox('setValue', null);
												}
												ed = finprodinBDataGrid.datagrid('getEditor', {
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
			columns : [ [{
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
                editor : {
					type : 'numberbox',
					options : {
						precision:4,
						required:true,
						onChange:function(newValue,oldValue){
							var row = finprodinBDataGrid.datagrid('getSelected');
							var rindex = finprodinBDataGrid.datagrid('getRowIndex', row);
							
							var ninnumED = finprodinBDataGrid.datagrid('getEditor', {
								index : rindex,
								field : 'ninnum'
							});
							var ninnum = ninnumED.target.numberbox('getValue');
							if(ninnum){
								var costunitmnyED = finprodinBDataGrid.datagrid('getEditor', {
									index : rindex,
									field : 'costunitmny'
								});
								costunitmnyED.target.numberbox('setValue',$.MMNumberMul(newValue,ninnum));
							}
						}
					}
				}
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
                editor : {
					type : 'numberbox',
					options : {
						readonly:true,
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
			} ,{
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
			},{
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
                editor : {
					type : 'numberbox',
					options : {
						precision:4,
						onChange:function(newValue,oldValue){
							var row = finprodinBDataGrid.datagrid('getSelected');
							var rindex = finprodinBDataGrid.datagrid('getRowIndex', row);
							
							if(newValue && oldValue && row.vsrcid && $.MMNumberSub(newValue,oldValue)> 0){
								var ninassistnumED = finprodinBDataGrid.datagrid('getEditor', {
									index : rindex,
									field : 'ninassistnum'
								});
								ninassistnumED.target.numberbox('setValue',oldValue);
								return ;
							}
							
							var measrate =row.vtransrate;
							var measrateArray = measrate.split('/');
							measrate = $.MMNumberDiv(measrateArray[0],measrateArray[1]);
							if(measrate){
								var ninnumED = finprodinBDataGrid.datagrid('getEditor', {
									index : rindex,
									field : 'ninnum'
								});
								ninnumED.target.numberbox('setValue',$.MMNumberMul(measrate,newValue));
							}
							
						}
					}
				}
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
                editor : {
					type : 'numberbox',
					options : {
						precision:4,
						readonly:true,
						onChange:function(newValue,oldValue){
							var row = finprodinBDataGrid.datagrid('getSelected');
							var rindex = finprodinBDataGrid.datagrid('getRowIndex', row);
							
							var costunitpriceED = finprodinBDataGrid.datagrid('getEditor', {
								index : rindex,
								field : 'costunitprice'
							});
							var costunitprice = costunitpriceED.target.numberbox('getValue');
							if(costunitprice){
								var costunitmnyED = finprodinBDataGrid.datagrid('getEditor', {
									index : rindex,
									field : 'costunitmny'
								});
								costunitmnyED.target.numberbox('setValue',$.MMNumberMul(newValue,costunitprice));
							}
						}
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
						readonly:true,
					}
				}
			},{
				field : 'dbizindate',
				title : '<spring:message code="dbizindate" />',
				width : 120,
				align : 'left',
				halign : 'center',
				 editor : {
						type : 'datebox',
						options : {
						}
					}
			},{
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
				editor : {
					type : 'textbox',
					options : {
					}
				}
			},{
				field : 'vsrcbid',
				hidden:true,
				editor : {
					type : 'textbox',
					options : {
					}
				}
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
                editor : {
					type : 'numberbox',
					options : {precision:4,
						readonly:true
						}
				}
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
                editor : {
					type : 'numberbox',
					options : {precision:4,
						readonly:true,}
				}
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
					finprodinBDataGrid.datagrid('beginEdit', rowIndex);
					transData(finprodinBDataGrid,rowIndex,row);
					parent.$.modalDialog.last_edit_index = rowIndex;
				} else {
					finprodinBDataGrid.datagrid('clearSelections');
					finprodinBDataGrid.datagrid('selectRow', parent.$.modalDialog.last_edit_index);
				}
			},
		});
		parent.$.modalDialog.inner_datagrid = finprodinBDataGrid;
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
		if(row.cunitid){
			$.ajax({  
		         type : 'get',  
		         url : '${pageContext.request.contextPath}/castunit/trans/'+row.cunitid,    
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
			if (finprodinBDataGrid.datagrid('validateRow', parent.$.modalDialog.last_edit_index)) {
				finprodinBDataGrid.datagrid('clearSelections').datagrid(
						'endEdit', parent.$.modalDialog.last_edit_index);
				parent.$.modalDialog.last_edit_index = undefined;
			} else {
				return;
			}
		}
		$('#finprodinBDataGrid').datagrid('insertRow', {
			row : {}
		});
	}
	/**
	 * 暂时没有想到更好的办法，只能一次允许删除一行
	 */
	deleteRow = function() {
		if (parent.$.modalDialog.last_edit_index != undefined) {
			if (finprodinBDataGrid.datagrid('validateRow', parent.$.modalDialog.last_edit_index)) {
				finprodinBDataGrid.datagrid('endEdit', parent.$.modalDialog.last_edit_index);
			} else {
				finprodinBDataGrid.datagrid('cancelEdit', parent.$.modalDialog.last_edit_index);
			}
			finprodinBDataGrid.datagrid('deleteRow', parent.$.modalDialog.last_edit_index);
			parent.$.modalDialog.last_edit_index = undefined;
		}
	}
	endEditing = function() {
		if (parent.$.modalDialog.last_edit_index == undefined) {
			return true;
		}
		if (finprodinBDataGrid.datagrid('validateRow', parent.$.modalDialog.last_edit_index)) {
			finprodinBDataGrid.datagrid('endEdit', parent.$.modalDialog.last_edit_index);
			parent.$.modalDialog.last_edit_index = undefined;
			return true;
		} else {
			return false;
		}
	}
</script>
<div class="easyui-layout" data-options="fit:true,bfinprodin:false">
	<div data-options="region:'north',bfinprodin:false" title=""
		style="overflow: hidden; background: #eee;">
		<form id="form" method="post">
			<table align="center">
				<tr>
					<input name="id" style="display: none;" value="${finprodinHVO.id}">
					<input name="vbilltype" style="display: none;" value="${finprodinHVO.vbilltype}">
				</tr>
				<tr>
					<th><spring:message code="cbilltype" /></th>
					<td><input name="cbilltype" class="easyui-combobox" data-options="readonly:true,valueField:'billtype_id',textField:'billtype_name',panelHeight:25,url:'${pageContext.request.contextPath}/billtype/46'"
						 value="${finprodinHVO.cbilltype}"></td>
					<th><spring:message code="vbillcode" /></th>
					<td><input name="vbillcode" class="easyui-textbox" data-options="readonly:true"
						value="${finprodinHVO.vbillcode}"></td>
					<th><spring:message code="dbilldate" /></th>
					<td><input name="dbilldate" type="text" class="easyui-datebox"
						required="required" data-options="editable:false" 
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
					<td><input name="memo" class="easyui-textbox" 
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