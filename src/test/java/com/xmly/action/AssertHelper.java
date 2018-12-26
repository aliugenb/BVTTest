package com.xmly.action;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 5:50 PM
 */
public class AssertHelper extends SoftAssert {
    @Override
    protected void doAssert(IAssert<?> a) {
        super.doAssert(a);
    }

    @Override
    public void assertAll() {
        super.assertAll();
    }
}
