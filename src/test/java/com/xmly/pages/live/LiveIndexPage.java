package com.xmly.pages.live;

import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
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

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search_bar_action")
    public MobileElement SearchBar; //搜索框

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search_bar_action")
    public MobileElement createLiveRoomBtn; //我要直播按钮

    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"亲密度周榜\")"),
            @AndroidBy(id = "com.ximalaya.ting.android.liveindex.application:id/live_home_anchor_rank_tv")})
    public MobileElement liveRecord; //排行榜

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_tab_layout")
    public List<MobileElement> liveTabs; //分类tab

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_item_record_cover")
    public MobileElement liveRoom; //直播间

    public int getLiveTabQty() {
        return liveTabs.size();
    }

    //跳转创建直播间页面
    public void gotoCreateLiveRoomPage() {
        createLiveRoomBtn.click();
    }

    //首页进入直播间
    public void gotoUserLiveRoomPage() {
        liveRoom.click();
    }
}
