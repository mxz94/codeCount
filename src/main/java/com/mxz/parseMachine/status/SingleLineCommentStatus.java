package com.mxz.parseMachine.status;


import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;

public class SingleLineCommentStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case LINE_CONTINUATION:
                return ParseMachine.singleLineCommentNextStatus;
            case CAREER_OPERATOR:
                return ParseMachine.startStatus;
            default:
                return ParseMachine.singleLineCommentStatus;
        }
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.COMMENT;
    }

    public String toString(){
        return "SingleLineCommentStatus";
    }
}
