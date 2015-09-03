package com.renho.simulateservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@WebServlet("/simpleCacheServlet")
public class SimpleCacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SimpleCacheServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String req = request.getParameter("req");
		if("renho".equals(req)) {
			CacheManager manager = CacheManager.getInstance();
			System.out.println(manager);
			String names[] = manager.getCacheNames();
			for (int i = 0; i < names.length; i++) {
				System.out.println(names[i]);
			}
			// 根据cacheName生成一个Cache对象
			// 第一种方式：
			//Cache cache = manager.getCache(names[0]);
			// 第二种方式，ehcache里必须有defaultCache存在,"test"可以换成任何值
			Cache cache = manager.getCache("renho");
			if(null == cache) {
				//生存时间10
				cache = new Cache("renho", 1, true, false, 10, 20);
				manager.addCache(cache);
				//向Cache对象里添加Element元素，Element元素有key，value键值对组成
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d = sdf.format(new Date());
				cache.put(new Element("key-renho", d));
				Element element = cache.get("key-renho");
				System.out.println(cache);
				System.out.println(element.getValue());
				Object obj = element.getObjectValue();
				System.out.println((String) obj);
				//manager.shutdown();
				response.getWriter().print("新增cache:" + d);
				response.getWriter().close();
			}else {
				Element element = cache.get("key-renho");
				String d = (String) element.getObjectValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nd = sdf.format(new Date());
				cache.remove("key-renho");
				cache.put(new Element("key-renho", nd));
				response.getWriter().print("已存在cache:" + d + ", 更新:" + nd);
				response.getWriter().close();
			}
		}else {
			CacheManager manager = CacheManager.getInstance();
			Cache cache = manager.getCache("renho");
			Element element = cache.get("key-renho");
			if(null == element) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d = sdf.format(new Date());
				cache.put(new Element("key-renho", d));
				response.getWriter().print("cache已过期,新增cache:" + d);
				response.getWriter().close();
			}else {
				String d = (String) element.getObjectValue();
				response.getWriter().print("已存在cache:" + d);
				response.getWriter().close();
			}
		}
	}

}
