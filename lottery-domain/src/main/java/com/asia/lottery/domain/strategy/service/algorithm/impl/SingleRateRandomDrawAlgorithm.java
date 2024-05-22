package com.asia.lottery.domain.strategy.service.algorithm.impl;

import com.asia.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * 单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {


    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // 随机索引
        int random = generateSecureRandomIntCode(100);
        int idx = super.hashIdx(random);

        // 返回结果
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) {
            return null;
        }

        return awardId;
    }


}
