<%@ page language="java" 
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>
			
		</title>
		
		<style type="text/css">
			a:link{
				text-decoration: none;
			}
		</style>
		
		<link rel="stylesheet" type="text/css" href="css/basic.css"/>
		<link rel="stylesheet" type="text/css" href="css/good.css"/>
	</head>
	<body>
		<div id="page-black"></div>
		<%@ include file ="head.jsp" %>
			
		
		<!-- 主要内容 -->
		
		<div id="good">
		<div id="good-show">
			<img src=${goods.gpic } >
		</div>	
		<div id="good-info">
			<table id="good-table">
				<tr>
					<td colspan="2" style="text-align: center;"><h2>商品名称</h2></td>					
				</tr>
				<tr class="tr-info">
					<td class="td-title">品牌：</td>
					<td>${goods.gname }</td>
				</tr>
				<tr class="tr-info">
					<td class="td-title">单价：</td>
					<td><span class="s-money">${goods.gprice } </span></td>
				</tr>
				
				<tr class="tr-info">
					<td class="td-title">描述：</td>
					<td>${goods.gdescribe }</td>
				</tr>
				<tr class="tr-info">
					<td class="td-title">库存：</td>
					<td>${goods.ginventory }</td>
				</tr>
				<tr class="tr-info">
					<td class="td-title">数量：</td>
					<td>
						<span class="s-btn"><button class="btn" onclick="numMulp()">-</button></span><input type="text" value="1" disabled="disabled" id="total"/><span class="s-btn" ><button class="btn" onclick="numAdd()">+</button></span>
					</td>
				</tr>
			</table>
		</div>
		
		</div>
		<div id="gopay">
		<input type="hidden" id="gid" value="${goods.gid }">
			<button type="button" class="btn btn-danger" id="add">加入购物车</button>
		</div>
		
		<div id="footer">
			蜗牛创想科技-woniushop&copy; 版权所有
		</div>
	<script src="js/jquery.min.js" ></script>
	
	<script src="js/basic.js" ></script>
	<script type="text/javascript">
		function numAdd(){
			var $total = $("#total");
			var count = parseInt($total.val());
			$total.val(count+1);	
		}
		function numMulp(){
			var $total = $("#total");
			var count = parseInt($total.val());
			if(count >=1){
				$total.val(count-1);
			}
		}
		
	$(document).ready(function(){
		$("#add").click(function(){
			$.post("shopcar.action",{"method":"add","gid":$("#gid").val(),"num":$("#total").val()},function(data){
				alert("添加成功!!!");
			});
		});
	});
	</script>
	</body>
</html>