package com.renho.mock.user;

import com.sun.javafx.binding.StringFormatter;
import jdk.nashorn.api.scripting.URLReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
public class App {

    public static AtomicInteger index = new AtomicInteger(0);

    public static void main( String[] args ) throws ScriptException, IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("js");
        Boolean flag = (Boolean) nashorn.eval(new URLReader(new URL("https://cdn.bootcdn.net/ajax/libs/Mock.js/1.0.1-beta3/mock.js")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("./users.sql", false));
        for (int i=0; i<10; i++) {
            executorService.execute(new Task(nashorn, index, Integer.valueOf(args[0]), bw));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        bw.close();
    }

    public static class Task implements Runnable {

        private ScriptEngine nashorn;
        private AtomicInteger index;
        private Integer count;
        private BufferedWriter bw;
        private static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

        public Task(ScriptEngine nashorn, AtomicInteger index, Integer count, BufferedWriter bw) {
            this.nashorn = nashorn;
            this.index = index;
            this.count = count;
            this.bw = bw;
        }

        @lombok.SneakyThrows
        @Override
        public void run() {

            StringBuilder allSql = new StringBuilder();
            for (int i=0; i<count; i++) {
                String column = "id, login_name, password, username, gender, card_no, age, birthdate, tel, email, tld, protocol, ip, zip, region, address, `desc`, last_login_time";

                Integer id = index.incrementAndGet();
                String loginName = getLoginName(4 + new Random().nextInt(6));
                String password = getLoginName(6 + new Random().nextInt(10));
                String username = (String) nashorn.eval("Mock.Random.cname()");
                String gender = (String) nashorn.eval("Mock.Random.pick(['男', '女'])");
                String tel = getTel();
                String email = (String) nashorn.eval("Mock.Random.email()");
                String tld = (String) nashorn.eval("Mock.Random.tld()");
                String cardNo = (String) nashorn.eval("Mock.Random.id()");
                String birthdate = cardNo.substring(6, 14);
                int age = 2021 - Integer.parseInt(birthdate.substring(0, 4));
                String protocol = (String) nashorn.eval("Mock.Random.protocol()");
                String ip = (String) nashorn.eval("Mock.Random.ip()");
                String zip = (String) nashorn.eval("Mock.Random.zip()");
                String region = (String) nashorn.eval("Mock.Random.region()");
                String address = (String) nashorn.eval("Mock.Random.county(true)");
                String desc = (String) nashorn.eval("Mock.Random.csentence()");
                String lastLoginTime = (String) nashorn.eval("Mock.Random.datetime()");


                String values = StringFormatter.format("(%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", id, loginName, password, username, gender, cardNo, age, birthdate, tel, email, tld, protocol, ip, zip, region, address, desc, lastLoginTime).get();
                String sql = StringFormatter.format("insert into user(%s) values %s;\n", column, values).get();
                allSql.append(sql);
                if (0 == i%10_0000) {
                    this.bw.write(allSql.toString());
                    allSql = new StringBuilder();
                }
            }
            if (allSql.length() > 0) {
                this.bw.write(allSql.toString());
            }
        }

        private String getLoginName(int length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int number = (int) (Math.random() * base.length());
                sb.append(base.charAt(number));
            }
            return sb.toString();
        }

        private String getTel() {
            int index = getNum(0, telFirst.length - 1);
            String first = telFirst[index];
            String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
            String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
            return first + second + thrid;
        }

        private int getNum(int start, int end) {
            return (int) (Math.random() * (end - start + 1) + start);
        }
    }
}
