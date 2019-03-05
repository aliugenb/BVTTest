package com.xmly.pages.live.userliveroompage;

import com.xmly.common.DriverHelper;
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

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_fans_guide_tv")
    public MobileElement joinFansClubBtn;

    @AndroidFindBy(accessibility = "立即加入(19喜钻）")
    public MobileElement joinBy;

    //贵族弹幕
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_noble_bullet_tv")
    public MobileElement nobleBullet;

    //发言框
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/comment_body")
    public MobileElement speakEditText;

    /*
     * Description：开启或者关闭弹幕
     * Param []
     * return boolean
     **/
    public boolean switchBullet() {
        boolean flag = false;
        bulletSwitchBtn.click();
        if (DriverHelper.isDisplayed(commonBullet)) {
            flag = true;
        }
        return flag;
    }

    /*
     * Description：根据弹幕类型选中不同弹幕，默认选中普通
     * Param [bulletType]
     * return void
     **/
    public void clickBulletByType(String bulletType) {
        switch (bulletType) {
            case BulletType.COMMON:
                commonBullet.click();
                break;
            case BulletType.FANS:
                fansBullet.click();
                break;
            case BulletType.NOBLE:
                nobleBullet.click();
                break;
            default:
                commonBullet.click();
                break;
        }
    }

    public void joinFansClub() {
        joinFansClubBtn.click();
    }

    /*
     * Description：获取发言框的文案
     * Param []
     * return java.lang.String
     **/
    public String getEditText() {
        String text = "";
        if (DriverHelper.isDisplayed(speakEditText)) {
            text = speakEditText.getText();
        }
        return text;
    }
}
