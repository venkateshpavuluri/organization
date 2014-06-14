/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ticketTypeDao;

/**
 * @author devi
 *
 */
public class ticketTypeServiceImpl implements ticketTypeService {
	ticketTypeDao tDao;

	public ticketTypeDao gettDao() {
		return tDao;
	}

	public void settDao(ticketTypeDao tDao) {
		this.tDao = tDao;
	}
	public String msg;
	List<Object[]> objects;

	public Long checkTicketTypeCount(String ticketType) {
		Long l = tDao.checkTicketTypeCount(ticketType);
		return l;
	}
	public Long updateCheckTicketType(String ticketType,int ticketTypeId) {
		Long l = tDao.updateCheckTicketType(ticketType, ticketTypeId);
		return l;
	}
	
	public String saveTicketTypeDetails(Object object,String userId,String userName) {
		try {
			msg = tDao.saveTicketTypeDetails(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

	public List<Object[]> searchTicketType() {
		
		try {
			objects = tDao.searchTicketType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchTicketTypeWithId(int id) {
		List<Object[]> list = null;
		try {
			list = tDao.searchTicketTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateTicketType(Object object) {
		try {
			msg = tDao.updateTicketType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String deleteTicketType(int id) {
		try {
			msg = tDao.deleteTicketType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

	
	public List<Object[]> basicSearchTicketType(String label,String operator,String searchName){
		try {
			objects = tDao.basicSearchTicketType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}


}
