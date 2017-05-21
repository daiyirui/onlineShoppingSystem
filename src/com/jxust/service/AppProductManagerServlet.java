package com.jxust.service;

import com.jxust.commons.AppJsonUtil;
import com.jxust.dao.ProductManager;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.entity.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by idisfkj on 16/7/19.
 */
public class AppProductManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if ("query".equals(action)) {
            query(req, resp);
        } else if ("queryAll".equals(action)) {
            queryAll(req, resp);
        } else if ("queryHost".equals(action)) {
            queryHost(req, resp);
        }

    }

    /**
     * 查询单个商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductManager manager = new ProductManagerImpl();
        Product product = manager.findProductById(productId);
        if (product.getProductid() > 0) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("productid", product.getProductid())
                        .put("productname", product.getProductname())
                        .put("price", product.getPrice())
                        .put("number", product.getNumber())
                        .put("picture", product.getPicture())
                        .put("classid", product.getClassid())
                        .put("remark", product.getRemark())
                        .put("discount", product.getDiscount())
                        .put("tradenumber", product.getTradenumber())
                        .put("evaluatenumber", product.getEvaluatenumber());
                AppJsonUtil.writeJson(response, jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询所有商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductManager manager = new ProductManagerImpl();
        List<Product> list = manager.findAllProduct();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("productid", list.get(i).getProductid())
                        .put("productname", list.get(i).getProductname())
                        .put("price", list.get(i).getPrice())
                        .put("number", list.get(i).getNumber())
                        .put("picture", list.get(i).getPicture())
                        .put("classid", list.get(i).getClassid())
                        .put("remark", list.get(i).getRemark())
                        .put("discount", list.get(i).getDiscount())
                        .put("tradenumber", list.get(i).getTradenumber())
                        .put("evaluatenumber", list.get(i).getEvaluatenumber());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject object = new JSONObject();
        try {
            object.put("projectItem", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppJsonUtil.writeJson(response, object.toString());
    }

    /**
     * 查询热销商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryHost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductManager manager = new ProductManagerImpl();
        List<Product> list = manager.findHostByTradeNumber();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("id", list.get(i).getProductid())
                        .put("imgUrl", "http://192.168.3.1:8080/" + list.get(i).getPicture())
                        .put("descText", list.get(i).getRemark());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject object = new JSONObject();
        try {
            object.put("items", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppJsonUtil.writeJson(response, object.toString());
    }

}
