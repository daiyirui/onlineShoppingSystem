package com.jxust.dao.impl;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.ShoppingcartManager;
import com.jxust.entity.Product;
import com.jxust.entity.Shoppingcart;
import com.jxust.entity.Shoppingcartlist;

public class ShoppingcartManagerImpl implements ShoppingcartManager {

    @Override
    public Product findproductById(int shoppingcartid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Shoppingcart shoppingcart=findShoppingcartById(shoppingcartid);
        Product product = null;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from Product where productid =" + shoppingcart.getProductid());
            while (rs.next()) {
                product = new Product();
                product.setProductid(rs.getInt(1));
                product.setProductname(rs.getString(2));
                product.setClassid(rs.getInt(3));
                product.setPrice(rs.getDouble(4));
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
    public List<Shoppingcart> findAllShoppingcarts() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Shoppingcart> shoppingcarts = new ArrayList<Shoppingcart>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from shoppingcart");
            while (rs.next()) {
                Shoppingcart shoppingcart = new Shoppingcart();
                shoppingcart.setShoppingcartid(rs.getInt(1));
                shoppingcart.setProductid(rs.getInt(2));
                shoppingcart.setUserid(rs.getInt(3));
                shoppingcart.setNumber(rs.getInt(4));

                shoppingcart.setCreatetime(String.valueOf(rs.getDate(5)));

                shoppingcart.setRemark(rs.getString(6));
                shoppingcart.setType(rs.getString("type"));
                shoppingcarts.add(shoppingcart);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return shoppingcarts;
    }

    @Override
    public List<Shoppingcart> findOneUserAllShoppingcarts(int userid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Shoppingcart> shoppingcarts = new ArrayList<Shoppingcart>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from shoppingcart where userid=" + userid);
            while (rs.next()) {
                Shoppingcart shoppingcart = new Shoppingcart();
                shoppingcart.setShoppingcartid(rs.getInt(1));
                shoppingcart.setProductid(rs.getInt(2));
                shoppingcart.setUserid(rs.getInt(3));
                shoppingcart.setNumber(rs.getInt(4));

                shoppingcart.setCreatetime(String.valueOf(rs.getDate(5)));

                shoppingcart.setRemark(rs.getString(6));
                shoppingcart.setType(rs.getString("type"));
                shoppingcarts.add(shoppingcart);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return shoppingcarts;
    }

    @Override
    public Shoppingcart findShoppingcartById(int shoppingcartid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Shoppingcart shoppingcart = null;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from shoppingcart where shoppingcartid=" + shoppingcartid);
            while (rs.next()) {
                shoppingcart = new Shoppingcart();
                shoppingcart.setShoppingcartid(rs.getInt(1));
                shoppingcart.setProductid(rs.getInt(2));
                shoppingcart.setUserid(rs.getInt(3));
                shoppingcart.setNumber(rs.getInt(4));

                shoppingcart.setCreatetime(String.valueOf(rs.getDate(5)));
                shoppingcart.setType(rs.getString("type"));

                shoppingcart.setRemark(rs.getString(6));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return shoppingcart;
    }

    @Override
    public boolean addShoppingcart(Shoppingcart shoppingcart) {
        Connection conn = null;
        Statement stat = null;
        boolean result;
        try {
            conn = JDBCUtil.getConn();
            // 澹版槑sql璇彞
            String sql = "insert into shoppingcart(productid,userid,remark,number,createtime,type) "
                    + "values("
                    + shoppingcart.getProductid() + "," + shoppingcart.getUserid() + ",'"
                    + shoppingcart.getRemark() + "'," + shoppingcart.getNumber() + ",'"
                    + shoppingcart.getCreatetime() + "',+'" + shoppingcart.getType() + "')";

            //鑾峰彇鎵цsql璇彞鐨勫璞�
            stat = conn.createStatement();

            //鎵ц妫�储鏁版嵁搴�
            stat.executeUpdate(sql);
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, null);
        }
        return result;
    }


    @Override
    public boolean modifyShoppingcart(Shoppingcart shoppingcart) {
        Connection conn = null;
        PreparedStatement stat = null;
        boolean flag = false;
        try {
            //
            conn = JDBCUtil.getConn();

            // 澹版槑sql璇彞
            String sql = "update shoppingcart set shoppingcartid=?,productid=?,userid=?,remark=?,number=?,createtime=?,type=? where shoppingcartid=?";

            stat = conn.prepareStatement(sql);
            stat.setInt(1, shoppingcart.getShoppingcartid());
            stat.setInt(2, shoppingcart.getProductid());
            stat.setInt(3, shoppingcart.getUserid());
            stat.setString(4, shoppingcart.getRemark());
            stat.setInt(5, shoppingcart.getNumber());
            stat.setDate(6, Date.valueOf(shoppingcart.getCreatetime()));
            stat.setString(7, shoppingcart.getType());
            stat.setInt(8, shoppingcart.getUserid());
       
            stat.executeUpdate(sql);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, null);
        }
        return flag;
    }

    @Override
    public int checkoutShoppingCart(int productid, int userid, String type) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int id = 0;
        connection = JDBCUtil.getConn();
        String sql = "SELECT shoppingcartid FROM shoppingcart WHERE productid = ? and userid = ? and type = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, productid);
            statement.setInt(2, userid);
            statement.setString(3, type);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, resultSet);
        }
        return id;
    }

    @Override
    public boolean updateShoppingCartNumber(int shoppingcartid, int flag) {
        Connection conn = null;
        PreparedStatement statem = null;
        conn = JDBCUtil.getConn();
        boolean result;
        String sql = null;
        if (flag == 1) {
            sql = "UPDATE shoppingcart SET number = number +1 WHERE shoppingcartid = ?";
        } else if (flag == 0) {
            sql = "UPDATE shoppingcart SET number = number -1 WHERE shoppingcartid = ?";
        }
        try {
            statem = conn.prepareStatement(sql);
            statem.setInt(1, shoppingcartid);
            statem.executeUpdate();
            result = true;
        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, statem, null);
        }
        return result;
    }

    @Override
    public List<Shoppingcartlist> queryAllShoppingCartByUserId(int userid) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Shoppingcartlist> list = new ArrayList<Shoppingcartlist>();
        connection = JDBCUtil.getConn();
        String sql = "SELECT shoppingcart.shoppingcartid,shoppingcart.productid,product.picture,product.price,product.discount," +
                "product.remark,shoppingcart.number,shoppingcart.type FROM shoppingcart,product " +
                "where shoppingcart.productid = product.productid and shoppingcart.userid = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userid);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Shoppingcartlist shoppingcartlist = new Shoppingcartlist();
                shoppingcartlist.setShoppingcartid(resultSet.getInt("shoppingcartid"));
                shoppingcartlist.setProductid(resultSet.getInt("productid"));
                shoppingcartlist.setPicture(resultSet.getString("picture"));
                shoppingcartlist.setPrice(resultSet.getInt("price"));
                shoppingcartlist.setDiscount(resultSet.getString("discount"));
                shoppingcartlist.setRemark(resultSet.getString("remark"));
                shoppingcartlist.setNumber(resultSet.getInt("number"));
                shoppingcartlist.setType(resultSet.getString("type"));
                list.add(shoppingcartlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public boolean deleteAllByUserId(int userid) {
        Connection connection = null;
        Statement statement = null;
        boolean result;
        connection = JDBCUtil.getConn();
        String sql = "DELETE FROM shoppingcart WHERE userid = " + userid;
        try {
            statement = connection.createStatement();
            statement.execute(sql);
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
    public List<Shoppingcart> findShoppingcart(Date start, Date end) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Shoppingcart> shoppingcarts = new ArrayList<Shoppingcart>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from shoppingcart where createtime>=" + start + " and createtime=<" + end);
            while (rs.next()) {
                Shoppingcart shoppingcart = new Shoppingcart();
                shoppingcart.setShoppingcartid(rs.getInt("shoppingcartid"));
                shoppingcart.setProductid(rs.getInt("productid"));
                shoppingcart.setUserid(rs.getInt("userid"));
                shoppingcart.setRemark(rs.getString("remark"));
                shoppingcart.setNumber(rs.getInt("number"));
                shoppingcart.setCreatetime(String.valueOf(rs.getDate("createtime")));
                shoppingcarts.add(shoppingcart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return shoppingcarts;
    }

    @Override
    public boolean deleteShoppingcart(int shoppingcartid) {
        Connection conn = null;
        Statement stat = null;
        boolean result;
        try {
            conn = JDBCUtil.getConn();

            stat = conn.createStatement();

            stat.executeUpdate("delete from shoppingcart where shoppingcartid=" + shoppingcartid);
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, null);
        }
        return result;
    }


}
