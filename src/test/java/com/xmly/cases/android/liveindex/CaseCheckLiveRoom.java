package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.pages.live.LiveIndexPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:56 PM
 * case编号：LiveIndex_04
 * 显示直播间
 */

public class CaseCheckLiveRoom extends AndroidBaseCase {
    @Test
    public void checkLiveRecord() {
        LiveIndexPage liveIndexPage = new LiveIndexPage(driver);
        liveIndexPage.isLiveRoomDisplayed();
    }
}
