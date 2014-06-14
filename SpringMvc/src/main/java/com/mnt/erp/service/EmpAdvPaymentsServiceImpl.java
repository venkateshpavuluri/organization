package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.EmpAdvPaymentsDao;

public class EmpAdvPaymentsServiceImpl implements EmpAdvPaymentsService {
	String message;
	EmpAdvPaymentsDao empadvpaymentsdao;
	List<Object[]> objects;
	
	
	public EmpAdvPaymentsDao getEmpadvpaymentsdao() {
		return empadvpaymentsdao;
	}

	public void setEmpadvpaymentsdao(EmpAdvPaymentsDao empadvpaymentsdao) {
		this.empadvpaymentsdao = empadvpaymentsdao;
	}

	@Override
	public String saveEmpAdvPayments(Object object, String userId,
			String userName) {
		try {
			message = empadvpaymentsdao.saveEmpAdvPayments(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return message;
	}

	@Override
	public List<Object[]> searchEmpAdvPaymentsWithId(int id) {
		try {
			objects = empadvpaymentsdao.searchEmpAdvPaymentsWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchEmpAdvPayments() {
		try {
			objects = empadvpaymentsdao.searchEmpAdvPayments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectempadvpaymentIds() {
		try {
			objects = empadvpaymentsdao.selectempadvpaymentIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectEmpadv() {
		try {
			objects = empadvpaymentsdao.selectEmpadv();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public String updateEmpAdvPayments(Object object) {
		try {
			message = empadvpaymentsdao.updateEmpAdvPayments(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteEmpAdvPayments(int id) {
		try {
			message = empadvpaymentsdao.deleteEmpAdvPayments(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Long getEmpAdvPaymentsCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getEmpAdvPaymentsCountedit(String name, int eapId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchEmpadvpay(String label, String operator,
			String searchName) {
		try {
			objects = empadvpaymentsdao.basicSearchEmpadvpay(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
