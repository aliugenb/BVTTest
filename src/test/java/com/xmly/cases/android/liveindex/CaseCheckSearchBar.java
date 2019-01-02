package com.xmly.cases.android.liveindex;

import com.xmly.action.MyException;
import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.utils.SnapshotAndLog;
import org.testng.Assert;
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
//        basePage.enter(basePage.LiveHomePage);
//        Assert.assertTrue(liveIndexPage.SearchBar.isDisplayed());
        SnapshotAndLog.snapshotByAppium(driver,"aaaa");
        Assert.assertTrue(1==2);
        assertHelper.assertTrue(3==4);
        System.out.println("++++++++++");
//
//        assertHelper.assertAll();
    }
}
