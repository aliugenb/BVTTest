package com.xmly.cases.anchorLiveRoom.android;

import com.xmly.cases.AndroidBaseCase;
import com.xmly.cases.anchorLiveRoom.Call;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 4:27 PM
 */
public class CaseCall extends Call {
    @Test
    public static void checkCall() throws InterruptedException {
        Call.checkCall();
    }
}
