package com.xmly.cases;

import com.xmly.common.AssertHelper;
import com.xmly.common.MyException;
import com.xmly.driver.BaseDriver;
import com.xmly.pages.BasePage;
import com.xmly.pages.LoginPage;
import com.xmly.pages.live.createliveroompage.CreateLiveRoomPage;
import com.xmly.pages.live.liveindexpage.LiveDynamicPage;
import com.xmly.pages.live.liveindexpage.LiveIndexPage;
import com.xmly.pages.live.anchorliveroompage.AnchorRoomIndexPage;
import com.xmly.pages.live.userliveroompage.UserRoomIndexPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 4:07 PM
 */

public class BaseCase {
    protected static AppiumDriver<? extends MobileElement> driver;

    protected static BasePage basePage;
    protected static LoginPage loginPage;
    protected static LiveIndexPage liveIndexPage;
    protected static LiveDynamicPage liveDynamicPage;
    protected static CreateLiveRoomPage createLiveRoomPage;
    protected static AnchorRoomIndexPage anchorRoomIndexPage;
    protected static UserRoomIndexPage userRoomIndexPage;

    protected static AssertHelper assertHelper;

    protected static int deviceWidth;
    protected static int deviceHeight;

    @Parameters({"osDriver"})
    @BeforeClass
    public static void setUp(int osDriver) throws MyException, IOException {
        BaseDriver.setDriver(osDriver);
        driver = BaseDriver.getDriver();
        assertHelper = new AssertHelper();

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        liveIndexPage = new LiveIndexPage(driver);
        liveDynamicPage = new LiveDynamicPage(driver);
        createLiveRoomPage = new CreateLiveRoomPage(driver);
        anchorRoomIndexPage = new AnchorRoomIndexPage(driver);
        userRoomIndexPage = new UserRoomIndexPage(driver);

        deviceWidth = driver.manage().window().getSize().width;
        deviceHeight = driver.manage().window().getSize().height;
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
