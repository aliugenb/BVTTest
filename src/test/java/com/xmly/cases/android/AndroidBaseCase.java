package com.xmly.cases.android;

import com.xmly.common.AssertHelper;
import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.pages.BasePage;
import com.xmly.pages.LoginPage;
import com.xmly.pages.live.AnchorLiveRoomPage.AnchorRoomIndexPage;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;
import com.xmly.utils.AppiumServer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/26
 * Time: 4:27 PM
 */

public class AndroidBaseCase extends AndroidBaseDriver {

    protected static BasePage basePage;
    protected static LoginPage loginPage;
    protected static LiveIndexPage liveIndexPage;
    protected static CreateLiveRoomPage createLiveRoomPage;
    protected static AnchorRoomIndexPage anchorRoomIndexPage;

    protected static AssertHelper assertHelper;

    @BeforeTest
    public static void setUp() throws Exception {
        assertHelper = new AssertHelper();

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        liveIndexPage = new LiveIndexPage(driver);
        createLiveRoomPage = new CreateLiveRoomPage(driver);
        anchorRoomIndexPage = new AnchorRoomIndexPage(driver);
    }

    @AfterTest
    public static void tearDown() throws Exception {
        driver.quit();
//        SnapshotAndLog.logByAdb(FilesInit.logDirPath);
        AppiumServer.stopAppium();
    }
}
