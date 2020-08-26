package com.renho;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class FileClientTest {

    @Test
    public void testUpload() {

        FileClient.INSTANCE.init();
        FileClient.INSTANCE.init();
        FileClient.INSTANCE.init();
        FileClient.INSTANCE.init();

        File dirFile = new File("/Users/renho/workspace/wsttt");
        File[] files = dirFile.listFiles();
        FileClient.INSTANCE.upload(Arrays.asList(files));

        FileClient.INSTANCE.isDone();
        FileClient.INSTANCE.shutdown();
    }

}
