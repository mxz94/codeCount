package com.mxz.common;

import java.util.Objects;

/**
 * @Author mxz
 * @Date 2019/11/3 19:21
 **/
public class PrintUtils {

    public static void printLine() {
        System.out.println("----------------------------------------------------------");
    }

    private static final String tab3 = "            ";
    public static void printVar(Object... args) {
        for (Object arg : args) {
            System.out.print(arg + tab3);
        }
        System.out.println();
    }
}
