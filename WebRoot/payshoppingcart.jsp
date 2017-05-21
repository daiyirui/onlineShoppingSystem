<%@ page language="java" import="java.util.*"  import="com.jxust.entity.*"  pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>支付界面</title>
<link href="css/bootstrap1.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="js/simpleCart.min.js">
	
</script>
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				
				<div class="header-left">
					<ul>
					     <li class="active grid"><a class="color8" href="UserManagerServlet?action=home&userid=${userid }">主页</a></li>
					  
						<li><a href="ShoppingcartManagerServlet?userid=${userid }&action=allshoppingcard">购物车</a></li>
						<li><a href="OrderManagerServlet?userid=${userid }&action=allOrder">我的订单</a></li>
					

						<li><a href="UserManagerServlet?action=show&userid=${userid }" target="_top"><span>个人信息管理</span></a></li>
					
					  <li><a>欢迎你，${ user.username}</a></li>

						<li><a href="login.jsp">退出</a></li>

					</ul>
					<div class="clearfix"></div>
				</div>
					
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="container">
			<div class="head-top">
				
		</div>

	</div>



	<div class="container">
	
		<div class="content-top">

			<div class="grid-in">
			
			
		<c:forEach  items="${ shoppingcartlists}" var="shoppingcartlist">
		
			
<div class="my_shopping" align="left">
 	<img class="pic_shop"
				src="${ shoppingcartlist.picture }" />
 	</div>
 	<br>
	<div id="div_choice" class="choice_merch" align="center">
	
	</div>
	
	<table class="tabl_buy" id="tbCartItemsNormal">
	<tr class="tabl_buy_title">
	<td class="buy_td_6">
	<span>&nbsp;</span>
	</td>
	<td>
	<span class="span_w1">商品名:${shoppingcartlist.productname }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td>
	<span class="span_w1">尺寸:${shoppingcartlist.type }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td class="buy_td_4">
	<span class="span_w3">原价：${shoppingcartlist.price }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td class="buy_td_4">
	<span class="span_w3">折扣：${shoppingcartlist.discount }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td class="buy_td_1">
	<span class="span_w2">数量:${shoppingcartlist.number }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
		<td class="buy_td_1">
	<span class="span_w2">金额:${allmoney }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
					
	

	</tr>
				


	
	<tr class='td_no_bord'>
								
	<td class="buy_td_6">
								
	</td>
	
	<td class="buy_td_1">
		&nbsp;&nbsp;${it.value.num}
		</td>
	
		<td class="buy_td_1">
	
									
									
			</td>
			<td class="buy_td_1">
		
			</td>
			</tr>
		<br>
			</table> 
			
			</c:forEach>
			
			<p>总金额：${allmoney }</p>
<button onclick="window.location.href='OrderManagerServlet?userid=${userid}&action=payshoppingcart&allshoppingcartid=${allshoppingcartid} '">付款</button>
	<button  onclick="javascript:history.go(-1)">返 回</button>

				
				
				<div class="clearfix"></div>
			</div>
		</div>
		</div>
		
		
		<!----->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

		<div class="footer-class">

			<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved</p>
		

		</div>

</body>
</html>

			
		
		
			
		
  
  


				
		