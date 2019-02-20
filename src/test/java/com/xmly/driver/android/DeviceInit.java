package com.xmly.driver.android;

import com.xmly.common.Status;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.CommonUtil;
import org.testng.Reporter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import static com.xmly.utils.FilesInit.apkPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/2/13
 * Time: 21:25
 */

public class DeviceInit {
    public static void installApp(String productModel) {
        String installCmd = "adb install " + apkPath;
        String uninstallCmd = "adb uninstall com.ximalaya.ting.android";
        if (isAppInstalled()) {
            CommonUtil.execCmd(uninstallCmd);
            CommonUtil.sleep(20);
        }

        AdbInstall adbInstall = new AdbInstall(installCmd);
        ClickAcceptInstall clickAcceptInstall = new ClickAcceptInstall(productModel);
        adbInstall.start();
        clickAcceptInstall.start();

        while (true) {
            if (isAppInstalled()) {
                Reporter.log("App安装成功");
                Status.isInstall = true;
                return;
            }
            CommonUtil.sleep(3);
        }
    }

    private static boolean isAppInstalled() {
        String packageCmd = "adb shell pm list package | grep \"ximalaya\"";
        String result = CommonUtil.execCmd(packageCmd);
        System.out.println(result);
//        if (result != null) {
        if (result.contains("ximalaya")) {
            return true;
        }
        return false;
    }

    private static class AdbInstall extends Thread {
        public String cmd;

        public AdbInstall(String cmd) {
            this.cmd = cmd;
        }

        public void run() {
            CommonUtil.execCmd(cmd);
        }
    }

    private static class ClickAcceptInstall extends Thread {
        public String productModel;

        public ClickAcceptInstall(String productModel) {
            this.productModel = productModel;
        }

        public void run() {
            if (productModel.equals("RNE-AL00")) {
                CommonUtil.sleep(6);
                AdbUtil.tapByCoordinates(528, 1283);
                CommonUtil.sleep(10);
                AdbUtil.tapByCoordinates(356, 1204);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        DeviceInit.installApp("RNE-AL00");
    }
}