<%@ page language="java" 
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>






<!-- 
		 登录  注册部分
		 -->

	<!-- 登录 -->
	<div id="login" class="outer-black">
		<!--  关闭登录注册弹窗-->
		<div class="close">
			<img src="icon/关闭.png" onclick="closeLoginBox()">
		</div>
		<div class="login-title">登录</div>
		<div class="login-form">
			<div class="form-group">
				<span class="i-user f-span"><input type="text"
					placeholder="请输入账号" name="lname" id="lname" class="f-input" /></span>
			</div>
			<div class="form-group">
				<span class="i-password f-span"><input type="password"
					placeholder="请输入密码" name="lpwd" id="lpwd" class="f-input" /> </span>
			</div>
		</div>
		<div class="l-btn">
			<button type="button" class="btn btn-danger "  id="btnlogin">登录</button>
		</div>
	</div>
	
	
	<!-- 注册-->
	<form action="login.action?method=reg" method="post">
	<div id="register" class="outer-black">
		<div class="close">
			<img src="icon/关闭.png" onclick="closeRegisterBox()">
		</div>
		<div class="register-title">注册</div>
		<div class="register-form">
			<div class="form-group">
				<span class="i-user f-span"><input type="text"
					placeholder="请输入账号" name="lname" class="f-input" /></span>
			</div>
			<div class="form-group">
				<span class="i-password f-span"><input type="password"
					placeholder="请输入密码" name="lpwd" class="f-input" /> </span>
			</div>
			<div class="form-group">
				<span class="i-password f-span"><input type="password"
					placeholder="请再次输入密码" name="lpwd2" class="f-input" /> </span>
			</div>
		</div>
		<div class="l-btn">
			<button  class="btn btn-danger ">注册</button>
		</div>
	</div>
</form>


	<!-- 
		 登录 注册结束
		 -->
	<div id="header">
		<div id="logo">
			<a href="goodsType.action?method=front">WoniuShop</a>
		</div>
		<div id="userzoom">
			<!-- if not login , use this code block-->
			<c:if test="${loginuser==null }">
			 <div id="n-inout">
					<a href="#" onclick="showLoginBox()" class="icon i-user">登录</a>
					<a href="#" onclick="showRegisterBox()" class=" icon i-register">注册</a>
				</div> 
				</c:if>
			<!-- if logined，use this -->
			<c:if test="${loginuser!=null }">
			 <div id="y-inout">
				<a href="order.action?method=orderList" class="icon i-order">订单</a> <a
					href="shopcar.action?method=list" class="icon i-shopcar">购物车</a> <a href=""
					class="icon i-user" id="y-inout-lname">${loginuser.lname }</a>
					 <a href="login.action?method=exit"	class="icon i-loginout">注销</a>
			</div> 
			</c:if>
			 <div id="y-inout2">
				<a href="order.action?method=orderList" class="icon i-order">订单</a> <a
					href="shopcar.action?method=list" class="icon i-shopcar">购物车</a> <a href=""
					class="icon i-user" id="y-inout-lname">${loginuser.lname }</a>
					 <a href="login.action?method=exit"	class="icon i-loginout">注销</a>
			</div> 
			
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/basic.js"></script>
	<script src="js/Slider.js"></script>
	<script src="js/index.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#y-inout2").hide();
		$("#btnlogin").click(function() {
			
			$.post("login.action", {
				"method" : "loginajax",
				"lname" : $("#lname").val(),
				"lpwd" : $("#lpwd").val()
			}, function(data) {
				var jsonObj = eval("("+data+")");
				if(jsonObj.result!="no"){
					$("#n-inout").hide();
					$("#y-inout2").show();
					$("#y-inout-lname").text(jsonObj.lname);
				}
				
				$("#login").fadeOut("fast");
				closeblack();
			});

		});
	}); 
	
	
	
	</script>
	
	
</body>
</html>