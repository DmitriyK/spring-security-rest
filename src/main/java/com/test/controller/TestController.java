package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Controller
@RequestMapping(value = "/foos")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "otvet! =" + randomAlphabetic(6);
    }
}
