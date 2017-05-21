<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>会员注册界面</title>
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
	<script type="text/javascript">
	
	function  isNumber()
{  

 var phone = document.getElementById("phone").value; 
var  Letters  =  "1234567890-";  //可以自己增加可输入值
var  i;
var  c;
if(phone.charAt(  0  )=='-')
return  false;
if(  phone.charAt(  phone.length  -  1  )  ==  '-'  )
return  false;
for(  i  =  0;  i  <  phone.length;  i  ++  )
{  
c  =  phone.charAt(  i  );
if  (Letters.indexOf(  c  )  <  0)
return  false;
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

}
}



function checkpassword(){ 
           var password = document.getElementById("userpassword").value; 
           var repsword = document.getElementById("confirmuserpassword").value; 
       if(password != repsword) {
        alert("两次密码不同，请重新输入");
         return false;
          }
      
       }
       


function checksex(){
 
                var sex = document.getElementById("sex").value; 
                
                 if(sex!="男"&&sex!="女") {
           alert("请重新输入性别！");
            return false;
          }
       
 }      
       
       


function validate_form(thisform)
{

   
with (thisform)
{
if (validate_email(email,"Not a valid e-mail address!")==false)
  {email.focus();return false;}
  
  if(checkpassword()==false){
  return false;
  }
  if(checksex()==false){
  return false;
  }
   if(isNumber()==false){
  
   return false;
  }
  
}

   alert("注册成功！请登录！");
   return true;
}

</script>
<body>
<!-- banner-body -->
	<div class="banner-body regstr">
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
<!-- register -->
             <form  name="register" action="UserManagerServlet" method="post" onsubmit="return validate_form(this)">
              <input type="hidden" name="action" value="register" >
			<div class="sign-up-form">
				<h3>Register here</h3>
					<p>Having hands on experience in creating innovative designs,I do offer design 
						solutions which harness</p>
						
				<div class="sign-up">
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">用户名* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="username" id="username" class="username" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
					
					
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="d">密码* :</h4>
						</div>
						<div class="sign-up2">
						
								<input type="password"  name="userpassword" id="userpassword" class="userpassword" placeholder=" " required=" "/>
						
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>确认密码* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="password" id="confirmuserpassword" class="confirmuserpassword" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
                             <div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">用户年龄* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="age" id="age"class="age" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>

    <div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">用户性别* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="sex" id="sex"class="sex" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
<div class="sign-u">
						<div class="sign-up1">
							<h4 class="c">邮箱* :</h4>
						</div>
						<div class="sign-up2">
						
								<input type="text" name="email" id="email" class="email" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>

     <div class="sign-u">
						<div class="sign-up1">
							<h4>用户电话号码* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="phone" id="phone" class="phone" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
	<div class="sign-u">
						<div class="sign-up1">
							<h4>用户收货地址* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="address" id="adrress" class="adrress" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
				<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">备注 :</h4>
						</div>
						<div class="sign-up2">
						
								<input type="text"  name="remark" id="remark" class="remark" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>	
						<input type="submit" name="submit" id="submit" value="提交">
					
				</div>
			</div>
			</form>
<!-- //register -->
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