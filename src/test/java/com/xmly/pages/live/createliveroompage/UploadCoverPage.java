package com.xmly.pages.live.createliveroompage;

import com.xmly.common.DriverHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * ClassName: UploadCoverPage
 * Author: ye.liu
 * Date: 2019-03-19 16:56
 * Description:上传直播间封面页面,只适配了华为手机
 */
public class UploadCoverPage extends CreateLiveRoomPage {
    public UploadCoverPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //上传方式为相册
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"相册\")")
    public MobileElement byAlbumBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"杂志锁屏\")")
    public MobileElement pictreAlbum;

    //上传方式为拍照
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"拍照\")")
    public MobileElement byCaptureBtn;

    //拍照权限确认按钮
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement permissionallowBtn;

    //华为手机拍照
    @AndroidFindBy(id = "com.huawei.camera:id/shutter_button")
    public MobileElement shutterBtn;

    //照片选中按钮
    @AndroidFindBy(id = "com.huawei.camera:id/done_button")
    public MobileElement selectBtn;

    //裁剪完成按钮
    @AndroidFindBy(id = "com.android.gallery3d:id/head_select_right")
    public MobileElement finshBtn;

    //通过相册上传
    public void uploadByAlbum() {
        byAlbumBtn.click();
        pictreAlbum.click();
        sleep(5);
        DriverHelper.clickWindowCenter(driver);
        finshBtn.click();
        sleep(5);
        DriverHelper.clickByCoordinates(driver, 675, 45);
    }

    //通过拍照上传
    public void uploadByCapture() {
        byCaptureBtn.click();
        DriverHelper.clickByPossibleElement(permissionallowBtn);

        shutterBtn.click();
        selectBtn.click();
        sleep(5);
        DriverHelper.clickByCoordinates(driver, 675, 45);
    }
}
