package com.xmly.common;

import com.xmly.utils.SnapshotAndLog;
import io.appium.java_client.AppiumDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 5:50 PM
 */
public class SoftAssert extends Assertion {
    // LinkedHashMap to preserve the order
    private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();

    @Override
    protected void doAssert(IAssert<?> a) {
        onBeforeAssert(a);
        try {
            a.doAssert();
            onAssertSuccess(a);
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            m_errors.put(ex, a);
        } finally {
            onAfterAssert(a);
        }
    }

    public void assertAll(AppiumDriver driver, String fileName) {
        if (!m_errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append("\n\t");
                sb.append(ae.getKey().getMessage());
                SnapshotAndLog.snapshotByAppium(driver, fileName);
            }
            throw new AssertionError(sb.toString());
        }
    }
}
