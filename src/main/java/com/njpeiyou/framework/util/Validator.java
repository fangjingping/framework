package com.njpeiyou.framework.util;

/**
 * Created by fangjingping-xes on 2017/4/12.
 */
public interface Validator {
    boolean validate(Object targetParam);
    boolean validate(Object[] targetParam);
    String getErrorMsg(String paramName);
    String getErrorMsg(String[] paramName);
}
