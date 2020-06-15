package com.seayon.validator.constraintvalidators;


import com.seayon.validator.utils.StringToHex;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class StringUtilsTest {
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

        System.out.println("\"我的祖国哦\".length() = " + "我的祖国哦".length());
        System.out.println("\"我的祖国哦abc\".length() = " + "我的祖国哦abc".length());
        try {
            System.out.println("\"我的祖国哦abc\".getBytes(\"GBK\").length = " + "我的祖国哦abc".getBytes("GBK").length);
            System.out.println("\"我的祖国哦abc\".getBytes(\"UTF-8\").length = " + "我的祖国哦abc".getBytes("UTF-8").length);
            System.out.println("\"我的祖国哦abc\".getBytes(\"UTF-16\").length = " + "我的祖国哦abc".getBytes("UTF-16").length);
            System.out.println("\"Hello我的祖国\uD83D\uDCF1\" = " + "Hello我的祖国📱");
            String greeting = "Hello我的祖国📱";
            System.out.println("StringToHex.stringToHexString(greeting) = " + StringToHex.stringToHexString(greeting));

            System.out.println(greeting.length());
            int cpCount = greeting.codePointCount(0, greeting.length());

            System.out.println("cpCount = " + cpCount);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
