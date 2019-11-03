package com.mxz.parseMachine;

public interface IStatus {
    public abstract IStatus Transform(ParseMachine.Action action);
    public abstract ParseMachine.Type GetType();
}
