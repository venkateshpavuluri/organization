/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 08-11-2013
 * @build 0.0
 *
 */
public interface BomDao {
	
    public List<Object[]> bomAdvanceSearch(String name);
	public List<Object[]> setBomSearch(String name);
	public String addBom(Object object);
	public List<Object[]> searchBom();
	public List<Object[]> searchBomWithId(int id);
	public List<Object> editBomWithId(int qid);
	public String updateBom(Object object);
    public String deleteBom(int id);
    public String deleteBomLine(int bomLineId);
    public int checkDuplicate(String checkMaterial);	
    public int checkEditDuplicate(String checkMaterial,int id);
    public List<Object[]> basicSearchBom(String label,String operator,String searchName);
    
    public List<Object[]> getBomCategory();

}
