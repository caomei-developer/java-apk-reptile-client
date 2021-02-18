package com.charles.data.fuzhu.fu_category.bean;

import java.util.List;

public class RecommendList {


    public int RETCODE;
    public String MSG;
    public UserinfoBean USERINFO;
    public DataBean DATA;

    public int getRETCODE() {
        return RETCODE;
    }

    public void setRETCODE(int RETCODE) {
        this.RETCODE = RETCODE;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    public UserinfoBean getUSERINFO() {
        return USERINFO;
    }

    public void setUSERINFO(UserinfoBean USERINFO) {
        this.USERINFO = USERINFO;
    }

    public DataBean getDATA() {
        return DATA;
    }

    public void setDATA(DataBean DATA) {
        this.DATA = DATA;
    }

    public static class UserinfoBean {
    }

    public static class DataBean {
        public List<LmlistBean> LMLIST;

        public static class LmlistBean {
            public String LMID;
            public String LMNAME;
            public String LMTYPE;
            public List<BooksBean> BOOKS;

            public String getLMID() {
                return LMID;
            }

            public void setLMID(String LMID) {
                this.LMID = LMID;
            }

            public String getLMNAME() {
                return LMNAME;
            }

            public void setLMNAME(String LMNAME) {
                this.LMNAME = LMNAME;
            }

            public String getLMTYPE() {
                return LMTYPE;
            }

            public void setLMTYPE(String LMTYPE) {
                this.LMTYPE = LMTYPE;
            }

            public List<BooksBean> getBOOKS() {
                return BOOKS;
            }

            public void setBOOKS(List<BooksBean> BOOKS) {
                this.BOOKS = BOOKS;
            }

            public static class BooksBean {
                public int SUBJECT;
                public int KEYNO;
                public int KEYID;
                public String KEYNAME;
                public String COVERURL;
                public int HOTDEGREE;
                public String AUTHORNAME;
                public String AUTHORID;
                public String KEYTYPE;
                public String WORDNUM;
                public String CONTENT;

                public String getCONTENT() {
                    return CONTENT;
                }

                public void setCONTENT(String CONTENT) {
                    this.CONTENT = CONTENT;
                }

                public int getSUBJECT() {
                    return SUBJECT;
                }

                public void setSUBJECT(int SUBJECT) {
                    this.SUBJECT = SUBJECT;
                }

                public int getKEYNO() {
                    return KEYNO;
                }

                public void setKEYNO(int KEYNO) {
                    this.KEYNO = KEYNO;
                }

                public int getKEYID() {
                    return KEYID;
                }

                public void setKEYID(int KEYID) {
                    this.KEYID = KEYID;
                }

                public String getKEYNAME() {
                    return KEYNAME;
                }

                public void setKEYNAME(String KEYNAME) {
                    this.KEYNAME = KEYNAME;
                }

                public String getCOVERURL() {
                    return COVERURL;
                }

                public void setCOVERURL(String COVERURL) {
                    this.COVERURL = COVERURL;
                }

                public int getHOTDEGREE() {
                    return HOTDEGREE;
                }

                public void setHOTDEGREE(int HOTDEGREE) {
                    this.HOTDEGREE = HOTDEGREE;
                }

                public String getAUTHORNAME() {
                    return AUTHORNAME;
                }

                public void setAUTHORNAME(String AUTHORNAME) {
                    this.AUTHORNAME = AUTHORNAME;
                }

                public String getAUTHORID() {
                    return AUTHORID;
                }

                public void setAUTHORID(String AUTHORID) {
                    this.AUTHORID = AUTHORID;
                }

                public String getKEYTYPE() {
                    return KEYTYPE;
                }

                public void setKEYTYPE(String KEYTYPE) {
                    this.KEYTYPE = KEYTYPE;
                }

                public String getWORDNUM() {
                    return WORDNUM;
                }

                public void setWORDNUM(String WORDNUM) {
                    this.WORDNUM = WORDNUM;
                }
            }
        }

        public List<LmlistBean> getLMLIST() {
            return LMLIST;
        }

        public void setLMLIST(List<LmlistBean> LMLIST) {
            this.LMLIST = LMLIST;
        }
    }
}
