package com.mnt.erp.dao;

import java.util.List;

public interface EmpAdvReceiptDao {
	public String saveEmpAdvReceipts(Object object,String userId,String userName);

	public List<Object[]> searchEmpAdvReceiptsWithId(int id);

	public List<Object[]> searchEmpAdvReceipts();

	public List<Object[]> selectempadvreceiptIds();
	public List<Object[]>selectEmpadv();

	public String updateEmpAdvReceipts(Object object);

	public String deleteEmpAdvReceipts(int id);

	public Long getEmpAdvReceiptsCount(String name);

	public Long getEmpAdvReceiptsCountedit(String name, int eapId);

	public List<Object[]> basicSearchEmpadvrec(String label, String operator,
			String searchName);
}
