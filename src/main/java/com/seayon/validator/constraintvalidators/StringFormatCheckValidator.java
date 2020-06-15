package com.seayon.validator.constraintvalidators;

import com.seayon.validator.constraints.StringFormatCheck;
import sun.nio.cs.ext.GBK;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.UnsupportedEncodingException;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/12/14 11:10
 * @Description
 */
public class StringFormatCheckValidator implements ConstraintValidator<StringFormatCheck, String> {

    private int minLength;

    private int maxLength;

    private String message;

    private String charsetName;

    boolean optional;

    @Override
    public void initialize(final StringFormatCheck stringFormatCheck) {
        this.minLength = stringFormatCheck.minLength();
        this.maxLength = stringFormatCheck.maxLength();
        this.optional = stringFormatCheck.optional();
        this.message = stringFormatCheck.message();
        this.charsetName = stringFormatCheck.charsetName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //传输参数如果为空，判断是否允许为空，如果允许为空就返回true
        if (StringUtils.isBlank(value) && optional) {
            return true;
        }

        int length = 0;
        try {
            if (!StringUtils.isBlank(charsetName)) {
                length = value.getBytes(charsetName).length;
            } else {
                length = value.length();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("The Character Encoding GBK is not supported");
        }
        if (value == null || length == 0) {
            if (minLength == 0) {
                return true;
            } else {
                if (StringUtils.isBlank(message)) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate("该字段值不能为空").addConstraintViolation();
                }
                return false;
            }
        }
        if (length > maxLength) {
            if (message == null || message.length() == 0) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("长度 %s 超出最大限制长度 %s ", length, maxLength)).addConstraintViolation();
            }
            return false;
        }
        if (length < minLength) {
            if (message == null || message.length() == 0) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("长度 %s 低于最小限制长度 %s ", length, minLength)).addConstraintViolation();
            }
            return false;
        }
        return true;

    }
}
