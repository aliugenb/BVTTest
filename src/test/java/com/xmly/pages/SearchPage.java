package com.xmly.pages;

import com.xmly.common.DriverHelper;
import com.xmly.common.MyException;
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
    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_search_et")
    public MobileElement searchEditText;

    //搜索按钮
    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_search_button")
    public MobileElement searchBtn;

    //搜索结果页直播tab
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ximalaya.ting.android.main.application:id/main_id_stickynavlayout_indicator\").childSelector(new UiSelector().text(\"直播\"))")
    public MobileElement liveTabInSearchResult;

    //搜索结果页直播间入口
    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_item_record_cover")
    public MobileElement liveRoomInSearchResult;


    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_back_btn")
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
     * Description：退出搜索页
     * Param []
     * return void
     **/
    public void exitSearchPage() {
        backBtn.click();
    }

}
