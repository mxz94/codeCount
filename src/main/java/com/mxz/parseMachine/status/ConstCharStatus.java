package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;

public class ConstCharStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        switch (action){
            case TURN_OPERATOR:
                return ParseMachine.constCharNextStatus;
            case DOUBLE_QUOTATION:
                return ParseMachine.normalStatus;
            default:
                return ParseMachine.constCharStatus;
        }
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.EFFECTIVE;
    }

    public String toString(){
        return "ConstCharStatus";
    }
}
