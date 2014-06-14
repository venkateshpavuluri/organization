/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.dao.PlantDao;

/**
 * @author pvenkateswarlu
 * @version 1.0 20-09-2013
 */

public class PlantServiceImpl implements PlantService {
	private List<Object[]> list;
	private Iterator<Object[]> iterator;
	private Object[] objects;
	private List<Plant> listPlant = null;
	private Plant plants = null;
	private CountrysList countrysList = null;
	private Organization organization = null;
	PlantDao dao;

	/**
	 * @return the dao
	 */
	public PlantDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(PlantDao dao) {
		this.dao = dao;
	}

	String msg = null;

	@Override
	public String savePlantDetails(Object object,String userId,String UserName) {
		// TODO Auto-generated method stub

		try {
			msg = dao.savePlantDetails(object,userId,UserName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> getPlantIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.getPlantIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Plant> searchPlantDetails() {
		// TODO Auto-generated method stub

		try {

			list = dao.searchPlantDetails();
			listPlant = new ArrayList<Plant>();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				plants = new Plant();
				// p.plantId
				// ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList
				// from Plant p
				plants.setPlantId((Integer) objects[0]);
				plants.setPlantName((String) objects[1]);
				plants.setAdd1((String) objects[2]);
				plants.setAdd2((String) objects[3]);
				plants.setAdd3((String) objects[4]);
				plants.setCity((String) objects[5]);
				plants.setState((String) objects[6]);
				plants.setPhone((String) objects[7]);
				plants.setFax((String) objects[8]);
				plants.setMobile((String) objects[9]);
				countrysList = (CountrysList) objects[11];
				plants.setCountry(String.valueOf(countrysList.getCountryId()));
				plants.setCountryName(countrysList.getCountryName());
				organization = (Organization) objects[10];
				plants.setOrgId(String.valueOf(organization.getOrgId()));
				plants.setOrgName(organization.getOrgName());
				listPlant.add(plants);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPlant;
	}

	@Override
	public List<Plant> searchPlantDetails(int id) {
		// TODO Auto-generated method stub
		try {

			list = dao.searchPlantDetails(id);
			listPlant = new ArrayList<Plant>();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				plants = new Plant();
				// p.plantId
				// ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList
				// from Plant p
				plants.setPlantId((Integer) objects[0]);
				plants.setPlantName((String) objects[1]);
				plants.setAdd1((String) objects[2]);
				plants.setAdd2((String) objects[3]);
				plants.setAdd3((String) objects[4]);
				plants.setCity((String) objects[5]);
				plants.setState((String) objects[6]);
				plants.setPhone((String) objects[7]);
				plants.setFax((String) objects[8]);
				plants.setMobile((String) objects[9]);
				countrysList = (CountrysList) objects[11];
				plants.setCountry(String.valueOf(countrysList.getCountryId()));
				plants.setCountryName(countrysList.getCountryName());
				organization = (Organization) objects[10];
				plants.setOrgId(String.valueOf(organization.getOrgId()));
				plants.setOrgName(organization.getOrgName());
				listPlant.add(plants);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPlant;

	}

	@Override
	public String updatePlantDetails(Object object) {
		// TODO Auto-generated method stub
		Plant plant = null;
		try {
			plant = (Plant) object;
			plant.setPlantId(plant.getPlantIdEdit());
			plant.setPlantName(plant.getPlantNameEdit());
			plant.setAdd1(plant.getAdd1Edit());
			plant.setAdd2(plant.getAdd2Edit());
			plant.setAdd3(plant.getAdd3Edit());
			plant.setCity(plant.getCityEdit());
			plant.setCountry(plant.getCountryEdit());
			plant.setFax(plant.getFaxEdit());
			plant.setMobile(plant.getMobileEdit());
			plant.setOrgId(plant.getOrgIdEdit());
			plant.setPhone(plant.getPhoneEdit());
			plant.setState(plant.getStateEdit());
			msg = dao.updatePlantDetails(plant);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deletePlantDetails(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = dao.deletePlantDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getPlantNameCount(String name) {
		// TODO Auto-generated method stub
		Long dupId = 0l;
		try {
			dupId = dao.getPlantNameCount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dupId;
	}

	@Override
	public Long updateDuplicate(String plantName, int plantId) {
		// TODO Auto-generated method stub
		Long dupId = 0l;
		try {
			dupId = dao.updateDuplicate(plantName, plantId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dupId;
	}

	public List<Object[]> selectPlantDetails() {
		try {
			list = dao.selectPlantDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Plant> basicSearchPlant(String label, String operator,
			String searchName) {
		try {
			list = dao.basicSearchPlant(label, operator, searchName);
			listPlant = new ArrayList<Plant>();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				plants = new Plant();
				plants.setPlantId((Integer) objects[0]);
				plants.setPlantName((String) objects[1]);
				plants.setAdd1((String) objects[2]);
				plants.setAdd2((String) objects[3]);
				plants.setAdd3((String) objects[4]);
				plants.setCity((String) objects[5]);
				plants.setState((String) objects[6]);
				plants.setPhone((String) objects[7]);
				plants.setFax((String) objects[8]);
				plants.setMobile((String) objects[9]);
				countrysList = (CountrysList) objects[11];
				plants.setCountry(String.valueOf(countrysList.getCountryId()));
				plants.setCountryName(countrysList.getCountryName());
				organization = (Organization) objects[10];
				plants.setOrgId(String.valueOf(organization.getOrgId()));
				plants.setOrgName(organization.getOrgName());
				listPlant.add(plants);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPlant;
	}
	@Override
	public List<Object[]> getPlantAdvance(String columns, String opeator,
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
			finalStringForSearch=finalStringForSearch+"  p."+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
		}
		
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = dao.plantAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = dao.plantAdvanceSearch("ALL");
		}
		return list;
	}
	public List<Object[]> getPlant(String plant) {
		List<Object[]> list = dao.setPlantSearch(plant);
		return list;
	}

}
