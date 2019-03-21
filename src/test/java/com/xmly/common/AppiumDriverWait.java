package com.xmly.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ClassName: AppiumDriverWait
 * Author: ye.liu
 * Date: 2019-03-21 11:23
 * Description:
 */
public class AppiumDriverWait extends FluentWait<AppiumDriver> {

    private final AppiumDriver driver;

    /**
     * Wait will ignore instances of NotFoundException that are encountered (thrown) by default in
     * the 'until' condition, and immediately propagate all others.  You can add more to the ignore
     * list by calling ignoring(exceptions to add).
     *
     * @param driver           The WebDriver instance to pass to the expected conditions
     * @param timeOutInSeconds The timeout in seconds when an expectation is called
     * @see WebDriverWait#ignoring(java.lang.Class)
     */
    public AppiumDriverWait(AppiumDriver driver, long timeOutInSeconds) {
        this(
                driver,
                java.time.Clock.systemDefaultZone(),
                Sleeper.SYSTEM_SLEEPER,
                timeOutInSeconds,
                DEFAULT_SLEEP_TIMEOUT);
    }

    /**
     * Wait will ignore instances of NotFoundException that are encountered (thrown) by default in
     * the 'until' condition, and immediately propagate all others.  You can add more to the ignore
     * list by calling ignoring(exceptions to add).
     *
     * @param driver           The WebDriver instance to pass to the expected conditions
     * @param timeOutInSeconds The timeout in seconds when an expectation is called
     * @param sleepInMillis    The duration in milliseconds to sleep between polls.
     * @see WebDriverWait#ignoring(java.lang.Class)
     */
    public AppiumDriverWait(AppiumDriver driver, long timeOutInSeconds, long sleepInMillis) {
        this(
                driver,
                java.time.Clock.systemDefaultZone(),
                Sleeper.SYSTEM_SLEEPER,
                timeOutInSeconds,
                sleepInMillis);
    }

    /**
     * @param driver           The WebDriver instance to pass to the expected conditions
     * @param clock            The clock to use when measuring the timeout
     * @param sleeper          Object used to make the current thread go to sleep.
     * @param timeOutInSeconds The timeout in seconds when an expectation is
     * @param sleepTimeOut     The timeout used whilst sleeping. Defaults to 500ms called.
     */
    public AppiumDriverWait(
            AppiumDriver driver,
            java.time.Clock clock,
            Sleeper sleeper,
            long timeOutInSeconds,
            long sleepTimeOut) {
        super(driver, clock, sleeper);
        withTimeout(Duration.ofSeconds(timeOutInSeconds));
        pollingEvery(Duration.ofMillis(sleepTimeOut));
        ignoring(NotFoundException.class);
        this.driver = driver;
    }

    @Override
    protected RuntimeException timeoutException(String message, Throwable lastException) {
        AppiumDriver exceptionDriver = driver;
        TimeoutException ex = new TimeoutException(message, lastException);
        ex.addInfo(WebDriverException.DRIVER_INFO, exceptionDriver.getClass().getName());
        while (exceptionDriver instanceof WrapsAppiumDriver) {
            exceptionDriver = ((WrapsAppiumDriver) exceptionDriver).getWrappedDriver();
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
