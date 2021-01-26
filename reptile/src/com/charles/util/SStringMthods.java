package com.charles.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

public class SStringMthods {
    public static String base64_code(String paramString) {
        return new String(AndBase64.decode(paramString.getBytes(), 0));
    }

    public static String bytes2Hex(byte[] paramArrayOfbyte) {
        String str = "";
        for (byte b = 0; b < paramArrayOfbyte.length; b++) {
            String str1 = Integer.toHexString(paramArrayOfbyte[b] & 0xFF);
            String str2 = str;
            if (str1.length() == 1) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(str);
                stringBuilder1.append("0");
                str2 = stringBuilder1.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(str1);
            str = stringBuilder.toString();
        }
        return str;
    }

    public static String connectParameters(Map<String, String> paramMap) {
        if (paramMap == null || paramMap.isEmpty())
            return "";
        StringBuffer stringBuffer = new StringBuffer();
        Object[] arrayOfObject = paramMap.keySet().toArray();
        Arrays.sort(arrayOfObject);
        int i = arrayOfObject.length;
        byte b1 = 0;
        byte b2 = 0;
        while (b1 < i) {
            Object object = arrayOfObject[b1];
            stringBuffer.append(object);
            stringBuffer.append("=");
            stringBuffer.append(paramMap.get(object));
            if (++b2 < arrayOfObject.length)
                stringBuffer.append("&");
            b1++;
        }
        return stringBuffer.toString();
    }

    public static String md5(String paramString) {
        try {
            byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder(arrayOfByte.length * 2);
            int i = arrayOfByte.length;
            for (byte b = 0; b < i; b++) {
                int j = arrayOfByte[b] & 0xFF;
                if (j < 16)
                    stringBuilder.append("0");
                stringBuilder.append(Integer.toHexString(j));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            RuntimeException runtimeException = new RuntimeException("Huh, MD5 should be supported?", noSuchAlgorithmException);
            throw runtimeException;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", unsupportedEncodingException);
        }
    }

    public static String md5Number(String paramString, int paramInt) {
        for (byte b = 0; b < paramInt; b++)
            paramString = md5(paramString);
        return paramString;
    }

    public static boolean mobileNumVerify(String paramString) {
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9])|(14[0-9]))\\d{8}$").matcher(paramString).matches();
    }

    public static String shaEncrypt(String paramString) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(md5(paramString).getBytes());
            byte[] arrayOfByte = messageDigest.digest();
            MessageDigest algb  = MessageDigest.getInstance("SHA-1");
            algb.update(md5(paramString).getBytes());
            if (algb.isEqual(arrayOfByte,algb.digest())) {
                System.out.println("信息检查正常");
            } else {
                System.out.println("摘要不相同");
            }
            return bytes2Hex(algb.digest());
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        return null;
    }
}
