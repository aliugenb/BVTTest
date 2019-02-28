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
 * 热门分类tab存在并且有5个
 */

public class CaseCheckLiveTab extends CaseHelper {
    @Test
    public void checkLiveTab() {
        gotoLiveIndex();
        assertHelper.assertTrue(liveIndexPage.liveTabs.size() == 5, "CaseCheckLiveTab首页tab数量=5");

        Point initialPoint = liveIndexPage.liveTabs.get(0).getLocation();

        int liveTabX = DriverHelper.getLowerRight(liveIndexPage.liveTabs.get(0)).getX();
        int initialLiveTabY = DriverHelper.getUpperLeft(liveIndexPage.liveTabs.get(0)).getY();

        int targetLiveTabY = DriverHelper.getLowerRight(liveIndexPage.searchBar).getY();

        //滑动tab到顶部
        Swipe.swipeByCoordinates(liveTabX, initialLiveTabY, liveTabX, targetLiveTabY, driver);

        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.liveTabs.get(0)),
                getCurClassName() + "上滑到顶部后位置固定");


        Swipe.swipeByCoordinates(liveTabX, targetLiveTabY, liveTabX, initialLiveTabY, driver);
        Swipe.swipeDown(driver);
        sleep(2);
        assertHelper.assertTrue(liveIndexPage.liveTabs.get(0).getLocation() == initialPoint,
                getCurClassName() + "下滑后恢复到默认位置");
    }
}
