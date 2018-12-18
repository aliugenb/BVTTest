package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.CaseHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:43 PM
 * case编号：LiveIndex_04
 * 热门分类tab存在并且有5个
 */

public class CaseCheckLiveTab extends CaseHelper {
    @Test
    public void checkLiveTab() {
        gotoLiveHomePage();
        System.out.println(liveIndexPage.getLiveTabQty());
        Assert.assertEquals(liveIndexPage.getLiveTabQty(), 5);
    }
}
