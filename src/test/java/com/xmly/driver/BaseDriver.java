package com.xmly.driver;

import com.xmly.cases.BaseCase;
import com.xmly.common.MyException;
import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.driver.ios.IosBaseDriver;
import com.xmly.utils.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 2:45 PM
 */
public abstract class BaseDriver implements Driver {

    private static AppiumDriver<? extends MobileElement> driver;

    public static void setDriver(int osDriver) throws MyException {
        try {
            if (!AppiumServer.startAppium()) {
                throw new MyException("appium未启动");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        if (osDriver == Driver.AndroidDriver) {
            driver = new AndroidBaseDriver().getDriver();
        } else if (osDriver == Driver.IosDriver) {
//            BaseDriver.driver = IosBaseDriver.getDriver();
            System.out.println("还没做呢");
        } else {
            throw new MyException("未传入系统类型");
        }
    }

    public static AppiumDriver<? extends MobileElement> getDriver() {
        return driver;
    }
}
