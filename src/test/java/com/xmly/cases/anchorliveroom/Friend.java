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
public class Friend extends CaseHelper {
    private static FriendPage friendPage;

    public static void openFriendModel() throws InterruptedException {
        friendPage = new FriendPage(driver);
        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.enableFriendModel();
        assertHelper.assertTrue(DriverHelper.isDisplayed(friendPage.friendConfirmPopup));
    }
}
