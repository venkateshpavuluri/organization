package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ProcessBean;

public interface ProcessService {
	
		public String saveProcessService(Object object);
		public List<Object[]>searchProcessServiceWithId(int id);
		public List<Object[]>searchProcessService();
		public List<Object[]>selectProcessService();
		public List<Object[]>selectMaterialservice();
		public List<ProcessBean> EditProcess(int id);
		public Long getProcessDetailedit(String name,int processdid);
		public Long getProcessDetailcountedit(String name,int processdetailsid);
		public String updateProcessService(Object object);
		public String deleteProcessService(int id);
		public String deleteChildDetailsService(int cid);
        public Long getprocesscount(String name);
    	public Long getProcessDetailCount(String desc);
    	public Long getProcessDescriptionedit(String name,int processdescid);
        public List<Object[]>selectProcessTypeDetailService();
        public List<Object[]> basicSearchProcess(String label,String operator,String searchName);
}
