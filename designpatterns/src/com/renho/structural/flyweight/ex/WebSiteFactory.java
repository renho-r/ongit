package com.renho.structural.flyweight.ex;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {
	private static Map<String, WebSite> webSites = new HashMap<String, WebSite>();

	private WebSiteFactory() {
	}

	public static WebSite createWebSite(String type) {
		WebSite webSite = webSites.get(type);
		if (webSite == null) {
			webSite = new ConcurrentWebSite(type);
			webSites.put(type, webSite);
		}
		return webSite;
	}

	public static int webSitesCount() {
		return webSites.size();
	}
}
