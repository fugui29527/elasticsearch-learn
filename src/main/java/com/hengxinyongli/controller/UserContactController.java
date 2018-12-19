package com.hengxinyongli.controller;

import com.hengxinyongli.service.UserContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/17 14:11
 * @since <版本号>
 */
@RestController
public class UserContactController {
    private Logger logger=LoggerFactory.getLogger(getClass());
    @Autowired
    private UserContactService userContactService;

    @GetMapping("/toes")
    public String toes(int startPage){

             userContactService.toes(startPage);

        return "ok";
    }

}
