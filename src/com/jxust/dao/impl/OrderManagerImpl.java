package com.jxust.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.OrderManager;
import com.jxust.entity.*;
import com.jxust.entity.Order;
import com.jxust.entity.Orderlist;
import com.jxust.entity.Product;
import com.sun.crypto.provider.RSACipher;


public class OrderManagerImpl implements OrderManager {

    @Override
    public List<Product> findProductByOrder(String orderName) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select product.productid,product.productname,product.classid"
                    + ",product.price , ordero.number , product.picture , product.remark , product.discount"
                    + ",product.tradenumber , product.evaluatenumber from product,ordero where ordero.ordername="
                    + "'" + orderName + "'" + "and ordero.productid = product.productid");
            while (rs.next()) {
                Product product = new Product();
                product.setProductid(rs.getInt(1));
                product.setProductname(rs.getString(2));
                product.setClassid(rs.getInt(3));
                product.setPrice(rs.getInt(4));
                product.setNumber(rs.getInt(5));
                product.setPicture(rs.getString(6));

                product.setRemark(rs.getString(7));
                product.setDiscount(rs.getString(8));
                product.setTradenumber(Integer.parseInt(rs.getString(9)));
                product.setEvaluatenumber(Integer.parseInt(rs.getString(10)));
                products.add(product);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }
        return products;
    }




    @Override
    public Order findOrderById(int Orderid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Order order = null;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            String sql="select * from ordero where orderid = "+Orderid+" and isdelorder=1";
            System.out.println(sql);
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                order = new Order();
                order.setOrderid(rs.getInt(1));
                order.setOrdername(rs.getString(2));
                order.setProductid(rs.getInt(3));
                order.setNumber(rs.getInt(4));
                order.setUserid(rs.getInt(5));
                order.setUserjudge(rs.getString(6));
                order.setCreatetime(rs.getString(7));
                order.setIsdelorder(rs.getInt(8));
                order.setRemark(rs.getString(9));
                order.setReceiver(rs.getInt(10));
                order.setIndex(rs.getInt("ind"));
                order.setSize(rs.getString("size"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return order;

    }

    @Override
    public Order findAllOrderById(int Orderid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Order order = null;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from ordero where orderid =" + Orderid);
            while (rs.next()) {
                order = new Order();
                order.setOrderid(rs.getInt(1));
                order.setOrdername(rs.getString(2));
                order.setProductid(rs.getInt(3));
                order.setNumber(rs.getInt(4));
                order.setUserid(rs.getInt(5));
                order.setUserjudge(rs.getString(6));
                order.setCreatetime(rs.getString(7));
                order.setIsdelorder(rs.getInt(8));
                order.setRemark(rs.getString(9));
                order.setReceiver(rs.getInt(10));
                order.setIndex(rs.getInt("ind"));
                order.setSize(rs.getString("size"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return order;

    }
    @Override

    public Product findproductById(int orderid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Product product = null;
        conn = JDBCUtil.getConn();
     
        Order order =null;
        try {
        	order = findOrderById(orderid);
            stat = conn.createStatement();
            String sql = "select * from product where productid=" + order.getProductid();

            rs = stat.executeQuery(sql);

            while (rs.next()) {
                product = new Product();
                product.setProductid(rs.getInt(1));
                product.setProductname(rs.getString(2));
                product.setClassid(rs.getInt(3));
                product.setPrice(rs.getInt(4));
                product.setNumber(rs.getInt(5));
                product.setPicture(rs.getString(6));

                product.setRemark(rs.getString(7));
                product.setDiscount(rs.getString(8));
                product.setTradenumber(rs.getInt(9));
                product.setEvaluatenumber(rs.getInt(10));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return product;
    }

    @Override
    public List<Order> findAllOrder() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<Order>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from ordero where isdelorder=" + 1);
            while (rs.next()) {
                Order order = new Order();

                order.setOrderid(rs.getInt(1));
                order.setOrdername(rs.getString(2));
                order.setProductid(rs.getInt(3));
                order.setNumber(rs.getInt(4));
                order.setCreatetime(rs.getString(5));
                order.setUserid(rs.getInt(6));
                order.setUserjudge(rs.getString(7));
                order.setIsdelorder(rs.getInt(8));
                order.setRemark(rs.getString(9));
                order.setReceiver(rs.getInt(10));
                order.setSize(rs.getString("size"));
                orders.add(order);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return orders;
    }


    @Override
    public boolean addOrder(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result;

        try {
            String sql = "insert into ordero(ordername,productid,number,userid,userjudge,createtime,isdelorder,remark,receiver,ind,size) "
                    + "value(?,?,?,?,?,?,?,?,?,?,?)";
            connection = JDBCUtil.getConn();
            statement = connection.prepareStatement(sql);
            statement.setString(1, order.getOrdername());
            statement.setInt(2, order.getProductid());
            statement.setInt(3, order.getNumber());
            statement.setInt(4, order.getUserid());
            statement.setString(5, order.getUserjudge());
            statement.setString(6, order.getCreatetime());
            statement.setInt(7,1);
            statement.setString(8, order.getRemark());
            statement.setInt(9, order.getReceiver());
            statement.setInt(10, order.getIndex());
            statement.setString(11, order.getSize());
            statement.executeUpdate();

            result = true;
        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, null);
        }
        return result;
    }

    @Override
    public void deleteOrder(int Orderid) {
        Connection connection = null;
        PreparedStatement statement = null;


        try {
            String sql = "update ordero set isdelorder=? where orderid=? ";
            connection = JDBCUtil.getConn();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setInt(2, Orderid);

            statement.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, null);
        }


    }

    @Override
    public void modifyOrder(Order order) {

        Connection connection = null;
        PreparedStatement statement = null;


        try {
            String sql = "update ordero set ordername=?,productid=?,number=?,userid=?,userjudge=?,createtime=?,isdelorder=?,remark=?,receiver=?,ind=?,size=? where orderid=? ";
            connection = JDBCUtil.getConn();
            statement = connection.prepareStatement(sql);

            statement.setString(1, order.getOrdername());
            statement.setInt(2, order.getProductid());
            statement.setInt(3, order.getNumber());
            statement.setInt(4, order.getUserid());
            statement.setString(5, order.getUserjudge());
            statement.setString(6, order.getCreatetime());
            statement.setInt(7, order.getIsdelorder());
            statement.setString(8, order.getRemark());
            statement.setInt(9, order.getReceiver());
            statement.setInt(10, order.getIndex());
            statement.setString(11, order.getSize());
            statement.setInt(12, order.getOrderid());
            statement.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, null);
        }


    }

    @Override
    public List<String> findOrderNameByUserid(int userid) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = JDBCUtil.getConn();
        List<String> list = new ArrayList<String>();
        String sql = "select distinct ordername from ordero where isdelorder=" + 1 + " and  userid = " + userid;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Orderlist> findOrderListByOrderName(String orderName) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Orderlist> orders = new ArrayList<Orderlist>();

        conn = JDBCUtil.getConn();
        String sql = "select ordero.number,ordero.createtime,ordero.isdelorder,ordero.remark,ordero.receiver" +
                ",product.price,product.picture from ordero,product " +
                "where ordero.ordername = " + "'" + orderName + "'" + " and ordero.productid = product.productid";
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Orderlist orderlist = new Orderlist();
                orderlist.setNumber(rs.getInt(1));
                orderlist.setCreatetime(rs.getString(2));
                orderlist.setIsdelorder(rs.getInt(3));
                orderlist.setRemark(rs.getString(4));
                orderlist.setReceiver(rs.getInt(5));
                orderlist.setPrice(rs.getInt(6));
                orderlist.setPicture(rs.getString(7));
                orders.add(orderlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> findOrder(Date start, Date end) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<Order>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from ordero where createtime>=" + start + " and createtime=<" + end);
            while (rs.next()) {
                Order order = new Order();
                order.setOrderid(rs.getInt(1));
                order.setOrdername(rs.getString(2));
                order.setProductid(rs.getInt(3));
                order.setNumber(rs.getInt(4));
                order.setUserid(rs.getInt(5));
                order.setUserjudge(rs.getString(6));
                order.setCreatetime(rs.getString(7));
                order.setIsdelorder(rs.getInt(8));
                order.setRemark(rs.getString(9));
                order.setReceiver(rs.getInt(10));
                order.setIndex(rs.getInt("ind"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return orders;
    }

    @Override
    public List<Order> findOrderByUserId(int userid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<Order>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            String sql = "select * from ordero where isdelorder=" + 1 + "  and userid= " + userid;
            System.out.println(sql);
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                Order order = new Order();

                order.setOrderid(rs.getInt(1));
                order.setOrdername(rs.getString(2));
                order.setProductid(rs.getInt(3));
                order.setNumber(rs.getInt(4));
                order.setUserid(rs.getInt(5));
                order.setUserjudge(rs.getString(6));
                order.setCreatetime(rs.getString(7));
                order.setIsdelorder(rs.getInt(8));
                order.setRemark(rs.getString(9));
                order.setReceiver(rs.getInt(10));
                order.setIndex(rs.getInt("ind"));

                order.setSize(rs.getString("size"));


                orders.add(order);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {

            JDBCUtil.closeDB(conn, stat, rs);
        }

        return orders;
    }

    @Override
    public User findUserByUserId(int userid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean comfirmReceiveByOrderName(String orderName) {
        Connection conn = null;
        Statement stat = null;
        boolean result ;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            String sql = "update ordero set receiver = 0 where ordername = " + "'" + orderName + "'" ;
            System.out.println(sql);
            stat.executeUpdate(sql);
            result = true;
        } catch (SQLException e) {
            result = false ;
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean isDelOrderByOrderName(String orderName) {
        Connection conn = null;
        Statement stat = null;
        boolean result ;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            String sql = "update ordero set isdelorder = 0 where ordername = " + "'" + orderName + "'" ;
            System.out.println(sql);
            stat.executeUpdate(sql);
            result = true;
        } catch (SQLException e) {
            result = false ;
            e.printStackTrace();
        }

        return result;
    }


}
