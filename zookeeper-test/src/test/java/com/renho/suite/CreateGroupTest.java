package com.renho.suite;

import com.renho.zookeeper.base.CreateGroup;
import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CreateGroupTest {

    private CreateGroup createGroup;

    @Before
    public void init() throws IOException, InterruptedException {
        createGroup = new CreateGroup();
        createGroup.connect("127.0.0.1:2181");

    }

    @After
    public void destroy() throws InterruptedException {
        createGroup.close();
    }

    @Test
    public void testCreate() throws KeeperException, InterruptedException {
        createGroup.create("renho");
    }

}
