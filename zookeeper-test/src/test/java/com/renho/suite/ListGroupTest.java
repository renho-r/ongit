package com.renho.suite;

import com.renho.zookeeper.base.ListGroup;
import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ListGroupTest {

    private ListGroup listGroup;

    @Before
    public void init() throws IOException, InterruptedException {
        listGroup = new ListGroup();
        listGroup.connect("127.0.0.1:2181");

    }

    @After
    public void destroy() throws InterruptedException {
        listGroup.close();
    }

    @Test
    public void testList() throws KeeperException, InterruptedException {
        listGroup.list("renho");
    }

}
