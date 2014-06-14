/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.StockTransferBean;
import com.mnt.erp.bean.StockTransferLineBean;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.StockTransferService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 29-11-2013
 */
@Controller
public class StockTransferController {
	private static final Logger log = Logger
			.getLogger(StockTransferController.class);

	@Autowired
	StockTransferService stockTransService;
	@Autowired
	PopulateService populateService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;

	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	Object obj = null;
	HttpSession session = null;
	String message = "";
	boolean flag = false;

	@RequestMapping(value = "/stockTransferHome", method = RequestMethod.GET)
	public ModelAndView stockTransferHome(
			@ModelAttribute("stockTransferCmd") StockTransferBean stockTransferBean,
			SessionStatus status, Model model, HttpServletResponse response,
			HttpServletRequest request) {

		// log.info("In Stock Transfer");
		response.setCharacterEncoding("UTF-8");
		model.addAttribute("stockTransferBean", new StockTransferBean());
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("stockTransferHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("stockTransferHome", "stockTransferCmd",
				stockTransferBean);

	}

	@ModelAttribute("OrgSelect")
	public Map<Integer, String> custSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = stockTransService.selectOrgIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("SelectBatchNo")
	public Map<String, String> selectBatchNo() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			list = stockTransService.selectBatchNos();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((String) objects[0], (String) objects[0]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/forPlantIds", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> PlantIds(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("orgId") int orgId) {
		response.setCharacterEncoding("UTF-8");
		Map<Integer, String> map = null;
		try {
			list = stockTransService.selectPlantIds(orgId);
			if (list != null) {
				map = new HashMap<Integer, String>();
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/forStorLocIds", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> storLocIds(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("plantId") int plantId) {
		response.setCharacterEncoding("UTF-8");
		Map<Integer, String> map = null;
		try {
			list = stockTransService.populateStorLocIds(plantId);
			if (list != null) {
				map = new HashMap<Integer, String>();
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@RequestMapping(value = "/forBatchNo", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> forBatchNos(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("materialId") int matId,
			@RequestParam("slId") String slId) {
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = null;
		try {
			List<Object[]> obAry = stockTransService.getBatchNOs(matId, slId);
			if (obAry != null) {
				map = new HashMap<String, String>();
			}
			itr = obAry.iterator();
			while (itr.hasNext()) {
				Object[] obje = (Object[]) itr.next();
				map.put((String) obje[0], (String) obje[0]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@RequestMapping(value = "/getStockQty", method = RequestMethod.POST)
	public @ResponseBody
	float forAvalQty(HttpServletRequest request, HttpServletResponse response,
			StockTransferBean stBean) {
		response.setCharacterEncoding("UTF-8");
		int slId = 0;
		int matId = Integer.parseInt(request.getParameter("materialId"));
		if (!"".equals(request.getParameter("slId"))) {
			slId = Integer.parseInt(request.getParameter("slId"));
		}
		String bId = request.getParameter("batchNo");
		float avalQty = 0;
		List<MatStockBean> mBean = null;
		try {
			mBean = stockTransService.getAvlQty(matId, slId, bId);
			if (mBean != null) {
				for (MatStockBean ms : mBean) {
					avalQty = ms.getQtyAval();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return avalQty;

	}

	@RequestMapping(value = "/checkStockAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkStockAddDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("stockTransferNo") String stNo) {
		response.setCharacterEncoding("UTF-8");
		Long checkCustName = stockTransService.checkStockTransfer(stNo);
		if (checkCustName != 0) {
			message = "Warning ! Stock Transfer No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/stockTransferAdd", method = RequestMethod.POST)
	public String savestockTransfer(
			@ModelAttribute("stockTransferCmd") StockTransferBean saveStockBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");
		String stockTransferSave = null;
		List<StockTransferLineBean> stockTransferLine = new ArrayList<StockTransferLineBean>();

		String materialId[] = saveStockBean.getMaterialId();
		String qty[] = saveStockBean.getQuantity();
		String uomId[] = saveStockBean.getUOMId();
		String batchNo[] = saveStockBean.getBatchNo();
		StockTransferBean stBean = (StockTransferBean) saveStockBean;

		MatStockBean mBean = new MatStockBean();
		int mStockId = 0;
		float matQty = 0, totQty = 0;
		if (materialId != null) {
			for (int n = 0; n < materialId.length; n++) {
				StockTransferLineBean stLine = new StockTransferLineBean();
				stLine.setMaterialId(materialId[n]);
				stLine.setQuantity(qty[n]);
				stLine.setUOMId(uomId[n]);
				stLine.setBatchNo(batchNo[n]);
				stockTransferLine.add(stLine);

				// get mat Stock from Stor Loc
				List<MatStockBean> ob = stockTransService.getMatStock(
						Integer.parseInt(materialId[n]),
						Integer.parseInt(stBean.getStorageLocationId()),
						batchNo[n]);
				if (ob != null) {
					for (MatStockBean mst : ob) {
						mStockId = mst.getMatStockId();
						matQty = mst.getQtyAval();
					}
					totQty = matQty - Float.parseFloat(qty[n]);
					mBean.setMatStockId(mStockId);
					mBean.setMaterialId(Integer.parseInt(materialId[n]));
					mBean.setBatchNo(batchNo[n]);
					mBean.setStorLocId(Integer.parseInt(stBean
							.getStorageLocationId()));
					mBean.setQtyAval(totQty);
					flag = stockTransService.saveOrUpdateMatStock(mBean);

					// get mat Stock To Stor Loc
					List<MatStockBean> obs = stockTransService.getMatStock(
							Integer.parseInt(materialId[n]),
							Integer.parseInt(stBean.getToStorageLocationId()),
							batchNo[n]);
					if (obs != null) {
						for (MatStockBean mst : obs) {
							mStockId = mst.getMatStockId();
							matQty = mst.getQtyAval();
						}
						totQty = matQty + Float.parseFloat(qty[n]);
						flag = stockTransService.updateMatStock(totQty, Integer
								.parseInt(materialId[n]), Integer
								.parseInt(stBean.getToStorageLocationId()),
								batchNo[n]);
					}

					else {
						// Save Or Update Quantity From MatStock
						MatStockBean mmBean = new MatStockBean();
						mmBean.setMaterialId(Integer.parseInt(materialId[n]));
						mmBean.setBatchNo(batchNo[n]);
						mmBean.setStorLocId(Integer.parseInt(stBean
								.getToStorageLocationId()));
						mmBean.setQtyAval(Float.parseFloat(qty[n]));
						flag = stockTransService.saveOrUpdateMatStock(mmBean);
					}

				} else {
					// Save Or Update Quantity From MatStock
					mBean.setMaterialId(Integer.parseInt(materialId[n]));
					mBean.setBatchNo(batchNo[n]);
					mBean.setStorLocId(Integer.parseInt(stBean
							.getToStorageLocationId()));
					mBean.setQtyAval(Float.parseFloat(qty[n]));
					flag = stockTransService.saveOrUpdateMatStock(mBean);
				}
			}

			stBean.setStockTransferLine(stockTransferLine);
		}
		try {
			stBean.setStockTransferDate(dateService.dateFormat(
					dateService.dateParse(stBean.getStockTransferDate(), "au"),
					"au"));
			String msg = stockTransService.saveStockTransfer(stBean);
			if (msg == "S") {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Stock Transfer", "ROW", String
						.valueOf(stBean.getStockTransferId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				stockTransferSave = "Stock Transfer Data Saved Successfully!";
			} else {
				return "redirect:stockTransferHome.mnt?addSTFail="
						+ stockTransferSave + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:stockTransferHome.mnt?addSTFail="
					+ stockTransferSave + "";
		}
		return "redirect:stockTransferHome.mnt?addSTSus=" + stockTransferSave
				+ "";
	}

	@RequestMapping(value = "/checkStockUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkStockUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("estockTransferNo") String stockNo,
			@RequestParam("stId") int stId) {
		response.setCharacterEncoding("UTF-8");
		int checkCustName = stockTransService.updateCheckStockTransfer(stockNo,
				stId);
		if (checkCustName != 0) {
			message = "Warning ! Stock Transfer No is Already exists. Please try some other name";
		} else {
			message = null;
		}
		return message;
	}

	@ModelAttribute("SelectUom")
	public Map<Integer, String> uomSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = stockTransService.populateUOMIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("materialSelect")
	public Map<Integer, String> populatStatusIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.material_Id,m.materialName from Material m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/forMaterial", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> materialSelectBox(HttpServletRequest request,
			HttpServletResponse response) {
		Object[] objects = null;
		List<Object[]> list = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		int storLocId = 0;
		if (!"".equals(request.getParameter("storLocId"))) {
			storLocId = Integer.parseInt(request.getParameter("storLocId"));
		}
		try {
			list = stockTransService.populateMaterialIds(storLocId);
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("storLocSelect")
	public Map<Integer, String> storLocSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = stockTransService.populateStorLocIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("plantSelect")
	public Map<Integer, String> plantSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = stockTransService.selectPlantIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/stockTransferSearch", method = RequestMethod.GET)
	public String searchstockTransfer(
			@ModelAttribute("stockTransferCmd") StockTransferBean stockTransferBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<StockTransferBean> STList = new ArrayList<StockTransferBean>();
		try {

			String dbField = stockTransferBeanSearch.getXmlLabel();
			String operation = stockTransferBeanSearch.getOperations();
			String basicSearchId = stockTransferBeanSearch.getBasicSearchId();

			if (operation.equals("_%")) {
				operation = " like ";
				basicSearchId = basicSearchId + "%";

			} else if (operation.equals("%_")) {
				operation = " like ";
				basicSearchId = "%" + basicSearchId;

			} else if (operation.equals("%_%")) {
				operation = " like ";
				basicSearchId = "%" + basicSearchId + "%";
			}

			if (basicSearchId == "") {
				list = stockTransService.searchStockTransfer();

			} else {

				list = stockTransService.basicSearchStockTransfer(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				StockTransferBean stb = new StockTransferBean();
				stb.setStockTransferId((Integer) objects[0]);
				stb.setStockTransferNo((String) objects[1]);
				stb.setStockTransferDate(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				Organization org = ((Organization) objects[6]);
				stb.setOrgId(org.getOrgName());
				Plant p = ((Plant) objects[7]);
				stb.setPlantId(p.getPlantName());
				StorageLocation sl = ((StorageLocation) objects[8]);
				stb.setStorageLocationId(sl.getStorageLocation());

				STList.add(stb);
			}
			request.setAttribute("STList", STList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stockTransferHome";
	}

	@RequestMapping(value = "/stockTransferDelete", method = RequestMethod.GET)
	public String stockTransferDelete(
			@ModelAttribute("stockTransferCmd") StockTransferBean stockTransferBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		String stDelete = null;
		int cId = Integer.parseInt(request.getParameter("stockTransferId"));

		try {
			String msg = stockTransService.deleteStockTransfer(cId);

			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Stock Transfer", "ROW", String
						.valueOf(cId), "1", modifiedDate,
						session.getAttribute("userName").toString());

				stDelete = "Stock Transfer Deleted Successfully";

			} else {
				stDelete = "Stock Transfer Deletion Failed due to Conatraint Violation!";
				return "redirect:stockTransferHome.mnt?DeleteSTFail="
						+ stDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:stockTransferHome.mnt?DeleteSTFail=" + stDelete
					+ "";
		}
		return "redirect:stockTransferHome.mnt?DeleteSTsus=" + stDelete + "";

	}

	@RequestMapping(value = "/stockTransferEdit", method = RequestMethod.GET)
	public String stockTransferEdit(
			@ModelAttribute("stockTransferCmd") StockTransferBean stockTransferBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<StockTransferBean> stockEditList = new ArrayList<StockTransferBean>();
		List<StockTransferLineBean> stockLineEditList = new ArrayList<StockTransferLineBean>();
		List<Float> qtyList = new ArrayList<Float>();
		int stockId = stockTransferBeanEdit.getStockTransferId();
		try {
			List<Object> l = stockTransService
					.searchStockTransferWithId(stockId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				StockTransferBean ccb = (StockTransferBean) oo;
				stockTransferBeanEdit.setEstockTransferId(ccb
						.getStockTransferId());
				stockTransferBeanEdit.setEstockTransferNo(ccb
						.getStockTransferNo());
				stockTransferBeanEdit
						.setEstockTransferDate(dateService.dateFormat(
								dateService.dateParse(
										ccb.getStockTransferDate(), "se"), "se"));
				stockTransferBeanEdit.setEorgId(ccb.getOrgId());
				stockTransferBeanEdit.setEplantId(ccb.getPlantId());
				stockTransferBeanEdit.setEstorageLocationId(ccb
						.getStorageLocationId());
				stockTransferBeanEdit.setEtoOrgId(ccb.getToOrgId());
				stockTransferBeanEdit.setEtoPlantId(ccb.getToPlantId());
				stockTransferBeanEdit.setEtoStorageLocationId(ccb
						.getToStorageLocationId());

				List<StockTransferLineBean> listEdit = ccb
						.getStockTransferLine();

				Iterator<StockTransferLineBean> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					StockTransferLineBean cc = (StockTransferLineBean) o;
					StockTransferLineBean sMultiple = new StockTransferLineBean();
					sMultiple.setEstockTransferLineId(cc
							.getStockTransferLineId());
					sMultiple.setEstockTransferId(ccb.getStockTransferId());
					Material mt = cc.getMaterial();
					sMultiple.setEmaterialName(mt.getMaterialName());
					sMultiple.setEmaterialId(cc.getMaterialId());
					sMultiple.setEquantity(cc.getQuantity());
					Uom uom = cc.getUom();
					sMultiple.setEuomName(uom.getUom());
					sMultiple.seteUOMId(cc.getUOMId());
					sMultiple.setEbatchNo(cc.getBatchNo());
					stockLineEditList.add(sMultiple);
					qtyList.add(Float.parseFloat(cc.getQuantity()));
				}
				stockTransferBeanEdit.setStockTransferLine(stockLineEditList);
				stockEditList.add(stockTransferBeanEdit);
			}
			session = request.getSession(false);
			session.setAttribute("qtyList", qtyList);
			request.setAttribute("stockEditList", stockEditList);
			request.setAttribute("stockLineEditList", stockLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stockTransferHome";
	}

	@RequestMapping(value = "/stockTransferUpdate", method = RequestMethod.POST)
	public String stockTransferUpdate(
			@ModelAttribute("stockTransferCmd") StockTransferBean stockTransferBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		MatStockBean mBean = new MatStockBean();
		int mStockId = 0;
		float matQty = 0, diffQty = 0, totQty = 0;

		response.setCharacterEncoding("UTF-8");
		List<StockTransferLineBean> STLineUpList = new ArrayList<StockTransferLineBean>();
		String msg = null;
		String stockUpdate = null;
		try {
			stockTransferBeanUpdate.setStockTransferId(stockTransferBeanUpdate
					.getEstockTransferId());
			stockTransferBeanUpdate.setStockTransferNo(stockTransferBeanUpdate
					.getEstockTransferNo());
			stockTransferBeanUpdate.setStockTransferDate(dateService
					.dateFormat(dateService.dateParse(
							stockTransferBeanUpdate.getEstockTransferDate(),
							"au"), "au"));
			stockTransferBeanUpdate.setOrgId(stockTransferBeanUpdate
					.getEorgId());
			stockTransferBeanUpdate.setPlantId(stockTransferBeanUpdate
					.getEplantId());
			stockTransferBeanUpdate
					.setStorageLocationId(stockTransferBeanUpdate
							.getEstorageLocationId());
			stockTransferBeanUpdate.setToOrgId(stockTransferBeanUpdate
					.getEtoOrgId());
			stockTransferBeanUpdate.setToPlantId(stockTransferBeanUpdate
					.getEtoPlantId());
			stockTransferBeanUpdate
					.setToStorageLocationId(stockTransferBeanUpdate
							.getEtoStorageLocationId());

			int sLineId[] = stockTransferBeanUpdate.getEstockTransferLineId();
			String matid[] = stockTransferBeanUpdate.getEmaterialId();
			String qty[] = stockTransferBeanUpdate.getEquantity();
			String uomId[] = stockTransferBeanUpdate.geteUOMId();
			String[] batchNo = stockTransferBeanUpdate.getEbatchNo();
			String childDelete = "", ss = "1";
			int id = 0;
			List<Float> newQty = new ArrayList<Float>();
			if (matid != null && qty != null) {
				session = request.getSession(false);
				@SuppressWarnings("unchecked")
				List<Float> oldQty = (List<Float>) session
						.getAttribute("qtyList");

				for (int n = 0; n < matid.length; n++) {
					int cbId = sLineId[n];
					// Get mat Stock
					List<MatStockBean> ob = stockTransService.getMatStock(
							Integer.parseInt(matid[n]), Integer
									.parseInt(stockTransferBeanUpdate
											.getEstorageLocationId()),
							batchNo[n]);

					if (cbId == 0) {
						StockTransferLineBean sib = new StockTransferLineBean();
						sib.setMaterialId(matid[n]);
						sib.setQuantity(qty[n]);
						sib.setUOMId(uomId[n]);
						sib.setBatchNo(batchNo[n]);
						STLineUpList.add(sib);
						// Mat Stock for new row
						if (ob != null) {
							for (MatStockBean mst : ob) {
								mStockId = mst.getMatStockId();
								matQty = mst.getQtyAval();
							}
							totQty = matQty - Float.parseFloat(qty[n]);
							mBean.setMatStockId(mStockId);
							mBean.setMaterialId(Integer.parseInt(matid[n]));
							mBean.setBatchNo(batchNo[n]);
							mBean.setStorLocId(Integer
									.parseInt(stockTransferBeanUpdate
											.getEstorageLocationId()));
							mBean.setQtyAval(totQty);
							flag = stockTransService
									.saveOrUpdateMatStock(mBean);

							List<MatStockBean> obs = stockTransService
									.getMatStock(
											Integer.parseInt(matid[n]),
											Integer.parseInt(stockTransferBeanUpdate
													.getEtoStorageLocationId()),
											batchNo[n]);

							if (obs != null) {
								for (MatStockBean mst : obs) {
									mStockId = mst.getMatStockId();
									matQty = mst.getQtyAval();
								}

								// Update Quantity From MatStock
								totQty = matQty + Float.parseFloat(qty[n]);
								flag = stockTransService
										.updateMatStock(
												totQty,
												Integer.parseInt(matid[n]),
												Integer.parseInt(stockTransferBeanUpdate
														.getEtoStorageLocationId()),
												batchNo[n]);

							}
						} else {
							// Save Or Update Quantity From MatStock
							mBean.setMaterialId(Integer.parseInt(matid[n]));
							mBean.setBatchNo(batchNo[n]);
							mBean.setStorLocId(Integer
									.parseInt(stockTransferBeanUpdate
											.getEtoStorageLocationId()));
							mBean.setQtyAval(Float.parseFloat(qty[n]));
							flag = stockTransService
									.saveOrUpdateMatStock(mBean);
						}

					} else {
						newQty.add(Float.parseFloat(qty[n]));
						StockTransferLineBean sibs = new StockTransferLineBean();
						sibs.setMaterialId(matid[n]);
						sibs.setQuantity(qty[n]);
						sibs.setUOMId(uomId[n]);
						sibs.setBatchNo(batchNo[n]);
						id = sLineId[n];
						childDelete = request.getParameter("Check" + id);
						if (ss.equals(childDelete)) {
							msg = stockTransService.deleteStockTransferLine(id);
						} else {
							STLineUpList.add(sibs);
						}
						// Check OldQty And NewQty for Matstock Update
						if (oldQty.get(n) > (newQty.get(n))) {
							if (ob != null) {
								for (MatStockBean mst : ob) {
									mStockId = mst.getMatStockId();
									matQty = mst.getQtyAval();
								}
								diffQty = oldQty.get(n) - newQty.get(n);
								totQty = matQty + diffQty;
								mBean.setMatStockId(mStockId);
								mBean.setMaterialId(Integer.parseInt(matid[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(stockTransferBeanUpdate
												.getEstorageLocationId()));
								mBean.setQtyAval(totQty);
								flag = stockTransService
										.saveOrUpdateMatStock(mBean);

								// Update Stock from To Stor Loc
								flag = stockTransService.updateMatStock(Float
										.parseFloat(qty[n]), Integer
										.parseInt(matid[n]), Integer
										.parseInt(stockTransferBeanUpdate
												.getEtoStorageLocationId()),
										batchNo[n]);

							} else {
								// Save Or Update Quantity From MatStock
								mBean.setMaterialId(Integer.parseInt(matid[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(stockTransferBeanUpdate
												.getEtoStorageLocationId()));
								mBean.setQtyAval(Float.parseFloat(qty[n]));
								flag = stockTransService
										.saveOrUpdateMatStock(mBean);
							}

						} else if (oldQty.get(n) < (newQty.get(n))) {
							if (ob != null) {
								for (MatStockBean mst : ob) {
									mStockId = mst.getMatStockId();
									matQty = mst.getQtyAval();
								}
								diffQty = newQty.get(n) - oldQty.get(n);
								totQty = matQty - diffQty;
								mBean.setMatStockId(mStockId);
								mBean.setMaterialId(Integer.parseInt(matid[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(stockTransferBeanUpdate
												.getEstorageLocationId()));
								mBean.setQtyAval(totQty);
								flag = stockTransService
										.saveOrUpdateMatStock(mBean);

								// Update Stock from To Stor Loc
								flag = stockTransService.updateMatStock(Float
										.parseFloat(qty[n]), Integer
										.parseInt(matid[n]), Integer
										.parseInt(stockTransferBeanUpdate
												.getEtoStorageLocationId()),
										batchNo[n]);

							} else {
								// Save Or Update Quantity From MatStock
								mBean.setMaterialId(Integer.parseInt(matid[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(stockTransferBeanUpdate
												.getEtoStorageLocationId()));
								mBean.setQtyAval(Float.parseFloat(qty[n]));
								flag = stockTransService
										.saveOrUpdateMatStock(mBean);
							}

						} else {
							// Two Quantitys are Equal No update...
						}

					}

				}
			}

			stockTransferBeanUpdate.setStockTransferLine(STLineUpList);
			msg = stockTransService
					.updateStockTransfer(stockTransferBeanUpdate);

			if (msg == "Updated") {
				stockUpdate = "Stock Transfer Data Updated Successfully";

			} else {
				stockUpdate = "Stock Transfer Data Not Updated";
				return "redirect:stockTransferHome.mnt?UpdateSTFail="
						+ stockUpdate + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:stockTransferHome.mnt?UpdateSTFail=" + stockUpdate
					+ "";
		}

		return "redirect:stockTransferHome.mnt?UpdateSTsus=" + stockUpdate + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "stockTransferId";
		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/STAdvanceSearch", method = RequestMethod.GET)
	public String stockAdvanceSearch(
			@ModelAttribute("stockTransferCmd") StockTransferBean st,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> objArray = null;
		List<StockTransferBean> stList = new ArrayList<StockTransferBean>();
		List<StockTransferBean> refList = new ArrayList<StockTransferBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("stockTransferId");

			for (Object[] object : objArray) {
				StockTransferBean s = new StockTransferBean();
				if ((boolean) object[2].equals("false")) {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					stList.add(s);
				} else {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					refList.add(s);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stAdv", stList);
		request.setAttribute("refList", refList);
		return "stockTransferHome";
	}

	@RequestMapping(value = "/STAdvanceSearchOperations", method = RequestMethod.GET)
	public String stAdvanceSearchOperations(
			@ModelAttribute("stockTransferCmd") StockTransferBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<StockTransferBean> STList = new ArrayList<StockTransferBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = stockTransService.advSearchStockTransfer(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = stockTransService.searchStockTransfer();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			StockTransferBean stb = new StockTransferBean();
			stb.setStockTransferId((Integer) objects[0]);
			stb.setStockTransferNo((String) objects[1]);
			stb.setStockTransferDate(dateService.dateFormat(
					dateService.dateParse((String) objects[2], "se"), "se"));
			Organization org = ((Organization) objects[6]);
			stb.setOrgId(org.getOrgName());
			Plant p = ((Plant) objects[7]);
			stb.setPlantId(p.getPlantName());
			StorageLocation sl = ((StorageLocation) objects[8]);
			stb.setStorageLocationId(sl.getStorageLocation());

			STList.add(stb);
		}
		request.setAttribute("STList", STList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("stockTransferCmd", new StockTransferBean());
		return "stockTransferHome";
	}
}
