/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.DeliveryNote;

/**
 * @author venkateshp
 * 
 */
public interface DeliveryNoteService {

	public String saveDeliveryNote(Object object);

	public List<Object[]> searchDeliveryNote();

	public List<Object[]> basicSearchDeliveryservice(String dbField,
			String operation, String basicSearchId);

	public List<DeliveryNote> editDeliveryNoteDetails(int deliveryNoteId);

	public String updateDeliveryDetails(Object object);

	public String deleteChildRecords(Object object);

	public String deleteDeliveryNote(int deliveryId);

	public List<Object[]> deliveryadvance(String columns, String operations,
			String advanceSearchText);

	public List<Object[]> getDelivery(String rfq);
}
