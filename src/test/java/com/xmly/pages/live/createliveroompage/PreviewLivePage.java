package com.xmly.pages.live.createliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * ClassName: PreviewLivePage
 * Author: ye.liu
 * Date: 2019-03-19 23:32
 * Description:
 */

public class PreviewLivePage extends CreateLiveRoomPage {
    public PreviewLivePage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //发布预告按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_bottom_tv")
    public MobileElement createBtn;

    //开始时间
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_start_time_tv")
    public MobileElement startTime;

    //结束时间
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_end_time_tv")
    public MobileElement endTime;


    //直播时间
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_time_result_tv")
    public MobileElement liveTime;

    public String getStartTime() {
        return startTime.getText();
    }

    public String getEndime() {
        return endTime.getText();
    }
}
