package com.mxz.task.juge;

import com.mxz.parseMachine.ParseMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author mxz
 * @Date 2019/11/3 21:06
 **/
public class CPPJudgeCode extends JudgeCode {
    public static final String LANGUAGE = "c++";
    private ParseMachine parseMachine;
    public CPPJudgeCode() {
        parseMachine = new ParseMachine();
    }
    @Override
    public void judge(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file, "utf-8");
        boolean isEffect = false;    //标记是否是有效行
        boolean isComment = false;   //标记是否是注释行
        boolean isEmpty = true;      //标记是否是空行

        while (sc.hasNextLine()) {
            totalCount++;
            String line = sc.nextLine().trim();
            // 正常非注释状态
            if (line.equals("")) {
                emptyCount++;
            } else {
                isEffect = false;
                isComment = false;
                isEmpty = true;
                char[] temp = line.toCharArray();
                for (int i = 0; i < temp.length; i++) {
                    parseMachine.Parse(parseMachine.ParseAction(temp[i]));
                    if (parseMachine.GetStatus().GetType() == ParseMachine.Type.EFFECTIVE) {
                        isEffect = true;

                    } else if (parseMachine.GetStatus().GetType() == ParseMachine.Type.COMMENT) {
                        isComment = true;
                    }
                    //处理空行内有空格和水平制表符的情况
                    if(temp[i]!=' '&&temp[i]!='\t')
                        isEmpty = false;
                }
                //每行结尾加行尾换行符进行处理
                parseMachine.Parse(parseMachine.CareerOperatorAction());
                if (parseMachine.GetStatus().GetType() == ParseMachine.Type.EFFECTIVE) {
                    isEffect = true;
                } else if (parseMachine.GetStatus().GetType() == ParseMachine.Type.COMMENT) {
                    isComment = true;
                }
                if(isEffect){
                    effectiveCount++;
                }
                if(!isEffect && isComment){
                    commentCount++;
                }
                if(isEmpty)
                    emptyCount++;
            }
        }
    }
}
