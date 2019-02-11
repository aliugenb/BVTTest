package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.anchorliveroom.Speak;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-11
 * Time: 14:52
 */
public class CaseSpeak extends Speak {

    @Test
    public static void checkSpeak() throws InterruptedException {
        Speak.checkSpeak();
    }
}
