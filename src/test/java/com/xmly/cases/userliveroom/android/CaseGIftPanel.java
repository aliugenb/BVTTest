package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import com.xmly.pages.live.userliveroompage.GiftPanelPage;
import com.xmly.pages.live.userliveroompage.GiftTabType;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

/**
 * ClassName: CaseGIftPanel
 * Author: ye.liu
 * Date: 2019-03-10 23:12
 * Description:礼物面板测试
 */
public class CaseGIftPanel extends CaseHelper {
    private static GiftPanelPage giftPanelPage;

    @Test(description = "礼物面板点击各个tab")
    public void checkClickTab() {
        gotoUserLiveRoomAfterLogin("");
        userRoomIndexPage.gotoGiftPanelPage();
        giftPanelPage = new GiftPanelPage(driver);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.gift),
                getCurClassName() + "打开面板默认选中礼物tab");

        giftPanelPage.clickTabByType(GiftTabType.BAG);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.bag),
                getCurClassName() + "点击背包tab正常");

        giftPanelPage.clickTabByType(GiftTabType.GIFT);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.gift),
                getCurClassName() + "点击礼物tab正常");
//
        giftPanelPage.clickTabByType(GiftTabType.TREASURE);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.primaryTreasureBox),
                getCurClassName() + "点击宝箱tab正常");

        Point startPoint = DriverHelper.getCenter(giftPanelPage.supremacyTreasureBox);
        int xStart = startPoint.getX();
        int xEnd = DriverHelper.getCenter(giftPanelPage.primaryTreasureBox).getX();
        int y = startPoint.getY();

        Swipe.swipeByCoordinates(xStart, y, xEnd, y, driver);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.fansGift),
                getCurClassName() + "宝箱tab滑动至粉丝团tab正常");

        Swipe.swipeByCoordinates(xStart, y, xEnd, y, driver);
        assertHelper.assertTrue(DriverHelper.isDisplayed(giftPanelPage.nobleGift),
                getCurClassName() + "粉丝团tab滑动至贵族tab正常");
    }
}
