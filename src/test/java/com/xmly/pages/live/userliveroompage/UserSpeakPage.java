package com.xmly.pages.live.userliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * ClassName: UserSpeakPage
 * Author: ye.liu
 * Date: 2019-02-26 14:20
 * Description:
 */
public class UserSpeakPage extends UserRoomIndexPage {
    public UserSpeakPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //弹幕功能开关
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_time_result_tv")
    public MobileElement bulletSwitchBtn;

    //普通弹幕
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_normal_bullet_tv")
    public MobileElement commonBullet;

    //粉丝弹幕
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_fans_bullet_tv")
    public MobileElement fansBullet;

    //贵族弹幕
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_noble_bullet_tv")
    public MobileElement nobleBullet;

}
