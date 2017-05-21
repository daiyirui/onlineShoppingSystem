package com.jxust.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.BrowseproductManager;
import com.jxust.entity.Browseproduct;
import com.jxust.entity.*;

public class BrowseproductManagerImpl implements BrowseproductManager {

    @Override
    public Browseproduct findBrowseproductById(int browseproductid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Browseproduct browseproduct = null;
        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            String sql = "select * from browseproduct where browseproductid=" + browseproductid;
            System.out.println(sql);
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                browseproduct = new Browseproduct();
                browseproduct.setBrowseproductid(rs.getInt(1));
                browseproduct.setBrowseproductname(rs.getString(2));
                browseproduct.setProductid(rs.getInt(3));
                browseproduct.setClassid(rs.getInt(4));
                browseproduct.setPopularity(rs.getInt(5));
                browseproduct.setHotsale(rs.getInt(6));
                browseproduct.setKeywords(rs.getString(7));
                browseproduct.setRemark(rs.getString(8));
                browseproduct.setPicture(rs.getString(9));
                browseproduct.setSize(rs.getString(10));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return browseproduct;
    }

    @Override
    public Product findproductById(int browseproductid) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Product product = null;
        conn = JDBCUtil.getConn();
        Browseproduct browseproduct = findBrowseproductById(browseproductid);
        try {
            stat = conn.createStatement();
            String sql = "select * from product where productid=" + browseproduct.getProductid();
            System.out.println(sql);
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
    public List<Browseproduct> findAllBrowseproducts() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Browseproduct> browseproducts = new ArrayList<Browseproduct>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();

            rs = stat.executeQuery("select * from browseproduct");
            while (rs.next()) {
                Browseproduct browseproduct = new Browseproduct();

                browseproduct.setBrowseproductid(rs.getInt(1));
                browseproduct.setBrowseproductname(rs.getString(2));
                browseproduct.setProductid(rs.getInt(3));
                browseproduct.setClassid(rs.getInt(4));
                browseproduct.setPopularity(rs.getInt(5));
                browseproduct.setHotsale(rs.getInt(6));
                browseproduct.setKeywords(rs.getString(7));
                browseproduct.setRemark(rs.getString(8));
                browseproduct.setPicture(rs.getString(9));
                browseproduct.setSize(rs.getString(10));
                browseproducts.add(browseproduct);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return browseproducts;
    }

    @Override
    public List<Browseproduct> findBrowseproductsBypopularity() {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Browseproduct> browseproducts = new ArrayList<Browseproduct>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from browseproduct ORDER by popularity desc ");
            while (rs.next()) {
                Browseproduct browseproduct = new Browseproduct();

                browseproduct.setBrowseproductid(rs.getInt(1));
                browseproduct.setBrowseproductname(rs.getString(2));
                browseproduct.setProductid(rs.getInt(3));
                browseproduct.setClassid(rs.getInt(4));
                browseproduct.setPopularity(rs.getInt(5));
                browseproduct.setHotsale(rs.getInt(6));
                browseproduct.setKeywords(rs.getString(7));
                browseproduct.setRemark(rs.getString(8));
                browseproduct.setPicture(rs.getString(9));
                browseproduct.setSize(rs.getString(10));
                browseproducts.add(browseproduct);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return browseproducts;

    }

    @Override
    public List<Browseproduct> findBrowseproductsByhotsale() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Browseproduct> browseproducts = new ArrayList<Browseproduct>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from browseproduct ORDER by hotsale desc ");
            while (rs.next()) {
                Browseproduct browseproduct = new Browseproduct();

                browseproduct.setBrowseproductid(rs.getInt(1));
                browseproduct.setBrowseproductname(rs.getString(2));
                browseproduct.setProductid(rs.getInt(3));
                browseproduct.setClassid(rs.getInt(4));
                browseproduct.setPopularity(rs.getInt(5));
                browseproduct.setHotsale(rs.getInt(6));
                browseproduct.setKeywords(rs.getString(7));
                browseproduct.setRemark(rs.getString(8));
                browseproduct.setPicture(rs.getString(9));
                browseproduct.setSize(rs.getString(10));
                browseproducts.add(browseproduct);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return browseproducts;
    }

    @Override
    public List<Browseproduct> findBrowseproductsBykey(String keyword) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Browseproduct> browseproducts = new ArrayList<Browseproduct>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            String sql = "SELECT * FROM browseproduct WHERE keywords LIKE '%" + keyword + "%'";
            rs = stat.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                Browseproduct browseproduct = new Browseproduct();
                browseproduct.setBrowseproductid(rs.getInt(1));
                browseproduct.setBrowseproductname(rs.getString(2));
                browseproduct.setProductid(rs.getInt(3));
                browseproduct.setClassid(rs.getInt(4));
                browseproduct.setPopularity(rs.getInt(5));
                browseproduct.setHotsale(rs.getInt(6));
                browseproduct.setKeywords(rs.getString(7));
                browseproduct.setRemark(rs.getString(8));
                browseproduct.setPicture(rs.getString(9));
                browseproduct.setSize(rs.getString(10));
                browseproducts.add(browseproduct);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }


        return browseproducts;
    }

    @Override
    public List<Browseproduct> findBrowseproductsByclass(int classid) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Browseproduct> browseproducts = new ArrayList<Browseproduct>();

        conn = JDBCUtil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from browseproduct where classid=" + classid);
            while (rs.next()) {
                Browseproduct browseproduct = new Browseproduct();

                browseproduct.setBrowseproductid(rs.getInt(1));
                browseproduct.setBrowseproductname(rs.getString(2));
                browseproduct.setProductid(rs.getInt(3));
                browseproduct.setClassid(rs.getInt(4));
                browseproduct.setPopularity(rs.getInt(5));
                browseproduct.setHotsale(rs.getInt(6));
                browseproduct.setKeywords(rs.getString(7));
                browseproduct.setRemark(rs.getString(8));
                browseproduct.setPicture(rs.getString(9));
                browseproduct.setSize(rs.getString(10));
                browseproducts.add(browseproduct);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }

        return browseproducts;
    }

    @Override
    public List<BrowseProductsList> findBrowseByPopularity() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<BrowseProductsList> lists = new ArrayList<BrowseProductsList>();
        conn = JDBCUtil.getConn();
        String sql = "select A.browseproductname,A.productid,A.popularity,A.hotsale,B.price,B.discount,B.picture " +
                "from browseproduct as A,product as B " +
                "where A.productid = B.productid order by A.popularity DESC";
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                BrowseProductsList list = new BrowseProductsList();
                list.setProductName(rs.getString(1));
                list.setProductid(rs.getInt(2));
                list.setPopularity(rs.getInt(3));
                list.setHotsale(rs.getInt(4));
                list.setPrice(rs.getInt(5));
                list.setDiscount(rs.getString(6));
                list.setPicture(rs.getString(7));
                lists.add(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }
        return lists;
    }

    @Override
    public List<BrowseProductsList> findBrowseByHotsale() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<BrowseProductsList> lists = new ArrayList<BrowseProductsList>();
        conn = JDBCUtil.getConn();
        String sql = "select A.browseproductname,A.productid,A.popularity,A.hotsale,B.price,B.discount,B.picture " +
                "from browseproduct as A,product as B " +
                "where A.productid = B.productid order by A.hotsale DESC";
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                BrowseProductsList list = new BrowseProductsList();
                list.setProductName(rs.getString(1));
                list.setProductid(rs.getInt(2));
                list.setPopularity(rs.getInt(3));
                list.setHotsale(rs.getInt(4));
                list.setPrice(rs.getInt(5));
                list.setDiscount(rs.getString(6));
                list.setPicture(rs.getString(7));
                lists.add(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(conn, stat, rs);
        }
        return lists;
    }

}
