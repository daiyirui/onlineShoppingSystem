package com.jxust.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.ProductManager;
import com.jxust.entity.*;

public class ProductManagerImpl implements ProductManager {
    @Override
    public Product findProductById(int productid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Product product = null;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from Product where productid =" + productid);
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
                product.setTradenumber(Integer.parseInt(rs.getString(9)));
                product.setEvaluatenumber(Integer.parseInt(rs.getString(10)));

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
    public List<Product> findProductByName(String string) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM product WHERE key LIKE '%" + string + "%' ");
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
    public List<Product> findProductByClass(int classid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM product WHERE classid=" + classid);
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
    public List<Product> findProductByprice(Double low, Double high) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from product");
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
    public List<Product> findAllProduct() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Product> Products = new ArrayList<Product>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from product");
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
                product.setTradenumber(rs.getInt(9));
                product.setEvaluatenumber(rs.getInt(10));
                Products.add(product);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return Products;

    }

    @Override
    public List<Product> findHostByTradeNumber() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from product ORDER BY tradenumber desc limit 4");
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
	public List<Product> findHostBydiscount(String discount) {
		  Connection conn = null;
	        Statement stat = null;
	        ResultSet rs = null;
	        List<Product> Products = new ArrayList<Product>();

	        conn = JDBCUtil.getConn();
	        try {
	            stat = conn.createStatement();
	            rs = stat.executeQuery("select * from product where discount='"+discount+"'");
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
	                product.setTradenumber(rs.getInt(9));
	                product.setEvaluatenumber(rs.getInt(10));
	                Products.add(product);
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            JDBCUtil.closeDB(conn, stat, rs);
	        }

	        return Products;
	}


}
