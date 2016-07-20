package com.pascalwelsch.compositeandroid.core;

public abstract class CallFun4<R, T1, T2, T3, T4> extends NamedSuperCall {

    public CallFun4(final String methodName) {
        super(methodName);
    }

    public abstract R call(final T1 p1, final T2 p2, final T3 p3, final T4 p4);
}
