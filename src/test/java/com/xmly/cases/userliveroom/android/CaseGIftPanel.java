package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.live.userliveroompage.GiftPanelPage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseGIftPanel
 * Author: ye.liu
 * Date: 2019-03-10 23:12
 * Description:
 */
public class CaseGIftPanel extends CaseHelper {
    private static GiftPanelPage giftPanelPage;

    @Test(description = "礼物面板点击各个tab")
    public void checkClickTab() {
        gotoUserLiveRoomAfterLogin();
        userRoomIndexPage.gotoGiftPanelPage();
        giftPanelPage = new GiftPanelPage(driver);

//        assertHelper.assertTrue();
    }
}
