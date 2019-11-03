package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;

public class NormalStatus implements IStatus {

    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case TURN_OPERATOR:
                return ParseMachine.intermediateStatus;
            case DOUBLE_QUOTATION:
                return ParseMachine.constCharStatus;
            case CAREER_OPERATOR:
                return ParseMachine.startStatus;
            default:
                return ParseMachine.normalStatus;
        }
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.EFFECTIVE;
    }

    public String toString(){
        return "NormalStatus";
    }
}
