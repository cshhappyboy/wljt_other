<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>离线管理系统</title>
<link href="${pageContext.request.contextPath}/style/images/login.css"
	rel="stylesheet" type="text/css" />
<jsp:include page="inc.jsp"></jsp:include>
<script type="text/javascript">
	var script;
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/user/login',
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.status == 200) {
					location.href = result.data;
				} else {
					alert(result.msg);
				}
			}
		});
		script = $('#scriptlocale');
		$('#locale').combobox({
			width : 120,
			height : 25,
			panelHeight : 100,
			valueField : 'value',
			textField : 'text',
			value : 1,
			data : [ {
				value : '1',
				text : '简体中文'
			}, {
				value : '2',
				text : 'English'
			}, {
				value : '3',
				text : 'French'
			}, {
				value : '4',
				text : 'Portuguese'
			} ],
			onChange : function(newValue, oldValue) {
				if (newValue == '1') {
					var src = "zh_CN";
				} else if (newValue == '2') {
					var src = "en";
				} else if (newValue == '3') {
					var src = "fr";
				} else if (newValue == '4') {
					//葡萄牙语的要重做
					var src = "pu_BR";
				}
				script.attr('src', src);
				$.cookie('locale', src, {
					expires : 7
				});
			},
			onLoadSuccess : function() {
				var src = "zh_CN";
				script.attr('src', src);
				$.cookie('locale', src, {
					expires : 7
				});
			}
		});

	});
	lg = function() {
		$('#form').submit();
	}
	reset = function() {
		$('#form').form('reset');
	}
	onKeyDown = function(e) {
		if (e.keyCode == 13) {
			lg();
		}
	}
</script>
</head>
<body onkeydown="onKeyDown(event);">
	<div id="login">

		<div id="top">
			<div id="top_left">
				<img
					src="${pageContext.request.contextPath}/style/images/login_03.gif" />
			</div>
			<div id="top_center"></div>
		</div>

		<div id="center">
			<div id="center_left"></div>
			<div id="center_middle">
				<form id="form" method="post">
					<div id="loc">
						语 言 <input id="locale" name="locale" />
					</div>
					<div id="user">
						用 户 <input type="text" name="usercode" />
					</div>
					<div id="password">
						密 码 <input type="password" name="userpassword" />
					</div>
					<div id="btn">
						<a href="javascript:void(0)" onclick="lg()">登录</a><a
							href="javascript:void(0)" onclick="reset()">清空</a>
					</div>
				</form>
			</div>
			<div id="center_right"></div>
		</div>
		<div id="down">
			<div id="down_left">
				<div id="inf">
					<span class="inf_text">版本信息</span> <span class="copyright">管理信息系统
						2018 v1.0</span>
				</div>
			</div>
			<div id="down_center"></div>
		</div>

	</div>
</body>
</html>
