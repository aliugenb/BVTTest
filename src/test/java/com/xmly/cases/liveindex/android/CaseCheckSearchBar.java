package com.xmly.cases.liveindex.android;

import com.xmly.cases.liveindex.CheckSearchBar;
import com.xmly.common.MyException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 22:45
 * case编号：LiveIndex_01
 */

public class CaseCheckSearchBar extends CheckSearchBar {
    @Test
    public static void checkSearchBar() throws InterruptedException, IOException, MyException {
        CheckSearchBar.checkSearchBar();
    }
}
