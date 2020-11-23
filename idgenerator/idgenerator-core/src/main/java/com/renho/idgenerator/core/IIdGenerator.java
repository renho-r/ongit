package com.renho.idgenerator.core;

/**
 * @author renho
 * @date 2020/10/26
 */
public interface IIdGenerator {

    /**
     * 获取guid
     * @return
     */
    String get();

    /**
     * 按类别获取guid
     * @param seqName
     * @return
     */
    String get(String seqName);

}
