package com.xmly.pages;

import com.xmly.common.ActionHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/2
 * Time: 5:07 PM
 */
public class LoginPage extends BasePage {

    public static final String onlineUsername = "17602176634";
    public static final String testUsername = "18616219964";
    public static final String passwd = "a123456";

    public LoginPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_login_more")
    public MobileElement moreLoginBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_username")
    public MobileElement userNameInput;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_password")
    public MobileElement passwdInput;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_login")
    public MobileElement loginBtn;

    public void login(String userName, String passwd) throws InterruptedException {
        moreLoginBtn.click();
        userNameInput.sendKeys(userName);
        ActionHelper.sleep(3000);
        passwdInput.sendKeys(passwd);
        ActionHelper.sleep(2000);
        loginBtn.click();
    }

    //线上账号登录
    public void onlineLogin() throws InterruptedException {
        login(onlineUsername, passwd);
    }

    //测试账号登录
    public void testLogin() throws InterruptedException {
        login(testUsername, passwd);

    }
}
