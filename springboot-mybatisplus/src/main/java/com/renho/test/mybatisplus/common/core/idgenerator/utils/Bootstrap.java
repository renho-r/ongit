package com.renho.test.mybatisplus.common.core.idgenerator.utils;

import com.renho.test.mybatisplus.common.core.idgenerator.dto.LeafAlloc;
import com.renho.test.mybatisplus.common.core.idgenerator.redis.ServerNodeManager;
import com.renho.test.mybatisplus.common.core.idgenerator.service.SeqSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * id生成器启动类
 */
@Service("Bootstrap")
public class Bootstrap {

	@Autowired
	private ServerNodeManager serverNodeManger;

	@Autowired
	private SeqSaveService seqSaveService;

	/*@Autowired
	private LeafAllocRepository leafAllocRepository;*/


	public void start(String seqName){
		LeafAlloc seqSave = seqSaveService.getSeqByName(seqName);
		if (seqSave == null) {
			throw new IllegalArgumentException("序列"+seqName+"不存在！");
		}
		serverNodeManger.init(seqSave);
	}

	public long incr(String seqName) {
		return serverNodeManger.incr(seqName);
	}
	/**
	 * 每次取多少个ID
	 * @return
	 */
	public int getOffset(){

		return serverNodeManger.getStep();
	}

}
