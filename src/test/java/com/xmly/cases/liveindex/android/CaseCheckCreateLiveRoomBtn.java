package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 23:14
 */

public class CaseCheckCreateLiveRoomBtn extends CaseHelper {
    @Test(description = "检查直播首页存在我要直播按钮")
    public void checkCreateLiveRoomBtn() {
        gotoLiveIndex();
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.liveOptionsBtn),
                getCurClassName() + "首页存在我要直播按钮");
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(createLiveRoomPage.beginLiveBtn),
                getCurClassName() + "判断创建页面存在开始按钮");
    }
}
