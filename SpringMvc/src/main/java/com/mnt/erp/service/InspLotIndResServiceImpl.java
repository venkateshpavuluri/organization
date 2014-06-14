/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.erp.dao.InspLotIndResDao;

/**
 * @author Naresh
 * @version 1.0 17-05-2014
 */
@Service("inspLotIndResService")
public class InspLotIndResServiceImpl implements InspLotIndResService {
	@Autowired
	InspLotIndResDao inspLotIndResDao;

	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;

	@Override
	public boolean saveInspLotIndRes(Object object) {
		try {

			flag = inspLotIndResDao.saveInspLotIndRes(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchInspLotIndRes() {
		try {
			objects = inspLotIndResDao.searchInspLotIndRes();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchInspLotIndResWithId(int inspId) {
		try {
			obj = inspLotIndResDao.searchInspLotIndResWithId(inspId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateInspLotIndRes(Object object) {
		try {
			flag = inspLotIndResDao.updateInspLotIndRes(object);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspLotIndRes(int inspId) {
		try {
			flag = inspLotIndResDao.deleteInspLotIndRes(inspId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspLotIndResLine(int inspLineId) {
		try {
			flag = inspLotIndResDao.deleteInspLotIndResLine(inspLineId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchInspLotIndRes(String label,
			String operator, Double searchName) {
		try {
			objects = inspLotIndResDao.basicSearchInspLotIndRes(label,
					operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchInspLotIndRes(String labels, String opts,
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
			list = inspLotIndResDao
					.advSearchInspLotIndRes(finalStringForSearch);
		} else {
			list = inspLotIndResDao.searchInspLotIndRes();
		}
		return list;
	}

}
