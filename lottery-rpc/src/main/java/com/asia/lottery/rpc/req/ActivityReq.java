package com.asia.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author by asia
 * @Classname ActivityReq
 * @Description TODO
 * @Date 2024/5/16 23:51
 */
public class ActivityReq implements Serializable {

    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
