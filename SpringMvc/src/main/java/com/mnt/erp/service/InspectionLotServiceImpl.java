/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.GoodsReceiptLine;
import com.mnt.erp.dao.InspectionLotDao;

/**
 * @author Naresh
 * @version 1.0 07-01-2014
 */
public class InspectionLotServiceImpl implements InspectionLotService {

	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;
	Long l = 0l;

	InspectionLotDao inspectionLotDao;

	public InspectionLotDao getInspectionLotDao() {
		return inspectionLotDao;
	}

	public void setInspectionLotDao(InspectionLotDao inspectionLotDao) {
		this.inspectionLotDao = inspectionLotDao;
	}

	@Override
	public Long updateCheckInspectionLot(String inspNo, int inspId) {
		try {
			l = inspectionLotDao.updateCheckInspectionLot(inspNo, inspId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Long checkInspectionLotCout(String inspNo) {
		try {
			l = inspectionLotDao.checkInspectionLotCout(inspNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean saveInspectionLotDetails(Object object) {
		try {
			flag = inspectionLotDao.saveInspectionLotDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchInspectionLot() {
		try {
			objects = inspectionLotDao.searchInspectionLot();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchInspectionLotWithId(int inspId) {
		try {
			obj = inspectionLotDao.searchInspectionLotWithId(inspId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateInspectionLot(Object object) {
		try {
			flag = inspectionLotDao.updateInspectionLot(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspectionLot(int inspId) {
		try {
			flag = inspectionLotDao.deleteInspectionLot(inspId);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchInspectionLot(String label,
			String operator, String searchName) {
		try {
			objects = inspectionLotDao.basicSearchInspectionLot(label,
					operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<GoodsReceiptLine> getAvlQty(int matId, String batchNo) {
		List<GoodsReceiptLine> grl = null;
		try {
			grl = inspectionLotDao.getAvlQty(matId, batchNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return grl;
	}

	@Override
	public boolean deleteInspectionLotEqp(int inspEqpId) {
		try {
			flag = inspectionLotDao.deleteInspectionLotEqp(inspEqpId);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> advSearchInspectionLot(String labels, String opts,
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
						finalStringForSearch += " and dn." + column[i] + " "
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
			list = inspectionLotDao
					.advSearchInspectionLot(finalStringForSearch);
		} else {
			list = inspectionLotDao.searchInspectionLot();
		}
		return list;
	}

}
