package com.xmly.pages.live.anchorliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-01-31
 * Time: 18:04
 * 设置话题页面
 */
public class TopicPage extends AnchorRoomIndexPage {
    public TopicPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_announceEt")
    public MobileElement topicInput;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/actionTv")
    public MobileElement topicConfirmBtn;


    //设置话题内容
    public void setTopic(String content) throws InterruptedException {
        topicInput.sendKeys(content);
        TimeUnit.SECONDS.sleep(5);
        topicConfirmBtn.click();
    }

    //获取直播间话题
    public String getTopic() {
        String topic = "";
        topic = topicInput.getText();
        return topic;
    }
}
