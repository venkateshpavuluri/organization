/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.dao.StorageLocationDao;

/**
 * @author pvenkateswarlu
 * @version 1.0 23-09-2013
 */
public class StorageLocationServiceImpl implements StorageLocationService {
	String msg;
	StorageLocationDao dao;
	List<Object[]> list;
	List<StorageLocation> stlist;
	Iterator<Object[]> iterator;
	Object[] objects;
	StorageLocation storageLocation;

	/**
	 * @return the dao
	 */
	public StorageLocationDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(StorageLocationDao dao) {
		this.dao = dao;

	}

	@Override
	public String saveStoragLocation(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		try {
			msg = dao.saveStoragLocation(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<StorageLocation> searchStorageLocation() {
		// TODO Auto-generated method stub
		List<StorageLocation> locations = null;
		CountrysList countrysList = null;
		Plant plant = null;
		try {
			list = dao.searchStorageLocation();
			locations = new ArrayList<StorageLocation>();
			iterator = list.iterator();
			while (iterator.hasNext()) // select s.storageLocationId
										// ,s.storageLocation,s.add1,s.add2,s.add3,s.city,s.state,s.phone,s.fax,s.mobile,s.zip,s.plants,s.countrysList
										// from StorageLocation s where
										// p.plantId";
			{
				objects = (Object[]) iterator.next();
				storageLocation = new StorageLocation();
				storageLocation.setStorageLocationId((Integer) objects[0]);
				storageLocation.setStorageLocation((String) objects[1]);
				storageLocation.setAdd1((String) objects[2]);
				storageLocation.setAdd2((String) objects[3]);
				storageLocation.setAdd3((String) objects[4]);
				storageLocation.setCity((String) objects[5]);
				countrysList = (CountrysList) objects[12];
				storageLocation.setState((String) objects[6]);
				storageLocation.setPhone((String) objects[7]);
				storageLocation.setFax((String) objects[8]);
				storageLocation.setMobile((String) objects[9]);
				storageLocation.setZip((String) objects[10]);
				storageLocation.setCountry(String.valueOf(countrysList.getCountryId()));
				storageLocation.setCountryName(countrysList.getCountryName());
				plant = (Plant) objects[11];
				storageLocation.setPlantId(String.valueOf(plant.getPlantId()));
				storageLocation.setPlantName(plant.getPlantName());
				locations.add(storageLocation);
				// storageLocation
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return locations;
	}

	@Override
	public List<StorageLocation> searchStorageWithId(int id) {
		// TODO Auto-generated method stub
		List<StorageLocation> locations = null;
		List<StorageLocation> list = null;
		Iterator<StorageLocation> iterator = null;
		CountrysList countrysList = null;
		Plant plant = null;
		try {
			list = dao.searchStorageWithId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getStorageIds() {
		// TODO Auto-generated method stub

		try {
			list = dao.getStorageIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String deleteStorageLoc(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = dao.deleteStorageLoc(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String updateStorageLocation(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = dao.updateStorageLocation(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long duplicateCheck(String storageLocation) {
		// TODO Auto-generated method stub
		Long duplicateId = 0l;
		try {

			duplicateId = dao.duplicateCheck(storageLocation);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return duplicateId;
	}

	@Override
	public Long updateDuplicateCheck(String storageLocation,
			int storageLocationId) {
		// TODO Auto-generated method stub
		Long duplicateId = 0l;
		try {
			duplicateId = dao.updateDuplicateCheck(storageLocation,
					storageLocationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicateId;
	}

	public List<StorageLocation> basicSearchStorageLoc(String label,
			String operator, String searchName) {
		List<StorageLocation> locations = null;
		CountrysList countrysList = null;
		Plant plant = null;
		try {
			list = dao.basicSearchStorageLoc(label, operator, searchName);
			locations = new ArrayList<StorageLocation>();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				storageLocation = new StorageLocation();
				storageLocation.setStorageLocationId((Integer) objects[0]);
				storageLocation.setStorageLocation((String) objects[1]);
				storageLocation.setAdd1((String) objects[2]);
				storageLocation.setAdd2((String) objects[3]);
				storageLocation.setAdd3((String) objects[4]);
				storageLocation.setCity((String) objects[5]);
				countrysList = (CountrysList) objects[12];
				storageLocation.setState((String) objects[6]);
				storageLocation.setPhone((String) objects[7]);
				storageLocation.setFax((String) objects[8]);
				storageLocation.setMobile((String) objects[9]);
				storageLocation.setZip((String) objects[10]);
				storageLocation.setCountry(String.valueOf(countrysList.getCountryId()));
				storageLocation.setCountryName(countrysList.getCountryName());
				plant = (Plant) objects[11];
				storageLocation.setPlantId(String.valueOf(plant.getPlantId()));
				storageLocation.setPlantName(plant.getPlantName());
				locations.add(storageLocation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return locations;
	}
	@Override
	public List<Object[]> getStorageAdvance(String columns, String opeator,
			String advanceSearchText) {
		// TODO Auto-generated method stub
		String column[]=columns.split(",");
		String op[]=opeator.split(",");
		String advanceSearch[]=advanceSearchText.split(",");
		String finalStringForSearch="";
		
		for(int i=0;i<advanceSearch.length;i++){
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			if (op[i].equals("_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = advanceSearch[i] +"%";
				

			} else if (op[i].equals("%_")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = "%" + advanceSearch[i];

			} else if (op[i].equals("%_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] =  "%"  + advanceSearch[i] + "%" ;

			} else if (op[i].equals("=")) {
				column[i]=column[i];
				op[i]=" = ";
				advanceSearch[i] =   advanceSearch[i]  ;

			} else if (op[i].equals("!=")) {
				column[i]=column[i];
				op[i]=" != ";
				advanceSearch[i] =   advanceSearch[i]  ;

			}
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			finalStringForSearch=finalStringForSearch+"  s."+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
		}
		
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = dao.storageAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = dao.storageAdvanceSearch("ALL");
		}
		return list;
	}
	public List<Object[]> getStorage(String storage) {
		List<Object[]> list = dao.setStorageSearch(storage);
		return list;
	}


}
