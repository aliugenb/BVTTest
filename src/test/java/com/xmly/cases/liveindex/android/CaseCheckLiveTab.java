package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import org.openqa.selenium.Point;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:43 PM
 */

public class CaseCheckLiveTab extends CaseHelper {
    @Test(description = "直播间首页tab滑动")
    public void checkLiveTab() {
        gotoLiveIndex();
        assertHelper.assertTrue(liveIndexPage.liveTabs.size() == 5, "CaseCheckLiveTab首页tab数量=5");

        Point initialPoint = liveIndexPage.liveTabs.get(0).getLocation();


        //滑动tab到顶部
        for (int i = 0; i < 2; i++) {
            Swipe.swipeUp(driver);
        }
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.liveTabs.get(0)),
                getCurClassName() + "上滑到顶部后位置固定不隐藏");

        //滑动tab到初始位置
        for (int i = 0; i < 3; i++) {
            Swipe.swipeDown(driver);
        }
        sleep(5);
        Point lastPoint = liveIndexPage.liveTabs.get(0).getLocation();
        assertHelper.assertTrue((initialPoint.getX() == lastPoint.getX()) && (initialPoint.getY() == lastPoint.getY()),
                getCurClassName() + "下滑后恢复到默认位置");
    }
}
