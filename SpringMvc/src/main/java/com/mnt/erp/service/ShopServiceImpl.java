package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ShopDao;

public class ShopServiceImpl implements ShopService {

	List<Object[]> objects = null;
	String sus=null;
	private ShopDao shopDao;
	
	

	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	public Long checkShopCout(String shop) {
		Long l = shopDao.checkShopCout(shop);
		return l;
	}
	public Long updateCheckShop(String shop,int shopId) {
		Long l = shopDao.updateCheckShop(shop, shopId);
		return l;
	}
	
	public String saveShopDetails(Object object) {
		try {
			sus = shopDao.saveShopDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchShop() {
		
		try {
			objects = shopDao.searchShop();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchShopWithId(int id) {
		List<Object[]> list = null;
		try {
			list = shopDao.searchShopWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateShop(Object object) {
		try {
			sus = shopDao.updateShop(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteShop(int id) {
		try {
			sus = shopDao.deleteShop(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectShop() {
		
		try {
			objects = shopDao.selectShop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchShop(String label,String operator,String searchName){
		try {
			objects = shopDao.basicSearchShop(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
