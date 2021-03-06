package com.njpeiyou.framework.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fangjingping-xes on 2017/4/1.
 */
public class REUtil {

    public static Boolean isUrl(String url){
        if(StringUtils.isEmpty(url)){return false;}
        String regEx="^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(url);
        boolean match = matcher.matches();
        return match;
    }

    public static Boolean isEmail(String email){
        if(StringUtils.isEmpty(email)){return false;}
        String regEx="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
