package com.dream.qixing.mobile.model.review;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Review implements Serializable {
    private Integer reviewId;

    private Integer userId;

    private String reviewContent;

    private Date reviewTime;

    private Integer replyCount;

    /**
     * 0:骑行报告评论 1：活动评论 2：自行车评论
     */
    private Integer reviewType;

    /**
     * review_type =0 该值是骑行报告的编码，以此类推
     */
    private Integer typeCode;
    
    private List<Replay> replays ;

    private static final long serialVersionUID = 1L;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent == null ? null : reviewContent.trim();
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getReviewType() {
        return reviewType;
    }

    public void setReviewType(Integer reviewType) {
        this.reviewType = reviewType;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    
    public List<Replay> getReplays() {
		return replays;
	}

	public void setReplays(List<Replay> replays) {
		this.replays = replays;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reviewId=").append(reviewId);
        sb.append(", userId=").append(userId);
        sb.append(", reviewContent=").append(reviewContent);
        sb.append(", reviewTime=").append(reviewTime);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", reviewType=").append(reviewType);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}