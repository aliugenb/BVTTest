package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.MyException;
import com.xmly.pages.SearchPage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveRoomByPath
 * Author: ye.liu
 * Date: 2019-03-16 20:24
 * Description:
 */
public class CaseEnterLiveRoomByPath extends CaseHelper {
    @Test(description = "首页进入直播间")
    public void enterByLiveIndex() throws MyException {
        gotoLiveIndex();
        gotoUserLiveRoomByType("");
        String roomType = userRoomIndexPage.getRoomType();
        assertHelper.assertTrue(roomType != null,
                getCurClassName() + "直播首页进入直播间");
        exitAnchorLiveRoom(roomType);
    }

    @Test(description = "直播动态进入直播间")
    public void enterByLiveDynamicPage() {
        loginByClickLiveBtn();
        liveIndexPage.gotoLiveDynamicPage();
        liveDynamicPage.enterRoomByType("");
        String roomType = userRoomIndexPage.getRoomType();
        assertHelper.assertTrue(roomType != null,
                getCurClassName() + "直播动态首页进入直播间");
        exitAnchorLiveRoom(roomType);
        liveDynamicPage.exitLiveDynamicPage();
    }

    @Test(description = "通过搜索结果页进入直播间")
    public void enterBySearch() throws MyException {
        liveIndexPage.gotoSearchPage();
        String searchText = "倾城之恋_";
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterLiveRoomBySearch(searchText);
        String roomType = userRoomIndexPage.getRoomType();
        assertHelper.assertTrue(roomType != null,
                getCurClassName() + "搜索结果页进入直播间");
        exitAnchorLiveRoom(roomType);
    }
}
