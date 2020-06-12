package com.seayon.validator.constraintvalidators;


import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest{
    @Test
    public void testIsBlank() {
        Assert.assertTrue(StringUtils.isBlank(""));
        Assert.assertTrue(StringUtils.isBlank("   "));
        Assert.assertTrue(StringUtils.isBlank(" "));
        Assert.assertFalse(StringUtils.isBlank("_"));
        Assert.assertFalse(StringUtils.isBlank(" 1 "));
        Assert.assertFalse(StringUtils.isBlank("中文"));
        Assert.assertFalse(StringUtils.isBlank("中文 "));
        Assert.assertFalse(StringUtils.isBlank(" 中文"));
        Assert.assertFalse(StringUtils.isBlank(" 中文 "));
    }
}
