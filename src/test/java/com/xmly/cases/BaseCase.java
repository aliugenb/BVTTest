package com.xmly.cases;

import com.xmly.driver.android.AndroidBaseDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/26
 * Time: 4:27 PM
 */
public class BaseCase {
    protected static AppiumDriver<? extends MobileElement> driver;

    @BeforeTest
    public static void setUp() throws Exception {
        driver = new AndroidBaseDriver().getDriver();
    }

    @AfterTest
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
