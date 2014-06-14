/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.dao.GoodsIssueDao;

/**
 * @author kirangangone
 * 
 */
public class GoodsIssueServiceImpl implements GoodsIssueService {
	public GoodsIssueDao goodsIssueDao;

	String message = null;
	boolean flag;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	public GoodsIssueDao getGoodsIssueDao() {
		return goodsIssueDao;
	}

	public void setGoodsIssueDao(GoodsIssueDao goodsIssueDao) {
		this.goodsIssueDao = goodsIssueDao;
	}

	@Override
	public String saveGoodsIssue(Object object) {
		String message = "S";
		try {
			message = goodsIssueDao.saveGoodsIssue(object);
		} catch (Exception e) {
			e.printStackTrace();
			message = "F";

		}
		return message;
	}

	public List<Object> editGoodsIssueWithId(int cId) {
		try {
			obj = goodsIssueDao.editGoodsIssueWithId(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List<Object[]> basicSearchGoodsIssue(String label, String operator,
			String searchName, String advancedValu) {
		List<Object[]> objs = null;
		try {

			if (advancedValu.equalsIgnoreCase("A")) {
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
							finalStringForSearch = finalStringForSearch
									+ "  i." + column[i] + " " + op[i] + " "
									+ advanceSearch[i] + " " + "AND";
						}
					}

				}
				// System.out.println("String Value Kiran"
				// +finalStringForSearch);
				// List<Object[]> list = null;
				if (finalStringForSearch.length() > 3) {
					objs = goodsIssueDao.basicSearchGoodsIssue("", "", "",
							finalStringForSearch.substring(0,
									finalStringForSearch.length() - 3));
				}
			} else {
				// System.out.println("In Basic with basicSearchId != empty 1 in service");
				objs = goodsIssueDao.basicSearchGoodsIssue(label, operator,
						searchName, "");
				// System.out.println("In Basic with basicSearchId != empty 2 in service");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}

	/*
	 * public List<Object[]> getPurchaseAdvance(String columns, String opeator,
	 * String advanceSearchText) { String column[] = columns.split(","); String
	 * op[] = opeator.split(","); String advanceSearch[] =
	 * advanceSearchText.split(","); String finalStringForSearch = "";
	 * 
	 * for (int i = 0; i < advanceSearch.length; i++) { if (!op[i].equals("0")
	 * && advanceSearch[i] != "") { if (op[i].equals("_%")) { column[i] =
	 * column[i]; op[i] = " like "; advanceSearch[i] = advanceSearch[i] + "%";
	 * 
	 * } else if (op[i].equals("%_")) { column[i] = column[i]; op[i] = " like ";
	 * advanceSearch[i] = "%" + advanceSearch[i];
	 * 
	 * } else if (op[i].equals("%_%")) { column[i] = column[i]; op[i] =
	 * " like "; advanceSearch[i] = "%" + advanceSearch[i] + "%";
	 * 
	 * } else if (op[i].equals("=")) { column[i] = column[i]; op[i] = " = ";
	 * advanceSearch[i] = advanceSearch[i];
	 * 
	 * } else if (op[i].equals("!=")) { column[i] = column[i]; op[i] = " != ";
	 * advanceSearch[i] = advanceSearch[i];
	 * 
	 * } if (!op[i].equals("0") && advanceSearch[i] != "") {
	 * finalStringForSearch = finalStringForSearch + "  po." + column[i] + " " +
	 * op[i] + " '" + advanceSearch[i] + "' " + "AND"; } }
	 * 
	 * } // System.out.println("String Value Kiran" +finalStringForSearch);
	 * List<Object[]> list = null; if (finalStringForSearch.length() > 3) { list
	 * = GoodsIssueDao.setPurchaseAdvanceSearch(finalStringForSearch
	 * .substring(0, finalStringForSearch.length() - 3)); } else { list =
	 * GoodsIssueDao.basicSearchPO(); } return list; }
	 */

	@Override
	public boolean updateGoodsIssue(Object object, AuditLog a, int alength) {
		try {
			// System.out.println("Came to Service Of Purchase Update");
			flag = goodsIssueDao.updateGoodsIssue(object, a, alength);
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	public int checkGoodsIssue(String pno, String custId) {
		int i = 0;
		try {
			i = goodsIssueDao.checkGoodsIssue(pno, custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean deleteGoodsIssue(int id, String mainOrSub) {
		// TODO Auto-generated method stub

		try {
			flag = goodsIssueDao.deleteGoodsIssue(id, mainOrSub);
		} catch (Exception e) {
			// e.printStackTrace();
			return flag;
		}
		return flag;
	}

	public double getAvailableQuantity(String material, String batchNo,
			String storageLocation) {
		double list = 0.0;
		// TODO Auto-generated method stub

		try {
			list = goodsIssueDao.getAvailableQuantity(material, batchNo,
					storageLocation);
		} catch (Exception e) {
			// e.printStackTrace();
			return list;
		}
		return list;

	}

	/*
	 * public void getMaterialStockUpdate(String material,String
	 * stockDeductedOrAdded) { try {
	 * goodsIssueDao.getMaterialStockUpdate(material, stockDeductedOrAdded); }
	 * catch (Exception e) { //e.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 */

	@Override
	public List<MatStockBean> getAvlQty(int matId, int stlId, String batchId) {
		List<MatStockBean> mtStock = null;
		try {
			mtStock = goodsIssueDao.getAvlQty(matId, stlId, batchId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mtStock;
	}

	@Override
	public boolean saveOrUpdateMatStock(Object object) {
		boolean flag = true;
		try {
			flag = goodsIssueDao.saveOrUpdateMatStock(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<MatStockBean> getMatStock(int mtId, int slId, String bNo) {
		List<MatStockBean> ob = null;
		try {
			ob = goodsIssueDao.getMatStock(mtId, slId, bNo);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ob;
	}

}
