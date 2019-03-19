package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-01-31
 * Time: 15:47
 */
public class CaseMute extends CaseHelper {
    @Test(description = "检查静音功能正常")
    public void checkMute() {
        createAnchorLiveRoom();
        anchorRoomIndexPage.enableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.disableMuteBtn),
                getCurClassName() + "开启静音模式按钮文案变成静音");


        DriverHelper.clickByCoordinates(driver, deviceWidth / 2, deviceHeight / 3);
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                getCurClassName() + "开启静音模式出现静音icon");

        anchorRoomIndexPage.disableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.enableMuteBtn),
                getCurClassName() + "关闭静音模式按钮文案变成开麦");
        DriverHelper.clickByCoordinates(driver, deviceWidth / 2, deviceHeight / 3);
        assertHelper.assertTrue(!DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                getCurClassName() + "关闭静音模式静音icon消失");
    }
}
