package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;

public class MultiLineCommentStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case ASTERISK:
                return ParseMachine.multiLineCommentEndStatus;
            default:
                return ParseMachine.multiLineCommentStatus;
        }
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.COMMENT;
    }

    public String toString(){
        return "MultiLineCommentStatus";
    }
}
