package com.xmly.cases.android;

import com.xmly.action.ActionHelper;
import com.xmly.pages.BasePage;
import com.xmly.pages.live.AnchorLiveRoomPage;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;
import org.testng.Assert;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/29
 * Time: 3:48 PM
 */

public class CaseHelper extends AndroidBaseCase {

    public static final String LiveHomePage = "LiveIndex";
    public static final String FindHomePage = "FindIndex";

    public static void gotoLiveHomePage() {
        basePage.enter(LiveHomePage);
    }

    public static void gotoFindHomePage() {
        basePage.enter(FindHomePage);
    }

    //创建直播间
    public static void createLiveRoom() throws InterruptedException {
        gotoLiveHomePage();
        liveIndexPage.gotoCreateLiveRoomPage();
        createLiveRoomPage.BeginLiveBtn.click();
        ActionHelper.sleep(8000);
    }

    //主播端结束直播间
    public static void endAnchorLive() throws InterruptedException {
        anchorLiveRoomPage.exitLiveBtn.click();
        ActionHelper.sleep(1000);
        anchorLiveRoomPage.endLiveBtn.click();
    }
}
