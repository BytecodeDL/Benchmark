package com.bytecodedl.benchmark.pointsto.annotations;

import com.bytecodedl.benchmark.callgraph.annotations.DirectCall;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface PointsTos {
    PointsTo[] value();
}
