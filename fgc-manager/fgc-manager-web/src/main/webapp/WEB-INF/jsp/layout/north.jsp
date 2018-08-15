<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript" charset="utf-8">
	/**
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI,jQuery cookie plugin
	 * 
	 * 更换EasyUI主题的方法
	 * 
	 * @param themeName
	 *            主题名称
	 */
	function changeThemeFun(themeName) {
		if ($.cookie('easyuiThemeName')) {
			$('#layout_north_pfMenu').menu(
					'setIcon',
					{
						target : $('#layout_north_pfMenu div[title='
								+ $.cookie('easyuiThemeName') + ']')[0],
						iconCls : 'emptyIcon'
					});
		}
		$('#layout_north_pfMenu').menu('setIcon', {
			target : $('#layout_north_pfMenu div[title=' + themeName + ']')[0],
			iconCls : 'tick'
		});

		var $easyuiTheme = $('#easyuiTheme');
		var url = $easyuiTheme.attr('href');
		var href = url.substring(0, url.indexOf('themes')) + 'themes/'
				+ themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);

		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for (var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				try {
					$(ifr).contents().find('#easyuiTheme').attr('href', href);
				} catch (e) {
					try {
						ifr.contentWindow.document
								.getElementById('easyuiTheme').href = href;
					} catch (e) {
					}
				}
			}
		}
		$.cookie('easyuiThemeName', themeName, {
			expires : 7
		});

	};

	function logoutFun(b) {
		$.getJSON('${pageContext.request.contextPath}/user/logout', {
			t : new Date()
		}, function(result) {
			location.replace('${pageContext.request.contextPath}/login');
		});
	}

	function editCurrentUserPwd() {
		parent.$
				.modalDialog({
					title : '修改密码',
					width : 300,
					height : 250,
					href : '${pageContext.request.contextPath}/userController/editCurrentUserPwdPage',
					buttons : [ {
						text : '修改',
						handler : function() {
							var f = parent.$.modalDialog.handler
									.find('#editCurrentUserPwdForm');
							f.submit();
						}
					} ]
				});
	}
	function currentUserRole() {
		parent.$
				.modalDialog({
					title : '我的角色',
					width : 300,
					height : 250,
					href : '${pageContext.request.contextPath}/userController/currentUserRolePage'
				});
	}
	function currentUserResource() {
		parent.$
				.modalDialog({
					title : '我可以访问的资源',
					width : 300,
					height : 250,
					href : '${pageContext.request.contextPath}/userController/currentUserResourcePage'
				});
	}
	function changeYWDate(){
		parent.$
		.modalDialog({
			title : '<spring:message code="ywdate" />',
			width : 300,
			height : 150,
			href : '${pageContext.request.contextPath}/context/ywDate',
			buttons:[{
				text:'<spring:message code="ok" />',
				handler:function(){
					parent.$.modalDialog.handler.data
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			}],
		});
	}
</script>
<div id="sessionInfoDiv"
	style="position: absolute; left: 30px; top: 5px;"
	class="alert alert-info">
		<c:if test="${sessionInfo.id != null}">[<strong>${sessionInfo.name}</strong>]，欢迎你！当前业务日期：[<strong id="nowDate">${sessionInfo.nowDate}</strong>]</c:if>
</div>
<div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0);" class="easyui-menubutton"
		data-options="menu:'#layout_north_pfMenu',iconCls:'cog'">更换皮肤</a><a
		href="javascript:void(0);" class="easyui-linkbutton" onclick = 'logoutFun(true);'
		data-options="iconCls:'cog'"><spring:message code="exit" /></a>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/ywdate')}">
			<a href="javascript:void(0);" class="easyui-linkbutton" onclick = 'changeYWDate();'
		data-options="iconCls:'cog'"><spring:message code="ywdate" /></a>
		</c:if>
		
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeThemeFun('default');" title="default">default</div>
	<div onclick="changeThemeFun('gray');" title="gray">gray</div>
	<div onclick="changeThemeFun('metro');" title="metro">metro</div>
	<div onclick="changeThemeFun('bootstrap');" title="bootstrap">bootstrap</div>
	<div onclick="changeThemeFun('black');" title="black">black</div>
	<div onclick="changeThemeFun('material');" title="material">material</div>
</div>
