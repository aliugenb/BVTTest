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
    public void checkMute() throws InterruptedException {
        createAnchorLiveRoom();
        anchorRoomIndexPage.enableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.disableMuteBtn),
                "CaseMute开启静音模式按钮文案变成静音");

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        DriverHelper.clickByCoordinates(driver, width / 2, height / 3);
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                "CaseMute开启静音模式出现静音icon");

        anchorRoomIndexPage.disableMute();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.enableMuteBtn),
                "CaseMute关闭静音模式按钮文案变成开麦");
        DriverHelper.clickByCoordinates(driver, width / 2, height / 3);
        assertHelper.assertTrue(!DriverHelper.isDisplayed(anchorRoomIndexPage.micOffIcon),
                "CaseMute关闭静音模式静音icon消失");
    }
}
