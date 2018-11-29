package com.xmly.pages.live;

import com.sun.xml.internal.rngom.parse.host.Base;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/26
 * Time: 8:40 PM
 */
public class RecorderPage extends BasePage {

    public RecorderPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"亲榜\")"),
            @AndroidBy(id = "com.ximalaya.ting.android.liveindex.application:id/live_home_anchor_rank_tv")})
    public MobileElement livrRecord;

}
