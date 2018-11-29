package com.xmly.cases.android;

import com.xmly.pages.BasePage;
import com.xmly.pages.live.AnchorLiveRoomPage;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/29
 * Time: 3:48 PM
 */
public class CaseHelper extends AndroidBaseCase {

    public static final String LiveHomePage = "LiveIndex";
    public static final String FindHomePage = "FindIndex";

    protected static BasePage basePage;
    protected static LiveIndexPage liveIndexPage;
    protected static CreateLiveRoomPage createLiveRoomPage;
    protected static AnchorLiveRoomPage anchorLiveRoomPage;

    {
        basePage = new BasePage(driver);
        liveIndexPage = new LiveIndexPage(driver);
        createLiveRoomPage = new CreateLiveRoomPage(driver);
        anchorLiveRoomPage = new AnchorLiveRoomPage(driver);
    }

    public static void gotoLiveHomePage() {
        basePage.enter(LiveHomePage);
    }

    public static void gotoFindHomePage() {
        basePage.enter(FindHomePage);
    }

    public static void createLiveRoom() {
        gotoLiveHomePage();
        liveIndexPage.gotoCreateLiveRoomPage();
        createLiveRoomPage.BeginLive();
    }

    public static void endAnchorLive() throws InterruptedException {
        anchorLiveRoomPage.endLive();
    }
}
