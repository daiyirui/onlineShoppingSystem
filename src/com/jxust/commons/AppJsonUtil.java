package com.jxust.commons;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AppJsonUtil {

	public static String Stuent_name="sname";
	public static String Stuent_pwd="spwd";
	public static String Stuent_age="sage";
	public static String Stuent_detail="sdetail";
	public static String WelcomeMymsg="MyMsg?";
	public static String WelcomeAllmsg="AllMsg?";
	
	public static void writeJson(HttpServletResponse respone, String result) {
		
		respone.setContentType("application/json;charset=utf-8");
		PrintWriter out; 
		try {
		 

			out = respone.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("Comm_Util_writeJson---->" + e);
		}
	}
}
