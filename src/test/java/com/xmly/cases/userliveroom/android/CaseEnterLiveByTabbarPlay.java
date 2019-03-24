package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.MyException;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveByTabbarPlay
 * Author: ye.liu
 * Date: 2019-03-24 23:48
 * Description:
 */
public class CaseEnterLiveByTabbarPlay extends CaseHelper {
    @Test(description = "通过肚脐眼进入直播间")
    public void enterByTabbarPlay() throws MyException {
        gotoLiveIndex();
        gotoUserLiveRoomByType("");
        String anchorName = userRoomIndexPage.getAnchorName();

        exitAnchorLiveRoom(userRoomIndexPage.getRoomType());

        liveIndexPage.gotoLiveRoomByTabbarPlay();

        assertHelper.assertTrue(userRoomIndexPage.getAnchorName().equals(anchorName),
                getCurClassName() + "肚脐眼进入同一直播间正常");
    }
}
