package com.jxust.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.dao.BrowseproductManager;
import com.jxust.dao.ClassManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.UserManager;
import com.jxust.dao.impl.BrowseproductManagerImpl;
import com.jxust.dao.impl.ClassManagerImpl;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.dao.impl.UserManagerImpl;
import com.jxust.entity.Browseproduct;
import com.jxust.entity.Class;
import com.jxust.entity.Product;
import com.jxust.entity.User;

public class OtherManagerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		
		String action=request.getParameter("action");
		if("index".equals(action)){
			index(request, response);
		}
		else if("showAllProductByClass".equals(action)){
			showAllProductByClass(request, response);
		}else if("showOneProduct".equals(action))
		{
			showOneProduct(request, response);
		}
		else if("showPopularity".equals(action))
		{
			showPopularity(request, response);
		}
		else if("showHotsale".equals(action))
		{
			showHotsale(request, response);
		}
	      
	}

	public void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		
	
			 //类别操作
			 
			ClassManager classManager=new ClassManagerImpl();
			 List<Class> classes=classManager.findAllClasses();
			 	 
			 //浏览产品的东西
		 BrowseproductManager bManager=new BrowseproductManagerImpl();
	     List<Browseproduct> browseproducts=bManager.findAllBrowseproducts();
	       // System.out.println(browseproducts.toString());
	     ProductManager productManager=new ProductManagerImpl();
	     List<Product> products=new ArrayList<Product>();
	     for(Browseproduct  browseproduct : browseproducts){
	 
	     Product  product=productManager.findProductById(browseproduct.getProductid());
	 
	         products.add(product);
	  
	     }



     
	     request.setAttribute("classes", classes);
	     request.setAttribute("products", products);
	     request.setAttribute("browseproducts", browseproducts);
		
		 request.getRequestDispatcher("./index.jsp").forward(request, response);
		
	}
	
	public void showAllProductByClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   

      
        String classid=request.getParameter("classid");
   	 
		ClassManager classManager=new ClassManagerImpl();
		 List<Class> classes=classManager.findAllClasses();
		
		 BrowseproductManager bManager=new BrowseproductManagerImpl();
		 ProductManager productManager=new  ProductManagerImpl();
	     List<Product> products= productManager.findProductByClass(Integer.parseInt(classid));
	     List<Browseproduct> browseproducts=bManager.findBrowseproductsByclass(Integer.parseInt(classid));
	   
		
	

	      request.setAttribute("products", products);
	      request.setAttribute("browseproducts", browseproducts);
	      request.setAttribute("classes", classes);
	      request.setAttribute("classid", classid);
	      request.getRequestDispatcher("./index.jsp").forward(request, response);
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
		
		  
		   if(product.getClassid()==4) {
			   request.getRequestDispatcher("./browseproduct.jsp").forward(request, response);
				 
		           }else if(product.getClassid()==5){
		        	   
		        	   request.getRequestDispatcher("./browseproduct1.jsp").forward(request, response);
		           }
	           else if(product.getClassid()==7){
		        	   
	        	   request.getRequestDispatcher("./browseproduct2.jsp").forward(request, response);
		           }
		           else{
		        	   
		        	   request.getRequestDispatcher("./browseproduct3.jsp").forward(request, response);
		           }
		           
			 }
				
			 
		
		 
		
	
	
	public void showPopularity(HttpServletRequest request, HttpServletResponse response)
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
				return o1.getPopularity()-o2.getPopularity()>0?-1:1;
			}});
		 
		 request.setAttribute("classid", classid); 
	
		  request.setAttribute("browseproducts", browseproducts);
	      request.setAttribute("classes", classes);
	   
      
            request.getRequestDispatcher("./index.jsp").forward(request, response);
		
	}
	public void showHotsale(HttpServletRequest request, HttpServletResponse response)
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
				return o1.getHotsale()-o2.getHotsale()>0?-1:1;
			}});
		 
		 request.setAttribute("classid", classid); 
	
		  request.setAttribute("browseproducts", browseproducts);
	      request.setAttribute("classes", classes);
	    
            request.getRequestDispatcher("./index.jsp").forward(request, response);
             
	       
	}
	
	

	
	}


