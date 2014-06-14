/**
 * @Copyright MNTSOFT

 * 
 */

package com.mnt.erp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mnt.erp.bean.StockCategory;
import com.mnt.erp.dao.StockCategoryDao;

/**
 * @author pvenkateswarlu
 * @version 1.0 28-10-2013
 */
public class StockCategoryServiceImpl implements StockCategoryService {
StockCategoryDao stockCategoryDao;
List<StockCategory> list;
List<Object[]> objects;
Iterator<Object[]> iterator;
Object[] stockCategory;
StockCategory category;
List<StockCategory> categories;
	public StockCategoryDao getStockCategoryDao() {
	return stockCategoryDao;
}

public void setStockCategoryDao(StockCategoryDao stockCategoryDao) {
	this.stockCategoryDao = stockCategoryDao;
}
String msg;

	@Override
	public String saveStockCategory(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		try
		{
			msg=stockCategoryDao.saveStockCategory(object,userId,userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getStockCategoryDuplicateCount(String name) {
		// TODO Auto-generated method stub
		Long count=0l;
		try
		{
			count=stockCategoryDao.getStockCategoryDuplicateCount(name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<StockCategory> searchStockCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		List<StockCategory> categories=null;
		try
		{
			categories=new ArrayList<StockCategory>();
			list=stockCategoryDao.searchStockCategoryWithId(id);
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				stockCategory=(Object[])iterator.next();
				category=new StockCategory();
				category.setStockCategoryId((Integer)stockCategory[0]);
				category.setStockCategoryName((String)stockCategory[1]);
				categories.add(category);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<StockCategory> searchStockCategory() {
		// TODO Auto-generated method stub
		
		try
		{
			objects=stockCategoryDao.searchStockCategory();
			categories=new ArrayList<StockCategory>();
			iterator=objects.iterator();
			while(iterator.hasNext())
			{
				stockCategory=(Object[])iterator.next();
				category=new StockCategory();
				category.setStockCategoryId((Integer)stockCategory[0]);
				category.setStockCategoryName((String)stockCategory[1]);
				categories.add(category);
						
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public List<Object[]> selectStockCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=stockCategoryDao.selectStockCategory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateStockCategory(Object object) {
		// TODO Auto-generated method stub
		try
		{
			msg=stockCategoryDao.updateStockCategory(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteStockCategory(int id) {
		// TODO Auto-generated method stub
		try
		{
			msg=stockCategoryDao.deleteStockCategory(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getStockCategoryCountedit(String name, int stockCategoryId) {
		// TODO Auto-generated method stub
		Long count=null;
		try
		{
			count=stockCategoryDao.getStockCategoryCountedit(name, stockCategoryId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<StockCategory> basicSearchStockCategory(String label,
			String operator, String searchName) {
		// TODO Auto-generated method stub
		
		try
		{
			list=new ArrayList<StockCategory>();
			objects=stockCategoryDao.basicSearchStockCategory(label, operator, searchName);
			iterator=objects.iterator();
			while(iterator.hasNext())
			{
				
				stockCategory=(Object[])iterator.next();
				category=new StockCategory();
				category.setStockCategoryId((Integer)stockCategory[0]);
				category.setStockCategoryName((String)stockCategory[1]);
			
				list.add(category);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
