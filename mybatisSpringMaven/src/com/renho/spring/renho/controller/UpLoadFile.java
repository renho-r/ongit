package com.renho.spring.renho.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UpLoadFile {
	
	/**
	 * 对应前台
	 * <form action="/mybatisSpringMaven/renho/uploadFile.do" method="POST" enctype="multipart/form-data">
			<input type="file" id="uploadFile" name="fileName">
			<input type="submit" id="submitUpload" value="确定">
	   </form>
	 */
	@RequestMapping("renho/uploadFile.do")
	@ResponseBody
	public void upload(HttpServletRequest request) {
		// 解析器解析request的上下文
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		 // 检查form是否有enctype="multipart/form-data"  
		if (multipartResolver.isMultipart(request)) {
			// 再将request中的数据转化成multipart类型的数据
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					String fileName = file.getOriginalFilename();
					String path = "D:/" + fileName;
					File localFile = new File(path);
					// 写文件到本地
					try {
						file.transferTo(localFile);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
