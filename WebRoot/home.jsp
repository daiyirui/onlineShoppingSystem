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
<title>吊炸天会员登录首页</title>
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
				<div class="search">
					<form action="BrowseproductManagerServlet" method="post">
					    <input type="hidden" name="action" value="search">
					     <input type="hidden" name="userid" value="${userid }">
						<input type="text" name="keywords" value=${keywords } >
						<input type="submit" value="搜索">
					</form>
				</div>
				<div class="header-left">
					<ul>
					    <li class="active grid"><a class="color8" href="UserManagerServlet?action=home&userid=${userid }">主页</a></li>
					  
						<li><a href="ShoppingcartManagerServlet?userid=${userid }&action=allshoppingcard">购物车</a></li>
						<li><a href="OrderManagerServlet?userid=${userid }&action=allOrder">我的订单</a></li>
					

						<li><a href="UserManagerServlet?action=show&userid=${userid}" target="_top"><span>个人信息管理</span></a></li>
					
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
				<div class="logo">
					<a href="#"><img src="images/logo.jpg" alt=""></a>
				</div>
				<div class=" h_menu4">
					<ul class="memenu skyblue">
						
						<li><a class="color1" href="#">分类</a>
							<div class="mepanel">
								<div class="row">
									
								
								<div class="col1">
										<div class="h_nav">
											<ul>
								
								<c:forEach items="${classes}" var="cla" >
								<c:choose>
								<c:when test="${6>=cla.classid&&cla.classid>=1}">
								
												<li><a href="ProductManagerServlet?action=showAllProductByClass&userid=${userid }&classid=${ cla.classid}">${ cla.classname}</a></li>
						     	</c:when>
			            </c:choose>
	                    	   </c:forEach>
									</ul>
										</div>
									</div>
								
								
									
												
								
								<div class="col1">
										<div class="h_nav">
											<ul>
								
								<c:forEach items="${classes}" var="cla" >
								<c:choose>
								<c:when test="${12>=cla.classid&&cla.classid>=7}">
								
												<li><a href="ProductManagerServlet?action=showAllProductByClass&userid=${userid }&classid=${cla.classid}">${ cla.classname}</a></li>
						     	</c:when>
			            </c:choose>
	                    	   </c:forEach>
									</ul>
										</div>
									</div>
									
									<div class="col1">
										<div class="h_nav">
											<ul>
						
								
								<c:forEach items="${classes}" var="cla" >
								<c:choose>
								<c:when test="${18>=cla.classid&&cla.classid>=13}">
								
												<li><a href="ProductManagerServlet?action=showAllProductByClass&userid=${userid }&classid=${ cla.classid}">${ cla.classname}</a></li>
						     	</c:when>
			            </c:choose>
	                    	   </c:forEach>
									</ul>
										</div>
									</div>
								
								
				
								
								
								</div>
							</div></li>
						
						<li><a class="color6" href="contact.jsp">联系我们</a></li>
						
					</ul>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>

	</div>



	<div class="container">
	
		<div class="content-top">
		
		<div align="center">
			<a href="BrowseproductManagerServlet?action=showPopularity&userid=${userid}&classid=${classid}">按人气查询</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="BrowseproductManagerServlet?action=showHotsale&userid=${userid}&classid=${classid}">按销量查询</a>
			</div>
			<br><br><br><br><br><br>



       
			<div class="grid-in">
			
		
	   <c:forEach items="${browseproducts}"  var="browseproduct" begin="0" end="2" >
	   	<div class="col-md-4 grid-top">  
					<a href="BrowseproductManagerServlet?browseproductid=${browseproduct.browseproductid}&action=showOneProduct&userid=${userid}" class="b-link-stripe b-animate-go  thickbox"><img
						class="img-responsive" src="${browseproduct.picture }" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>${browseproduct.browseproductname}</span>
							</h3>
						</div> </a>
					<p>
						<a href="BrowseproductManagerServlet?browseproductid='${browseproduct.browseproductid}'&action=showOneProduct&userid=${userid}">产品名：${browseproduct.browseproductname }  人气指数：${browseproduct.popularity }  销量：${browseproduct.hotsale }</a>
					</p>
				</div>
				</c:forEach>
		<div class="clearfix"></div>
		
		 <c:forEach items="${browseproducts}"  var="browseproduct" begin="3" end="5" >
	   	<div class="col-md-4 grid-top">  
					<a href="BrowseproductManagerServlet?browseproductid=${browseproduct.browseproductid}&action=showOneProduct&userid=${userid}" class="b-link-stripe b-animate-go  thickbox"><img
						class="img-responsive" src="${browseproduct.picture }" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>${browseproduct.browseproductname}</span>
							</h3>
						</div> </a>
					<p>
						<a href="BrowseproductManagerServlet?browseproductid='${browseproduct.browseproductid}'&action=showOneProduct&userid=${userid}">产品名：${browseproduct.browseproductname }  人气指数：${browseproduct.popularity }  销量：${browseproduct.hotsale }</a>
					</p>
				</div>
				</c:forEach>
		
				<div class="clearfix"></div>
			 <c:forEach items="${browseproducts}"  var="browseproduct" begin="6" end="8" >
	   	<div class="col-md-4 grid-top">  
					<a href="BrowseproductManagerServlet?browseproductid=${browseproduct.browseproductid}&action=showOneProduct&userid=${userid}" class="b-link-stripe b-animate-go  thickbox"><img
						class="img-responsive" src="${browseproduct.picture }" alt="">
						<div class="b-wrapper">
							<h3 class="b-animate b-from-left    b-delay03 ">
								<span>${browseproduct.browseproductname}</span>
							</h3>
						</div> </a>
					<p>
						<a href="BrowseproductManagerServlet?browseproductid='${browseproduct.browseproductid}'&action=showOneProduct&userid=${userid}">产品名：${browseproduct.browseproductname }  人气指数：${browseproduct.popularity }  销量：${browseproduct.hotsale }</a>
					</p>
				</div>
				</c:forEach>
		
				<div class="clearfix"></div>
			
				
			</div>
			
		</div>
		<!----->


		<div class="footer-class">

			<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved</p>
		

		</div>
	</div>
</body>
</html>
