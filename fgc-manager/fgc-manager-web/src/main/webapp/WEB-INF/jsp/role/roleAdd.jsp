<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$('#pid').combotree({    
    url: '${pageContext.request.contextPath}/role/roleTree',    
    parentField : 'pid',
	lines : true,
	panelHeight : 'auto',
	onLoadSuccess : function() {
		parent.$.messager.progress('close');
	}
}); 

$('#form').form({
	 url:'${pageContext.request.contextPath}/role/insertRole',    
	 onSubmit: function(){
		 parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			});
			var isValid = $(this).form('validate');
			if (!isValid) {
				parent.$.messager.progress('close');
			}
			return isValid;
	 },    
	 success:function(result){    
		parent.$.messager.progress('close');
		result = $.parseJSON(result);
		if (result.status == 200) {
			parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
			parent.layout_west_tree.tree('reload');
			parent.$.modalDialog.handler.dialog('close');
		}  
	 }    
});
</script>
<div class="easyui-layout" data-options="fit: true, border: false">
	<div data-options="region:'center',fit: true, border: false">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>角色名称</th>
					<td><input name="name" type="text" placeholder="请输入角色名称"
						class="easyui-validatebox span2" data-options="required:true"
						value=""></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>排序</th>
					<td><input name="seq" value="100" class="easyui-numberspinner"
						style="width: 140px; height: 29px;" required="required"
						data-options="editable:false,min:100"></td>
					<th>上级角色</th>
					<td><select id="pid" name="pid"
						style="width: 140px; height: 29px;"></select><img
						src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
						onclick="$('#pid').combotree('clear');" /></td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="3"><textarea name="remark" rows="" cols=""
							class="span5"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>