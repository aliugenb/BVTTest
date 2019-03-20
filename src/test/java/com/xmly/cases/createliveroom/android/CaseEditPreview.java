package com.xmly.cases.createliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.TopicPage;
import com.xmly.utils.SnapshotAndLog;
import org.testng.annotations.Test;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * ClassName: CaseEditPreview
 * Author: ye.liu
 * Date: 2019-03-20 16:08
 * Description:编辑及删除预告直播间
 */
public class CaseEditPreview extends CaseHelper {

    @Test(description = "检查编辑预告")
    public void editPreview() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();
        if (!DriverHelper.isDisplayed(createLiveRoomPage.previewTitle)) {
            System.out.println("已存在直播预告");
            createLiveRoomPage.createPreviewLive();
        }

        String title = "大家好";
        String topic = "随便聊聊";

        createLiveRoomPage.editPreview(title, topic);
        sleep(5);
        SnapshotAndLog.snapshotByAppium("编辑预告直播间的话题和title");

        createLiveRoomPage.startPreviewLive();
        anchorRoomIndexPage.anchroRoomInit();

        anchorRoomIndexPage.gotoTopicPage();
        TopicPage topicPage = new TopicPage(driver);
        assertHelper.assertTrue(topicPage.getTopic().equals(topic),
                getCurClassName() + "直播间更改话题正确");
    }
}
