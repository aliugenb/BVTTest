package com.xmly.pages.live.userliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * ClassName: GiftPanelPage
 * Author: ye.liu
 * Date: 2019-02-25 13:57
 * Description:
 */
public class GiftPanelPage extends UserRoomIndexPage {
    public GiftPanelPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_tab_indicator_red_point")
    public List<MobileElement> tabList;
}
