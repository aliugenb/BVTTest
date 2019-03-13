package com.xmly.cases;

import com.xmly.common.DriverHelper;
import com.xmly.common.Status;
import com.xmly.common.SwipeDirection;
import com.xmly.pages.live.userliveroompage.RoomType;
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
        if (!DriverHelper.isDisplayed(basePage.homePageLiveTab)) {
            basePage.appIndexInit();
        }
        basePage.enterPage(basePage.LIVEHOMEPAGE);
        liveIndexPage.liveIndexInit();

        //关闭第一次安装出现的首充弹窗
        if (!Status.isInstall) {
            gotoUserLiveRoomByType("");
            userRoomIndexPage.closeFirstChargePop();
            userRoomIndexPage.exitLiveRoom(0);
        }
    }

    /*
    跳转发现页
     */
    public static void gotoFindIndex() {
        basePage.appIndexInit();
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
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        //首次创建直播间出现蒙层，点击6次后消失
        for (int i = 0; i < 6; i++) {
            DriverHelper.clickByCoordinates(driver, width / 2, height / 2);
            sleep(2);
        }
    }

    /*
     * @Description:用户端登录后进入直播间
     * @Param []
     * @return void
     **/
    public static void gotoUserLiveRoomAfterLogin() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        gotoUserLiveRoomByType("");
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
