package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;


public class MultiLineCommentEndNextStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case CAREER_OPERATOR:
                return ParseMachine.multiLineCommentEndStatus;
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
}
