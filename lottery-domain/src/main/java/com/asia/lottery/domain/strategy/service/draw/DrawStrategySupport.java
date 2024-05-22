package com.asia.lottery.domain.strategy.service.draw;

import com.asia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.asia.lottery.domain.strategy.repository.IStrategyRepository;
import com.asia.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId    策略 ID
     * @return  策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品 ID
     * @return 中奖详情
     */
    protected Award queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }



}
