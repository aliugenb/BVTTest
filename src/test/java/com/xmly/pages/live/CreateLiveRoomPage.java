package com.xmly.pages.live;

import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 8:09 PM
 * 创建直播页面
 */

public class CreateLiveRoomPage extends BasePage {
    public CreateLiveRoomPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id="com.ximalaya.ting.android.live.application:id/live_bottom_right_tv")
    public MobileElement beginLiveBtn; //开始直播按钮

    @AndroidFindBy(id="com.ximalaya.ting.android.live.application:id/live_bottom_left_tv")
    public MobileElement previewLiveBtn; //创建预告按钮

}
