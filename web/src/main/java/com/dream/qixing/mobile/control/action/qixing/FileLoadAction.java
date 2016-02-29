package com.dream.qixing.mobile.control.action.qixing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;

@ApiAction("common.upload")
public class FileLoadAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String rootPath="d:\\";
	File tempPathFile;
	@ApiListField("imgs")
	@ApiField("img_url")
	private List<String> imgUrl = new ArrayList<String>();;

	public String execute() {
		try {
			doPost(this.getRequest(),this.getResponse());
			this.setIsSuccessful(true);
			this.setStatusCode(200);
		} catch (ServletException e) {
			this.setIsSuccessful(false);
			this.setStatusCode(500);
			this.setDescription(e.getMessage());
		} catch(Exception e){

		}
		return "";
	}

	
	// 重写doPost方法，处理事件识别请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DATE);
		String filePath = rootPath+File.separator+year+File.separator+month+File.separator+day+File.separator;
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		try {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Set factory constraints
			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
			factory.setRepository(tempPathFile);// 设置缓冲区目录

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint
			upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
			Iterator<FileItem> i = items.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				String fileName = fi.getName();
				
				if (fileName != null) {
					fileName= c.get(Calendar.SECOND)+fileName;;
					imgUrl.add("http://p1.dream.com/"+year+"/"+month+"/"+day+"/"+fileName);
					File fullFile = new File(new String(fileName.getBytes(), "utf-8")); // 解决文件名乱码问题
					File savedFile = new File(filePath, fullFile.getName());
					fi.write(savedFile);
				}
			}
			
			
			System.out.print("upload succeed");
		} catch (Exception e) {
			
		}
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
