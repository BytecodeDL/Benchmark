package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Loops2
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description The analysis must support loop constructs. Allocation site in N
 */
public class Loops2 {

    public class N {
        public String value = "";
        public N next;

        public N() {
            Benchmark.alloc(2);
            next = new N();
        }
    }

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.basic.Loops2$N: void <init>(com.bytecodedl.benchmark.pointsto.basic.Loops2)>/new com.bytecodedl.benchmark.pointsto.basic.Loops2$N/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Loops2: void test()>/node")
    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.basic.Loops2: void test()>/new com.bytecodedl.benchmark.pointsto.basic.Loops2$N/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Loops2: void test()>/node")
    private void test() {
        Benchmark.alloc(1);
        N node = new N();

        int i = 0;
        while (i < 10) {
            node = node.next;
            i++;
        }

        N o = node.next;
        N p = node.next.next;
        Benchmark.test("node",
                "{allocId:1, mayAlias:[node], notMayAlias:[i,o,p], mustAlias:[node], notMustAlias:[p]},"
                        + "{allocId:2, mayAlias:[o], notMayAlias:[node], mustAlias:[o], notMustAlias:[p]}");
    }

    public static void main(String[] args) {
        Loops2 l1 = new Loops2();
        l1.test();
    }
}
