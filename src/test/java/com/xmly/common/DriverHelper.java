package com.xmly.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/3
 * Time: 4:37 PM
 */
public class DriverHelper {

    public static void clickByText(AppiumDriver driver, String text) {
        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator
                ("new UiSelector().text(\"" + text + "\")"));
        element.click();
    }

    /*
     * @Description: 判断元素是否存在，无Exception抛出
     * @Param [mobileElement]
     * @return boolean
     **/
    public static boolean isDisplayed(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    //点击可能存在的元素,如权限弹层之类
    public static void clickByPossibleElement(MobileElement mobileElement) {
        if (isDisplayed(mobileElement)) {
            mobileElement.click();
        }
    }


    /*
     * @Description: 获取元素的文本，无NoSuchElementException抛出
     * @Param [mobileElement]
     * @return java.lang.String
     **/
    public static String getText(MobileElement mobileElement) {
        String text = "";
        try {
            if (mobileElement.isDisplayed()) {
                text = mobileElement.getText();
                return text;
            }
        } catch (NoSuchElementException e) {
            return text;
        }
        return text;
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

    //点击屏幕中心位置
    public static void clickWindowCenter(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        clickByCoordinates(driver, width / 2, height / 2);
    }
}
