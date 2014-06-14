package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.EmpAdvReceiptDao;

public class EmpAdvReceiptsServiceImpl implements EmpAdvReceiptsService {
	String message;
	EmpAdvReceiptDao empadvreceiptsdao;
	List<Object[]> objects;
	
	
	public EmpAdvReceiptDao getEmpadvreceiptsdao() {
		return empadvreceiptsdao;
	}

	public void setEmpadvreceiptsdao(EmpAdvReceiptDao empadvreceiptsdao) {
		this.empadvreceiptsdao = empadvreceiptsdao;
	}

	@Override
	public String saveEmpAdvReceipts(Object object, String userId,
			String userName) {
		try {
			message = empadvreceiptsdao.saveEmpAdvReceipts(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return message;
	}

	@Override
	public List<Object[]> searchEmpAdvReceiptsWithId(int id) {
		try {
			objects = empadvreceiptsdao.searchEmpAdvReceiptsWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchEmpAdvReceipts() {
		try {
			objects = empadvreceiptsdao.searchEmpAdvReceipts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectempadvreceiptsIds() {
		try {
			objects = empadvreceiptsdao.selectempadvreceiptIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectEmpadv() {
		try {
			objects = empadvreceiptsdao.selectEmpadv();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public String updateEmpAdvReceipts(Object object) {
		try {
			message = empadvreceiptsdao.updateEmpAdvReceipts(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteEmpAdvReceipts(int id) {
		try {
			message = empadvreceiptsdao.deleteEmpAdvReceipts(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Long getEmpAdvReceiptsCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getEmpAdvReceiptsCountedit(String name, int eapId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchEmpadvrec(String label, String operator,
			String searchName) {
		try {
			objects = empadvreceiptsdao.basicSearchEmpadvrec(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
