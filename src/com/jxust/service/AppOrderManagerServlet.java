package com.jxust.service;

import com.jxust.commons.AppJsonUtil;
import com.jxust.dao.ClassManager;
import com.jxust.dao.OrderManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.ShoppingcartManager;
import com.jxust.dao.impl.ClassManagerImpl;
import com.jxust.dao.impl.OrderManagerImpl;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.dao.impl.ShoppingcartManagerImpl;
import com.jxust.entity.Class;
import com.jxust.entity.Order;
import com.jxust.entity.Orderlist;
import com.jxust.entity.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by idisfkj on 16/7/25.
 */
public class AppOrderManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if ("showAll".equals(action)) {
            showAllOrder(req, resp);
        } else if ("addOrder".equals(action)) {
            addOrder(req, resp);
        }else if("orderName".equals(action)){
        	findProductByOrderName(req,resp);
        }else if("confirmReceiver".equals(action)){
        	confirmReceveredByOrderName(req,resp);
        }else if("isDelOrder".equals(action)){
        	comfirmIsDelOrderByOrderName(req,resp);
        }
    }

    /**
     * 确认删除订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void comfirmIsDelOrderByOrderName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String orderName = request.getParameter("orderName");
        OrderManager orderManager = new OrderManagerImpl();
        boolean result = orderManager.isDelOrderByOrderName(orderName);
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", result);
            AppJsonUtil.writeJson(response, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 确认收货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void confirmReceveredByOrderName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String orderName = request.getParameter("orderName");
        OrderManager orderManager = new OrderManagerImpl();
        boolean result = orderManager.comfirmReceiveByOrderName(orderName);
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", result);
            AppJsonUtil.writeJson(response, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 根据订单查找产品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findProductByOrderName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String orderName = request.getParameter("orderName");
			System.out.println(orderName);
			 OrderManager orderManager = new OrderManagerImpl();
		     List<Product> products = new ArrayList<Product>();
		     
			 products = orderManager.findProductByOrder(orderName);
			 JSONArray jsonArray = new JSONArray();
			 System.out.println(products.size());
			 for(int i= 0; i < products.size(); i++){
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

    /**
     * 展示所有用户订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void showAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        OrderManager manager = new OrderManagerImpl();
        //找到orderName
        List<String> listOrderName = manager.findOrderNameByUserid(userid);
        //整合每一个orderName 形成orderList
        List<Orderlist> orderlists = new ArrayList<Orderlist>();

        for (int i = 0; i < listOrderName.size(); i++) {
            //找到每一个orderList
            List<Orderlist> list = manager.findOrderListByOrderName(listOrderName.get(i));
            int totalAccount = 0;
            int totalNumber = 0;
            for (int j = 0; j < list.size(); j++) {
                totalAccount = (int) (list.get(j).getPrice() * list.get(j).getNumber()) + totalAccount;
                totalNumber = list.get(j).getNumber() + totalNumber;
            }
            Orderlist orderlist = new Orderlist();
            orderlist.setOrdername(listOrderName.get(i));
            orderlist.setCreatetime(list.get(0).getCreatetime());
            orderlist.setPicture(list.get(0).getPicture());
            orderlist.setRemark(list.get(0).getRemark());
            orderlist.setTotalAccount(totalAccount);
            orderlist.setNumber(totalNumber);
            orderlist.setIsdelorder(list.get(0).getIsdelorder());
            orderlist.setReceiver(list.get(0).getReceiver());
            //形成全新的orderList
            orderlists.add(orderlist);
        }

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < orderlists.size(); i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("ordername", orderlists.get(i).getOrdername())
                        .put("createtime", orderlists.get(i).getCreatetime())
                        .put("remark", orderlists.get(i).getRemark())
                        .put("totalAccount", orderlists.get(i).getTotalAccount())
                        .put("number", orderlists.get(i).getNumber())
                        .put("isdelorder", orderlists.get(i).getIsdelorder())
                        .put("receiver", orderlists.get(i).getReceiver())
                        .put("picture",orderlists.get(i).getPicture());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("orderItems", jsonArray);
            AppJsonUtil.writeJson(response, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从购物车添加到订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ordername = request.getParameter("ordername");
        int productid = Integer.parseInt(request.getParameter("productid"));
        int number = Integer.parseInt(request.getParameter("number"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        String createtime = request.getParameter("createtime");
        int isdelorder = Integer.parseInt(request.getParameter("isdelorder"));
        String remark = request.getParameter("remark");
        int receiver = Integer.parseInt(request.getParameter("receiver"));

        Order order = new Order();
        order.setOrdername(ordername);
        order.setProductid(productid);
        order.setNumber(number);
        order.setUserid(userid);
        order.setCreatetime(createtime);
        order.setIsdelorder(isdelorder);
        order.setRemark(remark);
        order.setReceiver(receiver);

        OrderManager manager = new OrderManagerImpl();
        boolean result = manager.addOrder(order);
        try {
            JSONObject jsonObject = new JSONObject().put("flag", result);
            AppJsonUtil.writeJson(response, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
