package com.xmly.cases.anchorliveroom;

import com.xmly.cases.BaseCase;
import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.CallPage;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:14 PM
 */
public abstract class Call extends CaseHelper {

    public static void checkCall() throws InterruptedException {
        CallPage callPage = new CallPage(driver);
        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.callBtn.click();
        assertHelper.assertTrue(
                DriverHelper.getText(callPage.onCallNum).equals("连麦未开启"),
                "判断打开连麦时默认关闭", "连麦默认关闭");
    }
}
