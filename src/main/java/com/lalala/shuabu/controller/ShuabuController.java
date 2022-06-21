package com.lalala.shuabu.controller;

import com.lalala.shuabu.model.User;
import com.lalala.shuabu.util.Http;
import com.lalala.shuabu.util.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author：LSP
 * @date 2022/6/17
 */
@RestController
public class ShuabuController {



    @RequestMapping("/shuabu")
    public String MiStepApi(@RequestBody User user) {
        Http http = new Http();
        String s = http.mainHandler(user);
        return s.indexOf("success") != -1 ? R.success("刷步成功"+ user.getStep() +"步") : R.error("刷步失败");
    }
}
