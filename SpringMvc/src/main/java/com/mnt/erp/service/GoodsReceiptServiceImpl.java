package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.GoodsReceipt;
import com.mnt.erp.dao.GoodsReceiptDao;

public class GoodsReceiptServiceImpl implements GoodsReceiptService {

	public GoodsReceiptDao gdao;

	public GoodsReceiptDao getGdao() {
		return gdao;
	}

	public void setGdao(GoodsReceiptDao gdao) {
		this.gdao = gdao;
	}

	String msg;

	public String saveGoodsReceipt(Object object,String userId,String userName) {

		try {
			msg = gdao.saveGoodsReceipt(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public List<GoodsReceipt> searchGoodsReceipt() {

		// TODO Auto-generated method stub
		List<GoodsReceipt> list = null;
		try {
			list = gdao.searchGoodsReceipt();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object> editGoodsReceipWithId(int prid) {

		// TODO Auto-generated method stub
		List<Object> list = null;
		try {
			list = gdao.editGoodsReceipWithId(prid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateGoodsReceipt(Object object) {

		// TODO Auto-generated method stub
		try {
			msg = gdao.updateGoodsReceipt(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public int goodsReceiptDuplicate(String receivingID) {
		int list = 0;
		try {
			list = gdao.goodsReceiptDuplicate(receivingID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String deleteGoodsReceipt(int id) {

		try {
			msg = gdao.deleteGoodsReceipt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public int goodsReceiptEditDuplicate(String receivingId, int id) {
		int list = 0;
		try {
			list = gdao.goodsReceiptEditDuplicate(receivingId, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<GoodsReceipt> basicSearchGoodsReceipt(String label, String operator,
			String searchName) {
		List<GoodsReceipt> objects = null;
		try {
			objects = gdao.basicSearchGoodsReceipt(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	public String deleteGoodsReceiptLine(int kk){
		String msg = null;
		try {
			msg = gdao.deleteGoodsReceiptLine(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public List<Object> getGoodsAdvance(String columns, String opeator,
			String advanceSearchText) {
		// TODO Auto-generated method stub
		String column[]=columns.split(",");
		String op[]=opeator.split(",");
		String advanceSearch[]=advanceSearchText.split(",");
		String finalStringForSearch="";
		
		for(int i=0;i<advanceSearch.length;i++){
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			if (op[i].equals("_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = advanceSearch[i] +"%";
				

			} else if (op[i].equals("%_")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = "%" + advanceSearch[i];

			} else if (op[i].equals("%_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] =  "%"  + advanceSearch[i] + "%" ;

			} else if (op[i].equals("=")) {
				column[i]=column[i];
				op[i]=" = ";
				advanceSearch[i] =   advanceSearch[i]  ;

			} else if (op[i].equals("!=")) {
				column[i]=column[i];
				op[i]=" != ";
				advanceSearch[i] =   advanceSearch[i]  ;

			}
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			finalStringForSearch=finalStringForSearch+"  g."+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
		}
		
		List<Object> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = gdao.goodsAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = gdao.goodsAdvanceSearch("ALL");
		}
		return list;
	}
	public List<Object> getGoods(String goods) {
		List<Object> list = gdao.setGoodsSearch(goods);
		return list;
	}
	public List<Object> purchaseOrderMaterialGet(String poNum,int materilId){
		List<Object> list = gdao.purchaseOrderMaterialGet(poNum, materilId);
		return list;
	}
	public List<Object> goodsReceiptLineMaterialQtyGet(String poNum,int materilId){
		List<Object> list = gdao.goodsReceiptLineMaterialQtyGet(poNum, materilId);
		return list;
	}
}
