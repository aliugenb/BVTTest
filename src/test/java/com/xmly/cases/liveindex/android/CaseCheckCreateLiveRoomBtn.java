package com.xmly.cases.liveindex.android;

import com.xmly.cases.liveindex.CheckCreateLiveRoomBtn;
import com.xmly.common.MyException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 23:14
 * case编号：LiveIndex_02
 */

public class CaseCheckCreateLiveRoomBtn extends CheckCreateLiveRoomBtn{
    @Test
    public static void checkCreateLiveRoomBtn() throws InterruptedException, IOException, MyException {
        CheckCreateLiveRoomBtn.checkCreateLiveRoomBtn();
    }
}
