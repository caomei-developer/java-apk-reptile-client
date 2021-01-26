package com.charles.util;

public class SignatureUtil {
    public static String consumerSecret = "cCEc0PPno08rFDwP";

    public static String addBookShelf(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("cID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString5);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String addCommentFuli(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String addDayRead(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("doWhat=");
        stringBuilder.append(paramString4);
        stringBuilder.append("minutes=");
        stringBuilder.append(paramString5);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String afterDaySign(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("nDay=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String aliFuzhu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("itemID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("rmb=");
        stringBuilder.append(paramString5);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String bookType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("doWhat=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String bookcata(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString2);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("isUpdate=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramLong);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        paramString1 = stringBuilder.toString().trim();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String bookcolumn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("columnID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String bookindex(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString2);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("lmID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramLong);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        paramString1 = stringBuilder.toString().trim();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String booklist(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String booksorts(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("prefer=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String buycart(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bList=");
        stringBuilder.append(paramString3);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("cost=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString5);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String changeTask(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("doWhat=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String commbooks(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pn=");
        stringBuilder.append(paramString6);
        stringBuilder.append("prefer=");
        stringBuilder.append(paramString3);
        stringBuilder.append("rank=");
        stringBuilder.append(paramString5);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String currency(String paramString1, String paramString2, String paramString3, String paramString4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String delBookShelf(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bList=");
        stringBuilder.append(paramString3);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String detail(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("goID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String downbatchfree(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("batch=");
        stringBuilder.append(paramString4);
        stringBuilder.append("bID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("cNoList=");
        stringBuilder.append(paramString5);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString6);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String downnum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("cID=");
        stringBuilder.append(paramString5);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String editUserBirthday(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("newUBirthday=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String editUserName(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String editUserPhone(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("dCode=");
        stringBuilder.append(paramString5);
        stringBuilder.append("pNo=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("vCode=");
        stringBuilder.append(paramString6);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String editUserPwd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("dCode=");
        stringBuilder.append(paramString5);
        stringBuilder.append("pNo=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("vCode=");
        stringBuilder.append(paramString6);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String editUserSex(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("newUSex=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String editUserSig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String elitebook(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("page=");
        stringBuilder.append(paramString2);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramLong);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String evokebatchfree(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("cID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("cNum=");
        stringBuilder.append(paramString5);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString6);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String evokeselectfree(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("cNoList=");
        stringBuilder.append(paramString4);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString5);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String freshGitt(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("doWhat=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String getSMSCode(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("country=");
        stringBuilder.append(paramString5);
        stringBuilder.append("dCode=");
        stringBuilder.append(paramString4);
        stringBuilder.append("pNo=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String getUserCountry(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("doWhat=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String hdBalance(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pn=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String hdUnlock(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("doWhat=");
        stringBuilder.append(paramString5);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String hotbookss(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("prefer=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String imeiadd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("imei=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String inviteInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String inviteList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pn=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String keyBooks(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pn=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String listcommbook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6,
                                      String paramString7, String paramString8, String paramString9, String paramString10, String paramString11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bt=");
        stringBuilder.append(paramString5);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pn=");
        stringBuilder.append(paramString9);
        stringBuilder.append("prefer=");
        stringBuilder.append(paramString3);
        stringBuilder.append("rank=");
        stringBuilder.append(paramString8);
        stringBuilder.append("state=");
        stringBuilder.append(paramString7);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("vip=");
        stringBuilder.append(paramString6);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString10, paramString11, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String loglist(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pn=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String memberLog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pn=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String motivateRead(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("doWhat=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String myhome(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String operatorLogOnsign(String paramString1, String paramString2, String paramString3, String paramString4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String orderFuzhu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String pubchapter(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("cID=");
        stringBuilder.append(paramString4);
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString5);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String pwdLogOn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("pcd=");
        stringBuilder.append(paramString3);
        stringBuilder.append("pwd=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String qqinterLogOn(String paramString1, String paramString2, String paramString3, String paramString4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String shelfbooks(String paramString1, long paramLong1, String paramString2, int paramInt, long paramLong2, String paramString3, String paramString4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("intBhSynTime=");
        stringBuilder.append(paramLong2);
        stringBuilder.append("pn=");
        stringBuilder.append(paramInt);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramLong1);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString2);
        stringBuilder.append("");
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String signInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String tokenLogOn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String userAnnul(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("dCode=");
        stringBuilder.append(paramString5);
        stringBuilder.append("pNo=");
        stringBuilder.append(paramString4);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        stringBuilder.append("vCode=");
        stringBuilder.append(paramString6);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String userInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String userRestore(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("dCode=");
        stringBuilder.append(paramString4);
        stringBuilder.append("pNo=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("vCode=");
        stringBuilder.append(paramString5);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String vCodeLogOn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("dCode=");
        stringBuilder.append(paramString4);
        stringBuilder.append("pNo=");
        stringBuilder.append(paramString3);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("vCode=");
        stringBuilder.append(paramString5);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String wechatBind(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        stringBuilder.append("uID=");
        stringBuilder.append(paramString3);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String wechatLogOn(String paramString1, String paramString2, String paramString3, String paramString4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String weiborLogOn(String paramString1, String paramString2, String paramString3, String paramString4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("consumerKey=");
        stringBuilder.append(paramString1);
        stringBuilder.append("timestamp=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }
}
