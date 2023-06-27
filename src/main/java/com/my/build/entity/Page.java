package com.my.build.entity;

import java.util.List;

public class Page<T> {
    private int currPage;
    private int totalPage;
    private int totalCount;
    private int pageSize;
    private int start;
    private Boolean hasNext;
    private Boolean hasPrevious;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    private List<T> list;

    public int getCurrPage() {
        return currPage;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
        this.start = (currPage - 1) * pageSize;
        this.hasPrevious = currPage > 1;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;

    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPage = this.totalCount % this.pageSize == 0 ?
                this.totalCount / this.pageSize :
                this.totalCount / this.pageSize + 1;
        this.hasNext = currPage < totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
