package com.xmly.android.perfermance;

import com.xmly.android.action.Action;
import com.xmly.android.action.MyException;
import com.xmly.android.perfermance.handleData.Cpu;
import com.xmly.android.perfermance.handleData.DataSwitch;
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
    public void swipBanner() throws InterruptedException, IOException, MyException {
        try {

        } catch (Exception e) {
            DataSwitch.excelNormal = false;
            throw e;
        } finally {
            start = true;
            DataSwitch.cpuEnd = true;
            DataSwitch.memoryEnd = true;
        }
    }

    @Test
    public void cpuMonitor() throws IOException, InterruptedException {
        while (!start) {
            Thread.sleep(500);
            System.out.println("waiting");
        }
        new Cpu().writeExcel("首页banner轮播Cpu");
    }

    @Test
    public void memoryMonitor() throws IOException, InterruptedException {
        while (!start) {
            Thread.sleep(500);
            System.out.println("waiting");
        }
        new Memory().writeExcel("首页banner轮播Memory");
    }
}
