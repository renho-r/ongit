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

<<<<<<< HEAD
        File dirFile = new File("/Users/renho/workspace/wsttt");
=======
        File dirFile = new File("d://dev");
>>>>>>> 0b2d391269a86ea901c36d7bd84b871bd8513774
        File[] files = dirFile.listFiles();
        FileClient.INSTANCE.upload(Arrays.asList(files));

        FileClient.INSTANCE.isDone();
        FileClient.INSTANCE.shutdown();
    }

}
