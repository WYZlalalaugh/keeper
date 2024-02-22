package com.soft.keeper.controller;

import com.soft.keeper.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @RequestMapping("/submitRecord")
    @ResponseBody
    public int submitRecord() {
        return recordService.addBatch();
    }

    @RequestMapping("/countRecord/{alarmtype}")
    @ResponseBody
    public Map countRecord(@PathVariable String alarmtype) {
        return recordService.countRecord(alarmtype);
    }
    @RequestMapping("/findAreaVocs")
    @ResponseBody
    public List<Map> findAreaVocs() {
    return recordService.findAreaVocs();
    }
}
