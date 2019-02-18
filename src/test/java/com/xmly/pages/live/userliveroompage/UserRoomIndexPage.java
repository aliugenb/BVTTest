package com.xmly.pages.live.userliveroompage;

import com.xmly.common.DriverHelper;
import com.xmly.driver.Driver;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-14
 * Time: 17:34
 */

public class UserRoomIndexPage extends BasePage {
    public UserRoomIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //直播主题
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_showTopic")
    public MobileElement liveTopic;

    //主播粉丝团
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_fans_club")
    public MobileElement fansClubBtn;

    //主播昵称
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_anchor_name_tv")
    public MobileElement anchorNickName;

    //贵族列表
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_online_noble_tv")
    public MobileElement onlineNobleList;

    //发言框
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_send")
    public MobileElement speakText;

    //关注按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_followTv")
    public MobileElement followBtn;

    //退出直播按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_btn_close_room")
    public MobileElement closeRoomBtn;


    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_close_room_exit")
    public MobileElement exitRoomBtn;

    //关注并退出直播间按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_close_room_follow_and_exit")
    public MobileElement exitAndFollowBtn;

    /*
    用户端退出直播间
     */
    public void exitLiveRoom(int min) {
        closeRoomBtn.click();
        if (min >= 10) {
            exitAndFollowBtn.click();
        } else {
            exitRoomBtn.click();
        }
    }

    /*
    直播间左滑
     */
    public void swipToLeft() {

    }

    //是否关注了当前主播
    public boolean isFollow() {
        boolean flag = false;
        if (!DriverHelper.isDisplayed(followBtn)) {
            flag = true;
        }
        return flag;
    }
}
