package com.xmly.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/9
 * Time: 2:38 PM
 */
public class AppiumDriverWait extends FluentWait {

    private final AppiumDriver driver;

    public AppiumDriverWait(AppiumDriver driver, long timeOutInSeconds) {
        this(driver, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
    }

    public AppiumDriverWait(AppiumDriver driver, long timeOutInSeconds, long sleepInMillis) {
        this(driver, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
    }
    
    public AppiumDriverWait(AppiumDriver driver, Clock clock, Sleeper sleeper, long timeOutInSeconds,
                            long sleepTimeOut) {
        super(driver, clock, sleeper);
        withTimeout(java.time.Duration.ofSeconds(timeOutInSeconds));
        pollingEvery(java.time.Duration.ofMillis(sleepTimeOut));
        ignoring(NotFoundException.class);
        this.driver = driver;
    }

    @Override
    protected RuntimeException timeoutException(String message, Throwable lastException) {
        WebDriver exceptionDriver = driver;
        TimeoutException ex = new TimeoutException(message, lastException);
        ex.addInfo(WebDriverException.DRIVER_INFO, exceptionDriver.getClass().getName());
        while (exceptionDriver instanceof WrapsDriver) {
            exceptionDriver = ((WrapsDriver) exceptionDriver).getWrappedDriver();
        }
        if (exceptionDriver instanceof RemoteWebDriver) {
            RemoteWebDriver remote = (RemoteWebDriver) exceptionDriver;
            if (remote.getSessionId() != null) {
                ex.addInfo(WebDriverException.SESSION_ID, remote.getSessionId().toString());
            }
            if (remote.getCapabilities() != null) {
                ex.addInfo("Capabilities", remote.getCapabilities().toString());
            }
        }
        throw ex;
    }
}
