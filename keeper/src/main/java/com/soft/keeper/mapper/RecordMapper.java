package com.soft.keeper.mapper;
import com.soft.keeper.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RecordMapper {
    /**
     * 批量添加记录信息
     * @param list
     * @return
     */
    int addBatch(List<Record> list);
    Map countRecord(String alarmType);
    List<Map> findAreaVocs();
}
