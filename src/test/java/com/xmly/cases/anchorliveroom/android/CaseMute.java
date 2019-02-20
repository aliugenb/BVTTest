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
    public static void checkMute() throws InterruptedException {
        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.enableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.disableMuteBtn),
                "判断开启静音模式按钮文案变成静音", "Mute开启静音模式后按钮文案未变成静音");

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        DriverHelper.pressByCoordinates(driver, width / 2, height / 3);
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                "判断开启静音模式出现静音icon", "Mute开启静音模式未出现静音icon");

        anchorRoomIndexPage.disableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.enableMuteBtn),
                "判断关闭静音模式按钮文案变成开麦", "Mute关闭静音模式按钮文案未变成开麦");
        DriverHelper.pressByCoordinates(driver, width / 2, height / 3);
        assertHelper.assertTrue(!DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                "判断关闭静音模式静音icon消失", "Mute关闭静音模式静音icon未消失");
    }
}
