package com.mnt.erp.service;

import java.util.List;

public interface ShopService {

	
	public Long updateCheckShop(String shop,int shopId);

	public Long checkShopCout(String shop);
	
	public String saveShopDetails(Object object);

	public List<Object[]> searchShop();

	public List<Object[]> searchShopWithId(int id);

	public String updateShop(Object object);

	public String deleteShop(int id);
	
	public List<Object[]> selectShop();
	
	public List<Object[]> basicSearchShop(String label,String operator,String searchName);
}
