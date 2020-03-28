package com.learn.controller;

import com.alibaba.fastjson.JSON;
import com.learn.config.UndertowConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wu00y
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {
    @Autowired
    private UndertowConfig undertowConfig;
    private  volatile int i = 0;
    @RequestMapping(value = "/world",method = RequestMethod.GET)
    public String hello(){
        synchronized (this) {
            log.info("hello world i:{}", i++);
            log.info("hello world config:{}", undertowConfig.toString());
        }
        return "hello world";
    }
}
