package com.xmly.cases.android;

import com.xmly.action.MyException;
import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.pages.BasePage;
import com.xmly.pages.live.AnchorLiveRoomPage;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;
import com.xmly.utils.AppiumServer;
import com.xmly.utils.FilesInit;
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
        if (!AppiumServer.startAppium()) {
            throw new MyException("appium未启动");
        }

        AndroidBaseDriver.init();
        FilesInit.filesInit();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    SnapshotAndLog.logByAdb(FilesInit.logDirPath);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
        basePage = new BasePage(driver);
        liveIndexPage = new LiveIndexPage(driver);
        createLiveRoomPage = new CreateLiveRoomPage(driver);
        anchorLiveRoomPage = new AnchorLiveRoomPage(driver);
    }

    @AfterTest
    public static void tearDown() throws Exception {
        driver.quit();
//        System.out.println(FilesInit.logDirPath);
//        SnapshotAndLog.logByAdb(FilesInit.logDirPath);
        AppiumServer.stopAppium();

//        Files.move(preTestNGReportPath, tarTestNGReportPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
