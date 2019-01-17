package com.xmly.pages.live.anchorliveroompage;

import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:57 PM
 */
public class AnchorRoomIndexPage extends BasePage {
    public AnchorRoomIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_cancle_share_and_dismiss")
    public MobileElement cancelShareBtn; //取消分享

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_content")
    public MobileElement content; //主播间消息

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_iv_pk")
    public MobileElement pkBtn; //pk按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_defaultCallIv")
    public MobileElement callBtn; //连麦按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/tab_listen")
    public MobileElement listenBtn; //音效按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_chat_bottom_music")
    public MobileElement addBgmBtn; //添加背景音乐按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_ll_more")
    public MobileElement moreBtn; //更多按钮

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"交友模式\")")
    public MobileElement friendBtn; //交友模式按钮

    //退出直播相关
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_back_btn")
    public MobileElement exitLiveBtn; //退出直播

    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"结束直播\")"),
            @AndroidBy(id = "com.ximalaya.ting.android.live.application:id/live_ok")
    })
    public MobileElement endLiveBtn; //结束直播

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_cancel")
    public MobileElement cancelEndLiveBtn; //取消退出直播按钮


    //断流报错页面
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"直播信号中断\")")
    public MobileElement errorPopup; //信号中断报错页面

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"重试\")")
    public MobileElement errorRetry; //信号中断重试

    //主播端退出直播间
    public void endAnchorLive() throws InterruptedException {
        exitLiveBtn.click();
        TimeUnit.SECONDS.sleep(2);
        endLiveBtn.click();
    }

    //开启交友模式
    public void enableFriendModel() {
        moreBtn.click();
        friendBtn.click();
    }
}
