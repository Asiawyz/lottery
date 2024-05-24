package com.asia.lottery.domain.activity.service.deploy;

import com.asia.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @author asia
 * @version 1.0
 * @project lottery
 * @description 活动部署配置接口
 * @date 2024/5/24 14:04:12
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);

}
