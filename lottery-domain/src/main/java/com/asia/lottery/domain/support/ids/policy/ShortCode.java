package com.asia.lottery.domain.support.ids.policy;

import com.asia.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @author asia
 * @version 1.0
 * @project lottery
 * @description 短码生成策略，仅支持很小的调用量，用于生成活动配置类编号，保证全局唯一
 * @date 2024/5/27 10:38:55
 */
@Component
public class ShortCode implements IIdGenerator {

    @Override
    public long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数
        String idStr = String.valueOf(year - 2020) +
                hour +
                String.format("%02d", week) +
                day +
                String.format("%03d", new Random().nextInt(1000));

        return Long.parseLong(idStr);
    }
}
