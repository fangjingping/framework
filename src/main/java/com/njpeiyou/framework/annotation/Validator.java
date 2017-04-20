package com.njpeiyou.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by fangjingping-xes on 2017/4/11.
 */
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
@Repeatable(Validators.class)
public @interface Validator {
    String paramName() default "null";
    String[] paramNames() default "null";
    Class[] validateClass();
}
