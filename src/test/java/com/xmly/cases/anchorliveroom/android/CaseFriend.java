package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.FriendPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-01-31
 * Time: 11:14
 */
public class CaseFriend extends CaseHelper {
    private FriendPage friendPage;

    @Test(description = "交友模式开启")
    public void openFriendModel() throws InterruptedException {
        friendPage = new FriendPage(driver);

        createAnchorLiveRoom();
        anchorRoomIndexPage.gotoFriendPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(friendPage.friendConfirmPopup),
                "CaseFriend点击开启弹出交友模式确认弹窗");

        friendPage.enableFriend();
        System.out.println(friendPage.getFriendSeatQty());
        assertHelper.assertTrue(friendPage.getFriendSeatQty() == 8,
                "CaseFriend交友模式8个交友位置");
    }
}
