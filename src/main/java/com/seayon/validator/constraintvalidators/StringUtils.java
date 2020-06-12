package com.seayon.validator.constraintvalidators;

class StringUtils {
    /**
     * 判断字符是否为空
     *
     * @param cs
     * @return
     */
    protected static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}
