package com.bytecodedl.benchmark.demo;

public class VirtualCallDemo1 implements VirtualCallInterface1 {
    public VirtualCallInterface1 parent;
    public static void main(String[] args) {
        VirtualCallInterface1 vcall2 = new VirtualCallDemo2();
        VirtualCallDemo1 vcall1 = new VirtualCallDemo1(vcall2);
        VirtualCallInterface1 varParent = vcall1.getParent();
        varParent.foo();
    }

    public VirtualCallDemo1(VirtualCallInterface1 argParent){
        this.parent = argParent;
    }

    public VirtualCallInterface1 getParent() {
        return parent;
    }

    public void foo() {
        VirtualCallDemo1.target();
    }

    public static void target(){

    }
}
