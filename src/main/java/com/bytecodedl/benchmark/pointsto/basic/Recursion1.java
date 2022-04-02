package com.bytecodedl.benchmark.pointsto.basic;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

/*
 * @testcase Recursion1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description The analysis must support recursion
 */
public class Recursion1 {

    public Recursion1() {}

    public class N {
        public String value;
        public N next;

        public N(String value) {
            this.value = value;
            next = null;
        }
    }

    public N recursive(int i, N m) {
        if (i < 10) {
            int j = i + 1;
            return recursive(j, m.next);
        }
        return m;
    }

    @PointsTo(heap="<com.bytecodedl.benchmark.pointsto.basic.Recursion1: void test()>/new com.bytecodedl.benchmark.pointsto.basic.Recursion1$N/0", var = "<com.bytecodedl.benchmark.pointsto.basic.Recursion1: void test()>/node")
    public void test() {
        Benchmark.alloc(1);
        N node = new N("");

        Recursion1 r1 = new Recursion1();
        N n = r1.recursive(0, node);

        N o = node.next;
        N p = node.next.next;
        N q = node.next.next.next;

        Benchmark.test("n",
                "{allocId:1, mayAlias:[n], notMayAlias:[o,p,q], mustAlias:[n], notMustAlias:[o,p,q]}");
    }

    public static void main(String[] args) {
        Recursion1 r1 = new Recursion1();
        r1.test();
    }
}
