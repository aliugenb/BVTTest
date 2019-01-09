package com.xmly.pages.live.anchorliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/9
 * Time: 10:47 AM
 * 交友模式
 */
public class FriendPage extends AnchorRoomIndexPage {
    public FriendPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_seat_iv")
    public List<MobileElement> FriendSeats; //交友模式位置

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_operation_desc_tv")
    public MobileElement forbbidenSeatBtn; //锁定位置按钮


}
