package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-15
 * Time: 16:06
 */
public class CaseLiveDynamicLogin extends CaseHelper {
    @Test
    public static void checkLogin() {
        CaseHelper.gotoLiveIndex();
        String text = liveIndexPage.gotoLiveDynamicPage();
        int onlineNum = 0;
        if (text.indexOf("已关注") != 1) {
            onlineNum = Integer.parseInt(text.substring(text.indexOf("注"), text.length() - 1));
            assertHelper.assertTrue(onlineNum == liveDynamicPage.getOnlineAnchorQty(),
                    "首页显示的在线数量与直播动态内一致", "CaseLiveDynamicLogin首页显示在线数量与直播动态内不一致");
        }
    }
}
