package com.xmly.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * ClassName: ReportUtil
 * Author: ye.liu
 * Date: 2019-03-06 16:30
 * Description:
 */
public class ReportUtil {

    public static void reportByDingDing() throws IOException {
        String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=bd1124386fa17ac91e9f8386d59d98a2dd199746f200c6be07b4c6303e0f85e1";
        String reportPath = "http://192.168.62.79:10086/job/appiumtest/TestNG_20Report/";

        HttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost(WEBHOOK_TOKEN);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"执行完成，戳这" + reportPath + "\"},\"at\":{\"atMobiles\": [\"18918955916\"],\"isAtAll\": false}}";
//        String textMsg = "{\"msgtype\":\"link\",\"link\":{\"text\":\"群机器人是钉钉群的高级扩展功能。群机器人可以将第三方服务的信息聚合到群聊中，实现自动化的信息同步。例如：通过聚合GitHub，GitLab等源码管理服务，实现源码更新同步；通过聚合Trello，JIRA等项目协调服务，实现项目信息同步。不仅如此，群机器人支持Webhook协议的自定义接入，支持更多可能性，例如：你可将运维报警提醒通过自定义机器人聚合到钉钉群。\",\"title\":\"自定义机器人协议\",\"picUrl\":\"\",\"messageUrl\":\"https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.Rqyvqo&treeId=257&articleId=105735&docType=1\",\"at\":{\"atMobiles\": [\"18918955916\"],\"isAtAll\": false}}}";
//        String textMsg = "{\"msgtype\":\"markdown\",\"markdown\":{\"title\":\"直播ui测试\",\"text\":\"#### 直播ui测试  \\n @18918955916 \\n\\n > ![screenshot](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551876224024&di=1726dde2dd69e90755e374952a38c662&imgtype=0&src=http%3A%2F%2Fi.3001.net%2Fuploads%2FUp_imgs%2F20180125-44cded4a9cc7f838af8657f4894e485b.png)\\n  > ###### 18点20分发布 [戳这](" + reportPath + ") \"},\"at\":{\"atMobiles\":[\"18918955916\"],\"isAtAll\":false}}";
        StringEntity se = new StringEntity(textMsg, "utf-8");
        httppost.setEntity(se);

        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }

    }

    public static void main(String[] args) throws IOException {
        reportByDingDing();
    }
}
