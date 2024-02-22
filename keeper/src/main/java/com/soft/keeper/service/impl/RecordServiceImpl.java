package com.soft.keeper.service.impl;

import com.soft.keeper.entity.DeviceDetails;
import com.soft.keeper.entity.Record;
import com.soft.keeper.mapper.DeviceMapper;
import com.soft.keeper.mapper.RecordMapper;
import com.soft.keeper.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;
    @Autowired
    DeviceMapper deviceMapper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int addBatch() {
        //从数据库中查到的数据
        List<DeviceDetails> list = deviceMapper.findAll();
        List<Record> records = new ArrayList();
        Random random = new Random();
        //遍历查询到的设备信息
        for (int i = 0; i < list.size(); i++) {
            DeviceDetails deviceDetails = list.get(i);
            //记录信息
            Record record = new Record();
            int i1 = random.nextInt(10);
            //设置风机状态
            if (i1 < 9) {
                deviceDetails.setFan_state(1);
            } else {
                deviceDetails.setFan_state(0);
            }


            //
            record.setDevice_id((int) deviceDetails.getId());
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

            //设置错误日志
            if (deviceDetails.getFan_state() == 0) {
                deviceDetails.setError_log("风机故障");
            } else if (deviceDetails.getPurify_state() == 0) {
                deviceDetails.setError_log("净化器故障");
            } else if (deviceDetails.getSensor_state() == 0) {
                deviceDetails.setError_log("传感器故障");
            } else {
                deviceDetails.setError_log("");
            }
            //设置修改时间
            Date date = new Date();
            String format = sdf.format(date);
            deviceDetails.setUpdate_time(format);
            //设置记录的创建时间--设备信息修改时间
            record.setCreate_time(deviceDetails.getUpdate_time());
            //设置是否发送信息异常
            //获取当前时间减去修改时间的毫秒值
            try {
                long ll = new Date().getTime() - sdf.parse(deviceDetails.getUpdate_time()).getTime();
                if (ll / 1000 > 60) {
                    deviceDetails.setAlarm_state(2);
                    deviceDetails.setError_log("设备信息发送异常");
                }
            } catch (Exception e) {
                System.err.println("日期转换异常");
            }


            int i4 = random.nextInt(2);
            if (i4 == 0) {
                //修改设备信息
                int res = deviceMapper.updateById(deviceDetails);
                //将记录添加到记录列表中
                records.add(record);
            }
        }

        //向记录表中批量添加数据
        int res = recordMapper.addBatch(records);
        return res;
    }

    @Override
    public Map countRecord(String alarmType) {
        if (alarmType == null || alarmType.equals("")) {
            alarmType = "None";
        }
        return recordMapper.countRecord(alarmType);
    }

    @Override
    public List<Map> findAreaVocs() {
        return recordMapper.findAreaVocs();
    }
}
