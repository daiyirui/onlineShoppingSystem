<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>密码重置页面</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Quickly Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>

<script type="text/javascript">
		function check(){
			if(${massage}==1){
				alert("此用户不存在！！！");
			}
		}	
		
		function validate_email(field,alerttxt)
{
with (field)
{
apos=value.indexOf("@");
dotpos=value.lastIndexOf(".");
if (apos<1||dotpos-apos<2) 
  {alert(alerttxt);return false;}
else {return true;}
}
}




       


function validate_form(thisform)
{
  
with (thisform)
{
if (validate_email(email,"Not a valid e-mail address!")==false)
  {email.focus();return false;}
}

}
		
	
	</script>


</head>

<body onload="check()">
	<!-- banner-body -->
	<div class="banner-body regstr">
		<div class="container">
			<!-- header -->
			<div class="header">
				<div class="header-nav">
					<nav class="navbar navbar-default">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							
							<li class="hvr-bounce-to-bottom active"><a href="about.jsp">关于</a></li>
							
							<li class="hvr-bounce-to-bottom"><a href="contact.jsp">联系我们</a></li>
						  </ul>
						  
						  <div class="sign-in">
							<ul>
								<li><a href="javascript:history.go(-1)">退出</a></li>
								
							</ul>
							</div>
						  </div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil"
							id="bs-example-navbar-collapse-1">

							
						</div>
						<!-- /.navbar-collapse -->
					</nav>
				</div>

				<!-- search-scripts -->
				<script src="js/classie.js"></script>
				<script src="js/uisearch.js"></script>
				<script>
					new UISearch(document.getElementById('sb-search'));
				</script>
				<!-- //search-scripts -->
			</div>
			<!-- //header -->
			<!-- register -->
			<form id="_editForm" method="post" action="UserManagerServlet" onsubmit="return validate_form(this)">
	
			
				<input type="hidden" name="action" value="resetpassword" >
				<div class="sign-up-form">
					<h3>重置密码</h3>
					<br/>
					<div class="sign-up">
					<div class="sign-u">
							<div class="sign-up1">
								<h4 class="c">输入邮箱* :</h4>
							</div>
							<div class="sign-up2">

								<input type="text" name="email" id="email" class="email"
									placeholder=" " required=" " />
							</div>
							<div class="clearfix"></div>
					</div>
					
					<div class="sign-u">
							<div class="sign-up1">
								<h4 class="d">输入密码* :</h4>
							</div>
							<div class="sign-up2">

								<input type="password" name="resetpassword" id="resetpassword"
									class="userpassword" placeholder=" " required=" " />
							</div>
							<div class="clearfix"></div>
					</div>
					
					
						<input type="submit" name="submit" id="submit" value="提交">
				</div>
				</div>
			</form>
			<!-- //register -->
	</div>

	<div class="footer-bottom"    style="margin-top:160px"> 
		<div class="container">
			<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved</p>
		</div>
	</div>
	<script src="js/bootstrap.js">
		
	</script>

</body>
</html>