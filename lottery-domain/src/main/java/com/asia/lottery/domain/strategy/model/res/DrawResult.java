package com.asia.lottery.domain.strategy.model.res;

import com.asia.lottery.common.Constants;
import com.asia.lottery.domain.strategy.model.vo.DrawAwardInfo;

public class DrawResult {

    /**
     * 用户 ID
     */
    private String uId;

    /**
     * 策略 ID
     */
    private Long strategyId;

    /**
     * 中奖状态：0 未中奖，1 已中奖，2 兜底奖 Constants.DrawState
     */
    private Integer drawState = Constants.DrawState.FAIL.getCode();

    /**
     * 中奖奖品信息
     */
    private DrawAwardInfo drawAwardInfo;

    public DrawResult(){}

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
