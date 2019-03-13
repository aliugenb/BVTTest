package com.xmly.pages.live.liveindexpage;

import com.xmly.common.DriverHelper;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

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

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_type_tab_new")
    public MobileElement liveTab;

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

    //跳转创建直播间页面
    public void gotoCreateLiveRoomPage() {
        createLiveRoomBtn.click();
    }

    //通过肚脐眼进入直播间
    public void gotoUserLiveRoomByBar() {
        barPlayBtn.click();
    }

    //直播未正常关闭时弹出提醒弹层
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"结束直播\")")
    public MobileElement cancelLiveBtn;

    //关闭直播未正常关闭时首页弹出的提醒弹层
    public void liveIndexInit() {
        if (DriverHelper.isDisplayed(cancelLiveBtn)) {
            cancelLiveBtn.click();
        }
    }

    //跳转搜索页
    public void gotoSearchPage() {
        searchBar.click();
    }

    //首页直播动态入口
    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_dynamic_count_tv")
    public MobileElement liveDynamicBtn;

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
}
