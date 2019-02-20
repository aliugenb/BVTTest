package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:43 PM
 * 热门分类tab存在并且有5个
 */

public class CaseCheckLiveTab extends CaseHelper {
    @Test
    public static void checkLiveTab() {
        CaseHelper.gotoLiveIndex();
        assertHelper.assertTrue(liveIndexPage.getLiveTabQty() == 5,
                "判断首页tab数量=5", "CheckLiveTab首页tab数量");
    }
}
