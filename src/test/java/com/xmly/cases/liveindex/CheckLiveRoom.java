package com.xmly.cases.liveindex;

import com.xmly.cases.BaseCase;
import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:56 PM
 * case编号：LiveIndex_04
 * 显示直播间
 */

public abstract class CheckLiveRoom extends CaseHelper {

    public static void checkLiveRoom() {
        CaseHelper.gotoLiveIndex();
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.liveRoom));
    }
}
