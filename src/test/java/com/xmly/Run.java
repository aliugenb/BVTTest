package com.xmly;

import java.nio.file.Path;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/8/10
 * Time: 下午5:11
 */

public class Run {
    public static Path logDirPath;
    public static Path screenshotDirPath;
    public static Path testNGReportPath;
    public static Path preTestNGReportPath;
    public static Path tarTestNGReportPath;


    //    public static void main(String[] args) throws IOException, InterruptedException {
//        if (stopAppium()) {
//            startAppium();
//        }
//        init();
//        Files.deleteIfExists(preTestNGReportPath);
//        try {
//            TestNG testNG = new TestNG();
//
//            List<String> suites = new ArrayList<String>();
//            suites.add("./testng.xml");
//            testNG.setTestSuites(suites);
//            testNG.run();
//            System.out.println(testNG.getStatus());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            stopAppium();
//            Files.move(preTestNGReportPath, tarTestNGReportPath, StandardCopyOption.REPLACE_EXISTING);
//        }
//    }
//
//    public static void init() throws IOException, InterruptedException {
//
//        FilesInit filesInit = new FilesInit();
//        logDirPath = Paths.get(filesInit.getLogDirPath());
//        screenshotDirPath = Paths.get(filesInit.getScreenshotDirPath());
//        testNGReportPath = Paths.get(filesInit.getTestNGReportPath());
//        preTestNGReportPath = Paths.get(filesInit.getPreTestNGReportPath());
//        tarTestNGReportPath = Paths.get(filesInit.getTarTestNGReportPath());
//        try {
//            Files.createDirectories(logDirPath);
//            Files.createDirectories(screenshotDirPath);
//            Files.createDirectories(testNGReportPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Files.deleteIfExists(preTestNGReportPath);
//        SnapshotAndLog.logByAdb(logDirPath);
//    }
//
//    public static boolean startAppium() throws IOException, InterruptedException {
//        if (isPortUsing(4723)) {
//            return true;
//        }
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
//
//        Thread.sleep(10000);
//        int responseCode = 0;
//        responseCode = getAppiumResponseCode();
//        if (responseCode == 200) {
//            System.out.println("Appium-server start success");
//        }
//        return false;
//    }
//
//    public static boolean stopAppium() throws IOException {
//        if (!isPortUsing(4723)) {
//            return true;
//        }
//        String kill_cmd = "kill -9 ";
//        String[] lsof_cmd = new String[]{"sh", "-c", "lsof -i :4723| awk \'{if($1~/node/)print $2}\'"};
//        String pid = null;
//        Process proc = null;
//        try {
//            proc = Runtime.getRuntime().exec(lsof_cmd);
//            if (proc.waitFor() != 0) {
//                System.err.println("exit value = " + proc.exitValue());
//            }
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    proc.getInputStream()));
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                pid = line.toString().trim();
//            }
//            if (pid != null) {
//                Runtime.getRuntime().exec(kill_cmd + pid);
//                if (getAppiumResponseCode() == 0) {
//                    return true;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                proc.destroy();
//            } catch (Exception e1) {
//                System.err.print(e1);
//            }
//        }
//        return false;
//    }
//
//    private static int getAppiumResponseCode() {
//        String appiumUrl = "http://localhost:4723/wd/hub/status";
//        int responseCode = 0;
//        try {
//            URL url = new URL(appiumUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
//            responseCode = connection.getResponseCode();
//        } catch (IOException e) {
//        }
//        return responseCode;
//    }
//
//    private static boolean isPortUsing(int port) throws IOException {
//        String host = "127.0.0.1";
//        boolean flag = false;
//        Socket socket = null;
//        InetAddress theAddress = InetAddress.getByName(host);
//        try {
//            socket = new Socket(theAddress, port);
//            flag = true;
//        } catch (IOException e) {
//
//        } finally {
//            if (socket != null) {
//                socket.close();
//            }
//        }
//        return flag;
//    }
}
