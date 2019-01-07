package com.xmly.cases.liveindex;

import com.xmly.cases.BaseCase;


/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:43 PM
 * case编号：LiveIndex_04
 * 热门分类tab存在并且有5个
 */

public abstract class CheckLiveTab extends BaseCase {

    public static void checkLiveTab() {
        basePage.enter(basePage.LiveHomePage);
        assertHelper.assertTrue(liveIndexPage.getLiveTabQty()==5,
                "判断首页tab数量=5",driver,"CaseCheckLiveTab首页tab");
    }
}
