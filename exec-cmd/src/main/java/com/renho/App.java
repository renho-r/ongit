package com.renho;

import org.zeroturnaround.exec.ProcessExecutor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException, TimeoutException, IOException {
        String result = new ProcessExecutor()
                .command("/bin/sh", "-c", "more /Volumes/renho/temp/catalina.out|grep 'nginx'")
                .timeout(60, TimeUnit.SECONDS)
                .readOutput(true)
                .execute()
                .outputUTF8();
        System.out.println(result);

    }
}
