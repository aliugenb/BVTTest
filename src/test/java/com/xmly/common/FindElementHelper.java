package com.xmly.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * ClassName: FindElement
 * Author: ye.liu
 * Date: 2019-02-26 19:48
 * Description: 封装部分查找元素的方法
 */
public class FindElementHelper {

    /*
     * @Description: 滑动查找元素
     * @Param [driver, element]
     * @return io.appium.java_client.MobileElement
     **/
    public static MobileElement findElementBySwipe(AppiumDriver driver, MobileElement element, int step, String direction) {
        int start = 0;
        while (start < step) {
            try {
                if (element.isDisplayed()) {
                    return element;
                }
            } catch (NoSuchElementException e) {
                switch (direction) {
                    case SwipeDirection.UP:
                        Swipe.swipeUp(driver);
                        break;
                    case SwipeDirection.DOWN:
                        Swipe.swipeDown(driver);
                        break;
                    case SwipeDirection.RIGHT:
                        Swipe.swipeRight(driver);
                        break;
                    case SwipeDirection.LEFT:
                        Swipe.swipeLeft(driver);
                        break;
                }
            }
            start++;
        }
        throw new NoSuchElementException("未没找到相应元素");
    }

    /*
     * @Description: android根据uiautomator查找元素
     * @Param [driver]
     * @return void
     **/
    public static MobileElement findElementByAndroidUIAutomator(AppiumDriver driver, String uiobject) {
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(uiobject));
    }

    /*
     * @Description:根据图片查找元素
     * @Param [driver, imgPath]
     * @return io.appium.java_client.MobileElement
     **/
    public static MobileElement findElemnetByImage(AppiumDriver driver, String imgPath) {
        MobileElement element = null;
//        String imgFile = imgPath;
//        InputStream in = null;
//        byte[] data = null;
//        try {
//            in = new FileInputStream(imgFile);
//            data = new byte[in.available()];
//            in.read(data);
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Base64 base64 = new Base64();
//        String b64Img = new String(base64.encodeBase64(data));
        String b64Img = getReferenceImageB64();
        System.out.println(b64Img);
        Reporter.log(String.valueOf(driver.findElementByImage(b64Img).isDisplayed()));
        if (driver.findElementByImage(b64Img).isDisplayed()) {
            driver.findElementByImage(b64Img).click();
            System.out.println("点击成功");
        }
        return element;
    }

    public static String getReferenceImageB64() {
        File img = new File("/Users/xmly/Desktop/aa.png");
//        URL refImgUrl = getClass().getClassLoader().getResource("Edition031_Reference_Image.png");
        File refImgFile = Paths.get(img.toURI()).toFile();
//        File refImgFile = new File("/Users/xmly/Documents/xmly/Uitest/src/test/java/com/xmly/pages/live/aa.png");
        String b64 = null;
        try {
            b64 = Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b64;
    }
}
