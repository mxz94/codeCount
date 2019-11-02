package com.mxz.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Description 保存当前文件的行数状态信息
 * @Date 2019/11/2 12:06
 * @Author mxz
 */
public class JudgeCode {
    private int totalCount = 0;             //总行数
    private int emptyCount= 0;              //空行数
    private int effectiveCount =0;          //有效行数
    private int commentCount = 0;           //注释行数
    private boolean normalStatus = true;

    /**
     * 进行处理文件进行读取
     * @param file
     */
    public void Judge(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file, "utf-8");
        while (sc.hasNextLine()) {
            totalCount++;
            String line = sc.nextLine().trim();
            // 正常非注释状态
            if (line.equals("")) {
                emptyCount++;
            } else if (normalStatus) {
                if (line.startsWith("//")) {
                    commentCount++;
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    commentCount++;
                } else if (line.startsWith("/*")) {
                    // 参见/*  打头  */结尾 不在同一行              设置为待结束状态
                    normalStatus = false;
                    commentCount++;
                } else if (!normalStatus && line.endsWith("")) {
                    effectiveCount++;
                }
            } else {
                int i = line.lastIndexOf("*/");
            }
            /*
            *
             */  /* sad */ int a;// a
        }
    }

    /**
     * adsda
     *
     */ int a; // asdsada


    /**
     * adsda
     *
     */ // asdsada

    public int getTotalCount() {
        return totalCount;
    }

    public int getEmptyCount() {
        return emptyCount;
    }

    public int getEffectiveCount() {
        return effectiveCount;
    }

    public int getCommentCount() {
        return commentCount;
    }
}
