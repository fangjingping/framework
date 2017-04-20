package com.njpeiyou.framework.util;

import java.util.UUID;

/**
 * Created by fangjingping-xes on 2017/4/1.
 */
public class UUIDUtil {

    public static String getShortUUID(){
        // TODO: fangjingping 需要一个短UUID运算。16进制？ 64进制？
        return UUID.randomUUID().toString();
    }
}
