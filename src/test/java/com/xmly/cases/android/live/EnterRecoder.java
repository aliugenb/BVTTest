package com.xmly.cases.android.live;

import com.xmly.cases.android.AndroidBaseCase;
import com.xmly.pages.LiveIndexPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/24
 * Time: 10:48 AM
 */
public class EnterRecoder extends AndroidBaseCase {

    @Test
    public static void enterRecorder() {
        LiveIndexPage liveIndexPage = new LiveIndexPage(driver);
        liveIndexPage.enterRecorder();
    }
}
