package com.seayon.validator.constraintvalidators;

import com.seayon.validator.bean.DateDtoForTest;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;

import java.util.Set;

import static org.junit.Assert.*;

public class DateFormatCheckValidatorTest {

    @Test
    public void test() {

//获取验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        DateDtoForTest dateDtoForTest = new DateDtoForTest();
        dateDtoForTest.setDateStr1("20200104");
        dateDtoForTest.setDateStr2("20200104 12:01:01");
        dateDtoForTest.setDateStr2("20200104 12:01:01 123");

        Set<ConstraintViolation<DateDtoForTest>> validate = validator.validate(dateDtoForTest);



    }

}
