package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.pages.live.LiveIndexPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 22:45
 * case编号：LiveIndex_01
 */

public class caseCheckSearchBar extends AndroidBaseCase {
    @Test
    public void checkSearchBar() {
        LiveIndexPage liveIndexPage = new LiveIndexPage(driver);
        liveIndexPage.isLiveRoomSearchBarDisplayed();
    }
}
