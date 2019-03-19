package com.xmly.pages.live;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-18
 * Time: 17:38
 * 直播间类型
 */
public interface RoomType {
    //PK直播间
    String PK = "pk";
    //交友模式直播间
    String FRIEND = "friend";
    //普通直播间
    String COMMON = "common";
    //结束的直播间
    String END = "end";
    //预告直播间
    String PREVIEW = "preview";
}
