package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.live.anchorliveroompage.PicturePage;
import org.testng.annotations.Test;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * ClassName: CaseSendPicture
 * Author: ye.liu
 * Date: 2019-03-18 19:21
 * Description:
 */

public class CaseSendPicture extends CaseHelper {
    @Test(description = "主播端发送图片")
    public void sendPicture() {
        createAnchorLiveRoom();
        anchorRoomIndexPage.gotoPicturePage();

        PicturePage picturePage = new PicturePage(driver);
        picturePage.sendPicture();

        sleep(10);

        assertHelper.assertTrue(anchorRoomIndexPage.lastContent().getAttribute("className").equals("android.widget.ImageView"),
                getCurClassName() + "发送图片成功");
    }
}
