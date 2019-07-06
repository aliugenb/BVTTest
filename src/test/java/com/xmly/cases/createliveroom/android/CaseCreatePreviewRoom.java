package com.xmly.cases.createliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

/**
 * ClassName: CaseCreatePreviewRoom
 * Author: ye.liu
 * Date: 2019-03-19 22:46
 * Description:
 */
public class CaseCreatePreviewRoom extends CaseHelper {
    @Test(description = "检查创建预告直播间并立即开播")
    public void checkCreatePreview() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();
        if(DriverHelper.isDisplayed(createLiveRoomPage.editPreviewBtn)){
            createLiveRoomPage.deletePreview();
            liveIndexPage.gotoCreateLiveRoomPage();
        }
        createLiveRoomPage.createPreviewLive();

        assertHelper.assertTrue(DriverHelper.isDisplayed(createLiveRoomPage.previewTitle),
                getCurClassName() + "创建直播预告成功");

        createLiveRoomPage.exitCreate();
        liveIndexPage.gotoCreateLiveRoomPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(createLiveRoomPage.previewTitle),
                getCurClassName() + "退出预告再次进入仍显示直播预告");

        createLiveRoomPage.startPreviewLive();
        anchorRoomIndexPage.anchorRoomInit();
        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.pkBtn),
                getCurClassName() + "预告直播立即开始直播成功");
    }
}
