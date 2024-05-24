package com.asia.lottery.domain.activity.service.stateflow;

import com.asia.lottery.common.Constants;
import com.asia.lottery.common.Result;

/**
 * @author asia
 * @version 1.0
 * @project lottery
 * @description 状态处理接口
 * @date 2024/5/24 14:38:04
 */
public interface IStateHandler {

    /**
     * 提审
     * @param activityId        活动 ID
     * @param currentStatus     当前状态
     * @return                  审核结果
     */
    Result arraignment(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 审核通过
     * @param activityId        活动 ID
     * @param currentStatus     当前状态
     * @return                  审核结果
     */
    Result checkPass(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 审核拒绝
     * @param activityId        活动 ID
     * @param currentStatus     当前状态
     * @return                  审核结果
     */
    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 关闭
     * @param activityId        活动 ID
     * @param currentStatus     当前状态
     * @return                  审核结果
     */
    Result close(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 开启
     * @param activityId        活动 ID
     * @param currentStatus     当前状态
     * @return                  审核结果
     */
    Result open(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * 运行活动中
     * @param activityId        活动 ID
     * @param currentStatus     当前状态
     * @return                  审核结果
     */
    Result doing(Long activityId, Enum<Constants.ActivityState> currentStatus);
}
