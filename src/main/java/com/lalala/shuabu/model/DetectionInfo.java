package com.lalala.shuabu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author：LSP
 * @date 2022/6/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetectionInfo {
    private String address;

    private String age;

    private String deptCode;

    private String deptName;

    private String dutyDoctorName;
    //采集时间
    private String gatherDay;
    //采集地点
    private String gatherSite;
    //检测时间
    private String happenTime;
    //身份证号
    private String idCard;
    private String itemEname;
    //核酸检测
    private String itemName;
    private String itemName1;
    //核酸结果
    private String itemResult;
    private String linkMan;
    //名字
    private String name;
    private String orgCode;
    //检测机构
    private String orgName;
    private String patNum;
    private String reportId;
    private String sex;
    private String systemTime;
    private String tel;
}
