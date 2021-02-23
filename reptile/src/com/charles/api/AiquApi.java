package com.charles.api;

import java.security.spec.X509EncodedKeySpec;

public class AiquApi {

    //http://statics.yingxinpeixun.com/category/2/all.json
    //http://statics.yingxinpeixun.com/category/1/all.json


    //MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6W6LhspFzVVAeuV0W3vd7v6gzWW11g2THoamL0pNCLdeEahqmqn9RyYoTsvZuwjLyyaXQX/ieQGrl9iIlP7NpAlwbxn8LEEd6NzMrVvlEtymrPv7PpqjxL8biMCw+QmJAcRHTC51WYU0hrgwCw3Lf37WB7Z+9/ioce8pTEHz80QIDAQAB
    public static String a = "https://api.yingxinpeixun.com";

    public static String b = "https://aiquxs.newsina.cn";

    public static String c = "http://statics.yingxinpeixun.com";

    //banenr
    String banner = "banner/1/all.json";
    String hot = "book/hot/1/hot.json";
    String reco = "book/reco/1/reco.json";
    String nwes = "book/new/1/new.json";
    String finish = "book/finish/1/finish.json";

//    public static String a(String paramString1, String paramString2) {
//        try {
//            byte[] arrayOfByte = Base64.decode(paramString2, 2);
//            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
//            this(arrayOfByte);
//            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
//            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//            cipher.init(1, publicKey);
//            String str = Base64.encodeToString(cipher.doFinal(paramString1.getBytes()), 0);
//            paramString1 = str;
//        } finally {}
//        return paramString1;
//    }
}
