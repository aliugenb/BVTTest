package com.xmly.cases.anchorliveroom;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.FriendPage;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/9
 * Time: 8:01 PM
 * 主播端交友模式
 */
public abstract class Friend extends CaseHelper {
    private static FriendPage friendPage;

    public static void openFriendModel() throws InterruptedException {
        friendPage = new FriendPage(driver);

        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.gotoFriendPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(friendPage.friendConfirmPopup),
                "弹出交友模式确认弹窗", "Friend交友模式开启未弹出确认弹窗");

        friendPage.enableFriend();
        System.out.println(friendPage.getFriendSeatQty());
        assertHelper.assertTrue(friendPage.getFriendSeatQty() == 8,
                "判断开启8个交友位置", "Friend交友模式开启后没有8个交友位置");
    }


}
