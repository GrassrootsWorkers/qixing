package com.dream.qixing.mobile.control.action.qixing;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.qixing.RoadBook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiAction(value = "roadbook.list")
public class QueryRoadBookListAction extends BaseAction {

    @ApiListField("books")
    @ApiField("book")
    private List<RoadBook> roadBookList;

    @Override
    public String execute() {
        if (this.getUserId() == 0) {
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("数据不存在！");
            return "";
        }
        roadBookList = new ArrayList<RoadBook>();
        RoadBook book = new RoadBook();
        book.setRoadBookId(1000);
        book.setCreateTime(new Date());
        book.setName("昌平骑行");
        book.setRoadName("南邵--> 昌平-->十三陵");
        book.setStatusName("使用");
        book.setStatus(1);
        book.setMileage(100);
        roadBookList.add(book);
        RoadBook book1 = new RoadBook();
        book1.setRoadBookId(1000);
        book1.setCreateTime(new Date());
        book1.setName("昌平骑行");
        book1.setRoadName("南邵--> 昌平-->十三陵");
        book1.setStatusName("未使用");
        book1.setStatus(0);
        book1.setMileage(100);
        roadBookList.add(book1);
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("查询成功！");
        return "";
    }

    @Override
    public String getResponseName() {
        return null;
    }

}
