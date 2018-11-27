package com.xmly.cases.android.live;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.driver.android.AndroidDriverHelper;
import com.xmly.pages.live.RecorderPage;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/24
 * Time: 10:48 AM
 */
public class EnterRecoder extends AndroidBaseCase {

    @Test
    public static void enterRecorder() throws Exception {
        RecorderPage recorder = new RecorderPage(driver);
        recorder.enterRecorder();
        new AndroidDriverHelper().swipUpAndDownByTime(1);
    }
}
