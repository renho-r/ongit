package com.renho;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class HandleTask implements Callable<Object> {

    private String filePath;

    public HandleTask(String filePath) {
        this.filePath = filePath;
    }

    public Object call() throws Exception {
        System.out.printf("start handle file: %s\n", filePath);
        File srcFile = new File(filePath);
        File desFile = new File(filePath + ".des");

        List<String> data = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        String line = br.readLine();
        while (null != (line = br.readLine())) {
            if (!Utils.isDel(line)) {
                data.add(Utils.format(line));
            }
        }
        br.close();

        FileOutputStream out = new FileOutputStream(desFile);
        data.forEach(l -> {
            try {
                out.write((l + "\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        out.close();
        desFile.renameTo(srcFile);
        System.out.printf("end handle file: %s\n", filePath);
        return null;
    }
}
