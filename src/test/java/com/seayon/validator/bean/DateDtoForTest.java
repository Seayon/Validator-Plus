package com.seayon.validator.bean;

import com.seayon.validator.constraints.DateFormatCheck;

public class DateDtoForTest {


    @DateFormatCheck(dateFormatStr = "yyyyMMdd", message = "tip message A1")
    private String dateStr1;

    @DateFormatCheck(dateFormatStr = "yyyy-MM-dd HH:mm:ss", message = "tip message A1")
    private String dateStr2;

    @DateFormatCheck(dateFormatStr = "yyyy-MM-dd HH:mm:ss SSS", message = "tip message A1")
    private String dateStr3;

    public String getDateStr1() {
        return dateStr1;
    }

    public void setDateStr1(String dateStr1) {
        this.dateStr1 = dateStr1;
    }

    public String getDateStr2() {
        return dateStr2;
    }

    public void setDateStr2(String dateStr2) {
        this.dateStr2 = dateStr2;
    }

    public String getDateStr3() {
        return dateStr3;
    }

    public void setDateStr3(String dateStr3) {
        this.dateStr3 = dateStr3;
    }
}
