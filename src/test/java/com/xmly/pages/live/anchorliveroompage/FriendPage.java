package com.xmly.pages.live.anchorliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

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

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_seat_name_tv")
    public List<MobileElement> friendSeats; //交友模式位置

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_dialog_center_btn")
    public MobileElement friendConfirmPopup; //交友模式开启确认弹窗

    //锁定位置按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_operation_desc_tv")
    public MobileElement seatLockBtn;

    //交友模式设置入口
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_ll_chat_chairs_waiting")
    public MobileElement friendSettingEnter;

    //玩法设置
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"玩法设置\")")
    public MobileElement friendSettingsBtn;

    //团战pk模式
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_friends_pk_mode")
    public MobileElement friendPkMode;

    //开启团战pk模式
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_open_friends_pk_tv")
    public MobileElement startFriendPkBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_friends_pk")
    public MobileElement friendPkIcon;

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
        friendSeats.get(0).click();
        return seatLockBtn.getText();
    }

    public void startFriendPkMode() {
        friendSettingEnter.click();
        friendSettingsBtn.click();
        friendPkMode.click();
        startFriendPkBtn.click();
    }
}
