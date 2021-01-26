package com.charles.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DesUtil {
    public static final String getAppKey = "ZKYm5vSUhvcG9IbXNZTG1pb2";
    public static final String appKey = "6a76fa4370c18f00";

    public static final String appSecret = "U2FsdGVkX19xzjw/wexid7jGR5+gPYvzNyipiLU6y3wa2/Z2tkjj4vqDVXDlKSuymsqyDLJgr3wjbsSKl0uW2g=";

    public  final String encoding = "utf-8";

    public  final String iv = "01234567";

    public static String decode(String paramString1, String paramString2) throws Exception {
        DESedeKeySpec dESedeKeySpec = new DESedeKeySpec(paramString2.getBytes());
        SecretKey secretKey = SecretKeyFactory.getInstance("desede").generateSecret(dESedeKeySpec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec("01234567".getBytes()));
        return new String(cipher.doFinal(AndBase64.decode(paramString1, 0)), "utf-8");
    }

    public  String encode(String paramString1, String paramString2) throws Exception {
        DESedeKeySpec dESedeKeySpec = new DESedeKeySpec(paramString2.getBytes());
        SecretKey secretKey = SecretKeyFactory.getInstance("desede").generateSecret(dESedeKeySpec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        cipher.init(1, secretKey, new IvParameterSpec("01234567".getBytes()));
        return AndBase64.encodeToString(cipher.doFinal(paramString1.getBytes("utf-8")), 0);
    }
}
