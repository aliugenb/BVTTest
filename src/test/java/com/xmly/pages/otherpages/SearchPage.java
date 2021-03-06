package com.xmly.pages.otherpages;

import com.xmly.common.DriverHelper;
import com.xmly.common.MyException;
import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * ClassName: SearchPage
 * Author: ye.liu
 * Date: 2019-03-16 22:54
 * Description:
 */
public class SearchPage extends BasePage {
    public SearchPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    //搜索输入框
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/search_search_et")
    public MobileElement searchEditText;

    //搜索按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/search_search_button")
    public MobileElement searchBtn;

    //搜索结果页直播tab
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ximalaya.ting.android:id/search_id_stickynavlayout_indicator\").childSelector(new UiSelector().text(\"直播\"))")
    public MobileElement liveTabInSearchResult;

    //搜索结果页主播tab
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ximalaya.ting.android:id/search_id_stickynavlayout_indicator\").childSelector(new UiSelector().text(\"主播\"))")
    public MobileElement anchorTabInSearchResult;

    //主播tab下正在直播的主播
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/search_live_status")
    public MobileElement liveAnchor;

    //搜索结果页直播间入口
    @AndroidFindBy(id = "com.ximalaya.ting.android:id/search_item_record_cover")
    public MobileElement liveRoomInSearchResult;


    @AndroidFindBy(id = "com.ximalaya.ting.android:id/search_back_btn")
    public MobileElement backBtn;

    /*
     * Description：通过搜索结果页进入直播间
     * Param []
     * return void
     **/
    public void enterLiveRoomBySearch(String searchText) throws MyException {
        if (searchText == null) {
            throw new MyException("搜索文案传入错误");
        }
        searchEditText.sendKeys(searchText);
        searchBtn.click();
        sleep(5);
        if (!DriverHelper.isDisplayed(liveTabInSearchResult)) {
            throw new MyException("搜索结果没有直播间");
        }
        liveTabInSearchResult.click();
        liveRoomInSearchResult.click();
    }

    /*
     * Description：搜索结果页进入主播个人页
     * Param [searchText]
     * return void
     **/
    public void gotoPersonalPage(String searchText) throws MyException {
        if (searchText == null) {
            throw new MyException("搜索文案传入错误");
        }
        searchEditText.sendKeys(searchText);
        searchBtn.click();
        sleep(5);
        if (!DriverHelper.isDisplayed(anchorTabInSearchResult)) {
            throw new MyException("搜索结果没有主播");
        }
        anchorTabInSearchResult.click();
        liveAnchor.click();
    }

    /*
     * Description：退出搜索页
     * Param []
     * return void
     **/
    public void exitSearchPage() {
        backBtn.click();
    }

}
