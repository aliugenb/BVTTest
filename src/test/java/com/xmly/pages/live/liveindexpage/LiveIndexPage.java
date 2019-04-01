package com.xmly.pages.live.liveindexpage;

import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Point;

import java.util.List;

/**
 * ClassName: LiveIndexPage
 * Author: ye.liu
 * Date: 2018/11/8 11:09
 * Description: 直播Tab首页
 */

public class LiveIndexPage extends BasePage {

    public LiveIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //搜索框
    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_vg_search_bar")
    public MobileElement searchBar;

    //肚脐眼
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_round_progressbar_play_progress")
    public MobileElement barPlayBtn;


    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_search_button")
    public MobileElement searchBtn; //搜索页的搜索按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search_bar_action")
    public MobileElement createLiveRoomBtn; //我要直播按钮

    //主播排行榜
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_home_anchor_rank_tv")
    public MobileElement liveRecord;

    //分类tab
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_tab_layout")
    public List<MobileElement> liveTabs;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ximalaya.ting.android.live.application:id/live_tab_layout\").childSelector(new UiSelector().text(\"音乐\"))")
    public MobileElement musicTab;

    @AndroidFindBy(uiAutomator = "(\"new UiSelector().resourceId(\"com.ximalaya.ting.android.live.application:id/live_tab_layout\").childSelector(new UiSelector().text(\"交友\"))")
    public MobileElement friendTab;

    //直播间
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_item_record_cover")
    public MobileElement liveRoom;

    //交友模式直播间
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"交友模式\")")
    public MobileElement friendRoom;

    //PK模式直播间
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"正在PK\")")
    public MobileElement pkRoom;

    //直播间列表
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_item_record_anchor_right_mark2")
    public List<MobileElement> liveRoomMarkList;

    //首页直播动态入口
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_dynamic_count_tv")
    public MobileElement liveDynamicBtn;

    //直播未正常关闭时弹出提醒弹层
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"结束直播\")")
    public MobileElement cancelLiveBtn;

    //直播未正常关闭时弹出提醒弹层
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"继续直播\")")
    public MobileElement continueLiveBtn;

    //跳转榜单页
    public String gotoAnchorRankPage() {
        String text = null;
        MobileElement record = liveRecord;
        text = record.getText();
        record.click();
        return text;
    }

    //跳转创建直播间页面
    public void gotoCreateLiveRoomPage() {
        createLiveRoomBtn.click();
    }

    //通过未关闭直播的弹窗进入直播间
    public void gotoAnchorRoomByLivePop() {
        DriverHelper.clickByPossibleElement(continueLiveBtn);
    }

    //通过肚脐眼进入直播间
    public void gotoLiveRoomByTabbarPlay() {
        barPlayBtn.click();
    }

    //进入页面第一个直播间
    public void gotoUndefinedLiveRoom() {
        liveRoom.click();
    }

    //关闭直播未正常关闭时首页弹出的提醒弹层
    private int liveInitCount = 0;

    public boolean liveIndexInit() {
        DriverHelper.clickByPossibleElement(cancelLiveBtn);
        if (DriverHelper.isDisplayed(liveRoom)) {
            liveInitCount = 0;
            return true;
        }

        liveInitCount++;
        if (liveInitCount > 5) {
            return false;
        }
        liveIndexInit();
        return false;
    }

    //跳转搜索页
    public void gotoSearchPage() {
        searchBar.click();
    }

    /*
     * Description:跳转直播动态页面
     * Param []
     * return java.lang.String 直播动态入口文案
     **/
    public String gotoLiveDynamicPage() {
        String liveDynamicText = null;
        if (liveDynamicBtn.isDisplayed()) {
            liveDynamicText = liveDynamicBtn.getText();
            liveDynamicBtn.click();
        }
        return liveDynamicText;
    }

    /*
     * @Description:交友模式和pk直播间标签会被直播动态入口遮挡，做下判断
     * @Param [liveRoomMark]
     * @return boolean
     **/
    public boolean isUnderLiveDynamicBtn(MobileElement liveRoomMark) {
        boolean flag = false;

        Point liveRoomMarkPoint = DriverHelper.getCenter(liveRoomMark);
        Point LiveDynamicBtnLowerRight = DriverHelper.getLowerRight(liveDynamicBtn);
        Point LiveDynamicBtnUpperLeft = DriverHelper.getUpperLeft(liveDynamicBtn);

        if (liveRoomMarkPoint.getX() < LiveDynamicBtnUpperLeft.getX() && liveRoomMarkPoint.getX() > LiveDynamicBtnLowerRight.getX()
                && liveRoomMarkPoint.getY() < LiveDynamicBtnUpperLeft.getY() && liveRoomMarkPoint.getY() > LiveDynamicBtnLowerRight.getY()) {
            flag = true;
        }

        return flag;
    }
}
