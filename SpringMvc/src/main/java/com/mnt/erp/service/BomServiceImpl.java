/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;





import com.mnt.erp.dao.BomCategoryDaoImpl;
import com.mnt.erp.dao.BomDao;

/**
 * @author Kishore
 *
 */
public class BomServiceImpl implements BomService {

	String message;
	List<Object[]> list = null;
	public BomCategoryDaoImpl dao;
	public BomDao bomDao;
	
	
	
	
	public BomDao getBomDao() {
		return bomDao;
	}

	public void setBomDao(BomDao bomDao) {
		this.bomDao = bomDao;
	}

	@Override
	public String addBom(Object object) {
		// TODO Auto-generated method stub
		message = bomDao.addBom(object);
		return message;
	}

	@Override
	public List<Object[]> searchBom() {
		// TODO Auto-generated method stub
		try {

			list = bomDao.searchBom();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Object[]> searchBomWithId(int id) {
		// TODO Auto-generated method stub
		try {
			list =bomDao.searchBomWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object> editBomWithId(int qid) {
		// TODO Auto-generated method stub
		List<Object> list = null;
		try {
			list = bomDao.editBomWithId(qid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateBom(Object object) {
		// TODO Auto-generated method stub
		try {
			message = bomDao.updateBom(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteBom(int id) {
		// TODO Auto-generated method stub
		try {
			message = bomDao.deleteBom(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteBomLine(int bomLineId) {
		// TODO Auto-generated method stub
		try {
			message = bomDao.deleteBomLine(bomLineId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public int checkDuplicate(String checkMaterial) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = bomDao.checkDuplicate(checkMaterial);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public int checkEditDuplicate(String checkMaterial, int id) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = bomDao.checkEditDuplicate(checkMaterial, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public List<Object[]> basicSearchBom(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		try {
			list = bomDao.basicSearchBom(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getBomCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = bomDao.getBomCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> getBomAdvance(String columns, String opeator,
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
			finalStringForSearch=finalStringForSearch+"  b."+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
		}
		
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = bomDao.bomAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = bomDao.bomAdvanceSearch("ALL");
		}
		return list;
	}
	public List<Object[]> getBom(String bom) {
		List<Object[]> list = bomDao.setBomSearch(bom);
		return list;
	}

}
