<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>产品显示 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="style/login.css" type="text/css" rel="stylesheet">

<script src="js/jquery.min.js"></script>

<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />


<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>


<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="js/simpleCart.min.js">
	
</script>
<script type="text/javascript">
  function  isNumber(number)
{  

 
var  Letters  =  "1234567890-";  //可以自己增加可输入值
var  i;
var  c;
if(number.charAt(  0  )=='-')
return  false;
if(  number.charAt(  number.length  -  1  )  ==  '-'  )
return  false;
for(  i  =  0;  i  <  number.length;  i  ++  )
{  
c  =  number.charAt(  i  );
if  (Letters.indexOf(  c  )  <  0)
return  false;
}

}
	function add(userid,productid){
	      
	      
	         var intHot=null;
             var temp = document.getElementsByName("size");
      for(var i=0;i<temp.length;i++)
        {
            if(temp[i].checked)
            intHot = temp[i].value;
       }
  
           var number=document.getElementById("amount").value;
       
               alert("数量:"+number);
                  if(isNumber(number)==false){
	       alert("请输入正确的数字格式");
	       return;
	       }
               alert("尺码:"+intHot);
               if(intHot!=null)
               { alert("成功加入购物车");
                 document.location.href="./ShoppingcartManagerServlet?userid="+userid+"&productid="+productid+"&action=addShoppingcart&number="+number+"&size="+intHot;}
	            else
	            alert("没有选尺码！");
	         
	  
	}
	function pay(userid,productid){
	      
	        var intHot=null;
             var temp = document.getElementsByName("size");
      for(var i=0;i<temp.length;i++)
        {
            if(temp[i].checked)
            intHot = temp[i].value;
       }
  
           var number=document.getElementById("amount").value;
          if(isNumber(number)==false){
	       alert("请输入正确的数字格式");
	       return;
	       }
        if(intHot!=null)
               { alert("请稍等，跳转付款界面！！！");
                 document.location.href="OrderManagerServlet?userid="+userid+"&productid="+productid+"&action=pay&number="+number+"&size="+intHot;
          }
	            else
	            alert("没有选尺码！");
	  
	       
	  
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
  
  
  
  
  
  <div class="container">
  <div class="check">
  	
 <div id="U_left">
    <div class="up" style="margin-left: 330px"><img		class="img-responsive" src="${product.picture}" alt="" width="350px"></div>
</div>
<div id="U_right">
    <div class="U_top" style="margin-left: 450px"><br><br><br><br>
    <p><h4>${product.remark }</h4></p>
    <p><table  style="color:white"><tr><th style="background-color:red">乐购购物券</th></tr></table></p>
     <p class="del"><font size="2" color="#A2A2A2">价格：${product.price }</font></p>
    <p><font size="2" color="#A2A2A2">促销价：</font><font size=6 color="red">${product.price }</font></p>
    <p><font size="2" color="#A2A2A2">月销量：</font><font size="2" color="red">${product.evaluatenumber }</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="2" color="#A2A2A2">累计评价：</font><font size="2" color="red">${product.tradenumber }</font></p>
    <p><font size="2" color="#A2A2A2">尺码：</font>
    <form action="" method="post"> 
<label><input name="size" type="radio" value="37" />37</label> 
<label><input name="size" type="radio" value="38" />38</label> 
<label><input name="size" type="radio" value="39" />39 </label> 

<label><input name="size" type="radio" value="40" />40</label> 
<label><input name="size" type="radio" value="41" />41</label> 
<label><input name="size" type="radio" value="42" />42 </label> 
     <p>
     <font size="2" color="#A2A2A2">数量：</font><br>

     <input type="button"  style="width:40px;height:20px;"  value="-" onClick="javascript:if(this.form.amount.value>1) this.form.amount.value--;">
<input type="text" name="amount" id="amount" value=1  style="width:100px;height:20px;">
<input type="button" style="width:40px;height:20px;" value="+" onClick="javascript:this.form.amount.value++;">
 </p>
<br><br><br>
  <p> <style>
input[type=button]{background-color:white}
input[type=button]:hover,input[type=button]:active{background-color:#EE6911}
</style>
 <input type="button" value="立即购买" style="width:100px;height:50px;" onclick="javascript:pay(${userid},${product.productid})"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="button" value="加入购物车" style="width:100px;height:50px;" onclick="javascript:add(${userid},${product.productid})"/>    </p>  
</form>    </div>
</div>

	</div>
	
</div></div>	

<div class="footer-class" style="margin-top: 800px">



			<p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved</p>
		

		</div>
	
 </body>
</html>
