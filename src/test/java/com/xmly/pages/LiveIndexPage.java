package com.xmly.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/8
 * Time: 11:09 AM
 * 直播首页
 */
public class LiveIndexPage extends BasePage {

    public LiveIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"直播\")")
    WebElement LiveEnter;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search_bar_action")
    WebElement liveRoomSearchBar;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"亲密度周榜\")")
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_home_anchor_rank_tv")
    WebElement livrRecord;


    public void enterRecorder() {
        livrRecord.click();
    }
}
