package com.xmly.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/12
 * Time: 7:51 PM
 */

public class BasePage {

    public AppiumDriver<? extends MobileElement> driver;

    public BasePage(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
        //使用initElements方法构造,第一个参数new AppiumFieldDecorator,第二个参数是当前类
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"直播\")")
    MobileElement HomePageLiveBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"发现\")")
    MobileElement TabbarFindBtn;

    public void enter(String IndexPage) {
        switch (IndexPage) {
            case "LiveIndex":
                HomePageLiveBtn.click();
            case "FindIndex":
                TabbarFindBtn.click();
            default:
                HomePageLiveBtn.click();
        }
    }
}
