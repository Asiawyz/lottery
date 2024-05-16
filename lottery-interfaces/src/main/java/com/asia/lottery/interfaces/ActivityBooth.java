package com.asia.lottery.interfaces;

import com.asia.lottery.common.Constants;
import com.asia.lottery.common.Result;
import com.asia.lottery.infrastructure.dao.IActivityDao;
import com.asia.lottery.infrastructure.po.Activity;
import com.asia.lottery.rpc.IActivityBooth;
import com.asia.lottery.rpc.dto.ActivityDto;
import com.asia.lottery.rpc.req.ActivityReq;
import com.asia.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Service
public class ActivityBooth implements IActivityBooth {

    private Logger logger = LoggerFactory.getLogger(ActivityBooth.class);

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        logger.info("查询一次：{}", req.getActivityId());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
