package com.zlkj.trainmonitor.bean;

public class Pagination {
    private int total;
    private int pageSize;
    private int currentPage;

    public Pagination(int total, int pageSize, int currentPage) {
        this.total = total;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
