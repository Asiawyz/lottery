package com.asia.lottery.domain.activity.repository;

import com.asia.lottery.common.Constants;
import com.asia.lottery.domain.activity.model.vo.ActivityVO;
import com.asia.lottery.domain.activity.model.vo.AwardVO;
import com.asia.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.asia.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @author asia
 * @version 1.0
 * @project lottery
 * @description 活动仓库服务（活动表、奖品表、策略表、策略明细表）
 * @date 2024/5/24 09:16:59
 */
public interface IActivityRepository {

    /**
     * 添加活动配置
     * @param activity 活动配置
     */
    void addActivity(ActivityVO activity);

    /**
     * 添加奖品配置集合
     * @param awardList 奖品配置集合
     */
    void addAward(List<AwardVO> awardList);

    /**
     * 添加策略配置
     * @param strategy 策略配置
     */
    void addStrategy(StrategyVO strategy);

    /**
     * 添加策略明细配置
     * @param strategyDetailList    策略明细配置
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState);

}
