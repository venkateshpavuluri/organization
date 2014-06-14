package com.mnt.erp.controller;

/**
 * @author Srinivas

 */
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ProcessBean;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.ProcessTypeBean;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ProcessService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class ProcessController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	ProcessService processService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired AuditLogService auditLogService;
	
	HttpSession session;
	
	String msg = null;
	ProcessBean bean = null;
	String message = null;
	@RequestMapping(value = "/processHome", method = RequestMethod.GET)
	public String getProcess(@ModelAttribute ProcessBean processbean,
			SessionStatus status, Model model,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("processHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("Process", new ProcessBean());

		return "processHome";
	}
	@RequestMapping(value = "/processDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkProcessname(HttpServletRequest request,
			HttpServletResponse response, ProcessBean processbean) {
		
		Long pname = null;

		try {

			String before = request.getParameter("processname");
			pname = processService.getprocesscount(before);
			if (pname != 0) {
				processbean.setProcesshide(2);

				processbean.setProcess("");

				msg = "Warning ! Process is already exists. Please try some other name";

			}
			if (pname == 0) {
				processbean.setProcesshide(2);
				/*
				 * request.setAttribute("processdup",
				 * "Warning ! Process already Exists");
				 */
				processbean.setProcess("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@ModelAttribute("MaterialProcess")
	public Map<Integer, String> populateItemCategoryids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = processService.selectMaterialservice();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	
	@RequestMapping(value = "/saveProcess", method = RequestMethod.GET)
	public String saveProcess(
			@ModelAttribute("Process") ProcessBean processbean,
			ProcessDetailBean processDetailBean, BindingResult result,
			HttpServletRequest request,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		String msg = null;
		String processsuccess = null;
		String processdup = null;
		List<String> list = null;
		String name = processbean.getProcess();
		String desc = processDetailBean.getProcessdescription();
		Long id = 0L;
		Long pid = 0l;

		List<ProcessDetailBean> detailBeans = new ArrayList<ProcessDetailBean>();

		try {
			id = processService.getprocesscount(name);
			pid = processService.getProcessDetailCount(desc);
			if (id == 0 && pid == 0) {
				int processseq[] = processbean.getProcessseq();

				
				String processdesc[] = processbean.getProcessdescription();
				if (processdesc != null) {
					String processtyp = processbean.getProcesstypeid1();
					List<String> ptypelist = Arrays.asList(processtyp
							.split(","));
					Object[] processtype = ptypelist.toArray();
					String predessor[] = processbean.getPredessor();
					String successor[] = processbean.getSuccessor();
					String stageinspection = processbean.getStageinspection1();
					List<String> silist = Arrays.asList(stageinspection
							.split(","));
					Object[] stageinsp = silist.toArray();
					String serialcontrol = processbean.getSerialcontrol1();
					List<String> sclist = Arrays.asList(serialcontrol
							.split(","));
					Object[] scontrol = sclist.toArray();
					int inspectionpct[] = processbean.getInspectionpct();

					for (int p = 0; p < processdesc.length; p++) {

						ProcessDetailBean processDetailBean2 = new ProcessDetailBean();
						processDetailBean2.setProcessseq(processseq[p]);
						processDetailBean2.setProcesstypeid(processtype[p]
								.toString());
						processDetailBean2
								.setProcessdescription(processdesc[p]);
						processDetailBean2.setPredessor(predessor[p]);
						processDetailBean2.setSuccessor(successor[p]);
						processDetailBean2.setStageinspection(stageinsp[p]
								.toString());
						processDetailBean2.setSerialcontrol(scontrol[p]
								.toString());
						processDetailBean2.setInspectionpct(inspectionpct[p]);
						detailBeans.add(processDetailBean2);

					}
					processbean.setProcessdetailbean(detailBeans);
				}
			String msgg=processService.saveProcessService(processbean);
			if(msgg.equals("S"))
			{

				  Date date = new Date();
					session=request.getSession(false);
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Process","ROW" ,String.valueOf(processbean.getProcessid()),"1",modifiedDate,session.getAttribute("userName").toString());
				return "redirect:processHome.mnt?list=" + "success" + "";
			}
			else
			{
				return "redirect:processHome.mnt?listwar=" + "fail" + "";
			}
			} else {
				processdup = "Process already Exists please Enter Other ";
				processbean.setProcesshide(1);
				request.setAttribute("processdup", processdup);
				return "processHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:processHome.mnt?listwar=" + "fail" + "";
		}

	}

	

	@ModelAttribute("processSearch")
	public Map<Integer, String> populateProcessids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = processService.selectProcessService();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("processtypesearch")
	public Map<Integer, String> populateProcessTypeid() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = processService.selectProcessTypeDetailService();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	@RequestMapping(value = "/searchProcess", method = RequestMethod.GET)
	public String searchProcessIds(
			@ModelAttribute("Process") ProcessBean processBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			int iid = processBean.getProcessid();
			List<ProcessBean> processBeans = new ArrayList<ProcessBean>();
			String dbField = processBean.getXmlLabel();
			String operation = processBean.getOperations();
			String basicSearchId = processBean.getBasicSearchId();

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
				list = processService.searchProcessService();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					ProcessBean processBean2 = new ProcessBean();
					processBean2.setProcessid((Integer) obj[0]);
					processBean2.setProcess((String) obj[1]);
					Material mp=(Material)obj[2];
					processBean2.setMaterialprocess(mp.getMaterialName());
					processBean2.setVersion((String)obj[3]);
					processBeans.add(processBean2);

				}

			} else {

				list = processService.basicSearchProcess(dbField, operation,
						basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					ProcessBean processBean2 = new ProcessBean();
					processBean2.setProcessid((Integer) obj[0]);
					processBean2.setProcess((String) obj[1]);
					Material mp=(Material)obj[2];
					processBean2.setMaterialprocess(mp.getMaterialName());
					processBean2.setVersion((String)obj[3]);
					processBeans.add(processBean2);
				}
			}
			request.setAttribute("processBeans", processBeans);

			// model.addAttribute("Process", new ProcessBean());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "processHome";
	}

	@RequestMapping(value = "/processEdit", method = RequestMethod.GET)
	public String editProcess(
			@ModelAttribute("Process") ProcessBean processBean,
			BindingResult result, HttpServletRequest request, Model model) {
		List<ProcessBean> processeditlist = new ArrayList<ProcessBean>();
		List<ProcessDetailBean> pdbeditlist = new ArrayList<ProcessDetailBean>();
		// int processId = processBean.getProcessid();
		int processId = Integer.parseInt(request.getParameter("processedit"));

		try {
			List<ProcessBean> list = processService.EditProcess(processId);
			Iterator<ProcessBean> iter = list.iterator();
			if (iter.hasNext()) {
				Object object = iter.next();
				ProcessBean pb = (ProcessBean) object;

				processBean.setProcessidedit(pb.getProcessid());
				processBean.setProcessedit(pb.getProcess());
				processBean.setMaterialprocessEdit(pb.getMaterialprocess());
				processBean.setVersionEdit(pb.getVersion());
				List<ProcessDetailBean> listEdit = pb.getProcessdetailbean();

				Iterator<ProcessDetailBean> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					ProcessDetailBean pdbedit = (ProcessDetailBean) object2;
					// ProcessBean pdb=(ProcessBean)object2;

					ProcessDetailBean Pdedit = new ProcessDetailBean();
					Pdedit.setProcessdetailidedit(pdbedit.getProcessdetailid());

					Pdedit.setProcessseqedit(pdbedit.getProcessseq());
					ProcessTypeBean ptb = (ProcessTypeBean) pdbedit.getPtbean();
					Pdedit.setProcesstypeidedit(Integer.toString(ptb
							.getProcesstypeid()));
					Pdedit.setProcessTypeName(ptb.getProcesstype());
					Pdedit.setProcesstypeidedit2(ptb.getProcesstypeid());
					
					Pdedit.setProcessdetailid(pdbedit.getProcessdetailid());

					Pdedit.setProcessdescriptionedit(pdbedit
							.getProcessdescription());
					Pdedit.setPredessoredit(pdbedit.getPredessor());
					Pdedit.setSuccessoredit(pdbedit.getSuccessor());

					int convertsi = Integer.parseInt(pdbedit
							.getStageinspection());

					String y = null;
					String n = null;
					if (convertsi == 1) {
						y = "Yes";

					} else {
						y = "No";
					}
					Pdedit.setStageinspectionedit(y);
					Pdedit.setStageinspectionedit2(pdbedit.getStageinspection());

					int convertsc = Integer
							.parseInt(pdbedit.getSerialcontrol());
					if (convertsc == 1) {
						n = "Yes";

					} else {
						n = "No";
					}
					Pdedit.setSerialcontroledit(n);
                     Pdedit.setSerialcontroledit2(pdbedit.getSerialcontrol());
                    
					// Pdedit.setSerialcontroledit(y);
					Pdedit.setInspectionpctedit(pdbedit.getInspectionpct());
					pdbeditlist.add(Pdedit);

				}
				processBean.setProcessdetaileditlist(pdbeditlist);
				processeditlist.add(processBean);

			}
			request.setAttribute("editvalues", processeditlist);
			request.setAttribute("processDetailBeans", pdbeditlist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "processHome";

	}
	@RequestMapping(value = "/processDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkProcessnameEdit(HttpServletRequest request,
			HttpServletResponse response, ProcessBean processbean) {
	
		Long pname = null;

		try {

			String beforeedit = request.getParameter("processnameedit");
			int id = Integer.parseInt(request.getParameter("processid"));

			pname = processService.getProcessDetailedit(beforeedit, id);
			if (pname != 0) {
				processbean.setProcesshideedit(1);

				/*
				 * request.setAttribute("processduplicatemessage",
				 * "Warning ! Process already Exists");
				 */

				processbean.setProcessedit("");

				msg = "Warning ! Process is already exists. Please try some other name";

			}
			if (pname == 0) {
				processbean.setProcesshideedit(1);
				/*
				 * request.setAttribute("processduplicatemessage",
				 * "Warning ! Process already Exists");
				 */
				processbean.setProcessedit("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/processdescriptionDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkProcessDescname(HttpServletRequest request,
			HttpServletResponse response, ProcessDetailBean processdetailbean) {
	
		Long pdname = null;

		try {

			String before = request.getParameter("processdesc");

			pdname = processService.getProcessDetailCount(before);
			if (pdname != 0) {

				processdetailbean.setProcesshide(1);

				/*
				 * request.setAttribute("processdup",
				 * "Warning ! Process Description already Exists");
				 */

				processdetailbean.setProcessdescription("");

				message = "Warning ! Process Description is already exists. Please try some other name";

			}
			if (pdname == 0) {
				processdetailbean.setProcesshide(2);
				/*
				 * request.setAttribute("processdup",
				 * "Warning ! Process Description already Exists");
				 */
				processdetailbean.setProcessdescription("");

				message = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@RequestMapping(value = "/processDescDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkProcessdescriptionEdit(HttpServletRequest request,
			HttpServletResponse response, ProcessDetailBean processdetailbean) {
		
		Long pname = null;

		try {

			String beforeedit = request.getParameter("processdescedit");
			int id = Integer.parseInt(request.getParameter("processid"));

			pname = processService.getProcessDescriptionedit(beforeedit, id);
			if (pname != 0) {
				processdetailbean.setProcesshideedit(1);

				/*
				 * request.setAttribute("processduplicatemessage",
				 * "Warning ! Process already Exists");
				 */

				processdetailbean.setProcessdescriptionedit("");

				msg = "Warning ! Process Description is already exists. Please try some other name";

			}
			if (pname == 0) {
				processdetailbean.setProcesshideedit(1);
				/*
				 * request.setAttribute("processduplicatemessage",
				 * "Warning ! Process already Exists");
				 */
				processdetailbean.setProcessdescriptionedit("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@RequestMapping(value = "/processUpdate", method = RequestMethod.POST)
	public String updateProcess(
			@ModelAttribute("Process") ProcessBean processBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String name = processBean.getProcessedit();
		int processdid = processBean.getProcessidedit();
		
		Long id = 0l;
		Long pid = 0l;
		List<ProcessDetailBean> processdblist = new ArrayList<ProcessDetailBean>();
		List<ProcessDetailBean> processdb = new ArrayList<ProcessDetailBean>();
		String message = null;
		processBean.setProcessid(processdid);
		processBean.setProcess(name);
processBean.setMaterialprocess(processBean.getMaterialprocessEdit());
processBean.setVersion(processBean.getVersionEdit());
		int processdetailid[] = processBean.getProcessdetailidedit();
		int processdetaiilseq[] = processBean.getProcessseqedit();
		if (processdetaiilseq != null) {
		String processdetailtypeid = processBean.getProcesstypeidedit1();
		List<String> ptypelistedit = Arrays.asList(processdetailtypeid
				.split(","));
		Object[] processdetailedittype = ptypelistedit.toArray();

		String processdetaildesc[] = processBean.getProcessdescriptionedit();

		String processdetailpredessor[] = processBean.getPredessoredit();
		String processdetailsuccessor[] = processBean.getSuccessoredit();
		String processdetai[] = processBean.getStageinspectionedit1();
		
		for(int i=0;i<processdetai.length;i++ ){
			
		
		if (processdetai[i].equals("Yes")) {
			processdetai[i] = "1";
			//System.out.println("values are"+processdetai[i]);
		} else {
			processdetai[i] = "0";
		}
		
		}
		String processdetailserialcontrol[] = processBean.getSerialcontroledit1();
		
		for(int i=0;i<processdetailserialcontrol.length;i++ ){
           if (processdetailserialcontrol[i].equals("Yes")) {
        	   processdetailserialcontrol[i] ="1";
	                
         } else {
        	 processdetailserialcontrol[i] = "0";
         }
		}
		
		int processdetailinspection[] = processBean.getInspectionpctedit();
		String checked = "", s1 = "0", s2 = "1";

		if (processdetaiilseq.length == 0) {

		} else {

			for (int n = 0; n < processdetaiilseq.length; n++) {

				int processdetailId = processdetailid[n];
				if (processdetailId == 0) {

					ProcessDetailBean pdb = new ProcessDetailBean();
					pdb.setProcessdetailid(processdetailid[n]);
					pdb.setProcessseq(processdetaiilseq[n]);
					pdb.setProcesstypeid(processdetailedittype[n].toString());

					pdb.setProcessdescription(processdetaildesc[n]);
					pdb.setPredessor(processdetailpredessor[n]);
					pdb.setSuccessor(processdetailsuccessor[n]);
					pdb.setStageinspection(processdetai[n]);
					pdb.setSerialcontrol(processdetailserialcontrol[n]);
					pdb.setInspectionpct(processdetailinspection[n]);

					
					processdblist.add(pdb);
				} else {

					ProcessDetailBean pdbj = new ProcessDetailBean();
					pdbj.setProcessdetailid(processdetailid[n]);
					pdbj.setProcessseq(processdetaiilseq[n]);
					pdbj.setProcesstypeid(processdetailedittype[n].toString());

					pdbj.setProcessdescription(processdetaildesc[n]);
					pdbj.setPredessor(processdetailpredessor[n]);
					pdbj.setSuccessor(processdetailsuccessor[n]);
					pdbj.setStageinspection(processdetai[n]);
					pdbj.setSerialcontrol(processdetailserialcontrol[n]);
					pdbj.setInspectionpct(processdetailinspection[n]);

					int ss = processdetailid[n];

					checked = request.getParameter("Check" +ss);

					if (s1.equals(checked) || checked == null) {

						processdblist.add(pdbj);
					}
					if (s2.equals(checked)) {
						// delte ss
						processService.deleteChildDetailsService(ss);

					}

					// processdblist.add(pdbj);

				}
			}

			processBean.setProcessdetailbean(processdblist);

			id = processService.getProcessDetailedit(name, processdid);

		}
		}
				try {

					message = processService.updateProcessService(processBean);

					if (message.equals("S")) {
						request.setAttribute("processUpdate",
								"Process Details  Data Updated Successfully");
					} else {
						request.setAttribute("ProcessUpdateFail",
								"Process Details  Data did not Updated ");
					}

				} catch (Exception e) {
					request.setAttribute("processUpdateFail",
							"Process Details  Data did not Updated ");
					e.printStackTrace();
				}
			
		return "processHome";
	}

	@RequestMapping(value = "/processDelete", method = RequestMethod.GET)
	public String processDelete(@ModelAttribute("Process") ProcessBean pbdelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int Id = 0;
		String processdel=null;
		try {
			Id = Integer.parseInt(request.getParameter("processdelete"));
pbdelete.setMaterialbean(new Material());
			String msg = processService.deleteProcessService(Id);
			if (msg.equals("S")){
				  Date date = new Date();
					session=request.getSession(false);
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Process","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("processDelete",
						"Process Data Deleted Successfully");
			model.addAttribute("Process", new ProcessBean());
			}else{
			
				request.setAttribute("processDeleteFail","Process Data is Not Deleted Properly");
				model.addAttribute("Process", new ProcessBean());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "processHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "processid";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
