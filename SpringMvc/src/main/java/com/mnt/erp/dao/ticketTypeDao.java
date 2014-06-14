/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author devi
 *
 */
public interface ticketTypeDao {
	public Long updateCheckTicketType(String ticketType,int ticketTypeId);

	public Long checkTicketTypeCount(String ticketType);
	
	public String saveTicketTypeDetails(Object object,String userId,String userName);

	public List<Object[]> searchTicketType();

	public List<Object[]> searchTicketTypeWithId(int id);

	public String updateTicketType(Object object);

	public String deleteTicketType(int id);
	
	public List<Object[]> basicSearchTicketType(String label,String operator,String searchName);


}
