package com.jxust.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class ProductManagerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String action=request.getParameter("action"); 
        System.out.println(action);
           if("showAllProductByClass".equals(action)){
        	  showAllProductByClass(request, response);
        	  
          }
          
		
	}


	public void showAllProductByClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    String userid=request.getParameter("userid");
        UserManager userManager=new UserManagerImpl();
        User  user=userManager.findUserById(Integer.parseInt(userid));
        String classid=request.getParameter("classid");
   	 
		ClassManager classManager=new ClassManagerImpl();
		 List<Class> classes=classManager.findAllClasses();
		
		 BrowseproductManager bManager=new BrowseproductManagerImpl();
		 ProductManager productManager=new  ProductManagerImpl();
	     List<Product> products= productManager.findProductByClass(Integer.parseInt(classid));
	     List<Browseproduct> browseproducts=bManager.findBrowseproductsByclass(Integer.parseInt(classid));
	   
		
	 	request.setAttribute("userid", userid); 
        request.setAttribute("user", user);   
	      request.setAttribute("products", products);
	      request.setAttribute("browseproducts", browseproducts);
	      request.setAttribute("classid", classid);
	      request.setAttribute("classes", classes);
	      request.getRequestDispatcher("./home.jsp").forward(request, response);
	}
	
	
}
