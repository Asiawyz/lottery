package com.asia.lottery.domain.strategy.repository.impl;

import com.asia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.asia.lottery.domain.strategy.repository.IStrategyRepository;
import com.asia.lottery.infrastructure.dao.IAwardDao;
import com.asia.lottery.infrastructure.dao.IStrategyDao;
import com.asia.lottery.infrastructure.dao.IStrategyDetailDao;
import com.asia.lottery.infrastructure.po.Award;
import com.asia.lottery.infrastructure.po.Strategy;
import com.asia.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
