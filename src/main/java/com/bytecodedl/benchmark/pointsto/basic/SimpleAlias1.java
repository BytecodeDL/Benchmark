package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase SimpleAlias1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Direct alias
 */
public class SimpleAlias1 {

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.basic.SimpleAlias1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/0", var = "<com.bytecodedl.benchmark.pointsto.basic.SimpleAlias1: void main(java.lang.String[])>/b")
    public static void main(String[] args) {

        Benchmark.alloc(1);
        A a = new A();

        A b = a;
        Benchmark.test("b",
                "{allocId:1, mayAlias:[a,b], notMayAlias:[], mustAlias:[a,b], notMustAlias:[]}");
    }
}
