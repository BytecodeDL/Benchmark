package com.bytecodedl.benchmark.callgraph.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Describes a concrete method that is called (transitively) from the annotated method.
 * It does not mention the call site from which this call is triggered.
 *
 * @author Florian Kuebler
 */
@Retention(RUNTIME)
@Target({METHOD, CONSTRUCTOR})
@Repeatable(IndirectCalls.class)
public @interface IndirectCall {

    String name();

    int line() default -1;

    /**
     * Must be given in JVM binary notation (e.g. Ljava/lang/Object;)
     */
    String[] resolvedTargets() default {};

    /**
     * Must be given in JVM binary notation (e.g. Ljava/lang/Object;)
     */
    String[] prohibitedTargets() default {};

    Class<?> returnType() default Void.class;

    Class<?>[] parameterTypes() default {};

}
