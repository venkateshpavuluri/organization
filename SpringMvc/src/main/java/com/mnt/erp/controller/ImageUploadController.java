/**
 * 
 */
package com.mnt.erp.controller;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.ProjectTaskDocument;

/**
 * @author venkateshp
 *
 */
@Controller
public class ImageUploadController {
	Logger logger=Logger.getLogger(ImageUploadController.class);
	@RequestMapping(value = "/imageUploadHome", method = RequestMethod.GET)
	public String saveOrganization(@ModelAttribute("imageUpload") ProjectTaskDocument uploadBean,
			Model model, BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		
		return "imageUploadView";
	}
		
	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
	public @ResponseBody String saveImage(@ModelAttribute("imageUpload") ProjectTaskDocument uploadBean,
			Model model, BindingResult result, HttpServletRequest request,
			HttpServletResponse response,@RequestParam("imageFile") MultipartFile file1) {
		HttpURLConnection connection=null;
		
		String uri="http://localhost:8067/MNTERP/rest/imageData/uploadData";
		String uriEncode=urlEncode(uri);	
		int ch=0;
		char ch1='a';
		try {
			/*response.setContentType("text/html");
			PrintWriter pw=response.getWriter();*/
			connection=getHTTPConnection(uri);
			logger.info("connection iss=="+connection);
			MultipartFile file=uploadBean.getImageFile();
			logger.info("fileData iss=="+file.getBytes());
			DataOutputStream dataOutputStream=new DataOutputStream(connection.getOutputStream());
			dataOutputStream.write(file.getBytes());
			InputStream inputStream=connection.getInputStream();
			logger.info("input iss=="+inputStream);
			 ch=inputStream.read();
			
			while(ch!=-1)
			{
				ch1=(char)ch;
			/*	pw.write((char)ch);*/
				logger.info("success msg iss=="+(char)ch);
				ch=inputStream.read();	
				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
/*		return "imageUploadView";*/
		return String.valueOf(ch1);
		
	}
	public HttpURLConnection getHTTPConnection(String url) throws Exception {

		HttpURLConnection _conn = null;
		URL serverAddress = null;
		for (int i = 0; i <= 1; i++) {
			try {
				serverAddress = new URL(url);
				_conn = (HttpURLConnection) serverAddress.openConnection();
				if (_conn != null) {
					_conn.setDoInput(true);
					_conn.setDoOutput(true);
					_conn.setUseCaches(false);
					_conn.setRequestMethod("POST");
					_conn.setRequestProperty("Connection", "Keep-Alive");			
					_conn.setRequestProperty("Content-Type",
							"application/xml");
					_conn.setReadTimeout(120000);
					_conn.setConnectTimeout(120000);
					}
					_conn.connect();

					return _conn;
				}
			

			catch (MalformedURLException me) {
				me.printStackTrace();
				throw me;
			}

			catch (SocketTimeoutException se) {
				se.printStackTrace();
				_conn = null;
				if (i != 0)
					throw se;
			}

			catch (Exception e) {
				logger.error(e.getMessage());
				throw e;
			}
		}
		return _conn;
	}
	public static String urlEncode(String sUrl) {
		int i = 0;
		String urlOK = "";
		while (i < sUrl.length()) {
			if (sUrl.charAt(i) == ' ') {
				urlOK = urlOK + "%20";
			} else {
				urlOK = urlOK + sUrl.charAt(i);
			}
			i++;
		}
		return (urlOK);
	}
	}


