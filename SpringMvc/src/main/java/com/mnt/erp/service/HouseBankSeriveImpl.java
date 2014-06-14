package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.HouseBankBean;
import com.mnt.erp.dao.AccountGroupDao;
import com.mnt.erp.dao.HouseBankDao;

public class HouseBankSeriveImpl implements HouseBankService {
	String message;
	HouseBankDao hbdao;
	List<Object[]> objects;
	List<HouseBankBean> hblist;
	public HouseBankDao getHbdao() {
		return hbdao;
	}

	public void setHbdao(HouseBankDao hbdao) {
		this.hbdao = hbdao;
	}

	@Override
	public String saveHouseBankService(Object object,String userId,String userName) {
		try {
			message = hbdao.saveHouseBank(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return message;
	}

	@Override
	public List<Object[]> searchHouseBankService() {
		try {
			objects = hbdao.searchHouseBank();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectHouseBankIdsService() {
		try {
			objects = hbdao.selectHouseBankIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectOrgidService() {
          try{
			
			objects=hbdao.selectOrgid();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectCountryidService() {
            try{
			
			objects=hbdao.selectCountryid();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateHouseBankService(Object object) {
		try {
			message = hbdao.updateHouseBank(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteHouseBankService(int id) {
		try {
			message = hbdao.deleteHouseBank(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Long getHouseBankCountService(String name) {
		Long id = 0L;
		try {
			id = hbdao.getHouseBankCount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	
	}

	@Override
	public Long getHouseBankCounteditService(String name, int hbid) {
		Long id = 0L;
		try {
			id = hbdao.getHouseBankCountedit(name, hbid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> basicSearchHouseBankService(String label,
			String operator, String searchName) {
		try {
			objects = hbdao.basicSearchHouseBank(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> searchHouseBankServiceWithId(int id) {
try{
			
			objects=hbdao.searchHouseBankWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<HouseBankBean> EditHousebankservice(int iid) {
		try{
			hblist=hbdao.Edithb(iid);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return hblist;
	}

}
