package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.otherpages.FindIndexPage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveByVoiceFriend
 * Author: ye.liu
 * Date: 2019-02-27 23:43
 * Description: 入口已关闭
 */
public class CaseEnterLiveByVoiceFriend extends CaseHelper {
    @Test(description = "通过发现页语音交友进入直播间")
    public void enterLiveByVoiceFriend() {
        gotoFindIndex();
        FindIndexPage findIndexPage = new FindIndexPage(driver);
        findIndexPage.enterLiveRoom();
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() != null,
                getCurClassName() + "搜索结果页进入直播间");
    }
}
