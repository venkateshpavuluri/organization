/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.VendorReturnDao;

/**
 * @author Sailaja
 * @version 1.0 20-11-2013
 * @build 0.0
 */
public class VendorReturnServiceImpl implements VendorReturnService {

	public VendorReturnDao vendorReturnDao;
	String message = null;
	List<Object[]> list = null;

	public VendorReturnDao getVendorReturnDao() {
		return vendorReturnDao;
	}

	public void setVendorReturnDao(VendorReturnDao vendorReturnDao) {
		this.vendorReturnDao = vendorReturnDao;
	}

	@Override
	public List<Object[]> getPurchaseOrderIds() {

		try {
			list = vendorReturnDao.getPurchaseOrderIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String addVendorReturn(Object object) {
		// TODO Auto-generated method stub
		message = vendorReturnDao.addVendorReturn(object);
		return message;
	}

	@Override
	public List<Object> searchVendorReturn() {
		// TODO Auto-generated method stub
		List<Object> obj = null;
		try {

			obj = vendorReturnDao.searchVendorReturn();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public List<Object> searchVendorReturnWithId(int id) {
		// TODO Auto-generated method stub
		List<Object> obj = null;
		try {
			obj = vendorReturnDao.searchVendorReturnWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Object> getVendorReturnAdvance(String columns, String opeator,
			String advanceSearchText) {
		// TODO Auto-generated method stub
		String column[] = columns.split(",");
		String op[] = opeator.split(",");
		String advanceSearch[] = advanceSearchText.split(",");
		String finalStringForSearch = "";
		List<Object> advSearchList = null;
		int count = 0;
		try {
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
						if (count > 0) {
							finalStringForSearch += " and vr." + column[i]
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

			if (finalStringForSearch.length() > 0) {
				advSearchList = vendorReturnDao
						.vendorReturnAdvanceSearch(finalStringForSearch);
			} else {
				advSearchList = vendorReturnDao
						.vendorReturnAdvanceSearch("ALL");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return advSearchList;
	}

	@Override
	public List<Object> getVendorReturn(String vendorReturn) {
		// TODO Auto-generated method stub
		List<Object> list = vendorReturnDao.setVendorReturnSearch(vendorReturn);
		return list;
	}

	@Override
	public List<Object> basicSearchVendorReturn(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object> listobj = null;
		try {
			listobj = vendorReturnDao.basicSearchVendorReturn(label, operator,
					searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listobj;
	}

	@Override
	public String deleteVendorReturn(int id) {
		// TODO Auto-generated method stub
		try {
			message = vendorReturnDao.deleteVendorReturn(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<Object> editVendorReturnWithId(int vrid) {
		// TODO Auto-generated method stub
		List<Object> list = null;
		try {
			list = vendorReturnDao.editVendorReturnWithId(vrid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateVendorReturn(Object object) {
		// TODO Auto-generated method stub
		try {
			message = vendorReturnDao.updateVendorReturn(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public int checkDuplicate(String checkVrNo) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = vendorReturnDao.checkDuplicate(checkVrNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public int checkEditDuplicate(String checkVrNo, int id) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = vendorReturnDao.checkEditDuplicate(checkVrNo, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public String deleteVendorReturnLine(int kk) {
		// TODO Auto-generated method stub
		try {
			message = vendorReturnDao.deleteVendorReturnLine(kk);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<Object[]> getRejQty(int poId, int grId, String mtId, String bNo) {
		List<Object[]> obj = null;
		try {
			obj = vendorReturnDao.getRejQty(poId, grId, mtId, bNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateGRLQtyReturns(final int grId, final String matId,
			final String bNo, final float returnQty) {
		try {
			vendorReturnDao.updateGRLQtyReturns(grId, matId, bNo, returnQty);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean updateGRLQtys(final int grId, final String matId,
			final String bNo, final float retQty, final float rejQty) {
		try {
			vendorReturnDao.updateGRLQtys(grId, matId, bNo, retQty, rejQty);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

}
