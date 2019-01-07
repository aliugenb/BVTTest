package com.xmly.cases;

import com.xmly.common.AssertHelper;
import com.xmly.common.MyException;
import com.xmly.driver.BaseDriver;
import com.xmly.pages.BasePage;
import com.xmly.pages.LoginPage;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;
import com.xmly.pages.live.anchorliveroompage.AnchorRoomIndexPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;

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
    protected static CreateLiveRoomPage createLiveRoomPage;
    protected static AnchorRoomIndexPage anchorRoomIndexPage;

    protected static AssertHelper assertHelper;

    @Parameters({"osDriver"})
    @BeforeClass
    public static void setUp(int osDriver) throws MyException {
        BaseDriver.setDriver(osDriver);
        driver = BaseDriver.getDriver();
        assertHelper = new AssertHelper();

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        liveIndexPage = new LiveIndexPage(driver);
        createLiveRoomPage = new CreateLiveRoomPage(driver);
        anchorRoomIndexPage = new AnchorRoomIndexPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
