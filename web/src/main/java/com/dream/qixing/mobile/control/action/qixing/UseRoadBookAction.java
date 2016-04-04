package com.dream.qixing.mobile.control.action.qixing;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;

@ApiAction(value = "roadbook.use")
public class UseRoadBookAction extends BaseAction {
    @ApiField("road_book_id")
    private Integer roadBookId;

    @Override
    public String execute() {
        if (roadBookId == null) {
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("数据库繁忙");
            return "";
        } else {
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("设置成功！");
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
}
