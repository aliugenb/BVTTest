package com.xmly.pages.live.anchorliveroompage;

import com.xmly.common.DriverHelper;
import com.xmly.common.Status;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static com.xmly.utils.CommonUtil.sleep;

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

    //取消分享
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_cancle_share_and_dismiss")
    public MobileElement cancelShareBtn;

    //主播间消息
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_content")
    public List<MobileElement> liveContents;

    //更多按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_ll_more")
    public MobileElement moreBtn;

    //pk按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_iv_pk")
    public MobileElement pkBtn;

    //连麦按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_defaultCallIv")
    public MobileElement callBtn;

    //音效模式
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/tab_listen")
    public MobileElement listenBtn;

    //添加背景音乐按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_chat_bottom_music")
    public MobileElement addBgmBtn;

    //更多-交友模式
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"交友模式\")")
    public MobileElement friendBtn;

    //更多-话题
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"话题\")")
    public MobileElement topicBtn;

    //更多-发言
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"发言\")")
    public MobileElement speakBtn;

    //更多-图片
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"图片\")")
    public MobileElement pictureBtn;

    //更多-开麦
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"开麦\")")
    public MobileElement enableMuteBtn;

    //更多-静音
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"静音\")")
    public MobileElement disableMuteBtn;

    //静音模式开启icon
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_iv_mic_off")
    public MobileElement micOffIcon;

    //更多-上热门
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"上热门\")")
    public MobileElement hotRocketBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"开启热门火箭\")")
    public MobileElement enableHotRocketBtn;

    //关闭热门火箭
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"关闭热门火箭\")")
    public MobileElement disableHotRocketBtn;

    //右侧小火箭图标
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/rocket")
    public MobileElement hotRocket;

    //确认关闭按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/ok_btn")
    public MobileElement okBtn;

    //更多-背包
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"背包\")")
    public MobileElement anchorBag;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_tab_indicator_red_point")
    public List<MobileElement> tabs;

    //发言输入框
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/comment_body")
    public MobileElement commentBody;

    //发言发送按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/send_comment")
    public MobileElement sendBtn;

    //退出直播相关
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_back_btn")
    public MobileElement exitLiveBtn;

    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"结束直播\")"),
            @AndroidBy(id = "com.ximalaya.ting.android.live.application:id/live_ok")
    })
    public MobileElement endLiveBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_cancel")
    public MobileElement cancelEndLiveBtn;

    //断流报错页面
    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"直播信号中断\")"),
            @AndroidBy(uiAutomator = "new UiSelector().text(\"直播详情获取失败\")")
    })
    public MobileElement errorPopup; //直播中断报错页面

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"重试\")")
    public MobileElement errorRetry; //信号中断重试

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

    //开启热门火箭
    public void enableHotRocket() {
        moreBtn.click();
        hotRocketBtn.click();
        enableHotRocketBtn.click();
    }

    //关闭热门火箭
    public void disableHotRocket() {
        moreBtn.click();
        hotRocketBtn.click();
        disableHotRocketBtn.click();
        okBtn.click();
    }

    //进入开启交友模式页面
    public void gotoFriendPage() {
        moreBtn.click();
        friendBtn.click();
    }

    //进入开启连麦页面
    public void gotoCallPage() {
        callBtn.click();
    }

    // 进入话题设置页面
    public void gotoTopicPage() {
        moreBtn.click();
        topicBtn.click();
    }

    public void getRoomTopic() {
        moreBtn.click();
        topicBtn.click();
    }

    //进入发送图片页面
    public void gotoPicturePage() {
        moreBtn.click();
        pictureBtn.click();
    }

    //打开主播端礼物背包
    public void openBag() {
        moreBtn.click();
        anchorBag.click();
    }

    /*
     * @Description:获取最新的聊天框消息
     * @Param []
     * @return io.appium.java_client.MobileElement
     **/
    public MobileElement lastContent() {
        return liveContents.get(liveContents.size() - 1);
    }

    /*
     * @Description: 主播端根据content内容发言
     * @Param [content]
     * @return void
     **/
    public void speakByContent(String content) {
        moreBtn.click();
        speakBtn.click();
        commentBody.sendKeys(content);
        sendBtn.click();
    }

    /*
     * @Description:主播端退出直播间
     * @Param []
     * @return void
     **/
    public void exitAnchorLive() {
        exitLiveBtn.click();
        endLiveBtn.click();
    }

    //关闭创建直播间后的分享页面及首次引导弹层
    public void anchroRoomInit() {
        cancelShareBtn.click();
        if (Status.isFirstCreateRoom) {
            //首次创建直播间出现蒙层，点击6次后消失
            for (int i = 0; i < 6; i++) {
                DriverHelper.clickWindowCenter(driver);
                sleep(2);
            }
            Status.isFirstCreateRoom = false;
        }
    }
}
