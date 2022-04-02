package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Loops1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description The analysis must support loop constructs. No allocation site in N
 */
public class Loops1 {

    public class N {
        public String value = "";
        public N next;

        public N() {
            next = null;
        }
    }

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.basic.Loops1: void test()>/new com.bytecodedl.benchmark.pointsto.basic.Loops1$N/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Loops1: void test()>/node")
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
        N q = node.next.next.next;

        Benchmark
                .test("node",
                        "{allocId:1, mayAlias:[node], notMayAlias:[i,o,p,q], mustAlias:[node], notMustAlias:[i,o,p,q]}");
    }

    public static void main(String[] args) {
        Loops1 l1 = new Loops1();
        l1.test();
    }
}
