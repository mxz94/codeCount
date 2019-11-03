package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;

public class IntermediateNextStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case CAREER_OPERATOR:
                return ParseMachine.intermediateStatus;
            default:
                return ParseMachine.normalStatus;
        }
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.COMMENT;
    }
}
