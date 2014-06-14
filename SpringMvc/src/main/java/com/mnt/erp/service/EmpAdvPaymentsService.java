package com.mnt.erp.service;

import java.util.List;

public interface EmpAdvPaymentsService {
	public String saveEmpAdvPayments(Object object,String userId,String userName);

	public List<Object[]> searchEmpAdvPaymentsWithId(int id);

	public List<Object[]> searchEmpAdvPayments();

	public List<Object[]> selectempadvpaymentIds();
	public List<Object[]>selectEmpadv();

	public String updateEmpAdvPayments(Object object);

	public String deleteEmpAdvPayments(int id);

	public Long getEmpAdvPaymentsCount(String name);

	public Long getEmpAdvPaymentsCountedit(String name, int eapId);

	public List<Object[]> basicSearchEmpadvpay(String label, String operator,
			String searchName);
}
