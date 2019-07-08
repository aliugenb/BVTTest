package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.MyException;
import com.xmly.pages.otherpages.SearchPage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveBySearch
 * Author: ye.liu
 * Date: 2019-02-24 22:36
 * Description:
 */
public class CaseEnterLiveBySearch extends CaseHelper {
    @Test(description = "通过搜索结果页进入直播间")
    public void enterBySearch() throws MyException {
        gotoLiveIndex();
        liveIndexPage.gotoSearchPage();
        String searchText = "音动_24H娱乐";
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterLiveRoomBySearch(searchText);
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() != null,
                getCurClassName() + "搜索结果页进入直播间");
    }
}
