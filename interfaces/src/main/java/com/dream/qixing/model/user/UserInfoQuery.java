package com.dream.qixing.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoQuery {
    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}