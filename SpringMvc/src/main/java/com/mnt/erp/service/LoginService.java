package com.mnt.erp.service;

import java.util.List;

/**
 * @author pvenkateswarlu
 *
 */

public interface LoginService {
	public List<Object[]> getCredentials(String username,String password);

}
