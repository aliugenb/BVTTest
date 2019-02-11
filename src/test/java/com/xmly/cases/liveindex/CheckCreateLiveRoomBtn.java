package com.xmly.cases.liveindex;

import com.xmly.cases.BaseCase;
import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.MyException;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 4:44 PM
 */
public abstract class CheckCreateLiveRoomBtn extends CaseHelper {

    public static void checkCreateLiveRoomBtn() throws InterruptedException, IOException, MyException {
        CaseHelper.gotoLiveIndex();
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(liveIndexPage.createLiveRoomBtn),
                "判断首页存在我要直播按钮", "CheckCreateLiveRoomBtn搜索框不存在");

        liveIndexPage.gotoCreateLiveRoomPage();
        try {
            if (loginPage.moreLoginBtn.isDisplayed()) {
                loginPage.onlineLogin();
            }
            liveIndexPage.gotoCreateLiveRoomPage();
            assertHelper.assertTrue(
                    DriverHelper.isDisplayed(createLiveRoomPage.beginLiveBtn),
                    "判断创建页面存在开始按钮", "CheckCreateLiveRoomBtn开始按钮不存在");
        } catch (NoSuchElementException e) {
        }
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(createLiveRoomPage.beginLiveBtn),
                "判断创建页面存在开始按钮", "CheckCreateLiveRoomBtn开始按钮不存在");
    }
}
