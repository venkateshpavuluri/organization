/**
 * 
 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Bom;
import com.mnt.erp.bean.BomCategory;
import com.mnt.erp.bean.BomLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BomService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0 08-11-2013
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class BomController {
	private Logger logger=Logger.getLogger(BomController.class);

	@Autowired
	BomService bomService;
	@Autowired
	PlantService plantService;
	@Autowired
	MaterialService materialService;
	@Autowired
	UomService uomService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	HttpSession  session;

	Object[] objects = null;
	List<Bom> bom1 = null;
	String name = null;
	Bom bo = null;
	Object[] objects2 = null;
	
	List<Object[]> objectsArray = null;
	int id = 0;
	Iterator<Object[]> iterator = null;
	List<Bom> bomList = null;

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "bomId";

		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* ================ To Get Bom Category Values========= */
	@ModelAttribute("bomcategory")
	public Map<Integer, String> bomIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = bomService.getBomCategory();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());

		}
		return map;
	}

	/* ================ To Get Plant Id Values========= */
	@ModelAttribute("plant")
	public Map<Integer, String> plantIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = plantService.getPlantIds();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* ==================== To Get Material Id Values================= */
	@ModelAttribute("material")
	public Map<Integer, String> materialIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = materialService.materialIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* ======================= To Get UOM Id Values================= */
	@ModelAttribute("uom")
	public Map<Integer, String> UomIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = uomService.uomIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@RequestMapping(value = "/Bom", method = RequestMethod.GET)
	public ModelAndView getBom(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		 session=request.getSession(false);
		List<String> list=menuService.getPrivilige("Bom.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("bomHome", "bomCommand", new Bom());

	}
	/*
	 * ===========================Duplicate checking for
	 * add========================
	 */
	@RequestMapping(value = "/bomDuplicateAddCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkBomNo(HttpServletRequest request,
			HttpServletResponse response, Bom bom) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String before = request.getParameter("material");
			pname = bomService.checkDuplicate(before);
			if (pname!= 0) {
				bom.setAid(2);

				request.setAttribute("addBomDuplicate",
						"Material is Already Exists Please try some other name");

				bom.setmId("");

				msg = "Material is Already Exists Please try some other name";

			}
			if (pname == 0) {
				bom.setAid(2);
				request.setAttribute("addBomDuplicate",
						"Material is Already Exists Please try some other name");
				bom.setmId("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	/* ================================Add Method========================== */
	@RequestMapping(value = "/bom", method = RequestMethod.GET)
	public String addBom(@ModelAttribute("bomCommand") Bom bomAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
	
		BomLine bomLine = null;
		List<BomLine> bomLines = null;
		String bomUpdate = null;
		String msg = null;

		 String checkMaterial = bomAdd.getBmaterial_Id();
	 int list1 = bomService.checkDuplicate(checkMaterial);
	

		try {
			if (list1 == 0) {

			bomLines = new ArrayList<BomLine>();

			String material = bomAdd.getmId();
			List<String> mlist = Arrays.asList(material.split(","));
			Object[] materialiid = mlist.toArray();

			Integer[] quantity = bomAdd.getQuantity();
			String unit = bomAdd.getUomm();
			List<String> uomlist = Arrays.asList(unit.split(","));
			Object[] uomid = uomlist.toArray();

			Integer[] explosion = bomAdd.getExplosionLevel();

			Integer[] predessor = bomAdd.getPredessor();
			
			String parentMaterial = bomAdd.getParentMat();
			List<String> parentMlist = Arrays.asList(parentMaterial.split(","));
			Object[] parentMaterials = parentMlist.toArray();

			for (int i = 0; i < quantity.length; i++) {
				bomLine = new BomLine();
				bomLine.setMaterial_Id(materialiid[i].toString());
				bomLine.setQuantity(quantity[i]);
				bomLine.setUom_Id(uomid[i].toString());
				bomLine.setExplosionLevel(explosion[i]);
				bomLine.setPredessor(predessor[i]);
				bomLine.setParentMaterial(parentMaterials[i].toString());

				bomLines.add(bomLine);

			}
			bomAdd.setBomLine(bomLines);
			msg = bomService.addBom(bomAdd);
			
		
		if (msg.equals("S")) {
			 Date date = new Date();
				session=request.getSession(false);
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","BOM","ROW" ,String.valueOf(bomAdd.getBomId()),"1",modifiedDate,session.getAttribute("userName").toString());
			return "redirect:Bom.mnt?list=" +"success"+"";
		}
			
		else
		{
			return "redirect:Bom.mnt?listwar=" +"fail"+"";
		}
		}
		 else 
		 { 
			 bomAdd.setAid(1);
		  request.setAttribute("addBomDuplicate",
		  "Material is Already Exists Please try some other name");
		  return "bomHome"; 
		  }
		 
	}
catch (Exception e) {
		e.printStackTrace();
		return "redirect:Bom.mnt?listwar=" +"fail"+"";
	}
		 
	}

	/*
	 * =============================Search
	 * Method======================================
	 */
	@RequestMapping(value = "/bomSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchBom(@ModelAttribute("bomCommand") Bom bomSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Bom> bom = null;
		List<Object[]> list = null;
		try {

			String dbField = bomSearch.getXmlLabel();
			String operation = bomSearch.getOperations();
			String basicSearchId = bomSearch.getBasicSearchId();

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

				list = bomService.searchBom();
				bom = new ArrayList<Bom>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					Bom bList = new Bom();
					bList.setBomId((Integer) objects[0]);
					Material materialBean = ((Material) objects[1]);
					bList.setBmaterial_Id(materialBean.getMaterialName());

					Plant plantBean = ((Plant) objects[2]);
					bList.setPlant_Id(plantBean.getPlantName());

					bList.setUsage((String) objects[3]);

					BomCategory bomCategoryBean = ((BomCategory) objects[4]);
					bList.setBomCategoryId(bomCategoryBean.getBomCategory());
					bList.setRevisionLevel((String) objects[5]);
					bList.setBomNumber((String) objects[6]);

					bom.add(bList);

				}

			} else {

				list = bomService.basicSearchBom(dbField, operation,
						basicSearchId);
				bom = new ArrayList<Bom>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					Bom bList = new Bom();
					bList.setBomId((Integer) objects[0]);

					Material materialBean = ((Material) objects[1]);
					bList.setBmaterial_Id(materialBean.getMaterialName());

					Plant plantBean = ((Plant) objects[2]);
					bList.setPlant_Id(plantBean.getPlantName());
					bList.setUsage((String) objects[3]);

					BomCategory bomCategoryBean = ((BomCategory) objects[4]);
					bList.setBomCategoryId(bomCategoryBean.getBomCategory());
					bList.setRevisionLevel((String) objects[5]);
					bList.setBomNumber((String) objects[6]);

					bom.add(bList);
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bomHome");
		modelAndView.addObject("bomCommand");
		request.setAttribute("bomSearch", bom);
		return modelAndView;
	}
	/**
	 * ========================================Duplicate Checking for
	 * edit===========================
	 */
	@RequestMapping(value = "/bomDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, Bom bomedit) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String beforeedit = request.getParameter("materialId");
			int iid = Integer.parseInt(request.getParameter("bid"));
			pname = bomService.checkEditDuplicate(beforeedit, iid);
			if (pname != 0) {
				bomedit.setBomIdEditt(1);
				request.setAttribute("updateBomDuplicate",
						"Material is Already Exists Please try some other name");
				bomedit.setmIdEditt("");

				msg = "Material is Already Exists Please try some other name";

			}
			if (pname == 0) {
				bomedit.setBomIdEditt(1);
				request.setAttribute("updateBomDuplicate",
						"Material is Already Exists Please try some other name");
				bomedit.setmIdEditt("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =====================================Edit
	 * Method==============================
	 */
	@RequestMapping(value = "/bomIdEdit1", method = RequestMethod.GET)
	@Scope("request")
	public String bomEdit(@ModelAttribute("bomCommand") Bom bomIdEdit1, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object> list = null;
		List<Bom> bomEditList = new ArrayList<Bom>();
		List<BomLine> bomLineEditList = new ArrayList<BomLine>();
		int bomid = bomIdEdit1.getBomId();

		try {

			list = bomService.editBomWithId(bomid);

			Iterator<Object> iterator = list.iterator();

			if (iterator.hasNext()) {
				Object bomObj = iterator.next();
				Bom bom = (Bom) bomObj;

				bomIdEdit1.setBomIdEditt(bom.getBomId());
				bomIdEdit1.setBmaterial_IdEditt(bom.getBmaterial_Id());
				bomIdEdit1.setPlant_IdEditt(bom.getPlant_Id());
				bomIdEdit1.setUsageEditt(bom.getUsage());

				bomIdEdit1.setBomCategoryIdEditt(bom.getBomCategoryId());

				bomIdEdit1.setRevisionLevelEditt(bom.getRevisionLevel());
				bomIdEdit1.setBomNumberEditt(bom.getBomNumber());
				bomIdEdit1.setQtyEdit(bom.getQty());
				bomIdEdit1.setuOMIdEdit(bom.getuOMId());

				List<BomLine> listEdit = bom.getBomLine();

				Iterator<BomLine> iterator1 = listEdit.iterator();
				while (iterator1.hasNext()) {
					Object bomLineObj = iterator1.next();
					BomLine bomLine = (BomLine) bomLineObj;
					BomLine bomMultiple = new BomLine();
					bomMultiple.setBomLineId(bomLine.getBomLineId());

					Material material = bomLine.getMaterialDetails();
					
					Material parentMaterial=bomLine.getParentMaterialDetails();
					
					Uom uom = bomLine.getUomDetails();
					bomMultiple.setMaterial_IdEditt((bomLine.getMaterial_Id()));
					bomMultiple.setMaterialName(material.getMaterialName());
					bomMultiple.setQuantityEditt((bomLine.getQuantity()));
					bomMultiple.setUom_IdEditt(bomLine.getUom_Id());

					bomMultiple.setUomName(uom.getUom());
					bomMultiple.setExplosionLevelEditt(bomLine.getExplosionLevel());
					bomMultiple.setPredessorEditt(bomLine.getPredessor());
					bomMultiple.setParentMaterialEditt(bomLine.getParentMaterial());
					bomMultiple.setParentMaterialName(parentMaterial.getMaterialName());
					bomLineEditList.add(bomMultiple);

				}
				bomEditList.add(bomIdEdit1);

			}

			model.addAttribute("bomCommand", bomIdEdit1);
			request.setAttribute("bomEditList", bomEditList);
			request.setAttribute("bomLineEditList", bomLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "bomHome";

	}

	/* ===================================Update Method======================== */
	@RequestMapping(value = "/bomEdit", method = RequestMethod.GET)
	public String updateBom(@ModelAttribute("bomCommand") Bom bomEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		BomLine bomLine = null;
		List<BomLine> bomLines = null;
		String bomUpdate = null;

		List<String> list = new ArrayList<String>();
		String msg = null;
		String checkMaterial = bomEdit.getBmaterial_IdEditt();
		
		int id = bomEdit.getBomIdEditt();
		
		 int list1 = bomService.checkEditDuplicate(checkMaterial, id);
	
		if (list1 == 0) {
		

		try {
			bomEdit.setBomId(id);
			bomEdit.setBmaterial_Id(bomEdit.getBmaterial_IdEditt());
			bomEdit.setPlant_Id(bomEdit.getPlant_IdEditt());
			bomEdit.setUsage(bomEdit.getUsageEditt());
			bomEdit.setBomCategoryId(bomEdit.getBomCategoryIdEditt());
			bomEdit.setRevisionLevel(bomEdit.getRevisionLevelEditt());
			bomEdit.setBomNumber(bomEdit.getBomNumberEditt());
			bomEdit.setQty(bomEdit.getQtyEdit());
			bomEdit.setuOMId(bomEdit.getuOMIdEdit());

			bomLines = new ArrayList<BomLine>();

			int[] bomIdUpdate = bomEdit.getBomLineIdEditt();

			String materialedit = bomEdit.getmIdEditt();
			List<String> meditlist = Arrays.asList(materialedit.split(","));
			Object[] materialiidedit = meditlist.toArray();

			Integer[] quantity = bomEdit.getQuantityEditt();

			String unitedit = bomEdit.getUommEditt();
			List<String> uomeditlist = Arrays.asList(unitedit.split(","));
			Object[] uomidedit = uomeditlist.toArray();

			Integer[] explosionLevel = bomEdit.getExplosionLevelEditt();
			Integer[] predessor = bomEdit.getPredessorEditt();

			String parentMaterialedit = bomEdit.getParentMatEditt();
			List<String> parentMateditlist = Arrays.asList(parentMaterialedit.split(","));
			Object[] parentMatedit = parentMateditlist.toArray();
			
			
			String idQL = null;

			for (int i = 0; i < quantity.length; i++) {
				bomLine = new BomLine();

				bomLine.setMaterial_Id(materialiidedit[i].toString());
				bomLine.setQuantity(quantity[i]);
				bomLine.setUom_Id(uomidedit[i].toString());
			
				bomLine.setExplosionLevel(explosionLevel[i]);
				bomLine.setPredessor(predessor[i]);
                bomLine.setParentMaterial(parentMatedit[i].toString());
                bomLine.setMaterialDetails(new Material());
                bomLine.setParentMaterialDetails(new Material());
               
         
				
                int bomLineId = bomIdUpdate[i];

				String ch = "1", ch1 = "0";
				idQL = request.getParameter(bomLineId + "Check");
				
				if (ch.equals(idQL)) {
					String mesg=bomService.deleteBomLine(bomLineId);
					

				}

				if (ch1.equals(idQL) || idQL == null) {
					 bomLines.add(bomLine);
					bomEdit.setBomLine(bomLines);
				}

			}
			
			//bomEdit.setMaterialBean(new Material());
			msg = bomService.updateBom(bomEdit);
			
if(msg.equals("S"))
{
	
			request.setAttribute("bomUpdate",
					"Bom Details Updated Successfully");
}
else
{
	request.setAttribute("bomUpdateFail",
			"Bom Details did not Updated");
}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
	
    else {
	
	 request.setAttribute("bomEditList", "bomEditList");
	request.setAttribute("updateBomDuplicate",
	 "Material is Already Exists Please try some other name"); 
	return "bomHome";
	  }
	 return "bomHome";
	}
	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/bomIdDelete", method = RequestMethod.GET)
	public String bomDelete(@ModelAttribute("bomCommand") Bom bom, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
	

		String bomUpdate = null;
		int id = Integer.parseInt(request.getParameter("bomId"));

		try {
			model.addAttribute("bomCommand", new Bom());
			String msg = bomService.deleteBom(id);
			if (msg.equals("S")) {
				Date date = new Date();
				session=request.getSession(false);
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","BOM","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			request.setAttribute("bomDelete","success");
			}
			else {
			
				request.setAttribute("bomDeleteFail","fail");
				return "bomHome";
			}

		

		} catch (Exception e) {
			request.setAttribute("bomDeleteFail","fail");
			e.printStackTrace();
		}
		return "bomHome";
	}
	@RequestMapping(value="/bomAdvanceSearch",method=RequestMethod.GET)
	public  String bomAdvanceSearch(@ModelAttribute("bomCommand") Bom bom,HttpServletRequest request,HttpServletResponse response)
	{
		
		String name1="bom",s1=null,s2=null;

		 List<Object[]> returnString = null;
		
		 bomList=new ArrayList<Bom>();
		 bom.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			
			for (Object[] object : returnString) {
				Bom b=new Bom();
				
				s1=(String)object[0];
				s2=(String)object[1];
				b.setFirstLabel(s1);
				
				b.setSecondLabel(s2);
				bomList.add(b);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  request.setAttribute("bomSearchAdvance",bomList);
		  return "bomHome";
	}
	
	
	
	@RequestMapping(value = "/bomAdvanceSearchOperations", method= RequestMethod.POST)
	public  String bomAdvanceSearchOperations(@ModelAttribute("bomCommand") Bom bom,HttpServletRequest request,HttpServletResponse response,Model model)
	{   
	
	     bom1=new ArrayList<Bom>();
	    String columns=bom.getFirstLabel();
	    String operations=bom.getOperations1();
	    String advanceSearchText=bom.getAdvanceSearchText();
	   
   	    if(advanceSearchText.length()!=0)
   	    {
   	  
	    objectsArray= bomService.getBomAdvance(columns, operations, advanceSearchText);
   	    }
   	    else
   	    {
   	     objectsArray= bomService.getBom("ALL");
   	    }
	    iterator=objectsArray.iterator();
	   while(iterator.hasNext())
	   {
		   bo=new com.mnt.erp.bean.Bom();
		  objects2=(Object[])iterator.next();
		    bo.setBomId((Integer) objects2[0]);
			Material materialBean = ((Material) objects2[1]);
			bo.setBmaterial_Id(materialBean.getMaterialName());

			Plant plantBean = ((Plant) objects2[2]);
			bo.setPlant_Id(plantBean.getPlantName());

			bo.setUsage((String) objects2[3]);

			BomCategory bomCategoryBean = ((BomCategory) objects2[4]);
			bo.setBomCategoryId(bomCategoryBean.getBomCategory());
			bo.setRevisionLevel((String) objects2[5]);
			bo.setBomNumber((String) objects2[6]);

		
		   bom1.add(bo);
		 
	   }
	
	   request.setAttribute("bomSearch",bom1);
       model.addAttribute("bom",new Bom());
       bom.setAdvanceSearchHidden(0);
	    return "bomHome";
		}


}
