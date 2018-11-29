package com.xmly.cases.android.anchorliveroom;

import com.xmly.cases.android.CaseHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 22:34
 */

public class CreatAndchorLiveRoom extends CaseHelper {
    @Test
    public void create() {
        CaseHelper.gotoLiveHomePage();
        liveIndexPage.gotoCreateLiveRoomPage();
        createLiveRoomPage.BeginLiveBtn.click();
    }
}
