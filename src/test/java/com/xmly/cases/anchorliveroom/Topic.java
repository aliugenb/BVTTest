package com.xmly.cases.anchorliveroom;

import com.xmly.cases.BaseCase;
import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.pages.live.anchorliveroompage.TopicPage;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-11
 * Time: 13:56
 * 主播端发布话题
 */
public abstract class Topic extends CaseHelper {

    public static void checkTopic() throws InterruptedException {

        String topicContent = "大家好";
        TopicPage topicPage = new TopicPage(driver);
        CaseHelper.createAnchorLiveRoom();

        anchorRoomIndexPage.gotoTopicPage();
        topicPage.setTopic(topicContent);

        assertHelper.assertTrue(anchorRoomIndexPage.findByContent(topicContent),
                "设置话题后直播间展示话题","Topic没有展示设置的话题");
    }
}
