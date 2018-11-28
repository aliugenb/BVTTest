package com.xmly.cases.android.liveroom;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.pages.live.CreateLiveRoomPage;
import com.xmly.pages.live.LiveIndexPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 22:34
 */

public class CreatLiveRoom extends AndroidBaseCase {
    @Test
    public void create() {
        LiveIndexPage liveIndexPage = new LiveIndexPage(driver);
        liveIndexPage.createLiveRoom();
        CreateLiveRoomPage createLiveRoomPage = new CreateLiveRoomPage(driver);
        createLiveRoomPage.BeginLive();
    }
}
