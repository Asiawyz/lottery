package com.asia.lottery.domain.activity.service.deploy.impl;

import com.alibaba.fastjson.JSON;
import com.asia.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.asia.lottery.domain.activity.model.req.ActivityConfigReq;
import com.asia.lottery.domain.activity.model.vo.ActivityVO;
import com.asia.lottery.domain.activity.model.vo.AwardVO;
import com.asia.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.asia.lottery.domain.activity.model.vo.StrategyVO;
import com.asia.lottery.domain.activity.repository.IActivityRepository;
import com.asia.lottery.domain.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author asia
 * @version 1.0
 * @project lottery
 * @description 部署活动配置服务
 * @date 2024/5/24 14:05:46
 */
@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("创建活动配置开始，activityId: {}", req.getActivityId());

        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // 添加活动配置
            ActivityVO activityVO = activityConfigRich.getActivity();
            activityRepository.addActivity(activityVO);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("创建活动配置完成，activityId: {}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("创建活动配置失败，唯一索引冲突 activityId: {}, reqJson: {}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }


    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        // todo 非核心功能，后续补充
    }
}
