package com.xmly.utils;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-13
 * Time: 17:57
 */
public enum BtnPosition {
    maimang("9999xxxx",528,1283),
    mi5("88888xxxxx",-1,-1),
    samsangS7("77777xxxxx",-1,-1);

    private String uid;
    private int x;
    private int y;

    BtnPosition(String uid, int x, int y){
        this.uid = uid;
        this.x = x;
        this.y = y;
    }

    public String getUid() {
        return uid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
