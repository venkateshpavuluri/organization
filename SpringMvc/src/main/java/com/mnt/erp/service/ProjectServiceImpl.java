package com.mnt.erp.service;
import java.util.List;
import com.mnt.erp.bean.Project;
import com.mnt.erp.dao.ProjectDao;;


/**
 * @author kirangangone
 * 
 */
public class ProjectServiceImpl implements ProjectService {
	public ProjectDao projectdao;
	boolean message = false;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	
     /**
	 * @return the projectdao
	 */
	public ProjectDao getProjectdao() {
		return projectdao;
	}


	/**
	 * @param projectdao the projectdao to set
	 */
	public void setProjectdao(ProjectDao projectdao) {
		this.projectdao = projectdao;
	}


	@Override
	public boolean saveProject(Project project) {
		// TODO Auto-generated method stub
		 message=projectdao.saveProject(project);
		return message;
	}
	
	public int duplicateCheckProject(String project, String Id) {
		int i = 0;
		try {
			i = projectdao.duplicateCheckProject(project, Id);

		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
	
/*For Project Group Id*/
	
	public List<Object[]> getOrgId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=projectdao.getOrgId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	
/*For Project Id*/
	
	public List<Object[]> getProjectId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=projectdao.getProjectId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	
	
	
/*For Manager Id*/
	
	public List<Object[]> getManagerId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=projectdao.getManagerId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	
	
/*For Manager Id*/
	
	public List<Object[]> getStatusId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=projectdao.getStatusId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
/*For Sales Order Id*/
	
	public List<Object[]> getSalesOrder(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=projectdao.getSalesOrder();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	public List<Object[]> basicSearchProject(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		try {
			objs = projectdao.basicSearchProject(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
	public List<Object> editProject(int cId) {
		try {
			obj = projectdao.editProject(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@Override
	public boolean updateProject(Project project) {
		boolean flag=false;
		try {
			// System.out.println("Came to Service Of Purchase Update");
		flag = projectdao.updateProject(project);
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	public boolean deleteProject(int id) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			msg = projectdao.deleteProject(id);
		} catch (Exception e) {
			//e.printStackTrace();
			return msg;
		}
		return msg;
	}
	

	


}
