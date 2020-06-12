package com.seayon.validator.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/12/14 11:03
 * @Description
 */
@Target({ElementType.METHOD, ElementType.FIELD, ANNOTATION_TYPE, CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface StringFormatChecks {
	StringFormatCheck[] value();
}
