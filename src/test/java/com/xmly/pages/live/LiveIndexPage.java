package com.xmly.pages.live;

import com.xmly.common.DriverHelper;
import com.xmly.common.Swipe;
import com.xmly.driver.Driver;
import com.xmly.pages.BasePage;
import com.xmly.pages.live.userliveroompage.RoomType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //肚脐眼
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/host_round_progressbar_play_progress")
    public MobileElement barPlayBtn;


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

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_item_record_anchor_right_mark2")
    public List<MobileElement> liveRoomMarkList;

    /*
     * @首页进入不同类型直播间
     * @roomType为空时，进入任意直播间
     * @首页滑动3次
     */
    public void gotoUserLiveRoomByType(String roomType) {
        if (roomType == null || roomType.equals("")) {
            liveRoom.click();
        } else {
            int start = 0;
            while (start < 3) {
                Map<String, MobileElement> liveRoomList = getLiveRoomList();
                for (String key : liveRoomList.keySet()) {
                    if (key == roomType) {
                        liveRoomList.get(key).click();
                        return;
                    }
                }
                Swipe.SwipeDown(driver);
                start++;
            }
            throw new NoSuchElementException("无这种类型的直播间");
        }
    }

    private Map<String, MobileElement> getLiveRoomList() {
        Map<String, MobileElement> liveRoomList = new HashMap<>();
        for (MobileElement liveRoom : liveRoomMarkList) {
            String roomMark = liveRoom.getText();
            String roomType = null;
            if (roomMark.contains("PK")) {
                roomType = RoomType.PK;
            } else if (roomMark.contains("交友")) {
                roomType = RoomType.Friend;
            } else {
                roomType = RoomType.COMMON;
            }
            liveRoomList.put(roomType, liveRoom);
        }
        return liveRoomList;
    }

    /*
    通过肚脐眼进入直播间
     */
    public void gotoUserLiveRoomByBar() {
        barPlayBtn.click();
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

    /*
    跳转搜索页
     */
    public void gotoSearchPage() {
        searchBar.click();
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
