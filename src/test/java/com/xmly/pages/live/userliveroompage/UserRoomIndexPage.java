package com.xmly.pages.live.userliveroompage;

import com.xmly.common.DriverHelper;
import com.xmly.common.Status;
import com.xmly.common.Swipe;
import com.xmly.pages.BasePage;
import com.xmly.pages.live.RoomType;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.KEY;
import com.xmly.utils.SnapshotAndLog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Reporter;

import static com.xmly.common.DriverHelper.getText;
import static com.xmly.common.DriverHelper.isDisplayed;
import static com.xmly.utils.CommonUtil.sleep;

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

    //预约直播的开播时间
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"开播时间\")")
    public MobileElement liveStartTime;

    //结束的直播主播名称
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_audience_finish_host_name")
    public MobileElement endLiveAnchorName;

    //直播间状态
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_room_status")
    public MobileElement liveRoomStatus;

    //直播主题
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_showTopic")
    public MobileElement liveTopic;

    //主播粉丝团
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_fans_club")
    public MobileElement fansClubBtn;

    //主播昵称
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_anchor_name_tv")
    public MobileElement anchorNickName;

    //贵族列表
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_online_noble_tv")
    public MobileElement onlineNobleList;

    //发言框
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_send")
    public MobileElement speakText;

    //上麦按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_btn_bottom_friends_seat_request")
    public MobileElement requestBtn;

    //团战pk结果页
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_friends_pk_result_top_iv")
    public MobileElement friendPkResultPop;

    //团战PK结果页关闭按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_close_btn")
    public MobileElement friendPkResultCloseBtn;

    //礼物面板按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_btn_gift")
    public MobileElement giftBtn;

    //PK状态栏
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_pk_status_bg")
    public MobileElement pkStatus;

    //关注按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_followTv")
    public MobileElement followBtn;

    //首充弹窗
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"首充\")")
    public MobileElement firstChargePop;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_webview_close")
    public MobileElement closeWebviewBtn;

    //退出直播按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_btn_close_room")
    public MobileElement closeRoomBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_close_room_exit")
    public MobileElement exitRoomBtn;

    //关注并退出直播间按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_close_room_follow_and_exit")
    public MobileElement exitAndFollowBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_scroll_svg_guide")
    public MobileElement swipeGuide;

    /*
     * Description：获取主播昵称
     * Param []
     * return java.lang.String
     **/
    public String getAnchorName() {
        return anchorNickName.getText();
    }

    /*
     * @Description: 关闭webview
     * @Param []
     * @return void
     **/
    public void closeWebView() {
        if (DriverHelper.isDisplayed(closeWebviewBtn)) {
            closeWebviewBtn.click();
        }
    }

    /*
     * @Description: 关闭首充弹窗
     * @Param []
     * @return void
     **/
    public void closeFirstChargePop() {
        if (!Status.isChargePop) {
            sleep(70);
            if (isDisplayed(firstChargePop)) {
                Reporter.log("出现首充弹窗");
                SnapshotAndLog.snapshotByAppium("出现首充弹窗");
                closeWebView();
            }
            Status.isChargePop = true;
        }
    }

    /*
     * @Description: 获取当前直播间类型
     * @Param []
     * @return java.lang.String
     **/
    public String getRoomType() {
        String roomType = null;

        if (isDisplayed(requestBtn)) {
            roomType = RoomType.FRIEND;
        } else if (isDisplayed(pkStatus)) {
            roomType = RoomType.PK;
        } else if (isDisplayed(liveStartTime) || getText(liveRoomStatus).equals("待播中")) {
            roomType = RoomType.PREVIEW;
        } else if (isDisplayed(endLiveAnchorName) || getText(liveRoomStatus).equals("直播结束")) {
            roomType = RoomType.END;
        } else if (isDisplayed(fansClubBtn)) {
            roomType = RoomType.COMMON;
        }
        return roomType;
    }

    /*
     * @Description: 打开发言面板
     * @Param []
     * @return void
     **/
    public void gotoUserSpeakPage() {
        speakText.click();
    }

    /*
     * @Description: 打开礼物面板
     * @Param []
     * @return void
     **/
    public void gotoGiftPanelPage() {
        giftBtn.click();
    }

    /*
     * @Description: 用户端退出正常状态的直播间
     * @Param [min] 一般退出，传入min<10;出现关注&退出按钮后退出，传入min>=10
     * @return void
     **/
    public void exitNormalLiveRoom() {
        closeRoomBtn.click();
        if (isDisplayed(swipeGuide)) {
            SnapshotAndLog.snapshotByAppium("出现左右滑动引导浮层");
            Swipe.swipeLeft(driver);
            closeRoomBtn.click();
        }
        if (isDisplayed(exitAndFollowBtn)) {
            SnapshotAndLog.snapshotByAppium("出现退出并关闭按钮");
            exitAndFollowBtn.click();
        } else {
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

    /*
     * Description：退出预告和结束的直播间
     * Param []
     * return void
     **/
    public void exitAbnormalLiveRoom(String roomType) {
        if (roomType.equals(RoomType.PREVIEW)) {
            if (isDisplayed(liveStartTime)) {
                closeRoomBtn.click();
            }
            SnapshotAndLog.snapshotByAppium("退出预告直播间");
        }
        if (roomType.equals(RoomType.END)) {
            if (isDisplayed(endLiveAnchorName)) {
                AdbUtil.pressKey(KEY.BACK);
            }
            SnapshotAndLog.snapshotByAppium("退出直播结束的直播间");
        }
        sleep(5);
        closeRoomBtn.click();
    }
}
