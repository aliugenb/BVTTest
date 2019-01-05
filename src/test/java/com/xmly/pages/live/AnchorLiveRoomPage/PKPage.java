package com.xmly.pages.live.AnchorLiveRoomPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:54 PM
 */
public class PKPage extends AnchorRoomIndexPage {
    public PKPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_iv_pk")
    public MobileElement pkBtn; //pk按钮
}
