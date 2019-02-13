package com.xmly.utils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-13
 * Time: 18:41
 */
public class CommonUtil {

    //分钟转换成毫秒
    public static int formatMin(int i) {
        int timeLong = 0;
        if (i > 0) {
            timeLong = i * 60 * 1000;
        } else {
            System.out.println("输入错误");
        }
        return timeLong;
    }



    //执行cmd
    public static void execCmd(String cmd) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(cmd);

        try {
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            proc.destroy();
        }
    }

    //休眠时长
    public static void sleep(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }
}
