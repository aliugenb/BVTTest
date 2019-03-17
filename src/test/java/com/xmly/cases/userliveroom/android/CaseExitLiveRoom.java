package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import org.testng.Reporter;
import org.testng.annotations.Test;

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
        gotoUserLiveRoomAfterLogin("");
        TimeUnit.MINUTES.sleep(1);
        exitAnchorLiveRoom(userRoomIndexPage.getRoomType());
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.createLiveRoomBtn),
                getCurClassName() + "退出直播成功");
        Reporter.log("退出直播间成功");
    }

    @Test(description = "用户进入直播间10分钟后退出")
    public void exitMoreTenMin() throws InterruptedException {
        gotoLiveIndex();
        loginByClickLiveBtn();
        //进入未关注过主播的直播间
        while (true) {
            gotoUserLiveRoomByType("");
            if (!userRoomIndexPage.isFollow()) {
                Reporter.log("进入测试直播间");
                break;
            }
            exitAnchorLiveRoom(userRoomIndexPage.getRoomType());
            Swipe.swipeUp(driver);
        }
        TimeUnit.MINUTES.sleep(11);
        exitAnchorLiveRoom(userRoomIndexPage.getRoomType());


        liveIndexPage.gotoUserLiveRoomByBar();
        assertHelper.assertTrue(userRoomIndexPage.isFollow(),
                getCurClassName() + "退出直播间同时时关注主播成功");
        Reporter.log("退出直播间同时时关注主播成功");
    }
}
