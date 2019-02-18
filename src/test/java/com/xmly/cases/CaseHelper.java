package com.xmly.cases;

import org.openqa.selenium.NoSuchElementException;
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
    处理app首页弹窗
     */
    public static void appIndexInit() {
        basePage.allowPermission();
        basePage.closeUpdatePop();
        basePage.closeInterstitial();
    }

    /*
    跳转直播首页
     */
    public static void gotoLiveIndex() {
        appIndexInit();
        basePage.enter(basePage.LiveHomePage);
        liveIndexPage.endLive();
    }

    /*
    跳转发现页
     */
    public static void gotoFindIndex() {
        appIndexInit();
        basePage.enter(basePage.FindHomePage);
    }

    /*
    通过点击直播首页我要直播按钮登录
     */
    public static void login() {
        liveIndexPage.gotoCreateLiveRoomPage();
        try {
            if (loginPage.moreLoginBtn.isDisplayed()) {
                loginPage.onlineLogin();
            }
            liveIndexPage.gotoCreateLiveRoomPage();
        } catch (NoSuchElementException e) {
            System.out.println("登录成功");
        }
    }

    /*
    直播首页创建直播间
     */
    public static void createAnchorLiveRoom() throws InterruptedException {
        gotoLiveIndex();
        login();
        createLiveRoomPage.beginLiveBtn.click();
        TimeUnit.SECONDS.sleep(8);
        anchorRoomIndexPage.cancelShareBtn.click();
    }
}
