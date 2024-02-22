package com.soft.keeper.controller;

import com.soft.keeper.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @RequestMapping("/addBath")
    @ResponseBody
    public int addBatch() {
        return deviceService.addBatch();
    }


    @RequestMapping("/groupByPro")
    @ResponseBody
    public List<Map> groupByPro() {
        return deviceService.groupByPro();
    }


    @RequestMapping("/groupByAlarm")
    @ResponseBody
    public Map<String, Long> groupByAlarm() {
        return deviceService.groupByAlarm();
    }

    @RequestMapping("/findErrorLog")
    @ResponseBody
    public List<Map> findErrorLog() {
        return deviceService.findErrorLog();
    }

    @RequestMapping("/countNetworkNum")
    @ResponseBody
    public List<Map> countNetworkNum() {
        return deviceService.countNetworkNum();
    }

    @RequestMapping("/groupByPro1")
    @ResponseBody
    public List<Map> groupByPro1(){
        return deviceService.groupByPro1();
    }

    @RequestMapping("/countNum")
    @ResponseBody
    public Map countNum(){
        return deviceService.countNum();
    }
}
