package com.xmly.cases.android;

import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.pages.BasePage;
import com.xmly.pages.live.AnchorLiveRoomPage;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/26
 * Time: 4:27 PM
 */

public class AndroidBaseCase {
    public static AppiumDriver<? extends MobileElement> driver;

    protected static BasePage basePage;
    protected static LiveIndexPage liveIndexPage;
    protected static CreateLiveRoomPage createLiveRoomPage;
    protected static AnchorLiveRoomPage anchorLiveRoomPage;

    @BeforeTest
    public static void setUp() throws Exception {
        driver = new AndroidBaseDriver().getDriver();

        basePage = new BasePage(driver);
        liveIndexPage = new LiveIndexPage(driver);
        createLiveRoomPage = new CreateLiveRoomPage(driver);
        anchorLiveRoomPage = new AnchorLiveRoomPage(driver);
    }

    @AfterTest
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
