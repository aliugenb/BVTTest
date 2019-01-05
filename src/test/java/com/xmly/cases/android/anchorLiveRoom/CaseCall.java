package com.xmly.cases.android.anchorLiveRoom;

import com.xmly.cases.android.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.AnchorLiveRoomPage.CallPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:14 PM
 */
public class CaseCall extends CaseHelper {

    static CallPage callPage = new CallPage(driver);

    @Test
    public static void checkCall() throws InterruptedException {
        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.callBtn.click();
        assertHelper.assertTrue(
                DriverHelper.getText(callPage.onCallNum).equals("连麦开启"),
                "判断打开连麦时默认关闭", driver, "连麦默认打开");
    }
}
