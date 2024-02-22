package com.soft.keeper.service;

import java.util.List;
import java.util.Map;

public interface DeviceService {

    int addBatch();
    List<Map> groupByPro();
    Map<String,Long> groupByAlarm();
    List<Map> findErrorLog();
    List<Map> countNetworkNum();
    List<Map> groupByPro1();
    Map countNum();
}
