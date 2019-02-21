package com.xmly.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/12/19
 * Time: 11:22 AM
 */
public class AppiumServer {

    public static boolean startAppium() throws IOException {
        if (isPortUsing(4723)) {
            return true;
        }
//        String cmd = "node /Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js";
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Runtime runtime = Runtime.getRuntime();
//                Process proc = null;
//                try {
//                    proc = runtime.exec(cmd);
//                    if (proc.waitFor() != 0) {
//                        System.err.println("exit value = " + proc.exitValue());
//                    }
//                } catch (InterruptedException e) {
//                    System.err.println(e);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    proc.destroy();
//                }
//            }
//        }).start();

//        Thread.sleep(10000);
        int responseCode = 0;
        responseCode = getAppiumResponseCode();
        if (responseCode == 200) {
            System.out.println("Appium-server start success");
            return true;
        }
        return false;
    }

    public static boolean stopAppium() throws IOException {
        if (!isPortUsing(4723)) {
            return true;
        }
        String killCmd = "kill -9 ";
        String[] lsofCmd = new String[]{"sh", "-c", "lsof -i :4723| awk \'{if($1~/node/)print $2}\'"};
        String pid = null;
        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(lsofCmd);
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                pid = line.toString().trim();
            }
            if (pid != null) {
                Runtime.getRuntime().exec(killCmd + pid);
                if (getAppiumResponseCode() == 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                proc.destroy();
            } catch (Exception e1) {
                System.err.print(e1);
            }
        }
        return false;
    }

    private static int getAppiumResponseCode() {
        String appiumUrl = "http://localhost:4723/wd/hub/status";
        int responseCode = 0;
        try {
            URL url = new URL(appiumUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
        }
        return responseCode;
    }

    private static boolean isPortUsing(int port) throws IOException {
        String host = "127.0.0.1";
        boolean flag = false;
        Socket socket = null;
        InetAddress theAddress = InetAddress.getByName(host);
        try {
            socket = new Socket(theAddress, port);
            flag = true;
        } catch (IOException e) {

        } finally {
            if (socket != null) {
                socket.close();
            }
        }
        return flag;
    }
}
