package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.MaterialPrice;
import com.mnt.erp.service.AuditLogService;

public class MaterialPriceDaoImpl extends HibernateDaoSupport implements MaterialPriceDao{
	
	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckMaterialPrice(int material,String batchNo,String validFrom,String validTo,int materialPrice_id){

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaterialPrice mp where mp.material_Id='"
					+ material + "' and mp.batchNo='"+batchNo+"' and mp.validFrom<='"+validFrom+"' and mp.validTo>='"+validTo+"' and mp.materialPrice_Id!='" + materialPrice_id + "'";
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

	public Long checkMaterialPrice(int material,String batchNo,String validFrom,String validTo) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaterialPrice mp where mp.material_Id='"
					+ material + "' and mp.batchNo='"+batchNo+"' and mp.validFrom<='"+validFrom+"' and mp.validTo>='"+validTo+"' ";
		
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

	public String saveMaterialPriceDetails(Object object,String userId,String userName) {
		try {
			MaterialPrice materialPriceBean = (MaterialPrice) object;
			Serializable id=getHibernateTemplate().save(object);
			
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Material Price",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchMaterialPrice() {

		try {
			String hql = "select q.materialPrice_Id,q.material,q.batchNo,q.amount,q.currency_Id,q.perUnit,q.validFrom,q.validTo,q.org_Id from MaterialPrice q order by q.material";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchMaterialPriceWithId(int id) {
		try {
			String hql = "select q.materialPrice_Id,q.material_Id,q.batchNo,q.amount,q.currency_Id,q.perUnit,q.validFrom,q.validTo,q.org_Id from MaterialPrice q where q.materialPrice_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateMaterialPrice(Object object) {
		try {
			MaterialPrice updateMaterialPrice = (MaterialPrice) object;
			getHibernateTemplate().update(updateMaterialPrice);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	public String deleteMaterialPrice(int id) {

		try {
			MaterialPrice deleteMaterialPrice = getHibernateTemplate().get(
					MaterialPrice.class, id);
			deleteMaterialPrice.setMaterial(new Material());
			getHibernateTemplate().delete(deleteMaterialPrice);
			msg="S";
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> selectMaterialPrice() {
		String sql = null;
		try {
			sql = "select q.materialPrice_Id,q.material,q.batchNo,q.amount,q.currency_Id,q.perUnit,q.validFrom,q.validTo,q.org_Id from MaterialPrice q";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchMaterialPrice(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.materialPrice_Id,q.material,q.batchNo,q.amount,q.currency_Id,q.perUnit,q.validFrom,q.validTo,q.org_Id from MaterialPrice q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> populateCurrencyIds(){
		
		try {
			String sql = "select c.currencyId,c.currency from Currency c";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
		
	}

}
