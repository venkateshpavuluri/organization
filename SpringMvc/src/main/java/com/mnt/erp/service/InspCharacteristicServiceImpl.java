/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;






import com.mnt.erp.dao.InspCharacteristicDao;


/**
 * @author kirangangone
 * 
 */
public class InspCharacteristicServiceImpl implements InspCharacteristicService {
	public InspCharacteristicDao inspCharacteristicDao;
	
	String msg = null;
	boolean flag;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;
    
	
	
	
	
	public InspCharacteristicDao getInspCharacteristicDao() {
		return inspCharacteristicDao;
	}

	public void setInspCharacteristicDao(InspCharacteristicDao inspCharacteristicDao) {
		this.inspCharacteristicDao = inspCharacteristicDao;
	}

	@Override
	public String saveInspCharacteristic(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		msg = inspCharacteristicDao.saveInspCharacteristic(object, userId, userName);
		return msg;
	}
	
	public List<Object> editInspCharacteristicWithId(int cId) {
		try {
			obj = inspCharacteristicDao.editInspCharacteristicWithId(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List<Object[]> basicSearchInspCharacteristic(String label, String operator,
			String searchName,String advancedValu ) {
		List<Object[]> objs = null;
		try {
			
			if(advancedValu.equalsIgnoreCase("A"))
			{
				String column[] = label.split(",");
				String op[] = operator.split(",");
				String advanceSearch[] = searchName.split(",");
				String finalStringForSearch = "";

				for (int i = 0; i < advanceSearch.length; i++) {
					if (!op[i].equals("0") && advanceSearch[i] != "") {
						if (op[i].equals("_%")) {
							column[i] = column[i];
							op[i] = " like ";
							advanceSearch[i] = advanceSearch[i] + "%";

						} else if (op[i].equals("%_")) {
							column[i] = column[i];
							op[i] = " like ";
							advanceSearch[i] = "%" + advanceSearch[i];

						} else if (op[i].equals("%_%")) {
							column[i] = column[i];
							op[i] = " like ";
							advanceSearch[i] = "%" + advanceSearch[i] + "%";

						} else if (op[i].equals("=")) {
							column[i] = column[i];
							op[i] = " = ";
							advanceSearch[i] = advanceSearch[i];

						} else if (op[i].equals("!=")) {
							column[i] = column[i];
							op[i] = " != ";
							advanceSearch[i] = advanceSearch[i];

						}
						if (!op[i].equals("0") && advanceSearch[i] != "") {
							finalStringForSearch = finalStringForSearch + "  i."
									+ column[i] + " " + op[i] + " " + advanceSearch[i]
									+ " " + "AND";
						}
					}

				}
				// System.out.println("String Value Kiran" +finalStringForSearch);
				//List<Object[]> list = null;
				if (finalStringForSearch.length() > 3) {
					objs = inspCharacteristicDao.basicSearchInspCharacteristic("","","",finalStringForSearch
							.substring(0, finalStringForSearch.length() - 3));
				}
			}
			else
			{
				//System.out.println("In Basic with basicSearchId != empty 1 in service");
			objs = inspCharacteristicDao.basicSearchInspCharacteristic(label, operator, searchName,"");
			//System.out.println("In Basic with basicSearchId != empty 2 in service");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}

	

	@Override
	public String updateInspCharacteristic(Object object) {
		try {
			
			msg = inspCharacteristicDao.updateInspCharacteristic(object);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return msg;
	}

	public int checkInspCharacteristic(String pno, String custId) {
		int i = 0;
		try {
			i = inspCharacteristicDao.checkInspCharacteristic(pno, custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	

	

	public String deleteInspCharacteristic(int id,String mainOrSub) {
		// TODO Auto-generated method stub

		try {
			msg = inspCharacteristicDao.deleteInspCharacteristic(id,mainOrSub);
		} catch (Exception e) {
		e.printStackTrace();
		
		}
		return msg;
	}
	
	
	public List<Object[]> inspectionMethodSelect()
	{
		 List<Object[]> list=null;
			// TODO Auto-generated method stub

			try {
				list=inspCharacteristicDao.inspectionMethodSelect();
			} catch (Exception e) {
				//e.printStackTrace();
				return list;
			}
			return list;
		
	}
	public List<Object[]> charactersticTypeSelect(){
		 List<Object[]> list=null;
			// TODO Auto-generated method stub

			try {
				list=inspCharacteristicDao.charactersticTypeSelect();
			} catch (Exception e) {
				//e.printStackTrace();
				return list;
			}
			return list;
	}
	

}
