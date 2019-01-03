package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import org.testng.annotations.Test;


/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:43 PM
 * case编号：LiveIndex_04
 * 热门分类tab存在并且有5个
 */

public class CaseCheckLiveTab extends AndroidBaseCase {
    @Test
    public void checkLiveTab() {
        basePage.enter(basePage.LiveHomePage);
        assertHelper.assertTrue(liveIndexPage.getLiveTabQty()==5,
                "判断首页tab数量=5",driver,"CaseCheckLiveTab首页tab");
    }
}
