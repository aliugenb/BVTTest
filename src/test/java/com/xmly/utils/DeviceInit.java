package com.xmly.utils;

import com.xmly.common.ActionHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
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
            TimeUnit.SECONDS.sleep(20);
        }

//        if (DeviceModel.equals("RNE-AL00")) {
//            System.out.println("ccc");
////            ProcessUtil.execProcess(installCmd);
////            AdbUtil.installAppByAutoAccept();
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                runExec(installCmd);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("=========");
                    TimeUnit.SECONDS.sleep(5);
                    tapByCoordinates(528, 1283);
                    TimeUnit.SECONDS.sleep(5);
                    tapByCoordinates(356, 1204);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(20);
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

    public static List<String> runExec(String cmd) {
        List<String> output = new ArrayList<>();
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);
            InputStream stdin = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                output.add(line);
            }
            int exitVal = proc.waitFor();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return output;
    }

    public static void tapByCoordinates(int x, int y) throws IOException {
        ActionHelper.execCmd("adb shell input tap " + x + " " + y);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new DeviceInit().installApp("RNE-AL00");
//        new DeviceInit().tapByCoordinates(528, 1283);
    }
}
