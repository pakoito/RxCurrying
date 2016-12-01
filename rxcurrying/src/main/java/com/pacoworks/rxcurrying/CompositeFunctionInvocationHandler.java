package com.pacoworks.rxcurrying;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

class CompositeFunctionInvocationHandler<T> implements InvocationHandler {

    private final T sourceFunction;
    private final Method callMethod;
    private final Object[] arguments;
    private final int targetArgumentCount;
    private final ClassLoader classLoader;
    private final Class<?> targetNestedFunctionType;

    CompositeFunctionInvocationHandler(T sourceFunction, ClassLoader classLoader, Class<?> targetNestedFunctionType) {
        this.sourceFunction = sourceFunction;
        this.callMethod = sourceFunction.getClass().getMethods()[0];
        this.classLoader = classLoader;
        this.targetNestedFunctionType = targetNestedFunctionType;
        this.targetArgumentCount = callMethod.getParameters().length;
        this.arguments = new Object[0];
    }

    private CompositeFunctionInvocationHandler(CompositeFunctionInvocationHandler<T> original, Object[] arguments) {
        this.sourceFunction = original.sourceFunction;
        this.callMethod = original.callMethod;
        this.targetArgumentCount = original.targetArgumentCount;
        this.targetNestedFunctionType = original.targetNestedFunctionType;
        this.classLoader = original.classLoader;
        this.arguments = arguments;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object[] newArguments = targetNestedFunctionType.isInstance(args[0]) ? this.arguments : append(this.arguments, args[0]);
        if (newArguments.length == targetArgumentCount) {
            return callMethod.invoke(sourceFunction, newArguments);
        } else {
            return Proxy.newProxyInstance(
                classloader(),
                new Class<?>[] { targetNestedFunctionType},
                new CompositeFunctionInvocationHandler<>(this, newArguments)
            );
        }
    }

    private static Object[] append(Object[] head, Object tail) {
        Object[] result = Arrays.copyOf(head, head.length + 1);
        result[head.length] = tail;
        return result;
    }

    private ClassLoader classloader() {
        return classLoader;
    }

}
