package com.lhzs.springbootdemo;

import com.lhzs.springbootdemo.utils.MavenReleaseManager;

public class MvnPackage {
    public static void main(String[] args) {
        MavenReleaseManager.release("dev");//此处指定或application.properties中指定都可以
    }
}
