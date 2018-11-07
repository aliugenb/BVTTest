package com.xmly.android.listener.appiumlistener;

import io.appium.java_client.events.api.general.WindowEventListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/9
 * Time: 上午11:19
 */
public class WindowListener implements WindowEventListener {
    @Override
    public void beforeWindowChangeSize(WebDriver driver, WebDriver.Window window, Dimension targetSize) {

    }

    @Override
    public void afterWindowChangeSize(WebDriver driver, WebDriver.Window window, Dimension targetSize) {

    }

    @Override
    public void beforeWindowIsMoved(WebDriver driver, WebDriver.Window window, Point targetPoint) {

    }

    @Override
    public void afterWindowIsMoved(WebDriver driver, WebDriver.Window window, Point targetPoint) {

    }

    @Override
    public void beforeWindowIsMaximized(WebDriver driver, WebDriver.Window window) {

    }

    @Override
    public void afterWindowIsMaximized(WebDriver driver, WebDriver.Window window) {

    }
}
