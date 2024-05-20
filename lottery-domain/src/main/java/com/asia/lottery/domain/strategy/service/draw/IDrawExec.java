package com.asia.lottery.domain.strategy.service.draw;

import com.asia.lottery.domain.strategy.model.req.DrawReq;
import com.asia.lottery.domain.strategy.model.res.DrawResult;

public interface IDrawExec {

    DrawResult doDrawExec(DrawReq req);

}
