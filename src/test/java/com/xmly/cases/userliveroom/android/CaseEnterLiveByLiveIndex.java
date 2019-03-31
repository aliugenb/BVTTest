package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.MyException;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveByLiveIndex
 * Author: ye.liu
 * Date: 2019-03-16 20:24
 * Description:
 */
public class CaseEnterLiveByLiveIndex extends CaseHelper {
    @Test(description = "首页进入直播间")
    public void enterByLiveIndex() throws MyException {
        gotoLiveIndex();
        gotoUserLiveRoomByType("");
        String roomType = userRoomIndexPage.getRoomType();
        assertHelper.assertTrue(roomType != null,
                getCurClassName() + "直播首页进入直播间");
        exitAnchorLiveRoom(roomType);
    }

    @Test(description = "直播动态进入直播间")
    public void enterByLiveDynamicPage() {
        loginByClickLiveBtn();
        liveIndexPage.gotoLiveDynamicPage();
        liveDynamicPage.enterRoomByType("");
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() != null,
                getCurClassName() + "直播动态首页进入直播间");
    }


}
