package com.asia.lottery.rpc.res;

import com.asia.lottery.common.Result;
import com.asia.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * @author by asia
 * @Classname ActivityRes
 * @Description TODO
 * @Date 2024/5/16 23:52
 */
public class ActivityRes implements Serializable {

    private Result result;

    private ActivityDto activity;

    public ActivityRes() {

    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }
}
