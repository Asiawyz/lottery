package com.asia.lottery.domain.strategy.service.draw;

import com.asia.lottery.common.Constants;
import com.asia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.asia.lottery.domain.strategy.model.req.DrawReq;
import com.asia.lottery.domain.strategy.model.res.DrawResult;
import com.asia.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.asia.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.asia.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.asia.lottery.infrastructure.po.Award;
import com.asia.lottery.infrastructure.po.Strategy;
import com.asia.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{

    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        // 1. 获取抽奖策略
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();

        // 2. 校验抽奖策略是否已经初始化到内存
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        // 3. 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等
        List<String> excludeAwardIds = queryExcludeAwardIds(req.getStrategyId());

        // 4. 执行抽奖算法
        String awardId = drawAlgorithm(req.getStrategyId(), drawAlgorithmGroup.get(strategy.getStrategyMode()), excludeAwardIds);

        // 5. 包装中奖结果
        return buildDrawResult(req.getuId(), req.getStrategyId(), awardId);
    }

    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空，风控策略，临时调整等。
     * 这类业务是含有业务逻辑的，所以需要由具体的实现方法决定
     *
     * @param strategyId
     * @return
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 执行抽奖算法
     *
     * @param strategyId        抽奖策略 ID
     * @param drawAlgorithm     抽奖算法模型
     * @param excludeAwardIds   排除的抽奖 ID
     * @return  抽奖结果
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);

    /**
     * 校验抽奖策略是否已经初始化到内存
     *
     * @param strategyId            抽奖策略 ID
     * @param strategyMode          抽奖策略模式
     * @param strategyDetailList    抽奖策略详情
     */
    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {

        // 非单项概率，不必存入缓存
//        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
//            return;
//        }

        IDrawAlgorithm drawAlgorithm = drawAlgorithmGroup.get(strategyMode);

        // 已经初始化过的数据，不必重复初始化
        if (drawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }

        // 解析并初始化中奖概率数据到散列表
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);

    }

    /**
     * 包装抽奖结果
     * @param uId           用户 ID
     * @param strategyId    策略 ID
     * @param awardId       奖品 ID，null 情况：并发抽奖情况下，库存临界值 1 -> 0，会有用户中奖结果为 null
     * @return  中奖结果
     */
    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId) {
        if (null == awardId) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略 ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        Award award = strategyRepository.queryAwardInfo(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        logger.info("执行策略抽奖完成【已中奖】，用户：{} 策略 ID：{} 奖品 ID:{} 奖品名称：{}", uId, strategyId, awardId, award.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }


}
