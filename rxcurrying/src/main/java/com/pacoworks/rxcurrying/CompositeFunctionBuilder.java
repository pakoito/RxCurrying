package com.pacoworks.rxcurrying;

import java.lang.reflect.Proxy;

class CompositeFunctionBuilder<T> {

    private final Object sourceFunction;

    private CompositeFunctionBuilder(Object sourceFunction) {
        this.sourceFunction = sourceFunction;
    }

    static <T> CompositeFunctionBuilder<T> compose(Object targetFunction) {
        return new CompositeFunctionBuilder<>(targetFunction);
    }

    T intoMany(Class<?> targetNestedFunctionType) {
        return createProxy(targetNestedFunctionType);
    }

    @SuppressWarnings("unchecked")
    private T createProxy(Class<?> targetNestedFunctionTypes) {
        final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return (T) Proxy.newProxyInstance(
            classLoader, new Class[] { targetNestedFunctionTypes },
            invocationHandlerFor(targetNestedFunctionTypes, classLoader)
        );
    }

    @SuppressWarnings("unchecked")
    private CompositeFunctionInvocationHandler invocationHandlerFor(Class<?> targetNestedFunctionTypes, ClassLoader classLoader) {
        return new CompositeFunctionInvocationHandler(
            sourceFunction,
            classLoader,
            targetNestedFunctionTypes
        );
    }

}
