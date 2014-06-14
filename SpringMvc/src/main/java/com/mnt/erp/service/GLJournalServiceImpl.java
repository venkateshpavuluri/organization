/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.dao.GLJournalDao;

/**
 * @author Naresh
 * @version 1.0 04-01-2014
 */
public class GLJournalServiceImpl implements GLJournalService {

	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;
	@Autowired
	DateConversionService dateService;

	GLJournalDao glJournalDao;

	public GLJournalDao getGlJournalDao() {
		return glJournalDao;
	}

	public void setGlJournalDao(GLJournalDao glJournalDao) {
		this.glJournalDao = glJournalDao;
	}

	@Override
	public boolean saveGLJournal(Object object) {
		try {

			flag = glJournalDao.saveGLJournal(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchGLJournal() {
		try {
			objects = glJournalDao.searchGLJournal();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchGLJournalWithId(int glId) {
		try {
			obj = glJournalDao.searchGLJournalWithId(glId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateGLJournal(Object object) {
		try {
			flag = glJournalDao.updateGLJournal(object);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteGLJournal(int glId) {
		try {
			flag = glJournalDao.deleteGLJournal(glId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteGLJournalLine(int gljId) {
		try {
			flag = glJournalDao.deleteGLJournalLine(gljId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchGLJournal(String label, String operator,
			String searchName) {
		try {
			objects = glJournalDao.basicSearchGLJournal(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchGLJournal(String labels, String opts,
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
								finalStringForSearch += " and glj."
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
								finalStringForSearch += " and glj." + column[i]
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
				list = glJournalDao.advSearchGLJournal(finalStringForSearch);
			} else {
				list = glJournalDao.searchGLJournal();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

}
