/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.InspectionType;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.MaterialCategory;
import com.mnt.erp.bean.MaterialDisplay;
import com.mnt.erp.bean.MaterialInspection;
import com.mnt.erp.bean.MaterialType;
import com.mnt.erp.bean.TaxCategory;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VendorInvoiceLine;
import com.mnt.erp.service.AuditLogService;

/**
 * @author pvenkateswarlu
 * @version 1.0 15-09-2013
 */

public class MaterialDaoImpl extends HibernateDaoSupport implements MaterialDao {
	@Autowired
	AuditLogService auditLogService;

	String msg;
	List<Object[]> objects;
	String sql;
	Iterator<Object> iterator = null;

	List<Object> list = null;
	List<Object[]> lists = null;

	@Override
	public String saveMaterialDetails(Object object, String userId,
			String userName) {
		try {
			Material material = (Material) object;
			Serializable id = getHibernateTemplate().save(material);
			Date date = new Date();
			String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
			auditLogService.setAuditLogSave(userId, "A", "Material", "ROW",
					String.valueOf(id), "1", modifiedDate, userName);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<MaterialDisplay> searchMaterial() {
		List<Object[]> listl = null;
		List<MaterialDisplay> displays = new ArrayList<MaterialDisplay>();
		MaterialType materialType = null;
		MaterialCategory materialCategory = null;
		Uom uomd = null;
		TaxCategory taxCategory = null;
		MaterialDisplay materialDisplay = null;
		try {

			String hql = "select m.material_Id,m.materialCode,m.materialName,m.materialTypeValues,m.uomDetails,m.category from Material m ORDER BY m.materialName";

			listl = getHibernateTemplate().find(hql);

			Iterator<Object[]> iterator = listl.iterator();
			while (iterator.hasNext()) {

				Object[] object = (Object[]) iterator.next();
				materialDisplay = new MaterialDisplay();
				materialDisplay.setMaterial_Id((Integer) object[0]);
				materialDisplay.setMaterialCodeName((String) object[1]);
				materialDisplay.setMaterialName((String) object[2]);
				materialType = (MaterialType) object[3];
				materialDisplay.setMaterialTypeName(materialType
						.getMaterialTypeName());
				materialCategory = (MaterialCategory) object[5];
				materialDisplay.setMaterialCategoryName(materialCategory
						.getMaterialCategory());
				uomd = (Uom) object[4];
				materialDisplay.setUomName(uomd.getUom());

				displays.add(materialDisplay);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return displays;
	}

	public List<Object> searchMaterialWithId(int id) {
		List<Object> objects = null;
		try {

			String hql = "from Material m where m.material_Id="
					+ id + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateMaterial(Object object) {
		try {
			Material material = (Material) object;

			getHibernateTemplate().update(material);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	public String materialDelete(int id) {
		Material material = null;
		try {
			material = (Material) getHibernateTemplate()
					.get(Material.class, id);
			material.setCategory(new MaterialCategory());
			material.setMaterialTypeValues(new MaterialType());
			material.setTaxCategory(new TaxCategory());
			material.setUomDetails(new Uom());
			getHibernateTemplate().delete(material);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> selectMaterialIds() {
		String sql = null;
		try {
			sql = "select m.material_Id,m.materialCode from Material m";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public Long duplicateCheck(String materialName) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Material m where  m.materialName='"
					+ materialName + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Long updateDuplicateCheck(String materialName, int materialId) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Material m where  m.materialName='"
					+ materialName + "' and m.material_Id!=" + materialId + "";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Object[]> getMaterialNameIds() {
		String sql = null;
		try {
			sql = "select m.material_Id,m.materialName from Material m";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> materialIdGet() {
		// TODO Auto-generated method stub
		String hql = "select m.material_Id,m.materialName from Material m ";

		List<Object[]> list = getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Object[]> basicSearchMaterial(String label, String operator,
			String searchName) {
		try {

			String hql = "select m.material_Id,m.materialCode,m.materialName,m.materialTypeValues,m.uomDetails,m.taxCategory,m.category from Material m where m."
					+ label + "" + operator + " ? ORDER BY m.materialName";

			Object[] parameters = { searchName };
			lists = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Object[]> getMaterialNameIds(String name) {
		String sql = null;
		try {

			sql = "select m.material_Id,m.materialName from Material m where  lower(m.materialName) like '"
					+ name + "%'";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> getMaterialNameEdit(int id) {
		String sql = null;
		try {
			// System.out.println(name);
			sql = "select m.materialName,m.material_Id from Material m where m.material_Id="
					+ id;
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public int materialStockGet(int materialId) {
		int f = 0;
		try {
			String hql = "select m.stock from Material m where m.material_Id="
					+ materialId + "";
			// f=getHibernateTemplate().find(hql);
			list = getHibernateTemplate().find(hql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				f = (Integer) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public String materialStockUpdate(final int materialId, final float stock) {

		getHibernateTemplate().executeFind(new HibernateCallback() {

			List<Object> listl = null;

			public Object doInHibernate(org.hibernate.Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub

				String hql = "update Material  set stock=" + stock
						+ "  where material_Id=" + materialId + "";
				Query query = session.createQuery(hql);
				query.executeUpdate();
				return listl;
			}
		});
		msg = "MaterialDetails Updated Successfully";
		return msg;

	}

	@Override
	public String deleteChildDetails(int cid) {
		try{
			//System.out.println("cid isss==="+cid);
			MaterialInspection mibean=(MaterialInspection)getHibernateTemplate().get(MaterialInspection.class, cid);
			mibean.setItbean(new InspectionType());
			getHibernateTemplate().delete(mibean);
		 // System.out.println("del"+rfbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Material Details Deleted Successfully";
	}

	

}
