package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Branching1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Condition. a and b alias on one path, not on the other
 */
public class Branching1 {

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.basic.Branching1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Branching1: void main(java.lang.String[])>/a")
    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.basic.Branching1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/1", var = "<com.bytecodedl.benchmark.pointsto.basic.Branching1: void main(java.lang.String[])>/a")
    public static void main(String[] args) {
        int i = 0;

        Benchmark.alloc(1);
        A a = new A();
        Benchmark.alloc(2);
        A b = new A();

        if (i < 0)
            a = b;

        Benchmark.test("a",
                "{allocId:1, mayAlias:[a], notMayAlias:[i,b], mustAlias:[a], notMustAlias:[i,b]},"
                        + "{allocId:2, mayAlias:[a,b], notMayAlias:[i], mustAlias:[a], notMustAlias:[i,b]}");
    }
}
