package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ProcessBean;
import com.mnt.erp.dao.ProcessDao;


public class ProcessServiceImpl implements ProcessService {
	ProcessDao pdao;
	String processmessage;
	List<Object[]> objects;
	List<Object> objects2;
	List<ProcessBean> plist;
	
	
	
	public ProcessDao getPdao() {
		return pdao;
	}

	public void setPdao(ProcessDao pdao) {
		this.pdao = pdao;
	}

	@Override
	public String saveProcessService(Object object) {
		try{
			processmessage=pdao.saveprocess(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return processmessage;
	}

	@Override
	public List<Object[]> searchProcessServiceWithId(int id) {
try{
			
			objects=pdao.searchProcessWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> searchProcessService() {
		try{
			objects=pdao.searchProcess();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<Object[]> selectProcessService() {
		try{
			objects=pdao.selectProcess();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public String updateProcessService(Object object) {
		try{
			processmessage=pdao.updateProcess(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return processmessage;
	}

	@Override
	public String deleteProcessService(int id) {
		try{
			processmessage=pdao.deleteProcess(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return processmessage;
	}

	@Override
	public Long getprocesscount(String name) {
		Long iid=0l;
		try{
		 iid=pdao.getProcessCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}
	

	@Override
	public List<Object[]> selectProcessTypeDetailService() {
		try{
			objects=pdao.selectProcessTypeDetail();
		}catch(Exception  e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<ProcessBean> EditProcess(int id) {
		try{
			plist=pdao.EditProcess(id);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return plist;
	}

	@Override
	public Long getProcessDetailCount(String desc) {
		Long pdid=0l;
		try{
		 pdid=pdao.getProcessDetailCount(desc);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pdid;
	}

	@Override
	public Long getProcessDetailedit(String name, int processdid) {
		Long id=0L;
		try{
			id=pdao.getProcessDetailedit(name, processdid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getProcessDetailcountedit(String name, int processdetailsid) {
		Long id=0L;
		try{
			id=pdao.getProcessDetailcountedit(name, processdetailsid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> basicSearchProcess(String label, String operator,
			String searchName) {
		try {
			objects = pdao.basicSearchProcess(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public Long getProcessDescriptionedit(String name, int processdescid) {
		Long id=0L;
		try{
			id=pdao.getProcessDescriptionedit(name, processdescid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public String deleteChildDetailsService(int cid) {
		try{
			processmessage=pdao.deleteChildDetails(cid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return processmessage;
	
	}

	@Override
	public List<Object[]> selectMaterialservice() {
try{
			
			objects=pdao.selectMaterial();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
	}

	

	


