package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.cases.android.CaseHelper;
import com.xmly.pages.live.LiveIndexPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 23:14
 * case编号：LiveIndex_02
 * 检查存在我要直播按钮
 */

public class CaseCheckCreateLiveRoomBtn extends CaseHelper {
    @Test
    public static void checkCreateLiveRoomBtn(){
        gotoLiveHomePage();
        Assert.assertTrue(liveIndexPage.createLiveRoomBtn.isDisplayed());
    }
}
