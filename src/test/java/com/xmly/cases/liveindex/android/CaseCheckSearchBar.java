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
    @Test(description = "首页存在搜索框")
    public static void checkSearchBar() {
        CaseHelper.gotoLiveIndex();
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(liveIndexPage.searchBar),
                "判断首页存在搜索框", "CheckSearchBar搜索框不存在");
        liveIndexPage.gotoSearchPage();
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(liveIndexPage.searchBtn),
                "判断当前在搜索页", "CheckSearchBar未跳转搜索页");
    }
}
