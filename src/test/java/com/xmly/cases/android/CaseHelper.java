package com.xmly.cases.android;

import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:07 PM
 */
public class CaseHelper extends AndroidBaseCase {

    //跳转直播首页
    public static void gotoLiveIndex() {
        basePage.enter(basePage.LiveHomePage);
    }

    //跳转发现页
    public static void gotoFindIndex() {
        basePage.enter(basePage.FindHomePage);
    }

    //直播首页创建直播间
    public static void createAnchorLiveRoom() throws InterruptedException {
        gotoLiveIndex();
        liveIndexPage.gotoCreateLiveRoomPage();
        try {
            if (loginPage.moreLoginBtn.isDisplayed()) {
                loginPage.onlineLogin();
            }
            liveIndexPage.gotoCreateLiveRoomPage();
        } catch (NoSuchElementException e) {
            System.out.println("登录成功");
        }
        createLiveRoomPage.beginLiveBtn.click();
        TimeUnit.SECONDS.sleep(8);
        anchorRoomIndexPage.cancelShareBtn.click();
    }
}
