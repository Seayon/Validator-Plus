package com.seayon.validator.constraints;

import com.seayon.validator.constraintvalidators.DateFormatCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/12/14 11:03
 * @Description 日期参数校验工具，可以按照自定义的参数格式尝试进行 format，如果 format 失败，就定义校验失败
 */
@Target({ElementType.METHOD, ElementType.FIELD, ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {DateFormatCheckValidator.class})
@Documented
public @interface DateFormatCheck {
    String message() default "日期格式不正确";

    String dateFormatStr();

    /**
     * 是否可以为空，可选，默认不能为空
     *
     * @return
     */
    boolean optional() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @see DateFormatCheck
     */
    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateFormatCheck[] value();
    }

}
