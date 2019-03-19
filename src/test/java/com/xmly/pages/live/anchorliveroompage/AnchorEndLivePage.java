package com.xmly.pages.live.anchorliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * ClassName: AnchorEndLivePage
 * Author: ye.liu
 * Date: 2019-03-19 15:14
 * Description:主播端退出报错专辑页面
 */

public class AnchorEndLivePage extends AnchorRoomIndexPage {
    public AnchorEndLivePage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //保存到专辑
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"保存到专辑\")")
    public MobileElement saveToAlbumPop;

    //选中要保存的专辑
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_action_cb")
    public MobileElement selectAlbumBtn;

    //保存按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_saveTv")
    public MobileElement saveBtn;

    //取消保存按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_unsaveTv")
    public MobileElement cancelSaveBtn;

    //左上角保存按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_finish_save_record_btn")
    public MobileElement upperLeftSaveBtn;

    //取消保存
    public void cancelSave() {
        cancelSaveBtn.click();
    }

    //点击左上角按钮再次保存并且保存成功
    public void saveToAlbum() {
        upperLeftSaveBtn.click();
        selectAlbumBtn.click();
        saveBtn.click();
    }
}
