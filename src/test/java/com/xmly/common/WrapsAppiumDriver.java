package com.xmly.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WrapsDriver;

/**
 * ClassName: WrapsAppiumDriver
 * Author: ye.liu
 * Date: 2019-03-21 13:49
 * Description:
 */
public interface WrapsAppiumDriver extends WrapsDriver {
    AppiumDriver getWrappedDriver();
}
