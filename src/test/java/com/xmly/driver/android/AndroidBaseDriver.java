package com.xmly.driver.android;

import com.xmly.listener.appiumlistener.ElementListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/8
 * Time: 10:57 AM
 */
public class AndroidBaseDriver {
    public static AppiumDriver<? extends MobileElement> driver;

    public AppiumDriver<? extends MobileElement> getDriver() throws Exception{
        DeviceInfo deviceInfo = new DeviceInfo();
        String deviceName = deviceInfo.getDeviceName();
        String platformVersion = deviceInfo.getOsVersion();

        //设置apk的路径
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "xmly.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", true);
        //  capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", deviceName);

        //设置安卓系统版本
        capabilities.setCapability("platformVersion", platformVersion);
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath());


        //设置新的命令等待时长（应该用不到，设置1h）
        capabilities.setCapability("newCommandTimeout", 3600);

        //使用自带输入法，输入中文
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);

//        capabilities.setCapability("automationName","uiautomator2");
//        capabilities.setCapability("noSign", true);
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.ximalaya.ting.android");
        capabilities.setCapability("appActivity", "com.ximalaya.ting.android.host.activity.WelComeActivity");


        //初始化
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new ElementListener());
        return driver;
    }

    @BeforeTest
    public static void setUp() throws Exception {
        DeviceInfo deviceInfo = new DeviceInfo();
        String deviceName = deviceInfo.getDeviceName();
        String platformVersion = deviceInfo.getOsVersion();

        //设置apk的路径
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "xmly.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", true);
        //  capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", deviceName);

        //设置安卓系统版本
        capabilities.setCapability("platformVersion", platformVersion);
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath());


        //设置新的命令等待时长（应该用不到，设置1h）
        capabilities.setCapability("newCommandTimeout", 3600);

        //使用自带输入法，输入中文
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);

//        capabilities.setCapability("automationName","uiautomator2");
//        capabilities.setCapability("noSign", true);
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.ximalaya.ting.android");
        capabilities.setCapability("appActivity", "com.ximalaya.ting.android.host.activity.WelComeActivity");


        //初始化
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new ElementListener());

        Thread.sleep(5000);

    }


    @AfterTest
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
