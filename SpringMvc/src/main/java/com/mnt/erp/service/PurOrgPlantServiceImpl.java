package com.mnt.erp.service;

import com.mnt.erp.dao.PurOrgPlantDao;

public class PurOrgPlantServiceImpl implements  PurOrgPlantService
{
	public PurOrgPlantDao ppdao;
	
    public PurOrgPlantDao getPpdao() {
		return ppdao;
	}
	public void setPpdao(PurOrgPlantDao ppdao) {
		this.ppdao = ppdao;
	}
	
    public String savePurOrgPlant(Object object){
    	
	ppdao.savePurOrgPlant(object);
	return "success";
	
    }
    
}
