/**
 * 
 */
package com.mnt.erp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.dao.DeliveryNoteDao;

/**
 * @author venkateshp
 * 
 */
public class DeliveryNoteServiceImpl implements DeliveryNoteService {
	String msg = null;
	List<Object[]> list = null;
	@Autowired
	DateConversionService dateService;

	DeliveryNoteDao deliveryNoteDao;

	public DeliveryNoteDao getDeliveryNoteDao() {
		return deliveryNoteDao;
	}

	public void setDeliveryNoteDao(DeliveryNoteDao deliveryNoteDao) {
		this.deliveryNoteDao = deliveryNoteDao;
	}

	@Override
	public String saveDeliveryNote(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = deliveryNoteDao.saveDeliveryNote(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchDeliveryNote() {
		// TODO Auto-generated method stub
		try {
			// it is used search the Delivery Note Details
			list = deliveryNoteDao.searchDeliveryNote();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> basicSearchDeliveryservice(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		try {
			// it is used search the Delivery Note Details by using basicSearch

			list = deliveryNoteDao.basicSearchRfqservice(dbField, operation,
					basicSearchId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<DeliveryNote> editDeliveryNoteDetails(int deliveryNoteId) {
		// TODO Auto-generated method stub
		Iterator<Object[]> iterator = null;
		List<DeliveryNote> deliveryNotes = null;
		try {
			deliveryNotes = deliveryNoteDao
					.editDeliveryNoteDetails(deliveryNoteId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return deliveryNotes;
	}

	@Override
	public String updateDeliveryDetails(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = deliveryNoteDao.updateDeliveryDetails(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteChildRecords(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = deliveryNoteDao.deleteChildRecords(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteDeliveryNote(int deliveryId) {
		// TODO Auto-generated method stub
		try {
			msg = deliveryNoteDao.deleteDeliveryNote(deliveryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> deliveryadvance(String columns, String operations,
			String advanceSearchText) {
		List<Object[]> lists = null;
		try {

			String column[] = columns.split(",");
			String op[] = operations.split(",");
			String advanceSearch[] = advanceSearchText.split(",");
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
						boolean flag = dateService.isThisDateValid(advanceSearch[i]);
								
						if (flag == true) {
							if (count > 0) {
								finalStringForSearch += " and d." + column[i] + " "
										+ op[i] + "'" + dateService.dateFormat(dateService.dateParse(advanceSearch[i], "au"), "au") + "'";
							} else {
								finalStringForSearch += column[i] + " " + op[i]
										+ "'" + dateService.dateFormat(dateService.dateParse(advanceSearch[i], "au"), "au") + "'";
								count++;
							}
						}else{
							if (count > 0) {
								finalStringForSearch += " and d." + column[i] + " "
										+ op[i] + "'" + advanceSearch[i] + "'";
							} else {
								finalStringForSearch += column[i] + " " + op[i] + "'"
										+ advanceSearch[i] + "'";
								count++;
							}
						}
						

					}
				}

			}

			if (finalStringForSearch.length() > 0) {
				lists = deliveryNoteDao
						.setDeliveryAdvanceSearch(finalStringForSearch);
			} else {
				lists = deliveryNoteDao.setDeliverySearch("ALL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;

	}

	@Override
	public List<Object[]> getDelivery(String delivery) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = deliveryNoteDao.setDeliverySearch(delivery);
		} catch (Exception e) {

		}
		return list;
	}
}
