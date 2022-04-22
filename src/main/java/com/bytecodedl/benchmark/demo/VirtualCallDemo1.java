package com.bytecodedl.benchmark.demo;

public class VirtualCallDemo1 implements VirtualCallInterface1 {
    public VirtualCallInterface1 parent;
    public static void main(String[] args) {
        VirtualCallInterface1 vcall2 = new VirtualCallDemo2();
        VirtualCallDemo1 vcall1 = new VirtualCallDemo1(vcall2);
        VirtualCallInterface1 varParent = vcall1.getParent();
        String source = vcall1.source();
        varParent.foo(source);
    }

    public VirtualCallDemo1(VirtualCallInterface1 argParent){
        this.parent = argParent;
    }

    public VirtualCallInterface1 getParent() {
        return parent;
    }

    public void foo(String fooArg) {
        VirtualCallDemo1.target(fooArg);
    }

    public static void target(String targetArg){

    }

    public String source(){
        return "source";
    }
}
