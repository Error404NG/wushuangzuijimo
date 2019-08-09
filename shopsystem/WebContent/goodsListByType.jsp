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
<link rel="stylesheet" type="text/css" href="css/paging.css" />
</head>
<body>
	<div id="page-black"></div>
	<%@ include file="head.jsp"%>
	<!-- 主要内容 -->
	<div id="good-list">
		<c:forEach items="${list }" var="goods">
			<div class="good">
				<div class="good-img">
					<a href="goods.action?method=goodsGet&gid=${goods.gid }"><img
						src="${goods.gpic }"></a>
				</div>
				<div class="good-info">
					<div class="good-left">
						<div class="good-price">
							<span class="s-money">${goods.gprice }</span>
						</div>
						<div class="good-add">
							
							 <img src="icon/加.png" class="qq" alt="${goods.gid }"> 
							
						</div>
					</div>
					<div class="good-right">${goods.gname }</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="page">
		<div class="page-item first" onclick="pageNum(1,${list[0].gtid})">首页</div>
		<div class="page-item prev"
			onclick="pageNum(${pb.pageNum==1?1:pb.pageNum-1},${list[0].gtid})">上一页</div>
		<div class="page-item">${pb.pageNum }/${pb.countPage }</div>
		<div class="page-item next"
			onclick="pageNum(${pb.pageNum==pb.countPage?pb.countPage:pb.pageNum+1},${list[0].gtid})">下一页</div>
		<div class="page-item last"
			onclick="pageNum(${pb.countPage},${list[0].gtid})">末页</div>
	</div>

	<div id="footer">蜗牛创想科技-woniushop&copy; 版权所有</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/basic.js"></script>
</body>
</html>
<script>
	function pageNum(pn,gtid){
		location.href="goods.action?method=getGoodsByGtid&gtid="+gtid+"&pageNum="+pn;
	}
	
	$(document).ready(function(){
		$(".qq").click(function(){
			
			$.post("shopcar.action",{"method":"add","gid":$(this).attr("alt")},function(data){
				alert("添加成功!!!");
			});
			
		});
	});
	
	
</script>