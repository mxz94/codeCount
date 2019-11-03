package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;


public class IntermediateStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case TURN_OPERATOR:
                return ParseMachine.singleLineCommentStatus;
            case ASTERISK:
                return ParseMachine.multiLineCommentStatus;
            case LINE_CONTINUATION:
                return ParseMachine.intermediateNextStatus;
            default:
                return ParseMachine.normalStatus;
        }
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.COMMENT;
    }

    public String toString(){
        return "IntermediateStatus";
    }
}
