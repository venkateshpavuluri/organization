package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.bean.PaymentTerms;

public class VendorDaoImpl extends HibernateDaoSupport implements VendorDao {
	String success = null;
	int returnId = 0;
	List<Object[]> objects = null;

	public int saveVendor(com.mnt.erp.bean.Vendor mm) {
		try {

			Serializable id = getHibernateTemplate().save(mm);

			returnId = (Integer) id;
		} catch (Exception e) {
			// e.printStackTrace();
			return returnId;
		}
		return returnId;

	}

	public Long getVendorNameDuplicate(String mm) {
		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from Vendor h where h.vendorName='"
					+ mm + "'";
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Long) object;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public int saveVendorBankDet(com.mnt.erp.bean.VendorBankDet mm) {

		try {
			Serializable id = getHibernateTemplate().save(mm);

			returnId = (Integer) id;
		} catch (Exception e) {
			return returnId;
		}
		return returnId;

	}

	public Long checkDuplicateVendorBankDet(String name, String accountNumber,
			int id, int bankId) {

		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from VendorBankDet h where h.bankName='"
					+ name
					+ "' AND h.accountNumber='"
					+ accountNumber
					+ "'  AND  h.vendorBankDetId!="
					+ bankId
					+ " AND h.vendorId=" + id;
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Long) object;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public int saveVendorMaterial(com.mnt.erp.bean.VendorMaterial mm) {

		try {
			Serializable id = getHibernateTemplate().save(mm);

			returnId = (Integer) id;
		} catch (Exception e) {
			return returnId;
		}
		return returnId;

	}

	public int saveVendorAccount(com.mnt.erp.bean.VendorAccountDetails mm) {

		try {
			Serializable id = getHibernateTemplate().save(mm);
			returnId = (Integer) id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnId;

	}

	public int saveVendorDocuments(com.mnt.erp.bean.VendorDocuments mm) {

		try {
			Serializable id = getHibernateTemplate().save(mm);

			returnId = (Integer) id;
		} catch (Exception e) {
			return returnId;
		}
		return returnId;

	}

	@Override
	public List<Object[]> setVendorSearch(String vendor) {
		String hql = null;
		if (vendor.equalsIgnoreCase("ALL")) {
			hql = "select h.vendorId,h.customerId,h.vendorName,h.address,h.city,h.state,h.country,h.zip,h.email,h.phone,h.fax,h.mobile,h.vendGroupId,h.blocked,h.tinNo,h.panNo,h.vatNo,h.serviceTaxNo from Vendor h";

		}

		if (!vendor.equalsIgnoreCase("ALL")) {
			hql = "select h.vendorId,h.customerId,h.vendorName,h.address,h.city,h.state,h.country,h.zip,h.email,h.phone,h.fax,h.mobile,h.vendGroupId,h.blocked,h.tinNo,h.panNo,h.vatNo,h.serviceTaxNo from Vendor h where h.vendorName='"
					+ vendor + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public String getGroupName(String id) {
		String hql = "select h.vendorGroup from VendGroup h where vendorGroup_Id='"
				+ id + "'";
		String name = null;
		List<Object[]> list = getHibernateTemplate().find(hql);
		Iterator it = list.iterator();
		for (Object object : list) {
			name = (String) object;

		}

		return name;

	}

	@Override
	public String getCountryName(String id) {
		String hql = "select h.countryName from CountrysList h where countryId='"
				+ id + "'";
		String name = null;
		List<Object[]> list = getHibernateTemplate().find(hql);

		Iterator it = list.iterator();
		for (Object object : list) {
			name = (String) object;

		}

		return name;

	}

	@Override
	public List<Object[]> setVendorSearch(int id) {

		String hql = "select h.vendorId,h.customerId,h.vendorName,h.address,h.city,h.state,h.country,h.zip,h.email,h.phone,h.fax,h.mobile,h.vendGroupId,h.blocked,h.tinNo,h.panNo,h.vatNo,h.serviceTaxNo,h.statusId from Vendor h  where h.vendorId="
				+ id;

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public List<Object[]> setVendorAdvanceSearch(String vendor) {
		String hql = null;
		if (vendor.equalsIgnoreCase("ALL")) {
			hql = "select h.vendorId,h.customerId,h.vendorName,h.address,h.city,h.state,h.country,h.zip,h.email,h.phone,h.fax,h.mobile,h.vendGroupId,h.blocked,h.tinNo,h.panNo,h.vatNo,h.serviceTaxNo,h.statusId from Vendor h";
		}

		if (!vendor.equalsIgnoreCase("ALL")) {
			hql = "select vendorId,customerId,vendorName,address,city,state,country,zip,email,phone,fax,mobile,vendGroupId,blocked,tinNo,panNo,vatNo,serviceTaxNo,h.statusId from Vendor where "
					+ vendor;
		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public List<Object[]> setVendorBankDetSearch(int id) {

		String hql = "select h.bankName,h.bankAddress,h.micrCode,h.ifscCode,h.accountType,h.accountNumber,h.vendorBankDetId  from VendorBankDet h  where h.vendorId="
				+ id;

		List<Object[]> list = getHibernateTemplate().find(hql);

		Iterator it = list.iterator();

		return list;

	}

	@Override
	public List<Object[]> setVendorDocumentSearch(int id) {

		String hql = "select h.documentName,h.documentPath,h.vendorDocId from VendorDocuments h  where h.vendorId="
				+ id;

		List<Object[]> list = getHibernateTemplate().find(hql);

		Iterator it = list.iterator();

		return list;

	}

	@Override
	public List<Object[]> setVendorMaterialSearch(int id) {
		String hql = "select h.materialId,h.vendorMatId from VendorMaterial h where h.vendorId="
				+ id;

		List<Object[]> list = getHibernateTemplate().find(hql);

		Iterator it = list.iterator();

		return list;

	}

	@Override
	public List<Object[]> setVendorAccountSearch(int id) {

		String hql = " from VendorAccountDetails h where h.vendorId=" + id;

		List<Object[]> list = getHibernateTemplate().find(hql);

		Iterator it = list.iterator();

		return list;

	}

	@Override
	public String updateVendor(Object object) {
		String message = "F";
		try {
			com.mnt.erp.bean.Vendor vendor2 = (com.mnt.erp.bean.Vendor) object;
			getHibernateTemplate().update(vendor2);
			message = "S";
		} catch (Exception e) {
			message = "F";
		}

		return message;
	}

	@Override
	public String UpdateVendorDocuments(Object object) {
		try {
			com.mnt.erp.bean.VendorDocuments vendor2 = (com.mnt.erp.bean.VendorDocuments) object;
			getHibernateTemplate().update(vendor2);

		} catch (Exception e) {
			return "fail";
		}

		return "success";
	}

	@Override
	public String updateVendorBankDet(Object object) {
		try {
			com.mnt.erp.bean.VendorBankDet vendor2 = (com.mnt.erp.bean.VendorBankDet) object;
			getHibernateTemplate().update(vendor2);

		} catch (Exception e) {
			// e.printStackTrace();
			return "fail";
		}

		return "success";
	}

	@Override
	public String updateVendorMaterial(Object object) {
		try {
			com.mnt.erp.bean.VendorMaterial vendor2 = (com.mnt.erp.bean.VendorMaterial) object;
			getHibernateTemplate().update(vendor2);

		} catch (Exception e) {
			return "fail";
		}

		return "success";
	}

	@Override
	public String updateVendorAccount(Object object) {
		try {
			com.mnt.erp.bean.VendorAccountDetails vendor2 = (com.mnt.erp.bean.VendorAccountDetails) object;
			getHibernateTemplate().update(vendor2);

		} catch (Exception e) {
			return "fail";
		}

		return "success";
	}

	public String vendorDelete(int id) {
		String message = "F";
		com.mnt.erp.bean.Vendor vendor = null;
		try {
			vendor = (com.mnt.erp.bean.Vendor) getHibernateTemplate().get(
					com.mnt.erp.bean.Vendor.class, id);
			getHibernateTemplate().delete(vendor);
			message = "S";
		} catch (Exception e) {
			e.printStackTrace();
			message = "F";

		}
		return message;
	}

	public String vendorBankDetDelete(int id) {
		com.mnt.erp.bean.VendorBankDet vendor = null;
		try {
			vendor = (com.mnt.erp.bean.VendorBankDet) getHibernateTemplate()
					.get(com.mnt.erp.bean.VendorBankDet.class, id);
			getHibernateTemplate().delete(vendor);
		} catch (Exception e) {
			return "fail";
		}
		return "success";
	}

	public String vendorDocumentDelete(int id) {
		com.mnt.erp.bean.VendorDocuments vendor = null;
		try {
			vendor = (com.mnt.erp.bean.VendorDocuments) getHibernateTemplate()
					.get(com.mnt.erp.bean.VendorDocuments.class, id);
			getHibernateTemplate().delete(vendor);
		} catch (Exception e) {
			return "fail";
		}
		return "success";
	}

	public String vendorMaterialDelete(int id) {
		com.mnt.erp.bean.VendorMaterial vendor = null;
		try {
			vendor = (com.mnt.erp.bean.VendorMaterial) getHibernateTemplate()
					.get(com.mnt.erp.bean.VendorMaterial.class, id);
			getHibernateTemplate().delete(vendor);
		} catch (Exception e) {
			return "fail";
		}
		return "success";
	}

	public String vendorAccountDelete(int id) {
		com.mnt.erp.bean.VendorAccountDetails vendor = null;
		try {
			vendor = (com.mnt.erp.bean.VendorAccountDetails) getHibernateTemplate()
					.get(com.mnt.erp.bean.VendorAccountDetails.class, id);

			vendor.setPaymentTerm(new PaymentTerms());
			vendor.setPaymentMethod(new PaymentMethod());
			vendor.setAcGroup(new AccountGroupBean());
			getHibernateTemplate().delete(vendor);
		} catch (Exception e) {
			return "fail";
		}
		return "success";
	}

	@Override
	public List<Object[]> vendorIdGet() {
		// TODO Auto-generated method stub
		String hql = "select h.vendorId,h.vendorName from Vendor h ";

		List<Object[]> list = getHibernateTemplate().find(hql);
		return list;
	}

	public List<Object[]> basicSearchVendor(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {

			String hql = "select h.vendorId,h.customerId,h.vendorName,h.address,h.city,h.state,h.country,h.zip,h.email,h.phone,h.fax,h.mobile,h.vendGroupId,h.blocked,h.tinNo,h.panNo,h.vatNo,h.serviceTaxNo from Vendor h where h."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	public Long getVendorNameDuplicateEdit(String mm, int id) {
		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from Vendor h where h.vendorName='"
					+ mm + "' AND h.vendorId!=" + id;
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Long) object;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public List<Object[]> selectAccountGroupIds() {
		// TODO Auto-generated method stub
		try {
			String hql = "select ags.accountgroupid,ags.accountgroup from AccountGroupBean ags";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentTermIds() {
		try {
			String hql = "select ags.paymentTermId,ags.paymentTermName from PaymentTerms ags";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentMethodIds(String type) {
		try {
			String hql = null;
			if (type.equalsIgnoreCase("PaymentMethod")) {
				hql = "select ags.paymentMethodId,ags.paymentMethodName from PaymentMethod ags";
			} else {
				hql = "select ags.statusId,ags.status from Status ags";
			}

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
