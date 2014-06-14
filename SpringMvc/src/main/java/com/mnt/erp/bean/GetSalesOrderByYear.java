/**
 * 
 */
package com.mnt.erp.bean;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 * @author venkateshp
 *
 */
public class GetSalesOrderByYear implements Serializable,JSONStreamAware {
	private String material;
	private float matpct;
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * @return the matpct
	 */
	public float getMatpct() {
		return matpct;
	}
	/**
	 * @param matpct the matpct to set
	 */
	public void setMatpct(float matpct) {
		this.matpct = matpct;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void writeJSONString(Writer out) throws IOException {
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("material", material);
        obj.put("matpct", matpct);
       
        JSONValue.writeJSONString(obj, out);
		
	}
	
	

}
