package com.charles.data.chuai.category.bean;

import com.charles.data.chuai.Response;

import java.util.List;


public class CategoryBean extends Response {
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sortIndex : 0
         * sortType : [{"sort":0,"sortName":"全部"},{"sort":1,"sortName":"校园"},{"sort":2,"sortName":"都市"},{"sort":3,"sortName":"豪门"},{"sort":4,"sortName":"悬疑"},{"sort":5,"sortName":"灵异"},{"sort":6,"sortName":"网络"},{"sort":7,"sortName":"穿越"},{"sort":8,"sortName":"仙侠"}]
         * kindIndex : 0
         * kindType : [{"kind":0,"kindName":"小说"},{"kind":1,"kindName":"漫画"},{"kind":2,"kindName":"有声"}]
         * fullIndex : 1
         * fullType : [{"full":"","fullName":"不限"},{"full":"1","fullName":"完结"},{"full":"0","fullName":"连载"}]
         * freeIndex : 0
         * freeType : [{"free":"","freeName":"不限"},{"free":"0","freeName":"付费"},{"free":"1","freeName":"免费"}]
         */

        private int sortIndex;
        private int kindIndex;
        private String fullIndex;
        private String freeIndex;
        private List<SortTypeBean> sortType;
        private List<KindTypeBean> kindType;
        private List<FullTypeBean> fullType;
        private List<FreeTypeBean> freeType;

        public int getSortIndex() {
            return sortIndex;
        }

        public void setSortIndex(int sortIndex) {
            this.sortIndex = sortIndex;
        }

        public int getKindIndex() {
            return kindIndex;
        }

        public void setKindIndex(int kindIndex) {
            this.kindIndex = kindIndex;
        }

        public String getFullIndex() {
            return fullIndex;
        }

        public void setFullIndex(String fullIndex) {
            this.fullIndex = fullIndex;
        }

        public String getFreeIndex() {
            return freeIndex;
        }

        public void setFreeIndex(String freeIndex) {
            this.freeIndex = freeIndex;
        }

        public List<SortTypeBean> getSortType() {
            return sortType;
        }

        public void setSortType(List<SortTypeBean> sortType) {
            this.sortType = sortType;
        }

        public List<KindTypeBean> getKindType() {
            return kindType;
        }

        public void setKindType(List<KindTypeBean> kindType) {
            this.kindType = kindType;
        }

        public List<FullTypeBean> getFullType() {
            return fullType;
        }

        public void setFullType(List<FullTypeBean> fullType) {
            this.fullType = fullType;
        }

        public List<FreeTypeBean> getFreeType() {
            return freeType;
        }

        public void setFreeType(List<FreeTypeBean> freeType) {
            this.freeType = freeType;
        }

        public static class SortTypeBean {
            /**
             * sort : 0
             * sortName : 全部
             */

            private int sort;
            private String sortName;

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getSortName() {
                return sortName;
            }

            public void setSortName(String sortName) {
                this.sortName = sortName;
            }
        }

        public static class KindTypeBean {
            /**
             * kind : 0
             * kindName : 小说
             */

            private int kind;
            private String kindName;

            public int getKind() {
                return kind;
            }

            public void setKind(int kind) {
                this.kind = kind;
            }

            public String getKindName() {
                return kindName;
            }

            public void setKindName(String kindName) {
                this.kindName = kindName;
            }
        }

        public static class FullTypeBean {
            /**
             * full :
             * fullName : 不限
             */

            private String full;
            private String fullName;

            public String getFull() {
                return full;
            }

            public void setFull(String full) {
                this.full = full;
            }

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }
        }

        public static class FreeTypeBean {
            /**
             * free :
             * freeName : 不限
             */

            private String free;
            private String freeName;

            public String getFree() {
                return free;
            }

            public void setFree(String free) {
                this.free = free;
            }

            public String getFreeName() {
                return freeName;
            }

            public void setFreeName(String freeName) {
                this.freeName = freeName;
            }
        }
    }
}
