package com.renho.test.mybatisplus.common.core.idgenerator.service;

import com.renho.test.mybatisplus.common.core.idgenerator.dao.SeqSaveMapper;
import com.renho.test.mybatisplus.common.core.idgenerator.dto.LeafAlloc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeqSaveService {

    @Autowired
    private SeqSaveMapper seqSaveMapper;

    public void insertSeq(LeafAlloc seqSave){
        seqSaveMapper.insertSeq(seqSave);
    }

    public void deleteSeq(String seqname){
        seqSaveMapper.deleteSeq(seqname);
    }

    public LeafAlloc getSeqByName(String seqname){
        return seqSaveMapper.getSeqByName(seqname);
    }

    public List<String> getSeqAll(){
        return seqSaveMapper.getSeqAll();
    }

    public List<LeafAlloc> getSeqInfoAll(){
        return seqSaveMapper.getSeqInfoAll();
    }

    public void updateSeq(LeafAlloc seqSave){
        seqSaveMapper.updateSeq(seqSave);
    }

    public void updateSeqByName(LeafAlloc seqSave){
        seqSaveMapper.updateSeqByName(seqSave);
    }

    public void updateSeqToZero(LeafAlloc seqSave){
        seqSaveMapper.updateSeqToZero(seqSave);
    }

}
