package com.asia.lottery.domain.support.ids.policy;

import com.asia.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author asia
 * @version 1.0
 * @project lottery
 * @description 工具类生成随机 ID
 * @date 2024/5/27 10:32:44
 */
@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
