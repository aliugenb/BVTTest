package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import com.xmly.pages.live.userliveroompage.GiftPanelPage;
import com.xmly.pages.live.userliveroompage.GiftTabType;
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
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.gift),
                getCurClassName() + "打开面板默认选中礼物tab");

        giftPanelPage.clickTabByType(GiftTabType.BAG);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.bag),
                getCurClassName() + "打开背包tab正常");

        giftPanelPage.clickTabByType(GiftTabType.GIFT);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.gift),
                getCurClassName() + "打开礼物tab正常");

        giftPanelPage.clickTabByType(GiftTabType.TREASURE);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.treasureBox),
                getCurClassName() + "打开宝箱tab正常");

        giftPanelPage.clickTabByType(GiftTabType.FANS);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.fansGift),
                getCurClassName() + "打开粉丝团tab正常");

        giftPanelPage.clickTabByType(GiftTabType.NOBLE);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.nobleGift),
                getCurClassName() + "打开贵族tab正常");

        Swipe.swipeRight(driver);
    }
}
