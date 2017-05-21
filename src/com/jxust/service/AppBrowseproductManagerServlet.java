package com.jxust.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.entity.BrowseProductsList;
import com.jxust.entity.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.jxust.commons.AppJsonUtil;
import com.jxust.dao.BrowseproductManager;
import com.jxust.dao.impl.BrowseproductManagerImpl;
import com.jxust.entity.Browseproduct;

public class AppBrowseproductManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("id".equals(action)) {
            showById(request, response);
        } else if ("popularity".equals(action)) {
            showPopularity(request, response);
        } else if ("hotsale".equals(action)) {
            showHotsale(request, response);
        } else if ("all".equals(action)) {
            showAll(request, response);
        } else if ("keywords".equals(action)) {
            showByKey(request, response);
        }
    }

    private void showByKey(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String keywords = request.getParameter("keywords");
        BrowseproductManager manager = new BrowseproductManagerImpl();
        List<Browseproduct> list = manager.findBrowseproductsBykey(keywords);
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("browseproductid", list.get(i).getBrowseproductid())
                        .put("browseproductname", list.get(i).getBrowseproductname())
                        .put("productid", list.get(i).getProductid())
                        .put("classid", list.get(i).getClassid())
                        .put("popularity", list.get(i).getPopularity())
                        .put("hotsale", list.get(i).getHotsale())
                        .put("keywords", list.get(i).getKeywords())
                        .put("ramark", list.get(i).getRemark())
                        .put("picture", list.get(i).getPicture());
                jsonArray.put(jsonObject);
            } catch (Exception e) {
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

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrowseproductManager manager = new BrowseproductManagerImpl();
        List<Browseproduct> list = manager.findAllBrowseproducts();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("browseproductid", list.get(i).getBrowseproductid())
                        .put("browseproductname", list.get(i).getBrowseproductname())
                        .put("productid", list.get(i).getProductid())
                        .put("classid", list.get(i).getClassid())
                        .put("popularity", list.get(i).getPopularity())
                        .put("hotsale", list.get(i).getHotsale())
                        .put("keywords", list.get(i).getKeywords())
                        .put("ramark", list.get(i).getRemark())
                        .put("picture", list.get(i).getPicture());
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


    private void showHotsale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        BrowseproductManager manager = new BrowseproductManagerImpl();
        List<BrowseProductsList> list = manager.findBrowseByHotsale();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 10; i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("productName", list.get(i).getProductName())
                        .put("productId", list.get(i).getProductid())
                        .put("hotsale", list.get(i).getHotsale())
                        .put("popularity", list.get(i).getPopularity())
                        .put("picture", list.get(i).getPicture())
                        .put("price", list.get(i).getPrice())
                        .put("discount", list.get(i).getDiscount());
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

    private void showPopularity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        BrowseproductManager manager = new BrowseproductManagerImpl();
        List<BrowseProductsList> list = manager.findBrowseByPopularity();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("productName", list.get(i).getProductName())
                        .put("productId", list.get(i).getProductid())
                        .put("hotsale", list.get(i).getHotsale())
                        .put("popularity", list.get(i).getPopularity())
                        .put("picture", list.get(i).getPicture())
                        .put("price", list.get(i).getPrice())
                        .put("discount", list.get(i).getDiscount());
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

    private void showById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int browseProductId = Integer.parseInt(request.getParameter("browseProductId"));
        BrowseproductManager manager = new BrowseproductManagerImpl();
        Browseproduct browseproduct = manager
                .findBrowseproductById(browseProductId);
        if (browseproduct.getBrowseproductid() > 0) {
            try {
                String a = null;
                JSONObject jsonObject = new JSONObject()
                        .put("browseproductid", browseproduct.getBrowseproductid())
                        .put("browseproductname", browseproduct.getBrowseproductid())
                        .put("productid", browseproduct.getProductid())
                        .put("classid", browseproduct.getClassid())
                        .put("popularity", browseproduct.getPopularity())
                        .put("hotsale", browseproduct.getHotsale())
                        .put("keywords", browseproduct.getKeywords())
                        .put("remark", browseproduct.getRemark())
                        .put("picture", browseproduct.getPicture());
                AppJsonUtil.writeJson(response, jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                // TODO: handle exception
            }
        }
    }
}
