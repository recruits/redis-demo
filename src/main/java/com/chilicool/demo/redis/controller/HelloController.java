package com.chilicool.demo.redis.controller;

import com.chilicool.demo.redis.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by zechenzhang on 2017/6/3.
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.put("time", new Date());
        model.put("message", this.message);
        model.put("serial_id", helloService.getHelloFraquncy());

        return "hello";
    }

}
