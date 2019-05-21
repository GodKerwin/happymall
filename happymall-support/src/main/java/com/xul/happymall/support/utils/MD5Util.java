package com.xul.happymall.support.utils;

import com.xul.happymall.support.enums.ExceptionEnum;
import com.xul.happymall.support.exception.HappymallSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Created by lxu on 2018/12/11.
 */
public class MD5Util {

    private static final Logger log = LoggerFactory.getLogger(MD5Util.class);

    private static final String SALT = "happymall";

    public static String encode(String origin) {
        origin += SALT;
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            log.error(e.toString());
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
        char[] charArray = origin.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
