package com.xmly.common;

import com.google.common.base.Function;
import io.appium.java_client.AppiumDriver;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/9
 * Time: 2:52 PM
 */

public interface ExpectedConditionForAppium<T> extends Function<AppiumDriver, T> {
}
