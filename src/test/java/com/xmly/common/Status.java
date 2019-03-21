package com.xmly.common;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/2/13
 * Time: 23:14
 */

public class Status {
    //判断app是否安装s
    volatile public static boolean isInstall = false;

    //判断app是否首次启动
    volatile public static boolean isFirstStart = true;

    //判断是否已出现过首充弹窗
    volatile public static boolean isChargePop = false;
}
