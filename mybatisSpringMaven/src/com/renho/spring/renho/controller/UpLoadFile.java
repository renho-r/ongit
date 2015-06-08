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
	 * ��Ӧǰ̨
	 * <form action="/mybatisSpringMaven/renho/uploadFile.do" method="POST" enctype="multipart/form-data">
			<input type="file" id="uploadFile" name="fileName">
			<input type="submit" id="submitUpload" value="ȷ��">
	   </form>
	 */
	@RequestMapping("renho/uploadFile.do")
	@ResponseBody
	public void upload(HttpServletRequest request) {
		// ����������request��������
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		 // ���form�Ƿ���enctype="multipart/form-data"  
		if (multipartResolver.isMultipart(request)) {
			// �ٽ�request�е�����ת����multipart���͵�����
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					String fileName = file.getOriginalFilename();
					String path = "D:/" + fileName;
					File localFile = new File(path);
					// д�ļ�������
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
