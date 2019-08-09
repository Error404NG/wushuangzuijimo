<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="shortcut icon" href="icon.png" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/slider.css" />
</head>
<body>
	<div id="page-black"></div>
	<%@ include file ="head.jsp" %>
	<div id="show">
		<ul class="slider">
			<li class="item"><img src="imgs/1.jpg"></li>
			<li class="item"><img src="imgs/2.jpg"></li>
			<li class="item"><img src="imgs/3.jpg"></li>
			<li class="item"><img src="imgs/4.jpg"></li>
			<li class="item"><img src="imgs/5.jpg"></li>
		</ul>

		<ul class="types">
			<c:forEach items="${list }" var="goodstypes">




				<li class="type-item"><a
					href="goods.action?method=getGoodsByGtid&gtid=${goodstypes.gtid }">
						<div class="type-img">
							<img src="${goodstypes.gtpic }" width="150">
						</div>
						<div class="type-content">
							<h3>${goodstypes.gtname }</h3>
							<p>${goodstypes.gtdescript }</p>
						</div>
				</a></li>
			</c:forEach>

		</ul>

	</div>

	<div id="footer">蜗牛创想科技-woniushop&copy; 版权所有</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/basic.js"></script>
	<script src="js/Slider.js"></script>
	<script src="js/index.js"></script>
	<!-- <script>
	$(document).ready(function(){
		$("#btnlogin").click(function(){
			alert("hello");
		});
	});
	
	</script> -->
</body>
</html>