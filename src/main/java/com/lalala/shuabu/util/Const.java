package com.lalala.shuabu.util;

import java.text.DecimalFormat;

/**
 */
public class Const {
    public static final String SESSION_SECURITY_CODE = "SESSION_SEC_CODE";
    public static final String SESSION_USER = "SESSION_USER";
    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    public static final String LOGIN_TOKEN_KEY = "BbcShop-token";
    public static final String SMS_PHONE_CODE = "PHONE-CODE";
    public static final String COOKIE_NAME = "COOKIE_SDC_WEHCAT";

    //TOKEN过期时间，设置半年过期时间
    public final static int TOKEN_EXPIRE = 3600 * 24 * 180;
    public final static int COOKIE_EXPIRE = 24 * 60 * 60;   //一天有效期
    /**
     * 系统返回代码
     */
    //返回的正确代码
    public static final int SUCCESS = 200;
    //返回错误代码
    public static final int ERROR = 400;
    //返回权限不足
    public static final int PERMISSION_NO = 403;
    //系统级错误
    public static final int ERROR_SYSTEM = 500;
    //登陆超时
    public static final int LOGIN_OUT = 401;
    //被踢下线
    public static final int KICK_OUT=300;


    //double保留两位小数
    public static DecimalFormat doubleFormat=new DecimalFormat(".##");

    /**
     * 操作日志类型
     */
    public static final int LOG_OTHER=0;    //其它
    public static final int LOG_ADD=1;      //新增
    public static final int LOG_EDIT=2;   //修改
    public static final int LOG_DELETE=3;   //删除

    /**
     * 商品状态
     */
    public enum EnumStatusProduct {

        draft("草稿",0),finish("编辑完成",1),online("已上架",2),outline("已下架",3);
        // 成员变量
        private String name;
        private int code;

        // 构造方法
        private EnumStatusProduct(String name, int code) {
            this.name = name;
            this.code = code;
        }

        public String getName()
        {
            return this.name;
        }
        public int getCode()
        {
            return this.code;
        }
    }

    /**
     * 用户状态
     */
    public enum EnumStatusUser{

        normal("使用中",0),stop("禁用",1);
        // 成员变量
        private String name;
        private int code;

        // 构造方法
        private EnumStatusUser(String name, int code) {
            this.name = name;
            this.code = code;
        }

        public String getName()
        {
            return this.name;
        }
        public int getCode()
        {
            return this.code;
        }
    }

    /**
     * 订单状态
     */
    public enum OrderStatus {
        //5和6的区别，5:没有发货退货，6，已经发货退货
        create("待付款",0),payed("待发货",1),express("已发货",2),recived("已收货",4),noExpressRefund("退货",5),expressRefund("退货",6),cancel("订单取消",7);
        // 成员变量
        private String name;
        private int code;

        // 构造方法
        private OrderStatus(String name, int code) {
            this.name = name;
            this.code = code;
        }
        public static String getName(int code){
            String name="";
            switch(code){
                case 0: name=create.name; break;
                case 1: name=payed.name; break;
                case 2: name=express.name;break;
                case 4: name=recived.name;break;
                case 5: name=noExpressRefund.name;break;
                case 6: name=expressRefund.name;break;
                case 7: name=cancel.name;break;
                default:name="未知";
            }
            return name;
        }
        public String getName()
        {
            return this.name;
        }
        public int getCode()
        {
            return this.code;
        }
    }
    /**
     * 支付状态
     */
    public enum PayStatus {
        nopay("未付款",0),payed("已付款",1),refund("退款",2);
        // 成员变量
        private String name;
        private int code;

        // 构造方法
        private PayStatus(String name, int code) {
            this.name = name;
            this.code = code;
        }

        public String getName()
        {
            return this.name;
        }
        public int getCode()
        {
            return this.code;
        }
    }
    /**
     * 发货状态
     */
    public enum ExpressStatus {
        noExpress("未发货",0),expressed("已发货",1),confirm("确认收获",2),refund("退货",3);
        // 成员变量
        private String name;
        private int code;

        // 构造方法
        private ExpressStatus(String name, int code) {
            this.name = name;
            this.code = code;
        }

        public String getName()
        {
            return this.name;
        }
        public int getCode()
        {
            return this.code;
        }
    }


}
