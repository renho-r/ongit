package com.renho;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by renho on 2016/4/25.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        JSONObject json = JSONObject.fromObject("{id:1, name:'renho'}");
        System.out.println(json);

        RandomAccessFile raf = new RandomAccessFile("pom.xml", "r");
        byte[] bs = new byte[(int) raf.length()];
        //raf.read(bs);
        System.out.println(new String(bs));
        FileChannel fc =  raf.getChannel();
        ByteBuffer bbs = ByteBuffer.allocate(1024);
        fc.read(bbs);
        System.out.println(new String(bbs.array()));
    }
}
