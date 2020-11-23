package com.renho.test.mybatisplus.common.core;


public interface IdGen {

    /**
     * 初始化
     */
     public boolean init();

    /**
     *
     * @param prefix 标识使用哪种序列
     * @param SeqName 序列 名称
     * @param ip 雪花模型所需ip地址
     * @param port 雪花模型所需端口号
     * @return
     */
    public Long get(String prefix, String SeqName, String ip, String port);



}
