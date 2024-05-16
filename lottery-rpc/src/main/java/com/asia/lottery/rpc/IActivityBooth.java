package com.asia.lottery.rpc;

import com.asia.lottery.rpc.req.ActivityReq;
import com.asia.lottery.rpc.res.ActivityRes;

/**
 * @author by asia
 * @Classname IActivityBooth
 * @Description TODO
 * @Date 2024/5/16 23:50
 */
public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq req);
}
