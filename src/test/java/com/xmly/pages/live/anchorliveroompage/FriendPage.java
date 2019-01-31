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
 */
public class FriendPage extends AnchorRoomIndexPage {
    public FriendPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_seat_name_tv")
    public List<MobileElement> friendSeats; //交友模式位置

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_dialog_center_btn")
    public MobileElement friendConfirmPopup; //交友模式开启确认弹窗

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_operation_desc_tv")
    public MobileElement forbbidenSeatBtn; //锁定位置按钮

    //开启交友模式
    public void enableFriend() {
        friendConfirmPopup.click();
    }

    //获取交友模式位置数量
    public int getFriendSeatQty() {
        return friendSeats.size();
    }
}
