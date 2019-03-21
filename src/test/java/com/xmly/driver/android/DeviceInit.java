package com.xmly.driver.android;

import com.xmly.common.Status;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.CommonUtil;
import org.testng.Reporter;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.xmly.utils.CommonUtil.execCmd;
import static com.xmly.utils.CommonUtil.sleep;
import static com.xmly.utils.FilesInit.apkPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/2/13
 * Time: 21:25
 */

public class DeviceInit {
    public static void installApp(String productModel) throws FileNotFoundException {
        String installCmd = "adb install " + apkPath;
        if (!Files.exists(Paths.get(apkPath))) {
            throw new FileNotFoundException("apk文件未找到");
        }
        if (isAppInstalled()) {
            AdbUtil.uninstallApp("com.ximalaya.ting.android");
            sleep(10);
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
            sleep(3);
        }
    }

    private static boolean isAppInstalled() {
        String packageCmd = "adb shell pm list package | grep \"ximalaya\"";
        String result = execCmd(packageCmd);
        System.out.println(result);
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
            execCmd(cmd);
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
                CommonUtil.sleep(20);
                AdbUtil.tapByCoordinates(356, 1204);
            } else {
                return;
            }
        }
    }
}