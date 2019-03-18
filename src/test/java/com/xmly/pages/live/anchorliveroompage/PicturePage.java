package com.xmly.pages.live.anchorliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * ClassName: PicturePage
 * Author: ye.liu
 * Date: 2019-03-18 19:28
 * Description:
 */
public class PicturePage extends AnchorRoomIndexPage {
    public PicturePage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //图片选中按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_selected_tag")
    public MobileElement selectTag;

    //发送按钮
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"发送\")")
    public MobileElement sendBtn;

    public void sendPicture() {
        selectTag.click();
        sendBtn.click();
    }
}
