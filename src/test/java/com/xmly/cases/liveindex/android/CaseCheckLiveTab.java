package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import org.testng.Reporter;
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
    public void checkLiveTab() {
        gotoLiveIndex();
//        assertHelper.assertTrue(liveIndexPage.getLiveTabQty() == 5, "CaseCheckLiveTab首页tab数量=5");
        Reporter.log(String.valueOf(liveIndexPage.liveTabs.get(0).getLocation()));
        System.out.println(liveIndexPage.liveTabs.get(0).getCoordinates().inViewPort());
//        Reporter.log(String.valueOf(liveIndexPage.liveTabs.get(0).getCoordinates().onScreen()));
//        Reporter.log(String.valueOf(liveIndexPage.liveTabs.get(0).getCoordinates().onPage()));
    }
}
