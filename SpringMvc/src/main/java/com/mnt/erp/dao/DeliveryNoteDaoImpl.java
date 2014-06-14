/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.DeliveryNoteLine;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.Uom;

/**
 * @author venkateshp
 * 
 */
public class DeliveryNoteDaoImpl extends HibernateDaoSupport implements
		DeliveryNoteDao {
	String msg = null;
	List<Object[]> list = null;
	String sql = null;
	static Logger logger = Logger.getLogger(DeliveryNoteDaoImpl.class);

	public String saveDeliveryNote(Object object) {

		try {
			DeliveryNote deliveryNote = (DeliveryNote) object;
			getHibernateTemplate().save(deliveryNote);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public List<Object[]> searchDeliveryNote() {
		// TODO Auto-generated method stub
		try {
			sql = "select d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.salesOrderDetails from com.mnt.erp.bean.DeliveryNote d ";
			list = getHibernateTemplate().find(sql);
			logger.info("with in thw dao deliveryNote list iss==" + list);// ,d.statusDetails
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> basicSearchRfqservice(String dbField,
			String operation, String basicSearchId) {
		try {
			sql = "select d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.salesOrderDetails from com.mnt.erp.bean.DeliveryNote d where d."
					+ dbField + "" + operation + " ? ";
			Object[] parameters = { basicSearchId };
			list = getHibernateTemplate().find(sql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<DeliveryNote> editDeliveryNoteDetails(int deliveryNoteId) {
		List<DeliveryNote> deliveryNotes = null;
		try {
			// sql="select d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.salesOrderDetails,d.deliveryNotes from com.mnt.erp.bean.DeliveryNote d where d.deliveryNoteId="+deliveryNoteId+"";
			sql = "from com.mnt.erp.bean.DeliveryNote d where d.deliveryNoteId="
					+ deliveryNoteId + "";
			deliveryNotes = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return deliveryNotes;
	}

	@Override
	public String updateDeliveryDetails(Object object) {
		String messagesg = null;
		try {
			DeliveryNote deliveryNote = (DeliveryNote) object;
			/*
			 * DeliveryNote
			 * notedetails=(DeliveryNote)getHibernateTemplate().get(
			 * DeliveryNote.class,deliveryNote.getDeliveryNoteId());
			 * Set<DeliveryNoteLine>
			 * deliveryNoteLines=notedetails.getDeliveryNotes();
			 * getHibernateTemplate().deleteAll(deliveryNoteLines);
			 */

			getHibernateTemplate().update(deliveryNote);
			messagesg = "S";
		} catch (Exception e) {
			messagesg = "F";
			e.printStackTrace();
		}
		return messagesg;
	}

	public String deleteChildData(Object object) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteChildRecords(Object object) {
		// TODO Auto-generated method stub
		try {
			List<DeliveryNoteLine> integers = (List<DeliveryNoteLine>) object;
			if (integers != null) {
				getHibernateTemplate().deleteAll(integers);
				msg = "child Rows Deleted Successfully";
			}

		} catch (Exception e) {
			msg = "child Rows Did Not Deleted ";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteDeliveryNote(int deliveryId) {
		// TODO Auto-generated method stub
		DeliveryNote deliveryNote = null;
		try {
			DeliveryNote deliveryNote2 = new DeliveryNote();
			deliveryNote2.setDeliveryNoteId(deliveryId);

			DeliveryNote deliveryNotes = new DeliveryNote();
			deliveryNotes.setDeliveryNoteId(deliveryId);
			deliveryNote = (DeliveryNote) getHibernateTemplate().get(
					DeliveryNote.class, deliveryId);
			Set<DeliveryNoteLine> deliveryNoteLines = deliveryNote
					.getDeliveryNotes();

			getHibernateTemplate().deleteAll(deliveryNoteLines);

			/*
			 * Iterator<DeliveryNoteLine> iterator=deliveryNoteLines.iterator();
			 * while(iterator.hasNext()) { DeliveryNoteLine
			 * line=(DeliveryNoteLine)iterator.next(); DeliveryNoteLine
			 * deliveryNoteLine=new DeliveryNoteLine();
			 * logger.info("delete line id iss are==="
			 * +line.getDeliveryNoteLineId());
			 * deliveryNoteLine.setDeliveryNoteLineId
			 * (line.getDeliveryNoteLineId());
			 * getHibernateTemplate().delete(deliveryNoteLine);
			 * 
			 * }
			 */

			// deliveryNote.setDeliveryNoteId(deliveryId);
			deliveryNote2.setSalesOrderDetails(new SalesOrderBean());
			deliveryNote2.setUomDetails(new Uom());
			getHibernateTemplate().delete(deliveryNote2);
			msg = "S";

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}

		return msg;
	}

	@Override
	public List<Object[]> setDeliveryAdvanceSearch(String name) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {

			String hql = null;
			if (name.equalsIgnoreCase("ALL")) {
				hql = "select d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.salesOrderDetails from com.mnt.erp.bean.DeliveryNote d ";

			}

			if (!name.equalsIgnoreCase("ALL")) {
				hql = "select d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.salesOrderDetails from com.mnt.erp.bean.DeliveryNote d where d."
						+name;
			}

			list = getHibernateTemplate().find(hql);

			return list;

		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<Object[]> setDeliverySearch(String name) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			if (name.equalsIgnoreCase("ALL")) {
				sql = "select d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.salesOrderDetails from com.mnt.erp.bean.DeliveryNote d";

			}

			if (!name.equalsIgnoreCase("ALL")) {
				sql = "select d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.salesOrderDetails from com.mnt.erp.bean.DeliveryNote d where d.deliveryNoteId='"
						+ name + "'";

			}
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {

		}
		return list;
	}

}
