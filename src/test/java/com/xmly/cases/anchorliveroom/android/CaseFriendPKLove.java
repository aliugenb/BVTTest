package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.live.anchorliveroompage.FriendPage;
import org.testng.annotations.Test;

import static com.xmly.common.DriverHelper.isDisplayed;
import static com.xmly.pages.BasePage.LIVEHOMEPAGE;
import static com.xmly.utils.CommonUtil.sleep;

/**
 * ClassName: CaseFriendPKLove
 * Author: ye.liu
 * Date: 2019-03-21 14:23
 * Description:交友模式心动时刻和团战模式
 */
public class CaseFriendPKLove extends CaseHelper {
    private static FriendPage friendPage;

    @Test(description = "开启心动模式")
    public void startLoveMode() {
        friendPage = new FriendPage(driver);
        createAnchorLiveRoom();
        anchorRoomIndexPage.gotoFriendPage();
        friendPage.enableFriend();

        friendPage.startLoveMode();
        assertHelper.assertTrue(isDisplayed(friendPage.startFriendLoveModeBtn),
                getCurClassName() + "不满足人数无法发起心动模式");
    }

    @Test(description = "开启团战PK模式")
    public void startFriendPkMode() {
        friendPage.startFriendPkMode();

        assertHelper.assertTrue(isDisplayed(friendPage.friendPkIcon),
                getCurClassName() + "PK模式开启");
        sleep(5);
        assertHelper.assertTrue(anchorRoomIndexPage.lastContent().getText().contains("主播已开启团战PK"),
                getCurClassName() + "系统消息提示开启团战");
    }

    @Test(description = "杀掉app重进直播间仍然在PK模式")
    public void isStillPkAfterRestart() {
        restartApp();
        appIndexInit();
        basePage.gotoPage(LIVEHOMEPAGE);
        sleep(10);
        liveIndexPage.gotoAnchorRoomByLivePop();
        anchorRoomIndexPage.anchroRoomInit();

        assertHelper.assertTrue(isDisplayed(friendPage.friendPkIcon),
                getCurClassName() + "杀掉app重进直播间仍然在PK模式");
    }

    @Test(description = "关闭团战PK模式")
    public void endFriendPkMode() {
        friendPage.endFriendPkMode();
        assertHelper.assertTrue(!isDisplayed(friendPage.friendPkIcon) && isDisplayed(friendPage.friendSeat),
                getCurClassName() + "关闭pk模式恢复到普通交友模式");
        sleep(5);
        assertHelper.assertTrue(anchorRoomIndexPage.lastContent().getText().contains("结束团战PK"),
                getCurClassName() + "系统消息提示结束团战");
    }
}
