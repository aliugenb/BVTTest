package com.xmly.driver.android;

import com.xmly.listener.appiumlistener.ElementListener;
import com.xmly.utils.DeviceInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.xmly.utils.FilesInit.apkPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/8
 * Time: 10:57 AM
 */

public class AndroidBaseDriver {

    private AppiumDriver<? extends MobileElement> driver;

    {
        AndroidDeviceInfo deviceInfo = new AndroidDeviceInfo();
        String deviceName = deviceInfo.getDeviceName();
        String platformVersion = deviceInfo.getOsVersion();
        String productModel = deviceInfo.getProductModel();

        try {
            new DeviceInit().installApp(productModel);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
//        capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

        //设置安卓系统版本
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        //设置apk路径
        capabilities.setCapability(MobileCapabilityType.APP, apkPath);


        //设置新的命令等待时长（应该用不到，设置1h）
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

        //使用自带输入法，输入中文
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);

        //capabilities.setCapability("automationName","uiautomator2");
        //capabilities.setCapability("noSign", true);
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.ximalaya.ting.android");
        capabilities.setCapability("appActivity", "com.ximalaya.ting.android.host.activity.WelComeActivity");


        //初始化
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new ElementListener());
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
