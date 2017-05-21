package com.jxust.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.jxust.dao.BrowseproductManager;
import com.jxust.dao.ClassManager;
import com.jxust.dao.UserManager;
import com.jxust.dao.impl.BrowseproductManagerImpl;
import com.jxust.dao.impl.ClassManagerImpl;
import com.jxust.dao.impl.UserManagerImpl;
import com.jxust.entity.Browseproduct;
import com.jxust.entity.Class;
import com.jxust.entity.Product;
import com.jxust.entity.User;

public class BrowseproductManagerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               String action=request.getParameter("action");
               System.out.println(action);
               if("showPopularity".equals(action)){
            	   showPopularity(request, response);
               }
               else if("showHotsale".equals(action)){
            	    showHotsale(request, response);
               }else if("all".equals(action)){
            	   
            	   showAll(request, response);
               }else if("key".equals(action)){
            	   showByKey(request, response);
               }
               else if("showOneProduct".equals(action)){
            	   showOneProduct(request, response);
             	  
               }else if("search".equals(action)){
             	  
             	  showByKey(request, response);
             	  
             	  
               }
             
	       
	}
	
	
	private void showOneProduct(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String browseproductid=request.getParameter("browseproductid");
	
		 BrowseproductManager browseproductManager=new BrowseproductManagerImpl();
		
		 Browseproduct browseproduct=browseproductManager.findBrowseproductById(Integer.parseInt(browseproductid));
		 Product product=browseproductManager.findproductById(Integer.parseInt(browseproductid));
		
		 request.setAttribute("browseproduct", browseproduct);
		 request.setAttribute("product",product);
		   String userid=request.getParameter("userid");
		 
		
		 if(userid!=null){
			
			
			 UserManager userManager=new UserManagerImpl();
	           User  user=userManager.findUserById(Integer.parseInt(userid));
	           request.setAttribute("userid", userid); 
	           request.setAttribute("user", user);   
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



	public void showPopularity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String classid=request.getParameter("classid");
		ClassManager classManager=new ClassManagerImpl();
		 List<Class> classes=classManager.findAllClasses();
		 BrowseproductManager browseproductManager=new BrowseproductManagerImpl();
		 List<Browseproduct>  browseproducts=null;
		
	
		
		if(classid!=null&&!classid.equals(""))
		{
			 browseproducts=browseproductManager.findBrowseproductsByclass(Integer.parseInt(classid));
		}
		else {
			browseproducts=browseproductManager.findAllBrowseproducts();
		}
	
		Collections.sort(browseproducts,new Comparator<Browseproduct>() {

			@Override
			public int compare(Browseproduct o1, Browseproduct o2) {
				// TODO Auto-generated method stub
				return o1.getPopularity()-o2.getPopularity()>0?-1:1;
			}});
		 
		 request.setAttribute("classid", classid); 
	
		  request.setAttribute("browseproducts", browseproducts);
	      request.setAttribute("classes", classes);
	      String userid=request.getParameter("userid");
	      if(userid!=null&&!userid.equals("")){
				 UserManager userManager=new UserManagerImpl();
	             User  user=userManager.findUserById(Integer.parseInt(userid));
	             request.setAttribute("userid", userid); 
	             request.setAttribute("user", user);   
             request.getRequestDispatcher("./home.jsp").forward(request, response);}
			 else{
				 
				  request.getRequestDispatcher("./index.jsp").forward(request, response);
			 }
		
	}
	public void showHotsale(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String classid=request.getParameter("classid");
		ClassManager classManager=new ClassManagerImpl();
		 List<Class> classes=classManager.findAllClasses();
		 BrowseproductManager browseproductManager=new BrowseproductManagerImpl();
		 List<Browseproduct>  browseproducts=null;
		
		 System.out.println("classid:"+classid);
		
		if(classid!=null&&!classid.equals(""))
		{
			 browseproducts=browseproductManager.findBrowseproductsByclass(Integer.parseInt(classid));
		}
		else {
			browseproducts=browseproductManager.findAllBrowseproducts();
		}
	
		Collections.sort(browseproducts,new Comparator<Browseproduct>() {

			@Override
			public int compare(Browseproduct o1, Browseproduct o2) {
				// TODO Auto-generated method stub
				return o1.getHotsale()-o2.getHotsale()>0?-1:1;
			}});
		 
		 request.setAttribute("classid", classid); 
	
		  request.setAttribute("browseproducts", browseproducts);
	      request.setAttribute("classes", classes);
	      String userid=request.getParameter("userid");
	      if(userid!=null&&!userid.equals("")){
				 UserManager userManager=new UserManagerImpl();
	             User  user=userManager.findUserById(Integer.parseInt(userid));
	             request.setAttribute("userid", userid); 
	             request.setAttribute("user", user);   
             request.getRequestDispatcher("./home.jsp").forward(request, response);}
			 else{
				 
				  request.getRequestDispatcher("./index.jsp").forward(request, response);
			 }
             
	       
	}
	public void showAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             
             
	       
	}
	
	public void showByKey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             
		
		
		
		 String keywords=request.getParameter("keywords");
		 BrowseproductManager browseproductManager=new BrowseproductManagerImpl();
		 List<Browseproduct>  browseproducts=browseproductManager.findBrowseproductsBykey(keywords);
			ClassManager classManager=new ClassManagerImpl();
			 List<Class> classes=classManager.findAllClasses();
			 request.setAttribute("keywords", keywords); 
			  request.setAttribute("browseproducts", browseproducts);
		      request.setAttribute("classes", classes);
		      String userid=request.getParameter("userid");
	            
			 if(userid!=null&&!userid.equals("")){
				 UserManager userManager=new UserManagerImpl();
	             User  user=userManager.findUserById(Integer.parseInt(userid));
	             request.setAttribute("userid", userid); 
	             request.setAttribute("user", user);   
                request.getRequestDispatcher("./home.jsp").forward(request, response);}
			 else{
				 
				  request.getRequestDispatcher("./index.jsp").forward(request, response);
			 }
	}
	


}
