package com.jxust.service;

import com.jxust.commons.AppJsonUtil;
import com.jxust.dao.ProductManager;
import com.jxust.dao.ShoppingcartManager;
import com.jxust.dao.UserManager;
import com.jxust.dao.impl.ProductManagerImpl;
import com.jxust.dao.impl.ShoppingcartManagerImpl;
import com.jxust.dao.impl.UserManagerImpl;
import com.jxust.entity.Product;
import com.jxust.entity.Shoppingcart;
import com.jxust.entity.Shoppingcartlist;
import com.jxust.entity.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by idisfkj on 16/7/22.
 */
public class AppShoppingCartManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            addShoppingCart(req, resp);
        } else if ("showAll".equals(action)) {
            showAllShoppingCart(req, resp);
        } else if ("addOrSub".equals(action)) {
            addOrSub(req, resp);
        } else if ("delete".equals(action)) {
            delete(req, resp);
        } else if ("deleteAll".equals(action)) {
            deleteAll(req, resp);
        }
    }

    /**
     * 添加商品到购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void addShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productid = req.getParameter("productid");
        String userid = req.getParameter("userid");
        String type = req.getParameter("type");
        boolean result;
        ShoppingcartManager shoppingcartManager = new ShoppingcartManagerImpl();
        //查询购物车中是否有该商品
        int id = shoppingcartManager.checkoutShoppingCart(Integer.parseInt(productid), Integer.parseInt(userid), type);
        if (id > 0) {
            //有则数量自增
            result = shoppingcartManager.updateShoppingCartNumber(id, 1);
        } else {
            System.out.println("add");
            //没有就在购物车中添加一条新数据项
            Date date = new Date();
            String dt = new String(new SimpleDateFormat("yyyy-MM-dd").format(date));
            Shoppingcart shoppingcart = new Shoppingcart();
            shoppingcart.setProductid(Integer.parseInt(productid));
            shoppingcart.setUserid(Integer.parseInt(userid));
            shoppingcart.setCreatetime(String.valueOf(java.sql.Date.valueOf(dt)));
            shoppingcart.setRemark("备注信息");
            shoppingcart.setNumber(1);
            shoppingcart.setType(type);

            result = shoppingcartManager.addShoppingcart(shoppingcart);
        }
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", result);
            AppJsonUtil.writeJson(resp, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 展示用户购物车信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showAllShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        ShoppingcartManager manager = new ShoppingcartManagerImpl();
        List<Shoppingcartlist> list = manager.queryAllShoppingCartByUserId(Integer.parseInt(userid));
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("shoppingcartid", list.get(i).getShoppingcartid())
                        .put("productid", list.get(i).getProductid())
                        .put("picture", list.get(i).getPicture())
                        .put("price", list.get(i).getPrice())
                        .put("discount", list.get(i).getDiscount())
                        .put("remark", list.get(i).getRemark())
                        .put("number", list.get(i).getNumber())
                        .put("type", list.get(i).getType());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("shoppingCartItem", jsonArray);
            AppJsonUtil.writeJson(resp, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addOrSub(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int shoppingcartid = Integer.parseInt(req.getParameter("shoppingcartid"));
        int flag = Integer.parseInt(req.getParameter("flag"));
        ShoppingcartManager manager = new ShoppingcartManagerImpl();
        boolean result = manager.updateShoppingCartNumber(shoppingcartid, flag);
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", result);
            AppJsonUtil.writeJson(resp, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int shoppingcartid = Integer.parseInt(req.getParameter("shoppingcartid"));
        ShoppingcartManager manager = new ShoppingcartManagerImpl();
        boolean result = manager.deleteShoppingcart(shoppingcartid);
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", result);
            AppJsonUtil.writeJson(resp, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userid = Integer.parseInt(req.getParameter("userid"));
        ShoppingcartManager manager = new ShoppingcartManagerImpl();
        boolean result = manager.deleteAllByUserId(userid);
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", result);
            AppJsonUtil.writeJson(resp, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
