package com.xmly.utils;

import com.xmly.common.ActionHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

import static com.xmly.utils.FilesInit.apkPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-12
 * Time: 14:29
 */
public class DeviceInit {
    public void installApp(String DeviceModel) throws IOException, InterruptedException {
        String installCmd = "adb install " + apkPath;
        String uninstallCmd = "adb uninstall com.ximalaya.ting.android";
        if (isAppInstalled()) {
            ActionHelper.execCmd(uninstallCmd);
        }
        if (DeviceModel.equals("RNE-AL00")) {
            System.out.println("ccc");
            ProcessUtil.execProcess(installCmd);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("=========");
                        tapByCoordinates(528, 1283);
                        TimeUnit.SECONDS.sleep(2);
                        tapByCoordinates(356, 1204);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(10);
        if (isAppInstalled()) {
            System.out.println("App安装成功");
            return;
        }
    }

    private boolean isAppInstalled() throws IOException {
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

    private void tapByCoordinates(int x, int y) throws IOException {
        ActionHelper.execCmd("adb shell input tap " + x + " " + y);
    }

//    public static void main(String[] args) throws IOException, InterruptedException {
//        new DeviceInit().installApp("RNE-AL00");
////        new DeviceInit().tapByCoordinates(528, 1283);
//    }
}
