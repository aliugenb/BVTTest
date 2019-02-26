package com.xmly.driver;

import com.xmly.common.MyException;
import com.xmly.common.Status;
import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.driver.android.AndroidDeviceInfo;
import com.xmly.driver.android.DeviceInit;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.AppiumServer;
import com.xmly.utils.SnapshotAndLog;
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

    public static void setDriver(int osDriver) throws MyException, IOException {
        if (!AppiumServer.startAppium()) {
            throw new MyException("appium未启动");
        }

        if (osDriver == Driver.ANDROIDDRIVER) {
            if (!AdbUtil.isConnect()) {
                throw new MyException("设备未连接");
            }
            AndroidDeviceInfo deviceInfo = new AndroidDeviceInfo();
            String deviceName = deviceInfo.getDeviceName();
            String platformVersion = deviceInfo.getOsVersion();
            String productModel = deviceInfo.getProductModel();

//            if (!Status.isInstall) {
//                DeviceInit.installApp(productModel);
//            }
            driver = new AndroidBaseDriver(deviceName, platformVersion).getDriver();

            AdbUtil.clearAndroidLog();
        } else if (osDriver == Driver.IOSDRIVER) {
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
