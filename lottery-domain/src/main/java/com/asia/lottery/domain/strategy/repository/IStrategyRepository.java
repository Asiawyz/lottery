package com.asia.lottery.domain.strategy.repository;

import com.asia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.asia.lottery.infrastructure.po.Award;

public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);
}
