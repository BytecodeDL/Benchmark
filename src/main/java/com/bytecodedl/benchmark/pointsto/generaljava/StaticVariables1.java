package com.bytecodedl.benchmark.pointsto.generaljava;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase StaticVariables1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias to a static variable, allocation site at the static variable site
 */
public class StaticVariables1 {

    private static A a;

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.generaljava.StaticVariables1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/0", var = "<com.bytecodedl.benchmark.pointsto.generaljava.StaticVariables1: void main(java.lang.String[])>/b")
    public static void main(String[] args) {
        Benchmark.alloc(1);
        a = new A();
        A b = a;
        A c = a;
        Benchmark.test("b",
                "{allocId:1, mayAlias:[b,c], notMayAlias:[], mustAlias:[b,c], notMustAlias:[]}");
    }
}
