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
    public static void checkSpeak() throws InterruptedException {
        String content = "大家好";

        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.speakByContent(content);
        assertHelper.assertTrue(anchorRoomIndexPage.findByContent(content),
                "发言后显示发送内容", "Speak没有展示发言内容");
    }
}
