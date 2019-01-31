package com.xmly.cases.anchorliveroom;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.FriendPage;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/9
 * Time: 8:01 PM
 */
public abstract class Friend extends CaseHelper {
    public static void openFriendModel() throws InterruptedException {
        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.gotoFriendPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.friendConfirmPopup),
                "弹出交友模式确认弹窗", "交友模式开启未弹出确认弹窗");

        anchorRoomIndexPage.enableFriend();
        System.out.println("========================");
        System.out.println(anchorRoomIndexPage.getFriendSeatQty());
        assertHelper.assertTrue(anchorRoomIndexPage.getFriendSeatQty() == 8,
                "判断开启8个交友位置", "没有8个交友位置");
    }


}
