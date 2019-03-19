package com.xmly.cases.createliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.live.createliveroompage.UploadCoverPage;
import com.xmly.utils.SnapshotAndLog;
import org.testng.annotations.Test;

/**
 * ClassName: CreateLiveRoom
 * Author: ye.liu
 * Date: 2019-03-19 16:48
 * Description:
 */
public class CreateLiveRoom extends CaseHelper {
    @Test(description = "检查正常创建直播间")
    public void createLiveRoom() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();
        createLiveRoomPage.gotoUploadCoverPage();

        UploadCoverPage uploadCoverPage = new UploadCoverPage(driver);
        uploadCoverPage.uploadByCapture();
        SnapshotAndLog.snapshotByAppium("通过拍照上传直播间封面");

        uploadCoverPage.uploadByAlbum();
        SnapshotAndLog.snapshotByAppium("通过相册上传直播间封面");


    }
}
