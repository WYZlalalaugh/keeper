package com.soft.keeper.mapper;

import com.soft.keeper.entity.DeviceDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface DeviceMapper {
    /**
     * 批量添加设备信息
     * @param list
     * @return
     */
    int addBatch(List<DeviceDetails> list);

    /**
     * 查询全部操作
     * @return
     */
    List<DeviceDetails> findAll();

    /**
     * 修改操作
     * @param deviceDetails
     * @return
     */
    int updateById(DeviceDetails deviceDetails);




    /**
     * -- 统计不同地区在线和故障设备数据量
     * @return
     */
    List<Map> groupByPro();


    List<Map> groupByAlarm();


    List<Map> findErrorLog();

    List<Map> countNetworkNum();

    List<Map> groupByPro1();

    Map countNum();


}
