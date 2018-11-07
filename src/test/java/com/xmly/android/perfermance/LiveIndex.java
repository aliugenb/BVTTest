package com.xmly.android.perfermance;

import com.xmly.android.action.Action;
import com.xmly.android.action.MyException;
import com.xmly.android.perfermance.handleData.Cpu;
import com.xmly.android.perfermance.handleData.DataSwitch;
import com.xmly.android.perfermance.handleData.Fps;
import com.xmly.android.perfermance.handleData.Memory;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/10/12
 * Time: 11:02 AM
 */
public class LiveIndex extends Action {
    private boolean start = false;

    @Test
    public void swipList() throws InterruptedException, IOException, MyException {
        try {
            driver.findElementByAndroidUIAutomator("text(\"发现\")").click();
            sleep(5000);
            start = true;
            swipUpAndDownByTime(5);
        } catch (Exception e) {
            DataSwitch.excelNormal = false;
            throw e;
        } finally {
            start = true;
            DataSwitch.fpsEnd = true;
        }
    }

    @Test
    public void fpsMonitor() throws IOException, InterruptedException {
        while (!start) {
            Thread.sleep(500);
            System.out.println("waiting");
        }
        new Fps().writeExcel("首页fps");
    }
}
