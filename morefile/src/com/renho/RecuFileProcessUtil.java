package com.renho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

public class RecuFileProcessUtil {
	
	private static Logger log = Logger.getLogger(RecuFileProcessUtil.class);
	
	private static void mergeMapData(Map<String, Long> sumMap, Map<String, Long> dGradeMap) {
		Set<String> keySet = dGradeMap.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Long tc = dGradeMap.get(key);
			Long count = sumMap.get(key);
			if(null == count) {
				sumMap.put(key, tc);
			}else {
				sumMap.put(key, tc + count);
			}
		}
	}
	
	private static void mergeDataByServer(Map<String, Map<String, Map<String, Long>>> allDataMap, Map<String, Map<String, Map<String, Long>>> map) {
		for(Entry<String, Map<String, Map<String, Long>>> entry:map.entrySet()) {
			Map<String, Map<String, Long>> allGradMap = allDataMap.get(entry.getKey());
			if(null == allGradMap) {
				allDataMap.put(entry.getKey(), entry.getValue());
			}else {
				Map<String, Map<String, Long>> needDataMap = entry.getValue();
				Iterator<String> oIt = needDataMap.keySet().iterator();
				while(oIt.hasNext()) {
					String key = oIt.next();
					Map<String, Long> allDomainMap = allGradMap.get(key);
					if(null == allDataMap) {
						allGradMap.put(key, needDataMap.get(key));
					}else {
						Map<String, Long> tAllDomainMap = needDataMap.get(key);
						Iterator<String> iIt = tAllDomainMap.keySet().iterator();
						while(iIt.hasNext()) {
							String inKey = iIt.next();
							Long allCount = allDomainMap.get(inKey);
							if(null == allCount) {
								allDomainMap.put(inKey, tAllDomainMap.get(inKey));
							}else {
								allDomainMap.put(inKey, tAllDomainMap.get(inKey) + allCount);
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] ips = TestData.getIps();
		List<String> ipList = Arrays.asList(ips);
		log.info("renho 单线程合并");
		long start = (new Date()).getTime();
		Map<String, Map<String, Map<String, Long>>> allDataMap = CollectionUtil.newHashMap();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<Map<String, Map<String, Map<String, Long>>>>> flist = CollectionUtil.newArrayList();
		List<ProcessFile> pl = CollectionUtil.newArrayList();
//		List<ProcessFileAll> pl = CollectionUtil.newArrayList();
		
//		String p = "E:\\dns_recursion_domain_top/test";
//		String p = "E:\\dns_recursion_domain_top/testone";
		String p = "E:\\dns_recursion_domain_top/test1";
		
		File faa = new File(p);
		int ii = 0;
		for(File fs:faa.listFiles()) {
			for(File fss:fs.listFiles()) {
				if(ipList.contains(fss.getName().split("_")[0])) {
					ProcessFile pf = new ProcessFile(fss.getPath(), ++ii);
//					ProcessFileAll pf = new ProcessFileAll(fss.getPath(), ++ii);
					pl.add(pf);					
				}
			}
		}
		
		try {
			flist = executor.invokeAll(pl);
			long end0 = (new Date()).getTime();
			log.info("读取数据:" + (end0 - start));
			for(Future<Map<String, Map<String, Map<String, Long>>>> f:flist) {
				mergeDataByServer(allDataMap, f.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		flist = null;
		long end0 = (new Date()).getTime();
		log.info("完成数据:" + (end0 - start));
		int[] dsfsdfa = new int[1024 * 1024];
		Map<String, List<SortPojo>> ttt = CollectionUtil.newHashMap();
		log.info("smsm");
		for(int i=1; i<5; i++) {
			long end1 = (new Date()).getTime();
			long start0 = (new Date()).getTime();
			Map<String, Long> sumMap = CollectionUtil.newHashMap();
			Iterator<String> oIt = allDataMap.keySet().iterator();
			while(oIt.hasNext()) {
				Map<String, Long> tm = allDataMap.get(oIt.next()).get("" + i);
				if(null != tm) {
					mergeMapData(sumMap, tm);					
				}
			}
			long end2 = (new Date()).getTime();
			log.info("合并" + i + "级域名:" + (end2 - end1));
			
			List<SortPojo> sortList = CollectionUtil.newArrayList();
			Set<String> keySet = sumMap.keySet();
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()) {
				String key = it.next();
				SortPojo sp = new SortPojo(key, sumMap.get(key));
				sortList.add(sp);
			}
			
			Collections.sort(sortList, new Comparator<SortPojo>() {
				
				@Override
				public int compare(SortPojo o1, SortPojo o2) {
					if(o1.getCount() > o2.getCount()) {
						return -1;
					}else if(o1.getCount() == o2.getCount()) {
						return o1.getDn().compareTo(o2.getDn());
					}else {
						return 1;
					}
				}
			});
			long end3 = (new Date()).getTime();
			log.info("排序" + i + "级域名:" + (end3 - end2));
			log.info("renho" + i + "级域名:" + sortList.size() + "个");
			int x = 0;
//			int len = 996;
			int len = sortList.size();
			for(int j=0; j<len; j++) {
				Long sum = 0L;
				SortPojo sp = sortList.get(j);
//				log.info((++x) + "--->" + sp.getDn() + ":" + sp.getCount());
				sum = needSave(allDataMap, i, sp.getDn(), sum);
//				log.info("分项" + sp.getDn() + "共:" + sum);
			}
			long end4 = (new Date()).getTime();
//			log.info("落地" + i + "级域名:" + (end4 - end3));
			ttt.put(i + "", sortList);
		}
		long end2 = (new Date()).getTime();
		log.info("处理数据:" + (end2 - end0));
		log.info("总时间:" + (end2 - start));
	}
	
	public static Long needSave(Map<String, Map<String, Map<String, Long>>> allDataMap, int grade, String dm, Long sum) {
		Iterator<String> it = allDataMap.keySet().iterator();
		while(it.hasNext()) {
			String ip = it.next();
			Map<String, Map<String, Long>> map = allDataMap.get(ip);
			Map<String, Long> tm = map.get("" + grade);
			if(null != tm) {
				Long count = tm.get(dm);
				if(null != count && count > 0) {
					sum += count;
//					log.info(ip + ":" + count);
				}				
			}
		}
		return sum;
	}
}

class ProcessFile implements Callable<Map<String, Map<String, Map<String, Long>>>> {

	private String filePath = null;
	private static Logger log = Logger.getLogger(Callable.class);
	public ProcessFile(String filePath, int tc) {
		this.filePath = filePath;
	}
	@Override
	public Map<String, Map<String, Map<String, Long>>> call() throws Exception {
		long start = (new Date()).getTime();
		Map<String, Map<String, Map<String, Long>>> bMap = new HashMap<String, Map<String, Map<String, Long>>>();
		File file = new File(filePath);
		if(file.exists()) {
			String ip = file.getName().split("_")[0];
			Map<String, Map<String, Long>> backMap = CollectionUtil.newHashMap();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				String lineData = null;
				while(null != (lineData=br.readLine())) {
					String[] lineDatas = lineData.split(" ");
					if(null == lineDatas || 8 != lineDatas.length) {
						continue;
					}
					String dn = lineDatas[5].split("/")[0];
					String[] dns = dn.split("\\.");
					String fd = dns[dns.length - 1];
					setData(backMap, "1", fd);
					String sd = null;
					if(dns.length > 2) {
						sd = dns[dns.length - 2] + "." + fd;
						setData(backMap, "2", sd);
					}
					String td = null;
					if(dns.length > 3) {
						td = dns[dns.length - 3] + "." + sd;
						setData(backMap, "3", td);
					}
					setData(backMap, "4", dn.substring(1));
					
				}
				bMap.put(ip, backMap);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			long end = (new Date()).getTime();
//			log.info("线程" + tc + ":读取文件OK---------------------------时间:" + (end - start));
			return bMap;
		}else {
			return null;
		}
	}
	private void setData(Map<String, Map<String, Long>> backMap, String dGrade, String dn) {
		Map<String, Long> lvMap = backMap.get(dGrade);
		if(null == lvMap) {
			lvMap = CollectionUtil.newHashMap();
			lvMap.put(dn, 1L);
			backMap.put(dGrade, lvMap);
		}else {
			Long count = lvMap.get(dn);
			if(null == count) {
				lvMap.put(dn, 1L);
			}else {
				lvMap.put(dn, ++count);
			}
		}
	}
	
}

class ProcessFileAll implements Callable<Map<String, Map<String, Map<String, Long>>>> {

	private String filePath = null;
	private static Logger log = Logger.getLogger(Callable.class);
	public ProcessFileAll(String filePath, int tc) {
		this.filePath = filePath;
	}
	@Override
	public Map<String, Map<String, Map<String, Long>>> call() throws Exception {
		long start = (new Date()).getTime();
		Map<String, Map<String, Map<String, Long>>> bMap = new HashMap<String, Map<String, Map<String, Long>>>();
		File file = new File(filePath);
		if(file.exists()) {
			String ip = file.getName().split("_")[0];
			Map<String, Map<String, Long>> backMap = CollectionUtil.newHashMap();
			FileReader fr = new FileReader(file);
			int len = (int) file.length();
			char[] dataChar = new char[len];
			fr.read(dataChar);
			fr.close();
			String data = new String(dataChar);
			String[] datas = data.split("\n");
			if(null != datas && datas.length > 0) {
				for(String row:datas) {
					String[] lineDatas = row.split(" ");
					if(null == lineDatas || 8 != lineDatas.length) {
						continue;
					}
					String dn = lineDatas[5].split("/")[0];
					String[] dns = dn.split("\\.");
					String fd = dns[dns.length - 1];
					setData(backMap, "1", fd);
					String sd = null;
					if(dns.length > 2) {
						sd = dns[dns.length - 2] + "." + fd;
						setData(backMap, "2", sd);
					}
					String td = null;
					if(dns.length > 3) {
						td = dns[dns.length - 3] + "." + sd;
						setData(backMap, "3", td);
					}
					setData(backMap, "4", dn.substring(1));
				}
				bMap.put(ip, backMap);
			}
			/*BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				String lineData = null;
				while(null != (lineData=br.readLine())) {
					String[] lineDatas = lineData.split(" ");
					if(null == lineDatas || 8 != lineDatas.length) {
						continue;
					}
					String dn = lineDatas[5].split("/")[0];
					String[] dns = dn.split("\\.");
					String fd = dns[dns.length - 1];
					setData(backMap, "1", fd);
					String sd = null;
					if(dns.length > 2) {
						sd = dns[dns.length - 2] + "." + fd;
						setData(backMap, "2", sd);
					}
					String td = null;
					if(dns.length > 3) {
						td = dns[dns.length - 3] + "." + sd;
						setData(backMap, "3", td);
					}
					setData(backMap, "4", dn.substring(1));
					
				}
				bMap.put(ip, backMap);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}*/
			long end = (new Date()).getTime();
//			log.info("线程" + tc + ":读取文件OK---------------------------时间:" + (end - start));
			return bMap;
		}else {
			return null;
		}
	}
	private void setData(Map<String, Map<String, Long>> backMap, String dGrade, String dn) {
		Map<String, Long> lvMap = backMap.get(dGrade);
		if(null == lvMap) {
			lvMap = CollectionUtil.newHashMap();
			lvMap.put(dn, 1L);
			backMap.put(dGrade, lvMap);
		}else {
			Long count = lvMap.get(dn);
			if(null == count) {
				lvMap.put(dn, 1L);
			}else {
				lvMap.put(dn, ++count);
			}
		}
	}
	
}

class SortPojo {
	private String dn;
	private Long count;
	public SortPojo(String dn, Long count) {
		this.dn = dn;
		this.count = count;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
