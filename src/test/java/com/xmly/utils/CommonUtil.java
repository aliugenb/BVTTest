package com.xmly.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-13
 * Time: 18:41
 */
public class CommonUtil {

    //执行cmd
    public static String execCmd(String cmd) {
        Runtime run = Runtime.getRuntime();
        Process proc = null;
        String output = null;
        try {
            Process process = run.exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                stringBuffer.append(line + " ");
            }
            output = stringBuffer.toString().trim();
            in.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (proc != null) {
                proc.destroy();
            }
        }
        return output;
    }

    /*
     *分钟转换成毫秒
     */
    public static int formatMin(int i) {
        int timeLong = 0;
        if (i > 0) {
            timeLong = i * 60 * 1000;
        } else {
            System.out.println("输入错误");
        }
        return timeLong;
    }

    /*
    休眠时长
     */
    public static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    检查当前最顶层页面的activity
     */
    public static boolean checkFocusedActivity(String activityName) throws IOException {
        String command = "adb shell \"dumpsys activity | grep \"mFocusedActivity\"\"";
        if (System.getProperty("os.name").equals("Mac OS X")) {
            command = "adb shell dumpsys activity | grep \"mFocusedActivity\"";
        }
        String focusedActivity = null;
        focusedActivity = CommonUtil.execCmd(command);
        if (focusedActivity.indexOf("packageName") != -1) {
            return true;
        }
        return false;
    }
}
