<%@ page language="java" import="java.util.*" import="com.jxust.entity.*"  pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>订单界面</title>
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
<script 
  		language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js">
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
		<div class="check">
			<h1>已经完成的订单</h1>
			<div class="col-md-9 cart-items">

			  <form action = "./OrderManagerServlet" name="findOrder" method = "post">
   <input name = "action" type="hidden" value="allOrder">
   <input name = "userid" type="hidden" value=${userid }  />
   	<div style="text-align:center">
 	 <input name = "start" id="start" type="text" value="${start }" /> 
     <img onclick="WdatePicker({el:$dp.$('start')})" src="My97DatePicker/skin/datePicker.gif"  width="16" height="22" align="absmiddle">
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input name = "end" id="end" type="text"  value="${end}"   /> 
     <img onclick="WdatePicker({el:$dp.$('end')})" src="My97DatePicker/skin/datePicker.gif"  width="16" height="22" align="absmiddle">
     <input name="submit1" type="submit" value="查询" />
     </div>
   </form>	
			
			<br>
		<c:forEach items="${orderlists}" var="orderlist">
           <c:choose>
           <c:when test="${ orderlist.index==0}">	
           <div align="left">
         <h4>    <c:out value="订单编号:" ></c:out>${ orderlist.ordername }</h4>
           </div>
            </c:when>
           </c:choose>
           
					<div class="cart-header">
						<a href="OrderManagerServlet?action=deleteOrder&userid=${userid }&orderid=${orderlist.orderid}"><div class="close1"> </div></a>
						<div class="cart-sec simpleCart_shelfItem">
							<div class="cart-item cyc">
								<img src="${orderlist.picture}" class="img-responsive" alt="" />
							</div>
							<div class="cart-item-info">
								<h3>
								
									
									<c:out value="产品名:" ></c:out>${orderlist.productname }<span> <c:out value="产品购买数量"></c:out>:
										${orderlist.number }</span>
								</h3>
								<ul class="qty">
									<li><p><c:out value="产品单价:"></c:out> ${orderlist.price }</p></li>
									<li><p><c:out value="产品打折:"></c:out> ${orderlist.discount}</p></li>
							
								
									<li><p><c:out value="产品尺寸:"></c:out> ${orderlist.size}</p></li>
							
							
								</ul>

								<div class="delivery">
									<p><span>	<c:out value="收货状态："></c:out>接收</span></p>
								<span>	<c:out value="订单生成时间："></c:out> ${orderlist.createtime}</span>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="clearfix"></div>

						</div>
					</div>
                   
				</c:forEach>





			</div>
		</div>
	</div>
	
	<div class="footer-class">

		<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved</p>


	</div>


</body>
</html>