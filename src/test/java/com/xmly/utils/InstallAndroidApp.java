package com.xmly.utils;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-13
 * Time: 17:55
 */
public class InstallAndroidApp extends Thread{
    boolean finish;
    String apkFileName ;
    String uid;

    public InstallAndroidApp(){
        finish = false;
        this.apkFileName = apkFileName;
        this.uid = uid;
    }

    @Override
    public void run() {
        AdbUtil.installApp();
        finish = true;
    }
}
