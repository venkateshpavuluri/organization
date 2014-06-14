package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.AccountGroupDao;
import com.mnt.erp.dao.VoucherTypeDao;

public class VoucherTypeServiceImpl implements VoucherTypeService {
	String message;
	VoucherTypeDao vtypedao;
	List<Object[]> objects;
	
	

	public VoucherTypeDao getVtypedao() {
		return vtypedao;
	}

	public void setVtypedao(VoucherTypeDao vtypedao) {
		this.vtypedao = vtypedao;
	}

	@Override
	public String saveVoucherTypeservice(Object object,String userId,String userName) {
		try {
			message= vtypedao.saveVoucherType(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return message;
	}

	@Override
	public List<Object[]> searchVoucherTypeWithId(int id) {
		try {
			objects = vtypedao.searchVoucherTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchVoucherType() {

		try {
			objects = vtypedao.searchVoucherType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectVoucherTypeids() {
		try {
			objects = vtypedao.selectVoucherTypeIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public String updateVoucherType(Object object) {
		try {
			message = vtypedao.updateVoucherType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteVoucherType(int id) {
		// TODO Auto-generated method stub
				try {
					message = vtypedao.deleteVoucherType(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return message;
	}

	@Override
	public Long getVoucherTypeCount(String name) {
		Long id = 0L;
		try {
			id = vtypedao.getVoucherTypeCount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getVoucherTypeCountedit(String name, int vtid) {
		Long id = 0L;
		try {
			id = vtypedao.getVoucherTypeCountedit(name, vtid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> basicSearchVoucherType(String label, String operator,
			String searchName) {
		try {
			objects = vtypedao.basicSearchVoucherType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

}
