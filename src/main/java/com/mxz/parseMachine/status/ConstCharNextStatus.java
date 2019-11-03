package com.mxz.parseMachine.status;

import com.mxz.parseMachine.IStatus;
import com.mxz.parseMachine.ParseMachine;

public class ConstCharNextStatus implements IStatus {
    @Override
    public IStatus Transform(ParseMachine.Action action) {
        return ParseMachine.constCharStatus;
    }

    @Override
    public ParseMachine.Type GetType() {
        return ParseMachine.Type.EFFECTIVE;
    }

    public String toString(){
        return "ConstCharNextStatus";
    }
}
