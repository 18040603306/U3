package com.team.housebackapi.util;

public class PageParmeter {

    //定义分页的属性
    private Integer page=1;//页码
    private Integer pageSize=5;//页大小

    public PageParmeter() {
    }

    public PageParmeter(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
