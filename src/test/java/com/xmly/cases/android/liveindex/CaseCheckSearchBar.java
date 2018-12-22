package com.xmly.cases.android.liveindex;

import com.xmly.action.MyException;
import com.xmly.cases.android.CaseHelper;
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

public class CaseCheckSearchBar extends CaseHelper {
    @Test
    public void checkSearchBar() throws InterruptedException, IOException, MyException {
        gotoLiveHomePage();
        Assert.assertTrue(liveIndexPage.SearchBar.isDisplayed());
    }
}
