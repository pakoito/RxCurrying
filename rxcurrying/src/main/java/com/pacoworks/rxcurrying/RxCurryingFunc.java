/*
 * Copyright (c) pakoito 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxcurrying;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.Function;

/**
 * Helper class to curry FuncN objects
 *
 * @author pakoito
 */
public class RxCurryingFunc {

    private static final Class[] FUNC1_INTERFACES = new Class[]{Func1.class};

    private static class Func1InvocationHandler implements InvocationHandler {

        private final Function function;
        private final Method callMethod;
        private final Object[] arguments;
        private int argumentCount = 0;

        private Func1InvocationHandler(Function function) {
            this.function = function;
            this.callMethod = function.getClass().getMethods()[0];
            this.arguments = new Object[callMethod.getParameters().length];
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (args[0] instanceof Func1) {
                return Proxy.newProxyInstance(classloader(), FUNC1_INTERFACES, this);
            } else {
                arguments[argumentCount] = args[0];
                argumentCount++;
                if (argumentCount == arguments.length) {
                    return callMethod.invoke(function, arguments);
                } else {
                    return Proxy.newProxyInstance(classloader(), FUNC1_INTERFACES, this);
                }
            }
        }

    }

    private static ClassLoader classloader() {
        return ClassLoader.getSystemClassLoader();
    }

    protected RxCurryingFunc() {
    }

    public static <A, B, R> Func1<A, Func1<B, R>> curry(final Func2<A, B, R> func) {
        return proxyFunction(func);
    }

    public static <A, B, C, R> Func1<A, Func1<B, Func1<C, R>>> curry(final Func3<A, B, C, R> func) {
        return proxyFunction(func);
    }

    public static <A, B, C, D, R> Func1<A, Func1<B, Func1<C, Func1<D, R>>>> curry(final Func4<A, B, C, D, R> func) {
        return proxyFunction(func);
    }

    public static <A, B, C, D, E, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, R>>>>> curry(final Func5<A, B, C, D, E, R> func) {
        return proxyFunction(func);
    }

    public static <A, B, C, D, E, F, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, R>>>>>> curry(final Func6<A, B, C, D, E, F, R> func) {
        return proxyFunction(func);
    }

    public static <A, B, C, D, E, F, G, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>>>> curry(final Func7<A, B, C, D, E, F, G, R> func) {
        return proxyFunction(func);
    }

    public static <A, B, C, D, E, F, G, H, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>>>> curry(final Func8<A, B, C, D, E, F, G, H, R> func) {
        return proxyFunction(func);
    }

    public static <A, B, C, D, E, F, G, H, I, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>>>> curry(final Func9<A, B, C, D, E, F, G, H, I, R> func) {
        return proxyFunction(func);
    }

    @SuppressWarnings("unchecked")
    private static <T> T proxyFunction(Function func) {
        return (T) Proxy.newProxyInstance(classloader(), FUNC1_INTERFACES, new Func1InvocationHandler(func));
    }

}
