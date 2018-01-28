package com.renho;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class App {

    public void formatFile(String fPath) throws InterruptedException {
        System.out.println("formatFile start");
        File dir = new File(fPath);
        File[] files = dir.listFiles();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
        Stream.of(files).forEach(f -> {
            tasks.add(new HandleTask(f.getAbsolutePath()));
        });
        executor.invokeAll(tasks);
        executor.shutdown();
        System.out.println("formatFile done");
    }

    public List<String> handleData(String filePath) throws InterruptedException {
        List<String> data = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while (null != (line = br.readLine())) {
                if (!Utils.isDel(line)) {
                    data.add(line);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public static void main(String[] args) throws InterruptedException {

        App app = new App();
        app.formatFile("/Users/renho/tdata");
    }
}
