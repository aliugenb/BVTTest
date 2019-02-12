package com.xmly.pages;

import com.xmly.common.DriverHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/12
 * Time: 7:51 PM
 */

public class BasePage {

    public AppiumDriver<? extends MobileElement> driver;

    private final int TIMEOUT = 15;
    public static final String LiveHomePage = "LiveIndex";
    public static final String FindHomePage = "FindIndex";

    public BasePage(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
        //使用initElements方法构造,第一个参数new AppiumFieldDecorator,第二个参数是当前类
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(TIMEOUT)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"直播\")")
    private MobileElement homePageLiveTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"发现\")")
    private MobileElement tabbarFindBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_close_firework")
    private MobileElement interstitial; //首页弹窗广告关闭按钮

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement permissionAllowBtn; //首页权限按钮


    public void enter(String HomePage) {
        switch (HomePage) {
            case "LiveIndex":
                homePageLiveTab.click();
                break;
            case "FindIndex":
                tabbarFindBtn.click();
                break;
            default:
                homePageLiveTab.click();
                break;
        }
    }

    public void closeInterstitial() {
        try {
            if (interstitial.isDisplayed()) {
                interstitial.click();
            }
        } catch (NoSuchElementException e) {
            e.getStackTrace();
        }
    }

    public void allowPermission() {
        if (DriverHelper.isDisplayed(permissionAllowBtn)) {
            permissionAllowBtn.click();
        }
    }
}
