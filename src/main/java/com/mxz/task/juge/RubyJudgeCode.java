package com.mxz.task.juge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author mxz
 * @Date 2019/11/3 21:06
 **/
public class RubyJudgeCode extends JudgeCode {
    public static final String LANGUAGE = "ruby";
    @Override
    public void judge(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file, "utf-8");
        boolean isComment = false;   //标记是否是注释行

        while (sc.hasNextLine()) {
            totalCount++;
            String line = sc.nextLine().trim();
            // 正常非注释状态
            if (line.equals("")) {
                emptyCount++;
            } else {
                isComment = false;
                if (line.startsWith("=begin"))
                   isComment = true;
                if (line.startsWith("=end")) {
                   commentCount ++;
                   isComment = false;
                }
                if (!isComment && line.startsWith("#"))
                   commentCount ++;
                if(!isComment)
                    effectiveCount++;
            }
        }
    }
}
