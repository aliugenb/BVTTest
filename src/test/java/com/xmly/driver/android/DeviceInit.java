package com.xmly.driver.android;

import com.xmly.common.Status;
import com.xmly.utils.AdbUtil;
import com.xmly.utils.CommonUtil;

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
    public static void installApp(String productModel) throws IOException, InterruptedException {
        String installCmd = "adb install " + apkPath;
        String uninstallCmd = "adb uninstall com.ximalaya.ting.android";
        if (isAppInstalled()) {
            CommonUtil.execCmd(uninstallCmd);
            TimeUnit.SECONDS.sleep(20);
        }

        AdbInstall adbInstall = new AdbInstall(installCmd);
        ClickAcceptInstall clickAcceptInstall = new ClickAcceptInstall(productModel);
        adbInstall.start();
        clickAcceptInstall.start();

        TimeUnit.SECONDS.sleep(20);
        if (isAppInstalled()) {
            System.out.println("App安装成功");
            Status.isInstall = true;
            return;
        }
    }

    private static boolean isAppInstalled() throws IOException {
        String packageCmd = "adb shell pm list package | grep \"ximalaya\"";

        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(packageCmd);
        try {
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                stringBuffer.append(line + " ");
            }
            String str = stringBuffer.toString().trim();
            if (str != null) {
                System.out.println(str);
                return true;
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            try {
                proc.destroy();
            } catch (Exception e1) {
                System.err.print(e1);
                throw e1;
            }
        }
        return false;
    }
}

class AdbInstall extends Thread {
    public String cmd;

    public AdbInstall(String cmd) {
        this.cmd = cmd;
    }

    public void run() {
        CommonUtil.execCmd(cmd);
    }
}

class ClickAcceptInstall extends Thread {
    public String productModel;

    public ClickAcceptInstall(String productModel) {
        this.productModel = productModel;
    }

    public void run() {
        if (productModel.equals("RNE-AL00")) {
            System.out.println("=========");
            CommonUtil.sleep(6);
            AdbUtil.tapByCoordinates(528, 1283);
            CommonUtil.sleep(6);
            AdbUtil.tapByCoordinates(356, 1204);
        } else {
            return;
        }
    }
}

class AppInstallStatus {

}