/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ApplicantBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.dao.ApplicantDao;

/**
 * @author devi
 *
 */
public class ApplicantServiceImpl implements ApplicantService{
	ApplicantDao appDao;

	public ApplicantDao getAppDao() {
		return appDao;
	}

	public void setAppDao(ApplicantDao appDao) {
		this.appDao = appDao;
	}
	@Override
	public String saveApplicantDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=appDao.saveApplicantDetails(object, userId, userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> getApplicantIds() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=appDao.getApplicantIds();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ApplicantBean> searchApplicants() {
		List<ApplicantBean> organizations=null;
	try
	{
		organizations=appDao.searchApplicants();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return organizations;
	}

	@Override
	public List<ApplicantBean> searchApplicantWithId(int id) {
		List<ApplicantBean> organizations=null;
		try
		{
			organizations=appDao.searchApplicantWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return organizations;
	}

	@Override
	public String updateApplicant(Object object) {
		String msg=null;
		try
		{
	ApplicantBean applicant=(ApplicantBean)object;
	applicant.setApplicant_Id(applicant.getApplicant_IdEdit());
	applicant.setFname(applicant.getFnameEdit());
	applicant.setLname(applicant.getLnameEdit());
	applicant.setMname(applicant.getMnameEdit());
	applicant.setPhoneNo(applicant.getPhoneNoEdit());
	applicant.setEmail(applicant.getEmailEdit());
	applicant.setVacancyDetail_Id(applicant.getVacancyDetail_IdEdit());
	applicant.setRefNo(applicant.getRefNoEdit());
	/*String path=applicant.getDocPathEdit().replace("\\", "/");
	String[] resumepath=path.split("/");
	applicant.setDocPathEdit("Resumes/"+resumepath[resumepath.length-1]);
	
	applicant.setDocPath(applicant.getDocPathEdit());*/
	//applicant.setDocPath()
	applicant.setShortListed(applicant.getShortListedEdit());
	applicant.setSelected(applicant.getSelectedEdit());
	applicant.setJoined(applicant.getJoinedEdit());
		msg=appDao.updateApplicants(applicant);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteApplicant(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=appDao.deleteApplicants(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long duplicateCheck(String fname) {
		// TODO Auto-generated method stub
		Long duid=0l;
		try
		{
			duid=appDao.duplicateCheck(fname);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duid;
	}

	@Override
	public Long updateDuplicateCheck(String fname, int aid) {
		// TODO Auto-generated method stub
		Long duid=0l;
		try
		{
			duid=appDao.updateDuplicateCheck(fname, aid);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duid;
	}

	public List<Object[]> selectApplicantDetails(){
		// TODO Auto-generated method stub
		
		List<Object[]>  list=null;
		try
		{
			list=appDao.selectApplicantDetails();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<ApplicantBean> basicSearchApplicant(String label, String operator,
			String searchName){
		List<ApplicantBean> organizations=null;
		try
		{
			organizations=appDao.basicSearchApplicants(label, operator, searchName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return organizations;
		
	}
		
	
}
