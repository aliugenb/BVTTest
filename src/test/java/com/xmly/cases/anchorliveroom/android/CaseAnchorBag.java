package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import org.testng.annotations.Test;

/**
 * ClassName: CaseAnchorBag
 * Author: ye.liu
 * Date: 2019-03-19 14:55
 * Description:主播端背包
 */
public class CaseAnchorBag extends CaseHelper {
    @Test(description = "检查主播端背包")
    public void checkAnchorBag() {
        createAnchorLiveRoom();
        anchorRoomIndexPage.openBag();
        assertHelper.assertTrue(anchorRoomIndexPage.tabs.size() == 1
                        && anchorRoomIndexPage.tabs.get(0).getText().equals("背包"),
                getCurClassName() + "主播端背包入口只展示背包tab");
    }
}
