package com.mnt.erp.service;

/*
 @author Srinivas
 @version 1.0   
 */
import java.util.List;

import com.mnt.erp.dao.AccountGroupDao;

public class AccountGroupServiceImpl implements AccountGroupService {
	String message;
	AccountGroupDao acdao;
	List<Object[]> objects;

	public AccountGroupDao getAcdao() {
		return acdao;
	}

	public void setAcdao(AccountGroupDao acdao) {
		this.acdao = acdao;
	}

	public String saveAccountGroupservice(Object object,String userId,String userName) {
		try {
			message = acdao.saveAccountGroups(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return message;
	}

	@Override
	public List<Object[]> searchAccountGroupsWithId(int id) {
		// TODO Auto-generated method stub
		try {
			objects = acdao.searchAccountGroupsWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchAccountGroups() {
		// TODO Auto-generated method stub

		try {
			objects = acdao.searchAccountGroups();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectAccountGroupids() {
		try {
			objects = acdao.selectAccountGroupIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public String updateAccountGroups(Object object) {
		// TODO Auto-generated method stub
		try {
			message = acdao.updateAccountGroups(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteAccountGroups(int id) {
		// TODO Auto-generated method stub
		try {
			message = acdao.deleteAccountGroups(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Long getAccountgroupCount(String name) {
		Long id = 0L;
		try {
			id = acdao.getAccountgroupCount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getAccountgroupCountedit(String name, int accountgroupid) {
		Long id = 0L;
		try {
			id = acdao.getAccountgroupCountedit(name, accountgroupid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public List<Object[]> basicSearchAccoutGroup(String label, String operator,
			String searchName) {
		try {
			objects = acdao.basicSearchAccoutGroup(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectcoa() {
		try{
objects=acdao.selectcoa();			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

}
