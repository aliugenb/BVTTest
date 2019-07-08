package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.MyException;
import com.xmly.pages.otherpages.PersonalPage;
import com.xmly.pages.otherpages.SearchPage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveByPersonal
 * Author: ye.liu
 * Date: 2019-03-31 19:47
 * Description:
 */
public class CaseEnterLiveByPersonal extends CaseHelper {
    @Test(description = "检查个人页进入直播间")
    public void enterByPersonal() throws MyException {
        gotoLiveIndex();
        liveIndexPage.gotoSearchPage();
        String searchText = "166620236";
        SearchPage searchPage = new SearchPage(driver);
        searchPage.gotoPersonalPage(searchText);

        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.enterLiveRoom();
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() != null,
                getCurClassName() + "主播个人页进入直播间");
    }
}
