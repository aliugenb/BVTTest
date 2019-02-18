package com.xmly.common;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-18
 * Time: 18:33
 */

public class Swipe {

    // 上滑
    public static void SwipeUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height * 5 / 7))
                .moveTo(PointOption.point(width / 2, height * 2 / 7)).release().perform();
    }

    // 下滑
    public static void SwipeDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(width / 2, height * 2 / 7))
                .moveTo(PointOption.point(width / 2, height * 5 / 7)).release()
                .perform();
    }

    // 左滑
    public static void SwipeLeft(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    // 右滑
    public static void SwipeRight(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }
}
