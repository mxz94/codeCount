package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;

public class SingleLineCommentNextStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case LINE_CONTINUATION:
                return ParseMachine.singleLineCommentNextStatus;
            default:
//                System.out.println("下一行还是注释行");
                return ParseMachine.singleLineCommentStatus;
        }
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.COMMENT;
    }

    public String toString(){
        return "SingleLineCommentNextStatus";
    }
}
