package com.logic.annotation;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 20:08
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    String name();
    String type() default "string";
}
