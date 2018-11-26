package com.xmly.cases;

import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.pages.LiveIndexPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/24
 * Time: 10:48 AM
 */
public class EnterRecoder {
    private static AppiumDriver<? extends MobileElement> driver;

    @BeforeTest

    public static void main(String[] args) throws Exception {
        driver = new AndroidBaseDriver().getDriver();
        LiveIndexPage liveIndexPage = new LiveIndexPage(driver);
        liveIndexPage.enterRecorder();
    }
}
