/**
 *@Copyright MNTSOFT 
 */
package com.mnt.erp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.dao.InspLotResultDao;

/**
 * @author Naresh
 * @version 1.0 10-01-2014
 */
public class InspLotResultServiceImpl implements InspLotResultService {

	boolean flag = true;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	@Autowired
	DateConversionService dateService;

	InspLotResultDao inspLotResDao;

	public InspLotResultDao getInspLotResDao() {
		return inspLotResDao;
	}

	public void setInspLotResDao(InspLotResultDao inspLotResDao) {
		this.inspLotResDao = inspLotResDao;
	}

	@Override
	public boolean saveInspLotResultDetails(Object object) {
		try {
			flag = inspLotResDao.saveInspLotResultDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchInspLotResult() {
		try {
			objects = inspLotResDao.searchInspLotResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchInspLotResultWithId(int inspId) {
		try {
			obj = inspLotResDao.searchInspLotResultWithId(inspId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateInspLotResult(Object object) {
		try {
			flag = inspLotResDao.updateInspLotResult(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspLotResult(int inspId) {
		try {
			flag = inspLotResDao.deleteInspLotResult(inspId);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchInspLotResult(String label,
			String operator, String searchName) {
		try {
			objects = inspLotResDao.basicSearchInspLotResult(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public boolean getLotQty(int inspId, float inspected) {
		try {
			flag = inspLotResDao.getLotQty(inspId, inspected);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object> getMaterialId(int inspid) {
		try {
			obj = inspLotResDao.getMaterialId(inspid);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return obj;
	}

	@Override
	public boolean updateMaterial(float stock, int matId) {
		try {
			flag = inspLotResDao.updateMaterial(stock, matId);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public float getStock(int materalId) {
		float stock = 0;
		try {
			stock = inspLotResDao.getStock(materalId);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return stock;
	}

	@Override
	public List<Object> getGoodsQty(int matId, String batchNo) {
		try {
			obj = inspLotResDao.getGoodsQty(matId, batchNo);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return obj;
	}

	@Override
	public boolean updateGoodsReceiptLine(float totQtyInsp, float totQtyAcp,
			float totQtyRej, int matId, String batchNo) {
		try {
			flag = inspLotResDao.updateGoodsReceiptLine(totQtyInsp, totQtyAcp,
					totQtyRej, matId, batchNo);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdateMatStock(Object object) {
		try {
			flag = inspLotResDao.saveOrUpdateMatStock(object);

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
			ob = inspLotResDao.getMatStock(mtId, slId, bNo);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ob;
	}

	@Override
	public List<Object[]> advSearchInspLotResult(String labels, String opts,
			String advText) {
		List<Object[]> lists = null;
		try {
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
					if (!"".equals(advanceSearch[i])) {
						boolean flag = dateService
								.isThisDateValid(advanceSearch[i]);

						if (flag == true) {
							if (count > 0) {
								finalStringForSearch += " and dn."
										+ column[i]
										+ " "
										+ op[i]
										+ "'"
										+ dateService.dateFormat(dateService
												.dateParse(advanceSearch[i],
														"au"), "au") + "'";
							} else {
								finalStringForSearch += column[i]
										+ " "
										+ op[i]
										+ "'"
										+ dateService.dateFormat(dateService
												.dateParse(advanceSearch[i],
														"au"), "au") + "'";
								count++;
							}
						} else {
							if (count > 0) {
								finalStringForSearch += " and dn." + column[i]
										+ " " + op[i] + "'" + advanceSearch[i]
										+ "'";
							} else {
								finalStringForSearch += column[i] + " " + op[i]
										+ "'" + advanceSearch[i] + "'";
								count++;
							}
						}

					}
				}

			}

			if (finalStringForSearch.length() > 0) {
				lists = inspLotResDao
						.advSearchInspLotResult(finalStringForSearch);

			} else {
				lists = inspLotResDao.searchInspLotResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

}
