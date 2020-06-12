package com.seayon.validator.constraintvalidators;

import com.seayon.validator.constraints.DateFormatCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/12/14 11:10
 * @Description
 */
public class DateFormatCheckValidator implements ConstraintValidator<DateFormatCheck, String> {

	private String dateFormatStr;

	boolean optional;

	@Override
	public void initialize(final DateFormatCheck dateFormatCheck) {
		this.dateFormatStr = dateFormatCheck.dateFormatStr();
		this.optional = dateFormatCheck.optional();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		//传输参数如果为空，判断是否允许为空，如果允许为空就返回true
		if (StringUtils.isBlank(value)) {
			return optional;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatStr);
		try {
			simpleDateFormat.setLenient(false);
			simpleDateFormat.parse(value);
		} catch (ParseException e) {
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("字符串无法按照格式 %s 转换为日期", dateFormatStr)).addConstraintViolation();
			return false;
		}
		return true;
	}
}
