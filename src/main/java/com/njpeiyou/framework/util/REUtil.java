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
        String regEx="^((http|https):\\/\\/)?[\\w-_.]+(\\/[\\w-_]+)*\\/?$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(url);
        boolean match = matcher.matches();
        return match;
    }

    public static Boolean isEmail(String email){
        if(StringUtils.isEmpty(email)){return false;}
        String regEx="^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
