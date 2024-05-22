package com.asia.lottery.domain.strategy.repository;

import com.asia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.asia.lottery.infrastructure.po.Award;

import java.util.List;

public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId    策略 ID
     * @param award         奖品 ID
     * @return              扣减结果
     */
    boolean deductStock(Long strategyId, String award);
}
