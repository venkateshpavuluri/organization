package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.AssetGroupDao;

/**
 * @author ybusireddy
 * @version 20-09-2013
 */
public class AssetGroupServiceImpl implements AssetGroupService {
	List<Object[]> list = null;
	AssetGroupDao dao;

	public AssetGroupDao getDao() {
		return dao;
	}

	public void setDao(AssetGroupDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveAssetGroupDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String asg = null;
		try {
			asg = dao.saveAssetGroupDetails(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return asg;
	}

	@Override
	public List<Object[]> searchAssetGroup() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchAssetGroup();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchAssetGroupWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchAssetGroupWithId(id);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	@Override
	public String updateAssetGroup(Object object) {
		// TODO Auto-generated method stub
		String s = null;
		try {
			s = dao.updateAssetGroup(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String deleteAssetGroup(int id) {
		// TODO Auto-generated method stub
		String is = null;
		try {
			is = dao.deleteAssetGroup(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectAssetGroup() {
		// TODO Auto-generated method stub

		try {
			list = dao.selectAssetGroup();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkAssetGroupType(String type) {
		// TODO Auto-generated method stub
		int cag = 0;
		try {
			cag = dao.checkAssetGroupType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cag;
	}

	public int updateCheckAssetGroupType(String type, int typeId) {
		int cag = 0;
		try {
			cag = dao.updateCheckAssetGroupType(type, typeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cag;
	}

	public List<Object[]> basicSearchAssetGroup(String label, String operator,
			String searchName) {
		try {
			list = dao.basicSearchAssetGroup(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

}
