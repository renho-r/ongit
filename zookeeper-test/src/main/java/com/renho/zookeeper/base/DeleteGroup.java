package com.renho.zookeeper.base;

import java.util.List;

import com.renho.zookeeper.watcher.ConnectionWatcher;
import org.apache.zookeeper.KeeperException;

public class DeleteGroup extends ConnectionWatcher {
    public void delete(String groupName) throws InterruptedException, KeeperException{
        String path="/"+groupName;
        List<String> children;
        try {
            children = zk.getChildren(path, false);
            for(String child:children){
                zk.delete(path+"/"+child, -1);
            }
            zk.delete(path, -1);
        } catch (KeeperException.NoNodeException e) {
            System.out.printf("Group %s does not exist\n", groupName);
            System.exit(1);
        }
    }
}