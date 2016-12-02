package com.pacoworks.rxcurrying;

import java.lang.reflect.Proxy;
import java.util.Arrays;

class CompositeFunctionBuilder<T> {

    private final Object sourceFunction;

    private CompositeFunctionBuilder(Object sourceFunction) {
        this.sourceFunction = sourceFunction;
    }

    static <T> CompositeFunctionBuilder<T> compose(Object targetFunction) {
        return new CompositeFunctionBuilder<>(targetFunction);
    }

    T into(int times, Class<?> targetNestedFunctionType, Class<?>... extraTypes) {
        Class<?>[] types = new Class[times + extraTypes.length];
        Arrays.fill(types, targetNestedFunctionType);
        System.arraycopy(extraTypes, 0, types, times, extraTypes.length);
        return createProxy(types);
    }

    @SuppressWarnings("unchecked")
    private T createProxy(Class<?>[] targetNestedFunctionTypes) {
        final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return (T) Proxy.newProxyInstance(
            classLoader,  new Class<?>[] { targetNestedFunctionTypes[0] },
            invocationHandlerFor(targetNestedFunctionTypes, classLoader)
        );
    }

    @SuppressWarnings("unchecked")
    private CompositeFunctionInvocationHandler invocationHandlerFor(Class<?>[] targetNestedFunctionTypes, ClassLoader classLoader) {
        return new CompositeFunctionInvocationHandler(
            sourceFunction,
            classLoader,
            targetNestedFunctionTypes
        );
    }

}
