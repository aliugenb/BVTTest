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
 * 主播端连麦功能
 */
public abstract class Call extends CaseHelper {

    public static void checkCall() throws InterruptedException {
        CallPage callPage = new CallPage(driver);
        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.gotoCallPage();
        assertHelper.assertTrue(
                DriverHelper.getText(callPage.onCallNum).equals("连麦未开启"),
                "判断打开连麦面板时默认关闭", "Call打开连麦面板时连麦未默认关闭");

        callPage.switchCall(); //开启连麦
        assertHelper.assertTrue(DriverHelper.getText(callPage.onCallNum).contains("连麦接通"),
                "判断连麦开启", "Call连麦没有正确开启");

        callPage.switchCall(); //关闭连麦
        assertHelper.assertTrue(
                DriverHelper.getText(callPage.onCallNum).equals("连麦未开启"),
                "判断连麦关闭", "Call连麦没有正确关闭");
    }
}
