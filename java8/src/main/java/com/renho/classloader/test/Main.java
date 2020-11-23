package com.renho.classloader.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\workspace");
        System.out.println(1);
        Class clazz = diskClassLoader.loadClass("com.renho.annotation.Test");
        System.out.println(2);
        Object t = clazz.newInstance();
        System.in.read();
        System.out.println(3);
        System.in.read();
        System.out.println(t);
        System.in.read();
        System.out.println(t.getClass().getAnnotations().length);
        System.in.read();
        System.out.println(t.getClass().getAnnotations()[0]);
        System.in.read();
        System.out.println(4);
    }
}

class  DiskClassLoader extends ClassLoader {

    private String classPath;

    public DiskClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.printf("load %s\n", name);
        return super.loadClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.printf("load %s\n", name);
        return super.loadClass(name, resolve);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes;
        Class<?> clazz;

        try {
            //获取.class 文件的二进制字节
            bytes = getClassByte(name);
            //将二进制字节转化为Class对象
            clazz = defineClass(name, bytes, 0, bytes.length);
            return clazz;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return super.findClass(name);
    }


    private byte[] getClassByte(String name) throws IOException {

        String classFile = classPath + File.separator + name.replace(".", File.separator) + ".class";
        System.out.println(classFile);

        File file = new File(classFile);

        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WritableByteChannel writableByteChannel = Channels.newChannel(byteArrayOutputStream);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int i;
        while (true) {
            i = fileChannel.read(byteBuffer);
            if (i == 0 || i == -1) {
                break;
            }
            byteBuffer.flip();
            writableByteChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        writableByteChannel.close();
        fileChannel.close();
        fileInputStream.close();

        return byteArrayOutputStream.toByteArray();

    }
}