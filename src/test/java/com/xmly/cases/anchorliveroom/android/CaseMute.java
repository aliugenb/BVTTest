package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.anchorliveroom.Mute;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-01-31
 * Time: 15:47
 */
public class CaseMute extends Mute {

    @Test
    public static void checkMute() throws InterruptedException {
        Mute.checkMute();
    }
}
