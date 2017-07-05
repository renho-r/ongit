package com.renho.example;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MyClassLoader extends ClassLoader {
	
	public MyClassLoader(String classDataRootPath) {
		super();
		System.out.println(classDataRootPath);
	}

	protected Class<?> loadClass(String name, int i)
			throws ClassNotFoundException {
		/*	
			 if(0 == i) {
			 	使用 AppClassLoader加载
			 }else if(1 == i) {
			 	不委派，自己加载
			 }
			 我是这么理解的
		 */
		synchronized (getClassLoadingLock(name)) {
			
			Class<?> c = findLoadedClass(name);
			
			if(0 == i) {
				c = super.loadClass(name);
			}else if(1 == i) {
				//load myself
				long t0 = System.nanoTime();
				
				long t1 = System.nanoTime();
				c = findClass(name);
				
				// this is the defining class loader; record the stats
				sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
				sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
				sun.misc.PerfCounter.getFindClasses().increment();
			}
            return c;
        }
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
	
	private byte[] loadClassBytes(String className) throws ClassNotFoundException {
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
		String baseDir = "E:\\renho\\workspace\\ongit\\classloader\\bin\\";
        StringBuffer sb = new StringBuffer(baseDir);
        name = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator + name);
        return sb.toString();
    } 
}
