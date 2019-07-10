package com.renho;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class StringConcat {

//    @Benchmark
//    public String testConcat() {
//
//        String result = "";
//
//        for(int i=0; i<10000; i++) {
//            result += "renho";
//        }
//
//        return result;
//    }

//    @Benchmark
//    public String testConcat() {
//
//        StringBuilder result = new StringBuilder();
////        StringBuffer result = new StringBuffer();
//        for(int i=0; i<10000; i++) {
//            result.append("renho");
//        }
//
//        return result.toString();
//    }

    @Benchmark
    public void testConcat() {

        for(int i=0; i<10000; i++) {
//            String result = "hello" + " renho";
            StringBuilder sb = new StringBuilder();
            sb.append("hello");
            sb.append(" renho");
            int a = Integer.valueOf(1000);
        }
    }
}
