package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.live.anchorliveroompage.FriendPage;
import org.testng.annotations.Test;

import static com.xmly.common.DriverHelper.isDisplayed;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-01-31
 * Time: 11:14
 */
public class CaseFriend extends CaseHelper {
    private static FriendPage friendPage;

    @Test(description = "交友模式开启")
    public void enableFriendMode() throws InterruptedException {
        friendPage = new FriendPage(driver);
        createAnchorLiveRoom();
        anchorRoomIndexPage.gotoFriendPage();
        assertHelper.assertTrue(isDisplayed(friendPage.friendConfirmPopup),
                getCurClassName() + "点击开启弹出交友模式确认弹窗");

        friendPage.enableFriend();
        assertHelper.assertTrue(isDisplayed(friendPage.friendSeat),
                getCurClassName() + "交友模式开启并展示交友位置");
    }

    @Test(description = "锁定交友位置")
    public void lockSeat() {
        assertHelper.assertTrue(friendPage.getSeatLockBtnText().equals("锁定位置"),
                getCurClassName() + "点击位置弹出锁定文案");
        friendPage.seatLockBtn.click();
        assertHelper.assertTrue(friendPage.getSeatLockBtnText().equals("解锁位置"),
                getCurClassName() + "点击位置弹出解锁文案");
        friendPage.seatLockBtn.click();
    }

    @Test(description = "退出交友模式")
    public void exitFriendMode() {
        anchorRoomIndexPage.exitFriendMode();
        assertHelper.assertTrue(!isDisplayed(friendPage.friendSeat),
                getCurClassName() + "退出交友模式");
    }
}
