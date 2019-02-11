package com.xmly.cases.liveindex;

import com.xmly.cases.BaseCase;
import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.MyException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 22:45
 * case编号：LiveIndex_01
 */

public abstract class CheckSearchBar extends CaseHelper {

    public static void checkSearchBar() throws InterruptedException, IOException, MyException {
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
