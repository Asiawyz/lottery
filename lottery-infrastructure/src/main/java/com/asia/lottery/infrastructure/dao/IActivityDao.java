package com.asia.lottery.infrastructure.dao;

import com.asia.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IActivityDao {

    void insert(Activity activity);

    Activity queryActivityById(Long activityId);
}
