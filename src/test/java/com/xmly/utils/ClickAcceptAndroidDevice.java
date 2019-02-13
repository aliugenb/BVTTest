package com.xmly.utils;

import org.apache.logging.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-13
 * Time: 17:56
 */
public class ClickAcceptAndroidDevice extends Thread{
    boolean finished;

    public ClickAcceptAndroidDevice(){
        finished = false;
    }

    @Override
    public void run() {
        String uid = AdbUtil.getAndroidDeviceId();
        int x = 0 ,y = 0;

        //从btnPosition中获取X,Y坐标
        for(int i = 0; i < BtnPosition.values().length; i++){
            String tmp_id = BtnPosition.values()[i].getUid();
            if(tmp_id.equalsIgnoreCase(uid)){
                x = BtnPosition.values()[i].getX();
                y = BtnPosition.values()[i].getY();
                break;
            }
        }

        if(x == -1 && y == -1){ //处理安装没有弹窗点击同意的情形
            finished = true;
            return;
        }

        AdbUtil.clickAccept(uid, x, y);
        finished = true;
    }
}
