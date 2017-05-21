package com.jxust.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.dao.BrowseproductManager;
import com.jxust.dao.ClassManager;
import com.jxust.dao.OrderManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.UserManager;
import com.jxust.dao.impl.BrowseproductManagerImpl;
import com.jxust.dao.impl.ClassManagerImpl;
import com.jxust.dao.impl.OrderManagerImpl;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.dao.impl.UserManagerImpl;
import com.jxust.entity.*;
import com.jxust.entity.Class;

public class UserManagerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4328808104437631515L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
	
	
		if ("login".equals(action)) {
			  
			login(request, response);
		} else if ("register".equals(action)) {
			register(request, response);
		}
		else if("show".equals(action)){
	
			show(request, response);
		}
		else if("modifypro".equals(action)){
			
		
			modifypro(request, response);
		}
		else if("modify".equals(action)){
			
			
			modify(request, response);
		}
		else if("home".equals(action)){
			home(request, response);
			
		}
		else if("resetpassword".equals(action)){
			rsPassword(request,response);
		}
	}
	
	

	private void rsPassword(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String resetpassword=request.getParameter("resetpassword");
		UserManager manager = new UserManagerImpl();
		if(manager.checkEmail(email)){
			if(manager.resetPassword(email,resetpassword)){
				response.sendRedirect("login.jsp");
			}
			
		}else{
			int massage=1;
			request.setAttribute("massage", massage);
			request.getRequestDispatcher("./resetPassword.jsp").forward(request, response);
		}
		
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		
		UserManager manager = new UserManagerImpl();
		 int userid = manager.checkLogin(username, userpassword).getUserid();
		
		 if (userid >0)
		 {
			 User user=manager.findUserById(userid);
			 
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

		 request.setAttribute("userid" , userid);
		 request.setAttribute("user", user);
		 request.getRequestDispatcher("./home.jsp").forward(request, response);
		 }

		 else{
		 response.sendRedirect("login.jsp");
		 }
		
	}

	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String remark = request.getParameter("remark");
		String phone= request.getParameter("phone");
		String address= request.getParameter("address");
		User user = new User();
		user.setUsername(username);
		user.setUserpassword(userpassword);
		user.setAge(Integer.parseInt(age));
		user.setSex(sex);
		user.setEmail(email);
		user.setRemark(remark);
		user.setAddress(address);
		user.setPhone(phone);

		UserManager manager = new UserManagerImpl();

		manager.register(user);

		response.sendRedirect("./login.jsp");

	}

	public void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   
		String userid=request.getParameter("userid");
		
          UserManager manager=new UserManagerImpl();
          User user=null;
           try {
        	user= manager.findUserById(Integer.parseInt(userid));
		} catch (Exception e) {
			response.sendRedirect("./login.jsp");
		}
    
      request.setAttribute("userid" , userid);
      request.setAttribute("user" , user);
		 request.getRequestDispatcher("./info.jsp").forward(request, response);
		
	}
	
	public void home(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		 UserManager userManager=new UserManagerImpl();
		  
		   User user=null;
           try {
        	user= userManager.findUserById(Integer.parseInt(userid));
		} catch (Exception e) {
			response.sendRedirect("./login.jsp");
		}
	 
	    
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
		 
		         products.add(product);}
		         request.setAttribute("classes", classes);
			     request.setAttribute("products", products);
			     request.getSession().setAttribute("userid", userid);
			     request.getSession().setAttribute("user", user);
			     request.setAttribute("browseproducts", browseproducts);
				
	    	   request.getRequestDispatcher("./home.jsp").forward(request, response);
	    	   
	
	}
	
	public void modifypro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String userid = request.getParameter("userid");
		   UserManager manager = new UserManagerImpl();
		   User user=manager.findUserById(Integer.parseInt(userid));
		  
		   request.setAttribute("user", user);
		 request.setAttribute("userid" , userid);
		 request.getRequestDispatcher("./uinfo.jsp").forward(request, response);
			
		}
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		 UserManager userManager=new UserManagerImpl();
		  
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String userpassword = request.getParameter("userpassword");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			String email = request.getParameter("email");
			String remark = request.getParameter("remark");
			String phone= request.getParameter("phone");
			String address= request.getParameter("address");

			User user = new User();
			user.setUserid(Integer.parseInt(userid));
			user.setUsername(username);
			user.setUserpassword(userpassword);
			user.setAge(Integer.parseInt(age));
			user.setSex(sex);
			user.setEmail(email);
			user.setRemark(remark);
			user.setAddress(address);
			user.setPhone(phone);
			
			userManager.modifyInfo(user);
		 
       request.setAttribute("user" , user);
		 request.setAttribute("userid" , userid);
		 request.getRequestDispatcher("./info.jsp").forward(request, response);
	}
}
