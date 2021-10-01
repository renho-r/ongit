package com.renho.test.util;

/**
 * @author renho
 * @date 2021/6/17
 */
public class MQTestUtils {

    private static final String PRE_PRODUCER_GROUP_NAME = "producer-group-name";
    private static final String PRE_CONSUMER_GROUP_NAME = "consumer-group-name";
    private static final String PRE_TOPIC_NAME = "topic-name";
    public static final String NAME_SERVER_ADDR = "myserver:9876";

    public static String genericConsumerGroupName() {
        Exception exception = new Exception();
        StackTraceElement[] stes = exception.getStackTrace();
        return PRE_CONSUMER_GROUP_NAME + "_" + stes[1].getClassName().replaceAll("\\.", "-");
    }

    public static String genericProducerGroupName() {
        Exception exception = new Exception();
        StackTraceElement[] stes = exception.getStackTrace();
        return PRE_PRODUCER_GROUP_NAME + "_" + stes[1].getClassName().replaceAll("\\.", "-");
    }

    public static String genericTopicName() {
        Exception exception = new Exception();
        StackTraceElement[] stes = exception.getStackTrace();
        return PRE_TOPIC_NAME + "_" + stes[1].getClassName().replaceAll("\\.", "-");
    }

}
