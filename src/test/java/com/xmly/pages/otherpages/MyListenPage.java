package com.xmly.pages.otherpages;

import com.xmly.common.DriverHelper;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;

/**
 * ClassName: MyListenPage
 * Author: ye.liu
 * Date: 2019-03-24 22:17
 * Description:我听页面
 */
public class MyListenPage extends BasePage {
    public MyListenPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }


    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_woting_anchor_multi_image")
    public MobileElement onlineLiveRoom;

    public void enterLive(){
        if(DriverHelper.isDisplayed(onlineLiveRoom)){
            onlineLiveRoom.click();
        }else {
            throw new NoSuchElementException("当前无正在直播的直播间");
        }
    }
}
