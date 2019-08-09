<%@ page language="java" 
    pageEncoding="utf-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="shortcut icon" href="icon.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="css/basic.css"/>
		<link rel="stylesheet" type="text/css" href="css/shopcar.css"/>
	</head>
	<body>
		<div id="page-black"></div>
	<%@ include file ="head.jsp" %>
		<!-- 主要内容 -->
		<div id="balance">您当期的余额为: <span class="s-money"> ￥10000</span></div>
		<table id="lists" >
			<tr>
				<th></th>
				<th>商品名称</th>
				<th>单价</th>
				<th>数量</th>
				<th>操作</th>
			</tr>
			<c:set var="sum" value="0"></c:set>
			<c:forEach items="${goodsMap }" var="map">
			<tr>
				<td class="td-g-img"><img src="${map.key.gpic }"></td>
				<td>${map.key.gname }</td>
				<td>${map.key.gprice }</td>
				<td>${map.value }</td>
				<td><img src="icon/关闭.png" class="remove" alt="${map.key.gid }"></td>
			</tr>
				<c:set var="sum" value="${sum+(map.key.gprice*map.value) }"></c:set>
				</c:forEach>
			
		</table>
		<div id="pay">
			<div class="btn-pay"><a href="order.action?method=list" class="btn btn-danger f-white">生成订单</a></div>
			<div class="total">总价为 <span class="s-money">￥ ${sum }</span></div>
		</div>
		<div id="footer">
			蜗牛创想科技-woniushop&copy; 版权所有
		</div>
		<script src="js/jquery.min.js" ></script>
		<script src="js/basic.js" ></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$(".remove").click(function(){
				location.href="shopcar.action?method=remove&gid="+$(this).attr("alt");
				
			});
		});
		</script>
	</body>
</html>