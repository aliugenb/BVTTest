package com.xmly.pages.live.anchorliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:54 PM
 * 连麦功能
 */
public class CallPage extends AnchorRoomIndexPage {
    public CallPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_defaultCallIv")
    public MobileElement callBtn; //连麦按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_onMicNumTv")
    public MobileElement onCallNum; //左上角连麦状态（开启状态及人数）

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_openCallCb")
    public MobileElement openCallSwitch; //连麦开关

}
