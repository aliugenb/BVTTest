package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.CaseHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:53 PM
 * case编号：LiveIndex_03
 * 显示亲密度榜
 */

public class CaseCheckLiveRecord extends CaseHelper {
    @Test
    public void checkLiveRecord() {
        gotoLiveHomePage();
        Assert.assertTrue(liveIndexPage.liveRecord.isDisplayed());
    }
}