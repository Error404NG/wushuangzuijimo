<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


	<caption><h1>商品编辑</h1></caption>
	<form action="goodsType.action?method=edit" method="post" var="goodstype" enctype="multipart/form-data">
	
		<input  type="hidden" name ="gtid" value=${goodstype.gtid }  >
		商品名称<input type="text" name="gtname"value=${goodstype.gtname } /><br>
		 商品图片<input type="file" name="gtpic" value=${goodstype.gtpic } /><br>
		商品描述<input  type="text" name="gtdescript value=${goodstype.gtdescript }"/><br>
		商品类型编号<input  type="text" name="gtdescript value=${goodstype.gtforetypeno }"/><br>
		软删除<input  type="text" name="gtdescript value=${goodstype.softdelete }"/><br>
		<button class="btn btn-success">编辑</button>







	</form>




</body>
</html>