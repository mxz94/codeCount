package com.mxz.task;

import com.mxz.GatherCodes;
import com.mxz.common.FileContainer;
import com.mxz.task.juge.CPPJudgeCode;
import com.mxz.task.juge.JudgeCode;
import com.mxz.task.juge.RubyJudgeCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @Description
 * @Date 2019/11/2 11:01
 * @Author mxz
 */
public class FileTask extends RecursiveTask<JudgeCode> {

    private int start, end;
    public static int part;
    public static String suffix;
    public FileTask(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected JudgeCode compute() {
        if (end - start <= part) {
            String path = FileContainer.getInstance().getFile();
            while( path != null) {
                handle(path);
                path = FileContainer.getInstance().getFile();
            }
        } else {
            int middle = start + (end-start)/2;

            FileTask subTask1 = new FileTask(start, middle);
            FileTask subTask2 = new FileTask(middle, end);

            subTask1.fork();
            subTask2.fork();

            JudgeCode join = subTask1.join();
            JudgeCode join1 = subTask2.join();
        }
        // 分批处理结束条件
        return null;
    }
    private void handle(String path) {
        JudgeCode judgeCode = createJugeCode();
        try {
            judgeCode.judge(new File(path));
            GatherCodes.getInstance().addCommentCount(judgeCode.getCommentCount())
                    .addEffectiveCount(judgeCode.getEffectiveCount())
                    .addEmptyCount(judgeCode.getEmptyCount())
                    .addTotalCount(judgeCode.getTotalCount());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JudgeCode createJugeCode() {
        JudgeCode judgeCode;
        if (RubyJudgeCode.LANGUAGE.equalsIgnoreCase(suffix)) {
            judgeCode = new RubyJudgeCode();
        } else {
            judgeCode = new CPPJudgeCode();
        }
        return judgeCode;
    }
}
