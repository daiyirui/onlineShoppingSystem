<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>About</title>
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
	<div class="banner-body abt">
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
						   <a class="navbar-brand" href="index.jsp"><span>Q</span>uickly</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							<li class="hvr-bounce-to-bottom"><a href="index.jsp">Home</a></li>
							<li class="hvr-bounce-to-bottom active"><a href="about.jsp">About</a></li>
							<li class="hvr-bounce-to-bottom"><a href="Portfolio.jsp">Portfolio</a></li>
							<li class="hvr-bounce-to-bottom"><a href="Pages.jsp">Pages</a></li>
							<li class="hvr-bounce-to-bottom"><a href="contact.jsp">Contact Us</a></li>
						  </ul>
						  <div class="sign-in">
							<ul>
								<li><a href="login.jsp">Sign In </a>/</li>
								<li><a href="register.jsp">Register</a></li>
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
<!-- about-page -->
	<div class="about">
			<div class="about-text">
				<h3>About Us</h3>
			</div>	
			<div class="about-info">
				<h4>Lorem Ipsum is not simply random text. It has roots in a piece of classical</h4>
				<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised 
					words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. </p>
				<div class="col-md-5 about-info-left">
					<img src="images/10-.jpg" alt=""/>
				</div>
				<div class="col-md-7 about-info-right">
					<h4>piece of classical Lorem Ipsum </h4>
					<p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'
					There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, <span>by injected humour,  to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, 
					or randomised words which don't look even slightly believable.Lorem Ipsum available, but the majority</span> have suffered alteration in some form, by injected humour.</p>
				</div>
				<div class="clearfix"> </div>
				
			</div>
			<div class="about-grid">
				<div class="col-md-4 about-text-info">
					<h4>Development</h4>
					<h5>nobis est eligendi optio cumque nihil</h5>
					<p class="about-pgh">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour,  to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum </p>
				</div>
				<div class="col-md-4 about-text-info">
					<h4>Our Skills</h4>
					<h5>repudiandae sint et molestiae</h5>
					<p class="about-pgh">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, to generate Lorem Ipsum which looks reasonable or randomised.</p>
				</div>
				<div class="col-md-4 about-text-info">
					<h4>Careers</h4>
					<h5>consequatur aut perferendis doloribus</h5>
					<p class="about-pgh">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some to generate Lorem Ipsum which looks reasonable.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="about-team">
				<div class="about-text">
					<h3 class="ind">Our Professionals</h3>
				</div>	
				<div class="row">
					<div class="col-sm-6 col-md-3 about-team-grids">
						<div class="thumbnail">
							<img src="images/15.jpg" alt="" class="img-responsive" />
							<div class="caption">
								<h4><a href="#">Eligendieos</a></h4>
								<p>vero eos et accusamus et iusto odio dignissimos ducimus</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-3 about-team-grids">
						<div class="thumbnail">
							<img src="images/16.jpg" alt="" class="img-responsive" />
							<div class="caption">
								<h4><a href="#">Dignissimos</a></h4>
								<p>vero eos et accusamus et iusto odio dignissimos ducimus</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-3 about-team-grids">
						<div class="thumbnail">
							<img src="images/17.jpg" alt="" class="img-responsive" />
							<div class="caption">
								<h4><a href="#">Accusamus Et Iusto</a></h4>
								<p>vero eos et accusamus et iusto odio dignissimos ducimus</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-3 about-team-grids">
						<div class="thumbnail">
							<img src="images/18.jpg" alt=""class="img-responsive" />
							<div class="caption">
								<h4><a href="#">Dignissimos Ducimus</a></h4>
								<p>vero eos et accusamus et iusto odio dignissimos ducimus</p>
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="advantages">
				<h3>Our Advantages</h3>
				<div class="advantag-main">
					<div class="advan-top">
						<div class="col-md-6 advantage-left">
							<div class="col-md-4 advan-cup">
								
							</div>
							 <div class="col-md-8 advan-text">
									<h4><a href="single.jsp">There are variations passage</a></h4>
									<p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete</p>
							 </div>	
						  <div class="clearfix"> </div>
						</div>
						<div class="col-md-6 advantage-right">
							<div class="col-md-4 advan-ser">
								
							</div>
							 <div class="col-md-8 advan-text">
									<h4><a href="single.jsp">There are variations passage</a></h4>
									<p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete</p>
							 </div>	
						  <div class="clearfix"> </div>
						</div>
					<div class="clearfix"> </div>
					</div>
					<div class="advan-bott">
						<div class="col-md-6 advantage-left">
							<div class="col-md-4 advan-mach">
								
							</div>
							 <div class="col-md-8 advan-text">
									<h4><a href="single.jsp">There are variations passage</a></h4>
									<p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete</p>
							 </div>	
						  <div class="clearfix"> </div>
						</div>
						<div class="col-md-6 advantage-right">
							<div class="col-md-4 advan-tin">
								
							</div>
							 <div class="col-md-8 advan-text">
									<h4><a href="single.jsp">There are variations passage</a></h4>
									<p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete</p>
							 </div>	
						  <div class="clearfix"> </div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
<!-- //about-page -->
		</div>
	</div>
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-3 footer-grid">
					<h3>cumque nihil impedit</h3>
					<div class="footer-grd-left">
						<img src="images/11.jpg" class="img-responsive" alt=" " />
					</div>
					<div class="footer-grd-left">
						<p>Nam libero tempore, cum 
							soluta nobis est eligendi optio cumque nihil impedit quo minus 
							id quod maxime placeat facere possimus, omnis voluptas assumenda 
							est, omnis dolor repellendus</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="col-md-3 footer-grid">
					<h3>voluptas assumenda</h3>
					<ul>
						<li><a href="#">doloribus asperiores</a></li>
						<li><a href="#">Itaque earum rerum</a></li>
						<li><a href="#">deserunt mollitia</a></li>
						<li><a href="#">facilis est et expedita</a></li>
						<li><a href="#">occaecati cupiditate</a></li>
						<li><a href="#">deserunt mollitia laborum</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h3>deserunt mollitia</h3>
					<ul>
						<li><a href="#">doloribus asperiores</a></li>
						<li><a href="#">Itaque earum rerum</a></li>
						<li><a href="#">deserunt mollitia</a></li>
						<li><a href="#">facilis est et expedita</a></li>
						<li><a href="#">occaecati cupiditate</a></li>
						<li><a href="#">deserunt mollitia laborum</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h3>Flckr Posts</h3>
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
			<p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网站模板" target="_blank">网站模板</a></p>
		</div>
	</div>
<!-- //footer -->
<!-- for bootstrap working -->
		<script src="js/bootstrap1.js"> </script>
<!-- //for bootstrap working -->
</body>
</html>
