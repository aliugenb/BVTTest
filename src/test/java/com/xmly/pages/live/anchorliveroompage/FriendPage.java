package com.xmly.pages.live.anchorliveroompage;

import com.xmly.common.AssertHelper;
import com.xmly.common.DriverHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-01-31
 * Time: 16:53
 * 交友模式
 */
public class FriendPage extends AnchorRoomIndexPage {
    public FriendPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //交友模式麦位
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_seat_name_tv")
    public MobileElement friendSeat;

    //交友模式开启确认弹窗
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_dialog_center_btn")
    public MobileElement friendConfirmPopup;

    //锁定位置按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_operation_desc_tv")
    public MobileElement seatLockBtn;

    //交友模式设置入口
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_ll_chat_chairs_waiting")
    public MobileElement friendSettingEnter;

    //玩法设置
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"玩法设置\")")
    public MobileElement friendSettingsBtn;

    //心动模式
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_friends_love_moment_mode")
    public MobileElement friendLoveMode;

    //开启心动模式
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_heart_moment_start")
    public MobileElement startFriendLoveModeBtn;

    //团战pk模式
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_friends_pk_mode")
    public MobileElement friendPkMode;

    //开启团战pk模式
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_open_friends_pk_tv")
    public MobileElement startFriendPkBtn;

    //团战PK Vs icon
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_friends_pk")
    public MobileElement friendPkIcon;

    //关闭团战PK模式
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_close_friends_pk_tv")
    public MobileElement endFriendPkBtn;

    //关闭确认按钮
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"确定\")")
    public MobileElement okBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_friends_pk_result_top_iv")
    public MobileElement friendPkResultPop;


    //开启交友模式
    public void enableFriend() {
        friendConfirmPopup.click();
    }

    /*
     * Description：点击锁定按钮并返回文案
     * Param []
     * return java.lang.String
     **/
    public String getSeatLockBtnText() {
        friendSeat.click();
        return seatLockBtn.getText();
    }

    public void startLoveMode() {
        DriverHelper.clickByPossibleElement(friendSettingEnter);
        friendSettingsBtn.click();
        friendLoveMode.click();
        startFriendLoveModeBtn.click();
    }

    public void startFriendPkMode() {
        DriverHelper.clickByPossibleElement(friendSettingEnter);
        friendSettingsBtn.click();
        friendPkMode.click();
        startFriendPkBtn.click();
    }

    public void endFriendPkMode() {
        friendSettingEnter.click();
        friendSettingsBtn.click();
        friendPkMode.click();
        endFriendPkBtn.click();
        okBtn.click();
        AssertHelper.assertTrue(DriverHelper.isDisplayed(friendPkResultPop),"交友团战PK结果弹窗");
        okBtn.click();
    }
}
