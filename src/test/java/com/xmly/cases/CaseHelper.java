package com.xmly.cases;

import com.xmly.common.DriverHelper;
import com.xmly.common.Status;
import com.xmly.common.SwipeDirection;
import com.xmly.pages.live.RoomType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import static com.xmly.common.FindElementHelper.findElementBySwipe;
import static com.xmly.utils.CommonUtil.sleep;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:07 PM
 */

public class CaseHelper extends BaseCase {

    final public static String USERNAME = "17602176634";
    final public static String PASSWD = "a123456";

    protected String curClassName = null;

    public String getCurClassName() {
        return getClass().getName();
    }

    /*
    跳转直播首页
     */
    public static void gotoLiveIndex() {
        sleep(10);
        appInit();
        basePage.enterPage(basePage.LIVEHOMEPAGE);
        if (!DriverHelper.isDisplayed(liveIndexPage.liveRoom)) {
            basePage.enterPage(basePage.LIVEHOMEPAGE);
        }
        liveIndexPage.liveIndexInit();
    }

    /*
     * @Description: 关闭首页各种弹窗，关闭直播间内首充弹窗
     * @Param []
     * @return void
     **/
    public static void appInit() {
        if (Status.isFristStart) {
            for (int i = 0; i < 3; i++) {
                //关闭权限弹层
                if (DriverHelper.isDisplayed(liveIndexPage.permissionAllowBtn)) {
                    liveIndexPage.permissionAllowBtn.click();
                }
                sleep(10);
                driver.closeApp();
                sleep(3);
                driver.launchApp();
                sleep(10);
            }

//            //关闭新人引导浮层
//            if (DriverHelper.isDisplayed(liveIndexPage.newerTips)) {
//                Dimension size = driver.manage().window().getSize();
//                int height = size.height;
//                int width = size.width;
//                DriverHelper.clickByCoordinates(driver, width / 2, height / 3);
//            }
        }
        //关闭广告弹窗
        if (DriverHelper.isDisplayed(liveIndexPage.closeInterstitialBtn)) {
            liveIndexPage.closeInterstitialBtn.click();
        }
        sleep(5);
        //关闭升级弹层
        if (DriverHelper.isDisplayed(liveIndexPage.updateBtn)) {
            liveIndexPage.updateBtn.click();
        }
        sleep(5);
        Status.isFristStart = false;
        Reporter.log("首页弹窗关闭，进入测试");
    }

    /*
    跳转发现页
     */
    public static void gotoFindIndex() {
        basePage.enterPage(basePage.FINDPAGE);
    }

    //出现登录页面后登录
    public static void loginByLoginPage() {
        loginPage.login(USERNAME, PASSWD);
        //登录成功后首页可能弹出正在直播提示
        sleep(3);
        liveIndexPage.liveIndexInit();
    }

    /*
    通过点击直播首页我要直播按钮登录
     */
    public static void loginByClickLiveBtn() {
        if (basePage.isLogin()) {
            return;
        }
        liveIndexPage.gotoCreateLiveRoomPage();
        sleep(2);

        try {
            if (loginPage.moreLoginBtn.isDisplayed()) {
                loginByLoginPage();
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
    public static void createAnchorLiveRoom() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();
        createLiveRoomPage.createAnchorRoom();
        sleep(10);
        anchorRoomIndexPage.cancelShareBtn.click();

        if (Status.isFirstCreateRoom) {
            Dimension size = driver.manage().window().getSize();
            int width = size.width;
            int height = size.height;
            //首次创建直播间出现蒙层，点击6次后消失
            for (int i = 0; i < 6; i++) {
                DriverHelper.clickByCoordinates(driver, width / 2, height / 2);
                sleep(2);
            }
            Status.isFirstCreateRoom = false;
        }
    }

    /*
     * @Description:用户端登录后进入指定直播间
     * @Param []
     * @return void
     **/
    public static void gotoUserLiveRoomAfterLogin(String roomType) {
        gotoLiveIndex();
        loginByClickLiveBtn();
        gotoUserLiveRoomByType(roomType);
    }

    /*
     * Description:根据roomType跳转不同类型的直播间
     * Param [roomType] 房间类型，为空时默认打开第一个
     * return void
     **/
    public static void gotoUserLiveRoomByType(String roomType) {
        if (roomType == null || roomType.equals("")) {
            liveIndexPage.liveRoom.click();
        } else if (roomType.equals(RoomType.FRIEND)) {
            findElementBySwipe(driver, liveIndexPage.friendRoom, 10, SwipeDirection.UP).click();
        } else if (roomType.equals(RoomType.PK)) {
            findElementBySwipe(driver, liveIndexPage.pkRoom, 10, SwipeDirection.UP).click();
        }
        userRoomIndexPage.closeFirstChargePop();
    }

    /*
     * @Description: 关闭webview
     * @Param []
     * @return void
     **/
    public static void closeWebView() {
        if (DriverHelper.isDisplayed(userRoomIndexPage.closeWebviewBtn)) {
            userRoomIndexPage.closeWebviewBtn.click();
        }
    }
}
