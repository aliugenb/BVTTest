package com.xmly.cases.liveindex.android;

import com.xmly.cases.liveindex.CheckLiveRoom;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:56 PM
 * case编号：LiveIndex_04
 * 显示直播间
 */

public class CaseCheckLiveRoom extends CheckLiveRoom {
    @Test
    public static void checkLiveRecord() {
        CheckLiveRoom.checkLiveRoom();
    }
}
