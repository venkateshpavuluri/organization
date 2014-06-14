/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mnt.erp.bean.Code;
import com.mnt.erp.bean.CodeGroup;
import com.mnt.erp.bean.DefectClassBean;
import com.mnt.erp.bean.DefectTypeBean;
import com.mnt.erp.bean.InspCharacteristic;
import com.mnt.erp.bean.InspLotIndResBean;
import com.mnt.erp.bean.InspLotIndResLine;
import com.mnt.erp.bean.InspectionLotBean;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.Uom;

/**
 * @author Naresh
 * @version 1.0 17-05-2014
 */
@Repository("inspLotIndResDao")
public class InspLotIndResDaoImpl extends CustomHibernateDaoSupport implements
		InspLotIndResDao {

	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public boolean saveInspLotIndRes(Object object) {
		try {
			InspLotIndResBean inspBean = (InspLotIndResBean) object;
			getHibernateTemplate().save(inspBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchInspLotIndRes() {
		try {
			String hql = "select cb.inspLotIndResId,cb.inspect,cb.inspected,cb.inspLotBean,cb.processDetail,cb.inspLotId,cb.processDetailId from InspLotIndResBean cb";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchInspLotIndResWithId(int inspId) {
		try {
			String hql = "from InspLotIndResBean cbd where cbd.inspLotIndResId="
					+ inspId + " ";
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateInspLotIndRes(Object object) {
		try {
			InspLotIndResBean popBeanUp = (InspLotIndResBean) object;
			InspLotIndResBean cBean = (InspLotIndResBean) getHibernateTemplate()
					.get(InspLotIndResBean.class,
							popBeanUp.getInspLotIndResId());
			for (InspLotIndResLine cbDelete : cBean.getInspLotIndResList()) {
				cbDelete.setCodeBean(new Code());
				cbDelete.setCodeGrpBean(new CodeGroup());
				cbDelete.setDefClsBean(new DefectClassBean());
				cbDelete.setDefTypeBean(new DefectTypeBean());
				cbDelete.setInspCharBean(new InspCharacteristic());
				cbDelete.setUomBean(new Uom());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().update(popBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspLotIndRes(int inspId) {
		try {
			InspLotIndResBean inspBean = new InspLotIndResBean();
			inspBean.setInspLotIndResId(inspId);
			InspLotIndResBean cBean = (InspLotIndResBean) getHibernateTemplate()
					.get(InspLotIndResBean.class, inspBean.getInspLotIndResId());
			for (InspLotIndResLine cbDelete : cBean.getInspLotIndResList()) {
				cbDelete.setCodeBean(new Code());
				cbDelete.setCodeGrpBean(new CodeGroup());
				cbDelete.setDefClsBean(new DefectClassBean());
				cbDelete.setDefTypeBean(new DefectTypeBean());
				cbDelete.setInspCharBean(new InspCharacteristic());
				cbDelete.setUomBean(new Uom());
				getHibernateTemplate().delete(cbDelete);
			}
			inspBean.setProcessDetail(new ProcessDetailBean());
			inspBean.setInspLotBean(new InspectionLotBean());

			getHibernateTemplate().delete(inspBean);

		} catch (Exception e) {

			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public boolean deleteInspLotIndResLine(int inspLineId) {
		try {
			InspLotIndResLine cbDelete = (InspLotIndResLine) getHibernateTemplate()
					.get(InspLotIndResLine.class, inspLineId);
			cbDelete.setCodeBean(new Code());
			cbDelete.setCodeGrpBean(new CodeGroup());
			cbDelete.setDefClsBean(new DefectClassBean());
			cbDelete.setDefTypeBean(new DefectTypeBean());
			cbDelete.setInspCharBean(new InspCharacteristic());
			cbDelete.setUomBean(new Uom());
			getHibernateTemplate().delete(cbDelete);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchInspLotIndRes(String label,
			String operator, Double searchName) {
		try {

			String hql = "select cb.inspLotIndResId,cb.inspect,cb.inspected,cb.inspLotBean,cb.processDetail,cb.inspLotId,cb.processDetailId from InspLotIndResBean cb where cb."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchInspLotIndRes(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select cb.inspLotIndResId,cb.inspect,cb.inspected,cb.inspLotBean,cb.processDetail,cb.inspLotId,cb.processDetailId from InspLotIndResBean cb where cb."
					+ advSearch + "";

		} else {
			hql = "select cb.inspLotIndResId,cb.inspect,cb.inspected,cb.inspLotBean,cb.processDetail,cb.inspLotId,cb.processDetailId from InspLotIndResBean cb";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
