/**
 * 
 */
package com.mnt.erp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mnt.erp.bean.ProjectTaskDocument;
import com.mnt.erp.dao.ImageUploadDao;

/**
 * @author venkateshp
 *
 */
@Component
@Path("/imageData")
public class ImageUploadWebService {
public static	Logger logger=Logger.getLogger(ImageUploadWebService.class);
	
	@Context
	private ServletContext context;
	@Autowired
	private ImageUploadDao imageUploadDao;
	@POST
	@Path("/uploadData")
	public String uploadImage(InputStream inputStream)
	{
		String succmessages="F";
		try
		{
	
		logger.info("dao iss=="+imageUploadDao);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		   String dt = date.getYear()+date.getMonth()+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds()+""+System.currentTimeMillis();
		String uploadedFileLocation= context.getRealPath("/DownloadedFiles/"+dt+".jpg");
		succmessages=writeToFile(inputStream,uploadedFileLocation);
		logger.info("fileLocation iss=="+uploadedFileLocation);
		if(succmessages.equals("S"))
		{
			logger.info("File Downloaded Successfully...Location iss=="+uploadedFileLocation);
	ProjectTaskDocument bean=new ProjectTaskDocument();
			bean.setDocumentPath(uploadedFileLocation);
			bean.setProjectTaskId(1);
			bean.setProjectTaskDocument("hello");
			
		boolean flag=imageUploadDao.saveImagePath(bean);
		}
		else
		{
			logger.info("File did not Download");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succmessages;

	}

	// save uploaded file to new location
	private String writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {
		String sucmess="F";

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));

			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
			sucmess="S";
		} catch (IOException e) {
			sucmess="F";
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return sucmess;

	}
	
	

}
