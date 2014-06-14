/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.GLFiscalYear;
import com.mnt.erp.bean.GLJournalBean;
import com.mnt.erp.bean.GLJournalLine;
import com.mnt.erp.bean.Organization;

/**
 * @author Naresh
 * @version 1.0 04-01-2014
 * 
 */
public class GLJournalDaoImpl extends HibernateDaoSupport implements
		GLJournalDao {

	boolean flag = true;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public boolean saveGLJournal(Object object) {
		try {
			GLJournalBean gljBean = (GLJournalBean) object;
			getHibernateTemplate().save(gljBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchGLJournal() {
		try {
			String hql = "select glj.glAccountId,glj.glAccountDT,glj.postingDT,glj.reference,glj.orgId,glj.currencyId,glj.glFiscalYearId,glj.description,glj.glFiscalYear,glj.currency,glj.organization from GLJournalBean glj";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchGLJournalWithId(int glId) {
		try {
			String hql = "from GLJournalBean dn where dn.glAccountId='" + glId
					+ "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateGLJournal(Object object) {
		try {
			GLJournalBean gljBeanUp = (GLJournalBean) object;
			GLJournalBean dBean = (GLJournalBean) getHibernateTemplate().get(
					GLJournalBean.class, gljBeanUp.getGlAccountId());
			for (GLJournalLine gljDelete : dBean.getGlJournalLine()) {
				gljDelete.setCurncy(new Currency());
				gljDelete.setAccGroup(new AccountGroupBean());
				getHibernateTemplate().delete(gljDelete);
			}
			getHibernateTemplate().update(gljBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteGLJournal(int glId) {
		try {
			GLJournalBean jb = new GLJournalBean();
			jb.setGlAccountId(glId);
			GLJournalBean deleteJournal = (GLJournalBean) getHibernateTemplate()
					.get(GLJournalBean.class, glId);
			deleteJournal.setOrganization(new Organization());
			deleteJournal.setCurrency(new Currency());
			deleteJournal.setGlFiscalYear(new GLFiscalYear());
			for (GLJournalLine ss : deleteJournal.getGlJournalLine()) {
				ss.setAccGroup(new AccountGroupBean());
				ss.setCurncy(new Currency());
				getHibernateTemplate().delete(ss);
			}

			getHibernateTemplate().delete(jb);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public boolean deleteGLJournalLine(int gljId) {
		try {
			GLJournalLine journalBean = (GLJournalLine) getHibernateTemplate()
					.get(GLJournalLine.class, gljId);
			journalBean.setCurncy(new Currency());
			journalBean.setAccGroup(new AccountGroupBean());
			getHibernateTemplate().delete(journalBean);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchGLJournal(String label, String operator,
			String searchName) {
		try {

			String hql = "select glj.glAccountId,glj.glAccountDT,glj.postingDT,glj.reference,glj.orgId,glj.currencyId,glj.glFiscalYearId,glj.description,glj.glFiscalYear,glj.currency,glj.organization from GLJournalBean glj where glj."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchGLJournal(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select glj.glAccountId,glj.glAccountDT,glj.postingDT,glj.reference,glj.orgId,glj.currencyId,glj.glFiscalYearId,glj.description,glj.glFiscalYear,glj.currency,glj.organization from GLJournalBean glj where glj."
					+ advSearch + "";

		} else {
			hql = "select glj.glAccountId,glj.glAccountDT,glj.postingDT,glj.reference,glj.orgId,glj.currencyId,glj.glFiscalYearId,glj.description,glj.glFiscalYear,glj.currency,glj.organization from GLJournalBean glj";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
