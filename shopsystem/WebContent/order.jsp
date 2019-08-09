<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/order.css" />
<title></title>
</head>
<body>
	<!-- 头部区域 -->
	<div id="page-black"></div>
	<%@ include file="head.jsp"%>


	<!-- 主要内容 -->
	<div id="order-main">
		<div id="address">
			<h1 class="title">选择邮寄地址</h1>
			<div class="a-list">
				<c:forEach items="${list }" var="address" varStatus="i">
					<div class="a-item ">
						<div class="i-info">
							<input type="hidden" name="aid" value="${address.aid }">
							<span class="i-s-title">姓名: </span><span class="i-s-name">${address.aname }</span>
							<span class="i-s-title">电话: </span><span class="i-s-phone">${address.atelephoneno }</span>
							<span class="i-s-title">邮寄编码: </span><span class="i-s-number">610620</span>
						</div>
						<div class="i-address ">${address.aprovince }${address.acity }${address.acounty }${address.atown }${address.addressinfos }</div>
					</div>
				</c:forEach>


			</div>
			<div class="add icon i-add">
				<a href="address.action?method=list">添加邮寄地址</a>
			</div>	
		</div>
		<div id="o-detail">
			<h1 class="d-number">订单号：${l }</h1>
			<div class="d-goodlist">
				<c:set var="sum" value="0"></c:set>
				<c:forEach items="${goodsMap }" var="map">
					<div class="g-item">
						<div class="item-img">
							<img src="${map.key.gpic }" />
						</div>
						<div class="item-name">
							<a href="good.html">${map.key.gname }</a>
						</div>
						<div class="item-price s-money">￥${map.key.gprice }</div>
						<div class="item-count">${map.value }</div>
					</div>
					<c:set var="sum" value="${sum+(map.key.gprice*map.value) }"></c:set>
				</c:forEach>


			</div>
			<div class="d-total">
				总价：<span class="d-s-price">￥${sum }元</span>
			</div>
		</div>
		<div id="gopay">
		<form action="order.action?method=add" method="post">
			<input  type="text" name="orderno" value="${l }" />
			<input  type="text" name="aid" id="aid"/>
			<button class="btn btn-danger">结账</button>
			</form>
		</div>
		



	<!-- 页尾 -->
	<div id="footer">蜗牛创想科技-woniushop&copy; 版权所有</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/basic.js"></script>

</body>
</html>
<script>
	$(document).ready(function() {
		$(".a-item").click(function(){
			//添加class
			$(this).addClass("active");
			/* alert($(this).children().children().val()); 找到aid  */
			$("#aid").val($(this).children().children().val()); 
			
			
			
		});
	});
</script>


