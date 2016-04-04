package com.dream.qixing.mobile.control.action.qixing;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.qixing.RoadBook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiAction(value = "roadbook.detail")
public class QueryRoadBookDetailAction extends BaseAction {

    private Integer roadBookId;
    @ApiField("book")
   private RoadBook book;
    @Override
    public String execute() {
       if(roadBookId !=null){
           book = new RoadBook();
           book.setRoadBookId(roadBookId);
           book.setCreateTime(new Date());
           book.setName("昌平骑行");
           book.setRoadName("南邵--> 昌平-->十三陵");
           book.setStatusName("使用");
           book.setStatus(1);
           book.setMileage(100);
           book.setTraces("name:lon:lat;name:lon:lat");
           this.setIsSuccessful(true);
           this.setStatusCode(200);
           this.setDescription("查询成功！");
           return "";
       }else{
           this.setIsSuccessful(false);
           this.setStatusCode(400);
           this.setDescription("数据不存在！");
           return "";
       }

    }

    @Override
    public String getResponseName() {
        return null;
    }

    public Integer getRoadBookId() {
        return roadBookId;
    }

    public void setRoadBookId(Integer roadBookId) {
        this.roadBookId = roadBookId;
    }

    public RoadBook getBook() {
        return book;
    }

    public void setBook(RoadBook book) {
        this.book = book;
    }
}
