package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.WareHouseBinDao;

public class WareHouseBinServiceImpl implements Warehousebinservice {
	String message;
	WareHouseBinDao whbdao;
	List<Object[]> objects;

	public WareHouseBinDao getWhbdao() {
		return whbdao;
	}

	public void setWhbdao(WareHouseBinDao whbdao) {
		this.whbdao = whbdao;
	}

	@Override
	public String saveWareHouseBin(Object object, String userId, String userName) {
		try {
			message = whbdao.saveWareHouseBin(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<Object[]> searchWareHouseBinWithId(int id) {
		try {
			objects = whbdao.searchWareHouseBinWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchWareHouseBin() {
		try {
			objects = whbdao.searchWareHouseBin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectWareHouseBinIds() {
		try {
			objects = whbdao.selectWareHouseBinIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectstoragetype() {
		try {
			objects = whbdao.selectstoragetype();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return objects;
	}

	@Override
	public List<Object[]> selectWareHouseBinTypeIds() {
		try {
			objects = whbdao.selectWareHouseBinTypeIds();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return objects;
	}

	@Override
	public List<Object[]> selectStorageSectionIds() {
		try {
			objects =whbdao.selectStorageSectionIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateWareHouseBin(Object object) {
		try {
			message = whbdao.updateWareHouseBin(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteWareHouseBin(int id) {
		try {
			message = whbdao.deleteWareHouseBin(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Long getWareHouseBinCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long geWareHouseBinedit(String name, int accountgroupid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchWareHouseBin(String label,
			String operator, String searchName) {
		try {
			objects = whbdao.basicSearchWareHouseBin(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
