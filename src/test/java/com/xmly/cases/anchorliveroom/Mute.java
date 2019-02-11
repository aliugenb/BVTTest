package com.xmly.cases.anchorliveroom;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-01-31
 * Time: 14:33
 * 主播端静音功能
 */
public abstract class Mute extends CaseHelper {

    public static void checkMute() throws InterruptedException {
        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.enableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.disableMuteBtn),
                "判断开启静音模式按钮文案变成静音", "Mute开启静音模式后按钮文案未变成静音");

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        DriverHelper.clickByCoordinates(driver, 2 / width, 2 / height);
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                "判断开启静音模式出现静音icon", "Mute开启静音模式未出现静音icon");

        anchorRoomIndexPage.disableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.enableMuteBtn),
                "判断关闭静音模式按钮文案变成开麦", "Mute关闭静音模式按钮文案未变成开麦");
        DriverHelper.clickByCoordinates(driver, 2 / width, 2 / height);
        assertHelper.assertTrue(!DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                "判断关闭静音模式静音icon消失", "Mute关闭静音模式静音icon未消失");
    }
}
