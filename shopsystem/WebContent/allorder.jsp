<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>订单</title>
		<link rel="shortcut icon" href="icon.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="css/basic.css"/>
		<link rel="stylesheet" type="text/css" href="css/allorder.css"/>

	</head>
	<body>
		<%@ include file="head.jsp" %>
		<!-- 主要内容 -->
		<table  id="orders">
			<tr>
				<th></th>
				<th></th>
				<th>商品名称</th>
				<th>金额</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${orderList }" var="order">
			<tr>
				<td class="order-id">订单号:${order.orderno}</td>
				<td colspan="5"></td>
				<td><button type="button" class="btn btn-info refund">退款</button></td>
			</tr>
				<c:forEach items="${orderItemList }" var="orderItem">
					<c:if test="${order.oid==orderItem.oid }">
						<tr >
							<td class="no-border"></td>
							<td ><img src="${orderItem.gpic }"></td>
							<td>${orderItem.gname }</td>
							<td>￥${orderItem.gprice }</td>
							<td>${orderItem.oicount}</td>
							<td>${order.createtime }</td>
							<td></td>
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
			
			
			
		</table>
		
		
		<div id="footer">
			蜗牛创想科技-woniushop&copy; 版权所有
		</div>
		<script src="js/jquery.min.js" ></script>
		<script src="js/basic.js" ></script>
		<script src="js/orders.js" ></script>
	</body>
</html>