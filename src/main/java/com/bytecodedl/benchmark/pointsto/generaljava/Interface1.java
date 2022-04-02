package com.bytecodedl.benchmark.pointsto.generaljava;

import com.bytecodedl.benchmark.pointsto.annotations.PointsTo;
import com.bytecodedl.benchmark.pointsto.helper.A;
import com.bytecodedl.benchmark.pointsto.helper.Benchmark;
import com.bytecodedl.benchmark.pointsto.helper.G;
import com.bytecodedl.benchmark.pointsto.helper.H;

/*
 * @testcase Interface1
 *
 * @version 1.0
 *
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 *
 * @description Alias from method in interface
 */
public class Interface1 {

    @PointsTo(heap = "<com.bytecodedl.benchmark.pointsto.generaljava.Interface1: void main(java.lang.String[])>/new com.bytecodedl.benchmark.pointsto.helper.A/1", var = "<com.bytecodedl.benchmark.pointsto.generaljava.Interface1: void main(java.lang.String[])>/c")
    public static void main(String[] args) {

        A a = new A();
        Benchmark.alloc(1);
        A b = new A();

        G g = new G();
        H h = new H();
        g.foo(a);
        A c = h.foo(b);

        Benchmark.test("c",
                "{allocId:1, mayAlias:[c,b], notMayAlias:[a,g,h], mustAlias:[c,b], notMustAlias:[a,g,h]}");

        Benchmark.use(c);
    }

}
