package com.mnt.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Document;
import com.mnt.erp.bean.DocumentCategory;
import com.mnt.erp.bean.DocumentObject;
import com.mnt.erp.bean.DocumentType;
import com.mnt.erp.bean.ObjectBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.service.DocumentService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class DocumentController {
	@Autowired
    DocumentService DocumentService;
    @Autowired
    XmlLabelsService xmlService;

    @Autowired
	ServletContext servletContext;
    @Autowired
    PopulateService populateService;
    @RequestMapping(value = "/Document", method = RequestMethod.GET)
    public ModelAndView getResourceRequest(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	return new ModelAndView("DocumentHome",
		"documentCommand", new Document());
    }
    @ModelAttribute("documentCategory")
    public Map<Integer, String> populateDocumentCategory() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select d.documentcategoryid,d.documentcategory from DocumentCategory d");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("documentType")
    public Map<Integer, String> populateDocumentType() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select d.documentType_Id,d.documentType from DocumentType d");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    
    @ModelAttribute("department")
    public Map<Integer, String> populateDepartment() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select d.departmentId,d.department from Department d");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("objects")
    public Map<Integer, String> populateObject() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select d.objectId,d.object from ObjectBean d");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("employee")
    public Map<Integer, String> populateEmployee() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select e.employee_Id,e.fName from Employee e");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("status")
    public Map<Integer, String> populateStatus() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select s.statusId,s.status from Status s");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("document")
    public Map<Integer, String> populateDocument() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select d.documentId,d.documentName from Document d");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @RequestMapping(value = "/DocumentAdd", method = RequestMethod.POST)
    public String saveDocumentAdd(
	    @ModelAttribute("documentCommand") Document DocumentAdd,
	    HttpServletRequest request, SessionStatus status,
	    HttpServletResponse response,@RequestParam("documentFile") MultipartFile file1) {
	response.setCharacterEncoding("UTF-8");
	String msg = null;
	String res = null;
	List<DocumentObject> DocumentSchCat = null;
	DocumentObject DocumentSchCa = null;
	String id = DocumentAdd.getDocumentName();
	Long s = DocumentService.checkDocument(id);
	UUID idOne = UUID.randomUUID();
	String resumesFile=null;
	String originalPath=null;
	DocumentAdd.setDocumentUID(String.valueOf(idOne));
	System.out.println("the uid is:"+DocumentAdd.getDocumentUID());
	//System.out.println("the path is:"+DocumentAdd.getPath());
	if (s == 0) {
	    try {

		String schDate = DocumentAdd.getObjectRefId();
		if (schDate != null) {

		    List<String> schDatelist = Arrays
			    .asList(schDate.split(","));
		    Object[] schDates = schDatelist.toArray();

		    String maintencCate = DocumentAdd
			    .getObjectId();
		    List<String> maintencCateList = Arrays.asList(maintencCate
			    .split(","));
		    Object[] maintencCateids = maintencCateList.toArray();
		    DocumentSchCat= new ArrayList<DocumentObject>();
			for (int i = 0; i < schDates.length; i++) {
			
				DocumentSchCa = new DocumentObject();
				DocumentSchCa.setObjectRefId(schDates[i].toString());
			
				DocumentSchCa.setObjectId(maintencCateids[i].toString());
				
				DocumentSchCat.add(DocumentSchCa);
		
	
			}
			DocumentAdd.setDocumentObject(DocumentSchCat);
			resumesFile=servletContext.getRealPath("/Documents");
			System.out.println("pPath:"+resumesFile);
			
			Date date=new Date();
			   String dt = date.getYear()+date.getMonth()+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds()+""+System.currentTimeMillis();
			   File file=new File(resumesFile+"/"+dt);
				file.mkdir();
			originalPath=resumesFile+"\\"+dt+"\\"+dt+".txt";
			//File files=new File(originalPath);
			InputStream inputStream=file1.getInputStream();
			
			java.io.OutputStream outputStream=new FileOutputStream(new File(originalPath));
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			inputStream.close();
			outputStream.close();
			
	
	
			DocumentAdd.setPath(originalPath);
		    msg = DocumentService
			    .saveDocumentDetails(DocumentAdd);
		    if (msg == "S") {
			res = "redirect:Document.mnt?list=" + "success"
				+ "";
		    } else {
			res = "redirect:Document.mnt?listwar=" + "fail"
				+ "";
		    }
		}
	    } catch (Exception e) {
		// res = "redirect:Document.mnt?listwar=" + "fail" + "";
		e.printStackTrace();

	    }
	    return res;

	} else {
	    DocumentAdd.setAid(1);

	    request.setAttribute("addPrivMainDuplicate",
		    "Equipment Already Exists Please try some other Equipment");
	    return "DocumentHome";
	}

    }

    @RequestMapping(value = "/DocumentSearch", method = RequestMethod.GET)
    public ModelAndView DocumentSearch(
	    @ModelAttribute("documentCommand") Document DocumentSearch,
	    Model model, HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<Object[]> list = null;
	List<Document> Document = new ArrayList<Document>();

	try {

	    String dbField = DocumentSearch.getXmlLabel();
	    String operation = DocumentSearch.getOperations();
	    String basicSearchId = DocumentSearch.getBasicSearchId();

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
		list = DocumentService.searchDocument();

	    } else {
		list = DocumentService.basicSearchDocument(
			dbField, operation, basicSearchId);

	    }

	    Iterator<Object[]> iterator = list.iterator();
	    while (iterator.hasNext()) {
		Document document = new Document();
		Object[] obj = (Object[]) iterator.next();
		document.setDocumentId((Integer)obj[0]);
		document.setDocumentName((String)obj[1]);
		document.setDocumentNo((String)obj[2]);
		DocumentCategory docCat=(DocumentCategory)obj[3];
		document.setDocumentCategoryName(docCat.getDocumentcategory());
		DocumentType docType=(DocumentType)obj[4];
		document.setDocumentTypeName(docType.getDocumentType());
		Status status=(Status)obj[5];
		document.setStatusName(status.getStatus());
		document.setPath((String)obj[6]);
		String s=document.getPath();
		System.out.println("the real path:"+document.getPath());
		String opath=s.replace("\\", "/");
		System.out.println("the path:"+opath);
		String[] resumepath=opath.split("/");
		System.out.println("the resume path:"+resumepath);

		System.out.println("the path:"+resumepath[resumepath.length-2]);
		String originaPath="Documents/"+resumepath[resumepath.length-2]+"/"+resumepath[resumepath.length-1];
		System.out.println("edit path iss=="+originaPath);
		document.setPath(originaPath);
		Document.add(document);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	request.setAttribute("preMainValues", "preMainValues");

	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("DocumentHome");
	modelAndView.addObject("Document", Document);
	return modelAndView;

    }
 
    @RequestMapping(value = "/DocumentEdit", method = RequestMethod.GET)
    public String editPrevMain(
	    @ModelAttribute("documentCommand") Document DocumentEdit,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<Document> preMainEdit = new ArrayList<Document>();

	List<DocumentObject> documentObjectList = new ArrayList<DocumentObject>();
	int id = Integer.parseInt(request.getParameter("DocumentId"));

	try {
	    List<Document> list = DocumentService
		    .searchDocumentWithId(id);
	    Iterator<Document> iter = list.iterator();
	    while (iter.hasNext()) {
		Object pobject = iter.next();
		Document resReq = (Document) pobject;
		DocumentEdit.setDocumentName(resReq.getDocumentName());
		DocumentEdit.setDocumentNo(resReq.getDocumentNo());
		DocumentEdit.setDocumentUID(resReq.getDocumentUID());
		DocumentEdit.setDocumentCategoryId(resReq.getDocumentCategoryId());
		DocumentEdit.setDocumentTypeId(resReq.getDocumentTypeId());
		DocumentEdit.setDocumentPart(resReq.getDocumentPart());
		DocumentEdit.setVersion(resReq.getVersion());
		DocumentEdit.setDescripion(resReq.getDescripion());
		DocumentEdit.setDepartmentId(resReq.getDepartmentId());
		DocumentEdit.setEmployeeId(resReq.getEmployeeId());
		DocumentEdit.setStatusId(resReq.getStatusId());
		DocumentEdit.setParentDocId(resReq.getParentDocId());
		System.out.println("the real path:"+resReq.getPath());
		String path=resReq.getPath().replace("\\", "/");
		String[] resumepath=path.split("/");
		System.out.println("the resume path:"+resumepath);
	String uid=resReq.getDocumentUID();
		System.out.println("the path:"+resumepath[resumepath.length-2]);
		String originaPath="Documents/"+resumepath[resumepath.length-2]+"/"+resumepath[resumepath.length-1];
		System.out.println("edit path iss=="+originaPath);
		DocumentEdit.setPath(originaPath);
		
System.out.println("the path is:"+DocumentEdit.getPath());
		// preMainEdit.add(resourceRequestEdit);

		List<DocumentObject> listEdit = resReq
			.getDocumentObject();

		Iterator<DocumentObject> iterate = listEdit.iterator();
		while (iterate.hasNext()) {
		    Object object2 = iterate.next();
		    DocumentObject resRdit = (DocumentObject) object2;

		    DocumentObject resReEdit = new DocumentObject();
		    resReEdit.setDocumentObjectIdEdit(resRdit
			    .getDocumentObjectId());
		    resReEdit.setObjectIdEdit(resRdit.getObjectId());
		 ObjectBean object=resRdit.getObjectBean();
		 resReEdit.setObjectName(object.getObject());
		    resReEdit.setObjectRefIdEdit(resRdit.getObjectRefId());
			 
		  

		    documentObjectList.add(resReEdit);

		}
		DocumentEdit
			.setDocumentObject(documentObjectList);

		preMainEdit.add(DocumentEdit);

	    }

	    request.setAttribute("preMainEdit", preMainEdit);

	    request.setAttribute("preMainCatList", documentObjectList);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "DocumentHome";
    }
 
    @RequestMapping(value = "/DocumentUpdate", method = RequestMethod.POST)
	public String DocumentUpdate(
			@ModelAttribute("documentCommand") Document DocumentUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<DocumentObject> resourceReqDetail = null;
		DocumentObject resoReqDetail=null;
		String msg=null;
		
		int id=DocumentUpdate.getDocumentId();
	String documentName=DocumentUpdate.getDocumentName();
	Long s=DocumentService.updateCheckDocument(documentName, id);

		if(s==0){
				try{
		
		String requiredDate = DocumentUpdate.getObjectRefId();

		if(requiredDate!=null){
		
		
	
		List<String> requiredDatelist = Arrays.asList(requiredDate.split(","));
		Object[] requiredDates = requiredDatelist.toArray();
		
					
		
		
	   
		String statuss = DocumentUpdate.getObjectIdEdit();
		
		List<String> statusList = Arrays.asList(statuss.split(","));
		Object[] statusids = statusList.toArray();
		
		int[] resReqIdUpdate = DocumentUpdate.getDocumentEditt();
	
		resourceReqDetail = new ArrayList<DocumentObject>();
		for (int i = 0; i < requiredDates.length; i++) {
		
			
			resoReqDetail.setDocumentObjectId(resReqIdUpdate[i]);
			resoReqDetail.setObjectRefId(requiredDates[i].toString());
			
			resoReqDetail.setObjectId(statusids[i].toString());
		
	
		int resDelId = resReqIdUpdate[i];
		
			String check = "1", check1 = "0";
			String egCheck = request.getParameter(resDelId + "Check");
			
			if (check.equals(egCheck)) {
				
				DocumentService.deleteDocumentDetail(resDelId);

			}

			if (check1.equals(egCheck) || egCheck == null) {
				
				resourceReqDetail.add(resoReqDetail);

			}

		}
			
		//resourceReqDetail.add(resoReqDetail);

		DocumentUpdate.setDocumentObject(resourceReqDetail);


		msg=DocumentService.updateDocument(DocumentUpdate);
		
		if(msg=="S"){
			request.setAttribute("prevMainUpdate", "Document has been updated");
		}
		else{
			request.setAttribute("prevMainUpdateError", "Document has not been updated");
		}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
				}
		else{
		
		//DocumentUpdate.setDocumentSchIdEdit(1);
		request.setAttribute("addPreMainEditDuplicate","Equipment Already Exists Please try some other Equipment");
		request.setAttribute("preMainEdit", "preMainEdit");
		return "DocumentHome";
		}
		return "DocumentHome";
	}

    @RequestMapping(value = "/DocumentDelete", method = RequestMethod.GET)
    public ModelAndView DocumentDelete(
	    @ModelAttribute("documentCommand") Document DocumentDelete,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	int id = Integer.parseInt(request.getParameter("DocumentId"));
	try {

	    String msg = DocumentService.deleteDocument(id);
	    if (msg == "S") {

		request.setAttribute("prevMainDelete",
			"Document has been deleted");

	    } else {

		request.setAttribute("prevMainDeleteError",
			"Document has not been deleted");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return new ModelAndView("DocumentHome",
		"documentCommand", new Document());
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "DocumentId";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
