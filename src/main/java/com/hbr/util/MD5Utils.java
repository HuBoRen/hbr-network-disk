

package com.hbr.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * MD5工具类
 * huboren
 */
public class MD5Utils {


    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',

            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    protected static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();

        }

    }

    public static String getMD5String(String str) {

        String md5Code = null;

        try {

            // 注意：此处以UTF-8编码获取字节码

            byte[] bytes = str.getBytes("UTF-8");

            md5Code = getMD5String(bytes);

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

        return md5Code;
    }


    private static String getMD5String(byte[] bytes) {

        messagedigest.update(bytes);

        return bufferToHex(messagedigest.digest());

    }


    private static String bufferToHex(byte bytes[]) {

        return bufferToHex(bytes, 0, bytes.length);

    }


    private static String bufferToHex(byte bytes[], int m, int n) {

        StringBuffer stringbuffer = new StringBuffer(2 * n);

        int k = m + n;

        for (int l = m; l < k; l++) {

            appendHexPair(bytes[l], stringbuffer);

        }

        return stringbuffer.toString();

    }


    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {

        char c0 = hexDigits[(bt & 0xf0) >> 4];

        char c1 = hexDigits[bt & 0xf];

        stringbuffer.append(c0);

        stringbuffer.append(c1);

    }

}

