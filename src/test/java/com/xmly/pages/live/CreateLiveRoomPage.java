package com.xmly.pages.live;

import com.xmly.common.DriverHelper;
import com.xmly.pages.BasePage;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.KEY;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 8:09 PM
 * 创建直播页面
 */

public class CreateLiveRoomPage extends BasePage {
    public CreateLiveRoomPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //开始直播按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_bottom_right_tv")
    public MobileElement beginLiveBtn;

    //创建预告按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_bottom_left_tv")
    public MobileElement previewLiveBtn;

    //确认取消创建按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/ok_btn")
    public MobileElement cancelBtn;

    //首次创建直播需麦克风权限
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement permissionAllowBtn;

    /*
     * Description：创建直播间
     * Param []
     * return void
     **/
    public void createAnchorRoom() {
        beginLiveBtn.click();
        if (DriverHelper.isDisplayed(permissionAllowBtn)) {
            permissionAllowBtn.click();
        }
    }

    /*
     * Description:Android取消创建直播间
     * Param []
     * return void
     **/
    public void cancelCreate() {
        AdbUtil.pressKey(KEY.BACK);
        sleep(10);
        cancelBtn.click();
    }
}
