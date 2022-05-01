package com.bytecodedl.benchmark.demo;

public class ContextSensitiveDemo2 implements ContextSensitive{
    public static void main(String[] args) {
        ContextSensitiveDemo2 demo21 = new ContextSensitiveDemo2();
        ContextSensitiveDemo2 demo22 = new ContextSensitiveDemo2();
        ContextSensitive demoInterface1 = demo21.foo(demo21);
        ContextSensitive demoInterface2 = demo22.foo(demo22);
        demoInterface1.func();
        demoInterface2.func();
    }

    @Override
    public ContextSensitive foo(ContextSensitive arg) {
        ContextSensitive ret = getCS(arg);
        return ret;
    }

    public ContextSensitive getCS(ContextSensitive arg1){
        return arg1;
    }

    @Override
    public String func() {
        String ret2 = "ContextSensitiveDemo2";
        return ret2;
    }
}
