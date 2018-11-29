package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.CaseHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:56 PM
 * case编号：LiveIndex_04
 * 显示直播间
 */

public class CaseCheckLiveRoom extends CaseHelper {
    @Test
    public void checkLiveRecord() {
        gotoLiveHomePage();
        Assert.assertTrue(liveIndexPage.liveRoom.isDisplayed());
    }
}
