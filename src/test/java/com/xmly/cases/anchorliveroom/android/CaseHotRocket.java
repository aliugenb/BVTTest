package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

/**
 * ClassName: CaseHot
 * Author: ye.liu
 * Date: 2019-03-19 14:04
 * Description:
 */
public class CaseHotRocket extends CaseHelper {
    @Test(description = "主播端上热门")
    public void checkHotRocket() {
        createAnchorLiveRoom();
        anchorRoomIndexPage.enableHotRocket();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.hotRocket),
                getCurClassName() + "开启热门火箭并且展示正常");

        anchorRoomIndexPage.disableHotRocket();
        assertHelper.assertTrue(!DriverHelper.isDisplayed(anchorRoomIndexPage.hotRocket),
                getCurClassName() + "关闭热门火箭并图标正常消失");

    }
}
