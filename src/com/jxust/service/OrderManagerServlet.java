package com.jxust.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.dao.ClassManager;
import com.jxust.dao.OrderManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.ShoppingcartManager;
import com.jxust.dao.UserManager;
import com.jxust.dao.impl.ClassManagerImpl;
import com.jxust.dao.impl.OrderManagerImpl;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.dao.impl.ShoppingcartManagerImpl;
import com.jxust.dao.impl.UserManagerImpl;
import com.jxust.entity.Class;
import com.jxust.entity.Order;
import com.jxust.entity.Orderlist;
import com.jxust.entity.Product;
import com.jxust.entity.Shoppingcart;
import com.jxust.entity.Shoppingcartlist;
import com.jxust.entity.User;

public class OrderManagerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String action=request.getParameter("action");
             init(request, response);
            if("allOrder".equals(action)){
            	showAllOrder(request, response);
            }else if("pay".equals(action)){
            	pay(request, response);
            }else if("deleteOrder".equals(action)){
            	deleteOrder(request, response);
            }else if("payshoppingcart".equals(action)){
              	payshoppingcart(request, response);
            }else if("addOrder".equals(action)){
            	addOrder(request, response);
            }
		    
	}
	public void showAllOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             String userid=request.getParameter("userid");
             UserManager userManager=new UserManagerImpl();
          
           User  user=userManager.findUserById(Integer.parseInt(userid));
         
             request.setAttribute("userid", userid); 
             request.setAttribute("user", user);   
             String start=request.getParameter("start");
             String end=request.getParameter("end");
            
             java.sql.Date date;
             java.sql.Date date1;
             java.sql.Date date2;
             OrderManager orderManager=null;
             List<Order> orders=null;
             List<Orderlist>  orderlists=new ArrayList<Orderlist>();;
             if("".equals(start)||start==null){
                  orderManager=new OrderManagerImpl();
                  orders= orderManager.findOrderByUserId(Integer.parseInt(userid));
                  
            for(Order order : orders){
             	  Product product=orderManager.findproductById(order.getOrderid());
             
            	     Orderlist orderlist=new Orderlist();
            	     orderlist.setOrderid(order.getOrderid());
            	      orderlist.setOrdername(order.getOrdername());
            	      orderlist.setProductname(product.getProductname());
            	      orderlist.setPrice(product.getPrice());
            	      orderlist.setNumber(order.getNumber());
            	      orderlist.setDiscount(product.getDiscount());
            	      orderlist.setCreatetime(order.getCreatetime());
                       orderlist.setSize(order.getSize());
            	      orderlist.setReceiver(order.getReceiver());
            	      orderlist.setPicture(product.getPicture());
            	      orderlist.setPhone(user.getPhone());
            	      orderlist.setAddress(user.getAddress());
            	      orderlist.setIndex(order.getIndex());
            	      orderlists.add(orderlist);
            	
            	     
            }
             
             }
             else{
            	 
            	 
            	     date1 = java.sql.Date.valueOf(start);
            	     date2 = java.sql.Date.valueOf(end); 
            	 
            	   
            	     
            	    orderManager=new OrderManagerImpl();
                    orders= orderManager.findOrderByUserId(Integer.parseInt(userid));
                  System.out.println(orders.toString());
              for(Order order : orders){
               	  Product product=orderManager.findproductById(order.getOrderid());
               	     date = java.sql.Date.valueOf(order.getCreatetime()); 
               	  if((date.after(date1)||date.equals(date1))&&(date.before(date2)||date.equals(date2))){
               		  System.out.println(date1);
                      System.out.println(date2);
                      System.out.println(date);
              	     Orderlist orderlist=new Orderlist();
              	     orderlist.setOrderid(order.getOrderid());
              	      orderlist.setOrdername(order.getOrdername());
              	      orderlist.setProductname(product.getProductname());
              	      orderlist.setPrice(product.getPrice());
              	      orderlist.setNumber(order.getNumber());
              	      orderlist.setDiscount(product.getDiscount());
              	      orderlist.setCreatetime(order.getCreatetime());
                         orderlist.setSize(order.getSize());
              	      orderlist.setReceiver(order.getReceiver());
              	      orderlist.setPicture(product.getPicture());
              	      orderlist.setPhone(user.getPhone());
              	      orderlist.setAddress(user.getAddress());
              	      orderlist.setIndex(order.getIndex());
              	      orderlists.add(orderlist);
               	  }
              	     
              }
            	 
             }
             
      /*      Collections.sort(orderlists, new Comparator<Orderlist>() {

				@Override
				public int compare(Orderlist o1,Orderlist o2) {
					// TODO Auto-generated method stub
					return java.sql.Date.valueOf(o2.getCreatetime()).after(java.sql.Date.valueOf(o1.getCreatetime()))?1:-1;
				}
			});*/
             request.setAttribute("start", start);
             request.setAttribute("end", end);
             request.setAttribute("orderlists", orderlists);
     	      request.getRequestDispatcher("./showallorder.jsp").forward(request, response);
             
	}
	
	public void pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             String userid=request.getParameter("userid");
             String productid=request.getParameter("productid");
             String number=request.getParameter("number");
             String size=request.getParameter("size");
            
          if(number==null||"".equals(number)){
        	  number=1+"";
          }
               ProductManager productManager=new ProductManagerImpl();
              Product product=productManager.findProductById(Integer.parseInt(productid));
              UserManager userManager=new UserManagerImpl();
             User user= userManager.findUserById(Integer.parseInt(userid));
              
              double allmoney=Integer.parseInt(number)*Double.parseDouble(product.getDiscount())*product.getPrice();
              double discountprice=Double.parseDouble(product.getDiscount())*product.getPrice();
              request.setAttribute("userid", userid); 
              request.setAttribute("product", product); 
             request.setAttribute("user", user); 
             request.setAttribute("size", size); 
              request.setAttribute("number", number);
              request.setAttribute("allmoney", allmoney);
              request.setAttribute("discountprice", discountprice);
     	      request.getRequestDispatcher("./payment.jsp").forward(request, response);
             
	}
	public void deleteOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String orderid=request.getParameter("orderid");
		   System.out.println("orderid:"+orderid);
		   OrderManager orderManager=new  OrderManagerImpl();
		   Order order1=null;
		   Order order=orderManager.findOrderById(Integer.parseInt(orderid));
		  
		   if(order.getIndex()==0){
			   int index=Integer.parseInt(orderid);
		  // orderManager.modifyOrder(Integer.parseInt(orderid));
			   index++;
			   System.out.println("index:"+index);
			    order1=orderManager.findOrderById(index);
			    System.out.println("order1:"+order1);
			    System.out.println(order1!=null);

			   while(order1==null||order1.getOrdername().equals(order.getOrdername())){
				   System.out.println("order1:"+order1);
				   if(order1!=null&&order1.getIndex()!=0){
					   order1.setIndex(0);
					  
					   orderManager.modifyOrder(order1);
					  
					  break;
				   }
				   else{
					   if(index<20)
				   order1=orderManager.findOrderById(++index);
					   else break;
				   }
			   }
			   
		   }
		 
		  
		   orderManager.deleteOrder(Integer.parseInt(orderid));
		   
		   String userid=request.getParameter("userid");
           UserManager userManager=new UserManagerImpl();
           User  user=userManager.findUserById(Integer.parseInt(userid));
           request.setAttribute("userid", userid); 
           request.setAttribute("user", user);   
            showAllOrder(request, response);
		
	}
	public void payshoppingcart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		 String userid=request.getParameter("userid");
		 
		  String allshoppingcartid=request.getParameter("allshoppingcartid");
	
	        Double allmoney=0.0;
	        int number=0;
	         String[] str1 = allshoppingcartid.split(",");
	       int[] str2 = new int[str1.length];
	       Date date=new Date();
	       String dt = new String(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
	       String dt1 = new String(new SimpleDateFormat("yyyy-MM-dd").format(date));
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
	       shoppingcartlist.setType(shoppingcart.getType());
	       shoppingcartlist.setNumber(shoppingcart.getNumber());
	       shoppingcartlist.setPrice(product.getPrice());
	       shoppingcartlist.setPicture(product.getPicture());
	       shoppingcartlist.setRemark(shoppingcartlist.getRemark());
	       shoppingcartManager.deleteShoppingcart(shoppingcart.getShoppingcartid());
	       allmoney+=Double.parseDouble(product.getDiscount())*product.getPrice()*shoppingcart.getNumber();
	     
	       Order order=new Order();
	       number=shoppingcart.getNumber();
		     if(number==0){
		    	 number=1;
		     }
	       order.setCreatetime(dt1);
	       order.setOrdername(dt);
	       order.setIndex(i);
	       order.setIsdelorder(1);
	       order.setNumber(number);
	       order.setSize(shoppingcart.getType());
	       order.setProductid(product.getProductid());
	        order.setUserid(Integer.parseInt(userid));
	 
	       OrderManager orderManager=new OrderManagerImpl();
	       orderManager.addOrder(order);
	       
	       } 
		  
	     
	
      
      showAllOrder(request, response);
       
	}

	
	public void addOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		 String userid=request.getParameter("userid");
		
    
          Date date=new Date();
	       String dt = new String(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
	       String dt1 = new String(new SimpleDateFormat("yyyy-MM-dd").format(date));
	       

		String productid=request.getParameter("productid");
		
		  String number=request.getParameter("number");
          String size=request.getParameter("size");
          if(size==null||"".equals(size)){
       	   size="均码";
          }
       if(number==null||"".equals(number)){
     	  number=1+"";
       }
		  if(productid!=null){
			  ProductManager productManager=new ProductManagerImpl();
			  Product product=productManager.findProductById(Integer.parseInt(productid));
			  OrderManager orderManager=new OrderManagerImpl();
			  
			  Order order=new Order();
			  
			  order.setOrdername(dt);
			  order.setIsdelorder(1);
			 
			  order.setCreatetime(dt1);
			  order.setNumber(Integer.parseInt(number));
			  order.setSize(size);
			  order.setProductid(product.getProductid());
			  order.setUserid(Integer.parseInt(userid));
			 orderManager.addOrder(order);
			  
		  }
		
		showAllOrder(request, response);
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
 		if(classid!=null&&"".equals(classid)){
 		 products= productManager.findProductByClass(Integer.parseInt(classid));
 	    
 	    }
 	     UserManager userManager=new UserManagerImpl();
 	    if(userid!=null&&"".equals(userid)){
            user=userManager.findUserById(Integer.parseInt(userid));
 	     }
 	 	request.setAttribute("userid", userid); 
         request.setAttribute("user", user);   
 	      request.setAttribute("products", products);
 	 
 	      request.setAttribute("classid", classid);
 	      request.setAttribute("classes", classes);
	   
   }
	

}
