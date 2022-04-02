package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase ParameterAlias1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Aliasing through static method parameter
 */
public class Parameter1 {

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.basic.Parameter1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Parameter1: void test(com.bytecodedl.benchmark.pointsto.helper.A)>/b")
    public static void test(A x) {
        A b = x;
        Benchmark.test("b",
                "{allocId:1, mayAlias:[b,x], notMayAlias:[], mustAlias:[b,x], notMustAlias:[]}");
    }

    public static void main(String[] args) {

        Benchmark.alloc(1);
        A a = new A();
        test(a);
    }
}
