package com.xmly.pages;

import com.xmly.common.DriverHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

    private final int TIMEOUT = 20;
    public static final String LIVEHOMEPAGE = "LiveIndex";
    public static final String FINDPAGE = "FindIndex";
    public static final String MYLISTEN = "MyListen";

    public BasePage(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
        //使用initElements方法构造,第一个参数new AppiumFieldDecorator,第二个参数是当前类
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(TIMEOUT)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"直播\")")
    public MobileElement homePageLiveTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"发现\")")
    private MobileElement tabbarFindBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"我听\")")
    private MobileElement tabbarMylistenBtn;


    @AndroidFindBy(id = "com.ximalaya.ting.android:id/tab_myspace")
    public MobileElement mySpaceBtn;

    //首页弹窗广告关闭按钮
    @AndroidFindAll({
            @AndroidBy(id = "com.ximalaya.ting.android:id/host_close_firework"),
            @AndroidBy(id = "com.ximalaya.ting.android:id/main_iv_close")
    })
    public MobileElement closeInterstitialBtn;

    //首页新人引导蒙层
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/main_tv_tips")
    public MobileElement newerTips;

    //首页权限管理
    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"确定\")"),
            @AndroidBy(id = "com.android.packageinstaller:id/permission_allow_button")
    })
    public MobileElement permissionAllowBtn;

    //首页升级弹窗
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_dialog_update_cancel_iv")
    public MobileElement updateBtn;

    /*
     * @Description: 进入直播首页或者发现页
     * @Param [homePage]
     * @return void
     **/
    public void gotoPage(String homePage) {
        switch (homePage) {
            case LIVEHOMEPAGE:
                homePageLiveTab.click();
                break;
            case FINDPAGE:
                tabbarFindBtn.click();
                break;
            case MYLISTEN:
                tabbarMylistenBtn.click();
                break;
            default:
                homePageLiveTab.click();
                break;
        }
    }

    /*
     * @Description:根据个人中心tab判断是否登录
     * @Param []
     * @return boolean
     **/
    public boolean isLogin() {
        boolean flag = false;
        if (DriverHelper.isDisplayed(mySpaceBtn)) {
            String btnText = mySpaceBtn.getText();
            if (!btnText.contains("未登录")) {
                return true;
            }
        }
        return flag;
    }
}
