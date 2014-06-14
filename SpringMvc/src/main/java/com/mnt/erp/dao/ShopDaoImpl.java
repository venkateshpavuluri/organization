package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Shop;

public class ShopDaoImpl extends HibernateDaoSupport implements ShopDao{
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckShop(String shop,int shopId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from Shop at where  at.shopName ='"
					+ shop + "' and at.shop_Id!='" + shopId + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public Long checkShopCout(String shop) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from Shop at where  at.shopName='"
					+ shop + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public String saveShopDetails(Object object) {
		try {
			Shop shopBean = (Shop) object;
			Serializable id=getHibernateTemplate().save(shopBean);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchShop() {

		try {
			String hql = "select s.shop_Id,s.shopCode,s.shopName,s.description,s.plant_Id from Shop s order by s.shopCode";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchShopWithId(int id) {
		try {
			String hql = "select s.shop_Id,s.shopCode,s.shopName,s.description,s.plant_Id from Shop s where s.shop_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateShop(Object object) {
		try {
			Shop updateShop = (Shop) object;
			getHibernateTemplate().update(updateShop);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	public String deleteShop(int id) {

		try {
			Shop shop=new Shop();
			shop.setShop_Id(id);
			
			getHibernateTemplate().delete(shop);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> selectShop() {
		String sql = null;
		try {
			sql = "select s.shop_Id,s.shopCode,s.shopName,s.description,s.plant_Id from Shop s";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchShop(String label, String operator,
			String searchName) {
		try {

			String hql = "select s.shop_Id,s.shopCode,s.shopName,s.description,s.plant_Id from Shop s where s."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}


}
