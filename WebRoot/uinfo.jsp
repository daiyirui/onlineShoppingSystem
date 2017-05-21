<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"  %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>个人信息修改页面</title>
<link href="css/bootstrap1.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
<link href="style/login.css" type="text/css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="style/font-awesome.min.css">

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
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="js/simpleCart.min.js">
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改会员信息</title>
<link rel="stylesheet" type="text/css" href="style/font-awesome.min.css">
<link href="style/login.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style/font-awesome.min.css">
<script src="js/jquery-1.11.1.min.js"></script>
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
return true;
}
</script>


</head>
<body>

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
	
	</div>		
<!-- logo头部 -->
<div id="Up_top">
  <div style="width: 1200px; margin: 0 auto; ">
	<img src="images/logo.jpg">
  </div>
</div>
 <div class="banner-body abt">
<!-- 1200主体开始 -->
<div style="width: 1200px; margin:0 auto;">
  <div id="U_left">
  <div class="up"><a href="UserManagerServlet?userid=${userid }&action=show"><i class="icon-edit"></i>个人资料</a></div>
    <div class="up lb"><a href="UserManagerServlet?userid=${userid }&action=modifypro"><i class="icon-lock"></i>修改信息</a></div>
  </div>


   
    <!-- 右边顶部开始 -->
  <div id="U_right">


<h3 align="center" style="margin-top: 5px">修改会员信息</h3>
    <div class="update"  style="margin-top:15px;width:780px">

   
   <div class="right_content" align="center">
      <form name="register" action="UserManagerServlet" method="post"  onsubmit="return validate_form(this)">
      <input type="hidden" name=action  value="modify" >
        <input type="hidden" name=userid  value=${userid } />
				<div class="sign-up-form">
				<div class="sign-up">
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a" >用户名* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="username" id="username" class="username" value="${user.username }" style="height:30px" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
					
					
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="d">密码* :</h4>
						</div>
						<div class="sign-up2">
						
								<input type="text"  name="userpassword" id="userpassword" class="userpassword"  value="${user.userpassword }" style="height:30px" placeholder=" " required=" " />					
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>确认密码* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="password" id="confirmuserpassword" class="confirmuserpassword" style="height:30px" placeholder=" " required=" " />
							
						</div>
						<div class="clearfix"> </div>
					</div>
                             <div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">用户年龄* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="age" id="age"class="age" value="${user.age }"  style="height:30px" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>

    <div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">用户性别* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="sex" id="sex"class="sex"  value="${user.sex }" style="height:30px" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
<div class="sign-u">
						<div class="sign-up1">
							<h4 class="c">邮箱* :</h4>
						</div>
						<div class="sign-up2">
						
								<input type="text" name="email" id="email" class="email"  value="${user.email }" style="height:30px" placeholder=" " required=" " />
							
						</div>
						<div class="clearfix"> </div>
					</div>

     <div class="sign-u">
						<div class="sign-up1">
							<h4>用户电话号码* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="phone" id="phone" class="phone" value="${user.phone }"  style="height:30px"placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
	<div class="sign-u">
						<div class="sign-up1">
							<h4>用户收货地址* :</h4>
						</div>
						<div class="sign-up2">
							
								<input type="text" name="address" id="adrress" class="adrress"  value="${user.address }" style="height:30px" placeholder=" " required=" "/>
							
						</div>
						<div class="clearfix"> </div>
					</div>
				<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">备注 :</h4>
						</div>
						<div class="sign-up2">
						
								<input type="text"  name="remark" id="remark" class="remark"  value="${user.remark }"   style="height:30px"  />
							
						</div>
						
					</div>	
						<input type="submit" name="submit" id="submit" value="提交">
				</div>
			</div>
			</form>
	</div>
	</div>
	</div>
</div>

				<div class="clearfix"   ></div>
		
	<div class="footer-class"  style="margin-top: 70px" >
		
			<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved</p>
			
		</div>
		</div>
</body>
</html>
