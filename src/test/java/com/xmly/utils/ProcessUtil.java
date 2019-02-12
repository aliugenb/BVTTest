package com.xmly.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-12
 * Time: 17:46
 */
public class ProcessUtil {

    public static void execProcess(String cmdStr) {
        Process process = null;
        try {
            System.out.println(cmdStr);
            process = Runtime.getRuntime().exec(cmdStr);
//            new ProcessClearStream(process.getInputStream(), "INFO").start();
//            new ProcessClearStream(process.getErrorStream(), "ERROR").start();

            final InputStream is1 = process.getInputStream();
            //获取进城的错误流
            final InputStream is2 = process.getErrorStream();
            //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
            new Thread() {
                public void run() {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
                    try {
                        String line1 = null;
                        while ((line1 = br1.readLine()) != null) {
                            if (line1 != null) {
//                                System.out.println(line1);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            is1.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
                    try {
                        String line2 = null;
                        while ((line2 = br2.readLine()) != null) {
                            if (line2 != null) {
//                                System.out.println(line2);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            is2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();


            int status = process.waitFor();

            System.out.println("return value:"+status);
            System.out.println(process.exitValue());
            byte[] bytes = new byte[process.getInputStream().available()];
            process.getInputStream().read(bytes);
            System.out.println(new String(bytes));

            System.out.println("Process exitValue: " + status);
        } catch (Exception e) {
            try {
                process.getErrorStream().close();

                process.getInputStream().close();
                process.getOutputStream().close();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("执行" + cmdStr + "出现错误，" + e.toString());
        } finally {
            if (process != null) {
                process.destroy();
            }
            process = null;
        }
    }

}

//class ProcessClearStream extends Thread {
//    private InputStream inputStream;
//    private String type;
//
//    ProcessClearStream(InputStream inputStream, String type) {
//        this.inputStream = inputStream;
//        this.type = type;
//    }
//
//    public void run() {
//        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(
//                    inputStream);
//            BufferedReader br = new BufferedReader(inputStreamReader);
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                System.out.println(type + ">" + line);
//            }
//            //while (br.readLine() != null) ;
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } finally {
//            i
//        }
//    }
//}
