package com.xmly.cases.liveindex.android;

import com.aventstack.extentreports.ExtentReports;
import com.xmly.cases.CaseHelper;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-15
 * Time: 16:06
 */
public class CaseLiveDynamicLogin extends CaseHelper {
    @Test(description = "未登录情况下进入直播动态")
    public static void checkLogin() {
        CaseHelper.gotoLiveIndex();
        String text = liveIndexPage.gotoLiveDynamicPage();
        int onlineNum = 0;
        if (text.indexOf("已关注") != -1) {
            onlineNum = getQty(text);
            assertHelper.assertTrue(onlineNum == liveDynamicPage.getOnlineAnchorQty(),
                    "CaseLiveDynamicLogin首页显示的在线数量与直播动态内一致");
        }
    }

    private static int getQty(String str) {
        int qty = 0;
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            String num = m.replaceAll("").trim();
            qty = Integer.parseInt(num);
        }
        return qty;
    }
}
