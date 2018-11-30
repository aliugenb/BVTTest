package com.xmly.action;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 5:50 PM
 */
public class AssertHelper extends Assertion {
    public AssertHelper() {
        super();
    }

    @Override
    protected void doAssert(IAssert<?> assertCommand) {
        super.doAssert(assertCommand);
    }

    @Override
    public void executeAssert(IAssert<?> assertCommand) {
        super.executeAssert(assertCommand);
    }

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
        super.onAssertSuccess(assertCommand);
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand) {
        super.onAssertFailure(assertCommand);
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        super.onAssertFailure(assertCommand, ex);
    }

    @Override
    public void onBeforeAssert(IAssert<?> assertCommand) {
        super.onBeforeAssert(assertCommand);
    }

    @Override
    public void onAfterAssert(IAssert<?> assertCommand) {
        super.onAfterAssert(assertCommand);
    }

    @Override
    public void assertTrue(boolean condition, String message) {
        super.assertTrue(condition, message);
    }

    @Override
    public void assertTrue(boolean condition) {
        super.assertTrue(condition);
    }

    @Override
    public void assertFalse(boolean condition, String message) {
        super.assertFalse(condition, message);
    }

    @Override
    public void assertFalse(boolean condition) {
        super.assertFalse(condition);
    }

    @Override
    public void fail(String message, Throwable realCause) {
        super.fail(message, realCause);
    }

    @Override
    public void fail(String message) {
        super.fail(message);
    }

    @Override
    public void fail() {
        super.fail();
    }

    @Override
    public <T> void assertEquals(T actual, T expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public <T> void assertEquals(T actual, T expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(String actual, String expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(String actual, String expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(double actual, double expected, double delta, String message) {
        super.assertEquals(actual, expected, delta, message);
    }

    @Override
    public void assertEquals(double actual, double expected, double delta) {
        super.assertEquals(actual, expected, delta);
    }

    @Override
    public void assertEquals(float actual, float expected, float delta, String message) {
        super.assertEquals(actual, expected, delta, message);
    }

    @Override
    public void assertEquals(float actual, float expected, float delta) {
        super.assertEquals(actual, expected, delta);
    }

    @Override
    public void assertEquals(long actual, long expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(long actual, long expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(boolean actual, boolean expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(boolean actual, boolean expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(byte actual, byte expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(byte actual, byte expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(char actual, char expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(char actual, char expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(short actual, short expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(short actual, short expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(int actual, int expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(int actual, int expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertNotNull(Object object) {
        super.assertNotNull(object);
    }

    @Override
    public void assertNotNull(Object object, String message) {
        super.assertNotNull(object, message);
    }

    @Override
    public void assertNull(Object object) {
        super.assertNull(object);
    }

    @Override
    public void assertNull(Object object, String message) {
        super.assertNull(object, message);
    }

    @Override
    public void assertSame(Object actual, Object expected, String message) {
        super.assertSame(actual, expected, message);
    }

    @Override
    public void assertSame(Object actual, Object expected) {
        super.assertSame(actual, expected);
    }

    @Override
    public void assertNotSame(Object actual, Object expected, String message) {
        super.assertNotSame(actual, expected, message);
    }

    @Override
    public void assertNotSame(Object actual, Object expected) {
        super.assertNotSame(actual, expected);
    }

    @Override
    public void assertEquals(Collection<?> actual, Collection<?> expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(Collection<?> actual, Collection<?> expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(Object[] actual, Object[] expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEqualsNoOrder(Object[] actual, Object[] expected, String message) {
        super.assertEqualsNoOrder(actual, expected, message);
    }

    @Override
    public void assertEquals(Object[] actual, Object[] expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEqualsNoOrder(Object[] actual, Object[] expected) {
        super.assertEqualsNoOrder(actual, expected);
    }

    @Override
    public void assertEquals(byte[] actual, byte[] expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(byte[] actual, byte[] expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(Set<?> actual, Set<?> expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertEquals(Set<?> actual, Set<?> expected, String message) {
        super.assertEquals(actual, expected, message);
    }

    @Override
    public void assertEquals(Map<?, ?> actual, Map<?, ?> expected) {
        super.assertEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(Object actual, Object expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(Object actual, Object expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(String actual, String expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(String actual, String expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(long actual, long expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(long actual, long expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(boolean actual, boolean expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(boolean actual, boolean expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(byte actual, byte expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(byte actual, byte expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(char actual, char expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(char actual, char expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(short actual, short expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(short actual, short expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(int actual, int expected, String message) {
        super.assertNotEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(int actual, int expected) {
        super.assertNotEquals(actual, expected);
    }

    @Override
    public void assertNotEquals(float actual, float expected, float delta, String message) {
        super.assertNotEquals(actual, expected, delta, message);
    }

    @Override
    public void assertNotEquals(float actual, float expected, float delta) {
        super.assertNotEquals(actual, expected, delta);
    }

    @Override
    public void assertNotEquals(double actual, double expected, double delta, String message) {
        super.assertNotEquals(actual, expected, delta, message);
    }

    @Override
    public void assertNotEquals(double actual, double expected, double delta) {
        super.assertNotEquals(actual, expected, delta);
    }
}
