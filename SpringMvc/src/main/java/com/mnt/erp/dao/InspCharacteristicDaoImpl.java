/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.InspCharacteristic;
import com.mnt.erp.bean.InspCharacteristicMethod;
import com.mnt.erp.bean.InspectionMethodBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;


/**
 * @author kirangangone	
 * @version 1.0
   @build 0.0
 * 
 *
 */
public class InspCharacteristicDaoImpl extends HibernateDaoSupport implements InspCharacteristicDao
{
	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;
	
	

	@Override
	public String saveInspCharacteristic(Object object,String userId,String userName)
	{
		// TODO Auto-generated method stub

		try
		{
			
			InspCharacteristic inspCharacteristic=(InspCharacteristic)object;
			Serializable id=getHibernateTemplate().save(inspCharacteristic);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Insp Characteristic",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
			
		}
		return msg;
	}
  
	

	public List<Object> editInspCharacteristicWithId(int Id) {
		try {
		//	System.out.println("editPoWith id "+Id);
			String hql = "from InspCharacteristic i where i.inspCharacteristicId="+Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public List<Object[]> basicSearchInspCharacteristic(String label, String operator,String searchName,String advBasic) {
		List<Object[]> objs = null;
		String hql =null;
		try {
			
			if(label=="" && operator=="" && searchName=="" && advBasic=="")
			{
				hql = "select i.inspCharacteristicId,i.inspCharacteristicCode,i.inspCharacteristic,i.uomId,i.validFrom,i.characteristicTypeId,i.rules,i.uomDetails,i.characteristicType from InspCharacteristic i ";
				objs = getHibernateTemplate().find(hql);
				//System.out.println("In Empty serch "+hql);
			}
			else
			if(label=="" && operator=="" && searchName=="" && advBasic!="")
			{
				hql = "select i.inspCharacteristicId,i.inspCharacteristicCode,i.inspCharacteristic,i.uomId,i.validFrom,i.characteristicTypeId,i.rules,i.uomDetails,i.characteristicType from InspCharacteristic i  where " +advBasic;
				objs = getHibernateTemplate().find(hql);
				//System.out.println("AdvBasic Search-------->"+objs);
			}
			else
			if(label!="" && operator!="" && searchName!="" && advBasic=="")
			{
				hql = "select i.inspCharacteristicId,i.inspCharacteristicCode,i.inspCharacteristic,i.uomId,i.validFrom,i.characteristicTypeId,i.rules,i.uomDetails,i.characteristicType from InspCharacteristic i where i."
					+ label + "" + operator + " ? ";
				Object[] parameters = { searchName };
				objs = getHibernateTemplate().find(hql, parameters);
				//System.out.println("In searchName!= && advBasic!= serch "+hql);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	@Override
	public String updateInspCharacteristic(Object object) {
		
		
		try {
			InspCharacteristic inspCharacteristic = (InspCharacteristic) object;
			
			getHibernateTemplate().update(inspCharacteristic);
			msg="S";
			
		} catch (Exception e) {
		   msg="F";
			e.printStackTrace();
			
		}
		return msg;
	}
	
	
	public int checkInspCharacteristic(String checkValue, String id) {
		try {
			
			String sql=null; 
			
			
			if(id=="")
			{
			sql= "select count(*) from InspCharacteristic cb where  cb.inspCharacteristic='"
					+ checkValue + "'";
			//System.out.println("Empty Id");
			}
			else
			{
				sql= "select count(*) from InspCharacteristic cb where  cb.inspCharacteristic='"
						+ checkValue + "' and cb.inspCharacteristicId!='" + id + "'";
				//System.out.println("Non Empty Id");
			}
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l.intValue();

	}

	
	
	
	public String deleteInspCharacteristic(int id,String mainOrSub) {
		
		
		try {
			
			if(mainOrSub.equalsIgnoreCase("Sub"))
			{
			
				com.mnt.erp.bean.InspCharacteristicMethod purchaseOrderLine = null;
				try {
					purchaseOrderLine = (com.mnt.erp.bean.InspCharacteristicMethod) getHibernateTemplate().get(
							com.mnt.erp.bean.InspCharacteristicMethod.class, id);
					purchaseOrderLine.setInspectionMethodBeanDetails(new InspectionMethodBean());
					getHibernateTemplate().delete(purchaseOrderLine);
					msg="S";
			      
				} catch (Exception e) {
					msg="F";
					 e.printStackTrace();
					
				}
				return msg;
			}
			else{
				InspCharacteristic inspCharacteristic=new InspCharacteristic();
				inspCharacteristic.setInspCharacteristicId(id);
		InspCharacteristic characteristic=(InspCharacteristic)getHibernateTemplate().get(InspCharacteristic.class, id);
				Set<InspCharacteristicMethod> characteristicMethods=characteristic.getInspCharacteristicMethodGroupDetails();
				getHibernateTemplate().deleteAll(characteristicMethods);
				
				getHibernateTemplate().delete(inspCharacteristic);
			
			
			}
			/*InspCharacteristic inspCharacteristic=new InspCharacteristic();
			inspCharacteristic.setInspCharacteristicId(id);
	InspCharacteristic characteristic=(InspCharacteristic)getHibernateTemplate().get(InspCharacteristic.class, id);
			List<InspCharacteristicMethod> characteristicMethods=characteristic.getInspCharacteristicMethodGroupDetails();
			getHibernateTemplate().deleteAll(characteristicMethods);
			
			getHibernateTemplate().delete(inspCharacteristic);*/
			msg="S";
			//System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return msg;
	}
	
	
	public List<Object[]> inspectionMethodSelect() {
		List<Object[]> list=null;
		try{
			String hql="select i.inspectionmethodid,i.inspectionmethod from InspectionMethodBean i";
			//System.out.println("sssss Came to Inspr");
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
	}
	public List<Object[]> charactersticTypeSelect(){
		List<Object[]> list=null;
		try{
			String hql="select i.characteristicType_Id,i.characteristicType from CharacteristicType i";
			//System.out.println("sssss Came to Inspr");
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
	}
}
