package com.asia.lottery.domain.strategy.service.draw;

import com.asia.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.Resource;

public class DrawConfig {

    @Resource
    private IDrawAlgorithm drawAlgorithm;
}
