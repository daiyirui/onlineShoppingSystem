package com.jxust.dao;

import java.util.List;

import com.jxust.entity.*;
import com.jxust.entity.Browseproduct;

public interface BrowseproductManager {

	 
	 public Browseproduct findBrowseproductById(int browseproductid);
	
	 public Product findproductById(int browseproductid);
	 
     public List<Browseproduct>	 findAllBrowseproducts();
     
     public List<Browseproduct> findBrowseproductsBypopularity();

	
     public List<Browseproduct> findBrowseproductsByhotsale();
	
	
     public List<Browseproduct> findBrowseproductsBykey(String keywords);
     
     public List<Browseproduct> findBrowseproductsByclass(int classid);

    /**
     *  App
     * @return
     */
    public List<BrowseProductsList> findBrowseByPopularity();

    /**
     * App
     * @return
     */
    public List<BrowseProductsList> findBrowseByHotsale();
}
