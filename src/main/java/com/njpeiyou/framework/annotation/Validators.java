package com.njpeiyou.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fangjingping-xes on 2017/4/12.
 */

@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface Validators {
    Validator[] value();
}
