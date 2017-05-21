<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>联系我们</title>
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
<!-- //js -->
<!-- start-smoth-scrolling -->
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
	<div class="banner-body cntct">
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
						   
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							
					   
						<li class="hvr-bounce-to-bottom active"><a href="#">关于</a></li>
							<li class="hvr-bounce-to-bottom active"><a href="contact.jsp">联系我们</a></li>
						  </ul>
					<div class="sign-in">
							<ul>
								<li><a href="javascript:history.go(-1)">退出</a></li>
								
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
<!-- contact -->
	<div class="contact">
		<div class="contact-left">
			<img src="images/kf.jpg"   height="500" width="500">
		</div>
		<div class="contact-right">
			<p class="phn">+9100 2481 5842</p>
			<p class="phn-bottom">客服电话24小时为您服务！
					<span>您的满意就是我们的责任！</span></p>
			<p class="lom">如遇到任何问题，请及时联系我们的客服，我们会尽快为您服务，解决您的问题！</p>
		</div>
		<div class="clearfix"> </div>
		<div class="contact-left1">
			<h3>有问题 <span>请联系我们</span></h3>
			<div class="in-left">
				<form>
					<input type="text" placeholder="你的姓名:" style="color:#000" >
					<input type="text" placeholder="联系电话:" style="color:#000" >
					<input type="text" placeholder="邮箱地址:"  style="color:#000">				
				</form>
			</div>
			<div class="in-right">
				<form>
					<textarea placeholder="问题描述:" ></textarea>
					<input type="submit" value="Submit">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
		<div class="contact-right1">
			<h3>在其他地方 <span>找到我们</span></h3>
			<h4>官方唯一旗舰店 <label>www.diaozhatian.com</label></h4>
			<p>新浪微博号：吊炸天官方购物平台;不定期有福利送哦！
			微信公众号：diaozhatianshopping;更多更快的资讯和新品在等待着您哦！</p>
			<ul>
				<li><a href="#" class="g1"> </a></li>
				<li><a href="#" class="p1"> </a></li>
				<li><a href="#" class="facebook1"> </a></li>
				<li><a href="#" class="twitter1"> </a></li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- //contact -->
		</div>
	</div>
<!-- footer -->
		<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-3 footer-grid">
					<h3>更好的服务</h3>
					<div class="footer-grd-left">
						<img src="images/11.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="footer-grd-left">
						<p>我们拥有更好的服务态度。</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="col-md-3 footer-grid">
					<h3>更多网购平台</h3>
					<ul>
						<li><a href="#">淘宝网</a></li>
						<li><a href="#">京东商城</a></li>
						<li><a href="#">一号店</a></li>
						<li><a href="#">亚马逊</a></li>
						<li><a href="#">聚美优品</a></li>
						<li><a href="#">美团</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h3>常用链接</h3>
					<ul>
						<li><a href="#">江西理工大学官网</a></li>
						<li><a href="#">厦门中软</a></li>
						<li><a href="#">江理教务系统</a></li>
						<li><a href="#">CSDN</a></li>
						<li><a href="#">慕课网</a></li>
						<li><a href="#">创业邦</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h3>小相册</h3>
					<div class="footer-grd">
						<img src="images/7.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="footer-grd">
						<img src="images/8.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="footer-grd">
						<img src="images/9.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="clearfix"> </div>
					<div class="footer-grd">
						<img src="images/10.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="footer-grd">
						<img src="images/7.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="footer-grd">
						<img src="images/8.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved </p>
		</div>
	</div>
<!-- //footer -->
<!-- for bootstrap working -->
		<script src="js/bootstrap1.js"> </script>
<!-- //for bootstrap working -->
</body>
</html>