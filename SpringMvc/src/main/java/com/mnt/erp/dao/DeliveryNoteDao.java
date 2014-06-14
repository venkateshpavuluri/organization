/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.DeliveryNote;

/**
 * @author venkateshp
 *
 */
public interface DeliveryNoteDao {
	
	public String saveDeliveryNote(Object object);
	public List<Object[]> searchDeliveryNote();
	public List<Object[]> basicSearchRfqservice(String dbField,String operation,String basicSearchId);
	public List<DeliveryNote> editDeliveryNoteDetails(int deliveryNoteId);
	public String updateDeliveryDetails(Object object);
	public String deleteChildRecords(Object object);
	public String deleteDeliveryNote(int deliveryId);
	public List<Object[]> setDeliveryAdvanceSearch(String name);
	public List<Object[]> setDeliverySearch(String name);
	
}
