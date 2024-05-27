package com.asia.lottery.domain.award.service.goods.impl;

import com.asia.lottery.common.Constants;
import com.asia.lottery.domain.award.model.req.GoodsReq;
import com.asia.lottery.domain.award.model.res.DistributionRes;
import com.asia.lottery.domain.award.service.goods.DistributionBase;
import com.asia.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description 优惠券商品
 */
@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {


    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        // 模拟调用优惠券发放接口
        logger.info("模拟调用发放优惠券发放接口 uId: {} awardContent: {}", req.getuId(), req.getAwardContent());
        updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(),
                Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.CouponGoods.getCode();
    }
}