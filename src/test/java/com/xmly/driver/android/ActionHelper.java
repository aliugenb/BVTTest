package com.xmly.driver.android;

import com.xmly.action.MyException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.Date;

import static com.xmly.action.CommonAction.formatMin;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 5:12 PM
 */
public class ActionHelper extends AndroidBaseDriver {

    public void swipUpAndDownByTime(int time) throws InterruptedException, IOException, MyException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        long s = (new Date()).getTime();
        while ((new Date()).getTime() - s < formatMin(time)) {
//            checkInFanli();
            for (int i1 = 0; i1 <= 8; i1++) {
                TouchAction action = new TouchAction(driver).press(width / 2, height * 5 / 7).waitAction().moveTo(width / 2, height * 2 / 7).release();
                action.perform();
                Thread.sleep(1000);
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                TouchAction action1 = new TouchAction(driver).press(width / 2, height * 2 / 7).waitAction().moveTo(width / 2, height * 5 / 7).release();
                action1.perform();
                Thread.sleep(1000);
            }
        }
    }
}
