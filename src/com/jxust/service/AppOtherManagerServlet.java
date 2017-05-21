package com.jxust.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jxust.commons.AppJsonUtil;
import com.jxust.dao.ClassManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.impl.ClassManagerImpl;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.entity.Class;
import com.jxust.entity.Product;

public class AppOtherManagerServlet extends HttpServlet {


    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("classname".equals(action)) {
            findProductGroupByClass(request, response);
        }

    }


    public void findProductGroupByClass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String className = request.getParameter("className");
        System.out.println(className);
        ClassManager classManager = new ClassManagerImpl();
        Class class1 = classManager.findClassByclassName(className);
        System.out.println(class1);
        ProductManager productManager = new ProductManagerImpl();
        List<Product> products = new ArrayList<Product>();

        products = productManager.findProductByClass(class1.getClassid());
        JSONArray jsonArray = new JSONArray();
        System.out.println(products.size());
        for (int i = 0; i < products.size(); i++) {
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject()
                        .put("productid", products.get(i).getProductid())
                        .put("productname", products.get(i).getProductname())
                        .put("price", products.get(i).getPrice())
                        .put("number", products.get(i).getNumber())
                        .put("picture", products.get(i).getPicture())
                        .put("classid", products.get(i).getClassid())
                        .put("discount", products.get(i).getDiscount())
                        .put("tradenumber", products.get(i).getTradenumber())
                        .put("evaluatenumber", products.get(i).getEvaluatenumber())
                        .put("remark", products.get(i).getRemark());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject object = new JSONObject();
        try {
            object.put("projectItem", jsonArray);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        AppJsonUtil.writeJson(response, object.toString());

    }


    public void init() throws ServletException {
        // Put your code here
    }

}
