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


<center>

	<form action="goodsEdit.do" method="post" enctype="multipart/form-data">
		商品名称<input type="text" name="name" /> 商品价格<input type="text"
			name="sal" /><br>
			 商品图片<input type="file" name="image" />

		<button class="btn btn-success">编辑</button>







	</form>
	</center>




</body>
</html>