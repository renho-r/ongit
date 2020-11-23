package com.renho.test.mybatisplus.common.core.idgenerator.redis;

import com.renho.test.mybatisplus.common.core.idgenerator.dto.LeafAlloc;

public interface ServerNodeListener {

	public enum ServerNodeEventType{
		UPDATE, REMOVE
	}
	/**
	 * 监听redis服务地址变化
	 * @param event
	 * @param
	 */
	public void eventOccured(ServerNodeEventType event, LeafAlloc seqSave);
}
