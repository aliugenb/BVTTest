package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:53 PM
 * case编号：LiveIndex_03
 * 显示亲密度榜
 */

public class CaseCheckLiveRecord extends CaseHelper {
    @Test(description = "检查首页显示排行榜")
    public void checkLiveRecord() throws InterruptedException {
        gotoLiveIndex();
        String recordText = liveIndexPage.gotoAnchorRankPage();
        System.out.println(recordText);
    }
}