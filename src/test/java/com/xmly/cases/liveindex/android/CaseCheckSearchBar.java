package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 22:45
 * case编号：LiveIndex_01
 */

public class CaseCheckSearchBar extends CaseHelper {
    @Test(description = "直播首页存在搜索框")
    public void checkSearchBar() {
        gotoLiveIndex();
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.searchBar),
                "CaseCheckSearchBar直播首页存在搜索框");
        liveIndexPage.gotoSearchPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.searchBtn),
                "CaseCheckSearchBar从直播首页跳转搜索页");
    }
}
