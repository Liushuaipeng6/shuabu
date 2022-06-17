package com.lalala.shuabu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lalala.shuabu.model.DetectionInfo;
import com.lalala.shuabu.service.IDetectionService;
import com.lalala.shuabu.util.ExcelUtils;
import com.lalala.shuabu.util.HttpClientUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @description:
 * @author：LSP
 * @date 2022/6/14
 */
@Service
public class DetectionImpl implements IDetectionService {

    public static void main(String[] args) {
        String filePath = "D:\\test_test\\code.txt";
//        List<String> readText = readTxt(filePath);
//        System.out.println(readText);
    }

    @Override
    public void getDetectionInfo(HttpServletResponse response) throws Exception {

        String filePath = "D:\\test_test\\code.txt";
//        String filePath = "/tmp/code.txt";
        List<String> readText = readTxt(filePath);

        List<DetectionInfo> list = new ArrayList<>();

        for (String s : readText) {
            Map<String, String> map = new HashMap<>();
            map.put("idCard", s);
            map.put("publicNoCode", null);

            String result = HttpClientUtils.sendHttpPost("http://hsjc.jiankangjining.com:10079/wander-nucleicSearch/hello/getDetectionInfo", map);


            List<DetectionInfo> list1 = JSONObject.parseArray(result, DetectionInfo.class);
            if (list1.size() > 0) {
                list.addAll(list1);
            }
        }

        ExcelUtils.listToExcel(list, getTitleMap(), "核酸结果", response);
    }

    public List<String> readTxt(String filePath) {

        try {
            List<String> lineTxtList = new ArrayList<>();
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    lineTxtList.add(lineTxt);
                    System.out.println(lineTxt);
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
            return lineTxtList;
        } catch (Exception e) {
            System.out.println("文件读取错误!");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * d导出标题栏
     *
     * @return
     */
    private LinkedHashMap<String, String> getTitleMap() {
        LinkedHashMap<String, String> names = new LinkedHashMap<String, String>();
        //name和operator是ExcelDTO实体类的属性名，姓名表示name列表头显示的名称
        names.put("name", "姓名");
        names.put("idCard", "身份证号");
        names.put("gatherDay", "采集时间");
        names.put("gatherSite", "采集地点");
        names.put("happenTime", "检测时间");
        names.put("itemName", "核酸检测");
        names.put("itemResult", "核酸结果");
        names.put("orgName", "检测机构");
        return names;
    }
}
