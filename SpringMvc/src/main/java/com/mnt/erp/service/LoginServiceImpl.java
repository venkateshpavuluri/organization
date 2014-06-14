package com.mnt.erp.service;

import java.io.Serializable;
import java.util.List;

import com.mnt.erp.dao.LoginDaoImpl;

/**
 * @author pvenkateswarlu
 *
 */

public class LoginServiceImpl implements LoginService,Serializable{
private com.mnt.erp.dao.LoginDaoImpl daoImpl;
	public LoginDaoImpl getDaoImpl() {
	return daoImpl;
}
public void setDaoImpl(LoginDaoImpl daoImpl) {
	this.daoImpl = daoImpl;
}
	@Override
	public List<Object[]> getCredentials(String username,String password) {
		List<Object[]> list=daoImpl.getCredentials(username,password);
		return list;
	}
	//@Override
	public List<Object[]> getDetails(String username) {
		List<Object[]> list=daoImpl.getDetails(username);
		return list;
	}
}
