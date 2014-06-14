/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.UomDao;

/**
 * This is Uom Service interface Implementation.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class UomServiceImpl implements UomService {
	public UomDao udao;
	List<Object[]> objects=null; 

	public List<Object[]> selectUomDetails() {
		List<Object[]> list = null;
		try {
			list = udao.selectUomDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public UomDao getUdao() {
		return udao;
	}

	public void setUdao(UomDao udao) {
		this.udao = udao;
	}

	String msg;

	@Override
	public String saveUomDetails(Object object,String userId,String userName) {
		try {
			msg = udao.saveUomDetails(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public List<Object[]> searchUom(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = udao.searchUom(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> editUomWithId(int id) {
		List<Object[]> list = null;
		try {
			list = udao.editUomWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateUom(Object object) {
		try {
			msg = udao.updateUom(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteUom(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = udao.uomDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public int uomDuplicate(String uomCheck, String uomCodeCheck) {
		// TODO Auto-generated method stub
		String msg = null;
		int list1 = 0;
		try {
			list1 = udao.uomDuplicate(uomCheck, uomCodeCheck);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	public int uomEditDuplicate(String uom, String uomCode, int id) {

		// TODO Auto-generated method stub
		String msg = null;
		int list1 = 0;
		try {
			list1 = udao.uomEditDuplicate(uom, uomCode, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	public List<Object[]> uomIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = udao.uomIdGet();
		return idsList;

	}

	@Override
	public List<Object[]> basicSearchUOM(String label, String operator,
			String searchName) {
		try {
			objects = udao.basicSearchUOM(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

}
