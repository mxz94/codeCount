package com.mxz;

import com.mxz.common.PrintUtils;

/**
 * @Description  汇总统计
 * @Date 2019/11/2 12:09
 * @Author mxz
 */
public class GatherCodes {
    private volatile int totalCount = 0;             //总行数
    private volatile int emptyCount= 0;              //空行数
    private volatile int effectiveCount =0;          //有效行数
    private volatile int commentCount = 0;           //注释行数
    private int fileCount = 0;           //注释行数
    private static GatherCodes gatherCodes;
    private GatherCodes() {
    }
    static {
        gatherCodes = new GatherCodes();
    }
    public static GatherCodes getInstance() {
        return gatherCodes;
    }
    public GatherCodes addTotalCount(int totalCount) {
        this.totalCount += totalCount;
        return this;
    }

    public GatherCodes addEmptyCount(int emptyCount) {
        this.emptyCount += emptyCount;
        return this;
    }

    public GatherCodes addEffectiveCount(int effectiveCount) {
        this.effectiveCount += effectiveCount;
        return this;
    }

    public GatherCodes addCommentCount(int commentCount) {
        this.commentCount += commentCount;
        return this;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public void print(){
        PrintUtils.printLine();
        PrintUtils.printVar("Files", "Lines", "Code", "Comments", "Blanks");
        PrintUtils.printLine();
        PrintUtils.printVar(fileCount, totalCount, effectiveCount, commentCount, emptyCount);
    }
}
