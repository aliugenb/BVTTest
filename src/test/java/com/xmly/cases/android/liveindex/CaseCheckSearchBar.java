package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.common.DriverHelper;
import com.xmly.common.MyException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 22:45
 * case编号：LiveIndex_01
 */

public class CaseCheckSearchBar extends AndroidBaseCase {
    @Test
    public void checkSearchBar() throws InterruptedException, IOException, MyException {
        basePage.enter(basePage.LiveHomePage);
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(liveIndexPage.searchBar),
                "判断首页存在搜索框", driver, "CaseCheckSearchBar搜索框不存在");
        liveIndexPage.gotoSearchPage();
        assertHelper.assertTrue(
                DriverHelper.isDisplayed(liveIndexPage.searchBtn),
                "判断当前在搜索页", driver, "CaseCheckSearchBar未跳转搜索页");
    }
}
