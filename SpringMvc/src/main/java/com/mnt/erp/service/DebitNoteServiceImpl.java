/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.dao.DebitNoteDao;

/**
 * @author Naresh
 * @version 1.0 02-01-2014
 */
public class DebitNoteServiceImpl implements DebitNoteService {
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;
	@Autowired
	DateConversionService dateService;

	DebitNoteDao debitNoteDao;

	public DebitNoteDao getDebitNoteDao() {
		return debitNoteDao;
	}

	public void setDebitNoteDao(DebitNoteDao debitNoteDao) {
		this.debitNoteDao = debitNoteDao;
	}

	@Override
	public int updateCheckDebitNote(String debNo, int dnId) {
		int i = 0;
		try {
			i = debitNoteDao.updateCheckDebitNote(debNo, dnId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Long checkDebitNote(String debNo) {
		try {
			l = debitNoteDao.checkDebitNote(debNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean saveDebitNote(Object object) {
		try {

			flag = debitNoteDao.saveDebitNote(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchDebitNote() {
		try {
			objects = debitNoteDao.searchDebitNote();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchDebitNoteWithId(int dnId) {
		try {
			obj = debitNoteDao.searchDebitNoteWithId(dnId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateDebitNote(Object object) {
		try {
			flag = debitNoteDao.updateDebitNote(object);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteDebitNote(int dnId) {
		try {
			flag = debitNoteDao.deleteDebitNote(dnId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteDebitNoteLine(int dndId) {
		try {
			flag = debitNoteDao.deleteDebitNoteLine(dndId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchDebitNote(String label, String operator,
			String searchName) {
		try {
			objects = debitNoteDao.basicSearchDebitNote(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchDebitNote(String labels, String opts,
			String advText) {
		List<Object[]> list = null;
		String column[] = labels.split(",");
		String op[] = opts.split(",");
		String advanceSearch[] = advText.split(",");
		String finalStringForSearch = "";
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
						}else{

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
				list = debitNoteDao.advSearchDebitNote(finalStringForSearch);
			} else {
				list = debitNoteDao.searchDebitNote();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

}
