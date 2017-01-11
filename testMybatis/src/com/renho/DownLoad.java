package com.renho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renho.pojo.FileBean;

import net.sf.json.JSONObject;

@WebServlet("/downLoad")
public class DownLoad extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, new Object[]{request, response});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void downLoad(HttpServletRequest request, HttpServletResponse response) {
		try {
			String filePath = request.getParameter("filePath");
			File file = new File(filePath);
			response.setContentType("text/html");
			response.addHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(file.getName(),"utf-8") + "\"");
			InputStream in = new FileInputStream(file);
			byte[] bs = new byte[4 * 1024];
			int len = 0;
			OutputStream os = response.getOutputStream();
			while(-1 != (len=in.read(bs))) {
				os.write(bs, 0, len);
			}
			in.close();
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static final String DEFAULT_PATH = "C:/Users/renho/Desktop";
	private void showCanDownLoad(HttpServletRequest request, HttpServletResponse response) {
		String showPath = request.getParameter("showPath");
		if(null == showPath || "".equals(showPath)) {
			showPath = DEFAULT_PATH;
		}
		File desktopFiles = new File(showPath);
		File[] files = desktopFiles.listFiles();
		List<FileBean> backList = new ArrayList<FileBean>();
		for(File f: files) {
			FileBean fb = new FileBean();
			String path = f.getPath();
			String fileName = f.getName();
			boolean type = f.isDirectory();
			
			fb.setFileName(fileName);
			fb.setPath(path);
			fb.setType(type?"0":"1");
			backList.add(fb);
		}
		JSONObject backJson = new JSONObject();
		backJson.put("showPath", showPath);
		backJson.put("files", backList);
		writeResponse(backJson, response);
	}
	
	private void writeResponse(JSONObject backJson, HttpServletResponse response) {
		response.setHeader("Charset", "UTF-8");
		response.setContentType("text;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(backJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
