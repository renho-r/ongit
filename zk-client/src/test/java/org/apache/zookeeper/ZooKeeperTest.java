package org.apache.zookeeper;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class ZooKeeperTest {

    @Test
    public void testConnect() throws IOException, KeeperException, InterruptedException {

        ZooKeeper zooKeeper = new ZooKeeper("localhost:2182", 30000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.printf("%s\n", event.getState());
            }
        });

        zooKeeper.getChildren("/", false).forEach(System.out::println);

        if (null == zooKeeper.exists("/renho", null)) {
            zooKeeper.create("/renho", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        for (int i=0; i<10000; i++) {
            zooKeeper.create("/renho/" + UUID.randomUUID().toString(), null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.printf("%s\n", i);
        }
        System.out.printf("done\n");
        System.in.read();
    }

}
