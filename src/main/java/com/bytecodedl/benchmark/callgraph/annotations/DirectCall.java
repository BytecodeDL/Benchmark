package com.bytecodedl.benchmark.callgraph.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Describes a method call at a specific call site and states which methods
 * the call must be resolved to.
 * Using this annotation implies that the call edges must be
 * directly available within the call graph from the specified call site. Therefore, this annoation
 * can be used to specify monomorphic or polymorphic method calls but are not suited to specify
 * indirect call targets, e.g., reflective call targets.
 * Furthermore, it is possible to exclude certain target methods.
 *
 *
 * @author Florian Kuebler
 * @author Michael Reif
 */
@Retention(RUNTIME)
@Target({METHOD, CONSTRUCTOR})
@Repeatable(DirectCalls.class)
public @interface DirectCall {

    String name();

    Class<?> returnType() default Void.class;

    Class<?>[] parameterTypes() default {};

    int line() default -1;

    /**
     * Must be given in JVM binary notation (e.g. Ljava/lang/Object;)
     */
    String[] resolvedTargets();

    /**
     * Must be given in JVM binary notation (e.g. Ljava/lang/Object;)
     */
    String[] prohibitedTargets() default {};
}
