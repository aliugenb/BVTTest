package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.otherpages.MyListenPage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveByMyListen
 * Author: ye.liu
 * Date: 2019-02-24 22:39
 * Description:
 */
public class CaseEnterLiveByMyListen extends CaseHelper {
    @Test(description = "通过我听页面进入直播间")
    public void enterByMyListen() {
        gotoMyListen();
        MyListenPage myListenPage = new MyListenPage(driver);
        myListenPage.enterLive();
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() != null,
                getCurClassName() + "我听页面进入直播间");
    }
}
