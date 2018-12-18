package com.xmly.cases.android;

import com.xmly.Run;
import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.pages.BasePage;
import com.xmly.pages.live.AnchorLiveRoomPage;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;
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
    protected static LiveIndexPage liveIndexPage;
    protected static CreateLiveRoomPage createLiveRoomPage;
    protected static AnchorLiveRoomPage anchorLiveRoomPage;

    @BeforeTest
    public static void setUp() throws Exception {
//        if (stopAppium()) {
//            startAppium();
//        }

        AndroidBaseDriver.init();
        Run.init();

        basePage = new BasePage(driver);
        liveIndexPage = new LiveIndexPage(driver);
        createLiveRoomPage = new CreateLiveRoomPage(driver);
        anchorLiveRoomPage = new AnchorLiveRoomPage(driver);
    }

    @AfterTest
    public static void tearDown() throws Exception {
        driver.quit();
//        stopAppium();
//        Files.move(preTestNGReportPath, tarTestNGReportPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
