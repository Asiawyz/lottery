package com.asia.lottery.domain.support.ids;

/**
 * @author asia
 * @version 1.0
 * @project lottery
 * @description id 生成接口
 * @date 2024/5/27 09:55:53
 */
public interface IIdGenerator {

    /**
     * 获取 ID
     * 1. 雪花算法，用于生成单号
     * 2. 日期算法，用于生成活动编号类，特性是生成数字串较短，但指定时间内不能生成太多
     * 3. 随机算法，用于生成策略 ID
     *
     * @return ID
     */
    long nextId();


}


