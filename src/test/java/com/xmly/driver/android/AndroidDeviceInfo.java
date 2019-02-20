package com.xmly.driver.android;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.xmly.utils.CommonUtil.execCmd;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/8
 * Time: 下午4:08
 */

public class AndroidDeviceInfo {
    private String OsVersion;
    private String DeviceName;
    private String ProductModel;


    public String getOsVersion() {
        return OsVersion;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public String getProductModel() {
        return ProductModel;
    }

    public AndroidDeviceInfo() {
        String version = execCmd("adb shell getprop ro.build.version.release");
        String deviceName = execCmd("adb devices");
        String productModel = execCmd("adb shell getprop ro.product.model");
        Pattern r = Pattern.compile("attached(.*)device");
        Matcher m = r.matcher(deviceName);
        this.OsVersion = version;
        if (m.find()) {
            this.DeviceName = m.group(1).trim();
        }
        this.ProductModel = productModel.trim();
    }

//    private static String GetInfo(String cmd) {
//        Runtime run = Runtime.getRuntime();
//        String info = null;
//        try {
//            Process process = run.exec(cmd);
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    process.getInputStream()));
//            StringBuffer stringBuffer = new StringBuffer();
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                stringBuffer.append(line + " ");
//            }
//            info = stringBuffer.toString();
//            in.close();
//            process.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return info;
//    }
}

