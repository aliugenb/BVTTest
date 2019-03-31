package com.xmly.pages.otherpages;

import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * ClassName: PersonalPage
 * Author: ye.liu
 * Date: 2019-03-31 19:42
 * Description:个人页
 */
public class PersonalPage extends BasePage {
    public PersonalPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_live_title")
    public MobileElement liveTitle;

    public void enterLiveRoom(){
        liveTitle.click();
    }
}
