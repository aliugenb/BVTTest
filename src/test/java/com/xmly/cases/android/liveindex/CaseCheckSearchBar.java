package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.common.MyException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 22:45
 * case编号：LiveIndex_01
 * 搜索框
 */

public class CaseCheckSearchBar extends AndroidBaseCase {
    @Test
    public void checkSearchBar() throws InterruptedException, IOException, MyException {
        basePage.enter(basePage.LiveHomePage);
//        assertHelper.assertTrue(liveIndexPage.SearchBar.isDisplayed(), "检查搜索框存在", driver);
        assertHelper.assertTrue(1==2, "搜索框存在", driver,"搜索框不存在");
    }
}
