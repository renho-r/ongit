package com.renho.springstarter.test;

import com.renho.idgenerator.core.IIdGenerator;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

//import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author renho
 * @date 2020/10/26
 */
@SpringBootApplication
//@EnableTransactionManagement
//@MapperScan("com.renho.**.mapper")
public class IdGeneratorApplication {

    private static IIdGenerator idGenerator;
    private static IIdGenerator snowFlakeIdGenerator;
    private static Map<String, Set<String>> UNI = new ConcurrentHashMap<>(16);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(IdGeneratorApplication.class);
        System.out.println("idGenerator: " + idGenerator);
        System.out.println("snowFlakeIdGenerator: " + snowFlakeIdGenerator);
        long start = System.currentTimeMillis();
        List<String> ids = new CopyOnWriteArrayList<>();
        ExecutorService executors = Executors.newFixedThreadPool(100);
        for (int i=0; i<1; i++) {
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    String tName = Thread.currentThread().getName();
                    for (int i=0; i<100; i++) {
                        String id = null;
                        if (null != idGenerator) {
                            id = idGenerator.get();
                            System.out.println(id);
                            id = idGenerator.get(tName);
                            System.out.println(id);
                        }
                        if (null != snowFlakeIdGenerator) {
                            id = snowFlakeIdGenerator.get();

                            int wLen = 5;
                            int seqLen = 10;

                            String bStr = Long.toBinaryString(Long.valueOf(id));
                            String workId = bStr.substring(bStr.length() - 15, bStr.length() - 15 + wLen);
                            long workerIdLong = Long.parseLong(workId, 2);
                            String time2 = bStr.substring(0, bStr.length() - 15);
                            Long timeMi = Long.parseLong(time2, 2) - 8796093022208L;
                            Date date = new Date();
                            date.setTime(timeMi);
                            String seqStr = bStr.substring(bStr.length() - seqLen, bStr.length());
                            long seq = Long.parseLong(seqStr, 2);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                            System.out.printf("id: %s, id-b:%s, time: %s, workerId: %s, sequence: %s \n"
                                    , id, bStr, sdf.format(date), workerIdLong, seq);
                        }
                        if (null != id) {
                            ids.add(id);
                        }
                    }
                }
            });
        }
        executors.shutdown();
        while (!executors.isTerminated()) {
            TimeUnit.SECONDS.sleep(3L);
        }
        long end = System.currentTimeMillis();
        System.out.println("size: " + ids.size());
    }

    @Autowired(required = false)
    @Qualifier("idGenerator")
    public void setIdGenerator(IIdGenerator idGenerator) {
        IdGeneratorApplication.idGenerator = idGenerator;
    }

    @Autowired(required = false)
    @Qualifier("snowFlakeIdGenerator")
    public void setSnowFlakeIdGenerator(IIdGenerator snowFlakeIdGenerator) {
        IdGeneratorApplication.snowFlakeIdGenerator = snowFlakeIdGenerator;
    }
}
