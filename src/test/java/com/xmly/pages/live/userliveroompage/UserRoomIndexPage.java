package com.xmly.pages.live.userliveroompage;

import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import com.xmly.pages.BasePage;
import com.xmly.utils.CommonUtil;
import com.xmly.utils.SnapshotAndLog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Reporter;

import static com.xmly.common.DriverHelper.isDisplayed;

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

    //上麦按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_btn_bottom_friends_seat_request")
    public MobileElement requestBtn;

    //礼物面板按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_btn_gift")
    public MobileElement giftBtn;

    //PK状态栏
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_pk_status")
    public MobileElement pkStatus;

    //关注按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_followTv")
    public MobileElement followBtn;

    //首充弹窗
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"首充\")")
    public MobileElement firstChargePop;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_webview_close")
    public MobileElement closeWebviewBtn;

    //退出直播按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_btn_close_room")
    public MobileElement closeRoomBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_close_room_exit")
    public MobileElement exitRoomBtn;

    //关注并退出直播间按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_close_room_follow_and_exit")
    public MobileElement exitAndFollowBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_scroll_svg_guide")
    public MobileElement swipeGuide;


    /*
     * @Description: 关闭首充弹窗
     * @Param []
     * @return void
     **/
    public void closeFirstChargePop() {
        CommonUtil.sleep(70);
        if (isDisplayed(firstChargePop)) {
            Reporter.log("出现首充弹窗");
            closeWebviewBtn.click();
        }
    }

    /*
     * @Description: 获取当前直播间类型
     * @Param []
     * @return java.lang.String
     **/
    public String getRoomType() {
        String roomType = RoomType.COMMON;

        if (isDisplayed(requestBtn)) {
            roomType = RoomType.FRIEND;
        } else if (isDisplayed(pkStatus)) {
            roomType = RoomType.PK;
        }
        return roomType;
    }

    /*
     * @Description: 用户端退出直播间
     * @Param [min] 一般退出，传入min<10;出现关注&退出按钮后退出，传入min>=10
     * @return void
     **/
    public void exitLiveRoom(int min) {
        closeRoomBtn.click();
        if (isDisplayed(swipeGuide)) {
            Reporter.log("出现左右滑动引导浮层");
            Swipe.swipeLeft(driver);
            closeRoomBtn.click();
        }
        Reporter.log("出现直播间关闭确认弹窗");
        if (min >= 10) {
            SnapshotAndLog.snapshotByAppium("超出10分钟用户端关闭直播间");
            exitAndFollowBtn.click();
        } else {
            SnapshotAndLog.snapshotByAppium("小于10分钟用户端关闭直播间");
            exitRoomBtn.click();
        }
    }

    //是否关注了当前主播
    public boolean isFollow() {
        boolean flag = false;
        if (!isDisplayed(followBtn)) {
            flag = true;
        }
        return flag;
    }
}
