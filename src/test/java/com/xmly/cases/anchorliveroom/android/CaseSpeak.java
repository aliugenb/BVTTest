package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-11
 * Time: 14:52
 */
public class CaseSpeak extends CaseHelper {

    @Test(description = "主播端发言")
    public void checkSpeak() throws InterruptedException {
        String content = "大家好";

        createAnchorLiveRoom();
        anchorRoomIndexPage.speakByContent(content);
//        assertHelper.assertTrue(anchorRoomIndexPage.findByContent(content),
//                "CaseSpeak发言成功并显示发送内容");
        assertHelper.assertTrue(anchorRoomIndexPage.lastContent().getText().equals(content),
                getCurClassName() + "发言成功并显示发送内容");
    }
}
