package com.xmly.pages;

import com.xmly.common.MyException;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.CommonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.io.IOException;
import java.util.List;

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

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_login_with_pwd")
    public MobileElement loginByPwdBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_username")
    public MobileElement userNameInput;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<MobileElement> inputEditText;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_password")
    public MobileElement passwdInput;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_login")
    public MobileElement loginBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_psw_status_switch")
    public MobileElement passwdStatusSwitch;

    private void login(String userName, String passwd) throws IOException, MyException {
        moreLoginBtn.click();
        loginByPwdBtn.click();
        System.out.println("开始输入");
//        userNameInput.sendKeys(userName);
        inputEditText.get(0).sendKeys(userName);
        System.out.println("输入账号");
        CommonUtil.sleep(6000);
        System.out.println("=================");
        inputEditText.get(1).sendKeys(passwd);
//        passwdInput.sendKeys(passwd);
        CommonUtil.sleep(5000);
        loginBtn.click();
    }

    //线上账号登录
    public void onlineLogin() {
        try {
            login(onlineUsername, passwd);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    //测试账号登录
    public void testLogin() {
        try {
            login(testUsername, passwd);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
}
