package com.asia.lottery.domain.strategy.model.res;

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
     * 奖品 ID
     */
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;

    public DrawResult(){}

    public DrawResult(String uId, Long strategyId, String rewardId, String awardName) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.rewardId = rewardId;
        this.awardName = awardName;
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

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
