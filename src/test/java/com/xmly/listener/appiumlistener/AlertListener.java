package com.xmly.listener.appiumlistener;

import io.appium.java_client.events.api.general.AlertEventListener;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.Credentials;


/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/9
 * Time: 上午11:04
 */
public class AlertListener implements AlertEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver, Alert alert) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver, Alert alert) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver, Alert alert) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver, Alert alert) {

    }

    @Override
    public void beforeAlertSendKeys(WebDriver driver, Alert alert, String keys) {

    }

    @Override
    public void afterAlertSendKeys(WebDriver driver, Alert alert, String keys) {

    }

    @Override
    public void beforeAuthentication(WebDriver driver, Alert alert, Credentials credentials) {

    }

    @Override
    public void afterAuthentication(WebDriver driver, Alert alert, Credentials credentials) {

    }
}
