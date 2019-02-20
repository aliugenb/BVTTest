package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.live.anchorliveroompage.TopicPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-11
 * Time: 14:35
 */
public class CaseTopic extends CaseHelper {
    @Test(description = "主播端发布话题")
    public static void checkTopic() throws InterruptedException {

        String topicContent = "大家好";
        TopicPage topicPage = new TopicPage(driver);
        CaseHelper.createAnchorLiveRoom();

        anchorRoomIndexPage.gotoTopicPage();
        topicPage.setTopic(topicContent);

        assertHelper.assertTrue(anchorRoomIndexPage.findByContent(topicContent),
                "设置话题后直播间展示话题", "Topic没有展示设置的话题");
    }
}
