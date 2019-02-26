# Uitest



###Uiautomator常用
>参考：
http://appium.io/docs/en/writing-running-appium/android/uiautomator-uiselector/

1. 滑动查找元素<br>
```new UiScrollable(new UiSelector().resourceId(\"\")).scrollIntoView(new UiSelector().text(\"\"))```
2. 根据text查找元素<br>
```new UiSelector().text("")```