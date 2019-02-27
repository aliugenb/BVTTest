package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import org.testng.annotations.Test;

/**
 * ClassName: CaseBullet
 * Author: ye.liu
 * Date: 2019-02-26 14:25
 * Description:
 */
public class CaseBullet extends CaseHelper {
    @Test(description = "普通弹幕")
    public void checkCommonBullet() {
        gotoLiveIndex();
        login();
        liveIndexPage.gotoUserLiveRoomByType("");
        userRoomIndexPage.gotoUserSpeakPage();
    }
}
