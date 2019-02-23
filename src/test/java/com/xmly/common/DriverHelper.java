package com.xmly.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
//import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/3
 * Time: 4:37 PM
 */
public class DriverHelper {

    //判断元素是否存在
    public static boolean isDisplayed(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }


    //获取元素对应的文本
    public static String getText(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                return mobileElement.getText();
            }
        } catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }

    //获取元素中心点击坐标
    public static String getCenterCoordinates(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                String coordinates = null;
                int x = mobileElement.getCenter().getX();
                int y = mobileElement.getCenter().getY();
                coordinates = "" + x + " " + y + "";
                return coordinates;
            }
        } catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }

    //根据图片点击
    public static void clickByImage(AppiumDriver driver, String imgPath) {
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
    }

    public static String getReferenceImageB64() {
        File img = new File("/Users/xmly/Desktop/bb.png");
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

    //根据坐标点击
    public static void clickByCoordinates(AppiumDriver driver, int x, int y) {
        TouchAction touchAction = new TouchAction(driver).press(PointOption.point(x, y)).release();
        touchAction.perform();
    }
}
