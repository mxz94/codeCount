package com.mxz.task;

import com.mxz.GatherCodes;
import com.mxz.common.FileContainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.concurrent.RecursiveTask;

/**
 * @Description
 * @Date 2019/11/2 11:01
 * @Author mxz
 */
public class FileTask extends RecursiveTask<JudgeCode> {

    private final Integer THREAD_NUM = Runtime.getRuntime().availableProcessors() * 2;
    int start, end;

    public FileTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected JudgeCode compute() {
        LinkedList<String> files = FileContainer.getInstance().getFiles();
        int size = files.size();
        if (end - start <= size/THREAD_NUM) {
            String path = FileContainer.getInstance().getFile();
            while( path != null) {
                handle(path);
                path = FileContainer.getInstance().getFile();
            }
        }
        int middle = start + (end-start)/2;

        FileTask subTask1 = new FileTask(start, middle);
        FileTask subTask2 = new FileTask(middle, end);

        subTask1.fork();
        subTask2.fork();

        JudgeCode join = subTask1.join();
        JudgeCode join1 = subTask2.join();
        // 分批处理结束条件
        return null;
    }

    private void handle(String path) {
        JudgeCode judgeCode = new JudgeCode();
        try {
            judgeCode.Judge(new File(path));
            GatherCodes.getInstance().addCommentCount(judgeCode.getCommentCount())
                    .addEffectiveCount(judgeCode.getEffectiveCount())
                    .addEmptyCount(judgeCode.getEmptyCount())
                    .addTotalCount(judgeCode.getTotalCount());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
