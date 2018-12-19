package com.hengxinyongli.service.impl;

import com.hengxinyongli.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2016/2/4.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello() {
        return "hello";
    }
}
