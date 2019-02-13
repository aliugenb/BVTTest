package com.xmly.utils;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-13
 * Time: 17:57
 */


import com.xmly.common.MyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.xmly.utils.FilesInit.apkPath;

/**
 * adb 控制类
 */
public class AdbUtil {


    public static String getAndroidDeviceId() {
        String androidId = System.getenv("androidId");
        if (null == androidId || "".equalsIgnoreCase(androidId)) {
            androidId = getRandomAndroidDeviceId();
        }


        return androidId;
    }


    public static String getRandomAndroidDeviceId() {
        String id = "";

        List<String> al = getAndroidDeviceIDs();
        if (null != al && al.size() > 0) {
            int i = new Random().nextInt(al.size());
            id = al.get(i);
        }

        return id;
    }

    public static List<String> getAndroidDeviceIDs() {
        List<String> deviceIds = new ArrayList<>();

        List<String> al = runExec("adb devices");
        if (null != al) {
            for (int i = 1; i < al.size(); i++) {
                String tmpStr = al.get(i);
                if (null != tmpStr && tmpStr.contains("device")) {
                    tmpStr = tmpStr.replace("device", "").trim();
                    deviceIds.add(tmpStr);
                }
            }
        }

        return deviceIds;
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


    public static boolean isAppExist(String appName, String uid) {
        boolean result = false;
        List<String> pList = runExec("adb -s " + uid + " shell pm list packages");
        for (int i = 0; pList != null && i < pList.size(); i++) {
            String pName = pList.get(i);
            if (pName.contains(appName)) {
                result = true;
                break;
            }
        }
        if (!result) {
        }
        return result;
    }


    public static boolean installApp() {
        boolean result = false;
        String absolutPath = System.getProperty("user.dir");
        String apkFilePath = apkPath; //需要将apk文件放置在 $user.dir/androidAppium/apps 下
        String cmd = "adb install " + apkFilePath;
        List<String> al = runExec(cmd);
        for (int i = 0; al != null && i < al.size(); i++) {
            String tmpStr = al.get(i);
            if (tmpStr != null && tmpStr.contains("Success")) {
                result = true;
                break;
            }
        }

        if (!result) {
        }

        return result;
    }


    public static boolean installAppByAutoAccept() {
        boolean result = false;

        InstallAndroidApp installAndroidApp = new InstallAndroidApp();
        ClickAcceptAndroidDevice clickAcceptAndroidDevice = new ClickAcceptAndroidDevice();

        installAndroidApp.start(); //启动安装线程
        clickAcceptAndroidDevice.start(); //启动点击接受线程

        boolean loop = true;
        long start = System.currentTimeMillis();
        while (loop) {
            long now = System.currentTimeMillis();
            long running = (now - start) / 1000; //一共运行的时长(秒数)
            if (installAndroidApp.finish && clickAcceptAndroidDevice.finished || running >= 15) { //安装与点击任务都完成 或者 运行时间大于15秒 就退出while循环
                loop = false;
                result = true;
            }

            waiting(1);
        }

        return result;
    }


    public static boolean uninstallApp(String appPackageName, String uid) {
        boolean result = false;
        String cmd = "adb -s " + uid + " uninstall " + appPackageName;
        List<String> al = runExec(cmd);
        if (al != null && al.size() > 0 && al.get(0) != null && al.get(0).contains("Success")) {
            result = true;
        } else {
        }

        return result;
    }

    /**
     * 单击动作
     *
     * @param uid
     * @param x   坐标x轴
     * @param y   坐标y轴
     * @return
     */
    public static boolean clickAccept(String uid, int x, int y) {
        boolean result = false;
        String cmd = "adb -s " + uid + " shell input tap " + 528 + " " + 1283;
        System.out.println(cmd);
        waiting(3); //等三秒
        runExec(cmd);

        return result;
    }


    public static void waiting(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //获取非appium的输入法
    public static String getInputMethod() throws IOException, MyException {
        String inputMethod = null;
        List<String> inputMethods = new ArrayList<>();
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec("adb shell ime list -s");
        try {
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                inputMethods.add(line.toString().trim());
            }

            if (inputMethods.size() == 1 && inputMethods.indexOf("io.appium.android.ime/.UnicodeIME") == 0) {
                throw new MyException("请安装其他三方输入法");
            } else {
                if (inputMethods.indexOf("io.appium.android.ime/.UnicodeIME") > 0) {
                    inputMethod = inputMethods.get(0);
                } else if (inputMethods.indexOf("io.appium.android.ime/.UnicodeIME") == 0) {
                    inputMethod = inputMethods.get(1);
                } else {
                    throw new MyException("没有安装appium输入法");
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            try {
                proc.destroy();
            } catch (Exception e1) {
                System.err.print(e1);
            }
        }
        return inputMethod;
    }
}
