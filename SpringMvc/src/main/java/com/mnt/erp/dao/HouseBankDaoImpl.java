package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.HouseBankBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.service.AuditLogService;


public class HouseBankDaoImpl extends HibernateDaoSupport implements HouseBankDao {
	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	List<Object[]> hblist=null;
	List <Object> hb1list=null;
	List<HouseBankBean> hb2list=null;
	@Override
	public String saveHouseBank(Object object,String userId,String userName) {
		try{
			HouseBankBean hb=(HouseBankBean) object;
			
			Serializable id=getHibernateTemplate().save(hb);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Code Group",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		}catch(Exception e){
			msg="F";
			e.printStackTrace();
			
		}
		return msg;
	}

	
	@Override
	public List<Object[]> searchHouseBank() {
		try{
			String hql="select r.bankid,r.orgbean,r.bankcode,r.bankname,r.branchname,r.address,r.city,r.state,r.countrybean,r.swiftcode,r.ifsccode from HouseBankBean r order by r.bankname";
			hblist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return hblist;
	}

	@Override
	public List<Object[]> selectHouseBankIds() {
		try{
			String hql="select r.bankid,r.orgid,r.bankcode,r.bankname,r.branchname,r.address,r.city,r.state,r.country,r.swiftcode,r.ifsccode from HouseBankBean r";
			hblist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return hblist;
	}
	@Override
	public List<Object[]> selectOrgid() {
		try{
			String hql="select i.orgId,i.orgName from Organization i";
			hblist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return hblist;
	}

	@Override
	public List<Object[]> selectCountryid() {
		try{
			String hql="select c.countryId,c.countryName from CountrysList c";
			hblist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return hblist;
	}
	@Override
	public String updateHouseBank(Object object) {
		try {
			HouseBankBean bean = (HouseBankBean) object;
			getHibernateTemplate().update(bean);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteHouseBank(int id) {
		try {
			HouseBankBean hbBean = (HouseBankBean) getHibernateTemplate().get(HouseBankBean.class, id);
			hbBean.setOrgbean(new Organization());
			hbBean.setCountrybean(new CountrysList());
			getHibernateTemplate().delete(hbBean);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getHouseBankCount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from HouseBankBean ab where ab.bankcode='"
					+ name + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Long getHouseBankCountedit(String name, int hbid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from HouseBankBean ab where ab.bankcode='"
					+ name + "'and ab.bankid!='" + hbid + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Object[]> basicSearchHouseBank(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.bankid,r.orgbean,r.bankcode,r.bankname,r.branchname,r.address,r.city,r.state,r.countrybean,r.swiftcode,r.ifsccode from HouseBankBean r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			hblist = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hblist;
	}


	@Override
	public List<Object[]> searchHouseBankWithId(int id) {
		try{
			String hql="select r.bankid,r.orgbean,r.bankcode,r.bankname,r.branchname,r.address,r.city,r.state,r.countrybean,r.swiftcode,r.ifsccode from HouseBankBean r where r.bankid="+id+"";
			hblist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hblist;
	}


	@Override
	public List<HouseBankBean> Edithb(int iid) {
		try{
			String hql="from HouseBankBean pb where pb.bankid="+iid+"";
			hb2list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return hb2list;
	}

	

}
