package com.xmly.cases.createliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

/**
 * ClassName: CaseDeletePreview
 * Author: ye.liu
 * Date: 2019-03-20 17:06
 * Description:删除直播预告
 */
public class CaseDeletePreview extends CaseHelper {
    @Test(description = "检查删除预告")
    public void deletePreview() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();
        if(!DriverHelper.isDisplayed(createLiveRoomPage.previewTitle)){
            System.out.println("已存在直播预告");
            createLiveRoomPage.createPreviewLive();
        }
        createLiveRoomPage.deletePreview();

        liveIndexPage.gotoCreateLiveRoomPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(createLiveRoomPage.createPreviewLiveBtn),
                getCurClassName() + "删除预告重新进入需重新显示创建预告按钮");
    }
}
