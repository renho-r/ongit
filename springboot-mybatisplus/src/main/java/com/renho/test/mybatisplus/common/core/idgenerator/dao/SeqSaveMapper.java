package com.renho.test.mybatisplus.common.core.idgenerator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.renho.test.mybatisplus.common.core.idgenerator.dto.LeafAlloc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeqSaveMapper extends BaseMapper<LeafAlloc> {

    public void insertSeq(LeafAlloc leafAlloc);

    public void deleteSeq(String seqname);

    public LeafAlloc getSeqByName(String seqname);

    public List<String> getSeqAll();

    public List<LeafAlloc> getSeqInfoAll();

    public void updateSeq(LeafAlloc leafAlloc);

    public void updateSeqByName(LeafAlloc leafAlloc);

    public void updateSeqToZero(LeafAlloc leafAlloc);
}
