package com.mxz;

import com.mxz.common.FileContainer;
import com.mxz.common.PropertiesUtil;
import com.mxz.task.FileTask;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ForkJoinPool;

/**
 * @Description
 * @Date 2019/11/1 19:52
 * @Author mxz
 */
public class Engine {
    private static final Integer THREAD_NUM = Runtime.getRuntime().availableProcessors() * 2;

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0)
            return;
        prepare(args);

        int size = FileContainer.getInstance().getFiles().size();
        ForkJoinPool fjp = new ForkJoinPool();
        FileTask.part = size < THREAD_NUM ? 1 : size/THREAD_NUM;
        FileTask task = new FileTask(0, size);
        fjp.execute(task);
        task.join();

        GatherCodes gatherCodes = GatherCodes.getInstance();
        gatherCodes.setFileCount(size);
        gatherCodes.print();
    }

    private static void prepare(String[] args) {
        String suffix = "c++";
        Properties props = PropertiesUtil.loadProps("app.properties");
        if (args.length > 1) {
            suffix = props.getProperty(args[1]);
        }
        FileContainer.getInstance().handleFilePath(args[0], suffix != null ? suffix : "c++");
    }
}
