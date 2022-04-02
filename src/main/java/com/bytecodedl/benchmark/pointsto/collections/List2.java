package com.bytecodedl.benchmark.pointsto.collections;

import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;

import java.util.LinkedList;

/*
 * @testcase List2
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description LinkedList
 */
public class List2 {

    public static void main(String[] args) {

        LinkedList<A> list = new LinkedList<A>();
        A a = new A();
        Benchmark.alloc(1);
        A b = new A();
        list.add(a);
        list.add(b);
        A c = list.get(1);
        Benchmark
                .test("b",
                        "{allocId:1, mayAlias:[c,b], notMayAlias:[a,list], mustAlias:[c,b], notMustAlias:[a,list]}");
    }
}
