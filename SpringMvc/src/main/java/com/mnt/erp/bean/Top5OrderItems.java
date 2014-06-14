/**
 * 
 */
package com.mnt.erp.bean;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 * @author venkateshp
 *
 */
public class Top5OrderItems implements Serializable,JSONStreamAware {
	private static Logger logger=Logger.getLogger(Top5OrderItems.class);
	private String material;
	private float quantity;
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
	 * @return the quantity
	 */
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void writeJSONString(Writer out) throws IOException {
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("material", material);
        obj.put("quantity", quantity);
       
        JSONValue.writeJSONString(obj, out);
		
	}
	/**
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
		
	}
	
	
	


