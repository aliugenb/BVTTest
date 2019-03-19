package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.AnchorEndLivePage;
import org.testng.annotations.Test;

/**
 * ClassName: CaseAncheorExitRoom
 * Author: ye.liu
 * Date: 2019-03-19 15:11
 * Description:退出主播端直播间
 */
public class CaseAncheorExitRoom extends CaseHelper {
    @Test(description = "检查退出主播直播间")
    public void exitAnchorRoom() {
        createAnchorLiveRoom();
        anchorRoomIndexPage.exitAnchorLive();

        AnchorEndLivePage anchorEndLivePage = new AnchorEndLivePage(driver);
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorEndLivePage.saveToAlbumPop),
                getCurClassName() + "主播端退出直播间出现保存专辑页面");

        anchorEndLivePage.cancelSave();
        assertHelper.assertTrue(anchorEndLivePage.upperLeftSaveBtn.getText().equals("保存回听"),
                getCurClassName() + "取消保存后左上角展示保存回听");

        anchorEndLivePage.saveToAlbum();
        assertHelper.assertTrue(anchorEndLivePage.upperLeftSaveBtn.getText().equals("已保存回听"),
                getCurClassName() + "重新保存后左上角展示已保存回听");
    }
}
