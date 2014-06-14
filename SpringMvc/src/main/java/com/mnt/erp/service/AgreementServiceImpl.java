package com.mnt.erp.service;
import java.util.List;
import com.mnt.erp.bean.Agreement;
import com.mnt.erp.bean.PurOrgCompany;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.dao.AgreementDao;

public class AgreementServiceImpl implements AgreementService {
	AgreementDao agdao;
	String agmessage;
	List<Object[]> objects;
	List<Object> object;
	List<Agreement> rflist;

	public AgreementDao getAgdao() {
		return agdao;
	}

	public void setAgdao(AgreementDao agdao) {
		this.agdao = agdao;
	}

	@Override
	public String saveAgreement(Object object) {
		try {
			agmessage = agdao.saveAgreement(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return agmessage;
	}

	@Override
	public List<Object[]> selectAgreementTypeid() {
		try {

			objects = agdao.selectAgreementTypeid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectVendorId() {
		try {

			objects = agdao.selectVendorId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectOrgId() {
		try {

			objects = agdao.selectOrgId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectpurOrgId() {
		try {

			objects = agdao.selectpurOrgId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectMaterial() {
		try {

			objects = agdao.selectMaterial();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectUom() {
		try {

			objects = agdao.selectUom();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Agreement> EditAgreement(int iid) {
		try {
			rflist = agdao.EditAgreement(iid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rflist;
	}

	@Override
	public String updateAgreement(Object object) {
		try {
			agmessage = agdao.updateAgreement(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agmessage;
	}

	@Override
	public String deleteAgreement(int id) {
		try {
			agmessage = agdao.deleteAgreement(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return agmessage;
	}

	@Override
	public String deleteChildDetails(int cid) {
		try {
			agmessage = agdao.deleteChildDetails(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agmessage;
	}

	@Override
	public List<Object[]> basicSearchAgreement(String label, String operator,
			String searchName) {
		try {
			objects = agdao.basicSearchAgreement(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
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
			list = agdao.setAgreementAdvanceSearch(finalStringForSearch
					.substring(0, finalStringForSearch.length() - 3));
		} else {
			list = agdao.setAgreementSearch("ALL");
		}
		return list;
	}

	@Override
	public Long getAgreementCount(String name) {
		Long id = 0L;
		try {
			id = agdao.getAgreementCount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getAgreementCountedit(String name, int Agreementid) {
		Long id = 0L;
		try {
			id = agdao.getAgreementCountedit(name, Agreementid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> searchAgreementservice() {
		try{
			objects=agdao.searchAgreement();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<Object[]> setAgreementSearch(String name) {
		List<Object[]> list = agdao.setAgreementSearch(name);
		return list;
	}

	@Override
	public List<PurchaseOrganization> selectPo(int orgId) {
		List<PurchaseOrganization> list = agdao.selectPoIds(orgId);
		return list;
	}

	@Override
	public List<PurchaseOrganization> selectPoEdit(int orgId) {
		List<PurchaseOrganization> list = agdao.selectPoIds(orgId);
		return list;
	}

}
