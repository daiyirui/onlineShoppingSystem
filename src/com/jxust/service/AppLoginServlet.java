package com.jxust.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.commons.AppJsonUtil;
import com.jxust.entity.User;
import org.json.JSONException;
import org.json.JSONObject;

import com.jxust.dao.UserManager;
import com.jxust.dao.impl.UserManagerImpl;

public class AppLoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        System.out.println("action:" + action);
        if ("login".equals(action)) {
            login(request, response);
        } else if ("sign".equals(action)) {
            sign(request, response);
        } else if ("set".equals(action)) {
            set(request, response);
        } else if ("updateSet".equals(action)) {
            updateSet(request, response);
        }

    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        boolean flag;
        System.out.println("用户名:" + username);
        UserManager manager = new UserManagerImpl();
        User user = manager.checkLogin(username, userpassword);
        // 登录成功
        if (user.getUserid() > 0) {
            request.getSession(true).setAttribute("userId", user.getUserid());
            flag = true;
        } else {
            flag = false;
        }
        try {
            String address = user.getAddress();
            String phone = user.getPhone();
            if (address == null){
                address = "";
            }
            if (phone == null){
                phone = "";
            }
            // 存储userId使用JSONObject
            JSONObject jsonObject = new JSONObject()
                    .put("flag", flag)
                    .put("userId", user.getUserid())
                    .put("phone",phone)
                    .put("address",address);
            // 返回给客户端
            AppJsonUtil.writeJson(response, jsonObject.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void sign(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean flag;
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        System.out.println("username:" + username);
        User user = new User();
        user.setUsername(username);
        user.setUserpassword(userpassword);
        user.setType(0);

        UserManager manager = new UserManagerImpl();
        if (manager.register(user)) {
            flag = true;
        } else {
            flag = false;
        }
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", flag)
                    .put("userId", -1);
            AppJsonUtil.writeJson(response, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取个人信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void set(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        UserManager manager = new UserManagerImpl();
        User user = manager.findUserById(userid);
        if (user.getUserid() > 0) {
            try {
                JSONObject jsonObject = new JSONObject()
                        .put("username", user.getUsername())
                        .put("userpassword", user.getUserpassword())
                        .put("age", user.getAge())
                        .put("sex", user.getSex())
                        .put("email", user.getEmail())
                        .put("remark", user.getRemark())
                        .put("phone", user.getPhone())
                        .put("address", user.getAddress());
                AppJsonUtil.writeJson(response, jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新个人信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateSet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean flag;
        int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String remark = request.getParameter("remark");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        User user = new User();
        user.setUserid(userid);
        user.setUsername(username);
        user.setUserpassword(userpassword);
        user.setAge(age);
        user.setSex(sex);
        user.setEmail(email);
        user.setRemark(remark);
        user.setType(0);
        user.setPhone(phone);
        user.setAddress(address);

        UserManager manager = new UserManagerImpl();
        if (manager.modifyInfo(user)) {
            flag = true;
        } else {
            flag = false;
        }
        try {
            JSONObject jsonObject = new JSONObject()
                    .put("flag", flag);
            AppJsonUtil.writeJson(response, jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
