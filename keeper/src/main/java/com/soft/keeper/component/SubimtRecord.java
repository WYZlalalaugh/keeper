package com.soft.keeper.component;

import com.soft.keeper.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SubimtRecord {
    @Autowired
    RecordService recordService;
    //规定每个多长时间执行一次
    @Scheduled(fixedRate = 10000)
    public void test(){
        int res = recordService.addBatch();
        System.out.println("更新的记录数:"+res);
    }
}
