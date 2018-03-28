package com.lhzs.springbootdemo.utils;

import java.io.*;

/**
 * @author jiangjie
 * 2018-03-22
 */
public class MavenReleaseManager {

    public static void release() {
        exeCommand(null);
    }

    public static void release(String env) {
        exeCommand(env);
    }

    private static void exeCommand(String env) {
        try {
            String projectPath = System.getProperty("user.dir");
            String command = "cd " + projectPath + "\n" + "mvn package -DskipTests";
            if (env != null) {
                command = "cd " + projectPath + "\n" + "mvn package -P " + env + " -DskipTests";
            }
            File batFile = new File(projectPath, "release.sh");
            if (!batFile.exists()) {
                batFile.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(batFile));
            osw.write(command);
            osw.close();
            Process process = Runtime.getRuntime().exec(batFile.getAbsolutePath());
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String temp;
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
            }
            br.close();
            batFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
