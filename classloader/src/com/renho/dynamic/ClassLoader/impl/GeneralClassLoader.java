package com.renho.dynamic.ClassLoader.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;

import com.renho.dynamic.ClassLoader.SuperClassLoader;
import com.renho.dynamic.business.businessInterface.SuperInterface;

public class GeneralClassLoader extends ClassLoader implements SuperClassLoader {

	private Map<String, SuperInterface> interfaceMap = new HashMap<String, SuperInterface>();
	private Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
	private String classDataRootPath;
	
	public GeneralClassLoader() {
		super();
	}
	
	public GeneralClassLoader(String classDataRootPath) {
		super();
		this.classDataRootPath = classDataRootPath;
	}
	
	@Override
	public void addInterfaceMap(String interfaceId, SuperInterface superInterface) {
		interfaceMap.put(interfaceId, superInterface);
	}
	
	@Override
	public void removeInterfaceMap(String interfaceId) {
		interfaceMap.remove(interfaceId);
	}
	
	@Override
	public Class<?> loadClass(String name, int i) throws ClassNotFoundException {
		synchronized (getClassLoadingLock(name)) {
			Class<?> c = findLoadedClass(name);
			if (0 == i) {
				c = super.loadClass(name);
			} else if (1 == i) {
				long t0 = System.nanoTime();
				long t1 = System.nanoTime();
				c = findClass(name);
				sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
				sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
				sun.misc.PerfCounter.getFindClasses().increment();
			}
			classMap.put(name, c);
			return c;
		}
	}

	@Override
	public Class<?> getClass(String name) {
		Class<?> clazz = classMap.get(name);
		if (null == clazz) {
			clazz = null;
		} else {

		}
		return clazz;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bytes = loadClassBytes(name);
		Class theClass = defineClass(name, bytes, 0, bytes.length);
		if (theClass == null)
			throw new ClassFormatError();
		return theClass;
	}

	private byte[] loadClassBytes(String className)
			throws ClassNotFoundException {
		try {
			String classFile = getClassFile(className);
			FileInputStream fis = new FileInputStream(classFile);
			FileChannel fileC = fis.getChannel();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			WritableByteChannel outC = Channels.newChannel(baos);
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			while (true) {
				int i = fileC.read(buffer);
				if (i == 0 || i == -1) {
					break;
				}
				buffer.flip();
				outC.write(buffer);
				buffer.clear();
			}
			fis.close();
			return baos.toByteArray();
		} catch (IOException fnfe) {
			throw new ClassNotFoundException(className);
		}
	}

	private String getClassFile(String name) {
		String baseDir = classDataRootPath + "\\bin\\";
		StringBuffer sb = new StringBuffer(baseDir);
		name = name.replace('.', File.separatorChar) + ".class";
		sb.append(File.separator + name);
		return sb.toString();
	}
}
