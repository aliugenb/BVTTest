package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import com.xmly.driver.Driver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: CaseExitLiveRoom
 * Author: ye.liu
 * Date: 2019-02-18 17:33
 * Description:
 */

public class CaseExitLiveRoom extends CaseHelper {

    @Test(description = "用户进入直播间1分钟后退出")
    public void exitLessTenMin() throws InterruptedException {
        gotoLiveIndex();
        login();
        liveIndexPage.gotoUserLiveRoomByType("");
        TimeUnit.MINUTES.sleep(1);
        userRoomIndexPage.closeFirstChargePop();
        userRoomIndexPage.exitLiveRoom(1);
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.createLiveRoomBtn),
                "退出直播成功", "CaseExitLiveRoom退出直播间失败");
        Reporter.log("退出直播间成功");
    }

    @Test(description = "用户进入直播间10分钟后退出")
    public void exitMoreTenMin() throws InterruptedException {
        gotoLiveIndex();
        login();
        //进入未关注过主播的直播间
        while (true) {
            liveIndexPage.gotoUserLiveRoomByType("");
            if (!userRoomIndexPage.isFollow()) {
                Reporter.log("进入测试直播间");
                break;
            }
            userRoomIndexPage.exitLiveRoom(0);
            Swipe.SwipeUp(driver);
        }
        userRoomIndexPage.closeFirstChargePop();
        TimeUnit.MINUTES.sleep(11);
        userRoomIndexPage.exitLiveRoom(11);
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.createLiveRoomBtn),
                "退出直播间成功", "CaseExitLiveRoom退出直播间失败");

        liveIndexPage.gotoUserLiveRoomByBar();
        assertHelper.assertTrue(userRoomIndexPage.isFollow(),
                "关注主播成功", "CaseExitLiveRoom关注主播失败");
        Reporter.log("退出直播间同时时关注主播成功");
    }
}
