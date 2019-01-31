package com.xmly.common;

import com.xmly.driver.AppiumDriverWait;
import com.xmly.driver.ExpectedConditionForAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Date;

import static com.xmly.common.ActionHelper.execCmd;
import static com.xmly.common.ActionHelper.formatMin;

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

//    public boolean waitForAeAppear(AppiumDriver driver, int timeOutInSeconds) {
//        try {
//            AppiumDriverWait wait = new AppiumDriverWait(driver, timeOutInSeconds);
//            wait.(new ExpectedConditionForAppium<WebElement>() {
//                public WebElement apply(AndroidDriver d) {
//                    return d.findElement(By
//                            .id("com.zhihu.android:id/showcase_close"));
//                }
//
//            });
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

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

    //根据设定时长滑动页面
    public static void swipUpAndDownByTime(AppiumDriver driver, int time) throws InterruptedException, IOException, MyException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        long s = (new Date()).getTime();
        while ((new Date()).getTime() - s < formatMin(time)) {
            for (int i1 = 0; i1 <= 8; i1++) {
                TouchAction action = new TouchAction(driver).press(PointOption.point(width / 2, height * 5 / 7))
                        .waitAction().moveTo(PointOption.point(width / 2, height * 2 / 7)).release();
                action.perform();
                Thread.sleep(1000);
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                TouchAction action1 = new TouchAction(driver).press(PointOption.point(width / 2, height * 2 / 7))
                        .waitAction().moveTo(PointOption.point(width / 2, height * 5 / 7)).release();
                action1.perform();
                Thread.sleep(1000);
            }
        }
    }


    //点击系统按钮
    public static void pressKey(KEY keyCode) throws IOException {
        if (keyCode.equals(KEY.BACK)) {
            //点击返回键
            execCmd("adb shell input keyevent 4");
        } else if (keyCode.equals(KEY.ENTER)) {
            //点击ENTER键
            execCmd("adb shell input keyevent 66");
        } else if (keyCode.equals(KEY.HOME)) {
            //点击HOME键
            execCmd("adb shell input keyevent 3");
        }
    }

    //根据坐标点击
    public static void clickByCoordinates(AppiumDriver driver, int x, int y) {
        TouchAction touchAction = new TouchAction(driver).press(PointOption.point(x, y)).release();
        touchAction.perform();
    }

}
