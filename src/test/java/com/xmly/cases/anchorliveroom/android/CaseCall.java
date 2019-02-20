package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.CallPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 4:27 PM
 */
public class CaseCall extends CaseHelper {
    @Test(description = "连麦开关功能正常")
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
