package com.mxz.task.juge;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Description 保存当前文件的行数状态信息
 * @Date 2019/11/2 12:06
 * @Author mxz
 */
public abstract class JudgeCode {
    protected int totalCount = 0;             //总行数
    protected int emptyCount= 0;              //空行数
    protected int effectiveCount =0;          //有效行数
    protected int commentCount = 0;           //注释行数

    /**
     * 进行处理文件进行读取
     * @param file
     */
    public abstract void judge(File file) throws FileNotFoundException;

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
