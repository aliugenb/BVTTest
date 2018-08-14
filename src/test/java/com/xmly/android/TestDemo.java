package com.xmly.android;

import com.xmly.android.action.Action;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/8
 * Time: 下午4:10
 */
public class TestDemo extends Action {

    @Test
    public void start() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"直播\")").click();
        sleep(5000);
    }
}
