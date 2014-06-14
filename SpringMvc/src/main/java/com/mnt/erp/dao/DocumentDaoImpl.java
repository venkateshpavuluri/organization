package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Document;
import com.mnt.erp.bean.DocumentCategory;
import com.mnt.erp.bean.DocumentObject;
import com.mnt.erp.bean.DocumentType;
import com.mnt.erp.bean.ObjectBean;
import com.mnt.erp.bean.Status;

public class DocumentDaoImpl extends HibernateDaoSupport implements DocumentDao{
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckDocument(String equipment,int id) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from Document at where  at.documentName ='"
					+ equipment + "' and at.documentId!='" + id + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public Long checkDocument(String equipment) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from Document g where  g.documentName='"
					+ equipment + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public String saveDocumentDetails(Object object) {
		try {
			Document DocumentBean = (Document) object;
			Serializable id=getHibernateTemplate().save(DocumentBean);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchDocument() {

		try {
			String hql = "select d.documentId,d.documentName,d.documentNo,d.documentCategory,d.documentType,d.status,d.path from Document d";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Document> searchDocumentWithId(int id) {
		List<Document> object=null;
		try {
			String hql = "from Document r where r.documentId="
					+ id + " ";
			object = getHibernateTemplate().find(hql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public String updateDocument(Object object) {
			
		DocumentObject pc = null;
		Iterator<DocumentObject> iterator1 = null;
		DocumentObject pLine = null;
		List<DocumentObject> list2 = null;
		try {

			Document pg = (Document) object;
			int id = pg.getDocumentId();
			System.out.println("the dao id is:"+id);
			

			Document po = (Document) getHibernateTemplate().get(
					Document.class, id);
			list2 = po.getDocumentObject();

			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (DocumentObject) o;
				pc = new DocumentObject();
				System.out.println("fddf"+pLine.getDocumentObjectId());
				pc.setDocumentObjectId(pLine.getDocumentObjectId());
			
		
			pc.setObjectBean(new ObjectBean());
			
			
				
				//getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}

	public String deleteDocument(int id) {
	
		DocumentObject emp=null;
	List<DocumentObject> list=null;
	try {
		list=new ArrayList<DocumentObject>();
		Document empbean=(Document)getHibernateTemplate().get(Document.class, id);
		empbean.setDocumentCategory(new DocumentCategory());
		empbean.setDocumentType(new DocumentType());
		
		empbean.setStatus(new Status());
		
		List<DocumentObject> beans=empbean.getDocumentObject();
		Iterator<DocumentObject> iterator=beans.iterator();
		while(iterator.hasNext())

		{
			
			emp=(DocumentObject)iterator.next();
			emp.setObjectBean(new ObjectBean());
			
	
			list.add(emp);
		}
		empbean.setDocumentObject(list);

	getHibernateTemplate().delete(empbean);
	msg="S";

		
	} catch (Exception e) {
		msg="F";
		e.printStackTrace();

	}
	return msg;
			}


	public List<Object[]> selectStatus() {
		String sql = null;
		try {
			sql = "select statusId,status from Status";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectEquipment() {
		String sql = null;
		try {
			sql = "select equipmentId,equipmentName from EquipmentBean";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectMaintenanceCategory() {
		String sql = null;
		try {
			sql = "select maintenanceCategoryId,maintenanceCategory from MaintenanceCategory";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectMaintenanceType() {
		String sql = null;
		try {
			sql = "select maintenanceTypeId,maintenanceType from maintenanceTypeBean";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	
	
	public List<Object[]> basicSearchDocument(String label, String operator,
			String searchName) {
		try {

			String hql = "select d.documentId,d.documentName,d.documentNo,d.documentCategory,d.documentType,d.status,d.path from Document d where d."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public String deleteDocumentDetail(int kk){
		// TODO Auto-generated method stub
		try {
			
			/*DocumentSchCat line=new DocumentSchCat();
			line.setDocumentSchCatId(kk);
			line.setMaintenanceCategory(new MaintenanceCategory());
			line.setMaintenanceTypeDetails(new maintenanceTypeBean());
					
			getHibernateTemplate().delete(line);*/
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

}
