package com.renho;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

public class HotswapCL extends ClassLoader {

	private String basedir; // 需要该类加载器直接加载的类文件的基目录
	private HashSet<String> dynaclazns; // 需要由该类加载器直接加载的类名

	public HotswapCL(String basedir, String[] clazns) throws IOException {
		super(null); // 指定父类加载器为 null
		this.basedir = basedir;
		dynaclazns = new HashSet<String>();
		loadClassByMe(clazns);
	}

	private void loadClassByMe(String[] clazns) throws IOException {
		for (int i = 0; i < clazns.length; i++) {
			loadDirectly(clazns[i]);
			dynaclazns.add(clazns[i]);
		}
	}

	private Class<?> loadDirectly(String name) throws IOException {
		Class<?> cls = null;
		StringBuffer sb = new StringBuffer(basedir);
		String classname = name.replace('.', File.separatorChar) + ".class";
		sb.append(File.separator + classname);
		File classF = new File(sb.toString());
		cls = instantiateClass(name, new FileInputStream(classF),
				classF.length());
		return cls;
	}

	private Class<?> instantiateClass(String name, InputStream fin, long len)
			throws IOException {
		byte[] raw = new byte[(int) len];
		fin.read(raw);
		fin.close();
		return defineClass(name, raw, 0, raw.length);
	}

	protected Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		Class<?> cls = null;
		cls = findLoadedClass(name);
		if (!this.dynaclazns.contains(name) && cls == null)
//			if("com.renho.Foo".equals(name)) {
//				System.out.println("use parent load");		
//			}
			cls = getSystemClassLoader().loadClass(name);
		if (cls == null)
			throw new ClassNotFoundException(name);
		if (resolve)
			resolveClass(cls);
		return cls;
	}

}