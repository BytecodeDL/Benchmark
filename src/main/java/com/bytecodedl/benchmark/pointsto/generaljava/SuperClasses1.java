package com.bytecodedl.benchmark.pointsto.generaljava;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;
import com.bytecodedl.benchmark.pointsto.helper.P;

/*
 * @testcase SuperClass1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias from method in super class
 */
public class SuperClasses1 {

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.generaljava.SuperClasses1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/1", var = "<com.bytecodedl.benchmark.pointsto.generaljava.SuperClasses1: void main(java.lang.String[])>/h")
    private static void main(String[] args) {
        Benchmark.alloc(1);
        A a = new A();
        A b = new A();

        P p = new P(a);
        p.alias(b);
        A h = p.getA();
        Benchmark.test("h",
                "{allocId:1, mayAlias:[h,b], notMayAlias:[a,p], mustAlias:[b,a], notMustAlias:[p]}");
        Benchmark.use(h);
    }

}
