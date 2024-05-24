package com.asia.lottery.infrastructure.dao;

import com.asia.lottery.infrastructure.po.Award;
import com.asia.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {

    /**
     * 查询策略配置
     * @param strategyId    策略 ID
     * @return              策略配置信息
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * 添加策略配置
     * @param req 策略配置
     */
    void insert(Strategy req);

}
