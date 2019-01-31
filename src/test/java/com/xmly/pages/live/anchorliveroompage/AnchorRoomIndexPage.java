package com.xmly.pages.live.anchorliveroompage;

import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:57 PM
 * 主播端直播间页面
 */
public class AnchorRoomIndexPage extends BasePage {
    public AnchorRoomIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_cancle_share_and_dismiss")
    public MobileElement cancelShareBtn; //取消分享

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_content")
    public MobileElement content; //主播间消息

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_ll_more")
    public MobileElement moreBtn; //更多按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_iv_pk")
    public MobileElement pkBtn; //pk按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_defaultCallIv")
    public MobileElement callBtn; //连麦按钮

    //进入开启连麦页面
    public void gotoCallPage() {
        callBtn.click();
    }

    //音效模式
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/tab_listen")
    public MobileElement listenBtn; //音效按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_chat_bottom_music")
    public MobileElement addBgmBtn; //添加背景音乐按钮

    //交友模式
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"交友模式\")")
    public MobileElement friendBtn; //交友模式按钮

    //进入开启交友模式页面
    public void gotoFriendPage() {
        moreBtn.click();
        friendBtn.click();
    }

    //静音模式
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"开麦\")")
    public MobileElement enableMuteBtn; //开启静音

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"静音\")")
    public MobileElement disableMuteBtn; //关闭静音

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_iv_mic_off")
    public MobileElement micOffIcon; //静音模式开启icon

    //开启静音模式
    public void enableMute() {
        moreBtn.click();
        enableMuteBtn.click();
    }

    //关闭静音模式
    public void disableMute() {
        try {
            if (moreBtn.isDisplayed()) {
                moreBtn.click();
                disableMuteBtn.click();
            }
        } catch (NoSuchElementException e) {
            disableMuteBtn.click();
        }
    }

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

    //主播端退出直播间
    public void endAnchorLive() throws InterruptedException {
        exitLiveBtn.click();
        TimeUnit.SECONDS.sleep(2);
        endLiveBtn.click();
    }

    //断流报错页面
    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"直播信号中断\")"),
            @AndroidBy(uiAutomator = "new UiSelector().text(\"直播详情获取失败\")")
    })
    public MobileElement errorPopup; //直播中断报错页面

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"重试\")")
    public MobileElement errorRetry; //信号中断重试
}
