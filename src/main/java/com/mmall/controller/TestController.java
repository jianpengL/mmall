package com.mmall.controller;

import com.mmall.common.TokenCache;
import com.mmall.dao.UserMapper;
import org.apache.commons.net.ntp.TimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Created by liujianp on 2018/2/18.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private UserMapper userMapper;

    private static final Logger logger= LoggerFactory.getLogger(TestController.class);

    public static void main(String[] args) {
        TimeStamp a=new TimeStamp(System.currentTimeMillis());
        System.out.println(a);
        Date c=new Date();
        System.out.println(c);

    }
    @RequestMapping(value = "set_cache.do")
    @ResponseBody
    public String setCache(String key,String value) {
       TokenCache.setKey(key, value);
        return MessageFormat.format("set key :{0},value:{1}.ok",key,value);
    }

    @RequestMapping(value = "get_cache.do")
    @ResponseBody
    public String getCache(String key) throws ExecutionException{
        return TokenCache.getKey(key);
    }
    @RequestMapping(value="test.do")
    @ResponseBody
    public String test(String str){
        logger.info("testinfo");
        logger.warn("testwarn");
        logger.error("testerror");
        return "testvalue:"+str;
    }


}
