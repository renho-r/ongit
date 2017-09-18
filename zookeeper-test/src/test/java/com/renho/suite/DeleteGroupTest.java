package com.renho.suite;

import com.renho.zookeeper.base.DeleteGroup;
import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DeleteGroupTest {

    private DeleteGroup deleteGroup;

    @Before
    public void init() throws IOException, InterruptedException {
        deleteGroup = new DeleteGroup();
        deleteGroup.connect("127.0.0.1:2181");

    }

    @After
    public void destroy() throws InterruptedException {
        deleteGroup.close();
    }

    @Test
    public void testDelete() throws KeeperException, InterruptedException {
        deleteGroup.delete("renho");
    }

}
