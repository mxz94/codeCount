package com.mxz.common;

import java.io.File;
import java.util.*;

/**
 * @Description 文件容器
 * @Date 2019/11/2 10:08
 * @Author mxz
 */
public class FileContainer {
    private static FileContainer fileContainer;
    private LinkedList<String> files ;
    static {
        fileContainer = new FileContainer();
    }
    private FileContainer() {
        files = new LinkedList<String>();
    }

    public static FileContainer getInstance() {
        return fileContainer;
    }

    /**
     * 读取所有文件路径
     * @param path
     */
    public void handleFilePath(String path, String suffix) {
        File file = new File(path);
        for (File file1 : file.listFiles()) {
            //file1.getName().matches(".*\\.c$");
            if (file1.isFile() && (suffix.contains(FileUtils.getFileSuffix(file1.getName()))))
                files.add(file1.toString());
            if (file1.isDirectory())
                handleFilePath(file1.toString(), suffix);
        }
    }


    public synchronized String getFile() {
        return files.size() == 0 ? null : files.removeLast();
    }

    public  LinkedList<String> getFiles() {
        return files;
    }
}
