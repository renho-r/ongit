package com.renho;

import com.renho.suite.CreateGroupTest;
import com.renho.suite.DeleteGroupTest;
import com.renho.suite.ListGroupTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CreateGroupTest.class, ListGroupTest.class, DeleteGroupTest.class})
public class ZookeeperTest {
}
