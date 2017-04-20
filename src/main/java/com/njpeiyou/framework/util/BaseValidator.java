package com.njpeiyou.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by fangjingping-xes on 2017/4/19.
 */
public class BaseValidator implements Validator {

    @Override
    public boolean validate(Object targetParam) {
        return true;
    }

    @Override
    public boolean validate(Object[] targetParam) {
        return true;
    }

    @Override
    public String getErrorMsg(String paramName) {
        return paramName + " invalid";
    }

    @Override
    public String getErrorMsg(String[] paramName) {
        String errParams = StringUtils.join(paramName,",");
        return errParams + " invalid";
    }
}
