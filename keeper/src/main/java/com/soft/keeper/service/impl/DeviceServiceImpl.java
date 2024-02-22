package com.soft.keeper.service.impl;

import com.soft.keeper.entity.DeviceDetails;
import com.soft.keeper.entity.Record;
import com.soft.keeper.mapper.DeviceMapper;
import com.soft.keeper.mapper.RecordMapper;
import com.soft.keeper.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    RecordMapper recordMapper;

    String[] provinces = {"河南省", "山东省", "江苏省", "河北省", "安徽省", "山西省"};
    double[][] lonlats = {{113.677409, 34.755813}, {117.121225, 36.65887}, {118.798972, 32.062204}, {114.521529, 38.046948}, {117.23804, 31.827069}, {112.555821, 37.871065}};
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int addBatch() {
        List<DeviceDetails> list = new ArrayList();
        List<Record> records = new ArrayList();
        Random random = new Random();
        //生成数据的逻辑
        for (int i = 0; i < 10; i++) {
            //设备信息
            DeviceDetails deviceDetails = new DeviceDetails();
            //记录信息
            Record record = new Record();
            int i1 = random.nextInt(10);
            //设置风机状态
            if (i1 < 9) {
                deviceDetails.setFan_state(1);
            } else {
                deviceDetails.setFan_state(0);
            }
            //将风机状态同步到记录对象中
            record.setFan_state(deviceDetails.getFan_state());

            int i2 = random.nextInt(10);
            //设置净化器状态
            if (i2 < 9) {
                deviceDetails.setPurify_state(1);
            } else {
                deviceDetails.setPurify_state(0);
            }
            //将净化器状态，铜鼓到记录对象中
            record.setPurify_state(deviceDetails.getPurify_state());
            int i3 = random.nextInt(10);
            //设置传感器状态
            if (i3 < 9) {
                deviceDetails.setSensor_state(1);
            } else {
                deviceDetails.setSensor_state(0);
            }
            //将传感器状态同步到记录对象中
            record.setSensor_state(deviceDetails.getSensor_state());
            //设置告警状态--出现任何设备状态为0则告警状态为0,否则为1
            if (i1 < 9 && i2 < 9 && i3 < 9) {
                deviceDetails.setAlarm_state(1);
            } else {
                deviceDetails.setAlarm_state(0);
            }
            //设置记录的油烟浓度
            double vocs = random.nextInt(100) / 100.0;
            record.setVocs(vocs);
            //设置网络
            int i4 = random.nextInt(3) + 1;
            deviceDetails.setNetwork_type(i4);
            //设置省份
            int i5 = random.nextInt(6);
            deviceDetails.setProvince(provinces[i5]);
            deviceDetails.setLongitude(lonlats[i5][0]);
            deviceDetails.setLatitude(lonlats[i5][1]);
            //设置错误日志
            if (deviceDetails.getFan_state() == 0) {
                deviceDetails.setError_log("风机故障");
            }
            if (deviceDetails.getPurify_state() == 0) {
                deviceDetails.setError_log("净化器故障");
            }
            if (deviceDetails.getSensor_state() == 0) {
                deviceDetails.setError_log("传感器故障");
            }
            //设置创建时间
            Date date = new Date();
            String format = sdf.format(date);
            deviceDetails.setCreate_time(format);
            //设置记录的创建时间
            record.setCreate_time(deviceDetails.getCreate_time());
            //添加设备信息
            list.add(deviceDetails);
            //将记录添加到记录列表中
            records.add(record);


        }
        int res = deviceMapper.addBatch(list);
        recordMapper.addBatch(records);
        return res;
    }

    @Override
    public List<Map> groupByPro() {
        List<Map> maps = deviceMapper.groupByPro();
        return maps;
//        Map<String, List> map1 = new HashMap<>();
//        map1.put("province", Arrays.asList("", "", "", "", "", ""));//存放省份信息
//        map1.put("normal", Arrays.asList(0l, 0l, 0l, 0l, 0l, 0l));//存放正常设备数量
//        map1.put("abnormal", Arrays.asList(0l, 0l, 0l, 0l, 0l, 0l));//存放异常设备数量
//        int i = 0;
//        for (Map map : maps) {
//            //如果再map1中不包含查询到的省份信息，则添加省份信息
//            if (!map1.get("province").contains(map.get("province"))) {
//                map1.get("province").set(i, map.get("province"));
//                i++;
//            }
//            //根据查询到的状态，将结果存放到标识不同状态的两个集合中
//            if (map.get("alarm_state").equals(1)) {
//                map1.get("normal").set(map1.get("province").indexOf(map.get("province")), map.get("count"));
//            } else {
//                map1.get("abnormal").set(map1.get("province").indexOf(map.get("province")), map.get("count"));
//            }
//        }
    }

    @Override
    public Map<String, Long> groupByAlarm() {
        List<Map> maps = deviceMapper.groupByAlarm();
        Map<String, Long> map1 = new HashMap<>();
        map1.put("告警", 0l);
        map1.put("故障", 0l);
        for (Map map : maps
        ) {
            if (map.get("alarm_state").equals(0)) {
                //告警信息
                map1.put("告警", (Long) map.get("count"));
            } else {
                //故障信息
                map1.put("故障", (Long) map.get("count"));
            }
        }
        return map1;
    }

    @Override
    public List<Map> findErrorLog() {
        return deviceMapper.findErrorLog();
    }

    @Override
    public List<Map> countNetworkNum() {
        List<Map> maps = deviceMapper.countNetworkNum();
//        Map<String, List> map1 = new HashMap<>();
//        map1.put("network", new ArrayList());
//        map1.put("count", new ArrayList());
//        for (Map map : maps) {
//            map1.get("network").add(map.get("network"));
//            map1.get("count").add(map.get("count"));
//        }
        return maps;
    }

    @Override
    public List<Map> groupByPro1() {
        return deviceMapper.groupByPro1();
    }

    @Override
    public Map countNum() {
        return deviceMapper.countNum();
    }

}
