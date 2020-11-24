package com.renho.test.mybatisplus.common.core.idgenerator.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/** 使用注意：
* 1.请注意seqName名称不能重复,这个一定要在控制台先查询一次,建议取名字格式为：database.table.column 如：prod.company.co_code
* 2.每次重启应用时,重启前应用取的batchSize个id,如果没用完,会直接取下一批,这个会造成id不连续而浪费
*   后台设置batchSize
*/
@Component
public final class IDGenerator  {

	/** 序列名称 */
	private String seqName;
	/** 当前值 */
	private volatile long currentOffset;
	/** 预留内存的最大值 */
	private volatile long maxOffset;

	private static  IDGenerator idGenerator;

	@Autowired
	private Bootstrap bootstrap;

	@PostConstruct
	public void init() {
		idGenerator = this;
		idGenerator.bootstrap = this.bootstrap;
	}


	public void init(String seqName){
		setSeqName(seqName);
		if(StringUtils.isBlank(seqName)){
			throw new IllegalArgumentException("缺少seqName");
		}

		IDGenerator.idGenerator.bootstrap.start(seqName);
	}

	/**
	 * 获取下一个唯一ID
	 * @return
	 */
	public synchronized long next(String seqName) {

		if(currentOffset == maxOffset){
			init(seqName);
			maxOffset = generateMaxOffset(seqName);
			currentOffset = maxOffset - IDGenerator.idGenerator.bootstrap.getOffset();
		}
		currentOffset++;
		return currentOffset;
	}

	/**
	 * size大小应有限制,不能超过步长大小
	 * @param size 获取的size大小
	 * @return
     */
	public synchronized List<Object> nextList(String seqName,int size){
		List<Object> currentList = new ArrayList<Object>();
		if(currentOffset + size >= maxOffset){
			maxOffset = generateMaxOffset(seqName);
			currentOffset = maxOffset - IDGenerator.idGenerator.bootstrap.getOffset();
		}
		for(int i = 0; i<size;i++){
			currentOffset ++ ;
			currentList.add(currentOffset);
		}
		return currentList;
	}

	private long generateMaxOffset(String seqName) {
		return IDGenerator.idGenerator.bootstrap.incr(seqName);
	}
	public String getSeqName() {
		return seqName;
	}
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

}
