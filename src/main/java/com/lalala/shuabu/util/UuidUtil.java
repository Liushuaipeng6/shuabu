package com.lalala.shuabu.util;

import java.util.UUID;

/**
 * @创建人：Gavin
 * @date 17/12/6 17:22
 */
public class UuidUtil {
    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    public static void main(String[] args) {
        for(int k=0; k<15; k++)
        {
            System.out.println(get32UUID());
        }

    }
}
