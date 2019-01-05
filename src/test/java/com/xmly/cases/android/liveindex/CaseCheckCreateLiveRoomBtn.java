package com.xmly.cases.android.liveindex;

import com.xmly.common.DriverHelper;
import com.xmly.common.MyException;
import com.xmly.cases.android.AndroidBaseCase;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 23:14
 * case编号：LiveIndex_02
 */

public class CaseCheckCreateLiveRoomBtn extends AndroidBaseCase {
    @Test
    public static void checkCreateLiveRoomBtn() throws InterruptedException, IOException, MyException {
        basePage.enter(basePage.LiveHomePage);
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(liveIndexPage.createLiveRoomBtn),
                "判断首页存在我要直播按钮", driver, "CaseCheckCreateLiveRoomBtn搜索框不存在");

        liveIndexPage.gotoCreateLiveRoomPage();
        try {
            if (loginPage.moreLoginBtn.isDisplayed()) {
                loginPage.onlineLogin();
            }
            liveIndexPage.gotoCreateLiveRoomPage();
            assertHelper.assertTrue(
                    DriverHelper.isDisplayed(createLiveRoomPage.beginLiveBtn),
                    "判断创建页面存在开始按钮", driver, "CaseCheckCreateLiveRoomBtn开始按钮不存在");
        } catch (NoSuchElementException e) {
        }
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(createLiveRoomPage.beginLiveBtn),
                "判断创建页面存在开始按钮", driver, "CaseCheckCreateLiveRoomBtn开始按钮不存在");
    }
}
