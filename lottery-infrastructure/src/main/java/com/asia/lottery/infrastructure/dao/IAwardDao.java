package com.asia.lottery.infrastructure.dao;

import com.asia.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAwardDao {

    /**
     * 查询奖品信息
     * @param awardId   奖品 ID
     * @return          奖品信息
     */
    Award queryAwardInfo(String awardId);

    /**
     * 添加奖品配置
     * @param awardList 奖品配置
     */
    void insertList(List<Award> awardList);

}
