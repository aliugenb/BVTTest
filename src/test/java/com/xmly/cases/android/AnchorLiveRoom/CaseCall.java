package com.xmly.cases.android.AnchorLiveRoom;

import com.xmly.cases.android.CaseHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:14 PM
 */
public class CaseCall extends CaseHelper {
    @Test
    public static void checkCall() {
        CaseHelper.createAnchorLiveRoom();
    }
}
