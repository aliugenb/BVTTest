package com.xmly.cases.liveindex.android;

import com.xmly.cases.liveindex.CheckLiveRecord;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:53 PM
 * case编号：LiveIndex_03
 * 显示亲密度榜
 */

public class CaseCheckLiveRecord extends CheckLiveRecord{
    @Test
    public static void checkLiveRecord() throws InterruptedException {
        CheckLiveRecord.checkLiveRecord();
    }
}