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

        int liveTabX = DriverHelper.getLowerRight(liveIndexPage.liveTabs.get(0)).getX();
        int initialLiveTabY = DriverHelper.getUpperLeft(liveIndexPage.liveTabs.get(0)).getY();

        int targetLiveTabY = DriverHelper.getLowerRight(liveIndexPage.searchBar).getY();

        //滑动tab到顶部
        Swipe.swipeByCoordinates(liveTabX, initialLiveTabY, liveTabX, targetLiveTabY, driver);
        Swipe.swipeUp(driver);
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.liveTabs.get(0)),
                getCurClassName() + "上滑到顶部后位置固定不隐藏");

        //滑动tab到初始位置
        Swipe.swipeByCoordinates(liveTabX, targetLiveTabY, liveTabX, initialLiveTabY, driver);
        Swipe.swipeDown(driver);
        sleep(2);
        Point lastPoint = liveIndexPage.liveTabs.get(0).getLocation();
        assertHelper.assertTrue((initialPoint.getX() == lastPoint.getX()) && (initialPoint.getY() == lastPoint.getY()),
                getCurClassName() + "下滑后恢复到默认位置");
    }
}
