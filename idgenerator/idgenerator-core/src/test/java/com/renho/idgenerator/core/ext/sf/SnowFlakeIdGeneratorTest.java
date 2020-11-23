package com.renho.idgenerator.core.ext.sf;

import com.renho.idgenerator.core.ext.sf.config.SnowFlakeConfig;
import com.renho.idgenerator.core.ext.sf.idpolicy.SnowFlakePolicy16;
import com.renho.idgenerator.core.ext.sf.idpolicy.SnowFlakePolicy18;
import com.renho.idgenerator.core.ext.sf.workeridpolicy.MacIpWorkerIpPolicy;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

public class SnowFlakeIdGeneratorTest {

    @BeforeAll
    public static void init() {

    }

    @Test
    public void getId() {

        IWorkerIdPolicy workerIdPolicy = new MacIpWorkerIpPolicy();

        SnowFlakeConfig snowFlakeConfig = new SnowFlakeConfig();
        snowFlakeConfig.setDynamicWorkId(true);
        snowFlakeConfig.setWorkerIdBits(5);
        snowFlakeConfig.setSequenceBits(10);
        snowFlakeConfig.setWorkerIdPolicy(workerIdPolicy);

        SnowFlakeIdGenerator snowFlakeIdGenerator = new SnowFlakeIdGenerator();
        snowFlakeIdGenerator.put("st", new SnowFlakePolicy16(snowFlakeConfig));
        snowFlakeIdGenerator.put("et", new SnowFlakePolicy18(snowFlakeConfig));
        snowFlakeIdGenerator.setDefaultType("et");

        // 获取默认长度序列值
        Stream.generate(new Random()::nextInt)
                .limit(10)
                .forEach((index) -> System.out.println(snowFlakeIdGenerator.get()));
        // 指定长度序列值
        // 16位
        Stream.generate(new Random()::nextInt)
                .limit(20)
                .forEach((index) -> System.out.println(snowFlakeIdGenerator.get("st")));
        // 18位
        Stream.generate(new Random()::nextInt)
                .limit(1000)
                .forEach((index) -> System.out.println(snowFlakeIdGenerator.get("et")));

        System.out.println(Long.MAX_VALUE);
    }

}