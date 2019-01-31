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

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_seat_iv")
    public List<MobileElement> friendSeats; //交友模式位置

    public int getLiveSeatQty() {
        return friendSeats.size();
    }
}
