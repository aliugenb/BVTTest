package com.xmly.cases;

import com.xmly.utils.CommonUtil;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:07 PM
 */

public class CaseHelper extends BaseCase {

    /*
    跳转直播首页
     */
    public static void gotoLiveIndex() {
        basePage.appIndexInit();
        basePage.enter(basePage.LIVEHOMEPAGE);
        liveIndexPage.endLive();
    }

    /*
    跳转发现页
     */
    public static void gotoFindIndex() {
        basePage.appIndexInit();
        basePage.enter(basePage.FINDPAGE);
    }

    /*
    通过点击直播首页我要直播按钮登录
     */
    public static void login() {
        if (basePage.isLogin()) {
            return;
        }
        liveIndexPage.gotoCreateLiveRoomPage();
        CommonUtil.sleep(2);

        try {
            if (loginPage.moreLoginBtn.isDisplayed()) {
                loginPage.onlineLogin();
            }
        } catch (NoSuchElementException e) {
            if (createLiveRoomPage.beginLiveBtn.isDisplayed()) {
                createLiveRoomPage.cancelCreate();
            }
        } finally {
            if (liveIndexPage.createLiveRoomBtn.isDisplayed()) {
                Reporter.log("登录成功");
            }
        }
    }

    /*
    直播首页创建直播间
     */
    public static void createAnchorLiveRoom() throws InterruptedException {
        gotoLiveIndex();
        login();
        liveIndexPage.gotoCreateLiveRoomPage();
        createLiveRoomPage.beginLiveBtn.click();
        TimeUnit.SECONDS.sleep(8);
        anchorRoomIndexPage.cancelShareBtn.click();
    }
}
