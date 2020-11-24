package com.renho.test.mybatisplus.keygenerator;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;

import java.util.Random;

/**
 * @author renho
 * @date 2020/10/23
 */
public class CustomKeyGenerator implements IKeyGenerator {
    @Override
    public String executeSql(String incrementerName) {
        System.out.println("IN CustomKeyGenerator executeSql...");
        return "SELECT 'custom" + new Random().nextInt(Integer.MAX_VALUE) + "' FROM DUAL";
    }
}
