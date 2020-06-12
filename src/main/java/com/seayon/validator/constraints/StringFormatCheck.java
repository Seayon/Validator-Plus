package com.seayon.validator.constraints;

import com.seayon.validator.constraintvalidators.StringFormatCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/12/14 11:03
 * @Description
 */
@Target({ElementType.METHOD, ElementType.FIELD, ANNOTATION_TYPE, CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {StringFormatCheckValidator.class})
@Documented
@Repeatable(StringFormatChecks.class)
public @interface StringFormatCheck {
	String message() default "";

	int minLength();

	int maxLength();

	boolean optional() default false;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @see StringFormatCheck
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		StringFormatCheck[] value();
	}

}
