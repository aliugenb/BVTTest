package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.pages.live.LiveIndexPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 23:14
 * case编号：LiveIndex_02
 */

public class CaseCheckCreateLiveRoomBtn extends AndroidBaseCase {
    @Test
    public void checkCreateLiveRoomBtn(){
        LiveIndexPage liveIndexPage = new LiveIndexPage(driver);
        liveIndexPage.isCreateLiveRoomBtnDisplayed();
    }
}
