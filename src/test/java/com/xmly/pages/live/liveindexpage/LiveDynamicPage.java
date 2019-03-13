package com.xmly.pages.live.liveindexpage;

import com.xmly.common.SwipeDirection;
import com.xmly.pages.live.RoomType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static com.xmly.common.FindElementHelper.findElementBySwipe;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-15
 * Time: 15:29
 * 直播动态页面
 */
public class LiveDynamicPage extends LiveIndexPage {
    public LiveDynamicPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //未登录情况下去登录按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_dynamic_go_login_tv")
    public MobileElement goLoginBtn;

    //未登录情况下显示热门主播推荐
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"热门主播推荐\")")
    public MobileElement hotRecommend;

    /*
    跳转登录页面
     */
    public void goToLogin() {
        if (goLoginBtn.isDisplayed()) {
            goLoginBtn.click();
        }
    }

    //无关注的主播
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"当前还没有你关注的主播正在直播哦~\")")
    public MobileElement noFollowAnchorText;

    //关注的主播头像
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_anchor_avatar")
    public MobileElement anchorHeader;

    //关注的主播昵称
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_anchor_name_tv")
    public MobileElement anchorNickName;

    //当前正在直播的主播数量
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"直播中\")")
    public List<MobileElement> onlineAnchors;

    //已结束的主播
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"直播结束\")")
    public MobileElement endLiveRoom;

    //预告的直播
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"即将直播\")")
    public MobileElement appointmentRoom;

    /*
    获取在线主播数量
     */
    public int getOnlineAnchorQty() {
        int onlineNum = 0;
        if (onlineAnchors.size() > 0) {
            onlineNum = onlineAnchors.size();
        }
        return onlineNum;
    }

    /*
     * Description：roomType为空时点击第一个直播间，其他根据传参
     * Param [roomType]
     * return void
     **/
    public void enterRoomByType(String roomType) {
        if (roomType == null || roomType.equals("")) {
            anchorHeader.click();
        } else if (roomType.equals(RoomType.END)) {
            findElementBySwipe(driver, endLiveRoom, 10, SwipeDirection.UP).click();
        } else if (roomType.equals(RoomType.APPOINTMENT)) {
            findElementBySwipe(driver, appointmentRoom, 10, SwipeDirection.UP).click();
        }
    }
}
