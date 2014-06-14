package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.GoodsReceiptTypeDao;

public class GoodsReceiptTypeServiceImpl implements GoodsReceiptTypeService {

	GoodsReceiptTypeDao dao;
	List<Object[]> list = null;

	public GoodsReceiptTypeDao getDao() {
		return dao;
	}

	public void setDao(GoodsReceiptTypeDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveGoodsReceiptTypeDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String gr = null;
		try {
			gr = dao.saveGoodsReceiptTypeDetails(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gr;
	}

	@Override
	public List<Object[]> searchGoodsReceiptType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchGoodsReceiptType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchGoodsReceiptTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchGoodsReceiptTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateGoodsReceiptType(Object object) {
		// TODO Auto-generated method stub
		String gr = null;
		try {
			gr = dao.updateGoodsReceiptType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gr;
	}

	@Override
	public String deleteGoodsReceiptType(int id) {
		// TODO Auto-generated method stub
		String gr = null;
		try {
			gr = dao.deleteGoodsReceiptType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gr;
	}

	@Override
	public List<Object[]> selectGoodsReceiptType() {
		// TODO Auto-generated method stub
		
		try {
			list = dao.selectGoodsReceiptType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkGoodsReceiptType(String type) {
		// TODO Auto-generated method stub
		int gr = 0;
		try {
			gr = dao.checkGoodsReceiptType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gr;
	}

	public int updateCheckGoodsReceiptType(String type, int gdtId) {
		int gr = 0;
		try {
			gr = dao.updateCheckGoodsReceiptType(type, gdtId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gr;
	}
	public List<Object[]> basicSearchGoodsReceipt(String label, String operator,
			String searchName){
		try {
			list = dao.basicSearchGoodsReceipt(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	public List<Object[]> goodsReceiptIdsGet(){
		List<Object[]> gr =null;
		try {
			gr = dao.goodsReceiptIdsGet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gr;
	}

}
