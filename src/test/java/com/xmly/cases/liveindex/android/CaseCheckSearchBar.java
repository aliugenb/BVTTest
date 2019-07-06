package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.otherpages.SearchPage;
import org.testng.annotations.Test;

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
                getCurClassName() + "直播首页存在搜索框");
        liveIndexPage.gotoSearchPage();
        SearchPage searchPage = new SearchPage(driver);
        assertHelper.assertTrue(DriverHelper.isDisplayed(searchPage.searchBtn),
                getCurClassName() + "从直播首页跳转搜索页");
    }
}
