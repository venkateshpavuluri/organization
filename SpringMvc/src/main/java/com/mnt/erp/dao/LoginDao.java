package com.mnt.erp.dao;
/**
 * @author pvenkateswarlu
 *
 */
import java.util.List;

public interface LoginDao {
public List<Object[]> getCredentials(String username,String password);
}
