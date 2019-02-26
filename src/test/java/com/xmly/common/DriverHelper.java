package com.xmly.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/3
 * Time: 4:37 PM
 */
public class DriverHelper {

    //判断元素是否存在
    public static boolean isDisplayed(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }


    //获取元素对应的文本
    public static String getText(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                return mobileElement.getText();
            }
        } catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }

    //获取元素中心点击坐标
    public static String getCenterCoordinates(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                String coordinates = null;
                int x = mobileElement.getCenter().getX();
                int y = mobileElement.getCenter().getY();
                coordinates = "" + x + " " + y + "";
                return coordinates;
            }
        } catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }

    //根据坐标点击
    public static void clickByCoordinates(AppiumDriver driver, int x, int y) {
        TouchAction touchAction = new TouchAction(driver).press(PointOption.point(x, y)).release();
        touchAction.perform();
    }
}
