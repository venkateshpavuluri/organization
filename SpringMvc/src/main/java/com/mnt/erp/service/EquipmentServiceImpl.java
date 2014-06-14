/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.EquipmentDao;

/**
 * @author madhav
 *
 */
public class EquipmentServiceImpl implements EquipmentService {
	
	//Instance Variables
		List<Object[]> objects = null;
		String sus = null;

		//Dao decleration with getters and setters methods
		EquipmentDao equipmentDao;

	
	/**
		 * @return the equipmentDao
		 */
		public EquipmentDao getEquipmentDao() {
			return equipmentDao;
		}

		/**
		 * @param equipmentDao the equipmentDao to set
		 */
		public void setEquipmentDao(EquipmentDao equipmentDao) {
			this.equipmentDao = equipmentDao;
		}

	//Method for CRUD Operations
	@Override
	public List<Object[]> selectEquipment() {
		return null;
	}

	@Override
	public int updateCheckEquipment(String equipmentName, int equipmentId) {
		int l =equipmentDao.updateCheckEquipment(equipmentName, equipmentId);
		return l;
	}

	@Override
	public Long addCheckEquipment(String equipmentName) {
		Long l =equipmentDao.addCheckEquipment(equipmentName);
		return l;
	}

	@Override
	public String saveEquipment(Object object) {
		try {
			sus = equipmentDao.saveEquipment(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchEquipment() {
		try {
			objects =equipmentDao.searchEquipment();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchEquipmentWithId(int id) {
		try {
			objects = equipmentDao.searchEquipmentWithId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateEquipment(Object object) {
		try {
			sus = equipmentDao.updateEquipment(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteEquipment(int id) {
		try {
			sus = equipmentDao.deleteEquipment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> selectEquipmentCategory() {
		try {
			objects = equipmentDao.selectEquipmentCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> basicSearchEquipment(String label, String operator,
			String searchName) {
		try {
			objects = equipmentDao.basicSearchEquipment(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String saveEquipmentDocuments(Object object) {
		
		try {
			sus = equipmentDao.saveEquipmentDocuments(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

}
