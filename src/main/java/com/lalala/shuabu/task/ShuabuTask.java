package com.lalala.shuabu.task;

import com.lalala.shuabu.model.User;
import com.lalala.shuabu.util.Http;
import com.lalala.shuabu.util.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author：LSP
 * @date 2022/6/20
 */
@Configuration
@EnableScheduling
public class ShuabuTask {


    @Value(value = "${shuabu.userFilePath}")
    private String userFilePath;

    @Scheduled(cron = "0 13 11 * * ? ")
//    @Scheduled(cron = "0 10 10 * * ? ")
    public void shuabu() {
        List<String> userList = readTxt(userFilePath);


        for (String s : userList) {
            String[] split = s.split("!@#");
            User user = new User(split[0], split[1], (int) (25000 + Math.random() * (29999 - 25000 + 1)));

            Http http = new Http();
            String result = http.mainHandler(user);
            System.out.println(result.indexOf("success") != -1 ? R.success("刷步成功" + user.getStep() + "步") : R.error("刷步失败"));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println((int) (25000 + Math.random() * (29999 - 25000 + 1)));
        }
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
}
