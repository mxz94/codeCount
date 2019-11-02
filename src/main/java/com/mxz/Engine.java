package com.mxz;

import com.mxz.common.FileContainer;
import com.mxz.task.FileTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * @Description
 * @Date 2019/11/1 19:52
 * @Author mxz
 */
public class Engine {
    public static final String path = "E:\\mxzworkspace\\codeCount\\Netvars.cpp";
    public static int comm;
    public static int blank;

    public static void main(String[] args) throws FileNotFoundException {


//        Scanner sc = new Scanner(new File(path));
//        while (sc.hasNextLine()) {
//            String curLine = sc.nextLine().trim();
//            if (curLine.startsWith("/*")) {
//                comm ++;
//            }
//        }
        FileContainer.getInstance().handleFilePath(path);
        ForkJoinPool fjp = new ForkJoinPool();
        FileTask task = new FileTask(0, FileContainer.getInstance().getFiles().size());
        fjp.execute(task);
        task.join();
    }
}
