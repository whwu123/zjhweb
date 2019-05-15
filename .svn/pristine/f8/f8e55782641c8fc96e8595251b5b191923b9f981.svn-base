package com.zjh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjh.model.Affix;
import com.zjh.service.AffixService;

@Controller
public class DownLoadController {

	@Resource(name="AffixService")
	private AffixService affixService;
	@RequestMapping("downloadAffix")
	public void downloadAffix(Integer id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Affix affix = null;
		if(id!=null){
			affix = affixService.getAffixById(id);
			String affixPath = affix.getAffixpath();
			File file=new File(affixPath);  
			response.setCharacterEncoding("utf-8");
			String fileName = affix.getAffixname()+"."+affix.getAffixtype();
			fileName = URLEncoder.encode(fileName, "UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); 
			response.addHeader("Content-Length", "" + affix.getSize()); 
			response.setContentType("application/octet-stream;charset=UTF-8");
		    OutputStream os = response.getOutputStream(); 
		    FileInputStream fis = new FileInputStream(file);  
		    byte[] buffer = new byte[2048];  
	        int readlength = 0;  
	        while((readlength = fis.read(buffer)) != -1){  
	        	os.write(buffer,0,readlength);   
	        } 
			fis.close();
			os.flush();
			os.close();
		}
		
	}
}
