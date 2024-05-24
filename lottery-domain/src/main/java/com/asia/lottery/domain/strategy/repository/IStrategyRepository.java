package com.asia.lottery.domain.strategy.repository;

import com.asia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.asia.lottery.domain.strategy.model.vo.AwardBriefVO;

import java.util.List;

public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    AwardBriefVO queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId    策略 ID
     * @param awardId         奖品 ID
     * @return              扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
