package com.xmly.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 5:12 PM
 */


public class ActionHelper {


    // 检查当前页面最上层的activity是否在指定packageName
    public static boolean checkPackage(String packageName) throws IOException {
        String command = "adb shell \"dumpsys activity | grep \"mFocusedActivity\"\"";
        if (System.getProperty("os.name").equals("Mac OS X")) {
            command = "adb shell dumpsys activity | grep \"mFocusedActivity\"";
        }
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command);
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
            if (str.indexOf("packageName") != -1) {
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
