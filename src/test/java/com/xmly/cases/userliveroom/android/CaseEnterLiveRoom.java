package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.RoomType;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveRoom
 * Author: ye.liu
 * Date: 2019-02-23 15:56
 * Description:
 */
public class CaseEnterLiveRoom extends CaseHelper {
//    @Test(description = "进入普通房间")
//    public void enterCommonRoom() {
//        gotoLiveIndex();
//        liveIndexPage.gotoUserLiveRoomByType(RoomType.COMMON);
//        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.COMMON,
//                getCurClassName() + "已进入普通直播间");
//        assertHelper.assertTrue(DriverHelper.isDisplayed(userRoomIndexPage.pkStatus) && !DriverHelper.isDisplayed(userRoomIndexPage.requestBtn),
//                getCurClassName() + "普通房间无pk和交友模式按钮");
//        userRoomIndexPage.exitLiveRoom(0);
//    }

    @Test(description = "进入交友模式房间")
    public void enterFriendRoom() {
        gotoUserLiveRoomAfterLogin();
        gotoUserLiveRoomByType(RoomType.FRIEND);
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.FRIEND,
                getCurClassName() + "已进入交友模式直播间");
        userRoomIndexPage.exitNormalLiveRoom(0);
    }

    @Test(description = "进入PK模式房间", dependsOnMethods = {"enterFriendRoom"})
    public void enterPkRoom() {
        gotoUserLiveRoomByType(RoomType.PK);
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.PK,
                getCurClassName() + "已进入pk模式直播间");
        userRoomIndexPage.exitNormalLiveRoom(0);
    }

    @Test(description = "进入结束的直播间", dependsOnMethods = {"enterPkRoom"})
    public void enterEndRoom() {
        liveIndexPage.gotoLiveDynamicPage();
        liveDynamicPage.enterRoomByType(RoomType.END);
        assertHelper.assertTrue(DriverHelper.isDisplayed(userRoomIndexPage.appointmentLiveRoom),
                getCurClassName() + "进入预告直播间展示预告信息");
        userRoomIndexPage.exitAppointmentRoom();
    }

//    @Test
}
