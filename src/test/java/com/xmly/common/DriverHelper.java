package com.xmly.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

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

    /*
     * Description: 获取元素中心点击坐标
     * Param [element]
     * return org.openqa.selenium.Point
     **/
    public static Point getCenter(MobileElement element) {
        return element.getCenter();
    }

    /*
     * Description: 获取元素左上角点击坐标
     * Param [element]
     * return org.openqa.selenium.Point
     **/
    public static Point getUpperLeft(MobileElement element) {
        return element.getLocation();
    }

    /*
     * Description: 获取元素右下角点击坐标
     * Param [element]
     * return org.openqa.selenium.Point
     **/
    public static Point getLowerRight(MobileElement element) {
        Point upperLeft = element.getCenter();
        Dimension dimensions = element.getSize();
        return new Point(upperLeft.getX() + dimensions.getWidth() / 2,
                upperLeft.getY() + dimensions.getHeight() / 2);
    }


    //根据坐标点击
    public static void clickByCoordinates(AppiumDriver driver, int x, int y) {
        TouchAction touchAction = new TouchAction(driver).press(PointOption.point(x, y)).release();
        touchAction.perform();
    }
}
