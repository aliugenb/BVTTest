package com.xmly.cases.createliveroom.android;

import com.xmly.cases.CaseHelper;
import org.testng.annotations.Test;

/**
 * ClassName: CreatePreviewRoom
 * Author: ye.liu
 * Date: 2019-03-19 22:46
 * Description:
 */
public class CreatePreviewRoom extends CaseHelper {
    @Test(description = "检查创建预告直播间")
    public void checkCreatePreview() {
        gotoLiveIndex();
        loginByClickLiveBtn();
        liveIndexPage.gotoCreateLiveRoomPage();


    }
}
