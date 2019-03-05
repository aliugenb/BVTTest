package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.userliveroompage.BulletType;
import com.xmly.pages.live.userliveroompage.UserSpeakPage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseBullet
 * Author: ye.liu
 * Date: 2019-02-26 14:25
 * Description:
 */
public class CaseBullet extends CaseHelper {
    private static UserSpeakPage userSpeakPage;

    @Test(description = "普通弹幕")
    public void checkCommonBullet() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoUserLiveRoomByType("");
        userRoomIndexPage.gotoUserSpeakPage();
        userSpeakPage = new UserSpeakPage(driver);

        userSpeakPage.switchBullet();
        assertHelper.assertTrue(userSpeakPage.getEditText().contains("发送直播间弹幕"),
                getCurClassName() + "弹幕开启并默认选中普通弹幕");

        userSpeakPage.switchBullet();
        assertHelper.assertTrue(!DriverHelper.isDisplayed(userSpeakPage.commonBullet),
                getCurClassName() + "关闭弹幕，收起弹幕类型一栏");

    }

    @Test(description = "粉丝弹幕", dependsOnMethods = {"checkCommonBullet"})
    public void checkFansBullet() {
        userSpeakPage.switchBullet();
        userSpeakPage.clickBulletByType(BulletType.FANS);

        userSpeakPage.joinFansClubBtn.click();
        userSpeakPage.joinBy.click();
//        assertHelper.assertTrue(DriverHelper.isDisplayed(userSpeakPage.joinBy),
//                "xxxx");
    }
}
