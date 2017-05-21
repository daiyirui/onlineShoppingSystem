<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>登录页面</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Quickly Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>

<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>
	
<body>
<!-- banner-body -->
	<div class="banner-body logn">
		<div class="container">
<!-- header -->
			<div class="header">
				<div class="header-nav">
					<nav class="navbar navbar-default">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
						  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						  </button>
						  <img alt="" src="images/1logo.png" style="height: 136px; width: 215px; ">
						   <a class="navbar-brand" href="#"><span>Q</span>uickly</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">

						
							<li class="hvr-bounce-to-bottom"><a href="OtherManagerServlet?action=index">主页</a>
		
												
						
							
						  </ul>
						  <div class="sign-in">
							<ul>
								<li><a href="login.jsp">登录 </a>/</li>
								<li><a href="register.jsp">注册</a></li>
							</ul>
							</div>
						</div><!-- /.navbar-collapse -->
					</nav>
				</div>
	
			<!-- search-scripts -->
			<script src="js/classie.js"></script>
			<script src="js/uisearch.js"></script>
				<script>
					new UISearch( document.getElementById( 'sb-search' ) );
				</script>
			<!-- //search-scripts -->
			</div>
<!-- //header -->
<!-- login-page -->
	<div class="login">
		<div class="login-grids">
			<div class="col-md-6 log">
					 <h3>Login</h3>
					 <p>Welcome, please enter the following to continue.</p>
					 <p>If you have previously Login with us, <a href="#">click here</a></p>
					 <form action="UserManagerServlet" method="post">
					 <input type="hidden" name="action" value="login" >
						 <h5>用 户 名:</h5>	
						 <input type="text" name="username" id="username" class="username" value="">
						 <h5>密 码:</h5>
						 <input type="password" name="userpassword" id="userpassword" class="userpassword" value="">					
						 <input type="submit" value="登录">
						  
					 </form>
					<a href="resetPassword.jsp">忘记密码?</a>
			</div>
			<div class="col-md-6 login-right">
					<h3>New Registration</h3>
					<p>
                                            通过创建一个会员，我们将更好的为你网购提供方便，眼花缭乱的货物摆在你的眼前，方便快捷的购买货物！<br/>Through the creation of a member, we will be better for you to buy online shopping convenience, dazzling goods placed in front of you, convenient and quick to buy goods!
</p>
					<a href="register.jsp" class="hvr-bounce-to-bottom button">加入我们</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<div class="footer-bottom">
		<div class="container">
			<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved </p>
		</div>
	</div>

		<script src="js/bootstrap.js"> </script>

</body>
</html>