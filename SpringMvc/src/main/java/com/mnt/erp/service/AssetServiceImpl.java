package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.bean.AssetBean;
import com.mnt.erp.dao.AssetDao;

public class AssetServiceImpl implements AssetService {
	AssetDao astdao;
	String assetmessage;
	List<Object[]> objects;
	List<Object> object;
	List<AssetBean> rflist;
	public AssetDao getAstdao() {
		return astdao;
	}

	public void setAstdao(AssetDao astdao) {
		this.astdao = astdao;
	}

	@Override
	public String saveAsset(Object object) {
		try {
			assetmessage = astdao.saveAsset(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return assetmessage;
	}

	@Override
	public List<Object[]> selectAssetTypeid() {
		try {

			objects = astdao.selectAssetTypeid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectAssetGroupId() {
		try {

			objects = astdao.selectAssetGroupId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectEmpId() {
		try {

			objects = astdao.selectEmpId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchAsset() {
		try{
			objects=astdao.searchAsset();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<AssetBean> EditAsset(int iid) {
		try {
			rflist = astdao.EditAsset(iid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rflist;
	}

	@Override
	public String updateAsset(Object object) {
		try {
			assetmessage = astdao.updateAsset(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assetmessage;
	}

	@Override
	public String deleteAsset(int id) {
		try {
			assetmessage = astdao.deleteAsset(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return assetmessage;
	}

	@Override
	public String deleteChildDetails(int cid) {
		try {
			assetmessage = astdao.deleteChildDetails(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assetmessage;
	}

	@Override
	public List<Object[]> basicSearchAsset(String label, String operator,
			String searchName) {
			try {
				objects = astdao.basicSearchAsset(label, operator, searchName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return objects;
	}

	@Override
	public List<Object[]> setAssetAdvanceSearch(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> setAssetSearch(String name) {
		List<Object[]> list = astdao.setAssetSearch(name);
		return list;
	}

	@Override
	public List<Object[]> setAgreementAdvanceSearch(String columns,
			String opeator, String advanceSearchText) {

			String column[] = columns.split(",");
			String op[] = opeator.split(",");
			String advanceSearch[] = advanceSearchText.split(",");
			String finalStringForSearch = "";

			for (int i = 0; i < advanceSearch.length; i++) {
				if (!op[i].equals("0") && advanceSearch[i] != "") {
					if (op[i].equals("_%")) {
						column[i] = column[i];
						op[i] = " like ";
						advanceSearch[i] = advanceSearch[i] + "%";

					} else if (op[i].equals("%_")) {
						column[i] = column[i];
						op[i] = " like ";
						advanceSearch[i] = "%" + advanceSearch[i];

					} else if (op[i].equals("%_%")) {
						column[i] = column[i];
						op[i] = " like ";
						advanceSearch[i] = "%" + advanceSearch[i] + "%";

					} else if (op[i].equals("=")) {
						column[i] = column[i];
						op[i] = " = ";
						advanceSearch[i] = advanceSearch[i];

					} else if (op[i].equals("!=")) {
						column[i] = column[i];
						op[i] = " != ";
						advanceSearch[i] = advanceSearch[i];

					}
					if (!op[i].equals("0") && advanceSearch[i] != "") {
						finalStringForSearch = finalStringForSearch + "  "
								+ column[i] + " " + op[i] + " '" + advanceSearch[i]
								+ "' " + "AND";
					}
				}

			}
			// System.out.println("String Value Kiran" +finalStringForSearch);
			List<Object[]> list = null;
			if (finalStringForSearch.length() > 3) {
				list = astdao.setAssetAdvanceSearch(finalStringForSearch
						.substring(0, finalStringForSearch.length() - 3));
			} else {
				list = astdao.setAssetSearch("ALL");
			}
			return list;
	}

}
