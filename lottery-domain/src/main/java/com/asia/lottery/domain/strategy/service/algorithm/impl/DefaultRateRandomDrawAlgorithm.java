package com.asia.lottery.domain.strategy.service.algorithm.impl;

import com.asia.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 必中中奖策略抽奖，排除掉已经中奖的概率，重新计算中奖逻辑
 */
@Component
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {


    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        return null;
    }
}
