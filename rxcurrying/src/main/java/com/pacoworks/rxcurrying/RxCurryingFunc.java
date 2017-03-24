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

import java.lang.reflect.Method;

import rx.functions.Func0;
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

    private static final Method[] FUNC_CALL_METHODS = {
        Func0.class.getMethods()[0],
        Func1.class.getMethods()[0],
        Func2.class.getMethods()[0],
        Func3.class.getMethods()[0],
        Func4.class.getMethods()[0],
        Func5.class.getMethods()[0],
        Func6.class.getMethods()[0],
        Func7.class.getMethods()[0],
        Func8.class.getMethods()[0],
        Func9.class.getMethods()[0]
    };

    protected RxCurryingFunc() {
    }

    public static <A, B, R> Func1<A, Func1<B, R>> curry(final Func2<A, B, R> func) {
        return fuzzyFunction(func, 2);
    }

    public static <A, B, C, R> Func1<A, Func1<B, Func1<C, R>>> curry(final Func3<A, B, C, R> func) {
        return fuzzyFunction(func, 3);
    }

    public static <A, B, C, D, R> Func1<A, Func1<B, Func1<C, Func1<D, R>>>> curry(final Func4<A, B, C, D, R> func) {
        return fuzzyFunction(func, 4);
    }

    public static <A, B, C, D, E, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, R>>>>> curry(final Func5<A, B, C, D, E, R> func) {
        return fuzzyFunction(func, 5);
    }

    public static <A, B, C, D, E, F, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, R>>>>>> curry(final Func6<A, B, C, D, E, F, R> func) {
        return fuzzyFunction(func, 6);
    }

    public static <A, B, C, D, E, F, G, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>>>> curry(final Func7<A, B, C, D, E, F, G, R> func) {
        return fuzzyFunction(func, 7);
    }

    public static <A, B, C, D, E, F, G, H, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>>>> curry(final Func8<A, B, C, D, E, F, G, H, R> func) {
        return fuzzyFunction(func, 8);
    }

    public static <A, B, C, D, E, F, G, H, I, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>>>> curry(final Func9<A, B, C, D, E, F, G, H, I, R> func) {
        return fuzzyFunction(func, 9);
    }

    private static <T> ArgumentConsumer consumeFunction(final T func, final Method method) {
        return new ArgumentConsumer() {
            @Override
            public Object onArgumentsReady(Object[] a) {
                try {
                    return method.invoke(func, a);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    private static <T extends Func1, P extends Function> T fuzzyFunction(P finalFunction, int targetLevel) {
        return (T) new FuzzyFunction(targetLevel, consumeFunction(finalFunction, FUNC_CALL_METHODS[targetLevel]));
    }

}
