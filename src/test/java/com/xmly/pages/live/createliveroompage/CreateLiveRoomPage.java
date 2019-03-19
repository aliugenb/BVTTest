package com.xmly.pages.live.createliveroompage;

import com.xmly.cases.CaseHelper;
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

    //直播间标题输入框
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_compose_title_et")
    public MobileElement titleEditText;

    //直播间话题输入框
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_compose_topic_et")
    public MobileElement topicEditText;

    //直播间封面
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_compose_base_cover_iv")
    public MobileElement roomCover;

    //标签下拉菜单
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_category_select_arrow")
    public MobileElement selectArrow;

    //直播间标签，选中有声书
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"有声书\")")
    public MobileElement liveCategoryTitle;

    //通知粉丝
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_notify_fans_switch")
    public MobileElement notifyFansBtn;

    //首次创建直播需麦克风权限
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement permissionAllowBtn;

    //打开上传封面页面
    public void gotoUploadCoverPage() {
        roomCover.click();
    }

    //设置直播间标题
    public void setTitle(String title) {
        titleEditText.sendKeys(title);

    }

    public void setTopic(String topic) {
        topicEditText.sendKeys(topic);

    }

    //设置直播间标签为有声书
    public void setCategory() {
        selectArrow.click();
        liveCategoryTitle.click();
    }

    /*
     * Description：创建直播间
     * Param []
     * return void
     **/
    public void createAnchorRoom() {
        notifyFansBtn.click();
        beginLiveBtn.click();
        DriverHelper.clickByPossibleElement(permissionAllowBtn);
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
