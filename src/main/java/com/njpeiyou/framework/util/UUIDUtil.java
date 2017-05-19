package com.njpeiyou.framework.util;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by fangjingping-xes on 2017/4/1.
 */
public class UUIDUtil {

    public static String getShortUUID(){
        // TODO: fangjingping 需要一个短UUID运算。16进制？ 64进制？
        return UUID.randomUUID().toString();
    }

    public static String getRuleRandomStr() {
        Set<String> randomStringSet = CacheKit.get("WechatTagCache", "randomStringSet");
        if (null == randomStringSet) {
            randomStringSet = new HashSet<>();
            List<Record> recordList = Db.find("select rule_name from tag_update_rule_webhook");
            for (Record record : recordList) {
                randomStringSet.add(record.get("rule_name"));
            }
        }
        String randomStr = RandomStringUtils.randomAlphabetic(8);
        while (randomStringSet.contains(randomStr)) {
            randomStr = RandomStringUtils.randomAlphabetic(8);
        }

        randomStringSet.add(randomStr);
        CacheKit.put("WechatTagCache", "randomStringSet", randomStringSet);
        return randomStr;
    }

    public static String getTemplateRandomStr(){
        return RandomStringUtils.randomAlphabetic(16);
    }

    public static int getMessageRandomNum(){
        return RandomUtils.nextInt();
    }
}
