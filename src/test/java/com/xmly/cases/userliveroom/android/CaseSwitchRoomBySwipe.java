package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.MyException;
import com.xmly.common.Swipe;
import org.testng.annotations.Test;

/**
 * ClassName: CaseSwitchRoomBySwipe
 * Author: ye.liu
 * Date: 2019-03-31 20:49
 * Description:左右切换直播间
 */
public class CaseSwitchRoomBySwipe extends CaseHelper {
    @Test(description = "检查左右切换直播间")
    public void switchRoomBySwipe() throws MyException {
        gotoLiveIndex();
        gotoUserLiveRoomByType("");
        for (int i = 0; i < 10; i++) {
            Swipe.swipeRight(driver);
        }
    }
}
