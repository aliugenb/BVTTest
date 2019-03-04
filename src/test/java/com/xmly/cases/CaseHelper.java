package com.xmly.cases;

import com.xmly.common.DriverHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:07 PM
 */

public class CaseHelper extends BaseCase {

    protected String curClassName = null;

    public String getCurClassName() {
        return getClass().getName();
    }

    /*
    跳转直播首页
     */
    public static void gotoLiveIndex() {
        basePage.appIndexInit();
        basePage.enterPage(basePage.LIVEHOMEPAGE);
        liveIndexPage.liveIndexInit();
    }

    /*
    跳转发现页
     */
    public static void gotoFindIndex() {
        basePage.appIndexInit();
        basePage.enterPage(basePage.FINDPAGE);
    }

    /*
    通过点击直播首页我要直播按钮登录
     */
    public static void login() {
        if (basePage.isLogin()) {
            return;
        }
        liveIndexPage.gotoCreateLiveRoomPage();
        sleep(2);

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
     * @Description: 直播间首页创建直播页
     * @Param []
     * @return void
     **/
    public static void createAnchorLiveRoom() throws InterruptedException {
        gotoLiveIndex();
        login();
        liveIndexPage.gotoCreateLiveRoomPage();
        createLiveRoomPage.createAnchorRoom();
        sleep(8);
        anchorRoomIndexPage.cancelShareBtn.click();
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        //首次创建直播间出现蒙层，点击6次后消失
        for (int i = 0; i < 6; i++) {
            DriverHelper.clickByCoordinates(driver, width / 2, height / 2);
            sleep(1);
        }
    }
}
