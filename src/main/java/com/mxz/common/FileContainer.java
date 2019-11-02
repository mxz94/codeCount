package com.mxz.common;

import sun.security.jca.GetInstance;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Description 文件容器
 * @Date 2019/11/2 10:08
 * @Author mxz
 */
public class FileContainer {
    private static FileContainer fileContainer;
    private LinkedList<String> files ;
    private Set<String> fileFormat ;
    static {
        fileContainer = new FileContainer();
    }
    private FileContainer() {
        files = new LinkedList<>();
        fileFormat = new HashSet<String>();
    }

    public static FileContainer getInstance() {
        return fileContainer;
    }

    /**
     * 读取所有文件路径
     * @param path
     */
    public void handleFilePath(String path) {
        File file = new File(path);
        for (File file1 : file.listFiles()) {
            String fileSuffix = FileUtils.getFileSuffix(file1.toString());
            if (file1.isFile() && (!fileFormat.isEmpty() || fileFormat.contains(fileSuffix)))
                files.add(file1.toString());
            if (file1.isDirectory())
                handleFilePath(file1.toString());
        }
    }

    public synchronized String getFile() {
        return files.size() == 0 ? null : files.removeLast();
    }

    public  LinkedList<String> getFiles() {
        return files;
    }
}
