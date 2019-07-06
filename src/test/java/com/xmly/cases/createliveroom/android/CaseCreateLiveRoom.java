package com.xmly.cases.createliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.TopicPage;
import com.xmly.pages.live.createliveroompage.UploadCoverPage;
import com.xmly.utils.SnapshotAndLog;
import org.testng.annotations.Test;

import static com.xmly.utils.CommonUtil.sleep;

/**
 * ClassName: CaseCreateLiveRoom
 * Author: ye.liu
 * Date: 2019-03-19 16:48
 * Description:创建立即开播的直播间
 */
public class CaseCreateLiveRoom extends CaseHelper {

    @Test(description = "检查正常创建直播间")
    public void createLiveRoom() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();
        if(DriverHelper.isDisplayed(createLiveRoomPage.previewTitle)){
            createLiveRoomPage.deletePreview();
            liveIndexPage.gotoCreateLiveRoomPage();
        }
        createLiveRoomPage.gotoUploadCoverPage();

        UploadCoverPage uploadCoverPage = new UploadCoverPage(driver);
        uploadCoverPage.uploadByCapture();
        sleep(5);
        SnapshotAndLog.snapshotByAppium("通过拍照上传直播间封面");

        createLiveRoomPage.gotoUploadCoverPage();
        uploadCoverPage.uploadByAlbum();
        sleep(5);
        SnapshotAndLog.snapshotByAppium("通过相册上传直播间封面");

        String title = "大家好";
        String topic = "随便聊聊";
        createLiveRoomPage.setTitle(title);
        createLiveRoomPage.setTopic(topic);

        createLiveRoomPage.setCategory();
        sleep(3);
        SnapshotAndLog.snapshotByAppium("设置直播间标签为有声书");

        createLiveRoomPage.createAnchorRoom();
        anchorRoomIndexPage.anchorRoomInit();

        assertHelper.assertTrue(DriverHelper.isDisplayed(anchorRoomIndexPage.pkBtn),
                getCurClassName() + "创建直播成功");
        anchorRoomIndexPage.gotoTopicPage();
        TopicPage topicPage = new TopicPage(driver);
        assertHelper.assertTrue(topicPage.getTopic().equals(topic),
                getCurClassName() + "直播间设置话题正确");
    }
}
