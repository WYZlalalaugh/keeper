package com.soft.keeper.service;

import com.soft.keeper.entity.Record;

import java.util.List;
import java.util.Map;

public interface RecordService {
    /**
     * 批量添加记录信息
     * @return
     */
    int addBatch();

    Map countRecord(String alarmType);

    List<Map> findAreaVocs();



}
