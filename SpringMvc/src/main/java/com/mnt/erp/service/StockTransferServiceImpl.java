/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.dao.StockTransferDao;

/**
 * @author Naresh
 * @version 1.0 29-11-2013
 */
public class StockTransferServiceImpl implements StockTransferService {
	String sus;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = false;

	StockTransferDao stockTransferDao;

	public StockTransferDao getStockTransferDao() {
		return stockTransferDao;
	}

	public void setStockTransferDao(StockTransferDao stockTransferDao) {
		this.stockTransferDao = stockTransferDao;
	}

	@Override
	public List<Object[]> selectOrgIds() {
		try {
			objects = stockTransferDao.selectOrgIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPlantIds(int orgId) {
		try {
			objects = stockTransferDao.selectPlantIds(orgId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateStorLocIds(int plantId) {
		try {
			objects = stockTransferDao.populateStorLocIds(plantId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public int updateCheckStockTransfer(String salesNo, int siId) {
		int i = 0;
		try {
			i = stockTransferDao.updateCheckStockTransfer(salesNo, siId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Long checkStockTransfer(String salesNo) {
		try {
			l = stockTransferDao.checkStockTransfer(salesNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String saveStockTransfer(Object object) {
		try {

			sus = stockTransferDao.saveStockTransfer(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchStockTransfer() {
		try {
			objects = stockTransferDao.searchStockTransfer();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchStockTransferWithId(int sId) {
		try {
			obj = stockTransferDao.searchStockTransferWithId(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateStockTransfer(Object object) {
		try {
			sus = stockTransferDao.updateStockTransfer(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteStockTransfer(int cId) {
		try {
			sus = stockTransferDao.deleteStockTransfer(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> basicSearchStockTransfer(String label,
			String operator, String searchName) {
		try {
			objects = stockTransferDao.basicSearchStockTransfer(label,
					operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateUOMIds() {
		try {
			objects = stockTransferDao.populateUOMIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateMaterialIds(int storLocId) {
		List<Object[]> objects = null;
		try {
			objects = stockTransferDao.populateMaterialIds(storLocId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateStorLocIds() {
		try {
			objects = stockTransferDao.populateStorLocIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPlantIds() {
		try {
			objects = stockTransferDao.selectPlantIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteStockTransferLine(int sId) {
		try {
			sus = stockTransferDao.deleteStockTransferLine(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> getBatchNOs(int materialId, String slId) {
		try {
			objects = stockTransferDao.getBatchNOs(materialId, slId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<MatStockBean> getAvlQty(int matId, int stlId, String batchId) {
		List<MatStockBean> mtStock = null;
		try {
			mtStock = stockTransferDao.getAvlQty(matId, stlId, batchId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mtStock;
	}

	@Override
	public boolean saveOrUpdateMatStock(Object object) {
		try {
			flag = stockTransferDao.saveOrUpdateMatStock(object);

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
			ob = stockTransferDao.getMatStock(mtId, slId, bNo);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ob;
	}

	@Override
	public List<Object[]> selectBatchNos() {
		try {
			objects = stockTransferDao.selectBatchNos();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public boolean updateMatStock(float qty, int mtId, int slId, String bNo) {
		boolean flag = false;
		try {

			flag = stockTransferDao.updateMatStock(qty, mtId, slId, bNo);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public List<Object[]> advSearchStockTransfer(String labels, String opts,
			String advText) {
		List<Object[]> list = null;
		String column[] = labels.split(",");
		String op[] = opts.split(",");
		String advanceSearch[] = advText.split(",");
		String finalStringForSearch = "";
		int count = 0;
		for (int i = 0; i < advanceSearch.length; i++) {
			if (!op[i].equals("0") && advanceSearch[i] != "") {
				if (op[i].equals("_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = advanceSearch[i] + "%";

				} else if (op[i].equals("%_")) {
					column[i] = column[i];
					op[i] = "like ";
					advanceSearch[i] = "%" + advanceSearch[i];

				} else if (op[i].equals("%_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = "%" + advanceSearch[i] + "%";

				} else if (op[i].equals("=")) {
					column[i] = column[i];
					op[i] = "=";
					advanceSearch[i] = advanceSearch[i];

				} else if (op[i].equals("!=")) {
					column[i] = column[i];
					op[i] = "!=";
					advanceSearch[i] = advanceSearch[i];

				}
				if (!"".equals(advanceSearch[i])) {
					if (count > 0) {
						finalStringForSearch += " and cb." + column[i] + " "
								+ op[i] + "'" + advanceSearch[i] + "'";
					} else {
						finalStringForSearch += column[i] + " " + op[i] + "'"
								+ advanceSearch[i] + "'";
						count++;
					}

				}

			}

		}

		if (finalStringForSearch.length() > 0) {
			list = stockTransferDao
					.advSearchStockTransfer(finalStringForSearch);
		} else {
			list = stockTransferDao.searchStockTransfer();
		}
		return list;
	}

}
