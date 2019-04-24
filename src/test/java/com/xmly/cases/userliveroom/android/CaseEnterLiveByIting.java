package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.utils.CommonUtil;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveByIting
 * Author: ye.liu
 * Date: 2019-04-16 10:34
 * Description:通过各种iting方式打开直播间,仅限Android
 */
public class CaseEnterLiveByIting extends CaseHelper {
    String cmd = "adb shell am start -a android.intent.action.VIEW -d ";

    @Test(description = "通过iting方式打开直播间")
    public void enterByType122() {
        gotoLiveIndex();
        String type122 = "iting://open?msg_type=122";
        CommonUtil.execCmd(cmd + type122);
        String roomType = userRoomIndexPage.getRoomType();
        assertHelper.assertTrue(roomType != null,
                getCurClassName() + "iting:type=122进入直播间");
        exitAnchorLiveRoom(roomType);
    }
}
