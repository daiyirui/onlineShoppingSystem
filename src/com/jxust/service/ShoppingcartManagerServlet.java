package com.jxust.service;

import java.io.IOException;
import java.io.PrintWriter;import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.dao.ClassManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.ShoppingcartManager;
import com.jxust.dao.UserManager;
import com.jxust.dao.impl.ClassManagerImpl;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.dao.impl.ShoppingcartManagerImpl;
import com.jxust.dao.impl.UserManagerImpl;
import com.jxust.entity.Class;
import com.jxust.entity.Orderlist;
import com.jxust.entity.Product;
import com.jxust.entity.Shoppingcart;
import com.jxust.entity.Shoppingcartlist;
import com.jxust.entity.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ShoppingcartManagerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       String action=request.getParameter("action");
       System.out.println(action.toString());
         init(request, response);
       if("addShoppingcart".equals(action)){
    	   addShoppingcart(request, response);
       }
       else if("allshoppingcard".equals(action)){
    	      allshoppingcard(request, response);
       }else if("deleteshoppingcard".equals(action)){
    	    deleteshoppingcard(request, response);
       }else if("allpay".equals(action)){
    	   allpay(request, response);
      }
	
	}
	
	
	public void addShoppingcart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String productid=request.getParameter("productid");
        String userid=request.getParameter("userid");
      
       String number=request.getParameter("number");
       String size=request.getParameter("size");
       if(size==null||"".equals(size)){
    	   size="均码";
       }
       if(number==null||"".equals(number)){
    	   number=1+"";
       }
       Date date=new Date();
       String dt = new String(new SimpleDateFormat("yyyy-MM-dd").format(date));
       Shoppingcart shoppingcart=new Shoppingcart();
         shoppingcart.setShoppingcartid(1);
         shoppingcart.setProductid(Integer.parseInt(productid));
         shoppingcart.setUserid(Integer.parseInt(userid));
         shoppingcart.setCreatetime(dt);
         shoppingcart.setType(size);
         shoppingcart.setRemark("备注信息");
        shoppingcart.setNumber(Integer.parseInt(number));
       
         System.out.println(shoppingcart.toString());
         
       ProductManager productManager=new ProductManagerImpl();
       Product product=productManager.findProductById(Integer.parseInt(productid));
       
       
       
       ShoppingcartManager shoppingcartManager=new ShoppingcartManagerImpl();
       shoppingcartManager.addShoppingcart(shoppingcart);
       
    
     
  
       if(userid!=null||"".equals(userid)){
    	   
           UserManager userManager=new UserManagerImpl();
           User  user=userManager.findUserById(Integer.parseInt(userid));
           request.setAttribute("userid", userid); 
           request.setAttribute("user", user);   
    	   request.setAttribute("product", product);
    	   if(product.getClassid()==4) {
  			 request.getRequestDispatcher("./product.jsp").forward(request, response);
  			 
  	           }else if(product.getClassid()==5){
  	        	   
  	        	   request.getRequestDispatcher("./product6.jsp").forward(request, response);
  	           }
             else if(product.getClassid()==7){
  	        	   
  	        	   request.getRequestDispatcher("./product5.jsp").forward(request, response);
  	           }
  	           else{
  	        	   
  	        	   request.getRequestDispatcher("./product2.jsp").forward(request, response);
  	           }
  	           
  		 }else{
  			 request.getRequestDispatcher("./browseproduct.jsp").forward(request, response);
  		 }
  		 
  		
  		 
       }
       
   
       
	
	public void allshoppingcard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String userid=request.getParameter("userid");
		  
		  UserManager userManager=new UserManagerImpl();
		  User user=userManager.findUserById(Integer.parseInt(userid));
		  
		  String start=request.getParameter("start");
          String end=request.getParameter("end");
         
          java.sql.Date date;
          java.sql.Date date1;
          java.sql.Date date2;
		  
          ShoppingcartManager shoppingcartManager=null;
          List<Shoppingcart> shoppingcarts=null;
          List<Shoppingcartlist> shoppingcartlists=null;
          if("".equals(start)||start==null){
		 shoppingcartManager=new ShoppingcartManagerImpl();
		   shoppingcarts=shoppingcartManager.findOneUserAllShoppingcarts(Integer.parseInt(userid));
		
		   shoppingcartlists=new ArrayList<Shoppingcartlist>();
		  for(Shoppingcart shoppingcart:shoppingcarts){
			  Product product=shoppingcartManager.findproductById(shoppingcart.getShoppingcartid());
			  Shoppingcartlist shoppingcartlist=new Shoppingcartlist();
			  shoppingcartlist.setShoppingcartid(shoppingcart.getShoppingcartid());
			  shoppingcartlist.setProductid(shoppingcart.getProductid());
			  shoppingcartlist.setPicture(product.getPicture());
			  shoppingcartlist.setCreatetime(shoppingcart.getCreatetime());
			  shoppingcartlist.setDiscount(product.getDiscount());
			  shoppingcartlist.setPrice(product.getPrice());
			  shoppingcartlist.setProductname(product.getProductname());
		     shoppingcartlist.setUserid(shoppingcart.getUserid());
			  shoppingcartlist.setNumber(shoppingcart.getNumber());
			  shoppingcartlist.setRemark(shoppingcart.getRemark());
			  shoppingcartlist.setType(shoppingcart.getType());
			  shoppingcartlists.add(shoppingcartlist);
			  
		  }
          }else{
        
        	  date1 = java.sql.Date.valueOf(start);
      	     date2 = java.sql.Date.valueOf(end); 
      	 
        	  
        	  shoppingcartManager=new ShoppingcartManagerImpl();
   		   shoppingcarts=shoppingcartManager.findOneUserAllShoppingcarts(Integer.parseInt(userid));
   		
   		   shoppingcartlists=new ArrayList<Shoppingcartlist>();
   		  for(Shoppingcart shoppingcart:shoppingcarts){
   			  
   			  Product product=shoppingcartManager.findproductById(shoppingcart.getShoppingcartid());
   			
   			   date = java.sql.Date.valueOf(shoppingcart.getCreatetime()); 
          	 
   			   if((date.after(date1)||date.equals(date1))&&(date.before(date2)||date.equals(date2))){
   			  Shoppingcartlist shoppingcartlist=new Shoppingcartlist();
   			  shoppingcartlist.setShoppingcartid(shoppingcart.getShoppingcartid());
   			  shoppingcartlist.setProductid(shoppingcart.getProductid());
   			  shoppingcartlist.setPicture(product.getPicture());
   			  shoppingcartlist.setCreatetime(shoppingcart.getCreatetime());
   			  shoppingcartlist.setDiscount(product.getDiscount());
   			  shoppingcartlist.setPrice(product.getPrice());
   			  shoppingcartlist.setProductname(product.getProductname());
   		     shoppingcartlist.setUserid(shoppingcart.getUserid());
   			  shoppingcartlist.setNumber(shoppingcart.getNumber());
   			  shoppingcartlist.setRemark(shoppingcart.getRemark());
   			  shoppingcartlist.setType(shoppingcart.getType());
   			  shoppingcartlists.add(shoppingcartlist);
   			   }
   		  }
        	  
        	  
          }
          
		 
          Collections.sort(shoppingcartlists, new Comparator<Shoppingcartlist>() {

				@Override
				public int compare(Shoppingcartlist o1,Shoppingcartlist o2) {
					// TODO Auto-generated method stub
					return java.sql.Date.valueOf(o1.getCreatetime()).before(java.sql.Date.valueOf(o2.getCreatetime()))?1:-1;
				}
			});
           request.setAttribute("start", start);
           request.setAttribute("end", end);
		  
           request.setAttribute("userid", userid); 
           request.setAttribute("user", user);   
		 
		  request.setAttribute("shoppingcartlists", shoppingcartlists);
		
		
		  request.getRequestDispatcher("./showallshoppingcart.jsp").forward(request, response);

	}
       
	public void deleteshoppingcard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String shoppingcartid=request.getParameter("shoppingcartid");
		  ShoppingcartManager shoppingcartManager=new ShoppingcartManagerImpl();
		    shoppingcartManager.deleteShoppingcart(Integer.parseInt(shoppingcartid));
		    allshoppingcard(request, response);
		  
		  
		
	}
	public void allpay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String userid=request.getParameter("userid");
         UserManager userManager=new UserManagerImpl();
		  User user=userManager.findUserById(Integer.parseInt(userid));
       String allshoppingcartid=request.getParameter("allshoppingcartid");
       if(allshoppingcartid.equals("")||allshoppingcartid==null){
    	   allshoppingcard(request, response);
       }
       else{
       List<Shoppingcartlist> shoppingcartlists=new ArrayList<Shoppingcartlist>();
        Double allmoney=0.0;
         String[] str1 = allshoppingcartid.split(",");
       int[] str2 = new int[str1.length];
       for (int i = 0; i < str1.length; i++) {
       str2[i] = Integer.parseInt(str1[i]);
       ShoppingcartManager shoppingcartManager=new ShoppingcartManagerImpl();
       Shoppingcart shoppingcart=shoppingcartManager.findShoppingcartById(str2[i]);
       Product product=shoppingcartManager.findproductById(str2[i]);
       Shoppingcartlist shoppingcartlist=new Shoppingcartlist();
       shoppingcartlist.setProductname(product.getProductname());
       shoppingcartlist.setShoppingcartid(shoppingcart.getShoppingcartid());
       shoppingcartlist.setProductid(product.getProductid());
       shoppingcartlist.setCreatetime(shoppingcart.getCreatetime());
       shoppingcartlist.setUserid(shoppingcart.getUserid());
       shoppingcartlist.setDiscount(product.getDiscount());
       shoppingcartlist.setNumber(shoppingcart.getNumber());
       shoppingcartlist.setPrice(product.getPrice());
       shoppingcartlist.setPicture(product.getPicture());
       shoppingcartlist.setType(shoppingcart.getType());
       shoppingcartlist.setRemark(shoppingcartlist.getRemark());
       allmoney+=Double.parseDouble(product.getDiscount())*product.getPrice()*shoppingcart.getNumber();
       shoppingcartlists.add(shoppingcartlist);
       } 
       
		
		  request.setAttribute("allshoppingcartid", allshoppingcartid); 
		  request.setAttribute("allmoney", allmoney); 
	      request.setAttribute("userid", userid); 
          request.setAttribute("user", user);   
	      request.setAttribute("shoppingcartlists", shoppingcartlists);
		  request.getRequestDispatcher("./payshoppingcart.jsp").forward(request, response);
       }
	}
	public void init(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	 
		String classid=request.getParameter("classid");
		String userid=request.getParameter("userid");
 		ClassManager classManager=new ClassManagerImpl();
 		 List<Class> classes=classManager.findAllClasses();
 		 List<Product> products=null;
 		 User user=null;
 		
 		 ProductManager productManager=new  ProductManagerImpl();
 	    if(classid!=null){
 		 products= productManager.findProductByClass(Integer.parseInt(classid));
 	    
 	    }
 	     UserManager userManager=new UserManagerImpl();
 	     if(userid!=null||"".equals(userid)){
            user=userManager.findUserById(Integer.parseInt(userid));
 	     }
 	 	request.setAttribute("userid", userid); 
         request.setAttribute("user", user);   
 	      request.setAttribute("products", products);
 	 
 	      request.setAttribute("classid", classid);
 	      request.setAttribute("classes", classes);
	   
   }
	
}
