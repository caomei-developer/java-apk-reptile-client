package com.charles.data.chuai.category.bean;

import com.charles.data.chuai.Response;

import java.util.List;

public class BookCategoryListBean extends Response  {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean  {
        private int bookId;
        private String bookName;
        private String bookImg;
        private String bookIntro;
        private String author;
        private List<String> bookLabel;

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getBookImg() {
            return bookImg;
        }

        public void setBookImg(String bookImg) {
            this.bookImg = bookImg;
        }

        public String getBookIntro() {
            return bookIntro;
        }

        public void setBookIntro(String bookIntro) {
            this.bookIntro = bookIntro;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public List<String> getBookLabel() {
            return bookLabel;
        }

        public void setBookLabel(List<String> bookLabel) {
            this.bookLabel = bookLabel;
        }
    }
}
