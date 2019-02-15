package com.xmly.pages.live;

import com.xmly.common.DriverHelper;
import com.xmly.driver.Driver;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/8
 * Time: 11:09 AM
 * 直播Tab首页
 */

public class LiveIndexPage extends BasePage {

    public LiveIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //搜索框
    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search")
    public MobileElement searchBar;

    //跳转搜索页
    public void gotoSearchPage() {
        searchBar.click();
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_search_button")
    public MobileElement searchBtn; //搜索页的搜索按钮

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search_bar_action")
    public MobileElement createLiveRoomBtn; //我要直播按钮

    //跳转创建直播间页面
    public void gotoCreateLiveRoomPage() {
        createLiveRoomBtn.click();
    }

    /*
    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"亲度周榜\")"),
            @AndroidBy(uiAutomator = "new UiSelector().text(\"小时榜\")"),
            @AndroidBy(uiAutomator = "new UiSelector().text(\"周榜\")"),
            @AndroidBy(uiAutomator = "new UiSelector().text(\"日周榜\")"),})
    */
    //主播排行榜
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_home_anchor_rank_tv")
    public MobileElement liveRecord;

    //跳转榜单页
    public String gotoAnchorRankPage() {
        String text = null;
        MobileElement record = liveRecord;
        text = record.getText();
        record.click();
        return text;
    }

    //分类tab
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_tab_layout")
    public List<MobileElement> liveTabs;

    public int getLiveTabQty() {
        return liveTabs.size();
    }

    //直播间
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_item_record_cover")
    public MobileElement liveRoom;

    /*
     *首页进入直播间
     */
    public void gotoUserLiveRoomPage() {
        liveRoom.click();
    }

    //直播未正常关闭时弹出提醒弹层
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"结束直播\")")
    public MobileElement cancelLiveBtn;

    //关闭直播未正常关闭时首页弹出的提醒弹层
    public void endLive() {
        if (DriverHelper.isDisplayed(cancelLiveBtn)) {
            cancelLiveBtn.click();
        }
    }

    //首页直播动态入口
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_dynamic_count_tv")
    public MobileElement liveDynamicBtn;

    //点击直播动态，并且获取当前文案
    public String gotoLiveDynamicPage() {
        String liveDynamicText = null;
        if (liveDynamicBtn.isDisplayed()) {
            liveDynamicText = liveDynamicBtn.getText();
            liveDynamicBtn.click();
        }
        return liveDynamicText;
    }
}
