/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Sailaja
 *
 */
public interface BomService {
	public List<Object[]> getBomAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> getBom(String bom);
	public String addBom(Object object);
	public List<Object[]> searchBom();
	public List<Object[]> searchBomWithId(int id);
	public List<Object> editBomWithId(int qid);
	public String updateBom(Object object);
    public String deleteBom(int id);
    public String deleteBomLine(int bomLineId);
    public int checkDuplicate(String checkMaterial);	
    public int checkEditDuplicate(String checkMaterial,int id);
    public List<Object[]> getBomCategory();
   
    public List<Object[]> basicSearchBom(String label,String operator,String searchName);

}
