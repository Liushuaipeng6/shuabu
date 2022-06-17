package com.lalala.shuabu.controller;

import com.lalala.shuabu.service.IDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author：LSP
 * @date 2022/6/14
 */
@RestController
public class DetectionController {
    @Autowired
    private IDetectionService detectionService;

    @RequestMapping("/excel/export")
    public void test(HttpServletResponse response) throws Exception {
        detectionService.getDetectionInfo(response);


    }
}
