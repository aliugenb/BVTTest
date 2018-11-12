package com.xmly.android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/8
 * Time: 11:09 AM
 * 直播首页
 */
public class LiveIndexPage extends BasePage{

    public LiveIndexPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id="")
    AndroidElement liveRoom;
}
