package com.xmly.pages.live;

import com.xmly.action.ActionHelper;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 8:08 PM
 * 主播侧直播间页面
 */
public class AnchorLiveRoomPage extends BasePage {
    public AnchorLiveRoomPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_cancle_share_and_dismiss")
    private MobileElement cancelShareBtn; //取消分享

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_iv_pk")
    private MobileElement pkBtn; //pk按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_defaultCallIv")
    private MobileElement callBtn; //连麦按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/tab_listen")
    private MobileElement listenBtn; //音效按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_chat_bottom_music")
    private MobileElement addBgmBtn; //添加背景音乐按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_back_btn")
    private MobileElement exitLiveBtn; //退出直播

    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"结束直播\")"),
            @AndroidBy(id = "com.ximalaya.ting.android.live.application:id/live_ok")
    })
    private MobileElement endLiveBtn; //结束直播

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_cancel")
    private MobileElement cancelEndLiveBtn; //取消退出直播按钮

    //结束直播
    public void endLive() throws InterruptedException {
        exitLiveBtn.click();
        ActionHelper.sleep(1000);
        endLiveBtn.click();
    }

    //取消结束直播
    public void cancelEndLive() throws InterruptedException {
        exitLiveBtn.click();
        ActionHelper.sleep(1000);
        cancelEndLiveBtn.click();
    }
}
