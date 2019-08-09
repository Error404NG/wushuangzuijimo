<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/basic.css"/>
		<link rel="stylesheet" type="text/css" href="css/address.css"/>
		<title></title>
	</head>
	<body>
	<!-- 头部区域 -->
		<div id="page-black"></div>
		<%@ include file="head.jsp"%>
		
	<!-- 中间区域 -->
	<div id="address-main">
		<h1 class="title">已有邮寄地址</h1>
		<div id="address ">
			<div class="a-list">
			<c:forEach items="${list }" var="address" varStatus="i">
				<div class="a-item ">
					<div class="i-info">
						<span  class="i-s-title">姓名: </span><span class="i-s-name">${address.aname }</span>
						<span class="i-s-title">电话: </span><span class="i-s-phone"></span>
						<span class="i-s-title">邮寄编码: </span><span class="i-s-number">610620</span>
					</div>
					<div class="i-address ">${address.aprovince }省${address.acity }市${address.acounty }区${address.atown }镇${address.addressinfos }</div>
					<div class="i-delete"><img src="icon/关闭.png" ></div>
				</div>
				</c:forEach>
				
				
			</div>
			
			
		</div>
		
		<h1 class="title">添加邮寄地址</h1>
		<div id="add-address">
				<form action="address.action?method=add" method="post">
					<div class="add-form-group ">
						<label for="name">姓名:</label>
						<input type="text" id="name" name="aname"/>
					</div>
					<div class="add-form-group ">
						<label for="phone">手机:</label>
						<input type="number" id="phone" name="atelephoneno" />
					</div>
					<div class="add-form-group inline-block">
						<label for="province">省份:</label>
						<select id="province" name="aprovince">
							<option value ="四川" selected="selected">四川</option>
							<option value ="陕西" selected="selected">陕西</option>
							<option value ="山西" selected="selected">山西</option>
							<option value ="" selected="selected">北京</option>
							<option value ="" selected="selected">天津</option>
							<option value ="" selected="selected">贵阳</option>
							<option value ="" selected="selected">南京</option>
							<option value ="" selected="selected">杭州</option>
							<option value ="" selected="selected">宁夏</option>
						</select>
					</div>
					<div class="add-form-group inline-block">
						<label for="city">城市:</label>
						<select id="city" name="acity">
							<option value ="成都" selected="selected">成都</option>
						</select>
					</div>
					<div class="add-form-group inline-block">
						<label for="county">区县:</label>
						<select id="county" name="acounty">
							<option value ="高新区" selected="selected">高新区</option>
						</select>
					</div>
					<div class="add-form-group inline-block">
						<label for="street">街道:</label>
						<select id="street" name="atown">
							<option value ="孵化园" selected="selected">孵化园</option>
						</select>
					</div>
					<div class="add-form-group address-detail">
						<label for="name">详细地址:</label>
						<textarea id="detail" name="addressinfos"></textarea>
					</div>
					<div class="add-form-group add-button ">
						<button class="btn btn-info">添加地址</button>
					</div>
				</form>
		</div>
	</div>	
			
		
	<!-- 尾部区域 -->
	<div id="footer">
		蜗牛创想科技-woniushop&copy; 版权所有
	</div>
	<script src="js/jquery.min.js" ></script>
	<script src="js/basic.js" ></script>
	</body>
</html>