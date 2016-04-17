package com.dream.qixing.control.action.qixing;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiField;

@ApiAction(value = "roadbook.add")
public class AddRoadBookAction extends BaseAction {

    private String traces;
    @ApiField("road_book_id")
    private Integer roadBookId;
    @Override
    public String execute() {
        if(traces == null){
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("数据格式不正确！");
            return "";
        }else{
            this.roadBookId = 10000;
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("添加路书成功！");
        }
        return "";
    }

    @Override
    public String getResponseName() {
        return null;
    }

    public String getTraces() {
        return traces;
    }

    public void setTraces(String traces) {
        this.traces = traces;
    }

    public Integer getRoadBookId() {
        return roadBookId;
    }

    public void setRoadBookId(Integer roadBookId) {
        this.roadBookId = roadBookId;
    }
}
