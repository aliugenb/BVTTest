package com.xmly.pages.otherpages;

import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/26
 * Time: 8:34 PM
 */

public class FindIndexPage extends BasePage {
    public FindIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //语音交友糖葫芦
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"语音交友\")")
    public MobileElement friendByVoice;

    //语音交友页面的直播间
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_item_record_cover")
    public MobileElement liveRoomInVoice;


    public void enterLiveRoom() {
        friendByVoice.click();
        liveRoomInVoice.click();
    }
}
