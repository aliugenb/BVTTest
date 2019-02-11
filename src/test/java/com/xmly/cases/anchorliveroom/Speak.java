package com.xmly.cases.anchorliveroom;

import com.xmly.cases.CaseHelper;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-11
 * Time: 14:39
 */
public abstract class Speak extends CaseHelper {
    public static void checkSpeak() throws InterruptedException {
        String content = "大家好";

        CaseHelper.createAnchorLiveRoom();
        anchorRoomIndexPage.speakByContent(content);
        assertHelper.assertTrue(anchorRoomIndexPage.findByContent(content),
                "发言后显示发送内容", "Speak没有展示发言内容");
    }
}
